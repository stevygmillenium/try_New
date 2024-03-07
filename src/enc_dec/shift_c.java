package enc_dec;

public class shift_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="blah",conv_data;
		conv_data=enc(data);
		System.out.println(conv_data);
		System.out.println(dec(conv_data));
	}
	public static String enc(String data) {
		char[]dec_data=data.toCharArray(),conv=new char[dec_data.length];
		int i = 0;
		for(char c:dec_data) {
			conv[i]=(char) (c+3);
			i++;
		}
		return new String(conv);
	}
	public static String dec(String data) {
		char[]enc_data=data.toCharArray(),conv=new char[enc_data.length];
		int i = 0;
		for(char c:enc_data) {
			conv[i]=(char) (c-3);
			i++;
		}
		return new String(conv);
	}

}
