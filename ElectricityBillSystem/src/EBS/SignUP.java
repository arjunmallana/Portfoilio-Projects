package EBS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignUP  extends JFrame implements ActionListener{

	JPanel p1 ;
	JTextField tf1,tf2,tf3,tf4;//username, password , rewrite password , meter_no
	Choice c1;
	JButton b1,b2; //signup , cancel
	
	SignUP(){
		setBounds(600,250,700,400);
		
		
		p1= new JPanel();
		p1.setBounds(30, 30, 650, 300);
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		p1.setForeground(new Color(34,139,34));
		p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Times New Roman",Font.BOLD,14));
		l1.setBounds(100,50,100,20);
		p1.add(l1);
		
		
		
		tf1 = new JTextField();
		tf1.setBounds(260,50,150,20);
		p1.add(tf1);
		
		JLabel l2 = new JLabel("Name");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Times New Roman",Font.BOLD,14));
		l1.setBounds(100,90,100,20);
		p1.add(l2);
		
		tf2 = new JTextField();
		tf2.setBounds(260, 90, 150, 20);
		p1.add(tf2);
		
		JLabel l3 = new JLabel("Password");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Times New Roman",Font.BOLD,14));
		l1.setBounds(100,130,100,20);
		p1.add(l3);
		
		tf3 = new JTextField();
		tf3.setBounds(260, 90, 150, 20);
		p1.add(tf3);
		
		JLabel l4 = new JLabel("Create Account Sa");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Times New Roman",Font.BOLD,14));
		l1.setBounds(100,130,100,20);
		p1.add(l4);
		
		
		
		JLabel l5 = new JLabel("Meter No");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Times New Roman",Font.BOLD,14));
		l5.setBounds(100,210,100,20);
		l5.setVisible(false);
		p1.add(l5);
		
		c1 = new Choice();
		c1.add("ADMIN");
		c1.add("Customer");
		c1.setBounds(260,170,150,20);
		p1.add(c1);
		
		c1.addItem(new ItemListener() {
		public void itemStateChanged(ItemEvent ae) {
			String usr = c1.getSelectedItem();
			if(usr.equals("Customer")) {
				l5.setVisible(true);
				tf4.setVisible(true);
			}
			else {
				l5.setVisible(false);
				tf4.setVisible(false);

			}
		
		}
		});
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}