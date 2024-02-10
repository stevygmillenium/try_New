package sum_Avg;

public class try_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("try sum!");
		int[]a= {300,500};
		float[]b=new float[10];
		for(int i=0;i<b.length;i++) {
			b[i]=(float) Math.random()*(a[1]-a[0])+a[0];
		}
		float sum=0;
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
			sum+=b[i];
		}
		System.out.println("The sum is:"+sum);
	}

}
