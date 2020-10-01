import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class calcu extends JFrame implements ActionListener 
{     
	
	public calcu() 
	{		//JFrame g= new JFrame("Tes");
			
			setTitle("Calculator");  
            setLocation(450,180);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(480, 450);
            
            Container konten1 = getContentPane();
			konten1.setLayout (new BorderLayout());
			JPanel konten2 = new JPanel();
			konten2.setLayout (new GridLayout(4,4,15,15));
			 
			 
			JTextArea screen = new JTextArea(2,25);
			screen.setFocusable(false);
			konten1.add(screen, BorderLayout.NORTH);
			
			JLabel bawah = new JLabel(" © Arman, Dimas, M. Ichsan, Steven");
			Font font = bawah.getFont();
			font = font.deriveFont(font.getSize() * 1.8f);
			bawah.setFont(font);
			bawah.setHorizontalAlignment(JLabel.CENTER);
			bawah.setFocusable(false);
		
			konten1.add(bawah, BorderLayout.SOUTH);
			
			 
			 JButton tombol1 = new JButton("7");
			 JButton tombol2 = new JButton("8");
			 JButton tombol3 = new JButton("9");
			 JButton tombol4 = new JButton("/");
			 JButton tombol5 = new JButton("4");
			 JButton tombol6 = new JButton("5");
			 JButton tombol7 = new JButton("6");
			 JButton tombol8 = new JButton("*");
			 JButton tombol9 = new JButton("1");
			 JButton tombol0 = new JButton("2");
			 JButton tombolplus = new JButton("3");
			 JButton tombolmin = new JButton("-");
			 JButton tombolkali = new JButton("0");
			 JButton tombolbagi = new JButton("c");
			 JButton tombolsama = new JButton("=");
			 JButton tomboldel = new JButton("+");
			 
			 konten2.add(tombol1);
			 konten2.add(tombol2);
			 konten2.add(tombol3);
			 konten2.add(tombol4);
			 konten2.add(tombol5);
			 konten2.add(tombol6);
			 konten2.add(tombol7);
			 konten2.add(tombol8);
			 konten2.add(tombol9);
			 konten2.add(tombol0);
			 konten2.add(tombolplus);
			 konten2.add(tombolmin);
			 konten2.add(tombolkali);
			 konten2.add(tombolbagi);
			 konten2.add(tombolsama);
			 konten2.add(tomboldel);
			 
			 konten1.add(konten2, BorderLayout.CENTER);
			 		
	}
	
	
    public void actionPerformed(ActionEvent e) 
	{
          //System.out.println("Penekanan ke " + ++i);
    }
      private JButton btnkonversi;
      private int i=0;
} 



public class Calculator
{
   public static void main(String[] args) 
   {  
	   JFrame f = new calcu();
       f.setVisible(true);
   }
}

