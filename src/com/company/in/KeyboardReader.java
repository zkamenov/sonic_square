package com.company.in;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardReader implements KeyListener {
    private boolean[] kb;
    public boolean w, a, s, d, r;

    public KeyboardReader() {
        kb = new boolean[256];
    }

    public void tick() {
        w=kb[KeyEvent.VK_W];
        a=kb[KeyEvent.VK_A];
        s=kb[KeyEvent.VK_S];
        d=kb[KeyEvent.VK_D];
        r=kb[KeyEvent.VK_R];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        kb[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        kb[e.getKeyCode()] = false;
    }
}
