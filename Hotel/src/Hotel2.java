import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Hotel extends JFrame implements ActionListener {
	
	//           Pendeklarasian Member Variabel
	private JComboBox <String> cbJenisKamar;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JButton buttonBook, buttonview;
	private JLabel lblJudul, lblmalam, lbllogo;
	private JTextField txtnama, txtnohp, txtbrpmalam, txtharga;
	private String jeniskamar,  totalharga;
	private int totalhargaint, hargakamarint;
	private String[] cbJenis = new String[5];
	private String[] hargaKamar = new String[5];
	private JDatePickerImpl datePicker;
	private ImageIcon logo;
	
	@SuppressWarnings("resource")
	Hotel() throws FileNotFoundException{		
		Scanner input = new Scanner(new File("D:\\workspace\\Hotel\\src\\jenisKamar.txt"));
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
		setSize(650,350);
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
		panel2.setLayout(new FlowLayout());
		TitledBorder titletglcheckin = BorderFactory.createTitledBorder(blackline,"Tanggal Check In");
		titletglcheckin.setTitleJustification(TitledBorder.CENTER);
		panel2.setBorder(titletglcheckin);
		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		TitledBorder titlelamainap = BorderFactory.createTitledBorder(blackline,"Lama Menginap");
		titlelamainap.setTitleJustification(TitledBorder.CENTER);
		panel3.setBorder(titlelamainap);
		
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		TitledBorder titlejeniskamar = BorderFactory.createTitledBorder(blackline, "Jenis Kamar");
		titlejeniskamar.setTitleJustification(TitledBorder.CENTER);
		panel4.setBorder(titlejeniskamar);
		
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
		panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//		Deklarasi Border untuk textfield
		TitledBorder titlenama = BorderFactory.createTitledBorder(blackline,"Isi Nama");
		TitledBorder titlenotelp = BorderFactory.createTitledBorder(blackline,"Isi No. HP");
		TitledBorder titletotalharga = BorderFactory.createTitledBorder(blackline,"Total Harga");
		
		//        Deklarasi JLabel
		logo = new ImageIcon("D:\\workspace\\Hotel\\src\\rajawalilogo.png");
		lbllogo = new JLabel(logo);
		lbllogo.setVisible(true);
		lblJudul = new JLabel("Hotel Ratu Rajawali");
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize() * 2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		
		lblmalam = new JLabel("Malam");
		lblmalam.setHorizontalAlignment(SwingConstants.LEFT);
		lblmalam.setVisible(true);
		
		//         Deklarasi JTextField txtnama, txtnohp, txttglcekin, txtbrpmalam, txtharga
		txtnama = new JTextField();
		txtnama.setVisible(true);
		txtnama.setHorizontalAlignment(JTextField.CENTER);
		titlenama.setTitleJustification(TitledBorder.CENTER);
		txtnama.setBorder(titlenama);

		txtnohp = new JTextField();
		txtnohp.setVisible(true);
		txtnohp.setHorizontalAlignment(JTextField.CENTER);
		titlenotelp.setTitleJustification(TitledBorder.CENTER);
		txtnohp.setBorder(titlenotelp);
		
		txtbrpmalam = new JTextField();
		txtbrpmalam.setHorizontalAlignment(JTextField.RIGHT);
		txtbrpmalam.setText("0");
		txtbrpmalam.setVisible(true);
		
		txtharga = new JTextField();
		txtharga.setVisible(true);
		txtharga.setHorizontalAlignment(JTextField.CENTER);
		txtharga.setFocusable(false);
		titletotalharga.setTitleJustification(TitledBorder.CENTER);
		txtharga.setBorder(titletotalharga);
		
		//         Deklarasi JComboBox
		cbJenisKamar = new JComboBox<>(cbJenis);
		cbJenisKamar.addActionListener(this);
		
		//			Deklarasi Kalender
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Hari");
		p.put("text.month", "Bulan");
		p.put("text.year", "Tahun");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		/*cbBulan.addActionListener(this);
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
		cbtgl.addActionListener(this);*/
		
		//         Deklarasi JButton
		
		buttonview = new JButton("View Rooms");
		buttonview.addActionListener(this);
		buttonBook = new JButton("Book");
		buttonBook.addActionListener(this);
		
		//         Menambah elemen-elemen ke Frame		

		panel2.add(datePicker);
		
		panel3.add(txtbrpmalam);
		panel3.add(lblmalam);
		
		panel4.add(cbJenisKamar);
		panel4.add(buttonview);
		
		panel5.add(lbllogo);
		panel5.add(lblJudul);
		
		panel1.add(txtnama);
		panel1.add(panel2);
		panel1.add(txtnohp);
		panel1.add(panel3);
		panel1.add(panel4);
		panel1.add(txtharga);
		
		c.add(panel5, BorderLayout.NORTH);
		c.add(panel1, BorderLayout.CENTER);
		c.add(buttonBook, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent event){
		
		if(event.getSource() == buttonview){
			JFrame viewImage;
			try {
				viewImage = new displayImages(cbJenis);
				viewImage.setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		int brpmalam;
		
		if(Integer.parseInt(txtbrpmalam.getText()) == 0){
			brpmalam = 1;
		}
		else{
			brpmalam = Integer.parseInt(txtbrpmalam.getText());
		}
		
		jeniskamar = (String) cbJenisKamar.getSelectedItem();
		String hargakamarstring = hargaKamar[cbJenisKamar.getSelectedIndex()];
		hargakamarint = Integer.parseInt(hargakamarstring);
		totalhargaint = hargakamarint * brpmalam;
		totalharga = Integer.toString(totalhargaint);
		txtharga.setText(totalharga);
				
		if (event.getSource()==buttonBook){
			
			Date tanggalcekin1 = (Date) datePicker.getModel().getValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String tanggalcekin3 = sdf.format(tanggalcekin1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd-MMM-yyyy" );
			LocalDate tglcekin = formatter.parse ( tanggalcekin3 , LocalDate :: from );
			LocalDate tanggalcekout1 = tglcekin.plusDays(Integer.parseInt(txtbrpmalam.getText()));
			String tanggalcekout3 = tanggalcekout1.format(formatter);
			
			String message = 	"\nNama : " + txtnama.getText() +
								"\nNo HP = " + txtnohp.getText() +
								"\nTanggal Check-in = " + tanggalcekin3 +
								"\nTanggal Check-out = " + tanggalcekout3 +
								"\nJenis Kamar = " + jeniskamar +
								"\nTotal Harga = " + totalharga;
			
			String title = "BOOK";
				
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
			
			Writer writer = null;
			
			try{
				writer = new BufferedWriter(new FileWriter("D:\\workspace\\data hotel\\data book hotel\\bookings.txt",true));
				String nodeValue = 
								   "\n" +
								   "\nNama = " + txtnama.getText() + 
								   "\nNo HP = " + txtnohp.getText() + 
								   "\nTanggal Check-in = " + tanggalcekin3 + 
								   "\nTanggal Check-out = " + tanggalcekout3 + 
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
