package sum_Avg;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;

public class try_Avg_frm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int[]a= {300,500};
	float[]b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try_Avg_frm frame = new try_Avg_frm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public try_Avg_frm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnsumButton = new JButton("sum");
		panel.add(btnsumButton);
		
		JButton btnavgButton = new JButton("average");
		panel.add(btnavgButton);
		
		JRadioButton rdbtnrndRadioButton = new JRadioButton("random");
		panel.add(rdbtnrndRadioButton);
		
		JCheckBox chckbxsrtCheckBox = new JCheckBox("sort");
		panel.add(chckbxsrtCheckBox);
		
		JLabel lblresLabel = new JLabel("value");
		panel.add(lblresLabel);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JList list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		
		btnsumButton.addActionListener((event)->{
			if(b==null) {
				String line=textField.getText();
				String nums[]=line.split(",");
				b=new float[nums.length];
				int i = 0;
				do {
					b[i]=Float.valueOf(nums[i]);
					i++;
				}
				while(i<b.length);
			}
			lblresLabel.setText(String.valueOf(try_Avg_adv.sum(b)));			
		});
		btnavgButton.addActionListener((event)->{
			if(b==null) {
				String line=textField.getText();
				String nums[]=line.split(",");
				b=new float[nums.length];
				int i = 0;
				while(i<b.length) {
					b[i]=Float.valueOf(nums[i]);
					i++;
				}
			}
			lblresLabel.setText(String.valueOf(try_Avg_adv.avg(b)));
		});
		rdbtnrndRadioButton.addActionListener((event)->{
			if(rdbtnrndRadioButton.isSelected()) {
				b=new float[10];
				for(int i=0;i<b.length;i++) {
					b[i]=(float) Math.random()*(a[1]-a[0])+a[0];
				}
				textField.setText(Arrays.toString(b));
			}
		});
		chckbxsrtCheckBox.addActionListener((event)->{
			if(chckbxsrtCheckBox.isSelected()) {
				float c[]=b;
				Arrays.sort(c);
				String nums[]=new String[c.length];
				int i = 0;
				for(float num:c) {
					nums[i]=String.valueOf(num);
					i++;
				}
				list.setListData(nums);
				float mid=(c[0]+c[c.length-1])/2;
				lblresLabel.setText(String.valueOf(mid));
			}
		});
	}

}
