import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList; // import the ArrayList class

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame();//Instaciando Swing
        JPanel p = new JPanel();
        JLabel l = new JLabel("Insira a Url:");
        JTextField t = new JTextField(10);
        JButton b = new JButton("Ok");
        BotaoAction action = new BotaoAction(t);
        f.setTitle("Adguard Hosts");
        f.setSize(300,200);
        f.setLocation(500,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechando de fato o programa

        ImageIcon iconLogo = new ImageIcon("App/images/icoAdguard.png");

        l.setIcon(iconLogo);
        
        p.add(l);
        p.add(t);
        b.addActionListener(action);
        p.add(b);
        f.add(p);
        f.setVisible(true);


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