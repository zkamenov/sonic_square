package com.company;

import com.company.in.KeyboardReader;

import java.awt.*;

public class Sonic implements DrawMethod {
    double x,y,w,h,xvel,yvel,jt;
    public KeyboardReader kbr;
    public Sonic() {
        kbr = new KeyboardReader();
        restart();
    }


    private void restart() {

        xvel=1;
        yvel=0;
        x=20;
        y=0;
        w=10;
        h=10;
        jt=0;
    }


    @Override
    public void draw(Graphics g) {
        g.fillRect((int) x,(int) y,(int) w,(int) h);
    }

    @Override
    public void calculate() {

        x+=xvel;
        y-=yvel;
        kbr.tick();
        if (kbr.w && jt > 0) {
            yvel = 10;
            y-=10;
            jt=0;
        }
        if (kbr.a) {
            xvel--;
        }
        if (kbr.d) {
            xvel++;
        }
        if (kbr.r) {
            xvel=1;
            yvel=0;
            x=20;
            y=0;
            w=10;
            h=10;
            jt=0;
        }
        yvel--;
        kbr.tick();
        for (Rectangle b     :     Blocks.blocks) {
                //Do not mess with detection code below
            if(x+w>b.x && x<b.x+b.width && y+h>b.y && y<b.y+b.height) {
                yvel = 1;
                jt=5;
            }
            if(x+w>b.x && x<b.x+b.width && y+h>b.y + 15 && y<b.y+b.height + 5) {
                yvel = -1;
                jt=0;
            }
            if(x+w>b.x-5 && x<b.x && y+h>b.y+5 && y<b.y+b.height-5)
                xvel = -1;

            if(x+w>b.x+b.width && x<b.x + b.width + 5 && y+h>b.y+5 && y<b.y+b.height-5)
                xvel = 1;
        }
        jt--;
        xvel*=0.9;
        yvel*=0.9;
        if (y > 200)
            restart();
    }
}
