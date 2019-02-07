package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements KeyListener {

    private MiLabel miLbl;

    public GUI() {
        super("Threads");
        this.setBounds(400, 100, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        addKeyListener(this);

        miLbl = new MiLabel();
        miLbl.setText("Thread");

        getContentPane().add(miLbl);
        new Thread(miLbl).start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {

            miLbl.setLocation(miLbl.getX(), miLbl.getY() - 5);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            miLbl.setLocation(miLbl.getX(), miLbl.getY() + 5);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
            miLbl.setLocation(miLbl.getX() - 5, miLbl.getY());
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
            miLbl.setLocation(miLbl.getX() + 5, miLbl.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
