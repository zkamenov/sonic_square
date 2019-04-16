package com.company;

import com.company.display.Display;
import com.company.in.KeyboardReader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static java.lang.System.exit;
import static java.lang.Thread.sleep;

public class Lauch implements Runnable {
    public static final Rectangle[] BLOCKS = new Rectangle[] {new Rectangle(10,10,10,10)};
    private int width, height, fps;
    private boolean running = false;

    private KeyboardReader kb;
    private Graphics g;
    private BufferStrategy bs;

    private Display d;

    private DrawMethod dm;

    private Sonic s;


    @Override
    public void run() {
        while(running) {
            try {
                sleep(1000/fps);

            } catch(Exception e) {
                e.printStackTrace();
                stop();
            }
            tick();
            render();

        }
        exit(0);
    }



    private synchronized void stop() {
        running=false;
        exit(1);
    }
    // Code for rendering on window of the program

    private void render() {
        bs = d.getCanvas().getBufferStrategy();
        if (bs==null) {
            d.getCanvas().createBufferStrategy(2);
            return;
        }

        g=bs.getDrawGraphics();
        g.clearRect(0,0,d.getFrame().getWidth(),d.getFrame().getHeight());
        g.translate((int) -s.x+(d.getFrame().getWidth()/2),(int) -s.y+(d.getFrame().getHeight()/2));
        dm.draw(g);
        bs.show();
        g.dispose();

    }

/*    synchronized void start() {
        running=true;
        thread = new Thread(this);
        thread.start();
    }
*/
    private void tick() {
        dm.calculate();
    }


    Lauch(int w, int h, int fps) {
        width=w;
        height=h;
        s = new Sonic();
        d = new Display(width,height,"Early Access");
        kb = new KeyboardReader();
        d.getFrame().addKeyListener(s.kbr);

        this.fps = fps;
        Blocks b = new Blocks();
        dm = new DrawMethod() {
            @Override
            public void draw(Graphics g) {
                s.draw(g);
                b.draw(g);
            }

            @Override
            public void calculate() {
                s.calculate();
                b.calculate();
            }
        };
        running = true;


    }


}