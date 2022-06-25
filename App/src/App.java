import domain.models.BotaoActionEnviar;
import domain.models.BotaoActionUrlListBlock;
import domain.models.Reputacao;
import infra.factories.ImageFactory;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class App {
    private static void setFont(FontUIResource myFont) {
        UIManager.put("CheckBoxMenuItem.acceleratorFont", myFont);
        UIManager.put("Button.font", myFont);
        UIManager.put("ToggleButton.font", myFont);
        UIManager.put("RadioButton.font", myFont);
        UIManager.put("CheckBox.font", myFont);
        UIManager.put("ColorChooser.font", myFont);
        UIManager.put("ComboBox.font", myFont);
        UIManager.put("Label.font", myFont);
        UIManager.put("List.font", myFont);
        UIManager.put("MenuBar.font", myFont);
        UIManager.put("Menu.acceleratorFont", myFont);
        UIManager.put("RadioButtonMenuItem.acceleratorFont", myFont);
        UIManager.put("MenuItem.acceleratorFont", myFont);
        UIManager.put("MenuItem.font", myFont);
        UIManager.put("RadioButtonMenuItem.font", myFont);
        UIManager.put("CheckBoxMenuItem.font", myFont);
        UIManager.put("OptionPane.buttonFont", myFont);
        UIManager.put("OptionPane.messageFont", myFont);
        UIManager.put("Menu.font", myFont);
        UIManager.put("PopupMenu.font", myFont);
        UIManager.put("OptionPane.font", myFont);
        UIManager.put("Panel.font", myFont);
        UIManager.put("ProgressBar.font", myFont);
        UIManager.put("ScrollPane.font", myFont);
        UIManager.put("Viewport.font", myFont);
        UIManager.put("TabbedPane.font", myFont);
        UIManager.put("Slider.font", myFont);
        UIManager.put("Table.font", myFont);
        UIManager.put("TableHeader.font", myFont);
        UIManager.put("TextField.font", myFont);
        UIManager.put("Spinner.font", myFont);
        UIManager.put("PasswordField.font", myFont);
        UIManager.put("TextArea.font", myFont);
        UIManager.put("TextPane.font", myFont);
        UIManager.put("EditorPane.font", myFont);
        UIManager.put("TabbedPane.smallFont", myFont);
        UIManager.put("TitledBorder.font", myFont);
        UIManager.put("ToolBar.font", myFont);
        UIManager.put("ToolTip.font", myFont);
        UIManager.put("Tree.font", myFont);
        UIManager.put("FormattedTextField.font", myFont);
        UIManager.put("IconButton.font", myFont);
        UIManager.put("InternalFrame.optionDialogTitleFont", myFont);
        UIManager.put("InternalFrame.paletteTitleFont", myFont);
        UIManager.put("InternalFrame.titleFont", myFont);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        JFrame frame = new JFrame(); // Janela
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);// Centralizando janela no meio
        frame.setTitle("Adguard Hosts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);// Impedindo redimensionamento

        ImageIcon imagePng = ImageFactory.getImage(ImageFactory.ADGUARD_TOP);// Imagem
        ImageIcon iconePng = ImageFactory.getImage(ImageFactory.ADGUARD);// Icone
        JLabel image = new JLabel();
        image.setIcon(imagePng);
        frame.add(image, BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.add(new JLabel("Insira URL para verificar confiabilidade:"));
        JTextField campoInsercao = new JTextField(340);
        campoInsercao.setBounds(100, 25, 300, 22);
        p.add(campoInsercao);
        JLabel exemplo = new JLabel("Exemplo: https://www.google.com.br/");
        exemplo.setBounds(140, 43, 300, 30);
        p.add(exemplo);

        JButton enviar = new JButton("Enviar");
        BotaoActionEnviar actionEnviar = new BotaoActionEnviar(campoInsercao);
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
                                BorderFactory.createEmptyBorder(5, 5, 5, 5)),
                        scroll.getBorder()));
        scroll.setBounds(35, 120, 416, 250);
        textArea.setBounds(35, 120, 416, 250);
        p.setLayout(null); // change jpanel layout to null
        p.add(scroll);

        //Em processo
        String s1[] = { "Times New Roman", "Arial", "Lista Adblock" };
        JComboBox c1 = new JComboBox(s1);
        c1.setBounds(30, 190, 100, 30);
        frame.add(c1);
        c1.getSelectedItem();
        String selectJComboBox = c1.getSelectedItem() + "";

        if (selectJComboBox.equals("Times New Roman")) {
            setFont(new FontUIResource(new Font("Times New Roman", Font.PLAIN, 12)));
            SwingUtilities.updateComponentTreeUI(frame);
        }


        enviar.setBounds(185, 190, 120, 30);
        listBlock.setBounds(155, 500, 180, 30);
        frame.add(enviar);
        frame.add(listBlock);
        frame.add(p);
        frame.setIconImage(iconePng.getImage());
        frame.setVisible(true);// Apresentando a janela

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setFont(new FontUIResource(new Font("Roboto Regular", Font.PLAIN, 12)));
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
