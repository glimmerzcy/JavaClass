package edu.tju.wordsFrequency;

import java.io.File;

public abstract class AbstractWordsFrequencyCounter {
	// 将指定文件中的所有单词加入到单词频率计数器中
	public abstract void addFile(File inputFile) throws Exception;
	// 将频率计数器的结果输出到指定文件(按频率递减的顺序)
	public abstract void output(File outputFile) throws Exception;
	
}
