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



public class menu_item extends JFrame implements ActionListener {
	
	private static final String INITIAL_VALUE = "1";

	private static final String String = null;
	
	//           Pendeklarasian Member Variabel
	
	private JPanel panel1, panel2, panel3,panel4,panel5;
	static JButton buttonlogin, btn_update,btn_input,btn_stok,btn_home;
	private JLabel lblnama,lblpw,lblJudul;
	static JPasswordField txtpw;
	static JTextField txtnama;
	static String vpassword,vmd5,vsha1;
	static JLabel txtSHA1MD5,txtMD5;
	static JFrame frame,framelogin,frame_menu_item,frame_input_item,frame_update_item;
	
	

	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			frame_menu_item = new menu_item();
			frame_menu_item.setVisible(true);
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
    
	
	@SuppressWarnings("resource")
	menu_item() throws FileNotFoundException, SQLException{		
		
		
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("MENU ITEM");
		setSize(650,350);
		setLocationRelativeTo(null);
		
		JFrame frame_input_item = new gui_input_item();
		frame_input_item.dispose();
		
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
	
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2,2));
		
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
		panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		

		//        Deklarasi JLabel
		
		lblJudul = new JLabel("MENU ITEM");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		

	
		
		
	
		//         Deklarasi JButton
		
		
		btn_update = new JButton("Update Barang");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/update.png"));
		    btn_update.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_update.setVisible(true);
		btn_update.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_update_item = null;
					try {
						dispose();
					
						frame_update_item = new gui_update_item();
						frame_update_item.setVisible(true);
						
	
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}		

			  } 
			} );
		
		
		btn_stok = new JButton("Menyuplai Barang");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/stok.png"));
		    btn_stok.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_stok.setVisible(true);
		btn_stok.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_stok_item = null;
					try {
						dispose();
						frame_stok_item = new gui_stok_item();
						
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}		
					frame_stok_item.setVisible(true);
					
				
			  } 
			} );
		
		
		btn_input = new JButton("Input Barang");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/input.png"));
		    btn_input.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_input.setVisible(true);
		btn_input.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_input_item = null;
				 
					try 
					{
						dispose();
						
					frame_input_item = new gui_input_item();
					frame_input_item.setVisible(true);
					
					
									
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			  }

		
			} );
		
		btn_home= new JButton("HOME");
		try {
		    Image img = ImageIO.read(getClass().getResource("/image/stok.png"));
		    btn_stok.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btn_home.setVisible(true);
		btn_home.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFrame frame_beranda = null;
					try {
						dispose();
						frame_beranda = new beranda();
						frame_beranda.setVisible(true);
						
						
						
					} catch (FileNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
					
				
			  } 
			} );
		
		
		//         Menambah elemen-elemen ke Frame		
		panel3.add(lblJudul);		
		panel5.add(btn_input);
		panel5.add(btn_update);
		panel5.add(btn_stok);
	
		
		//panel4.add(txtSHA1MD5);
		//panel2.add(buttonlogin);
		panel1.add(panel5, BorderLayout.CENTER);
		
		c.add(panel3, BorderLayout.NORTH);
		c.add(panel1, BorderLayout.CENTER);
		panel4.add(panel2);
		c.add(panel4, BorderLayout.SOUTH);
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
}








