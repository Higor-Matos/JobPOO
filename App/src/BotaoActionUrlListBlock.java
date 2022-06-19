import javax.swing.*;
import java.awt.event.*;


import javax.swing.JOptionPane;

public class BotaoActionUrlListBlock implements ActionListener {
    ImageIcon icoListVirus = new ImageIcon("App/images/icoListVirus.png");//Icone
    ImageIcon icoVazio = new ImageIcon("App/images/icoVazio.png");//Icone
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
        if(botaoActionEnviar.urlsBloqueadas.size() != 0){//Tratando quando a lista está vazia
            JOptionPane.showMessageDialog(null,"URLs não confiáveis testadas:\n" + output, "URLs Não Confiáveis Testadas", JOptionPane.INFORMATION_MESSAGE, icoListVirus);
        }else{
            JOptionPane.showMessageDialog(null,"Nenhuma URL não confiável testada" + output, "ERRO", JOptionPane.INFORMATION_MESSAGE, icoVazio);
        }
    }         
}
