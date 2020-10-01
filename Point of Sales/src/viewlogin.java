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



public class viewlogin extends JFrame implements ActionListener {
	
	private static final String INITIAL_VALUE = "1";

	private static final String String = null;
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4;
	static JButton buttonlogin, buttonregister,buttonhome;
	private JLabel lblnama,lblpw,lblJudul;
	static JPasswordField txtpw;
	static JTextField txtnama;
	static String vpassword,vmd5,vsha1,divisi;
	static JLabel txtSHA1MD5,txtMD5;
	private static JFrame frame,framelogin,frame_beranda;
	
	

	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			framelogin = new viewlogin(null);
			framelogin.setVisible(true);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
public static String encryptPasswordMD5(){
	    
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
	
	

public static void login() throws SQLException, IOException
{
 	//encryptPasswordSHA1();
	
	String nama= txtnama.getText();
	char[] pw= txtpw.getPassword();
	String vpassword= String.valueOf(pw);
	
	
	
  		encryptPasswordMD5();
 
  		txtSHA1MD5.setText(vmd5);
  		String md5=  txtSHA1MD5.getText();
  	beranda.tampil_nama_login(nama);
  	gui_input_item.tampil_nama_login(nama);
	gui_update_item.tampil_nama_login(nama);
	gui_stok_item.tampil_nama_login(nama);
	gui_daftar_akun.tampil_nama_login(nama);
	beranda_kasir.tampil_nama_login(nama);
	gui_transaksi_item.tampil_nama_login(nama);
	gui_laporan.tampil_nama_login(nama);

	
  	
	boolean a=entitylogin.validasi_login(nama, md5);
	boolean b=ctrl_login.cek_input(nama, vpassword);
	
	
	if(a&&b==true)
	{
		
		JOptionPane.showMessageDialog(null, "Login sukses");
		
		divisi=entitylogin.login_divisi(nama);
		System.out.println("Nilai divisi :" +divisi);	
		if(divisi.equals("Admin")) {
			
			frame_beranda = new beranda();
			frame_beranda.setVisible(true);
			//framelogin.dispose();
		}
		
		else if(divisi.equals("Kasir")) {
			
			JFrame gui_beranda_kasir;
			
			gui_beranda_kasir = new beranda_kasir();
			gui_beranda_kasir.setVisible(true);
			

		}
		
		
	}
	else 
	{
		JOptionPane.showMessageDialog(null, "Login gagal");
		
	}
	
	
}
    
	
	@SuppressWarnings("resource")
	viewlogin(ActionListener listener) throws FileNotFoundException, SQLException{		
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN : POINT of SALES");
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
		
		lblnama = new JLabel("UserName");
		lblnama.setHorizontalAlignment(SwingConstants.LEFT);
		lblnama.setVisible(true);
		
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
		buttonlogin.setVisible(true);
		buttonlogin.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				//ctrl_login.cek_input(getTitle(), getTitle());
				//entitylogin.validasi_login(getTitle(), getTitle());
				  try {
					login();
				} catch (FileNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  } 
				} );
		
		buttonregister = new JButton("Register");
		buttonregister.setVisible(true);
		buttonregister.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frameRegister = null;
					try {
						frameRegister = new register();
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frameRegister.setVisible(true);
				
			  } 
			} );
		
	
		
		
		
		//         Menambah elemen-elemen ke Frame		
		panel3.add(lblJudul);		
		panel1.add(lblnama);
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
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}








