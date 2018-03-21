package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class Drop extends Collidable {


    public Drop(Rectangle collisionBox) {
        super(collisionBox, new Texture(Gdx.files.internal("drop.png")));
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                collisionBox.x,
                collisionBox.y,
                collisionBox.width,
                collisionBox.height
        );
    }
}
