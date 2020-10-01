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
import java.util.ArrayList;



public class gui_update_item extends JFrame implements ActionListener  {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10;
	private JButton button1,button2,button3,button4,btn_cari,btn_update,btn_logout;
	private JLabel lblnama,lblnama2,lblpw,lblJudul,lblperusahaan,lblwelcome,lblkode,lblkuantitas,lblharga,lblkategori,
	lbl_kosong2,lbl_kosong,lbl_kosong3,lbl_kosong4;

	private static JTextField txtnama,txtkode,txtharga,txtkategori,txtkuantitas;

	static JFrame frame,frame_update_item,frame_menu_admin,framelogin,frame_laporan;
	private static String nama_login;
	 JTable table;
	public static  JTable tampil,tampil_data_dicari,table_cari;
	static String[] data_dicari;
	static String a,b,c,d,e;
	static boolean update;

	
	String columnNames[] = {"Nama barang","Kode barang","Jumlah","Harga","Kategori"};
	String data[]= { " ", " ", " ", " ", " " };
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Kategori"}, 0);
	private static JDialog dg; 
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_update_item = new gui_update_item();
			frame_update_item.setVisible(true);
			
			
			
		

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil_nama_login(String nama)
	{
		
		nama_login=nama;
	}

	
	
	public static void tampil_item() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException
	{	
		
		String nama;
		String kode= null;
		String harga = null;
		String kategori= null;
		String kuantitas = null ;
		
		try {
		
		tampil=entity_update_item.menampilkan_item();
		
		
		
		//DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Jumlah","Harga","Kategori"}, 0);
		//model.addRow(new String[] {nama, kode, harga,kategori,kuantitas});
		
		//Object [][] data= { {tampil[0]}, {tampil[1]}, {tampil[2]}, {tampil[3]}, {tampil[4]} };
		 //System.out.println(a);
		}
		catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("The index used is out of the bounds of array.\n"
                    + "Deal with it.");
        } 
		
		
	  	/*	
	boolean a=entity_update_item.update_item(nama, vpassword,kode,harga2,kategori,kuantitas2);
	boolean b=ctrl_update_item.cek_input(nama, kode, kuantitas2);
		if(a&&b)
		{
			JOptionPane.showMessageDialog(null, "input sukses");
			
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Login gagal");
			
		}
		*/
		
	}
	
	
		  
	
	public static void cari_item() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {

		String kode= txtkode.getText();
		
		
		
		model.setRowCount(0);
		data_dicari= entity_update_item.cari_item(kode);

		 model.addRow(new Object[]{data_dicari[0], data_dicari[1], data_dicari[2],data_dicari[3]});
		 
		//Object obj1 = GetData(table_cari, 0, 0);
		//System.out.println("Nilai field dari 1 column dan 1 row :" +obj1);
		}
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			 e.printStackTrace();
		}
		
	
	}
	
	
	public static Object GetData(Object model, int row_index, int col_index){
		  return ((DefaultTableModel) model).getValueAt(row_index, col_index);
		  }  
	
	public static void update_item() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {
			
		Object nama_barang= GetData(model, 0, 0);
		Object kode_barang= GetData(model, 0, 1);
		Object harga_barang= GetData(model, 0, 2);
		Object kategori_barang= GetData(model, 0, 3);
		
		boolean cek_input=ctrl_update_item.cek_input(nama_barang, kode_barang, harga_barang, kategori_barang);
		
		if(cek_input==true)
		{
		update= entity_update_item.update_item(nama_barang, kode_barang, harga_barang, kategori_barang);
		
			if(cek_input&&update==true)
			{
				JOptionPane.showMessageDialog(null, "Update sukses");
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Update Item gagal");
				
			}
		}
		
		else 
		{
			JOptionPane.showMessageDialog(null, "Kesalahan input data,update gagal");
			
		}
		
		
		
		//Object kode_barang = GetData(table_cari, 1, 0);
		
		System.out.println("Nilai field dari 1 column dan 1 row :" +nama_barang);	

		//tampil_data_dicari= entity_update_item.cari_item(kode);
		//data_dicari= entity_update_item.cari_item(kode);

		// model.addRow(new Object[]{data_dicari[0], data_dicari[1], data_dicari[2],data_dicari[3],data_dicari[4]});
		
		
		}
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			 e.printStackTrace();
		}
		
	
	}
	

	@SuppressWarnings("resource")
	gui_update_item() throws FileNotFoundException, SQLException{		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Update Item POS");
		setSize(850,650);
		setLocationRelativeTo(null);
	
		
		
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		

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
		panel7.setLayout(new GridLayout(3,1));
		panel7.setBackground(new Color(0,255,255));
		
		panel8 = new JPanel();
		panel8.setLayout(new BorderLayout());
		panel8.setBackground(new Color(0,255,255));
		
		panel9 = new JPanel();
		panel9.setLayout(new GridLayout(1,2));
		panel9.setBackground(new Color(0,255,255));
		
		panel10 = new JPanel();
		panel10.setLayout(new FlowLayout());
		panel10.setBackground(new Color(0,255,255));
		

		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU UPDATE ITEM");
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
	        dg = new JDialog(f , "Dialog Example", true);  
	        dg.setLayout( new BorderLayout() );  
	        JButton b = new JButton ("OK");  
	        b.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	               gui_update_item.dg.setVisible(false);  
	            }  
	        });    
	        dg.add(new JLabel(about), BorderLayout.CENTER); 
	        dg.add(judul, BorderLayout.NORTH);
	        dg.add(nama, BorderLayout.SOUTH);
	        dg.setLocationByPlatform(true);
	        dg.setSize(600,600);    
	        dg.setLocationRelativeTo(null);
	        dg.setVisible(true);  
			
			gui_update_item.dg.setVisible(true);  
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
		
		btn_update = new JButton("Update Data");
		btn_update.setPreferredSize(new Dimension(150, 50));
		btn_update.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				 try {
					update_item();
				} catch (ArrayIndexOutOfBoundsException | FileNotFoundException | NullPointerException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  } 
			} );
		
		
		lblnama2 = new JLabel("Search Nama Barang");
		lblnama2.setHorizontalAlignment(SwingConstants.LEFT);
		lblnama2.setVisible(true);
		
		
		
		tampil_item();
		
		
		//tampil.setColumnIdentifiers(columnNames);
		JTable table_cari = new JTable();
		table_cari.setModel(model);
		table_cari.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_cari.setFillsViewportHeight(true);
		//JTable(Object[][] rowData, Object[] columnNames);
		
		lbl_kosong3 = new JLabel("");
		lbl_kosong3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_kosong3.setVisible(true);
		
		lbl_kosong4 = new JLabel("");
		lbl_kosong4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_kosong4.setVisible(true);
		
		lblkode = new JLabel("Input Kode Barang");
		lblkode.setHorizontalAlignment(SwingConstants.LEFT);
		lblkode.setVisible(true);
		
		txtkode = new JTextField();
		txtkode.setVisible(true);
		txtkode.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_kosong = new JLabel("");
		lbl_kosong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_kosong.setVisible(true);
		
		btn_cari = new JButton("Cari Barang");
		btn_cari.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cari.setVisible(true);
		btn_cari.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			
				  try {
					cari_item();
				} 
				  catch (FileNotFoundException | SQLException | NullPointerException e1) 
				  {
					e1.printStackTrace();
				  }
				  } 
				} );
		
		
		
		
		
		
		//         Menambah elemen-elemen ke Frame		
		panel9.add(txtkode);
		panel9.add(btn_cari);
		panel1.add(lbl_kosong3);
		panel1.add(lbl_kosong4);
		panel1.add(lblkode);
		panel1.add(panel9);
		panel1.add(lbl_kosong);
		
		
		
		panel7.add(new JScrollPane(table_cari));
		panel7.add(panel10);
		panel10.add(btn_update);
		panel7.add(new JScrollPane(tampil));
		
		
		
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
		panel8.add(panel1,BorderLayout.NORTH);
		panel8.add(panel7,BorderLayout.CENTER);
	}
	
	

	


	public void actionPerformed(ActionEvent event){
		
		
		
		if(event.getSource() == button2){
			
			
		    }
		
		
		}
	
}