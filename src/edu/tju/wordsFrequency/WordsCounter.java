package edu.tju.wordsFrequency;

import java.util.*;
import java.util.Map.Entry;

public class WordsCounter {
	Map<String, Integer> cnt;
	
	WordsCounter() {
		this.cnt = new HashMap<String, Integer>();
		
	}
	
	void add(String s) {
		Integer num = cnt.get(s);
		if (num == null) {
			cnt.put(s, 1);
		}
		else {
			cnt.put(s, num + 1);
		}
	}
	
	List<Entry<String, Integer>> getSortedList() {
		List<Entry<String, Integer>> arr = new ArrayList<Entry<String, Integer>>();
		for (Entry<String, Integer> entry: cnt.entrySet()) {
			arr.add(entry);
		}
		arr.sort(new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return -Integer.compare(o1.getValue(), o2.getValue());
			}
		});
		return arr;
	}
}
