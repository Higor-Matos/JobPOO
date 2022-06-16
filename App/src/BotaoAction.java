import javax.swing.*;
import java.awt.event.*;
public class BotaoAction implements ActionListener {
    private JTextField t;
    
    public BotaoAction(JTextField t){
        this.t = t; 
    }

    public void actionPerformed(ActionEvent e) {
        String nome = t.getText();
        JOptionPane.showMessageDialog(null, "URL: " + nome);
    }


    
}
