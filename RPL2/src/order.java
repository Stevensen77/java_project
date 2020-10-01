import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class order extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order window = new order();
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
	public order() {
		//frame = new JFrame();
		setBounds(100, 100, 668, 567);
		setTitle("Laundry Tawakal");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblOrderPesanan = new JLabel("ORDER PESANAN");
		lblOrderPesanan.setForeground(Color.BLUE);
		lblOrderPesanan.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		panel_1.add(lblOrderPesanan);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNama = new JLabel("Nama :");
		lblNama.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNama.setBounds(139, 27, 52, 16);
		panel_2.add(lblNama);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(218, 22, 349, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblTanggal = new JLabel("Tanggal :");
		lblTanggal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTanggal.setBounds(123, 65, 68, 16);
		panel_2.add(lblTanggal);
		
		JLabel label_1 = new JLabel("Alamat  :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(123, 101, 68, 16);
		panel_2.add(label_1);
		
		JLabel lblNoHp = new JLabel("No HP :");
		lblNoHp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoHp.setBounds(133, 197, 58, 16);
		panel_2.add(lblNoHp);
		
		JLabel lblLayananLaundry = new JLabel("Layanan Laundry :");
		lblLayananLaundry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLayananLaundry.setBounds(60, 226, 131, 16);
		panel_2.add(lblLayananLaundry);
		
		JRadioButton rdbtnLaundryKiloanPaket = new JRadioButton("Laundry Kiloan Paket Hemat");
		rdbtnLaundryKiloanPaket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLaundryKiloanPaket.setBounds(218, 222, 283, 25);
		panel_2.add(rdbtnLaundryKiloanPaket);
		
		JRadioButton rdbtnLaundryKiloanExpress = new JRadioButton("Laundry Kiloan Express 1 Hari Selesai");
		rdbtnLaundryKiloanExpress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLaundryKiloanExpress.setBounds(218, 251, 349, 25);
		panel_2.add(rdbtnLaundryKiloanExpress);
		
		JRadioButton rdbtnLaundryKiloanSuper = new JRadioButton("Laundry Kiloan Super Express 10 Jam Selesai");
		rdbtnLaundryKiloanSuper.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLaundryKiloanSuper.setBounds(218, 281, 349, 25);
		panel_2.add(rdbtnLaundryKiloanSuper);
		
		JRadioButton rdbtnLadunrySatuansepatu = new JRadioButton("Ladunry Satuan (Sepatu, Jas, Gaun, dll)");
		rdbtnLadunrySatuansepatu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLadunrySatuansepatu.setBounds(218, 311, 349, 25);
		panel_2.add(rdbtnLadunrySatuansepatu);
		
		JLabel lblJamPenjemputan = new JLabel("Berat Cucian :");
		lblJamPenjemputan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJamPenjemputan.setBounds(92, 350, 99, 16);
		panel_2.add(lblJamPenjemputan);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(218, 60, 349, 25);
		panel_2.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(218, 188, 349, 25);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(218, 345, 113, 25);
		panel_2.add(textField_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setBounds(218, 101, 349, 74);
		panel_2.add(textArea);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("Order");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(button);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
}
