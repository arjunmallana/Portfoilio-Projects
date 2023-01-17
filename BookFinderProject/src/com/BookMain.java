package com;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookMain {

	private JFrame frame;
	private JTextField txtbookname;
	private JTextField txtbookprice;
	private JTextField txtbookedition;
	private JTable table;
	private JTextField txtbookID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMain window = new BookMain();
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
	public BookMain() {
		initialize();
		connect();
		table_load();
	}
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	
	public void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/booksys","root","root");
		}
		catch
		(ClassNotFoundException ex){}
		catch(SQLException ex){}
		}
	
	public void table_load() {
		try {
			pat= con.prepareStatement("select * from book");
			rs = pat.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1062, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setBounds(461, 23, 209, 54);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 96, 417, 224);
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 29, 106, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 101, 96, 37);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 165, 96, 37);
		panel.add(lblNewLabel_1_2);
		
		txtbookname = new JTextField();
		txtbookname.setBounds(126, 37, 260, 26);
		panel.add(txtbookname);
		txtbookname.setColumns(10);
		
		txtbookprice = new JTextField();
		txtbookprice.setColumns(10);
		txtbookprice.setBounds(126, 165, 260, 26);
		panel.add(txtbookprice);
		
		txtbookedition = new JTextField();
		txtbookedition.setColumns(10);
		txtbookedition.setBounds(126, 101, 260, 26);
		panel.add(txtbookedition);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname,edition,price;
				bname = txtbookname.getText();
				edition = txtbookedition.getText();
				price = txtbookprice.getText();
				
				
				try {
					pat = con.prepareStatement("insert into book(name,edition,price)values(?,?,?)");
					pat.setString(1,bname );
					pat.setString(2,edition );
					pat.setString(3, price);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null," Record Added! ");
					table_load();
					//load table 
					txtbookname.setText("");
					txtbookedition.setText("");
					txtbookprice.setText("");
					txtbookname.requestFocus();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
				
			}
		});
		btnSaveButton.setBounds(32, 330, 107, 41);
		btnSaveButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(btnSaveButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(187, 330, 107, 41);
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtbookname.setText("");
				txtbookedition.setText("");
				txtbookprice.setText("");
				txtbookname.requestFocus();
				
			}
		});
		btnClear.setBounds(332, 330, 107, 41);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 96, 517, 333);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(51, 430, 399, 69);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtbookID = new JTextField();
		txtbookID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
			          
		            String id = txtbookID.getText();
		 
		                pat = con.prepareStatement("select name,edition,price from book where id = ?");
		                pat.setString(1, id);
		                ResultSet rs = pat.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String name = rs.getString(1);
		                String edition = rs.getString(2);
		                String price = rs.getString(3);
		                
		                txtbookname.setText(name);
		                txtbookedition.setText(edition);
		                txtbookprice.setText(price);
		                
		                
		            }  
		            else
		            {
		             txtbookname.setText("");
		             txtbookedition.setText("");
		                txtbookprice.setText("");
		                
		            }
		            
		 
		 
		        }
				catch (SQLException ex) {
					// TODO: handle exception
				}
				
			}
		});
		txtbookID.setColumns(10);
		txtbookID.setBounds(129, 22, 260, 26);
		panel_1.add(txtbookID);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("BookID");
		lblNewLabel_1_1_1.setBounds(10, 10, 102, 45);
		panel_1.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					String bname,edition,price,bid;
					bname = txtbookname.getText();
					edition = txtbookedition.getText();
					price = txtbookprice.getText();
					bid  = txtbookID.getText();
					try {
					pat = con.prepareStatement("update book set name= ?,edition=?,price=? where id =?");
					pat.setString(1, bname);
					pat.setString(2, edition);
					pat.setString(3, price);
					pat.setString(4, bid);
					pat.executeUpdate();
					            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					            table_load();
					          
					            txtbookname.setText("");
					            txtbookedition.setText("");
					            txtbookprice.setText("");
					            txtbookID.requestFocus();
					}
					 
					            catch (SQLException e1) {
					e1.printStackTrace();
					}
					}
				
		
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUpdate.setBounds(604, 445, 107, 41);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String bid;
bid  = txtbookID.getText();
try {
	pat = con.prepareStatement("delete from book where id =?");
	pat.setString(1, bid);
	pat.executeUpdate();
    JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
    table_load();
  
    txtbookname.setText("");
    txtbookedition.setText("");
    txtbookprice.setText("");
    txtbookID.requestFocus();
}

    catch (SQLException e1) {
e1.printStackTrace();
}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDelete.setBounds(759, 445, 107, 41);
		frame.getContentPane().add(btnDelete);
	}
}
