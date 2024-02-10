package sum_Avg;

public class try_Avg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("try avg!");
		int[]a= {300,500};
		float[]b=new float[10];
		int i;
		i=0;
		do {
			b[i]=(float) Math.random()*(a[1]-a[0])+a[0];
			i++;
		}
		while(i<b.length);
		i=0;
		float sum=0,avg;
		while(i<b.length) {
			System.out.println(b[i]);
			sum+=b[i];
			i++;
		}
		System.out.println("The sum is:"+sum);
		avg=sum/b.length;
		System.out.println("The average is:"+avg);
	}

}
