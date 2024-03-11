package enc_dec;

public class shift_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="blah",conv_data;
		conv_data=enc(data);
		System.out.println(conv_data);
		System.out.println(dec(conv_data));
		conv_data=enc_dec(data, true);
		System.out.println(conv_data);
		System.out.println(enc_dec(conv_data, false));
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
	public static String enc_dec(String data,boolean enc) {
		char[]c_data,conv;
		String s_out = null,s_in,rev;
		StringBuilder sb;
		int i = 0;
		if(enc==true) {
			c_data=data.toCharArray();
			conv=new char[c_data.length];
			for(char c:c_data) {
				conv[i]=(char) (c+1);
				i++;
			}
			sb=new StringBuilder(new String(conv));
			rev=sb.reverse().toString();
			s_out=rev;
		}
		else if(enc==false) {
			s_in=data;
			sb=new StringBuilder(s_in);
			rev=sb.reverse().toString();
			conv=rev.toCharArray();
			c_data=new char[conv.length];
			for(char c:conv) {
				c_data[i]=(char) (c-1);
				i++;
			}
			s_out=new String(c_data);
		}
		else {}
		return s_out;
	}

}
