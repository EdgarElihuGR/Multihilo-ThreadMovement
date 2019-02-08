package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.xml.bind.DatatypeConverter;
import static gui.GUI.contadorDinamico;

public class MiLabel extends JLabel implements Runnable {

    private JFrame window;
    private static final int SIZELBL = 40;
    private int num;
    private int x = 0;
    private int y = 0;
    private int lapso = 5;
    private int limiteTiempo;
    private int iteraciones = 0;
    Random ran = new Random();

    public MiLabel() {

    }

    public MiLabel(JFrame window) {
        super();
        this.window = window;
        this.setVisible(true);
        this.setLocation((int) (Math.random() * window.getWidth()), (int) (Math.random() * window.getHeight()));
        this.setSize(SIZELBL, SIZELBL);
        this.setOpaque(true);
        this.setText("");
        limiteTiempo = 10000 / lapso;

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
                this.setBackground(Color.LIGHT_GRAY);
                break;
            case 8:
                this.setBackground(Color.GREEN);
                break;
            default:
                break;
        }
        this.window.add(this);
        this.window.repaint();
        
    }

    @Override
    public void run() {

        GUI.contadorDinamico++;
        System.out.println("Iniciando..." + GUI.contadorDinamico);
        GUI.contadorIncremental++;

        try {

            while (iteraciones < limiteTiempo) {

                num = ran.nextInt(8) + 1;

                if (num == 1) {
                    
                    moverDerecha();
                } else if (num == 2) {

                    moverIzquierda();
                } else if (num == 3) {

                    moverArriba();
                } else if (num == 4) {

                    moverAbajo();
                } else if (num == 5) {

                    moverDerechaArriba();
                } else if (num == 6) {

                    moverDerechaAbajo();
                } else if (num == 7) {

                    moverIzquierdaArriba();
                } else {

                    moverIzquierdaAbajo();
                }

            }

            this.window.remove(this);
            this.window.repaint();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        GUI.contadorDinamico--;
        System.out.println("Terminado " + GUI.contadorDinamico);

        if (GUI.contadorDinamico >= 30) {
            System.out.println("Bye");
            System.exit(0);
        }
    }

    //Funciones
    public void crearHijos() {
        num = ran.nextInt(3);
        switch (num) {
            case 0:
                
                break;
            case 1:

                MiLabel lblUnico = new MiLabel(window);
                acomodarTexto(lblUnico);
                new Thread(lblUnico).start();
                break;
            case 2:

                MiLabel lblCuates1 = new MiLabel(window);
                acomodarTexto(lblCuates1);
                new Thread(lblCuates1).start();
                
                MiLabel lblCuates2 = new MiLabel(window);
                acomodarTexto(lblCuates2);
                new Thread(lblCuates2).start();
                break;
            case 3:

                MiLabel lblTrillizos1 = new MiLabel(window);
                acomodarTexto(lblTrillizos1);
                new Thread(lblTrillizos1).start();
                
                MiLabel lblTrillizos2 = new MiLabel(window);
                acomodarTexto(lblTrillizos2);
                new Thread(lblTrillizos2).start();
                
                MiLabel lblTrillizos3 = new MiLabel(window);
                acomodarTexto(lblTrillizos3);
                new Thread(lblTrillizos3).start();
                break;
        }
    }

    public void acomodarTexto(JLabel lbl) {
        lbl.setText(Integer.toString(GUI.contadorIncremental));
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setVerticalAlignment(JLabel.CENTER);
    }

    public void moverDerecha() throws InterruptedException {

        while (x <= 435) {

            x += 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            Thread.sleep(lapso);

            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverIzquierda() throws InterruptedException {

        while (x >= 0) {
            Thread.sleep(lapso);
            x -= 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverArriba() throws InterruptedException {

        while (y >= 3) {
            Thread.sleep(lapso);
            y -= 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverAbajo() throws InterruptedException {

        while (y <= 420) {
            Thread.sleep(lapso);
            y += 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverDerechaArriba() throws InterruptedException {

        while (x <= 442 && y >= 0) {
            Thread.sleep(lapso);
            x += 1;
            y -= 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverDerechaAbajo() throws InterruptedException {

        while (x <= 442 && y <= 420) {
            Thread.sleep(lapso);
            x += 1;
            y += 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverIzquierdaArriba() throws InterruptedException {

        while (x >= 0 && y >= 0) {
            Thread.sleep(lapso);
            x -= 1;
            y -= 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }

    public void moverIzquierdaAbajo() throws InterruptedException {

        while (x >= 0 && y <= 420) {
            Thread.sleep(lapso);
            x -= 1;
            y += 1;
            this.setBounds(x, y, SIZELBL, SIZELBL);
            iteraciones++;

            if (iteraciones == 1000) {
                System.out.println("Hora de reproducirse campeón");
                crearHijos();
            }
        }
    }
}
