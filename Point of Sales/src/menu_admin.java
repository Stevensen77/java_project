import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;



public class menu_admin extends JFrame implements ActionListener {
	
	private static final String INITIAL_VALUE = "1";

	private static final String String = null;
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5;
	static JButton btn_reg,btn_ubah;
	private JLabel lblnama,lblpw,lblJudul;
	static JPasswordField txtpw;
	static JTextField txtnama;
	static String vpassword,vmd5,vsha1;
	static JLabel txtSHA1MD5,txtMD5;
	static JFrame frame,framelogin,frame_menu_admin;
	
	

	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_menu_admin = new menu_admin(null);
			frame_menu_admin.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
    
	
	@SuppressWarnings("resource")
	menu_admin(ActionListener listener) throws FileNotFoundException, SQLException{		
		
		
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("MENU ADMIN");
		setSize(650,350);
		setLocationRelativeTo(null);
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
	
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2,2));
		
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
		panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU ADMIN");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		

	

	
		//         Deklarasi JButton
		
		
		btn_reg = new JButton("Registrasi Akun");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/register.png"));
		    btn_reg.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_reg.setVisible(true);
		btn_reg.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_daftar_akun = null;
					try {
						
						dispose();
						frame_daftar_akun = new gui_daftar_akun();
						
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}		
					frame_daftar_akun.setVisible(true);
					
				
			  } 
			} );
		
		
		
		btn_ubah = new JButton("Ubah Data Kasir");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/edit.png"));
		    btn_ubah.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_ubah.setVisible(true);
		btn_ubah.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_update_akun= null;
					try {
						dispose();
						frame_update_akun = new gui_update_akun();
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frame_update_akun.setVisible(true);
				
			  } 
			} );
		
		//         Menambah elemen-elemen ke Frame		
		panel3.add(lblJudul);		
		panel5.add(btn_reg);
		panel5.add(btn_ubah);
	
		
		//panel4.add(txtSHA1MD5);
		//panel2.add(buttonlogin);
		panel1.add(panel5, BorderLayout.CENTER);
		
		c.add(panel3, BorderLayout.NORTH);
		c.add(panel1, BorderLayout.CENTER);
		panel4.add(panel2);
		c.add(panel4, BorderLayout.SOUTH);
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
}

