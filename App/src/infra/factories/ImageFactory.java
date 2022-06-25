package infra.factories;

import utils.FileUtils;

import javax.swing.*;

public class ImageFactory {

    public static final String ADGUARD = "ADGUARD";
    public static final String ADGUARD_TOP = "ADGUARD_TOP";
    public static final String ATENCAO = "ATENCAO";
    public static final String ERRO = "ERRO";
    public static final String LIST_VIRUS = "LIST_VIRUS";
    public static final String OK = "OK";
    public static final String VAZIO = "VAZIO";
    public static final String VIRUS = "VIRUS";

    public static ImageIcon getImage(String imageName) {
        ImageIcon imageIcon = null;
        switch (imageName) {
            case ADGUARD: imageIcon = imageFactory("icoAdguard.png");
            case ADGUARD_TOP: imageIcon = imageFactory("icoAdguardTop.png");
            case ATENCAO: imageIcon = imageFactory("icoAtencao.png");
            case ERRO: imageIcon = imageFactory("icoErro.png");
            case LIST_VIRUS: imageIcon = imageFactory("icoListVirus.png");
            case OK: imageIcon =  imageFactory("icoOk.png");
            case VAZIO: imageIcon = imageFactory("icoVazio.png");
            case VIRUS: imageIcon = imageFactory("icoVirus.png");
        }
        return imageIcon;
    }

    private static ImageIcon imageFactory(String directory) {
        return new ImageIcon(getDefaultDirectory(directory));
    }

    private static String getDefaultDirectory(String image) {
        return FileUtils.getCurrentDirectory() + "\\App\\src\\domain\\images\\" + image;
    }

}
