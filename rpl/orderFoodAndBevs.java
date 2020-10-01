import java.awt.CheckboxGroup;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class orderFoodAndBevs {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean LEFT_TO_RIGHT = true;
	
	static String[] cbMakanan = {" ", " ", " ", " ", " "};
	static String[] cbMinuman = {" ", " ", " ", " ", " "};
	static String[] hargaMakanan = {" ", " ", " ", " ", " "};
	static String[] hargaMinuman = {" ", " ", " ", " ", " "};
	static String[] hargaMinumanLarge = {" ", " ", " ", " ", " "};
	static String[] hargaMinumanMedium = {" ", " ", " ", " ", " "};
	static String[] hargaMinumanSmall = {" ", " ", " ", " ", " "};
	
	static JLabel label, labelhargamaks;
	static JComboBox<String> comboxMakanan;
	static JComboBox<String> comboxMinuman;
	static JTextField teksfieldMakanan;
	static JTextField teksfieldMinuman;
	static JTextField teksfieldTotal;
	static JCheckBox ceklisLarge, ceklisMedium, ceklisSmall;
	static JButton button;
	
	public static void addComponentsToPane(Container pane) {
		if (LEFT_TO_RIGHT){
			pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill){
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		label = new JLabel("Daftar Makanan");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		pane.add(label, c);
		
		label = new JLabel("Daftar Minuman");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		pane.add(label, c);
		
		comboxMakanan = new JComboBox<>(cbMakanan);
		comboxMakanan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				labelhargamaks.setText("Harga = "+hargaMakanan[comboxMakanan.getSelectedIndex()]);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		pane.add(comboxMakanan, c);
		
		comboxMinuman = new JComboBox<>(cbMinuman);
		comboxMinuman.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ceklisLarge.setText("Large " + hargaMinumanLarge[comboxMinuman.getSelectedIndex()]);
				ceklisMedium.setText("Medium " + hargaMinumanMedium[comboxMinuman.getSelectedIndex()]);
				ceklisSmall.setText("Small " + hargaMinumanSmall[comboxMinuman.getSelectedIndex()]);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 2;
		pane.add(comboxMinuman, c);
		
		labelhargamaks = new JLabel("Harga = ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		pane.add(labelhargamaks, c);
		
		label = new JLabel("Jumlah");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		pane.add(label, c);
		
		teksfieldMakanan = new JTextField("0");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		pane.add(teksfieldMakanan, c);
		
		/*CheckboxGroup cbg = new CheckboxGroup();
		ceklisLarge = new Checkbox("Large",cbg,true);
		ceklisMedium = new Checkbox("Medium",cbg,false);		
		ceklisSmall = new Checkbox("Small",cbg,false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 3;
		pane.add(cbg, c);*/
		
		ceklisLarge = new JCheckBox("Large");
		ceklisLarge.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ceklisLarge.isSelected()){
					hargaMinuman = hargaMinumanLarge;
					ceklisMedium.setSelected(false);
					ceklisSmall.setSelected(false);
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 2;
		pane.add(ceklisLarge, c);
		
		ceklisMedium = new JCheckBox("Medium");
		ceklisMedium.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hargaMinuman = hargaMinumanMedium;
				ceklisLarge.setSelected(false);
				ceklisSmall.setSelected(false);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 2;
		pane.add(ceklisMedium, c);
		
		ceklisSmall = new JCheckBox("Small");
		ceklisSmall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hargaMinuman = hargaMinumanSmall;
				ceklisLarge.setSelected(false);
				ceklisMedium.setSelected(false);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 2;
		pane.add(ceklisSmall, c);
		
		label = new JLabel("Jumlah");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 5;
		c.gridwidth = 1;
		pane.add(label, c);
		
		teksfieldMinuman = new JTextField("0");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 5;
		c.gridwidth = 1;
		pane.add(teksfieldMinuman, c);
		
		label = new JLabel("Total Harga");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		pane.add(label, c);
		
		teksfieldTotal = new JTextField(" ");
		teksfieldTotal.setFocusable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 7;
		c.gridwidth = 3;
		pane.add(teksfieldTotal, c);
		
		button = new JButton("Order");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 9;
		c.gridwidth = 2;
		pane.add(button, c);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int jmlMakanan = Integer.parseInt(teksfieldMakanan.getText());
				int MakananHarga = Integer.parseInt(hargaMakanan[comboxMakanan.getSelectedIndex()]);
				int hargaMakananTotal = jmlMakanan * MakananHarga;
				String makanan = Integer.toString(hargaMakananTotal);
				
				int jmlMinuman = Integer.parseInt(teksfieldMinuman.getText());
				int MinumanHarga = Integer.parseInt(hargaMinuman[comboxMinuman.getSelectedIndex()]);
				int hargaMinumanTotal = jmlMinuman * MinumanHarga;
				String minuman =  Integer.toString(hargaMinumanTotal);
				
				int total = hargaMakananTotal + hargaMinumanTotal;
				String totall = Integer.toString(total);
				
				teksfieldTotal.setText(makanan+" + "+minuman+" = "+totall);
				
				String message = cbMakanan[comboxMakanan.getSelectedIndex()] + " " + teksfieldMakanan.getText() + " | " + 
											cbMinuman[comboxMinuman.getSelectedIndex()] + " " + teksfieldMinuman.getText() + " | " + 
											makanan + " + " + minuman + " = " + total;
				
				Writer writer = null;
				
				try{
					writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\data Order\\order.txt",true));
					
					((BufferedWriter) writer).newLine();
					writer.write(message);
					
				}
				catch(IOException f){
					JOptionPane.showMessageDialog(null, "Maaf File Tidak Ada");
				}
				finally{
					try{writer.close();} catch(Exception f){}
				}
				
			}
		});
		
	}
	
	private static void createAndShowGUI(){
		JFrame frame = new JFrame("Order your Food and Beverages!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(520,300);
		addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException{
		int i= 0, j = 0;
		Scanner input1 = new Scanner(new File("C:\\Users\\user\\workspace\\Order Food and Beverages\\src\\Makanan.txt"));
		while (input1.hasNextLine()){
			String record = input1.nextLine();
			String[] splitter = record.split("\\|");
			cbMakanan[i] = splitter[0];
			hargaMakanan[i] = splitter[1];
			i++;
		}
		Scanner input2 = new Scanner(new File("C:\\Users\\user\\workspace\\Order Food and Beverages\\src\\Minuman.txt"));
		while(input2.hasNextLine()){
			String record = input2.nextLine();
			String[] splitter = record.split("\\|");
			cbMinuman[j] = splitter[0];
			hargaMinumanLarge[j] = splitter[1];
			hargaMinumanMedium[j] = splitter[2];
			hargaMinumanSmall[j] = splitter[3];
			j++;
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
