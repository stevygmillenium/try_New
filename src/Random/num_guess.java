package Random;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class num_guess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a= {300,500};
		float[]b=new float[5-2];
		for(int i=0;i<b.length;i++) {
			b[i]=(float) Math.random()*(a[1]-a[0])+a[0];
		}
		System.out.println(Arrays.toString(b));
		Random rnd=new Random();
		float c=b[rnd.nextInt(b.length)],tot=sum_Avg.try_Avg_adv.sum(b);
		Scanner sc=new Scanner(System.in);
		String num;
		System.out.println("Try to guess the selected number.");
		do {
			System.out.println("Total amount left:"+tot);
			num=sc.next();
			if(Float.valueOf(num)==c) {
				System.out.println("Number guessed!");
				break;
			}
			else {
				tot-=c;
				if(tot<=0) {
					break;
				}
				else {
					System.out.println("Try again.");
				}
			}
		}
		while(true);
		System.out.println("Thanks for playing!!");
		while(true) {
			float d=b[rnd.nextInt(b.length)];
			System.out.println(d);
			if(c==d) {
				break;
			}
			else {}
		}
		System.out.println(sum_Avg.try_Avg_adv.avg(b));
	}

}
