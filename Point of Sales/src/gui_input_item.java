

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



public class gui_input_item extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6,panel7,panel8;
	private JButton buttonlogin, buttonlogout,button1,button2,button3,button4,btn_input,btn_logout;
	private JLabel lblnama,lblpw,lblJudul,lblperusahaan,lblwelcome,lblkode,lblkuantitas,lblharga,lblkategori;
	private static JPasswordField txtpw;
	private static JTextField txtnama,txtkode,txtharga,txtkategori,txtkuantitas;
	private static String vpassword,vmd5,vsha1,nama_login,value_kategori,str_kode_huruf,kode_huruf,str_kode_angka;
	private JLabel txtSHA1MD5,txtSHA1,txtMD5;
	static JFrame frame,frame_input_item,frame_menu_admin,frame_menu_item,frame_beranda,framelogin,frame_laporan;
	private static JDialog d;  
	private String[] kategori_item = {
	         "Alat tulis",
	         "Bumbu masak",
	         "Biskuit",
	         "Keripik",
	         "Susu",
	         "Mie Instant",
	         "Minuman",
	         "Perlengkapan",
	         "Rokok",
	         "Sabun,Shampoo & Detergen"
	};
	private static char[] str_to_array;
	private static int kode_angka;
	

	
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_input_item = new gui_input_item();
			frame_input_item.setVisible(true);
			

			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil_nama_login(String nama)
	{
		
		nama_login=nama;
	}
	
//	public static void cari_kode_terakhir() throws SQLException
	//{
		
	//	kode_angka=entity_input_item.kode_terbesar(str_kode_huruf);
		
		
	//}
	
	public static void input() throws FileNotFoundException, SQLException
	{		
		String nama= txtnama.getText();
		String kode= txtkode.getText();
		String harga= txtharga.getText();
		
		kode_huruf = kode.substring(0,3);
		//kode_angka=Integer.parseInt(kode);
		str_kode_angka = kode.substring(3,5);
		
		
		System.out.println(kode_huruf+str_kode_angka);
		
		String kuantitas= txtkuantitas.getText();
	
			boolean b=ctrl_input_item.cek_input(nama, kode,harga,kuantitas);
			
			boolean c=entity_input_item.validasi_input(nama, kode_huruf,str_kode_angka,harga,kuantitas);
			
			if(b==true)
			{
				boolean a=entity_input_item.validasi_input(nama, kode_huruf,str_kode_angka,harga,kuantitas);
				
				
				if(a==true)
				{
					JOptionPane.showMessageDialog(null, "Input sukses");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Input gagal");
				}
			}
		
	}
	
	
	@SuppressWarnings("resource")
	gui_input_item() throws FileNotFoundException, SQLException{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setTitle("GUI INPUT POS");
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
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU INPUT ITEM");
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
						((Window) frame_menu_item).setVisible(true);
						
						
						
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
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
	               gui_input_item.d.setVisible(false);  
	            }  
	        });    
	        d.add(new JLabel(about), BorderLayout.CENTER); 
	        d.add(judul, BorderLayout.NORTH);
	        d.add(nama, BorderLayout.SOUTH);
	        d.setLocationByPlatform(true);
	        d.setSize(600,600);    
	        d.setLocationRelativeTo(null);
	        d.setVisible(true);  
			
			gui_input_item.d.setVisible(true);  
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
					input();
				} catch (FileNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			  } 
			} );
		
		
		lblnama = new JLabel("Input Nama Barang");
		lblnama.setHorizontalAlignment(SwingConstants.LEFT);
		lblnama.setVisible(true);
		
		txtnama = new JTextField();
		txtnama.setVisible(true);
		txtnama.setHorizontalAlignment(JTextField.CENTER);
		
		lblkode = new JLabel("Input Kode Barang (5 DIGIT)");
		lblkode.setHorizontalAlignment(SwingConstants.LEFT);
		lblkode.setVisible(true);
		
		txtkode = new JTextField();
		txtkode.setVisible(true);
		txtkode.setHorizontalAlignment(JTextField.CENTER);
		
		lblharga = new JLabel("Input Harga Barang");
		lblharga.setHorizontalAlignment(SwingConstants.LEFT);
		lblharga.setVisible(true);
		
		txtharga = new JTextField();
		txtharga.setVisible(true);
		txtharga.setHorizontalAlignment(JTextField.CENTER);
		
		lblkategori = new JLabel("Input Kategori Barang");
		lblkategori.setHorizontalAlignment(SwingConstants.LEFT);
		lblkategori.setVisible(true);
		
		/*txtkategori = new JTextField();
		txtkategori.setVisible(true);
		txtkategori.setHorizontalAlignment(JTextField.CENTER);*/
		
		JComboBox kategori = new JComboBox(kategori_item);
		kategori.setSelectedIndex(4);
		kategori.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  
				  value_kategori = kategori.getSelectedItem().toString();
				  if(value_kategori=="Susu") {
				  
				  str_to_array = value_kategori.toCharArray();
				  char[] kode_huruf= {str_to_array[0],str_to_array[1],str_to_array[2]};
				  str_kode_huruf=kode_huruf.toString();
				  txtkode.setText("ssu");
				  
				 // try {
					//cari_kode_terakhir();
				//} catch (SQLException e1) {
					
					//e1.printStackTrace();
				//}
					 System.out.println(kode_angka);
				  }
				  if(value_kategori=="Keripik") {
					
					  txtkode.setText("krp");
					  }
				  if(value_kategori=="Alat tulis") {
					  txtkode.setText("atk");
					  }
				  if(value_kategori=="Bumbu masak") {
					  txtkode.setText("bms");
					  }
				  if(value_kategori=="Susu") {
					  txtkode.setText("ssu");
					  }
				  if(value_kategori=="Mie Instant") {
					  txtkode.setText("mie");
					  }
				  if(value_kategori=="Minuman") {
					  txtkode.setText("mnm");
					  }
				  if(value_kategori=="Perlengkapan") {
					  txtkode.setText("per");
					  }
				  if(value_kategori=="Rokok") {
					  txtkode.setText("rok");
					  }
				  if(value_kategori=="Sabun,Shampoo & Detergen") {
					  txtkode.setText("snd");
					  }
				  if(value_kategori=="Biskuit") {
					  txtkode.setText("bkt");
					  }
			  } 
			} );
		
		lblkuantitas = new JLabel("Input Jumlah Barang");
		lblkuantitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblkuantitas.setVisible(true);
		
		txtkuantitas = new JTextField();
		txtkuantitas.setVisible(true);
		txtkuantitas.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		//         Menambah elemen-elemen ke Frame		

		panel1.add(lblnama);
		panel1.add(txtnama);
		panel1.add(lblkode);
		panel1.add(txtkode);
		panel1.add(lblharga);
		panel1.add(txtharga);
		panel1.add(lblkategori);
		panel1.add(kategori);
		panel1.add(lblkuantitas);
		panel1.add(txtkuantitas);
		panel7.add(btn_input);
		panel1.add(panel7);
		
		
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
		panel2.add(panel3, BorderLayout.WEST);
		panel8.add(panel1,BorderLayout.CENTER);
		panel8.add(panel7,BorderLayout.SOUTH);
	}
	
	

	
	
	public void actionPerformed(ActionEvent event){
		
	
		
		if(event.getSource() == buttonlogin){
			
			
		    }
		
		
		if(event.getSource() == button2){
			
			
		    }
		
		
		}
	
}