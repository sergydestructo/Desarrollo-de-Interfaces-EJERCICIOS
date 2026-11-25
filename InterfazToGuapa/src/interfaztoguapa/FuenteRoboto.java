package interfaztoguapa;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FuenteRoboto {

    public static Font cargarRobotoBold(float tamaño) {
        Font robotoFont = null;
        try {
            // Cargar desde la carpeta resources
            InputStream is = FuenteRoboto.class.getResourceAsStream("/fuentes/Roboto-Bold.ttf");
            if (is == null) {
                // Alternativa si el archivo está en la raíz del proyecto o classpath
                is = ClassLoader.getSystemResourceAsStream("Roboto-Bold.ttf");
            }
            
            robotoFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(tamaño);
            
            // Opcional: registrarla en el entorno gráfico de Java
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(robotoFont);
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Fuente por defecto en caso de error
            robotoFont = new Font("SansSerif", Font.PLAIN, (int) tamaño);
        }
        return robotoFont;
    }
}