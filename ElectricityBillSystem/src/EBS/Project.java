package EBS;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
	
	String meter;
	Project(String meter , String person){
		super("Electricity Billing System");
		this.meter = meter;
		
		setSize(1920,1030);
		
		/*Adding Background image*/
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Icons/elect1.jpg"));
		Image i3 = ic.getImage().getScaledInstance(1920, 930, Image.SCALE_DEFAULT);
		ImageIcon icc3 = new ImageIcon(i3);
		JLabel l1 = new JLabel(icc3);
		add(l1);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
