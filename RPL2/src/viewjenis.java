import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class viewjenis extends JFrame{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewjenis window = new viewjenis();
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
	public viewjenis() {
		setBounds(100, 100, 749, 364);
		setTitle("Laundry Tawakal");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblJenisLaundryBeserta = new JLabel("List Paket Laundry Beserta Harga");
		lblJenisLaundryBeserta.setForeground(Color.BLUE);
		lblJenisLaundryBeserta.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		panel.add(lblJenisLaundryBeserta);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 731, 64);
		panel_1.add(table);
		table.setBackground(SystemColor.control);
		table.setForeground(SystemColor.desktop);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"           Paket Laundry Kiloan", "        Harga/Kg", "   Paket Laundry Satuan", "           Harga"},
				{"Cuci Kiloan Reguler", "Rp 6.000", "Sepatu", "Rp 50.000"},
				{"Cuci Kiloan Express 1 Hari Selesai", "Rp 9.000", "Jas/Blezer", "Rp 30.000"},
				{"Cuci Kiloan Super Express 10 Jam", "Rp 15.000", "Gaun/Baju Pengantin", "Rp 100.000"},
			},
			new String[] {
				"Paket Laundry Kiloan", "Harga/Kg", "Paket Laundry Satuan", "Harga"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(202);
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}

}
