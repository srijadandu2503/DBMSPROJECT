
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class addcomment extends JFrame {
	private static final long serialVersionUID = 1L;
	static addcomment frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	//private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new addcomment();
					frame.setTitle("comment Info.");
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
	public addcomment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddcomment = new JLabel("Add comment");
		lblAddcomment.setForeground(Color.GRAY);
		lblAddcomment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblpostid = new JLabel("post ID :");
		
		JLabel lblfeedback= new JLabel("feedback :");
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		//textField_2 = new JTextField();
		//textField_2.setColumns(10);
		JButton btnAdduser = new JButton("Submit");
		btnAdduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String pid=textField.getText();
			String feedback=textField_1.getText();
			//String pno=textField_2.getText();
			if(userdetails.checkbook(pid)) {
				JOptionPane.showMessageDialog(addcomment.this,"post with Same post ID is present already\nInserton Failed !!!");
			}
			else {
			int i=posttype.insertpost(pid,feedback);
			if(i>0){
				JOptionPane.showMessageDialog(addcomment.this,"feedback added successfully!");
			}else{
				JOptionPane.showMessageDialog(addcomment.this,"Unknown Error !!!\nInsertion not completed");
			}
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				user.main(new String[]{});
				frame.dispose();
			}
			});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddcomment))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblpostid)
								.addComponent(lblfeedback)
					
								)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								
								//.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(btnAdduser)
					.addGap(30)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddcomment)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblpostid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblfeedback)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					//.addGap(18)
					//.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						//.addComponent(lblpno)
						//.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdduser, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					
	)	);
		contentPane.setLayout(gl_contentPane);
	}

}
