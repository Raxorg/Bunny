package com.frontanilla.bunny.entities;


import com.badlogic.gdx.graphics.Texture;

import java.awt.Rectangle;

public abstract class Collidable {

    protected Rectangle collisionBox;
    protected Texture texture;

    public Collidable(Rectangle collisionBox, Texture texture) {
        this.collisionBox = collisionBox;
        this.texture = texture;
    }

    protected boolean collides(Collidable other) {
        return collisionBox.intersects(other.collisionBox);
    }
}
