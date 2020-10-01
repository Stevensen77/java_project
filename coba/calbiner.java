import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class calcu extends JFrame implements ActionListener 
{     
	
	private JTextField layar;
	private JRadioButton rbbiner;
	private JRadioButton rbdesimal;
	private JButton tombol0;
	private JButton tombol1;
	private JButton tombol2;
	private JButton tombol3;
	private JButton tombolconv;
	private JButton tombol4;
	private JButton tombol5;
	private JButton tombol6;
	private JButton tombolclr;
	private JButton tombol7;
	private JButton tombol8;
	private JButton tombol9;
	private JButton tombolbc;
	public static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 25);
	public static final Font CALIBRI_FONT = new Font("Calibri", Font.BOLD, 25);
	public static final Font TNR_FONT = new Font("Times New Roman", Font.BOLD, 25);
	public static final Font CONSOLAS_FONT = new Font("Consolas", Font.BOLD, 25);
	public static final Font size1_FONT = new Font("", Font.BOLD, 12);
	public static final Font size2_FONT = new Font("", Font.BOLD, 25);
	public static final Font size3_FONT = new Font("", Font.BOLD, 40);
	
	
	static JMenuBar menuBar;
	static JMenu menu, submenu,zoom,view;
	static JMenuItem menuItem,full,normal,help,about,isiabout,isiabout1,decimal,aturfont,calibri,tnr,consolas,fontsize,font12,fontnormal,font40;
	static JRadioButtonMenuItem rbMenuItem;
	static JCheckBoxMenuItem cbMenuItem;
	
	public calcu() 
	{		
			
			setTitle("Calculator");  
            		
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
            
            Container konten1 = getContentPane();
			konten1.setLayout (new BorderLayout());
			JPanel konten2 = new JPanel();
			konten2.setLayout (new GridLayout(3,4,10,10));
			JPanel konten3 = new JPanel();
			konten3.setLayout (new BorderLayout());
			JPanel konten4 = new JPanel();
			konten4.setLayout (new FlowLayout());
			JPanel konten5 = new JPanel();
			konten5.setLayout (new GridLayout(2,1,0,0));
			 
			konten1.add(konten3, BorderLayout.NORTH);
			konten3.add(konten4, BorderLayout.CENTER);
			
			layar = new JTextField();
			layar.setPreferredSize( new Dimension( 400, 60 ) );
			layar.setHorizontalAlignment(SwingConstants.RIGHT);
			layar.setFont(BTN_FONT);
			layar.setFocusable(false);
			konten3.add(layar, BorderLayout.NORTH);
			
			JLabel modecalcu = new JLabel("Mode :");
			konten4.add(modecalcu);
			
			
			
			rbdesimal = new JRadioButton("Desimal");
			rbbiner = new JRadioButton("Biner");
			ButtonGroup ngumpul = new ButtonGroup();
			rbdesimal.setSelected(true);
			ngumpul.add(rbdesimal);
			ngumpul.add(rbbiner);
			konten4.add(rbdesimal);
			konten4.add(rbbiner);
			rbdesimal.addActionListener(this);
			rbbiner.addActionListener(this);
			
			JLabel bawah = new JLabel("\u00a9"+" Arman, Dimas, M. Ichsan, Steven");
			Font font = bawah.getFont();
			font = font.deriveFont(font.getSize() * 1.0f);
			bawah.setFont(font);
			bawah.setHorizontalAlignment(JLabel.CENTER);
			bawah.setFocusable(false);
		
			konten1.add(bawah, BorderLayout.SOUTH);
			
			 tombolbc = new JButton("<<");
			 tombolclr = new JButton("Clear");
			 
			 tombol1 = new JButton("1");
			 tombol2 = new JButton("2");
			 tombol3 = new JButton("3");
			 tombolconv = new JButton("Conv");
			 tombol4 = new JButton("4");
			 tombol5 = new JButton("5");
			 tombol6 = new JButton("6");
			 //tombolclr = new JButton("Clr");
			 tombol7 = new JButton("7");
			 tombol8 = new JButton("8");
			 tombol9 = new JButton("9");
			 tombol0 = new JButton("0");
			 
			 
			 konten5.add(tombolbc);
			 konten5.add(tombolclr);
			 
			 konten2.add(tombol1);
			 konten2.add(tombol2);
			 konten2.add(tombol3);
			 konten2.add(tombolconv);
			 konten2.add(tombol4);
			 konten2.add(tombol5);
			 konten2.add(tombol6);
			 konten2.add(konten5);
			 konten2.add(tombol7);
			 konten2.add(tombol8);
			 konten2.add(tombol9);
			 konten2.add(tombol0);

			tombol1.addActionListener(this);
			tombol2.addActionListener(this);
			tombol3.addActionListener(this);
			tombolconv.addActionListener(this);
			tombol4.addActionListener(this);
			tombol5.addActionListener(this);
			tombol6.addActionListener(this);
			tombolclr.addActionListener(this);
			tombol7.addActionListener(this);
			tombol8.addActionListener(this);
			tombol9.addActionListener(this);
			tombol0.addActionListener(this);
			
			tombolbc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {                                        

			String news = null;

			  if (layar.getText().length() > 0) { //f1 is a textfield      
			 StringBuilder strB = new StringBuilder(layar.getText());  
			 strB.deleteCharAt(layar.getText().length() -1);
			news = strB.toString();                 }
			layar.setText(news);/////set the updated text

			}}
			);           
			
			
			tombol1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			layar.setText(layar.getText()+"1");
			}
			}
			);
			
			tombol2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"2");}
			}
			}
			);
			
			tombol3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"3");}
			}
			}
			);
			
			tombol4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"4");}
			}
			}
			);
			
			
			
			tombol5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"5");}
			}
			}
			);

			tombol6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"6");}
			}
			}
			); 
			
			tombol7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"7");}
			}
			}
			);
			
			tombol8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"8");}
			}
			}
			);
			
			tombol9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbbiner.isSelected())
				{}
				else
				{layar.setText(layar.getText()+"9");}
			}
			}
			);
			
			tombolclr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			layar.setText("");
			}
			});
			
			tombol0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
						int teks0 = Integer.parseInt(layar.getText());
						if(teks0 != 0){
						layar.setText(layar.getText()+"0");}
					}	
				catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Input salah/terlalu berlebih!!");				
					}
				
			}
			}
			);
			
			tombolconv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(rbdesimal.isSelected())
				{
						String ambilteksdesimal;
						ambilteksdesimal = layar.getText();
					
						String hasilbiner = Integer.toBinaryString(Integer.parseInt(ambilteksdesimal));
						
						layar.setText(hasilbiner);
				
				}
			else if (rbbiner.isSelected())
				{
					String ambilteksbiner;
					ambilteksbiner = layar.getText();
					String hasildesimal = Integer.toString(Integer.parseInt(ambilteksbiner, 2));
					layar.setText(hasildesimal);
					
				}
			}
			}
			);
			 
			 konten1.add(konten2, BorderLayout.CENTER);
			 pack();
			 setVisible(true);
	
	
