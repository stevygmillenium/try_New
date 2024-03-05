package Random;

import java.util.Arrays;
import java.util.Random;

public class check_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float nums[]=new float[2*5];
		int min = 0,max = 0,i = 0;
		if(args.length==2) {
			min=Integer.parseInt(args[0]);
			max=Integer.parseInt(args[1]);
		}
		else {
			min=82100;
			max=96148;
		}
		do {
			nums[i]=(float) (Math.random()*(max-min)+min);
			i++;
		}
		while(i<nums.length);
		System.out.println(Arrays.toString(nums));
		System.out.println("amt:"+rand_sal(nums));
	}
	public static float rand_sal(float nums[]) {
		float num = 0;
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Random rnd=new Random();
		float mid=(nums[0]+nums[9])/2;
		System.out.println("mid:"+mid);
		while(num<mid) {
			num=nums[rnd.nextInt(nums.length)];
		}
		System.out.println("num:"+num);
		return (float) (num*(1+Math.random()));
	}

}
