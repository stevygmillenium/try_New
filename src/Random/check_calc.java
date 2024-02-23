package Random;

public class check_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=931322;
		float min,max,mid;
		min=(float) (num*2.5);
		max=(min/2)*3;
		System.out.println(min+" "+max);
		mid=(min+max)/2;
		System.out.println(mid);
		//System.out.println(check_Range(min, max));
		float amt=check_Range(min, max);
		System.out.println(amt);
		System.out.println(sf_hyp(amt));
	}
	public static float check_Range(float min,float max) {
		float num=(float) (Math.random()*(max-min)+min);
		System.out.println(num);
		char ch=String.valueOf(num).charAt(0);
		int div=Integer.valueOf(String.valueOf(ch));
		return num/div;
	}
	public static float sf_hyp(float num) {
		float sx,ft,hyp;
		ft=(float) (num*.432);
		sx=num-ft;
		hyp=(float) Math.sqrt(Math.pow(ft, 2)+Math.pow(sx, 2));
		return hyp;
	}

}
