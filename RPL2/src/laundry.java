import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class laundry implements ActionListener{

	private JFrame frame;
	private JButton btnViewJenisLaundry,btnOrderLaundry,btnLaporanLaundry;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					laundry window = new laundry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public laundry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 747, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Laundry Tawakal");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnViewJenisLaundry = new JButton("List Paket Laundry");
		btnViewJenisLaundry.addActionListener(this);
		panel.add(btnViewJenisLaundry);
		
		btnOrderLaundry = new JButton("Order Laundry");
		btnOrderLaundry.addActionListener(this);
		panel.add(btnOrderLaundry);
		
		btnLaporanLaundry = new JButton("Laporan Laundry");
		btnLaporanLaundry.addActionListener(this);
		panel.add(btnLaporanLaundry);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblLaundryTawakal = new JLabel("LAUNDRY TAWAKAL");
		lblLaundryTawakal.setBounds(76, 49, 576, 69);
		lblLaundryTawakal.setForeground(Color.BLUE);
		lblLaundryTawakal.setBackground(Color.RED);
		lblLaundryTawakal.setFont(new Font("Cooper Black", Font.PLAIN, 50));
		panel_1.add(lblLaundryTawakal);
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnViewJenisLaundry) {
			JFrame viewJenis;
			viewJenis = new viewjenis();
			viewJenis.setVisible(true);
		}
		if(event.getSource() == btnOrderLaundry) {
			JFrame order;
			order = new order();
			order.setVisible(true);
		}
		if(event.getSource() == btnLaporanLaundry) {
			JFrame laporan;
			laporan = new laporan();
			laporan.setVisible(true);
		}
	}
}
