package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.currentThread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {

    public static int contadorDinamico = 0;
    public static int contadorIncremental = 0;
    private MiLabel miLbl;

    public GUI() throws InterruptedException {
        super("Thread Movement");
        this.setBounds(400, 100, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        miLbl = new MiLabel(this);
        miLbl.setText(Integer.toString(GUI.contadorDinamico));
        miLbl.setForeground(Color.white);
        miLbl.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        miLbl.setHorizontalAlignment(JLabel.CENTER);
        miLbl.setVerticalAlignment(JLabel.CENTER);
        miLbl.setOpaque(true);
        this.add(miLbl);
        new Thread(miLbl).start();

    }
}
