package mod;

public class check_digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num="";
		char[]ch=num.toCharArray();
		int val[]=new int[ch.length],i = 0,tot = 0,c_d;
		for(char c:ch) {
			val[i]=Integer.valueOf(String.valueOf(c));
			i++;
		}
		for(i=0;i<val.length;i++) {
			tot+=val[i];
		}
		c_d=tot%(2*5);
		System.out.println(new String(ch)+c_d);
	}

}
