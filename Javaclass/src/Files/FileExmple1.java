package Files;

import java.io.File;

public class FileExmple1 {
	public static void main(String[] args) {
		File file=new File("C:/Users/DELL/eclipse-workspace/Javaclass");
		System.out.println("File Name"+file.getName());
		System.out.println("File path"+file.getPath());
		System.out.println("parent Directory"+file.getParent());
	}

}
