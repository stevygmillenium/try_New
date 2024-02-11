package dB;
import java.io.*;

public class Person implements Data{
	public String name="";
	public String email="";
	Person(String name,String email){
		this.name=name;
		this.email=email;
	}
	@Override
	public void writefile() throws IOException {
		// TODO Auto-generated method stub
		File file=new File("data.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		writer.write(name);
		writer.write(" "+email);
		writer.write("\n");
		writer.flush();
		writer.close();
	}
	@Override
	public void appendfile() throws IOException {
		// TODO Auto-generated method stub
		File file=new File("data.txt");
		FileWriter writer=new FileWriter(file,true);
		writer.write(name);
		writer.write(" "+email);
		writer.write("\n");
		writer.flush();
		writer.close();
	}
}
