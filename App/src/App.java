import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList; // import the ArrayList class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App{
    public static void main(String[] args) {

        JFrame frame = new JFrame(); //Janela
        frame.setSize (500, 600); 
        frame.setLocationRelativeTo(null);//Centralizando janela no meio
        frame.setTitle("Adguard Hosts");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);//Impedindo redimensionamento
        
        ImageIcon imagePng = new ImageIcon("App/images/icoAdguardTop.png");//Imagem
        JLabel image = new JLabel();
        image.setIcon(imagePng);
        frame.add(image,BorderLayout.NORTH);        

        JPanel p = new JPanel();
        p.add(new JLabel("Insira URL para verificar confiabilidade:")); 
        JTextField campoInsercao = new JTextField(25);
        p.add(campoInsercao);
        p.add(new JLabel("Exemplo: https://www.google.com.br/"));

        
        JButton enviar = new JButton("Enviar");
        BotaoAction action = new BotaoAction(campoInsercao);
        enviar.addActionListener(action);

        JButton listBlock = new JButton("URLs Bloqueadas");

        enviar.setBounds(185, 190, 120, 30);
        listBlock.setBounds(155, 500, 180, 30);
        frame.add(enviar);
        frame.add(listBlock);
        frame.add(p,BorderLayout.CENTER);
        
        frame.setVisible(true);//Apresentando a janela
        
        String entrada = campoInsercao.getText();


    }
}