package gui;

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

    private JPanel mainPanel;
    private JLabel lbl;

    public GUI() {
        super("Threads");
        setBounds(400, 100, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);

        mainPanel = new JPanel();
        lbl = new JLabel("Thread");

        mainPanel.add(lbl);
        getContentPane().add(mainPanel);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
            lbl.setLocation(lbl.getX(), lbl.getY() - 5);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            lbl.setLocation(lbl.getX(), lbl.getY() + 5);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
            lbl.setLocation(lbl.getX() - 5, lbl.getY());
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
            lbl.setLocation(lbl.getX() + 5, lbl.getY());
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
