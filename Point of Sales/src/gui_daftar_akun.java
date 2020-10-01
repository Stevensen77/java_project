import javax.imageio.ImageIO;
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



public class gui_daftar_akun extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6,panel7,panel8,panel9;
	private JButton buttonlogin, buttonlogout,button1,button2,button3,button4,btn_input,btn_logout;
	private JLabel lblusername,lblpw,lblJudul,lblperusahaan,lblwelcome,lbldivisi,lblalamat,lblnotkp,lblnohp,lblnama,lblnoktp,lblkelompok;
	private static JPasswordField txtpw;
	private static JTextField txtusername,txtalamat,txtnohp,txtnoktp,txtdivisi,txtnama;
	private static String password,md5,vsha1,pw_md5,encPass,nama_login;
	private JLabel txtSHA1MD5,txtSHA1;
	private static JLabel txtMD5;
	private static JComboBox divisi_list;
	static JFrame frame,frame_daftar_akun,frame_menu_admin,framelogin,frame_laporan;
	private static JDialog d;  
	
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
			
			Window frame_menu_item = null;
			
			frame_daftar_akun = new gui_daftar_akun();
			frame_daftar_akun.setVisible(true);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil_nama_login(String nama)
	{
		
		nama_login=nama;
	}
	
	public static String encryptPasswordMD5(){
	    
		char[] pw= txtpw.getPassword();
		password= String.valueOf(pw);
		
	    encPass=null;
			try{
			   MessageDigest digest= MessageDigest.getInstance("MD5");
			   digest.update(password.getBytes(),0,password.length());
			   encPass=new BigInteger(1,digest.digest()).toString(16);
			   md5=encPass.toUpperCase();
			  
			
			}
			catch(Exception e){
			   e.printStackTrace();
			}
	  return encPass;
	}
	
	
	public static void daftar_akun() throws FileNotFoundException, SQLException
	{		
		String username= txtusername.getText();
		
		String nama= txtnama.getText();
		String alamat= txtalamat.getText();
		String noktp= txtnoktp.getText();
		String divisi = divisi_list.getSelectedItem().toString();
		String nohp= txtnohp.getText();
	
		
		
		
		boolean c=ctrl_daftar_akun.cek_input(username,password,nama,alamat,noktp,divisi,nohp);
		if(c==true)
		{
			boolean a=entity_daftar_akun.input_akun(username,md5);
			boolean b=entity_daftar_akun.input_biodata(username,nama,alamat,noktp,divisi,nohp);
			
			if(a&&b)
			{
				JOptionPane.showMessageDialog(null, "Daftar Akun sukses");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Daftar Akun gagal");
			}
		}
	
			
		
	
			
		
	}
	
	
	@SuppressWarnings("resource")
	gui_daftar_akun() throws FileNotFoundException, SQLException{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DAFTAR AKUN");
		setSize(850,650);
		setLocationRelativeTo(null);
		

		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7,2));
		

		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(new Color(198, 199, 202));
		
		panel3 = new JPanel();
		panel3.setBounds(61, 11, 81, 140);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.setBackground(new Color(0,255,255));
		
		panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		panel5.setBackground(new Color(1, 185, 202));
		
		panel6 = new JPanel();
		panel6.setLayout(new FlowLayout());
		panel6.setBackground(new Color(0,255,255));
		
		panel7 = new JPanel();
		panel7.setLayout(new FlowLayout());
		panel7.setBackground(new Color(0,255,255));
		
		panel8 = new JPanel();
		panel8.setLayout(new BorderLayout());
		panel8.setBackground(new Color(0,255,255));
		
		panel9 = new JPanel();
		panel9.setLayout(new GridLayout(2,1));
		

		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU DAFTAR AKUN");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		
		lblperusahaan = new JLabel("PT.Indonusa");
		font = lblperusahaan.getFont();
		font = font.deriveFont(font.getSize() * 1.5f);
		lblperusahaan.setFont(font);
		lblperusahaan.setVisible(true);
		
		
		lblwelcome = new JLabel("welcome = "+nama_login);
		font = lblwelcome.getFont();
		font = font.deriveFont(font.getSize() * 1.5f);
		lblwelcome.setFont(font);
		lblwelcome.setVisible(true);
		
		TitledBorder keterangan = BorderFactory.createTitledBorder(blackline,"MENU ITEM");
		TitledBorder keterangan2 = BorderFactory.createTitledBorder(blackline,"ADMIN");
		TitledBorder keterangan3 = BorderFactory.createTitledBorder(blackline,"ABOUT");
		TitledBorder keterangan4 = BorderFactory.createTitledBorder(blackline,"REPORT");
		
		//         Deklarasi JButton
		
		button1 = new JButton("");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/kardus.png"));
		    button1.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		  
		keterangan.setTitleJustification(TitledBorder.CENTER);
		button1.setBorder(keterangan);
		button1.setPreferredSize(new Dimension(100, 100));
		button1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  Object frame_menu_item = null ;
					try {
						frame_menu_item= new menu_item();
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					((Window) frame_menu_item).setVisible(true);
			  } 
			} );
		
		button2 = new JButton("");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/report.png"));
		    button2.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		keterangan4.setTitleJustification(TitledBorder.CENTER);
		button2.setBorder(keterangan4);
		button2.setPreferredSize(new Dimension(100, 100));
		button2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				  frame_laporan = null;
					try {
						frame_laporan = new gui_laporan();
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frame_laporan.setVisible(true);
				
			  } 
			} );
		
		
		button3 = new JButton("");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/admin.png"));
		    button3.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		keterangan2.setTitleJustification(TitledBorder.CENTER);
		//keterangan.setTitlePosition(TitledBorder.BOTTOM);
		button3.setBorder(keterangan2);
		//button3.setHorizontalAlignment(SwingConstants.LEFT);
		button3.setPreferredSize(new Dimension(100, 100));
		button3.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  frame_menu_admin = null ;
					try {
						frame_menu_admin= new menu_admin(null);
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frame_menu_admin.setVisible(true);
				
			  } 
			} );
		
		button4 = new JButton("");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/about.png"));
		    button4.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		keterangan3.setTitleJustification(TitledBorder.CENTER);
		button4.setBorder(keterangan3);
		button4.setPreferredSize(new Dimension(100, 100));
		button4.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
		try {
			Image img = ImageIO.read(getClass().getResource("/image/team.jpg"));
			
			ImageIcon about=new ImageIcon(img);
			JLabel judul=new JLabel("Aplikasi POINT OF SALES", SwingConstants.CENTER);
			Font font = judul.getFont();
			font = font.deriveFont(font.getSize()*1.8f);
			judul.setFont(font);
			
			JLabel nama=new JLabel("STEVEN SEN - GUSTI BRANTYO - PANJI REKSA", SwingConstants.CENTER);
			
			
			
			JFrame f= new JFrame();  
	        d = new JDialog(f , "Dialog Example", true);  
	        d.setLayout( new BorderLayout() );  
	        JButton b = new JButton ("OK");  
	        b.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	               gui_daftar_akun.d.setVisible(false);  
	            }  
	        });    
	        d.add(new JLabel(about), BorderLayout.CENTER); 
	        d.add(judul, BorderLayout.NORTH);
	        d.add(nama, BorderLayout.SOUTH);
	        d.setLocationByPlatform(true);
	        d.setSize(600,600);    
	        d.setLocationRelativeTo(null);
	        d.setVisible(true);  
			
			gui_daftar_akun.d.setVisible(true);  
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
			  } 
		} );
		
		
		btn_logout = new JButton("Log Out");
		btn_logout.setPreferredSize(new Dimension(100, 50));
		btn_logout.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				
					try {
						framelogin= new viewlogin(null);
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					framelogin.setVisible(true);
					
					dispose();
				
			  } 
			} );
		
		btn_input = new JButton("INPUT");
		btn_input.setPreferredSize(new Dimension(100, 100));
		btn_input.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 try {
					 encryptPasswordMD5();
					daftar_akun();
					
				} catch (FileNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			  } 
			} );
		
		
		lblusername = new JLabel("Input Username");
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setVisible(true);
		
		txtusername = new JTextField();
		txtusername.setVisible(true);
		txtusername.setHorizontalAlignment(JTextField.CENTER);
		
		lblpw = new JLabel("Input Password");
		lblpw.setHorizontalAlignment(SwingConstants.LEFT);
		lblpw.setVisible(true);
		
		txtpw = new JPasswordField();
		txtpw.setVisible(true);
		txtpw.setHorizontalAlignment(JPasswordField.CENTER);
		
		lblnama = new JLabel("Nama : ");
		lblnama.setHorizontalAlignment(SwingConstants.LEFT);
		lblnama.setVisible(true);
		
		txtnama = new JTextField();
		txtnama.setVisible(true);
		txtnama.setHorizontalAlignment(JTextField.CENTER);
		
		lblalamat = new JLabel("Alamat : ");
		lblalamat.setHorizontalAlignment(SwingConstants.LEFT);
		lblalamat.setVisible(true);
		
		txtalamat = new JTextField();
		txtalamat.setVisible(true);
		txtalamat.setHorizontalAlignment(JTextField.CENTER);
		
		lblnoktp = new JLabel("No KTP : ");
		lblnoktp.setHorizontalAlignment(SwingConstants.LEFT);
		lblnoktp.setVisible(true);
		
		txtnoktp = new JTextField();
		txtnoktp.setVisible(true);
		txtnoktp.setHorizontalAlignment(JTextField.CENTER);
		
		String[] divisi = { "Admin", "Kasir" };
		
		divisi_list = new JComboBox(divisi);
		divisi_list.setSelectedIndex(1);
		divisi_list.addActionListener(this);
		
		lbldivisi = new JLabel("Divisi : ");
		lbldivisi.setHorizontalAlignment(SwingConstants.LEFT);
		lbldivisi.setVisible(true);
		
		lblnohp = new JLabel("No HP : ");
		lblnohp.setHorizontalAlignment(SwingConstants.LEFT);
		lblnohp.setVisible(true);
		
		txtnohp = new JTextField();
		txtnohp.setVisible(true);
		txtnohp.setHorizontalAlignment(JTextField.CENTER);
		
		lblkelompok = new JLabel("Steven sen - Panji Reksa - Gusti Brantyo ");
		lblkelompok.setHorizontalAlignment(SwingConstants.LEFT);
		lblkelompok.setVisible(true);
		

		
		//         Menambah elemen-elemen ke Frame		

		panel1.add(lblusername);
		panel1.add(txtusername);
		panel1.add(lblpw);
		panel1.add(txtpw);
		panel1.add(lblnama);
		panel1.add(txtnama);
		panel1.add(lblalamat);
		panel1.add(txtalamat);
		panel1.add(lblnoktp);
		panel1.add(txtnoktp);
		panel1.add(lbldivisi);
		panel1.add(divisi_list);
		panel1.add(lblnohp);
		panel1.add(txtnohp);
		panel6.add(btn_input);
		panel7.add(lblkelompok);
		
		
		
		panel3.add(lblJudul);
		panel3.add(lblperusahaan);
		
	
		panel4.add(button1);
		panel4.add(button2);
		panel4.add(button3);
		panel4.add(button4);
		
		panel5.add(lblwelcome, BorderLayout.WEST);
		panel5.add(btn_logout, BorderLayout.EAST);
		
		//panel3.add(buttonlogin);
		//panel3.add(buttonregister);
	
		panel2.add(panel4,BorderLayout.EAST);
		panel2.add(panel5,BorderLayout.SOUTH);
		
		c.add(panel2, BorderLayout.NORTH);
		c.add(panel8, BorderLayout.CENTER);
		c.add(panel6, BorderLayout.WEST);
		panel9.add(panel6);
		panel9.add(panel7);
		panel2.add(panel3, BorderLayout.WEST);
		panel8.add(panel1,BorderLayout.CENTER);
		panel8.add(panel9,BorderLayout.SOUTH);
		
	}
	
	

	
	
	public void actionPerformed(ActionEvent event){
		
	
		
		if(event.getSource() == buttonlogin){
			
			
		    }
		
		
		if(event.getSource() == button2){
			
			
		    }
		
		
		}
	
}