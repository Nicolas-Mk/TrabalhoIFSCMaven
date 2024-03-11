package utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageUtils {

    public static void resizeImageAndSetIcon(File selectedFile, JLabel iconLabel, int newWidth, int newHeight) throws Exception {
        // Carrega a imagem original a partir do arquivo selecionado
        BufferedImage originalImage = ImageIO.read(selectedFile);

        // Redimensiona a imagem para as novas dimensões
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Cria um BufferedImage a partir da imagem redimensionada
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        // Define o ícone do JLabel para a imagem redimensionada
       
        ImageIcon imageIcon = new ImageIcon(outputImage);
        iconLabel.setIcon(imageIcon);
    }
}
