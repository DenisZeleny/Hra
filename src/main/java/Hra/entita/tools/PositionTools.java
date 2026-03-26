package Hra.entita.tools;

import Hra.entita.Entita;

import java.awt.*;

public final class PositionTools {


    private PositionTools() {}


    public static boolean isAbove(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();

        return ra.y + ra.height <= rb.y;
    }


    public static boolean isBelow(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();

        return ra.y >= rb.y + rb.height;
    }


    public static double distanceToEntita(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();


        double centerAx = ra.x + ra.width / 2.0;
        double centerAy = ra.y + ra.height / 2.0;

        double centerBx = rb.x + rb.width / 2.0;
        double centerBy = rb.y + rb.height / 2.0;

        double dx = centerAx - centerBx;
        double dy = centerAy - centerBy;


        return Math.sqrt(dx * dx + dy * dy);
    }
}
