package EBS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class About  extends JFrame implements ActionListener{

	JButton b1;
	JLabel l1;
	Font f,f1,f2;
	TextArea t1;
	String s ;
	
	public About() {
		setLayout(null);
		JButton b1 = new JButton("Exit");
		add(b1);
		b1.setBounds(180, 430, 120, 40);//Button setBounds(buttonPositionHorizontal , buttonPositionVertical ,ButtonSizeHorizontal ,ButtonSizeVertical);*Check once *
		b1.addActionListener(this);
	
		Font f = new Font("Raleway", Font.BOLD, 18);
		setFont(f);
		
		s= " 						About 								\n"
				+"\n Electricity Billing System "
				+"Java Language "
				+"easier way to pay "
				+"consumers , admin ";			
	
	TextArea t1 = new TextArea(s,10,40,Scrollbar.VERTICAL);
	t1.setEditable(false);
	t1.setBounds(20,100,450,300);
	
	add(t1);
	
	Font f1  = new Font("Raleway", Font.BOLD, 16);
	t1.setFont(f1);
	
	Container contentPane = this.getContentPane();
	t1 = new TextArea();
	//Text Label Modification
	JLabel l1 = new JLabel("About Projects"); //Text heading
	add(l1); //Adding the text
	l1.setBounds(170, 10, 180, 80);//Label Text setBound(LabelPositionHorizontal , LabelPositionVertical , LabelTextboxSize, LabelPositoinHeight ) *Check once *
	l1.setForeground(Color.red);
	Font f2 =  new Font("Raleway", Font.BOLD, 20);
	l1.setFont(f2);
	setBounds(700,220,500,550);
	
	setLayout(null);
	setVisible(true);
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
public static void main(String[] args) {
	new About().setVisible(true);
}
}
