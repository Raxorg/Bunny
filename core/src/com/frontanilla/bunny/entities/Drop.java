package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;
import java.util.Random;

public class Drop extends Collidable {

    Random random;
    private int speed;

    public Drop(Rectangle collisionBox) {
        super(collisionBox, new Texture(Gdx.files.internal("drop.png")));
        random = new Random();
        speed = 4 + random.nextInt(5);
    }

    public void update() {
        if (bounds.x + bounds.width < 0 || bounds.y + bounds.height < 0) {
            bounds.setBounds(
                    random.nextInt(Gdx.graphics.getWidth() * 2),
                    Gdx.graphics.getHeight(),
                    10,
                    30
            );

            speed = 4 + random.nextInt(5);
        }
        bounds.setBounds(
                bounds.x - speed / 2,
                bounds.y - speed,
                bounds.width,
                bounds.height
        );
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height
        );
    }
}
