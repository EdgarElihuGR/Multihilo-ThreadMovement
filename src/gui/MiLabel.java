package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;

public class MiLabel extends JLabel implements Runnable {

    private int left = 0, right = 465, top = 0, bottom = 420;
    private int x = right / 2, y = bottom / 2;
    private int numRan;
    Random ran = new Random();

    public MiLabel() {
        super();
        this.setLocation(x, y);
        this.setVisible(true);
    }

    @Override
    public void run() {

        try {

            //Thread.sleep(2000);
            while (true) {

                numRan = ran.nextInt(8) + 1;

                if (numRan == 1) {

                    moverDerecha();
                } else if (numRan == 2) {

                    moverIzquierda();
                } else if (numRan == 3) {

                    moverArriba();
                } else if (numRan == 4) {

                    moverAbajo();
                } else if (numRan == 5) {

                    moverDerechaArriba();
                } else if (numRan == 6) {

                    moverDerechaAbajo();
                } else if (numRan == 7) {

                    moverIzquierdaArriba();
                } else {

                    moverIzquierdaAbajo();
                }

            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void moverDerecha() throws InterruptedException {

        while (x <= 435) {
            Thread.sleep(7);
            x += 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverIzquierda() throws InterruptedException {

        while (x >= 0) {
            Thread.sleep(7);
            x -= 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverArriba() throws InterruptedException {

        while (y >= 3) {
            Thread.sleep(7);
            y -= 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverAbajo() throws InterruptedException {

        while (y <= 420) {
            Thread.sleep(7);
            y += 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverDerechaArriba() throws InterruptedException {

        while (x <= 442 && y >= 0) {
            Thread.sleep(7);
            x += 1;
            y -= 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverDerechaAbajo() throws InterruptedException {

        while (x <= 442 && y <= 420) {
            Thread.sleep(7);
            x += 1;
            y += 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverIzquierdaArriba() throws InterruptedException {

        while (x >= 0 && y >= 0) {
            Thread.sleep(7);
            x -= 1;
            y -= 1;
            this.setBounds(x, y, 50, 50);
        }
    }

    public void moverIzquierdaAbajo() throws InterruptedException {

        while (x >= 0 && y <= 420) {
            Thread.sleep(7);
            x -= 1;
            y += 1;
            this.setBounds(x, y, 50, 50);
        }
    }
}
