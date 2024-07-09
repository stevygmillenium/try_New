package Random;

public class tri_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min,max;
		if(args.length==2) {
			min=Integer.parseInt(args[0]);
			max=Integer.parseInt(args[1]);
		}
		else {
			min=82100;
			max=96148;
		}
		double x,y[]= {0,0},z = 0,a,b = 0,c = 0;
		x=max-min;
		y[0]=Math.random();
		y[1]=Math.random();
		System.out.println(y[0]+" "+y[1]);
		if(y[0]<y[1]) {
			z=y[1]-y[0];
		}
		else if(y[0]>y[1]) {
			z=y[0]-y[1];
		}
		else {}
		a=x/z;
		System.out.println(a);
		if(y[0]<y[1]) {
			b=(a*y[0])+max;
			c=(a*y[1])+min;
		}
		else if(y[0]>y[1]) {
			b=(a*y[0])+min;
			c=(a*y[1])+max;
		}
		else {}
		boolean are_eq=b==c;
		System.out.print(b+" "+c+" "+are_eq);
	}

}
