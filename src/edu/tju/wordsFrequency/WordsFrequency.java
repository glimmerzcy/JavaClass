package edu.tju.wordsFrequency;

import java.io.File;

public class WordsFrequency {

	public static void main(String[] args) {
		File inputFile = new File("�˲���ĸǴı�Ӣ��.txt");
		
		File outputFile = new File("output.txt");
		
//		AbstractWordsFrequencyCounter counter = new CounterReadFileByScanner();
		AbstractWordsFrequencyCounter counter = new CounterReadByBufferedReader();
		
		try {
			counter.addFile(inputFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try {
			counter.output(outputFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("Count words frequency successfully by " + counter.getClass());
	}
}
