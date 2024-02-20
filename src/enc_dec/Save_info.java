package enc_dec;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Save_info {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
		// TODO Auto-generated method stub
		byte[]e_data=enc("blah!","ofui!(#+");
		String data;
		data=Base64.getEncoder().encodeToString(e_data);
		System.out.println(new String(e_data)+" "+data);
		File file=new File("e_data.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		writer.write(data);
		writer.flush();
		writer.close();
		FileReader reader=new FileReader(file);
		char[]cont=new char[(int) file.length()];
		reader.read(cont);
		reader.close();
		data=new String(cont);
		System.out.println(data);
		//System.out.println(dec(e_data,"ofui!(#+"));
		System.out.println(dec(Base64.getDecoder().decode(data), "ofui!(#+"));

	}
	public static byte[]enc(String data,String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException{
		byte[]b_key=key.getBytes(),e_data;
		DESKeySpec kspec=new DESKeySpec(b_key);
		Cipher cp =Cipher.getInstance("DES/ECB/PKCS5Padding");
		SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
		SecretKey sk=skf.generateSecret(kspec);
		cp.init(Cipher.ENCRYPT_MODE, sk);
		e_data=cp.doFinal(data.getBytes());
		return e_data;
	}
	public static String dec(byte[]e_data,String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		byte[]b_key=key.getBytes(),d_data;
		DESKeySpec kspec=new DESKeySpec(b_key);
		Cipher cp =Cipher.getInstance("DES/ECB/PKCS5Padding");
		SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
		SecretKey sk=skf.generateSecret(kspec);
		cp.init(Cipher.DECRYPT_MODE, sk);
		d_data=cp.doFinal(e_data);
		return new String(d_data);
	}

}
