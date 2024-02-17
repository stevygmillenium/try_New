package enc_dec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Convert_data {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		byte[]e_data=enc("blah!","ofui!(#+4285HJKL");
		System.out.println(new String(e_data));
		System.out.println(dec(e_data,"ofui!(#+4285HJKL"));
	}
	public static byte[]enc(String data,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		byte[]b_key=key.getBytes(),e_data;
		Cipher cp =Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKey sk=new SecretKeySpec(b_key,"AES");
		cp.init(Cipher.ENCRYPT_MODE, sk);
		e_data=cp.doFinal(data.getBytes());
		return e_data;
	}
	public static String dec(byte[]e_data,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[]b_key=key.getBytes(),d_data;
		Cipher cp =Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKey sk=new SecretKeySpec(b_key,"AES");
		cp.init(Cipher.DECRYPT_MODE, sk);
		d_data=cp.doFinal(e_data);
		return new String(d_data);
	}

}
