import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
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

        JTextField campoInsercao = new JTextField(25);

        JButton enviar = new JButton("Enviar");
        BotaoAction action = new BotaoAction(campoInsercao);
        enviar.addActionListener(action);
        JButton listBlock = new JButton("Lista de Bloqueio");
        

        JPanel p = new JPanel(); 
        p.add(new JLabel("Insira uma URL:")); 
        p.add(campoInsercao);
        p.add(enviar);
        p.add(listBlock);
        
        frame.add(p,BorderLayout.CENTER);
        
        frame.setVisible(true);//Apresentando a janela
        

        Scanner scanner = new Scanner(System.in);
        UrlHttp urlhttp = new UrlHttp();
        UrlHttps urlhttps = new UrlHttps();
        ArrayList<String> urlsNaoConfiaveis = new ArrayList<String>();
        do{

            System.out.print("Insira a Url para verificar confiabilidade.\nExemplo: https://www.google.com.br/\nUrl: ");
            String Entrada = scanner.next();

            if (Entrada.contains("https")) {//Verifico o protocolo do endereco
                if(urlhttps.validaUrl(Entrada)){//Chamo a função para verificar se o endereco é valido
                    urlhttps.setEndereco(Entrada);//Quando válido, coloco na varíavel do objeto
                    if(!urlhttps.reputacao.verificaReputacaoNaLista(urlhttps.getEndereco())){
                        urlsNaoConfiaveis.add(urlhttps.getEndereco());//Se não for confiável, adiciona na lista
                    }
                }
            } else if (Entrada.contains("http")) {
                if(urlhttp.validaUrl(Entrada)){
                    urlhttp.setEndereco(Entrada);
                if(!urlhttp.reputacao.verificaReputacaoNaLista(urlhttp.getEndereco()));
                    urlsNaoConfiaveis.add(urlhttp.getEndereco());
                }
            } else {
                System.out.println(">>> URL inválida <<< \nVerifique se inseriu corretamente com o protocolo HTTP ou HTTPS");
            }

            System.out.println("\n >>>> Lista de Urls não confiáveis <<<<\n" + urlsNaoConfiaveis);
        }while(true);
    }
}