package enc_dec;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save_info_xt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String data;
		File file;
		FileReader reader;
		char[]cont;
		file=new File("data.txt");
		reader=new FileReader(file);
		cont=new char[(int) file.length()];
		reader.read(cont);
		reader.close();
		data=new String(cont);
		System.out.println(data);
		file=new File("e_data.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		writer.write(shift_c.enc_dec_xt(data, "ofui!(#+4285rpuj%($'0171", true));
		writer.flush();
		writer.close();		
		reader=new FileReader(file);
		cont=new char[(int) file.length()];
		reader.read(cont);
		reader.close();
		data=new String(cont);
		System.out.println(shift_c.enc_dec_xt(data, "ofui!(#+4285rpuj%($'0171", false));
	}

}
