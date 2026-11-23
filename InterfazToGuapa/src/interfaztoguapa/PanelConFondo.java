/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaztoguapa;

/**
 *
 * @author Alumno
 */
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelConFondo extends JPanel {
    private Image imagen;

    public PanelConFondo() {
        // Ruta exacta respetando mayúsculas y minúsculas
        URL url = getClass().getResource("/Imagenes/imagen_lateral_original.png");
        if (url != null) {
            this.imagen = new ImageIcon(url).getImage();
        } else {
            System.err.println("No se encontró la imagen: /Imagenes/imagen_lateral_original.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
