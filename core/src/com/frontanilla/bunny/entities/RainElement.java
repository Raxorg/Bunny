package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class RainElement extends Collidable {

    private Rectangle collisionBox;
    private Random random;
    private float speed, xSize, ySize, xModifier;

    public RainElement(Rectangle bounds, float xSize, float ySize, float xModifier, Texture texture) {
        super(bounds, texture);
        collisionBox = new Rectangle(
                bounds.x + bounds.width * 0.15f,
                bounds.y + bounds.height * 0.15f,
                bounds.width * 0.7f,
                bounds.height * 0.7f
        );
        random = new Random();
        speed = 4 + random.nextInt(5);
        this.xSize = xSize;
        this.ySize = ySize;
        this.xModifier = xModifier;
    }

    public void update() {
        if (bounds.x + bounds.width < 0 || bounds.y + bounds.height < 0) {
            bounds.set(
                    random.nextInt((int) (Gdx.graphics.getWidth() + Gdx.graphics.getWidth() * xModifier)),
                    Gdx.graphics.getHeight(),
                    xSize,
                    ySize
            );
            collisionBox.set(
                    bounds.x + bounds.width * 0.15f,
                    bounds.y + bounds.height * 0.15f,
                    bounds.width * 0.7f,
                    bounds.height * 0.7f
            );

            speed = 4 + random.nextInt(5);
        }
        bounds.set(
                bounds.x - speed * xModifier,
                bounds.y - speed,
                bounds.width,
                bounds.height
        );
        collisionBox.set(
                collisionBox.x - speed * xModifier,
                collisionBox.y - speed,
                collisionBox.width,
                collisionBox.height
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

    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
