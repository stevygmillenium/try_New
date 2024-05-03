package mod;

public class check_code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code="";
		char[]ch=code.substring(0, 4).toCharArray();
		int m_val[]=new int[ch.length],i = 0;
		for(char c:ch) {
			m_val[i]=c%10;
			i++;
		}
		StringBuilder sb=new StringBuilder();
		for(i=0;i<ch.length;i++) {
			sb.append(m_val[i]);
		}
		String[]c_pat= {"3053","2961"};
		if(sb.toString().equals(c_pat[0])) {
			System.out.println("basic");
		}
		else if(sb.toString().equals(c_pat[1])) {
			System.out.println("pro");
		}
		else {
			System.out.println("invalid combination!");
		}
	}

}
