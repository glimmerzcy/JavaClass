package edu.tju.wordsFrequency;

import java.io.File;

public abstract class AbstractWordsFrequencyCounter {
	// ��ָ���ļ��е����е��ʼ��뵽����Ƶ�ʼ�������
	public abstract void addFile(File inputFile) throws Exception;
	// ��Ƶ�ʼ������Ľ�������ָ���ļ�(��Ƶ�ʵݼ���˳��)
	public abstract void output(File outputFile) throws Exception;
	
}
