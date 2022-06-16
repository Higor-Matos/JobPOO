import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BotaoAction implements ActionListener {
    UrlHttp urlhttp = new UrlHttp();
    UrlHttps urlhttps = new UrlHttps();
    private JTextField t;
    
    public BotaoAction(JTextField t){
        this.t = t; 
    }

    public void actionPerformed(ActionEvent e) {//Pegando o que foi digitado
        validation(t.getText());
    }

    public void validation(String entrada){
        ArrayList<String> urlsTestadas = new ArrayList<String>();

        if (entrada.contains("https")) {//Verifico o protocolo do endereco
            if(urlhttps.validaUrl(entrada)){//Chamo a função para verificar se o endereco é valido
                urlhttps.setEndereco(entrada);//Quando válido, coloco na varíavel do objeto
                if(!urlhttps.reputacao.verificaReputacaoNaLista(urlhttps.getEndereco())){
                    urlsTestadas.add(urlhttps.getEndereco());//Se não for confiável, adiciona na lista
                    JOptionPane.showMessageDialog(null, "                 URL Não Confiável\n        Adicionada a lista de bloqueio\nURL inserida: " + entrada);
                }else{
                    JOptionPane.showMessageDialog(null, "                 URL Confiável\nURL inserida: " + entrada);
                }
            }
        } else if (entrada.contains("http")) {
            if(urlhttp.validaUrl(entrada)){
                urlhttp.setEndereco(entrada);
            if(!urlhttp.reputacao.verificaReputacaoNaLista(urlhttp.getEndereco()));
                urlsTestadas.add(urlhttp.getEndereco());
                JOptionPane.showMessageDialog(null, "                 URL Não Confiável\n        Adicionada a lista de bloqueio\nURL inserida: " + entrada);
            }else{
                JOptionPane.showMessageDialog(null, "                 URL Confiável\nURL inserida: " + entrada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "                                            URL inválida\nVerifique se inseriu corretamente com o protocolo HTTP ou HTTPS\nExemplo: https://www.google.com.br/\nURL inserida: " + entrada);
        }
        System.out.println("\n >>>> Lista de Urls não confiáveis <<<<\n" + urlsTestadas);
    }


}
