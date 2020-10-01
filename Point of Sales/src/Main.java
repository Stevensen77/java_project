import java.awt.Dialog.ModalityType;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    JFrame frame1 = new JFrame();
    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame1.setUndecorated(true);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setVisible(true);

    JDialog nonModalDialog = new JDialog(frame1, "Non-Modal Dialog",
        ModalityType.MODELESS);
    nonModalDialog.add(Box.createRigidArea(new Dimension(200, 200)));
    nonModalDialog.pack();
    nonModalDialog.setVisible(true);

    JDialog modalDialog = new JDialog(frame1, "Modal Dialog",
        ModalityType.APPLICATION_MODAL);
    modalDialog.add(Box.createRigidArea(new Dimension(200, 200)));
    modalDialog.pack();
    modalDialog.setVisible(true);

  }
}