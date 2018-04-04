package com.frontanilla.bunny.entities;


import com.badlogic.gdx.graphics.Texture;

import java.awt.Rectangle;

public abstract class Collidable {

    protected Rectangle bounds;
    protected Texture texture;

    public Collidable(Rectangle bounds, Texture texture) {
        this.bounds = bounds;
        this.texture = texture;
    }

    protected boolean collides(Collidable other) {
        return bounds.intersects(other.bounds);
    }
}
