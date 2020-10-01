import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Hotel extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	private JComboBox <String> cbJenisKamar, cbBulan, cbtgl;
	private JPanel panel1, panel2, panel3;
	private JButton buttonBook;
	private JLabel lblJudul, lblbulan, lbltanggal, lblmalam;
	private JTextField txtnama, txtnohp, txttglcekin, txtbrpmalam, txtharga, txtbulan1, txttanggal1;
	//private String cbJenis[] = {"President Room (Rp700.000)" , "Suite Room (Rp475.000)", "Deluxe Room (Rp375.000)", "Business Room (Rp300.000)", "Standard Room (Rp250.000)"};
	private String cbbulan[] = {"Januari", "Februari" , "Maret" , "April" , "Mei" , "Juni" , "Juli" , "Agustus" , "September" , "Oktober" , "November" , "Desember"};
	private String cb31[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String cb30[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	private String cb29[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
	private ComboBoxModel[] models;
	private String jeniskamar,  totalharga;
	private int tglcekout, totalhargaint, hargakamarint;
	private String tanggalcekin, tanggalcekout;
	private String[] cbJenis = {" ", " ", " ", " ", " "};
	private String[] hargaKamar = {" "," ", " ", " ", " "};
	
	Hotel() throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("C:\\Users\\user\\OneDrive\\Documents\\Kuliah 064001600013\\workspace\\Hotel\\src\\jenisKamar.txt"));
		int i=0;
		while (input.hasNextLine()){
			String record = input.nextLine();
			String[] fields = record.split("Rp");
			cbJenis[i] = record;
			hargaKamar[i] = fields[1];
			i++;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Book your Room");
		setSize(500,300);
		setLocationRelativeTo(null);
		
		//        Pembuatan Container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//        Deklarasi JPanel & Border
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2,15,5));
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		TitledBorder titletglcheckin = BorderFactory.createTitledBorder(blackline,"Tanggal Check In");
		titletglcheckin.setTitleJustification(TitledBorder.CENTER);
		panel2.setBorder(titletglcheckin);
		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		TitledBorder titlelamainap = BorderFactory.createTitledBorder(blackline,"Lama Menginap");
		titlelamainap.setTitleJustification(TitledBorder.CENTER);
		panel3.setBorder(titlelamainap);
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi Nama");
		TitledBorder titlenotelp = BorderFactory.createTitledBorder(blackline,"Isi No. HP");
		TitledBorder titlejeniskamar = BorderFactory.createTitledBorder(blackline,"Jenis Kamar");
		TitledBorder titletotalharga = BorderFactory.createTitledBorder(blackline,"Total Harga");
		
		//        Deklarasi JLabel
		lblJudul = new JLabel("Hotel Ratu Rajawali");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblJudul.setVisible(true);
		
		/*lblbulan = new JLabel("Bulan");
		lblbulan.setHorizontalAlignment(SwingConstants.CENTER);
		lblbulan.setVisible(true);
		lbltanggal = new JLabel("Tanggal");
		lbltanggal.setHorizontalAlignment(SwingConstants.CENTER);
		lbltanggal.setVisible(true);*/
		lblmalam = new JLabel("Malam");
		lblmalam.setHorizontalAlignment(SwingConstants.LEFT);
		lblmalam.setVisible(true);
		
		//         Deklarasi JTextField txtnama, txtnohp, txttglcekin, txtbrpmalam, txtharga
		txtnama = new JTextField();
		txtnama.setVisible(true);
		titlenama.setTitleJustification(TitledBorder.CENTER);
		txtnama.setBorder(titlenama);

		txtnohp = new JTextField();
		txtnohp.setVisible(true);
		titlenotelp.setTitleJustification(TitledBorder.CENTER);
		txtnohp.setBorder(titlenotelp);
		
		txtbrpmalam = new JTextField();
		txtbrpmalam.setText("0");
		txtbrpmalam.setVisible(true);
		txtharga = new JTextField();
		txtharga.setVisible(true);
		txtharga.setFocusable(false);
		titletotalharga.setTitleJustification(TitledBorder.CENTER);
		txtharga.setBorder(titletotalharga);
		
		/*txtbulan1 = new JTextField();
		txtbulan1.setVisible(true);
		txttanggal1 = new JTextField();
		txttanggal1.setVisible(true);*/
		
		//         Deklarasi JComboBox
		cbJenisKamar = new JComboBox<>(cbJenis);
		cbJenisKamar.addActionListener(this);
		titlejeniskamar.setTitleJustification(TitledBorder.CENTER);
		cbJenisKamar.setBorder(titlejeniskamar);
		cbBulan = new JComboBox<>(cbbulan);
		cbBulan.addActionListener(this);
		models = new ComboBoxModel[12];
		models[0] = new DefaultComboBoxModel<>(cb31);
		models[1] = new DefaultComboBoxModel<>(cb29);
		models[2] = new DefaultComboBoxModel<>(cb31);
		models[3] = new DefaultComboBoxModel<>(cb30);
		models[4] = new DefaultComboBoxModel<>(cb31);
		models[5] = new DefaultComboBoxModel<>(cb30);
		models[6] = new DefaultComboBoxModel<>(cb31);
		models[7] = new DefaultComboBoxModel<>(cb31);
		models[8] = new DefaultComboBoxModel<>(cb30);
		models[9] = new DefaultComboBoxModel<>(cb31);
		models[10] = new DefaultComboBoxModel<>(cb30);
		models[11] = new DefaultComboBoxModel<>(cb31);
		cbtgl = new JComboBox<String>(models[0]);
		cbtgl.addActionListener(this);
		
		//         Deklarasi JButton
		buttonBook = new JButton("Book");
		buttonBook.addActionListener(this);
		
		//         Menambah elemen-elemen ke Frame
		
		/*panel2.add(lblbulan);
		panel2.add(txtbulan1);
		panel2.add(lbltanggal);
		panel2.add(txttanggal1);*/
		panel2.add(cbBulan);
		panel2.add(cbtgl);
		
		panel3.add(txtbrpmalam);
		panel3.add(lblmalam);
		
		panel1.add(txtnama);
		panel1.add(panel2);
		panel1.add(txtnohp);
		panel1.add(panel3);
		panel1.add(cbJenisKamar);
		panel1.add(txtharga);
		
		c.add(lblJudul, BorderLayout.NORTH);
		c.add(panel1, BorderLayout.CENTER);
		c.add(buttonBook, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent event){
		
		int brpmalam;
		
		int i = cbBulan.getSelectedIndex();
		cbtgl.setModel(models[i]);
		
		
		if(Integer.parseInt(txtbrpmalam.getText()) == 0){
			brpmalam = 1;
		}
		else{
			brpmalam = Integer.parseInt(txtbrpmalam.getText());
		}
		
		Object obj = event.getSource();
		
		jeniskamar = (String) cbJenisKamar.getSelectedItem();
		hargakamarint = Integer.parseInt(hargaKamar[cbJenisKamar.getSelectedIndex()]);
		totalhargaint = hargakamarint * brpmalam;
		totalharga = Integer.toString(totalhargaint);
		txtharga.setText(totalharga);
		
		/*if(cbJenisKamar.getSelectedItem().equals(cbJenis[0])){
			jeniskamar = "President Room";
			totalhargaint = 700000 * brpmalam;
			totalharga = Integer.toString(totalhargaint);
			txtharga.setText(totalharga);
		}
		else if(cbJenisKamar.getSelectedItem().equals(cbJenis[1])){
			jeniskamar = "Suite Room";
			totalhargaint = 475000 * brpmalam;
			totalharga = Integer.toString(totalhargaint);
			txtharga.setText(totalharga);
		}
		else if(cbJenisKamar.getSelectedItem().equals(cbJenis[2])){
			jeniskamar = "Deluxe Room";
			totalhargaint = 375000 * brpmalam;
			totalharga = Integer.toString(totalhargaint);
			txtharga.setText(totalharga);
		}
		else if(cbJenisKamar.getSelectedItem().equals(cbJenis[3])){
			jeniskamar = "Business Room";
			totalhargaint = 300000 * brpmalam;
			totalharga = Integer.toString(totalhargaint);
			txtharga.setText(totalharga);
		}
		else if(cbJenisKamar.getSelectedItem().equals(cbJenis[4])){
			jeniskamar = "Standart Room";
			totalhargaint = 250000 * brpmalam;
			totalharga = Integer.toString(totalhargaint);
			txtharga.setText(totalharga);
		}*/
		
		if (obj instanceof JButton){
			
			tanggalcekin = cbBulan.getSelectedItem() + " " + cbtgl.getSelectedItem();
			tglcekout = cbtgl.getSelectedIndex() + 1 + Integer.parseInt(txtbrpmalam.getText());
			tanggalcekout = cbBulan.getSelectedItem() + " " + Integer.toString(tglcekout);
			
			String message = 	"\nNama : " + txtnama.getText() +
								"\nNo HP = " + txtnohp.getText() +
								"\nTanggal Check-in = " + tanggalcekin +
								"\nTanggal Check-out = " + tanggalcekout +
								"\nJenis Kamar = " + jeniskamar +
								"\nTotal Harga = " + totalharga;
			
			String title = "BOOK";
			
			
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
			
			Writer writer = null;
			
			try{
				writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\data hotel\\data book hotel\\bookings.txt",true));
				String nodeValue = 
								   "\n" +
								   "\nNama = " + txtnama.getText() + 
								   "\nNo HP = " + txtnohp.getText() + 
								   "\nTanggal Check-in = " + tanggalcekin + 
								   "\nTanggal Check-out = " + tanggalcekout + 
								   "\nJenis Kamar = " + jeniskamar + 
								   "\nTotal Harga = " + totalharga;
				
				String[] words = nodeValue.split("\n");
				for (String word: words) {
			        writer.write(word);
			        ((BufferedWriter) writer).newLine();
			    } 
				
			}
			catch (IOException e){
				JOptionPane.showMessageDialog(null,"Maaf tanggal cek-in anda salah");
			}
			finally{
				try {writer.close();} catch (Exception e) {}
			}
		}
	}
}