menuBar = new JMenuBar();
//Build the first menu.
menu = new JMenu("Edit");
menu.setMnemonic(KeyEvent.VK_A);
menu.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
menuBar.add(menu);

menu.addSeparator();
aturfont = new JMenu("Jenis Font");
aturfont.setMnemonic(KeyEvent.VK_S);
menu.add(aturfont);

calibri = new JMenuItem("Calibri");
calibri.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
aturfont.add(calibri);
calibri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              layar.setFont(CALIBRI_FONT);
            }});
			
tnr = new JMenuItem("Times New Roman");
tnr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
aturfont.add(tnr);
tnr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              layar.setFont(TNR_FONT);
            }});

consolas = new JMenuItem("Consolas");
consolas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
aturfont.add(consolas);
consolas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              layar.setFont(CONSOLAS_FONT);
            }});

			
menu.addSeparator();
fontsize = new JMenu("Font SIZE");
fontsize.setMnemonic(KeyEvent.VK_S);
menu.add(fontsize);

fontnormal = new JMenuItem("DEFAULT");
fontnormal.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
fontsize.add(fontnormal);
fontnormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            layar.setFont(size2_FONT);
            }});

font12 = new JMenuItem("12");
font12.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
fontsize.add(font12);
font12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            layar.setFont(size1_FONT);
            }});
			
