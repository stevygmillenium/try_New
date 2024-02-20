package enc_dec;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Save_info_adv {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
		// TODO Auto-generated method stub
		String data;
		data=enc("blah!", "ofui!(#+4285rpuj%($'0171");
		System.out.println(data);
		File file=new File("e_data.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		writer.write(Base64.getEncoder().encodeToString(data.getBytes()));
		writer.flush();
		writer.close();
		FileReader reader=new FileReader(file);
		char[]cont=new char[(int) file.length()];
		reader.read(cont);
		reader.close();
		data=new String(cont);
		System.out.println(data);
		System.out.println(new String(Base64.getDecoder().decode(data)));
		System.out.println(dec(new String(Base64.getDecoder().decode(data)), "ofui!(#+4285rpuj%($'0171"));
	}
	public static String enc(String data,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[]b_key=key.getBytes(),e_data;
		Cipher cp =Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
		SecretKeySpec sks=new SecretKeySpec(b_key, "TripleDES");
		IvParameterSpec ips=new IvParameterSpec("ofui!(#+".getBytes());
		cp.init(Cipher.ENCRYPT_MODE, sks, ips);
		e_data=cp.doFinal(data.getBytes());
		return new String(e_data);
	}
	public static String dec(String data,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[]b_key=key.getBytes(),d_data;
		Cipher cp =Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
		SecretKeySpec sks=new SecretKeySpec(b_key, "TripleDES");
		IvParameterSpec ips=new IvParameterSpec("ofui!(#+".getBytes());
		cp.init(Cipher.DECRYPT_MODE, sks, ips);
		d_data=cp.doFinal(data.getBytes());
		return new String(d_data);
	}

}
