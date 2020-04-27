package edu.tju.countStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountStrings {

	public static void main(String[] args) {
		Map<String, Integer> cnt = new HashMap<String, Integer>();
		for (String s: args) {
			Integer num = cnt.get(s);
			if (num == null) {
				cnt.put(s, 1);
			}
			else {
				cnt.put(s, num + 1);
			}
		}
		for (Entry<String, Integer> entry: cnt.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

}
