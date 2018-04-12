package com.frontanilla.bunny.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Collidable {

    protected Rectangle bounds;
    protected Texture texture;

    public Collidable(Rectangle bounds, Texture texture) {
        this.bounds = bounds;
        this.texture = texture;
    }

    public boolean collides(Collidable other) {
        return bounds.overlaps(other.bounds);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
