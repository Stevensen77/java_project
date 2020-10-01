import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class gui_transaksi_item extends JFrame implements ActionListener  {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10,panel11,panel12,panel13;
	private JButton button1,button2,button3,button4,btn_cari,btn_update,btn_bayar,btn_logout,btn_next;
	private static JButton btn_drop;
	private JLabel lbl_no_transaksi,lblJudul,lblperusahaan,lblwelcome,lblkode,lbl_tgl,lbl_user,lbl_jumlah,lbl_total,lbl_dibayar,
					lbl_kembali,lbl_kelompok,lbl_drop,lbl_jam;
	private static JTextField txtnama,txt_kode,txt_no_transaksi,txt_user,txt_tgl,txt_jumlah,txt_dibayar,txt_kembali,txt_drop,txt_jam;
	private static JTextArea txt_total;
	static JFrame frame,frame_transaksi_item,frame_menu_admin,frame_beranda,f,framelogin,frame_laporan;
	private static String nama_login;
	 JTable table;
	public static  JTable tampil,tampil_data_dicari,table_cari;
	static String[] data_dicari;
	static String a,b,c,d,e,kode,str_jumlah,waktu,waktu2,str_kode_angka;
	static boolean update;
	private static int total_belanja,bayar,input,kembali,count,jumlah_baris,total_belanja_baru;
	static String str_total_belanja,str_bayar,str_kembali,kode_barang,jumlah_barang,str_no_transaksi,nama_barang2,jumlah_barang2,total_harga2,harga_barang2,kode_drop,kode_barang2,
					no_transaksi,str_total_harga,kode_huruf;
	private static ArrayList<String> nama_barang,kode_brg,harga_barang,jumlah_brg,total_harga,total_bayar;
	
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Jumlah pesan","Total"}, 0);
	 private static JDialog dg;  
	
	
	public static void main(String[] args) throws FileNotFoundException {
		try{
			
			
			frame_transaksi_item = new gui_transaksi_item();
			frame_transaksi_item.setVisible(true);
			
			tampil_no_transaksi();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void tampil_no_transaksi() throws SQLException
	{
	
		
		no_transaksi=entity_transaksi_item.no_transaksi();
		System.out.println(no_transaksi);
		
		txt_no_transaksi.setText(no_transaksi);
		
		
	}
	
	public static void tampil_nama_login(String nama) 
	{
		nama_login=nama;
		
	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		waktu = dtf.format(now);
		

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now2 = LocalDateTime.now();
		waktu2 = dtf2.format(now);
		
	}

	
	
	 
	
	public static void cari_item() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {
			
		
		
			kode= txt_kode.getText();
			
			kode_barang=txt_kode.getText();
			
			kode_huruf = kode.substring(0,3);
			//kode_angka=Integer.parseInt(kode);
			str_kode_angka = kode.substring(3,5);
			jumlah_barang=txt_jumlah.getText();
			
		
		//model.setRowCount(0);
		data_dicari= entity_transaksi_item.cari_item(kode_huruf,str_kode_angka);
		boolean cek_input=ctrl_transaksi_item.cek_input(kode_barang,jumlah_barang);
		
		if(cek_input==true)
		{
			if(!data_dicari[0].equals("salah"))
			{
				
				str_jumlah= txt_jumlah.getText();
				int jumlah=Integer.parseInt(str_jumlah);
			
					int jumlah_db=Integer.parseInt(data_dicari[3]);
			
			
					if(!(jumlah>=jumlah_db))
					{
					int harga=Integer.parseInt(data_dicari[2]);
					
					int total=jumlah*harga;
			
					 
					
					
			
					 model.addRow(new Object[]{data_dicari[0], data_dicari[1], data_dicari[2],jumlah,total});
					 
					 total_belanja+=total;
					 str_total_belanja=Integer.toString(total_belanja);
					 
					 txt_total.setText(str_total_belanja);
					 
					 
					 nama_barang = new ArrayList<String>();
					 kode_brg = new ArrayList<String>();
					 harga_barang = new ArrayList<String>();
					 jumlah_brg = new ArrayList<String>();
					 total_harga = new ArrayList<String>();
					 total_bayar = new ArrayList<String>();
					 
					 jumlah_baris=model.getRowCount();
					 
					 System.out.println(jumlah_baris);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Jumlah Pesanan melebihi stok!");	
					}
				 
				}
		}
	
		}
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			 e.printStackTrace();
		}
		
	
	}
	
	
	public static Object GetData(Object model, int row_index, int col_index){
		  return ((DefaultTableModel) model).getValueAt(row_index, col_index);
		  }  
	
	
	
	
	public static void input_transaksi() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {
		
			
			kode_barang=txt_kode.getText();
			jumlah_barang=txt_jumlah.getText();
			no_transaksi=txt_no_transaksi.getText();
			
		
			
			boolean cek_input=ctrl_transaksi_item.cek_input(kode_barang,jumlah_barang);
			
			if(cek_input==true)
			{
				
				
				 for(count = 0; count < model.getRowCount(); count++)
				 {
				      nama_barang.add(model.getValueAt(count, 0).toString());
				      kode_brg.add(model.getValueAt(count, 1).toString());
				      harga_barang.add(model.getValueAt(count, 2).toString());
				      jumlah_brg.add(model.getValueAt(count, 3).toString());
				      total_harga.add(model.getValueAt(count, 4).toString());
				      
				      
				      nama_barang2=nama_barang.get(count);
				   
						
				      
				 }
				 
				
			System.out.println("Nilai field dari 1 column dan 1 row :" +nama_barang2);
			update= entity_transaksi_item.input_transaksi(nama_barang,kode_brg,harga_barang,jumlah_brg,total_harga,waktu,waktu2,
					nama_login,jumlah_baris,no_transaksi);
	
			
				if(cek_input&&update==true)
				{
					JOptionPane.showMessageDialog(null, "Transaksi sukses");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Transaksi Masukan ke Database gagal");
				}
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Kesalahan input data,update gagal");	
			}
		

		
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		
	
	}
	

	@SuppressWarnings("resource")
	gui_transaksi_item() throws FileNotFoundException, SQLException{		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MENU TRANSAKSI PEMBELIAN");
		setSize(850,650);
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
		panel7.setLayout(new GridLayout(1,1));
		panel7.setBackground(new Color(0,255,255));
		
		panel8 = new JPanel();
		panel8.setLayout(new BorderLayout());
		panel8.setBackground(new Color(0,255,255));
		
		panel9 = new JPanel();
		panel9.setLayout(new GridLayout(4,2));
		panel9.setBackground(new Color(0,255,255));
		
		panel10 = new JPanel();
		panel10.setLayout(new GridLayout(3,2));
		panel10.setBackground(new Color(0,255,255));
		
		panel11 = new JPanel();
		panel11.setLayout(new BorderLayout());
		panel11.setBackground(new Color(0,255,255));
		
		panel12 = new JPanel();
		panel12.setLayout(new FlowLayout());
		panel12.setBackground(new Color(0,255,255));
		
		panel13 = new JPanel();
		panel13.setLayout(new GridLayout(1,3));
		panel13.setBackground(new Color(0,255,255));
		
		

		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU TRANSAKSI");
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
		TitledBorder keterangan4 = BorderFactory.createTitledBorder(blackline,"TRANSACTION");
		
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
		button1.setEnabled(false);
		
		button2 = new JButton("");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/transaksi.png"));
		    button2.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		keterangan4.setTitleJustification(TitledBorder.CENTER);
		button2.setBorder(keterangan4);
		button2.setPreferredSize(new Dimension(100, 100));
		button2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				 frame_transaksi_item = null ;
					try {
						frame_transaksi_item= new gui_transaksi_item();
						gui_transaksi_item.tampil_no_transaksi();
						
					
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frame_transaksi_item.setVisible(true);
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
		button3.setEnabled(false);
		
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
	               gui_transaksi_item.dg.setVisible(false);  
	            }  
	        });    
	        dg.add(new JLabel(about), BorderLayout.CENTER); 
	        dg.add(judul, BorderLayout.NORTH);
	        dg.add(nama, BorderLayout.SOUTH);
	        dg.setLocationByPlatform(true);
	        dg.setSize(600,600);    
	        dg.setLocationRelativeTo(null);
	        dg.setVisible(true);  
			
			gui_transaksi_item.dg.setVisible(true);  
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
		
		btn_next = new JButton("Next Order");
		
		btn_next.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				
					try 
					{
						model.setRowCount(0);
						 int no_transaksi= Integer.parseInt(txt_no_transaksi.getText());
				    	 int no_transaksi_baru=no_transaksi+1;
				    	 str_no_transaksi=Integer.toString(no_transaksi_baru);
				    	 txt_no_transaksi.setText(str_no_transaksi);
				    	total_belanja=0;
				    	str_total_belanja=Integer.toString(total_belanja);
				    	txt_total.setText(str_total_belanja);
				    	
				    	JOptionPane.showMessageDialog(null,"Transaksi Selesai, Memuat transaksi berikutnya");
						   
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
			  } 
			} );
		
		
		lbl_no_transaksi = new JLabel("No Transaksi");
		lbl_no_transaksi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_no_transaksi.setVisible(true);
		
		txt_no_transaksi = new JTextField("");
		txt_no_transaksi.setVisible(true);
		txt_no_transaksi.setHorizontalAlignment(JTextField.CENTER);

		lbl_user = new JLabel("User :");
		lbl_user.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_user.setVisible(true);
		
		txt_user = new JTextField(nama_login);
		txt_user.setVisible(true);
		txt_user.setHorizontalAlignment(JTextField.CENTER);

		lbl_tgl = new JLabel("Tanggal Transaksi :");
		lbl_tgl.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tgl.setVisible(true);
		
		txt_tgl= new JTextField(waktu);
		txt_tgl.setVisible(true);
		txt_tgl.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_jam = new JLabel("Waktu Transaksi :");
		lbl_jam.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_jam.setVisible(true);
		
		txt_jam= new JTextField(waktu2);
		txt_jam.setVisible(true);
		txt_jam.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		//tampil.setColumnIdentifiers(columnNames);
		
		JTable table_cari = new JTable();
		table_cari.setModel(model);
		table_cari.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_cari.setFillsViewportHeight(true);
		table_cari.setRowHeight(30);
		
		TableColumnModel columnModel = table_cari.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(90);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(10);
		columnModel.getColumn(3).setPreferredWidth(20);
		//JTable(Object[][] rowData, Object[] columnNames);
		

		
		
		lblkode = new JLabel("Input Kode Barang");
		lblkode.setHorizontalAlignment(SwingConstants.LEFT);
		lblkode.setVisible(true);
		
		txt_kode = new JTextField();
		txt_kode.setVisible(true);
		txt_kode.setColumns(6);
		txt_kode.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_jumlah = new JLabel("Jumlah =");
		lbl_jumlah.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_jumlah.setVisible(true);
		
		txt_jumlah = new JTextField();
		txt_jumlah.setVisible(true);
		txt_jumlah.setColumns(3);
		txt_jumlah.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_total = new JLabel("TOTAL =");
		Font font3 = lbl_total.getFont();
		font3 = font3.deriveFont(font3.getSize() * 1.5f);
		lbl_total.setFont(font3);
		lbl_total.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_total.setVisible(true);
		
		txt_total = new JTextArea ("0.00",2, 15);
		txt_total.setVisible(true);
		Font font6 = txt_total.getFont();
		font6 = font6.deriveFont(font6.getSize() * 1.7f);
		txt_total.setFont(font6);
		txt_total.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		lbl_dibayar = new JLabel("BAYAR =");
		Font font4 = lbl_dibayar.getFont();
		font4 = font4.deriveFont(font4.getSize() * 1.5f);
		lbl_dibayar.setFont(font4);
		lbl_dibayar.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dibayar.setVisible(true);
		
		lbl_drop = new JLabel("Drop Item");
		lbl_drop.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_drop.setVisible(true);
		
		txt_drop = new JTextField();
		txt_drop.setVisible(true);
		txt_drop.setColumns(6);
		txt_drop.setHorizontalAlignment(JTextField.CENTER);
		
		btn_drop = new JButton("DROP Item terplih");
		btn_drop.setVisible(true);
		btn_drop.addActionListener(new ActionListener() { 
		

				@Override
				public void actionPerformed(ActionEvent e) {
					 if (model.getRowCount() > 0 && table_cari.getSelectedRow() != -1 )
			          {	
							int item_terpilih=table_cari.getSelectedRow();
						 	 System.out.println(item_terpilih+"ini harga baru");
						 	 
						 	 
						  total_bayar.add(model.getValueAt(item_terpilih, 4).toString());
						      
			              model.removeRow(table_cari.getSelectedRow());
			          
					 
					     str_total_belanja=total_bayar.get(0);
					      item_terpilih=Integer.parseInt(str_total_belanja);
					     
					 
					 	total_belanja=total_belanja-item_terpilih;
				    	str_total_belanja=Integer.toString(total_belanja);
				    	txt_total.setText(str_total_belanja);
			          }
					
				}
			
				  } 
				 );
		
		
		btn_bayar = new JButton("BAYAR");
		btn_bayar.setVisible(true);
		Font font7 = btn_bayar.getFont();
		font7 = font7.deriveFont(font7.getSize() * 1.5f);
		btn_bayar.setFont(font7);
		btn_bayar.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  str_bayar=JOptionPane.showInputDialog("Jumlah Bayar =");  
				  bayar=Integer.parseInt(str_bayar);
				  JOptionPane.showOptionDialog(null,"Uang Dibayar= "+bayar+"\nCash",null,JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null);
				 
				if(input == JOptionPane.OK_OPTION)
				  {
				     kembali=bayar-total_belanja;
				     str_kembali=Integer.toString(kembali);
				     txt_kembali.setText(str_kembali);
				     
				     try {
				    	
				    	
						input_transaksi();
						
					} catch (ArrayIndexOutOfBoundsException | FileNotFoundException | NullPointerException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				  }
				  } 
				} );
		
		
		
		lbl_kembali = new JLabel("KEMBALI =");
		Font font5 = lbl_kembali.getFont();
		font5 = font5.deriveFont(font5.getSize() * 1.5f);
		lbl_kembali.setFont(font3);
		lbl_kembali.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_kembali.setVisible(true);
		
		txt_kembali = new JTextField("0.00");
		txt_kembali.setVisible(true);
		Font font8 = txt_kembali.getFont();
		font8 = font8.deriveFont(font8.getSize() * 1.7f);
		txt_kembali.setFont(font8);
		txt_kembali.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txt_kembali.setHorizontalAlignment(JTextField.CENTER);
		
		lbl_kelompok = new JLabel("Steven - Gusti - Panji");
		Font font2 = lbl_kelompok.getFont();
		font2 = font2.deriveFont(font2.getSize() * 1.5f);
		lbl_kelompok.setFont(font2);
		lbl_kelompok.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kelompok.setVisible(true);
		
		btn_cari = new JButton("Cari item");
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
		panel9.add(lbl_no_transaksi);
		panel9.add(txt_no_transaksi);
		panel9.add(lbl_user);
		panel9.add(txt_user);
		panel9.add(lbl_tgl);
		panel9.add(txt_tgl);
		panel9.add(lbl_jam);
		panel9.add(txt_jam);
		
		panel6.add(lblkode);
		panel6.add(txt_kode);
		panel6.add(lbl_jumlah);
		panel6.add(txt_jumlah);
		panel6.add(btn_cari);
		
		
		panel10.add(lbl_total);
		panel10.add(txt_total);
		panel10.add(lbl_dibayar);
		panel10.add(btn_bayar);
		panel10.add(lbl_kembali);
		panel10.add(txt_kembali);
		
		panel12.add(btn_next);
		panel12.add(btn_drop);
		
		panel13.add(panel6);
		panel13.add(panel12);
		
		JScrollPane scrollpane = new JScrollPane(table_cari);
		
		
		panel7.add(scrollpane);
		
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
		c.add(lbl_kelompok, BorderLayout.SOUTH);
		
		panel1.add(panel9, BorderLayout.WEST);
		//panel1.add(panel6, BorderLayout.SOUTH);
		panel2.add(panel3, BorderLayout.WEST);
		panel8.add(panel1,BorderLayout.NORTH);
		panel8.add(panel7,BorderLayout.CENTER);
		panel8.add(panel11,BorderLayout.SOUTH);
		panel11.add(panel10,BorderLayout.WEST);
		panel1.add(panel13,BorderLayout.SOUTH);
		
		
	}
	
	

	


	public void actionPerformed(ActionEvent event){
		
		
	
		
		}
	
}