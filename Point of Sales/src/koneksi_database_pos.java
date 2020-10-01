import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi_database_pos {
 private static Connection koneksi2;
 
 
 public static Connection getKoneksi2(){
  if (koneksi2 == null){
   try {String url = "jdbc:mysql://localhost:3306/pos"; // nama databasenya login
          String user="root"; // username mysql root
          String pass=""; //passwordnya kosong

 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
koneksi2 = DriverManager.getConnection(url , user, pass);

 } 
   catch(SQLException t){
     System.out.print("Gagal melakukan koneksi ke database");
 }
}

return koneksi2;
}
 } 
