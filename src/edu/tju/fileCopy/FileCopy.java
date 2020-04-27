package edu.tju.fileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileCopy {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			String inputLine = input.nextLine();
			String inputString[] = inputLine.trim().split("\\s+");
			String command = inputString[0];
			switch (command) {
			case "":
				break;
			case "cp": 
				try {
					handleCopy(inputString);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				input.close();
				System.exit(0);
			default : System.out.println(command + ": command not found");
			}
		}
	}
	
	public static void handleCopy(String[] input) throws Exception {
		switch (input.length) {
		case 1: throw new Exception("cp: missing file operand");
		case 2: throw new Exception("cp: missing destination folder operand after " + "'" + input[1] + "'");
		case 3: 
			copyFile(new File(input[1]), new File(input[2]));
			break;
		default: throw new Exception("cd: too many arguments");
		}
	}
	
	public static void copyFile(File source, File target) throws Exception {
        // 判断源文件是否存在，是否是 File
		if (!source.exists() || !source.isFile()) {
			throw new Exception("cp: cannot stat '" + source.getPath() 
                                + "': No such file");
		}
		// 判断目标目录是否存在，是否是 Diectory
        if (!target.exists() || !target.isDirectory()) {
			throw new Exception("cp: cannot stat '" + target.getPath() 
                                + "': No such directory");
		}
		
		target = new File(target.getPath() + File.separator + source.getName());
		
        // 若源与目标相同，不做处理
		if (target.getCanonicalPath().equals(source.getCanonicalPath())) {
			return;
		}
		
		target.createNewFile();
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(target);
			byte[] buf = new byte[1024];
			int bytes;
			while ((bytes = input.read(buf)) != -1) {
				output.write(buf, 0, bytes);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			throw new Exception("cp: fail");
		} finally {
			input.close();
			output.close();
		}
	}
}
