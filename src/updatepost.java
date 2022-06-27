

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class updatepost extends JFrame {

    private static final long serialVersionUID = 1L;
    static updatepost frame;
    private JPanel contentPane;
    private JTextField TextField;
    private JLabel lblEnterOldPassword;
    private JTextField TextField1;
    private JLabel lblEnterNewPassword;
    private JTextField TextField2;
    private JLabel lblReEnterNewPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new updatepost();
					frame.setTitle("Modify post Info.");
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
    public updatepost() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 350);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 37, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 87, 326, 40);
        contentPane.add(TextField1);
        TextField.setColumns(10);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 137, 326, 40);
        contentPane.add(TextField2);
        TextField2.setColumns(10);
        
        TextField.setText("");
		TextField1.setText("");
		TextField2.setText("");

		 Connection con = DB.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	post.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 225, 130, 50);
	        contentPane.add(btnBack);
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String b = TextField.getText();
                  String t = TextField1.getText();
                  String a = TextField2.getText();
                if(posttype.checkpost(b)) {
                try {

                    PreparedStatement st = con.prepareStatement("Update post_type set ptype=? where pid=?");

                    st.setString(1, t);
                    st.setString(2, a);
                  //  st.setString(3, b);
                    st.executeUpdate();
                  System.out.println("updated info for postid : " + a);
                    JOptionPane.showMessageDialog(btnSave, "Data Updated Successfully :)");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }}
				else{
					JOptionPane.showMessageDialog(updatepost.this,"post ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				//TextField2.setText("");
            }
 

            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setBounds(300, 225, 130, 50);
        contentPane.add(btnSave);

        lblEnterOldPassword = new JLabel("post ID :");
        lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnterOldPassword.setBounds(45, 37, 326, 40);
        contentPane.add(lblEnterOldPassword);
        
        lblEnterNewPassword = new JLabel("post type :");
        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnterNewPassword.setBounds(45, 87, 326, 40);
        contentPane.add(lblEnterNewPassword);
        
       // lblReEnterNewPassword = new JLabel("Phone number :");
     //   lblReEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
       // lblReEnterNewPassword.setBounds(45, 137, 326, 40);
        //contentPane.add(lblReEnterNewPassword);
        
        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String post = TextField.getText();
                  String pid = TextField1.getText();
                  String ptype = TextField2.getText();
            	Connection con = DB.getConnection();
            	//String post = null;
				if(posttype.checkpost(post)) {
            	Statement st;
				try {
					PreparedStatement stmt = con.prepareStatement("select * from post_type where pid=?");
					stmt.setString(1,post);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())   
					{	TextField.setText(rs.getString(1));
			TextField1.setText(rs.getString(2));
		//	TextField2.setText(rs.getString(3));
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(updatepost.this,"post ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				//TextField2.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(150, 225, 130, 50);
        contentPane.add(btnLoad);
        
    }
}