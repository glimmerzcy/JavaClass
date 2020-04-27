package edu.tju.wordsFrequency;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map.Entry;

public class CounterReadFileByScanner extends AbstractWordsFrequencyCounter {
	
	private WordsCounter cnt;
	
	public CounterReadFileByScanner() {
		this.cnt = new WordsCounter();
	}
	
	@Override
	public void addFile(File inputFile) throws Exception {
		if (!inputFile.exists()) {
			throw new Exception("File not found");
		}
		if (!inputFile.canRead()) {
			throw new Exception("File can't read");
		}
		
		Scanner input = new Scanner(inputFile);
		while (input.hasNext()) {
			String word = input.next();
			cnt.add(word);
		}
		input.close();
	}

	@Override
	public void output(File outputFile) throws Exception {
		try {
			outputFile.createNewFile();
		} catch (Exception e) {
			throw new Exception("Fail to create output file");
		}
		if (!outputFile.canWrite()) {
			throw new Exception("File can't write");
		}
		
		PrintWriter output = new PrintWriter(outputFile);
		for (Entry<String, Integer> entry: cnt.getSortedList()) {
			output.write(entry.getKey() + " \t" + entry.getValue() + "\r\n");
		}
		output.close();
	}
	
}
