package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReader {
	public static void main(String[] args) {
		File file=new File("C:/Users/DELL/eclipse-workspace/Javaclass");
		try {
		
		FileReader fr = new FileReader(file);
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		

}
}
