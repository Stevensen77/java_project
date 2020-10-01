

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class gui_update_akun extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10;
	private JButton buttonlogin, buttonlogout,button1,button2,button3,button4,btn_input,btn_cari,btn_logout,btn_update;
	private JLabel lblnama,lblpw,lblJudul,lblperusahaan,lblwelcome,lblkode,lbl_username,lbl_alamat,lbl_no_hp,lbl_no_ktp,lbl_divisi,lbl_cari_akun;
	private static JPasswordField txtpw;
	private static JTextField txtnama,txtkode,txt_alamat,txt_divisi,txt_no_hp,txt_no_ktp,txt_username,txt_cari_akun;
	private static String vpassword,vmd5,vsha1,nama_login,username,nama_lengkap,alamat,no_ktp,divisi,no_hp,username_temu,username_update;
	private JLabel txtSHA1MD5,txtSHA1,txtMD5;
	static JFrame frame,frame_input_item,frame_menu_admin,frame_menu_item,frame_beranda,framelogin,frame_update_akun,frame_laporan;
	private static String[] data_dicari;
	private static JDialog dg; 
	
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_update_akun = new gui_update_akun();
			frame_update_akun.setVisible(true);
			
		
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil_nama_login(String nama)
	{
		
		nama_login=nama;
	}
	
	public static void cari_akun() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {

		username= txt_cari_akun.getText();
		
		
		
		data_dicari= entity_update_akun.cari_akun(username);
		
		username_temu =data_dicari[0];
		nama_lengkap=data_dicari[1];
		alamat=data_dicari[2];
		no_ktp=data_dicari[3];
		no_hp=data_dicari[4];
		divisi=data_dicari[5];
		
		txt_username.setText(username_temu);
		txtnama.setText(nama_lengkap);
		txt_alamat.setText(alamat);
		txt_no_ktp.setText(no_ktp);
		txt_no_hp.setText(no_hp);
		txt_divisi.setText(divisi);
		
		
		
		
		//System.out.println("Nilai field dari 1 column dan 1 row :" +obj1);
		}
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			 e.printStackTrace();
		}
		
	
	}
	
	
	public static Object GetData(Object model, int row_index, int col_index){
		  return ((DefaultTableModel) model).getValueAt(row_index, col_index);
		  }  
	
	public static void update_akun() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			  LocalDateTime now = LocalDateTime.now();
			String waktu = dtf.format(now);	
			
			username_update= txt_username.getText();
			nama_lengkap= txtnama.getText();
			alamat= txt_alamat.getText();
			no_ktp= txt_no_ktp.getText();
			divisi= txt_divisi.getText();
			no_hp= txt_no_hp.getText();
		
		boolean cek_input=ctrl_update_akun.cek_input(username,username_update,nama_lengkap,alamat,no_ktp,divisi,no_hp);
		
		if(cek_input==true)
		{
		
		
		boolean stok= entity_update_akun.update_akun(username,username_update,nama_lengkap,alamat,no_ktp,divisi,no_hp);
		
		
			if(cek_input&&stok==true)
			{
				JOptionPane.showMessageDialog(null, "Update AKUN sukses");
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Update akun gagal");
				
			}
		}
		
		else 
		{
			JOptionPane.showMessageDialog(null, "Kesalahan input data,Update Akun gagal");
			
		}
		
		
		
		//Object kode_barang = GetData(table_cari, 1, 0);
		
	

		//tampil_data_dicari= entity_update_item.cari_item(kode);
		//data_dicari= entity_update_item.cari_item(kode);

		// model.addRow(new Object[]{data_dicari[0], data_dicari[1], data_dicari[2],data_dicari[3],data_dicari[4]});
		
		
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		
	
	}
	
	
	@SuppressWarnings("resource")
	gui_update_akun() throws FileNotFoundException, SQLException{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setTitle("GUI UPDATE AKUN POS");
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
		panel9.setLayout(new FlowLayout());
		panel9.setBackground(new Color(0,255,255));
		
		panel10 = new JPanel();
		panel10.setLayout(new GridLayout(1,2));
		panel10.setBackground(new Color(0,255,255));
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU UPDATE AKUN");
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
	        dg = new JDialog(f , "Dialog Example", true);  
	        dg.setLayout( new BorderLayout() );  
	        JButton b = new JButton ("OK");  
	        b.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	               gui_update_akun.dg.setVisible(false);  
	            }  
	        });    
	        dg.add(new JLabel(about), BorderLayout.CENTER); 
	        dg.add(judul, BorderLayout.NORTH);
	        dg.add(nama, BorderLayout.SOUTH);
	        dg.setLocationByPlatform(true);
	        dg.setSize(600,600);    
	        dg.setLocationRelativeTo(null);
	        dg.setVisible(true);  
			
			gui_update_akun.dg.setVisible(true);  
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
		
		btn_update = new JButton("UPDATE");
		btn_update.setPreferredSize(new Dimension(100, 100));
		btn_update.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 try {
					update_akun();
				} catch (FileNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			  } 
			} );
		
		
		lbl_cari_akun = new JLabel("Cari Username");
		lbl_cari_akun.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_cari_akun.setVisible(true);
		
		txt_cari_akun = new JTextField();
		txt_cari_akun.setVisible(true);
		txt_cari_akun.setColumns(20);
		txt_cari_akun.setHorizontalAlignment(JTextField.CENTER);
		
		btn_cari = new JButton("Cari Akun");
		btn_cari.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cari.setVisible(true);
		btn_cari.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			
				  try {
					cari_akun();
				} 
				  catch (FileNotFoundException | SQLException | NullPointerException e1) 
				  {
					e1.printStackTrace();
				  }
				  } 
				} );
		
		lbl_username = new JLabel("Username");
		lbl_username.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_username.setVisible(true);
		
		txt_username = new JTextField();
		txt_username.setVisible(true);
		txt_username.setHorizontalAlignment(JTextField.CENTER);
		
		

		
		lblnama = new JLabel("Nama Lengkap");
		lblnama.setHorizontalAlignment(SwingConstants.LEFT);
		lblnama.setVisible(true);
		
		txtnama = new JTextField();
		txtnama.setVisible(true);
		txtnama.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_alamat = new JLabel("Alamat");
		lbl_alamat .setHorizontalAlignment(SwingConstants.LEFT);
		lbl_alamat .setVisible(true);
		
		txt_alamat  = new JTextField();
		txt_alamat .setVisible(true);
		txt_alamat .setHorizontalAlignment(JTextField.CENTER);
		
		lbl_no_ktp = new JLabel("No KTP");
		lbl_no_ktp.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_no_ktp.setVisible(true);
		
		txt_no_ktp = new JTextField();
		txt_no_ktp.setVisible(true);
		txt_no_ktp.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_no_hp = new JLabel("No Handphone");
		lbl_no_hp.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_no_hp.setVisible(true);
		
		txt_no_hp = new JTextField();
		txt_no_hp.setVisible(true);
		txt_no_hp.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_divisi = new JLabel("DIVISI");
		lbl_divisi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_divisi.setVisible(true);
		
		txt_divisi = new JTextField();
		txt_divisi.setVisible(true);
		txt_divisi.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		//         Menambah elemen-elemen ke Frame		
		
		
		panel10.add(lbl_cari_akun);
		panel10.add(txt_cari_akun);
		panel10.add(btn_cari);
		
		panel1.add(lbl_username);
		panel1.add(txt_username);
		panel1.add(lblnama);
		panel1.add(txtnama);
		panel1.add(lbl_alamat);
		panel1.add(txt_alamat);
		panel1.add(lbl_no_ktp);
		panel1.add(txt_no_ktp);
		panel1.add(lbl_divisi);
		panel1.add(txt_divisi);
		panel1.add(lbl_no_hp);
		panel1.add(txt_no_hp);
		
		
		
		panel7.add(btn_update);
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
		panel9.add(panel10);
		panel8.add(panel9,BorderLayout.NORTH);
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