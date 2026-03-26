package Hra.entita.tools;

import Hra.entita.Entita;

public final class CollisionTools {

    private CollisionTools() {}

    public static boolean collisionRectangle(Entita entitaA, Entita entitaB) {
        // Rectangle.intersects performs a fast AABB overlap check.
        return entitaA.getBounds().intersects(entitaB.getBounds());
    }

}
