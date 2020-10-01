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


public class entity_transaksi_item {
	
	static String nama = null;
	static String kode=null;
	static String kuantitas=null;
	static String harga=null;
	static String nama_barang,kode_barang,str_harga_barang,str_total_harga,str_jumlah_barang,kode_huruf,str_kode_angka;
	static int harga_barang,total_harga,jumlah_barang,count,jumlah_akhir,jumlah_awal;
	
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Jumlah"}, 0);
	static DefaultTableModel model2 = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Jumlah"}, 0);
	
	static JTable table = new JTable();
	static JTable table2 = new JTable();
	static  ResultSet rs2,hasil;
	
	
	entity_transaksi_item() throws FileNotFoundException, SQLException,NullPointerException
	
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
	
	
	
	public static String[] cari_item(String kode_huruf,String kode_angka)
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
	
		table2.setModel(model2);
		
		ArrayList<Object[]> sets = new ArrayList<Object[]>();
		
		 nama="";
        kuantitas="";
		
		try {
			
   	  		
			 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	         rs2=statement.executeQuery("select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+kode_angka+"'");
	       
	            if(rs2.next()) 
	            	{
	                nama = rs2.getString("nama");             
	                kuantitas = rs2.getString("kuantitas");
	                kode_huruf = rs2.getString("kode_huruf");
	                kode_angka = rs2.getString("kode_angka");
	                harga = rs2.getString("harga");
	                
	                jumlah_awal=Integer.parseInt(kuantitas);
	  
	                sets.add(new String[]{nama,kode,harga,kuantitas});
	                model2.addRow(new Object[]{nama,kode,harga,kuantitas});
	                
	                kode=kode_huruf+kode_angka;
	                
	                return new String[] {nama,kode,harga,kuantitas};
	   		     
	            
					}
	            else {
		             JOptionPane.showMessageDialog(null, "Item tidak ditemukan");
		             kode="";  
		             
		             return new String[] {"salah","salah","salah"};
		         	}
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari item!");
		}
		 return new String[] {nama,kode,harga,kuantitas};
		
	}
	

	public static boolean input_transaksi(ArrayList<String> nama, ArrayList<String> kode,ArrayList<String> harga, ArrayList<String> jumlah,
			ArrayList<String> total, String waktu,String waktu2,String nama_login,int jumlah_baris,String no_transaksi)
	
	{
		
	
		try {
			Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
			 statement2.executeUpdate("INSERT INTO transaksi(no_transaksi,tanggal_transaksi,nama_kasir,waktu_transaksi) "
				   		+ "VALUES ('"+no_transaksi+"','"+waktu+"','"+nama_login+"','"+waktu2+"') ");
					
		
			 for(count = 0; count<jumlah_baris; count++)
			 {	
					
					nama_barang=nama.get(count);
					kode_barang= kode.get(count);
					str_harga_barang= harga.get(count);
					str_jumlah_barang=jumlah.get(count);
					str_total_harga=total.get(count);
					
					 System.out.println(jumlah_baris+nama_barang+kode_barang+str_total_harga);
					
					harga_barang=Integer.parseInt(str_harga_barang);
					jumlah_barang=Integer.parseInt(str_jumlah_barang);
					total_harga=Integer.parseInt(str_total_harga);
					
					jumlah_akhir=jumlah_awal-jumlah_barang;
					
					//ResultSet rs2=statement2.executeQuery("select * from items where kode='"+kode_barang+"'");
					
					 
					statement2.executeUpdate("INSERT INTO transaksi_item(nama_barang,no_transaksi,kode_barang,harga_barang,jumlah_barang,"
							+ "total_harga) VALUES ('"+nama_barang+"','"+no_transaksi+"','"+kode_barang+"','"+harga_barang+"',"
									+ "'"+jumlah_barang+"','"+total_harga+"') ");
					   	  
							
					kode_huruf = kode_barang.substring(0,3);
					str_kode_angka = kode_barang.substring(3,5);
					
					   
					  ResultSet rs3=statement2.executeQuery("select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+str_kode_angka+"'");
				       
					   if(rs3.next()) 
		            	{
						statement2.executeUpdate("UPDATE barang SET kuantitas = '"+jumlah_akhir+"' where kode_huruf='"+kode_huruf+"' AND kode_angka='"+str_kode_angka+"';");
	
						}
					   
					  // statement2.close();
			
			 }     
			 		
			 		
					   
					   JOptionPane.showMessageDialog(null,"Berhasil Mencatat Transaksi");
					   
					   return true;
				    
        } catch (Exception e) 
		{
            JOptionPane.showMessageDialog(null, "Gagal Mencatat Transaksi");
            return false;
        }
		
	}
	
	
	
}
