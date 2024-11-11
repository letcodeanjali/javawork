import java.io.FileReader;
import java.util.Properties;
public class A {
	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("log properties");
		Properties p=new Properties();
		p.load(fr);
		System.out.println("username");
		System.out.println("password");
		
	}

}
