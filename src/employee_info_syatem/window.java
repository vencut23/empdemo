package employee_info_syatem;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class window {

	private JFrame frame;
	private JTextField fntext;
	private JTextField lntext;
	private JTextField phonetext;
	private JTextField empidtext;
    Connection con=null;
    PreparedStatement pre=null;
    String[] columnHeaders = {"firstname", "lastname", "phone","empid"};
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
    private JTable table;
    private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public window() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("MingLiU-ExtB", Font.BOLD | Font.ITALIC, 20));
		frame.setBounds(100, 100, 653, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee  Information System");
		lblNewLabel.setBackground(new Color(128, 128, 0));
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setBounds(10, 11, 617, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 54, 272, 244);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel fnlab = new JLabel("First Name");
		fnlab.setBounds(10, 39, 100, 28);
		panel.add(fnlab);
		
		JLabel lnlab = new JLabel("Last Name");
		lnlab.setBounds(10, 86, 100, 28);
		panel.add(lnlab);
		
		JLabel phonelab = new JLabel("Phone ");
		phonelab.setBounds(10, 125, 100, 28);
		panel.add(phonelab);
		
		JLabel empidlab = new JLabel("Employee ID");
		empidlab.setBounds(10, 171, 100, 28);
		panel.add(empidlab);
		
		fntext = new JTextField();
		fntext.setBounds(89, 43, 161, 20);
		panel.add(fntext);
		fntext.setColumns(10);
		
		lntext = new JTextField();
		lntext.setColumns(10);
		lntext.setBounds(89, 90, 161, 20);
		panel.add(lntext);
		
		phonetext = new JTextField();
		phonetext.setColumns(10);
		phonetext.setBounds(89, 133, 161, 20);
		panel.add(phonetext);
		
		empidtext = new JTextField();
		empidtext.setColumns(10);
		empidtext.setBounds(89, 175, 161, 20);
		panel.add(empidtext);
		
		JButton savebut = new JButton("Save");
		savebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=conection.getConnection();
				String firstname=fntext.getText();
				String lastname = lntext.getText();
				String phoneno=phonetext.getText();
				String empid=empidtext.getText();
				try {
					pre=con.prepareStatement(Query.ADDQUERY);
					pre.setString(1,firstname);
					pre.setString(2,lastname);
					pre.setString(3,phoneno);
					pre.setString(4,empid);
					int a=pre.executeUpdate();
					if(a>0) {
						JOptionPane.showMessageDialog(null, "inserted succesfully");
						fntext.setText("");
						lntext.setText("");
						phonetext.setText("");
						empidtext.setText("");
						
						
						model.addRow(new Object[]{firstname,lastname,phoneno,empid});
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		savebut.setBounds(20, 322, 100, 32);
		frame.getContentPane().add(savebut);
		
		JButton delbut = new JButton("Delete");
		delbut.setBounds(196, 322, 100, 32);
		frame.getContentPane().add(delbut);
		
		table = new JTable();
		table.setBounds(367, 161, 90, -65);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		table_1.setModel(model);
		table_1.setBounds(314, 57, 313, 297);
		frame.getContentPane().add(table_1);
	}
}
