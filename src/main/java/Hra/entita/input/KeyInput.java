package Hra.entita.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private boolean[] keys = new boolean[256];

    public boolean isKeyPressed(int keyCode) {
        if (keyCode >= 0 && keyCode < keys.length) {
            return keys[keyCode];
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int kod = e.getKeyCode();
        if (kod >= 0 && kod < keys.length) {
            keys[kod] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kod = e.getKeyCode();
        if (kod >= 0 && kod < keys.length) {
            keys[kod] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean[] getKeys() {
        return keys;
    }
}