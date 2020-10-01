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


public class entity_update_item {
	
	static String nama = null;
	static String kode=null;
	static String strharga=null;
	static String kategori=null;
	static String strkuantitas=null,kode_huruf,str_kode_angka,kode_angka,nama_kategori;
	
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Kategori","Jumlah"}, 0);
	static DefaultTableModel model2 = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Kategori","Jumlah"}, 0);
	
	static JTable table = new JTable();
	static JTable table2 = new JTable();
	static ResultSet rs3;
	
	
	entity_update_item() throws FileNotFoundException, SQLException,NullPointerException
	
	{
	
	}
	
	
	public static String[] cari_item(String kode)
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
		kode= kode;
		table2.setModel(model2);
		
		ArrayList<Object[]> sets = new ArrayList<Object[]>();
		
		 nama="";
        
         strharga="";
         kategori="";
         
        kode_huruf = kode.substring(0,3);
		//kode_angka=Integer.parseInt(kode);
		str_kode_angka = kode.substring(3,5);
		
		try {
			
   	  		
			 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	         ResultSet rs2=statement.executeQuery("select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+str_kode_angka+"'");
	       
	            if(rs2.next()) 
	            	{
	                nama = rs2.getString("nama");
	                kode_huruf = rs2.getString("kode_huruf");
	                
	                System.out.println(kode_huruf);
	                kode_angka = rs2.getString("kode_angka");
	                strharga = rs2.getString("harga");    
	                
	                kode=kode_huruf+kode_angka;
	                
	                Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	                rs3=statement2.executeQuery("select * from kategori where id_kategori='"+kode_huruf+"'");
	                
	                if(rs3.next())
	                {
	                nama_kategori = rs3.getString("nama_kategori");	
	                }
	  
	                sets.add(new String[]{nama, kode, strharga,nama_kategori});
     
	                model2.addRow(new Object[]{nama, kode, strharga,nama_kategori});
	                
	                return new String[] {nama, kode, strharga,nama_kategori};
	   		     
	            
					}
	            else {
		             JOptionPane.showMessageDialog(null, "Item tidak ditemukan");
		             kode="";  
		         	}
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari item!");
		}
		 return new String[] {nama, kode, strharga,nama_kategori};
		
	}
	

	public static boolean update_item(Object nama,Object kode, Object harga,Object kategori){
	
		String nama_barang = String.valueOf(nama);
		String kode_barang = String.valueOf(kode);
		String harga_barang = String.valueOf(harga);
		String kategori_barang = String.valueOf(kategori);

		   kode_huruf = kode_barang.substring(0,3);
			//kode_angka=Integer.parseInt(kode);
		   str_kode_angka = kode_barang.substring(3,5);
		
		try {
			
				
        	  		String cek="select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+str_kode_angka+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
				
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==1)
				      {        
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
					   statement2.executeUpdate("UPDATE barang SET nama = '"+nama_barang+"', kode_huruf= '"+kode_huruf+"', "
					   		+"kode_angka= '"+str_kode_angka+"', harga= '"+harga_barang+"' where kode_huruf='"+kode_huruf+"' AND kode_angka='"+str_kode_angka+"';");
					   statement2.executeUpdate("UPDATE kategori SET nama_kategori = '"+kategori_barang+"' WHERE id_kategori='"+kode_huruf+"';");
					   statement2.close();
					   JOptionPane.showMessageDialog(null,"Berhasil Memasukan Data");
					   
					   return true;
				      }
				   else {
					     JOptionPane.showMessageDialog(null,"Data barang tidak ada");
				   }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengupdate Items");
            return false;
        }
		
		return false;
	}
	
	
	
	
	public static JTable menampilkan_item() throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException{
		
		table.setModel(model);
		
		//ArrayList<Object[]> sets = new ArrayList<Object[]>();
		try {
			  		
   	  		
            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
            ResultSet rs=statement.executeQuery("select * from items");
           // rs.beforeFirst();
            
            
            
            while (rs.next()) {
                String nama = rs.getString("nama");
                String kode = rs.getString("kode");
                String strharga = rs.getString("harga");          
                String kategori = rs.getString("kategori");
                String strkuantitas = rs.getString("kuantitas");

                model.addRow(new Object[]{nama, kode, strharga,kategori,strkuantitas});
              //  sets.add(new String[]{nama, kode, strharga,kategori,strkuantitas});
                //return new String[] {nama, kode, strharga,kategori,strkuantitas};
                
            }
            return table;
        } catch (ArrayIndexOutOfBoundsException e) 
		{
            JOptionPane.showMessageDialog(null, "gagal");
        }
		
		 return table;
	}
	
}
