package Random;

public class tri_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min=(int) gen_num(0, 0);
		System.out.println(min);
		float max=(float) gen_num(0, 0),mid=(min+max)/2;
		System.out.println(max);
		System.out.println("mid:"+mid);
		double num=gen_num(min, max);
		boolean gtet=num>=mid;
		System.out.println("num:"+num+" "+gtet);
		System.out.print("amt:"+num*(1+Math.random()));
	}	
	public static double gen_num(int min,float max){
		return Math.random()*(max-min)+min;
	}
}
