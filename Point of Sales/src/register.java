import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;



public class register extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4;
	private JButton buttonregister,buttonhome;
	private JLabel lblname,lblpw,lblJudul;
	private JPasswordField txtpw;
	private JTextField txtnama;
	private String vpassword,vmd5;
	private JLabel txtSHA1MD5;
	
	private static JFrame frame_register;
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_register = new register();
			frame_register.setVisible(true);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
  
	@SuppressWarnings("resource")
	register() throws FileNotFoundException, SQLException{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Form REGISTER AKUN ADMIN POS");
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
		
		lblJudul = new JLabel("Register Point of Sales");
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
		
		lblpw = new JLabel("Password (Harus Ada Karakter tanda baca!))");
		lblpw.setHorizontalAlignment(SwingConstants.LEFT);
		lblpw.setVisible(true);

		txtpw = new JPasswordField();
		txtpw.setVisible(true);
		txtpw.setHorizontalAlignment(JTextField.CENTER);
		titlepw.setTitleJustification(TitledBorder.CENTER);
		txtpw.setBorder(titlepw);
		
		
		//         Deklarasi JButton
		buttonregister = new JButton("DAFTAR");
		buttonregister.addActionListener(this);
	
		
		
		
		//         Menambah elemen-elemen ke Frame		
		panel3.add(lblJudul);		
		panel1.add(lblname);
		panel1.add(txtnama);
		panel1.add(lblpw);
		panel1.add(txtpw);
		
		panel4.add(txtSHA1MD5);
		
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
			  
			//txtMD5.setText(vmd5);
			
			}
			catch(Exception e){
			   e.printStackTrace();
			}
	  return encPass;
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		
		if(event.getSource() == buttonhome) {
			JFrame viewberanda = null;
			try {
				viewberanda = new beranda();
			} catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			viewberanda.setVisible(true);
		}
		
		
		
		
		if(event.getSource() == buttonregister){
			
			 
			 char[] pw= txtpw.getPassword();
             String s = String.valueOf(pw);
			
			 try {
				 String nama=txtnama.getText(); 
				
				//encryptPasswordSHA1();
           	  	encryptPasswordMD5();
           	  	//txtMD5.setText(vmd5);
           	  	//String akhir=  txtMD5.getText();
				
           	  		String cek="select * from akun where username='"+nama+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
		            
		            String divisi="Admin";
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==0)
				      {        
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
						
					   statement2.executeUpdate("INSERT INTO akun(username,password) VALUES ('"+nama+"','"+vmd5+"')");
					   statement2.executeUpdate("INSERT INTO biodata(username,nama,alamat,no_ktp,divisi,no_hp) VALUES ('"+nama+"',"
						   		+ "'nama','alamat','1234567891234567','"+divisi+"','"+90940932+"')");
					   statement2.close();
					   JOptionPane.showMessageDialog(null,"Berhasil Memasukan Data");
					   
					   JFrame frame_login = new viewlogin(null);
						frame_login.setVisible(true);
						dispose();
				      }
				   else {
					     JOptionPane.showMessageDialog(null,"data sudah ada");
				   }
			 }
			 
			 catch(Exception e)
			 {
				 JOptionPane.showMessageDialog(null,"Gagal Memasukan data");
		     }
		                 
			
		    }
		
		
		}
	
	
	
		
	
}