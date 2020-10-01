import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class konver extends JFrame implements ActionListener
	{     public konver() 
		{
	             setTitle("C2F");    setSize(280, 120);
	             setLocationRelativeTo(null);
	             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 
				 
	             JButton btnkonversi = new JButton("Convert");
				 
				 final JTextField isiteks = new JTextField();
				 isiteks.setSize(50,20);

				 JLabel labelcelcius = new JLabel("Celcius");
				 final JLabel labelfahrenheit = new JLabel(" Fahrenheit");
				 JLabel labelisi = new JLabel();
				 JLabel labelkosong = new JLabel();

				 
	             Container c = getContentPane();
	             c.setLayout(new GridLayout(2,2, 10, 5));
				 add(isiteks);
				 add(labelcelcius);
	             add(btnkonversi);
				 add(labelfahrenheit);
				 
		 btnkonversi.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
			double hasil = 0;
			double x;
			try 	{
						hasil = Double.parseDouble(isiteks.getText());
					}
			catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Maaf input salah!!");				
					}
			x = (hasil*1.8)+32;
			labelfahrenheit.setText(x + "° Fahrenheit");
			}
	});
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{

	}

}



public class Konversi {

	   public static void main(String[] args) {
		   JFrame w = new konver();
	        w.setVisible(true);
	   }
}
