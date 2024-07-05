package Random;

public class tri_check_adv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min=(int) tri_check.gen_num(0, 0);
		System.out.println(min);
		float max=(float) tri_check.gen_num(0, 0),mid=(min+max)/2;
		System.out.println(max);
		System.out.println("mid:"+mid);
		Object[] res=tri_check(min, max);
		System.out.print(res[0]+" "+res[1]+" "+res[2]);
	}
	public static Object[] tri_check(int min,float max) {
		double x,y;
		x=-1*(Math.log(min)/Math.log(max));
		y=1/(Math.pow(max, x));
		boolean are_eq=min==(int)y;
		Object[] res= {x,y,are_eq};
		return res;
	}

}
