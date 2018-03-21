package com.frontanilla.bunny;


import java.awt.Rectangle;

public abstract class Collidable {

    protected Rectangle collisionBox;

    public Collidable(Rectangle collisionBox) {
        this.collisionBox = collisionBox;
    }

    protected boolean collides(Collidable other) {
        return collisionBox.intersects(other.collisionBox);
    }
}
