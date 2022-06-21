import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BotaoActionEnviar implements ActionListener {
    ImageIcon icoAtencao = new ImageIcon("D:/App/images/icoAtencao.png");// Icone
    ImageIcon icoErro = new ImageIcon("D:/App/images/icoErro.png");// Icone
    ImageIcon icoOk = new ImageIcon("D:/App/images/icoOk.png");// Icone
    ImageIcon icoVirus = new ImageIcon("D:/App/images/icoVirus.png");// Icone
    public ArrayList<String> urlsBloqueadas = new ArrayList<>();
    private static BotaoActionEnviar botaoActionEnviar;
    private JTextField t;
    UrlHttp urlhttp = new UrlHttp();
    UrlHttps urlhttps = new UrlHttps();

    public boolean addListaTestadas(String x) {
        if (urlsBloqueadas.contains(x)) {
            return true; // Já está na lista, então ignorar
        }
        return false;// Não está na lista, então adicinar
    }

    public BotaoActionEnviar(JTextField t) {
        this.t = t;
    }

    public static BotaoActionEnviar newInstance(JTextField x) {
        if (botaoActionEnviar == null) {
            botaoActionEnviar = new BotaoActionEnviar(x);// Satisfazer construtor padrão);
        }
        return botaoActionEnviar;
    }

    public static BotaoActionEnviar getInstance() {
        return botaoActionEnviar;
    }

    public void actionPerformed(ActionEvent e) {// Pegando o que foi digitado
        validation(t.getText());
    }

    public void validation(String entrada) {
        if (entrada.contains("https")) {// Verifico o protocolo do endereco
            if (urlhttps.validaUrl(entrada)) {// Chamo a função para verificar se o endereco é valido
                urlhttps.setEndereco(entrada);// Quando válido, coloco na varíavel do objeto
                if (urlhttps.reputacao.verificaReputacaoNaLista(urlhttps.getEndereco())) {
                    if (!addListaTestadas(urlhttps.getEndereco())) {// Verifica se está repetido
                        urlsBloqueadas.add(urlhttps.getEndereco());// Se não for confiável, adiciona na lista
                        JOptionPane.showMessageDialog(null,
                                "        Adicionada a lista de bloqueio\nURL inserida: " + entrada, "URL Não Confiável",
                                JOptionPane.INFORMATION_MESSAGE, icoVirus);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "URL inserida:\n" + entrada, "URL Confiável",
                            JOptionPane.INFORMATION_MESSAGE, icoOk);
                    return;
                }
            }
        } else if (entrada.contains("http")) {// Verifico o protocolo do endereco
            if (urlhttp.validaUrl(entrada)) {// Chamo a função para verificar se o endereco é valido
                urlhttp.setEndereco(entrada);// Quando válido, coloco na varíavel do objeto
                if (urlhttp.reputacao.verificaReputacaoNaLista(urlhttp.getEndereco())) {
                    if (!addListaTestadas(urlhttp.getEndereco())) {// Verifica se está repetido
                        urlsBloqueadas.add(urlhttp.getEndereco());// Se não for confiável, adiciona na lista
                        JOptionPane.showMessageDialog(null,
                                "        Adicionada a lista de bloqueio\nURL inserida: " + entrada, "URL Não Confiável",
                                JOptionPane.INFORMATION_MESSAGE, icoVirus);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "URL inserida:\n" + entrada, "URL Confiável",
                            JOptionPane.INFORMATION_MESSAGE, icoOk);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null,
                "Verifique se inseriu corretamente com o protocolo HTTP ou HTTPS\nExemplo: https://www.google.com.br/\nURL inserida: "
                        + entrada,
                "URL Inválida", JOptionPane.INFORMATION_MESSAGE, icoErro);
    }
}