package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class RainElement extends Collidable {

    private Random random;
    private float speed, xSize, ySize, xModifier;

    public RainElement(Rectangle collisionBox, float xSize, float ySize, float xModifier, Texture texture) {
        super(collisionBox, texture);
        random = new Random();
        speed = 4 + random.nextInt(5);
        this.xSize = xSize;
        this.ySize = ySize;
        this.xModifier = xModifier;
    }

    public void update() {
        if (bounds.x + bounds.width < 0 || bounds.y + bounds.height < 0) {
            bounds.set(
                    random.nextInt(Gdx.graphics.getWidth() * 2),
                    Gdx.graphics.getHeight(),
                    xSize,
                    ySize
            );

            speed = 4 + random.nextInt(5);
        }
        bounds.set(
                bounds.x - speed * xModifier,
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
