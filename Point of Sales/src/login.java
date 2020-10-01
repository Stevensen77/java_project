import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;



public class login extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4;
	private JButton buttonlogin, buttonregister,buttonhome;
	private JLabel lblname,lblpw,lblJudul;
	private JPasswordField txtpw;
	private JTextField txtnama;
	private String vpassword,vmd5,vsha1;
	private JLabel txtSHA1MD5,txtSHA1,txtMD5;
	private JFrame frame;
	
	 // database URL
  
	@SuppressWarnings("resource")
	login() throws FileNotFoundException, SQLException{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Form LOGIN POS");
		setSize(650,350);
		setLocationRelativeTo(null);
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
	
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2,2));
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("Point of Sales");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		
		lblname = new JLabel("UserName");
		lblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblname.setVisible(true);
		
		txtSHA1MD5 = new JLabel("");
		txtSHA1MD5.setHorizontalAlignment(SwingConstants.LEFT);
		txtSHA1MD5.setVisible(true);
		
		//         Deklarasi JTextField
		txtnama = new JTextField();
		txtnama.setVisible(true);
		txtnama.setHorizontalAlignment(JTextField.CENTER);
		titlenama.setTitleJustification(TitledBorder.CENTER);
		txtnama.setBorder(titlenama);
		
		lblpw = new JLabel("Password");
		lblpw.setHorizontalAlignment(SwingConstants.LEFT);
		lblpw.setVisible(true);

		txtpw = new JPasswordField();
		txtpw.setVisible(true);
		txtpw.setHorizontalAlignment(JTextField.CENTER);
		titlepw.setTitleJustification(TitledBorder.CENTER);
		txtpw.setBorder(titlepw);
		
		
		//         Deklarasi JButton
		buttonlogin = new JButton("Login");
		buttonlogin.addActionListener(this);
		buttonregister = new JButton("Register");
		buttonregister.addActionListener(this);
		
		
		
		
		//         Menambah elemen-elemen ke Frame		
		panel3.add(lblJudul);		
		panel1.add(lblname);
		panel1.add(txtnama);
		panel1.add(lblpw);
		panel1.add(txtpw);
		
		panel4.add(txtSHA1MD5);
		
		panel2.add(buttonlogin);
		panel2.add(buttonregister);
	
		
		c.add(panel3, BorderLayout.NORTH);
		c.add(panel1, BorderLayout.CENTER);
		panel4.add(panel2);
		c.add(panel4, BorderLayout.SOUTH);
		
	}
	
	
	private String encryptPasswordMD5(){
	    
		char[] pw= txtpw.getPassword();
		vpassword= String.valueOf(pw);
		
	    String encPass=null;
			try{
			   MessageDigest digest= MessageDigest.getInstance("MD5");
			   digest.update(vpassword.getBytes(),0,vpassword.length());
			   encPass=new BigInteger(1,digest.digest()).toString(16);
			   vmd5=encPass.toUpperCase();
			  
			txtMD5.setText(vmd5);
			
			}
			catch(Exception e){
			   e.printStackTrace();
			}
	  return encPass;
	}
	
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		
	
		
		
		if(event.getSource() == buttonlogin){
			
			 try {
				 
				 	//encryptPasswordSHA1();
           	  		encryptPasswordMD5();
           	 
           	  		txtSHA1MD5.setText(vmd5);
           	  		String akhir=  txtSHA1MD5.getText();
				
           	  		
		            Statement statement = (Statement) koneksidatabase.getKoneksi().createStatement();
		            ResultSet result=statement.executeQuery("select * from admin where " + "username='" + txtnama.getText() + "'");
		            if (result.next()) {
		                String string = result.getString("password");
		                
		                //char[] pw= txtpw.getPassword();
		               // String s = String.valueOf(pw);
		                
						if (akhir.equals(string)) {
		                	JOptionPane.showMessageDialog(rootPane, "Password benar");
		                	JFrame viewberanda;
		        			viewberanda = new beranda();
		        			viewberanda.setVisible(true);

		                } else {
		                    JOptionPane.showMessageDialog(rootPane, "Password salah");
		                    txtpw.setText("");
		                    txtnama.requestFocus();
		                }
		            } else {
		                JOptionPane.showMessageDialog(rootPane, "User tidak ditemukan");
		                txtnama.setText("");
		                txtpw.setText("");
		                txtnama.requestFocus();
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(rootPane, "gagal");
		        }
			
		    }
		
		
		if(event.getSource() == buttonregister){
			
			JFrame viewregister = null;
			try {
				viewregister = new register();
			} catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			viewregister.setVisible(true);
			
		    }
		
		
		}
	
	
	
		
	
}