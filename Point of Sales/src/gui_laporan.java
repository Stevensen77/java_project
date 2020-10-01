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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



public class gui_laporan extends JFrame implements ActionListener  {
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5,panel6;
	private static JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel13;
	private JButton button1,button2,button3,button4,btn_cari,btn_update,btn_bayar,btn_logout,btn_next;
	private static JButton btn_drop;
	private JLabel lbl_no_transaksi,lblJudul,lblperusahaan,lblwelcome,lbl_tanggal,lbl_tgl,lbl_user;
	private static JLabel lbl_jumlah_pemasukan;
	private JLabel lbl_total;
	private static JLabel lbl_jumlah_transaksi;
	private JLabel lbl_kembali;
	private JLabel lbl_kelompok;
	private JLabel lbl_txt_transaksi;
	private JLabel lbl_txt_pemasukan;
	private static JTextField txtnama,txt_no_transaksi,txt_user,txt_tgl,txt_jumlah,txt_dibayar,txt_kembali,txt_drop;
	private static JTextArea txt_total;
	static JFrame frame,frame_transaksi_item,frame_menu_admin,frame_beranda,f,framelogin,frame_laporan;
	private static String nama_login;
	 JTable table;
	public static  JTable tampil,tampil_data_dicari,table_cari;
	static String data_dicari;
	static String a,b,c,d,e,kode,str_jumlah,waktu;
	static boolean update;
	private static int no_transaksi,jumlah_baris,jumlah_barang_today,total_harga_today,total_harga_item,count,total_belanja,
				int_total_harga,i,total_baris,int_total_pemasukan;
	
	static String str_total_belanja,str_bayar,str_kembali,kode_barang,jumlah_barang,str_no_transaksi,nama_barang2,
				jumlah_barang2,total_harga2,harga_barang2,kode_drop,kode_barang2,total_harga,
				str_total_harga,str_jumlah_baris,str_nama_barang,str_jumlah_barang,str_tanggal_transaksi,nama_barang,total_harga_hasil,total_pemasukan;
	private static String[] nama_barang_array,harga_barang,jumlah_barang_array,total_harga_array,total_bayar,no_transaksi_array;
	static String total_harga_table;
	
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Tanggal_transaksi","No_Transaksi","Nama_item","Jumlah_item","Total_harga"}, 0);
	 private static JDialog dg;  
	 private static JDatePickerImpl datePicker;
	 static Object[] data_dicari_item;
	 static Object baris_hasil;
	 static JScrollPane scrollpane,scrollpane2;
	 static ResultSet rs2,rs3;
	 
	
	public static void main(String[] args) throws FileNotFoundException {
		try{

			frame_laporan= new gui_laporan();
			frame_laporan.setVisible(true);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void tampil_nama_login(String nama) 
	{
		nama_login=nama;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		waktu = dtf.format(now);	
		
	}

	
	
	
	
	 
	
	public static void cari_transaksi() throws FileNotFoundException, SQLException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		try {
			
			i=0;
			int_total_pemasukan=0;
			
			Date tanggal_transaksi = (Date) datePicker.getModel().getValue();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String tanggal_laporan = sdf.format(tanggal_transaksi);
			
			
			try {
				
				model.setRowCount(0);
	   	  		
				 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		         rs2=statement.executeQuery("select * from transaksi where tanggal_transaksi='"+tanggal_laporan+"'");
		         
		         
		         while(rs2.next()) 
	         	{
					
		                
		                String tanggal_transaksi_db = rs2.getString("tanggal_transaksi");
		                
		                String waktu_transaksi_db = rs2.getString("waktu_transaksi");
		                String str_no_transaksi = rs2.getString("no_transaksi");
		                int int_no_transaksi=Integer.parseInt(str_no_transaksi);
		                
		                System.out.println(int_no_transaksi);
		               
		                Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		                rs3=statement2.executeQuery("select * from transaksi_item where no_transaksi='"+int_no_transaksi+"'");
			           
				        
				       // rs3.afterLast();
				         
						while(rs3.next())
						{	
							i++;
					          
							nama_barang=rs3.getString("nama_barang");
							//nama_barang = rs3.getString("nama_barang"); 
			               jumlah_barang=rs3.getString("jumlah_barang"); 
			               String total_harga=rs3.getString("total_harga");
			               String no_transaksi=rs3.getString("no_transaksi");
			               
			             
			               
			               model.addRow(new Object[]{tanggal_laporan+" - "+waktu_transaksi_db,no_transaksi,nama_barang,jumlah_barang,total_harga});
			               total_baris = i;
			             
			               
			               System.out.println("Total baris:"+total_baris+total_harga);
			             
			               
			               int_total_harga=Integer.parseInt(total_harga);
			               int_total_pemasukan+=int_total_harga;

						 }
						  total_pemasukan=Integer.toString(int_total_pemasukan);
						
	         	}
		        
		       
			            
			     
		     
			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
			    JOptionPane.showMessageDialog(null, "GAGAL mencari Transaksi!");
			}
			

		
		
		
		str_jumlah_baris=Integer.toString(total_baris);
		
		
		 lbl_jumlah_transaksi.setText(str_jumlah_baris+"  Order");
		 lbl_jumlah_pemasukan.setText("Rp "+total_pemasukan+",00");
		 
		
		 /*
		scrollpane2 = new JScrollPane(data_dicari_item);
		 panel7.add(scrollpane2);
		 */
	
		boolean cek_input=ctrl_laporan.cek_input(tanggal_laporan);
		

		}
	
		
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			 e.printStackTrace();
		}
		
	
	}
	
	
	public static Object GetData(Object model, int row_index, int col_index){
		  return ((DefaultTableModel) model).getValueAt(row_index, col_index);
		  }  
	
	
	
	

