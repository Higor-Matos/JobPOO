import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;

public class App{
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //Janela
        frame.setSize (500, 600); 
        frame.setLocationRelativeTo(null);//Centralizando janela no meio
        frame.setTitle("Adguard Hosts");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout());
        //frame.setResizable(false);//Impedindo redimensionamento
        
        ImageIcon imagePng = new ImageIcon("App/images/icoAdguardTop.png");//Imagem
        JLabel image = new JLabel();
        image.setIcon(imagePng);
        frame.add(image,BorderLayout.NORTH);        

        JPanel p = new JPanel();
        p.add(new JLabel("Insira URL para verificar confiabilidade:")); 
        JTextField campoInsercao = new JTextField(35);
        campoInsercao.setBounds(100,25,300,20);
        p.add(campoInsercao);
        JLabel exemplo = new JLabel("Exemplo: https://www.google.com.br/");
        exemplo.setBounds(140,43,300,30);
        p.add(exemplo);
        
        
        JButton enviar = new JButton("Enviar");
        BotaoActionEnviar actionEnviar = BotaoActionEnviar.newInstance(campoInsercao);
        enviar.addActionListener(actionEnviar);

        JButton listBlock = new JButton("URLs Bloqueadas");
        BotaoActionUrlListBlock actionListBlock = new BotaoActionUrlListBlock(new JTextField());
        listBlock.addActionListener(actionListBlock);
        
        Reputacao r = new Reputacao();
        JTextArea textArea = new JTextArea(r.getListaNaoConfiavel());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("URLs não confiáveis Adguard"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                                scroll.getBorder()));
        scroll.setBounds(35, 120, 416, 250);
        textArea.setBounds(35, 120, 416, 250);
        p.setLayout(null); //change jpanel layout to null
        p.add(scroll);


        enviar.setBounds(185, 190, 120, 30);
        listBlock.setBounds(155, 500, 180, 30);
        frame.add(enviar);
        frame.add(listBlock);
        frame.add(p);
        //frame.add(textArea);
        //frame.pack();
        frame.setVisible(true);//Apresentando a janela

    }
}