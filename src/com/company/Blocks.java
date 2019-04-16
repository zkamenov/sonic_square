package com.company;

import java.awt.*;

public class Blocks implements DrawMethod {
    public static Rectangle[] blocks = new Rectangle[] {
            new Rectangle(10,50,1000,200),
            new Rectangle(40,40,10,10),
            new Rectangle(-200,-200,210,500),
            new Rectangle(80,10,10,10),
            new Rectangle(120,0,10,10),
            new Rectangle(180,-30,200,80),
            new Rectangle(500,-100,10,50) //changeable block
    };
    @Override
    public void draw(Graphics g) {

        g.setColor(Color.green);
        for (Rectangle Block : blocks) {
            g.fillRect(Block.x,Block.y,Block.width,Block.height);
        }


    }



    @Override
    public void calculate() {


        blocks[6].height++;

                if(blocks[6].height>200)
                    blocks[6].height=10;



    }
}
