import java.awt.*;        
import java.awt.event.*; 
import javax.swing.*;     

class WinCurren extends JFrame implements ActionListener
{	private JComboBox <String> cbkiri;
	private JComboBox <String> cbkanan;
	private  JPanel panel1 ;
	private JLabel atas;
	private JLabel panah1;
	private JLabel panah2;
	private JTextField isiteks;
	private JTextField isiteks2;
	private JButton convert;  
	private JPanel panel2 ;
	private String a[] = {"Dolar Amerika (USD)","Poundsterling Inggris (GBP)","Rupiah Indonesia(IDR)","Ringgit Malaysia (MYR)","Yen Jepang (JPY)"};
	private String b[] = {"Dolar Amerika (USD)","Poundsterling Inggris (GBP)","Rupiah Indonesia(IDR)","Ringgit Malaysia (MYR)","Yen Jepang (JPY)"}; 
	private double ubah = 0;
	private double uang[][] = { {1 , 0.70 , 13255, 4.1885, 111.37} , { 1.35, 1 ,17500, 5.55, 150.83 } , { 0.0000752, 0.0000057 , 1 , 0.0003 , 0.0084}, {0.238,0.2,3200,1, 26.6 }, 
								{0.009,0.0066, 119.72, 0.0376, 1},{} };
	private String lblatas[][] = { {" Dolar US ke Dolar US $1 = $1", " Dolar US ke Poundsterling  $1 = \u00A3 0.74"," Dolar US ke Rupiah $1 = Rp13255", "Dolar US ke Ringgit $1 = RM 4.1885","Dolar US ke Yen Jepang $1 = \u00A51 = 111.37"},  
								{"Poundsterling ke Dolar US \u00A31  = $1.35", "Poundsterling ke Poundsterling \u00A31  = \u00A31 " ,"Poundsterling ke Rupiah \u00A31  = Rp17500" ,  "Poundsterling ke Ringgit \u00A31  = RM5.55", "Poundsterling ke Yen Jepang \u00A31  = \u00A51 150.83"} ,
								{" Rupiah ke Dolar US Rp1 = $ 0.0000752", "Rupiah ke Poundsterling Rp1 = \u00A3 0.000057" ," Rupiah ke Rupiah Rp1 = Rp1" ,  "Rupiah ke Ringgit Rp1 = RM0.0003", "Rupiah ke Yen Jepang Rp1 = \u00A51 0.0084" } ,
								{"Ringgit ke Dolar US RM1 = $0.238", "Ringgit ke Poundsterling RM1 = \u00A3 0.2" , "Ringgit ke Rupiah RM1 = Rp3200" , "Ringgit ke Ringgit RM1 = RM1", "Ringgit ke Yen Jepang RM1 = \u00A51 26.6" },
								{" Yen Jepang ke Dolar US \u00A51 1 = $0.009", " Yen Jepang ke Poundsterling \u00A51 1 = \u00A3 0.0066",   " Yen Jepang ke Rupiah  \u00A51 1 = Rp 119.72",  " Yen Jepang ke Ringgit \u00A51 1 = RM 0.0376",  " Yen Jepang ke Yen Jepang \u00A51 1 = \u00A51 1"}
								};
	public WinCurren() 
	{ setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Currency Mata Uang"); 
      setSize(600,300);
      setLocationRelativeTo(null);        
   
	  Container c = getContentPane();
	  c.setLayout(new BorderLayout());
	  panel1 = new JPanel();
	  panel1.setLayout(new GridLayout(2,3,0,15));
	  panel2 = new JPanel();
	  panel2.setLayout(new BorderLayout());
		
		atas = new JLabel();
		Font font = atas.getFont();
		font = font.deriveFont(font.getSize() * 1.8f);
		atas.setFont(font);
		atas.setHorizontalAlignment(JLabel.CENTER);
		
		panah1= new JLabel(">>");
		panah1.setFont(new Font("Serif", Font.BOLD, 24));
		panah1.setHorizontalAlignment(JLabel.CENTER);
		
		panah2= new JLabel(">>");
		panah2.setFont(new Font("Serif", Font.BOLD, 24));
		panah2.setHorizontalAlignment(JLabel.CENTER);
		
		cbkiri = new JComboBox<>(a);
		((JLabel)cbkiri.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);  
		cbkiri.addActionListener(this);
	  
	  cbkanan = new JComboBox<>(b);
	  ((JLabel)cbkanan.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      cbkanan.addActionListener(this);
	  
	  isiteks = new JTextField();
	  isiteks.setSize(50,20);
	  Font font5 = panah1.getFont();
	  isiteks.setFont(new Font("Serif", Font.BOLD, 14));
	  isiteks.setHorizontalAlignment(JLabel.CENTER);
	  isiteks.addActionListener(this);
	  
	  isiteks2 = new JTextField();
	  isiteks2.setSize(50,20);
	  isiteks2.setFont(new Font("Serif", Font.BOLD, 14));
	  isiteks2.setHorizontalAlignment(JLabel.CENTER);
	  isiteks2.setFocusable(false);
	  
	  convert = new JButton("Cek Nilai Tukar");
	  convert.addActionListener(this);
	  
      c.add(panel1, BorderLayout.CENTER);
	  c.add(atas, BorderLayout.NORTH);
	  c.add(panel2, BorderLayout.SOUTH);  
	  panel1.add(cbkiri);
	  panel1.add(panah1);
	  panel1.add(cbkanan);
	  panel1.add(isiteks);
	  panel1.add(panah2);
	  panel1.add(isiteks2);
	  panel2.add(convert, BorderLayout.NORTH); }
	
public void actionPerformed(ActionEvent event)
	{
	Object obj = event.getSource();
	atas.setVisible(true);
	atas.setText(lblatas[cbkiri.getSelectedIndex()][cbkanan.getSelectedIndex()]);
	
	if (obj instanceof JButton)
	{double angkakiri, angkakanan;
	angkakiri = Double.parseDouble(isiteks.getText());
	angkakanan = angkakiri * uang[cbkiri.getSelectedIndex()][cbkanan.getSelectedIndex()];
	String hasilb = String.format("%.3f",angkakanan);
	isiteks2.setText(hasilb);
	} }
}	
	
public class TukarUang
{	public static void main(String[] arg)
	{	JFrame  crn = new WinCurren();
		crn.setVisible(true);   }
}