package EBSWindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EBSLogin {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField TfUsername;
	private JPasswordField Pwdfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EBSLogin window = new EBSLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EBSLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtUsername.setText("Username");
		txtUsername.setBackground(UIManager.getColor("Button.background"));
		txtUsername.setBounds(97, 39, 79, 27);
		frame.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setEditable(false);
		txtPassword.setText("Password");
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtPassword.setBackground(SystemColor.menu);
		txtPassword.setBounds(97, 97, 79, 27);
		frame.getContentPane().add(txtPassword);
		
		TfUsername = new JTextField();
		TfUsername.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		TfUsername.setText("Username\r\n");
		TfUsername.setBounds(201, 40, 195, 27);
		frame.getContentPane().add(TfUsername);
		TfUsername.setColumns(10);
		
		Pwdfield = new JPasswordField();
		Pwdfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Pwdfield.setColumns(10);
		Pwdfield.setBounds(201, 97, 195, 27);
		frame.getContentPane().add(Pwdfield);
		
		JButton jb1 = new JButton("Login");
		jb1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb1.setBounds(79, 155, 112, 45);
		frame.getContentPane().add(jb1);
		
		JButton jb2 = new JButton("Exit");
		jb2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jb2.setBounds(227, 155, 112, 45);
		frame.getContentPane().add(jb2);
		
		JButton jb3 = new JButton("SignUp");
		jb3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jb3.setBounds(380, 155, 112, 45);
		frame.getContentPane().add(jb3);
		frame.setBounds(100, 100, 810, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
