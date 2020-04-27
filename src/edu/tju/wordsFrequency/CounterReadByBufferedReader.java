package edu.tju.wordsFrequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

public class CounterReadByBufferedReader extends AbstractWordsFrequencyCounter {
	
	private WordsCounter cnt;
	
	public CounterReadByBufferedReader() {
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
		
		WordsCounter cnt = new WordsCounter();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(inputFile));
			String sentence;
			while ((sentence = input.readLine()) != null) {
				String[] words = sentence.trim().split("\\s+");
				for (String word: words) {
					cnt.add(word);
				}
			}
		} catch (IOException e) {
			throw new Exception("I/O error occurs");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					throw new Exception("I/O error occurs");
				}
			}
		}

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
