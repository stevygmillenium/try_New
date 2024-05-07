package mod;

public class check_digit_adv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num="";		
		System.out.println(g_c_digit(num));
	}
	public static int g_c_digit(String num) {
		char[]ch=num.toCharArray();
		int val[]=new int[ch.length],i = 0,tot = 0,c_d,n;
		for(char c:ch) {
			n=Integer.valueOf(String.valueOf(c));
			if(n%2==0) {
				n*=3;
			}
			else {
				n*=2;
			}
			val[i]=n;
			i++;
		}
		for(i=0;i<val.length;i++) {
			tot+=val[i];
		}
		c_d=tot%10;
		return c_d;
	}

}
