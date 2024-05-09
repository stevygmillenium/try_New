package mod;

public class check_digit_xt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num="";				
		System.out.println(g_c_digit(num));
	}
	public static int g_c_digit(String num) {//luhn's alg
		char[]ch=num.toCharArray();
		int val[]=new int[ch.length],i = 0,tot = 0,c_d;
		for(char c:ch) {
			val[i]=Integer.valueOf(String.valueOf(c));
			i++;
		}
		if(val.length==13||val.length==15||val.length==17) {
			for(i=0;i<val.length;i+=2) {
				val[i]*=2;
			}
		}
		else if(val.length==12||val.length==14||val.length==16||val.length==18) {
			for(i=1;i<val.length;i+=2) {
				val[i]*=2;
			}
		}
		else {}		
		StringBuilder sb=new StringBuilder();
		for(i=0;i<val.length;i++) {
			sb.append(val[i]);
		}
		System.out.println(sb);
		for(char c:sb.toString().toCharArray()) {
			tot+=Integer.valueOf(String.valueOf(c));
		}
		if((tot%10)!=0) {			
			c_d=10-(tot%10);
		}
		else {
			c_d=tot%10;
		}
		return c_d;
	}

}
