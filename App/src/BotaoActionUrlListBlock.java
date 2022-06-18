import javax.swing.*;
import java.awt.event.*;


import javax.swing.JOptionPane;

public class BotaoActionUrlListBlock implements ActionListener {
    private JTextField t;
    private BotaoActionEnviar botaoActionEnviar = BotaoActionEnviar.newInstance(t);

    public BotaoActionUrlListBlock(JTextField t){
        this.t = t; 
    }

    public void actionPerformed(ActionEvent e) {//Pegando o que foi digitado
        String output = "";
        for(int i = 0; i<botaoActionEnviar.urlsBloqueadas.size(); i++){
            String everything = botaoActionEnviar.urlsBloqueadas.get(i).toString();

            output += everything + "\n";       
        }
        JOptionPane.showMessageDialog(null, output);
    }         
}
