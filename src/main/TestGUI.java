package main;

import gui.GUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import static gui.GUI.contadorDinamico;

public class TestGUI {

    public static void main(String[] args) throws InterruptedException {
        
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
