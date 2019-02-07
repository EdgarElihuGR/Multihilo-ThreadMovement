package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;

import javax.swing.JLabel;

public class MiLabel extends JLabel implements Runnable {

    	private JFrame window;

	Random ran = new Random();
	private int num;

	public MiLabel(JFrame window) {
		super();
		this.window = window;
		this.setVisible(true);
		this.setLocation((int)(Math.random() * window.getWidth()), (int)(Math.random() * window.getHeight()));
		this.setSize(20, 20);
		this.setOpaque(true);
		this.setText("");
		num = ran.nextInt(8) + 1;
		switch (num) {
		case 1:
			this.setBackground(Color.RED);
			break;
		case 2:
			this.setBackground(Color.BLUE);
			break;
		case 3:
			this.setBackground(Color.CYAN);
			break;
		case 4:
			this.setBackground(Color.DARK_GRAY);
			break;
		case 5:
			this.setBackground(Color.MAGENTA);
			break;
		case 6:
			this.setBackground(Color.ORANGE);
			break;
		case 7:
			this.setBackground(Color.YELLOW);
			break;
		case 8:
			this.setBackground(Color.GREEN);
			break;
		default:
			break;
		}
		System.out.println("Location: "+this.getLocation().getX()+","+this.getLocation().getY());
		this.window.add(this);
		this.window.repaint();
	}

	@Override
	public void run() {
		System.out.println("Iniciando...");
		try {
			Thread.sleep(500);
			MiLabel lbl = new MiLabel(window);
			new Thread(lbl).start();
			Thread.sleep(500);
			this.window.remove(this);
			this.window.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminado...");
	}
}
