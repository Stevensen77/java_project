import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;


public class entity_laporan {
	
	static String nama = null;
	static String kode=null;
	static String kuantitas=null;
	static String harga=null;
	static String tanggal_transaksi,str_no_transaksi,str_jumlah_barang,str_total_harga;
	static int total_baris,count, int_no_transaksi;
	//static String[] nama_barang;
	
	private static String[] kode_brg,harga_barang,total_bayar;

	static Object[] list,list_all;
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Jumlah"}, 0);
	static DefaultTableModel model2 = new DefaultTableModel(new String[]{"Tanggal_transaksi","No_Transaksi","Nama_item","Jumlah_item","Total_harga"}, 0);
	static JTable table = new JTable();
	static JTable table2 = new JTable();
	static String nama_barang;
	static String jumlah_barang ;
	static String total_harga ;
	static String no_transaksi ;
	static String list_semua ;
	static  ResultSet rs2,hasil,rs3;
	static int i=0;
	
	entity_laporan() throws FileNotFoundException, SQLException,NullPointerException
	
	{
	
	}
	
	public static String no_transaksi() throws SQLException
	{ 
	String no_transaksi_awal ,no_transaksi2 = null;
	int int_no_transaksi,no_transaksi_sudah_ada;
		

	 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	 hasil=statement.executeQuery("SELECT * FROM transaksi ORDER BY no_transaksi DESC LIMIT 1");
	 
	 hasil.next();
	 if (hasil.getRow()==1)
	 {
	 no_transaksi_awal = hasil.getString("no_transaksi");
	 
	 System.out.println(no_transaksi_awal);
	 
	 
	 int_no_transaksi=Integer.parseInt(no_transaksi_awal);
	 
	 
	
		 no_transaksi_sudah_ada = int_no_transaksi+1;
		 no_transaksi2 = Integer.toString(no_transaksi_sudah_ada);	
		 return no_transaksi2;
	 }
	 
	 if (hasil.getRow()==0)
	 {
		 int_no_transaksi=1;
		 no_transaksi2=Integer.toString(int_no_transaksi);		 
		 return no_transaksi2;
		 
	 }
	 
	return no_transaksi2;
		
		
		
		
	}
	
	
	
	public static Object[] cari_transaksi(String tanggal)
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
		table2.setModel(model2);
		
		
		try {
			
   	  		
			 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	         rs2=statement.executeQuery("select * from transaksi where tanggal_transaksi='"+tanggal+"'");
	         
	         
	         if(rs2.next()) 
         	{
				
	                
	                tanggal_transaksi = rs2.getString("tanggal_transaksi");
	                str_no_transaksi = rs2.getString("no_transaksi");
	                int_no_transaksi=Integer.parseInt(str_no_transaksi);
	                
	                System.out.println(int_no_transaksi);
	               
	                Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	                rs3=statement2.executeQuery("select * from transaksi_item where no_transaksi='"+int_no_transaksi+"'");
		           
			        
			        rs3.afterLast();
			         
					while(rs3.previous())
					{	
						
						
						 nama_barang=rs3.getString("nama_barang");
						//nama_barang = rs3.getString("nama_barang"); 
		               jumlah_barang=rs3.getString("jumlah_barang"); 
		               total_harga=rs3.getString("total_harga");
		               no_transaksi=rs3.getString("no_transaksi");
		               
		               total_baris = rs3.getRow();
						 System.out.println(total_baris);
		               
		               
		               model2.addRow(new Object[]{tanggal_transaksi,no_transaksi,nama_barang,jumlah_barang,total_harga,total_baris});
		               
		               
		               
		              return new Object[]{tanggal_transaksi,no_transaksi,nama_barang,jumlah_barang,total_harga,total_baris};
			            
		            	   
					 }
					

					 return new Object[]{tanggal_transaksi,no_transaksi,nama_barang,jumlah_barang,total_harga,total_baris};
	               
   
         	}
	         else {
	             JOptionPane.showMessageDialog(null, "Transaksi tidak ditemukan");
	          
	             
	             return new Object[]{tanggal_transaksi,no_transaksi,nama_barang,jumlah_barang,total_harga,total_baris};
	         	}
	     
		            
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari Transaksi!");
		}
		
		 return new Object[]{tanggal_transaksi,no_transaksi,nama_barang,jumlah_barang,total_harga};
		
	}
	
	

/*
	public static Object[] cari_item()
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
	
		
		try {
			

			 		Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		             rs3=statement.executeQuery("select * from transaksi_item where no_transaksi='"+int_no_transaksi+"'");
		             rs3.last(); 
			         total_baris = rs3.getRow();
		            
		                if(rs3.next()) 
		            	{
		               nama_barang[count] = rs3.getString("nama_barang"); 
		               jumlah_barang[count] = rs3.getString("jumlah_barang"); 
		               total_harga[count] = rs3.getString("total_harga");
		               no_transaksi[count] = rs2.getString("no_transaksi");
		
		               
			             System.out.println(rs3.getString("nama_barang"));
		            	}    
		   			 

		             return new Object[]{nama_barang, jumlah_barang,total_harga,no_transaksi,total_baris};
	               
   	
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari Transaksi!");
		}
		
		  return new Object[]{tanggal_transaksi,nama_barang, jumlah_barang,total_harga,no_transaksi,total_baris};
		
	}
	
	*/
	
	
}
