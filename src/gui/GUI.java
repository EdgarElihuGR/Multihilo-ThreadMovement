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

public class GUI extends JFrame{

    private MiLabel miLbl;

	public GUI() {
		super();
		this.setBounds(400, 100, 500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		miLbl = new MiLabel(this);
		miLbl.setText("");
		miLbl.setOpaque(true);
		this.add(miLbl);
		new Thread(miLbl).start();
	}
}
