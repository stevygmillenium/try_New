package Random;

import java.util.Arrays;
import java.util.Random;

public class card_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,c_len;
		int[]card_len= new int[4+3],c_d= {0,0};		
		for(i=0;i<card_len.length;i++) {
			card_len[i]=(4*3)+i;
		}
		System.out.println(Arrays.toString(card_len));
		Random rnd = new Random();
		c_len=card_len[rnd.nextInt(card_len.length)];
		System.out.println(c_len);
		int[] num=new int[2*5],card_num=new int[c_len];
		for(i=0;i<num.length;i++) {
			num[i]=i;
		}		
		StringBuilder sb=new StringBuilder();
		for(i=0;i<card_num.length;i++) {
			card_num[i]=num[rnd.nextInt(num.length)];
		}
		for(i=0;i<card_num.length;i++) {
			sb.append(card_num[i]);
		}
		System.out.println(sb);
		c_d[0]=mod.check_digit_adv.g_c_digit(sb.toString());
		c_d[1]=mod.check_digit_xt.g_c_digit(sb.toString());
		boolean are_eq=c_d[0]==c_d[1];
		System.out.println(c_d[0]+" "+c_d[1]+" "+are_eq);
	}

}
