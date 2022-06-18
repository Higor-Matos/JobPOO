import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class BotaoActionEnviar implements ActionListener {
    public ArrayList<String> urlsBloqueadas = new ArrayList<>();
    private static BotaoActionEnviar botaoActionEnviar;
    private JTextField t;
    UrlHttp urlhttp = new UrlHttp();
    UrlHttps urlhttps = new UrlHttps();

    public boolean addListaTestadas(String x){
        if(urlsBloqueadas.contains(x)){
            JOptionPane.showMessageDialog(null, "                 URL Já Testada\n        Encontra-se na lista de bloqueio\nURL inserida: " + x);
            return true; //Já está na lista, então ignorar
        }
        return false;//Não está na lista, então adicinar
    }

    public BotaoActionEnviar(JTextField t){
        this.t = t; 
    }

    public static BotaoActionEnviar newInstance(JTextField x){
        if(botaoActionEnviar == null){
            botaoActionEnviar = new BotaoActionEnviar(x);//Satisfazer construtor padrão);
        }
        return botaoActionEnviar;
    }

    public static BotaoActionEnviar getInstance(){
        return botaoActionEnviar;
    }

    public void actionPerformed(ActionEvent e) {//Pegando o que foi digitado
        validation(t.getText());
    }


    public void validation(String entrada){
        if (entrada.contains("https")) {//Verifico o protocolo do endereco
            if(urlhttps.validaUrl(entrada)){//Chamo a função para verificar se o endereco é valido
                urlhttps.setEndereco(entrada);//Quando válido, coloco na varíavel do objeto
                if(!urlhttps.reputacao.verificaReputacaoNaLista(urlhttps.getEndereco())){
                    if(!addListaTestadas(urlhttps.getEndereco())){//Verifica se está repetido
                        urlsBloqueadas.add(urlhttps.getEndereco());//Se não for confiável, adiciona na lista
                        JOptionPane.showMessageDialog(null, "                 URL Não Confiável\n        Adicionada a lista de bloqueio\nURL inserida: " + entrada);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "                 URL Confiável\nURL inserida: " + entrada);
                }
            }
        } else if (entrada.contains("http")) {
            if(urlhttp.validaUrl(entrada)){
                urlhttp.setEndereco(entrada);
            if(!urlhttp.reputacao.verificaReputacaoNaLista(urlhttp.getEndereco()));
                if(!addListaTestadas(urlhttp.getEndereco())){//Verifica se está repetido
                    urlsBloqueadas.add(urlhttp.getEndereco());//Se não for confiável, adiciona na lista
                    JOptionPane.showMessageDialog(null, "                 URL Não Confiável\n        Adicionada a lista de bloqueio\nURL inserida: " + entrada);
                }
            }else{
                JOptionPane.showMessageDialog(null, "                 URL Confiável\nURL inserida: " + entrada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "                                            URL inválida\nVerifique se inseriu corretamente com o protocolo HTTP ou HTTPS\nExemplo: https://www.google.com.br/\nURL inserida: " + entrada);
        }
    }
}
