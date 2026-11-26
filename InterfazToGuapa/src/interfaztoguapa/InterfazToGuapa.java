/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaztoguapa;

import javax.swing.SwingUtilities;

/**
 *
 * @author Alumno Mañana
 */
public class InterfazToGuapa {

    public static void main(String[] args) {
        // Se usa SwingUtilities.invokeLater para ejecutar la interfaz de forma segura
        SwingUtilities.invokeLater(() -> {
            Ventanuco ventana = new Ventanuco();
            ventana.setVisible(true);
        });
    }
    
}