	@SuppressWarnings("resource")
	gui_laporan() throws FileNotFoundException, SQLException{		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MENU LAPORAN TRANSAKSI");
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
		panel9.setLayout(new GridLayout(2,2));
		panel9.setBackground(new Color(0,255,255));
		
		panel10 = new JPanel();
		panel10.setLayout(new GridLayout(2,2));
		panel10.setBackground(new Color(0,255,255));
		
		panel11 = new JPanel();
		panel11.setLayout(new BorderLayout());
		panel11.setBackground(new Color(0,255,255));
		
	
		
		panel13 = new JPanel();
		panel13.setLayout(new FlowLayout());
		panel13.setBackground(new Color(0,255,255));
		
		

		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi username");
		TitledBorder titlepw = BorderFactory.createTitledBorder(blackline,"Isi password");

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("LAPORAN TRANSAKSI");
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
		
		UtilDateModel datemodel = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Hari");
		p.put("text.month", "Bulan");
		p.put("text.year", "Tahun");
		JDatePanelImpl datePanel = new JDatePanelImpl(datemodel, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		
		
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
				  JFrame frameRegister = null;
					try {
						frameRegister = new beranda();
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					frameRegister.setVisible(true);
				
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
	               gui_laporan.dg.setVisible(false);  
	            }  
	        });    
	        dg.add(new JLabel(about), BorderLayout.CENTER); 
	        dg.add(judul, BorderLayout.NORTH);
	        dg.add(nama, BorderLayout.SOUTH);
	        dg.setLocationByPlatform(true);
	        dg.setSize(600,600);    
	        dg.setLocationRelativeTo(null);
	        dg.setVisible(true);  
			
			gui_laporan.dg.setVisible(true);  
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
						JFrame frame_beranda= new beranda();
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					framelogin.setVisible(true);
					
					dispose();
					frame_beranda.dispose();
				
			  } 
			} );
		
	
		
		
		

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
		
		
		
		//tampil.setColumnIdentifiers(columnNames);
		
		JTable table_cari = new JTable();
		table_cari.setModel(model);
		table_cari.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_cari.setFillsViewportHeight(true);
		table_cari.setRowHeight(30);
		
		TableColumnModel columnModel = table_cari.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(30);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(30);
		columnModel.getColumn(3).setPreferredWidth(20);
		columnModel.getColumn(4).setPreferredWidth(20);
		
		//JTable(Object[][] rowData, Object[] columnNames);
		

		
		
		lbl_tanggal = new JLabel("Pilih tanggal Transaksi");
		lbl_tanggal.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tanggal.setVisible(true);
		
		
		
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

		lbl_txt_transaksi = new JLabel("Jumlah Transaksi    =");
		Font font4 = lbl_txt_transaksi.getFont();
		font4 = font4.deriveFont(font4.getSize() * 1.5f);
		lbl_txt_transaksi .setFont(font4);
		lbl_txt_transaksi .setHorizontalAlignment(SwingConstants.LEFT);
		lbl_txt_transaksi .setVisible(true);
		
		lbl_jumlah_transaksi = new JLabel("00");
		Font font5 = lbl_jumlah_transaksi .getFont();
		font5 = font5.deriveFont(font5.getSize() * 1.5f);
		lbl_jumlah_transaksi.setFont(font5);
		lbl_jumlah_transaksi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_jumlah_transaksi.setVisible(true);
		
		lbl_txt_pemasukan = new JLabel("Jumlah Pemasukan =");
		Font font7 = lbl_txt_pemasukan.getFont();
		font7 = font7.deriveFont(font7.getSize() * 1.5f);
		lbl_txt_pemasukan.setFont(font7);
		lbl_txt_pemasukan.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_txt_pemasukan.setVisible(true);
		
		lbl_jumlah_pemasukan = new JLabel("00");
		Font font9 = lbl_jumlah_pemasukan.getFont();
		font9 = font9.deriveFont(font9.getSize() * 1.5f);
		lbl_jumlah_pemasukan.setFont(font9);
		lbl_jumlah_pemasukan.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_jumlah_pemasukan.setVisible(true);
		
		
		

				
		lbl_kelompok = new JLabel("Steven - Gusti - Panji");
		Font font2 = lbl_kelompok.getFont();
		font2 = font2.deriveFont(font2.getSize() * 1.5f);
		lbl_kelompok.setFont(font2);
		lbl_kelompok.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kelompok.setVisible(true);
		
		btn_cari = new JButton("Cari Transaksi");
		btn_cari.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cari.setVisible(true);
		btn_cari.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			
				  try {
					 
					cari_transaksi();
					
				} 
				  catch (FileNotFoundException | SQLException | NullPointerException e1) 
				  {
					e1.printStackTrace();
				  }
				  } 
				} );
		
		
		
		
		
		
		//         Menambah elemen-elemen ke Frame		

		panel9.add(lbl_user);
		panel9.add(txt_user);
		panel9.add(lbl_tgl);
		panel9.add(txt_tgl);
		
		panel6.add(lbl_tanggal);
		panel6.add(datePicker);
		panel6.add(btn_cari);
		
		panel10.add(lbl_txt_transaksi);
		panel10.add(lbl_jumlah_transaksi);
		panel10.add(lbl_txt_pemasukan);
		panel10.add(lbl_jumlah_pemasukan);
		
		//panel12.add(datePicker);
		
		panel13.add(panel6);
	
		
		scrollpane = new JScrollPane(table_cari);
		
		
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