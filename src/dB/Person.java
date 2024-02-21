package dB;
import java.io.*;

public class Person implements Data{
	public String name="";
	public String email="";
	public Per_type p_type=null;
	Person(String name,String email,Per_type p_type){
		this.name=name;
		this.email=email;
		this.p_type=p_type;
	}
	@Override
	public void writefile() throws IOException {
		// TODO Auto-generated method stub
		File file=new File("data.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		writer.write(name);
		writer.write(","+email);
		writer.write(","+p_type);
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
		writer.write(","+email);
		writer.write(","+p_type);
		writer.write("\n");
		writer.flush();
		writer.close();
	}
}
