package Random;
import java.util.*;

public class alpha_Num_adv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,count=0;
		char[]alpha_b=new char[12+14],sp_c=new char[3*5],num=new char[10],passwl=new char[4],passwc=new char[passwl.length],passwn=new char[passwc.length];
		for(i=0;i<alpha_b.length;i++) {
			alpha_b[i]=(char) (97+i);
		}
		for(i=0;i<sp_c.length;i++) {
			sp_c[i]=(char) (33+i);
		}
		for(i=0;i<num.length;i++) {
			num[i]=(char) (48+i);
		}
		System.out.print(alpha_b);
		System.out.print(sp_c);
		System.out.print(num);
		Random rnd=new Random();
		char[]password=new char[passwl.length+passwc.length+num.length];
		i=0;
		do {
			passwl[i]=alpha_b[rnd.nextInt(alpha_b.length)];
			password[count]=passwl[i];
			i++;
			count++;
		}
		while(i<passwl.length);
		i=0;
		while(i<passwc.length) {
			passwc[i]=sp_c[rnd.nextInt(sp_c.length)];
			password[count]=passwc[i];
			i++;
			count++;
		}
		for(i=0;i<passwn.length;i++) {
			passwn[i]=num[rnd.nextInt(num.length)];
			password[count]=passwn[i];
			count++;
		}
		System.out.println();
		System.out.print(password);
	}

}
