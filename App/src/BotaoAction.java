import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BotaoAction implements ActionListener {

    private JTextField t;

    public BotaoAction(JTextField t){
        this.t = t;
    }
    public void actionPerformed(ActionEvent e) {
        String url = t.getText();
        JOptionPane.showMessageDialog(null, "Foi digitado: " + url);
    }
    
}
