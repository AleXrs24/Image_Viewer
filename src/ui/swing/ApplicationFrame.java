package ui.swing;

import userInterface.ImageViewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private ImageViewer imageViewer;
    private ActionListenerFactory factory;
    
    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Browser");
        this.factory = factory;
        this.setSize(1040, 850);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    
}
