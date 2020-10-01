import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;



public class beranda extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5;
	private JButton buttonlogin, btn_logout,button1,button2,button3,button4,button5;
	private JLabel lblname,lblpw,lblJudul,lblperusahaan,lblwelcome;
	private JPasswordField txtpw;
	private JTextField txtnama;
	private String vpassword,vmd5,vsha1;
	private static String nama_login;
	private JLabel txtSHA1MD5,txtSHA1,txtMD5;
	static JFrame frame,frame_menu_item,frame_menu_admin,frame_laporan;
	private JFrame framelogin;
	private static Window frame_beranda;
	 private static JDialog d;  
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			frame_beranda = null;
			
			frame_beranda = new beranda();
			frame_beranda.setVisible(true);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil_nama_login(String nama)
	{
		
		nama_login=nama;
		System.out.println(nama);
	}

	
	@SuppressWarnings("resource")
	beranda() throws SQLException, IOException{		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BERANDA POS");
		setSize(850,650);
		setLocationRelativeTo(null);
		JFrame framelogin = new viewlogin(null);
		framelogin.dispose();
	
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		

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
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("BERANDA");
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
		
		Image beranda_admin = ImageIO.read(getClass().getResource("/image/admin_beranda.png"));
		ImageIcon admin_beranda=new ImageIcon(beranda_admin);
		
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
				  frame_menu_item = null ;
					try {
						frame_menu_item= new menu_item();
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frame_menu_item.setVisible(true);
				
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
	               beranda.d.setVisible(false);  
	            }  
	        });    
	        d.add(new JLabel(about), BorderLayout.CENTER); 
	        d.add(judul, BorderLayout.NORTH);
	        d.add(nama, BorderLayout.SOUTH);
	        d.setLocationByPlatform(true);
	        d.setSize(600,600);    
	        d.setLocationRelativeTo(null);
	        d.setVisible(true);  
			
			beranda.d.setVisible(true);  
		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
			  } 
		} );
		
		buttonlogin = new JButton("Login");
		buttonlogin.addActionListener(this);
		
		btn_logout = new JButton("Log Out");
		btn_logout.setPreferredSize(new Dimension(100, 50));
		btn_logout.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				
					try {
						JFrame framelogin= new viewlogin(null);
						nama_login="";
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					framelogin.setVisible(true);
					
					dispose();
				
			  } 
			} );
		
		//         Menambah elemen-elemen ke Frame		

	
		panel1.add(new JLabel(admin_beranda));
		
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
		c.add(panel1, BorderLayout.CENTER);
		panel2.add(panel3, BorderLayout.WEST);
	}
	
	

	
	public void actionPerformed(ActionEvent event){
		
	
		
		if(event.getSource() == buttonlogin){
			
			
		    }
		
		
		if(event.getSource() == button2){
			
			
		    }
		
		
		}
	
}