package sum_Avg;

public class try_Avg_adv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a= {300,500};
		float[]b=new float[10];
		for(int i=0;i<b.length;i++) {
			b[i]=(float) Math.random()*(a[1]-a[0])+a[0];
		}
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		System.out.println("The sum is:"+sum(b));
		System.out.println("The average is:"+avg(b));
	}
	public static float sum(float[]c) {
		int i=0;
		float sum=0;
		do {
			sum+=c[i];
			i++;
		}
		while(i<c.length);
		return sum;
		}
	public static float avg(float[]c) {
		int i=0;
		float sum=0,avg;
		while(i<c.length) {
			sum+=c[i];
			i++;
		}
		avg=sum/c.length;
		return avg;
		}

}
