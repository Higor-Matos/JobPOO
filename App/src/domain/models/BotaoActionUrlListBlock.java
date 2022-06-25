package domain.models;

import domain.entities.BlockedUrls;
import infra.RealTimeDatabase;
import infra.factories.ImageFactory;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class BotaoActionUrlListBlock implements ActionListener {
    ImageIcon icoListVirus = ImageFactory.getImage(ImageFactory.LIST_VIRUS);// Icone
    ImageIcon icoVazio = ImageFactory.getImage(ImageFactory.VAZIO);// Icone
    private JTextField t;
    private BotaoActionEnviar botaoActionEnviar = new BotaoActionEnviar(t);

    public BotaoActionUrlListBlock(JTextField t) {
        this.t = t;
    }

    public void actionPerformed(ActionEvent e) {// Pegando o que foi digitado
        String output = "";
        List<String> urlsBloqueadas = RealTimeDatabase.blockedUrls.stream().map(BlockedUrls::getUrl).collect(Collectors.toList());
        for (int i = 0; i < urlsBloqueadas.size(); i++) {
            String everything = urlsBloqueadas.get(i);

            output += everything + "\n";
        }
        if (urlsBloqueadas.size() != 0) {// Tratando quando a lista está vazia
            JOptionPane.showMessageDialog(null, "URLs não confiáveis testadas:\n" + output,
                    "URLs Não Confiáveis Testadas", JOptionPane.INFORMATION_MESSAGE, icoListVirus);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma URL não confiável testada" + output, "ERRO",
                    JOptionPane.INFORMATION_MESSAGE, icoVazio);
        }
    }
}
