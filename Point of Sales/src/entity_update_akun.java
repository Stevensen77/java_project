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


public class entity_update_akun {
	
	static String username;
	static String alamat;
	static String nama;
	static String no_ktp;
	static String no_hp;
	static String divisi;
	static String username_temu;
	
	

	entity_update_akun() throws FileNotFoundException, SQLException,NullPointerException
	
	{
	
	}
	
	
	public static String[] cari_akun(String username)
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
		
		
		
		try {
			
   	  		
			 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	         ResultSet rs2=statement.executeQuery("select * from akun where username='"+username+"'");
	        
	         Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
             ResultSet rs3=statement2.executeQuery("select * from biodata where username='"+username+"'");
	       
	         
	            if(rs2.next()) 
	            	{

	   	         	
	                username_temu = rs2.getString("username");             
	               
	            	}
	            
	            if(rs3.next()) 
            	{
	                
	                nama = rs3.getString("nama"); 
	                alamat = rs3.getString("alamat");  
	                no_ktp = rs3.getString("no_ktp");  
	                no_hp = rs3.getString("no_hp");
	                divisi = rs3.getString("divisi");
	               
	 
	                return new String[] {username_temu,nama,alamat,no_ktp,no_hp,divisi};
	            
					}
	            
	            	else {
		             JOptionPane.showMessageDialog(null, "Akun tidak ditemukan");
		           
		         	}
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari akun!");
		}
		 return new String[] {username_temu,nama,alamat,no_ktp,no_hp,divisi};
         
		
	}
	

	public static boolean update_akun(String username,String username_update,String nama,String alamat,String no_ktp,String divisi,String no_hp)
	
	{
	
		try {
					       
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
					   statement2.executeUpdate("UPDATE akun SET username= '"+username_update+"' WHERE username='"+username+"';");
					   statement2.executeUpdate("UPDATE biodata SET username= '"+username_update+"',nama= '"+nama+"',alamat= '"+alamat+"',"
					   		+ "no_ktp= '"+no_ktp+"',divisi= '"+divisi+"',no_hp= '"+no_hp+"'WHERE username='"+username+"';");
					   statement2.close();
					   
					   
					   JOptionPane.showMessageDialog(null,"Berhasil Mengupdate Akun");
					   
					   return true;
				      
				   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengupdate Akun");
            return false;
        }
	
	}
	
	
	
}
