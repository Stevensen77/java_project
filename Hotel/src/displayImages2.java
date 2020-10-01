import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class displayImages extends JFrame implements ActionListener{

	ImageIcon[] kamar = new ImageIcon[5];
	JLabel lblJudul, lblImage, lbljenisKamar;
	JButton buttonkiri, buttonkanan;
	String[] jeniskamar;
	String[] pathgambar;
	int i = 0;
	
	displayImages(String[] JenisKamar) throws FileNotFoundException{
		
		jeniskamar = JenisKamar;
		
		setTitle("Display Kamar");
		setSize(1366,728);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		kamar[0] = new ImageIcon("D:\\workspace\\data hotel\\kamar\\standard.jpg");
		kamar[1] = new ImageIcon("D:\\workspace\\data hotel\\kamar\\business.jpg");
		kamar[2] = new ImageIcon("D:\\workspace\\data hotel\\kamar\\deluxe.jpg");
		kamar[3] = new ImageIcon("D:\\workspace\\data hotel\\kamar\\suite.jpg");
		kamar[4] = new ImageIcon("D:\\workspace\\data hotel\\kamar\\president.jpg");
		
		buttonkiri = new JButton("<");
		buttonkiri.setVisible(true);
		buttonkiri.addActionListener(this);
		buttonkiri.setFocusable(false);
		buttonkanan = new JButton(">");
		buttonkiri.setVisible(true);
		buttonkanan.addActionListener(this);
		
		lblJudul = new JLabel("Preview Kamar", JLabel.CENTER);
		Font font = lblJudul.getFont();
		font = font.deriveFont(font.getSize()*2.5f);
		lblJudul.setFont(font);
		lblJudul.setVisible(true);
		lblImage = new JLabel(kamar[0]);
		lblImage.setVisible(true);
		lbljenisKamar = new JLabel(JenisKamar[0], JLabel.CENTER);
		Font font2 = lbljenisKamar.getFont();
		font2 = font2.deriveFont(font2.getSize()*2f);
		lbljenisKamar.setFont(font2);
		lbljenisKamar.setVisible(true);
		
		
		c.add(lblJudul, BorderLayout.NORTH);
		c.add(buttonkiri, BorderLayout.WEST);
		c.add(lblImage, BorderLayout.CENTER);
		c.add(buttonkanan, BorderLayout.EAST);
		c.add(lbljenisKamar, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == buttonkiri){
			i--;
			lblImage.setIcon(kamar[i]);
			lbljenisKamar.setText(jeniskamar[i]);
			if(i==0){
				buttonkiri.setEnabled(false);
			}
			if(i==3){
				buttonkanan.setEnabled(true);
			}
		}
		
		if(e.getSource() == buttonkanan){
			i++;
			lblImage.setIcon(kamar[i]);
			lbljenisKamar.setText(jeniskamar[i]);
			if(i==4){
				buttonkanan.setEnabled(false);
			}
			if(i==1){
				buttonkiri.setEnabled(true);
			}
		}
	}
}
