
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

public class addpost extends JFrame {
	private static final long serialVersionUID = 1L;
	static addpost frame;
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
					frame = new addpost();
					frame.setTitle("post Info.");
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
	public addpost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddpost = new JLabel("Add post");
		lblAddpost.setForeground(Color.GRAY);
		lblAddpost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblpostid = new JLabel("post ID :");
		
		JLabel lblptype = new JLabel("post type :");
		
		
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
			String ptype=textField_1.getText();
			//String pno=textField_2.getText();
			if(userdetails.checkbook(pid)) {
				JOptionPane.showMessageDialog(addpost.this,"post with Same post ID is present already\nInserton Failed !!!");
			}
			else {
			int i=posttype.insertpost(pid,ptype);
			if(i>0){
				JOptionPane.showMessageDialog(addpost.this,"post added successfully!");
			}else{
				JOptionPane.showMessageDialog(addpost.this,"Unknown Error !!!\nInsertion not completed");
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
							.addComponent(lblAddpost))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblpostid)
								.addComponent(lblptype)
					
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
					.addComponent(lblAddpost)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblpostid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblptype)
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
