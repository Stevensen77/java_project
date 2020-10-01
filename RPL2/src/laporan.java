import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class laporan extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					laporan window = new laporan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public laporan() {
		setBounds(100, 100, 673, 487);
		setTitle("Laundry Tawakal");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLaporanLaundry = new JLabel("Laporan Laundry");
		lblLaporanLaundry.setBackground(SystemColor.control);
		lblLaporanLaundry.setForeground(Color.BLUE);
		lblLaporanLaundry.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		panel.add(lblLaporanLaundry);
		
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}

}