font40 = new JMenuItem("40");
font40.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
fontsize.add(font40);
font40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            layar.setFont(size3_FONT);
            }});
			
menu.addSeparator();
//a group of JMenuItems
menuItem = new JMenuItem("Save work?",
                         KeyEvent.VK_T);
menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_1, ActionEvent.ALT_MASK));
menuItem.getAccessibleContext().setAccessibleDescription(
        "This doesn't really do anything");
menu.add(menuItem);



//Build second menu in the menu bar.
view = new JMenu("View");
view.setMnemonic(KeyEvent.VK_N);
view.getAccessibleContext().setAccessibleDescription(
        "This menu does nothing");
menuBar.add(view);



view.addSeparator();
submenu = new JMenu("Tampilan");
submenu.setMnemonic(KeyEvent.VK_S);
view.add(submenu);

normal = new JMenuItem("Normal");
normal.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
submenu.add(normal);
normal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setSize(600,400);
			   setLocation(350,180);
            }});

full = new JMenuItem("Fullscreen");
submenu.add(full);

full.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setExtendedState(JFrame.MAXIMIZED_BOTH);
            }});

menu.addSeparator();
cbMenuItem = new JCheckBoxMenuItem("HIDE");
cbMenuItem.setMnemonic(KeyEvent.VK_C);
view.add(cbMenuItem);

cbMenuItem = new JCheckBoxMenuItem("SHOW");
cbMenuItem.setMnemonic(KeyEvent.VK_C);
view.add(cbMenuItem);


help = new JMenu("Help");
help.setMnemonic(KeyEvent.VK_N);
help.getAccessibleContext().setAccessibleDescription(
        "This menu does nothing");
menuBar.add(help);

menu.addSeparator();
about = new JMenu("ABOUT");
help.add(about);
about.setMnemonic(KeyEvent.VK_S);

isiabout1 = new JMenuItem("Project RPL Calculator Biner Desimal");
about.add(isiabout1);

isiabout = new JMenuItem("Arman | Dimas | Ichsan | Steven");
isiabout.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
about.add(isiabout);

setJMenuBar(menuBar);
	}
	
	
    public void actionPerformed(ActionEvent e) 
	{
		Object obj = e.getSource();
       if (obj instanceof JRadioButton) 
	{ 
			if(rbbiner.isSelected())
			{
				tombol2.setEnabled(false);
				tombol3.setEnabled(false);
				tombol4.setEnabled(false);
				tombol5.setEnabled(false);
				tombol6.setEnabled(false);
				tombol7.setEnabled(false);
				tombol8.setEnabled(false);
				tombol9.setEnabled(false);
				
			}
            else
			{
				tombol2.setEnabled(true);
				tombol3.setEnabled(true);
				tombol4.setEnabled(true);
				tombol5.setEnabled(true);
				tombol6.setEnabled(true);
				tombol7.setEnabled(true);
				tombol8.setEnabled(true);
				tombol9.setEnabled(true);
			}
        }

    }

} 



public class calbiner
{
   public static void main(String[] args) 
   {  
	   JFrame f = new calcu();
      f.setSize(600, 400);
	  f.setLocation(350,180);

   }
}

