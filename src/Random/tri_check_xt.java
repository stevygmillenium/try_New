package Random;

public class tri_check_xt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min=(int) tri_check.gen_num(0, 0);
		System.out.println(min);
		float max=(float) tri_check.gen_num(0, 0),mid=(min+max)/2;
		System.out.println(max);
		System.out.println("mid:"+mid);
		Object[]res=tri_check(min, max);
		double y[]=(double[]) res[1];
		System.out.println(res[0]+" "+y[0]);
		System.out.print(y[1]+" "+res[2]);
	}
	public static Object[] tri_check(int min,float max) {
		double x,y[]= {0,0},z;
		x=Math.pow(min, 2)*max;
		y[0]=Math.sqrt(x/max);
		z=Math.pow(min, 2)/max;
		y[1]=Math.sqrt(max*z);
		Object[]res= {x,y,z};
		return res;
	}

}
