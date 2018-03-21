package com.frontanilla.bunny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

public class Bunny extends Collidable {

    private float x, y;
    private Vector2 velocity;
    private Texture texture;
    boolean jumping, movingLeft, movingRight;

    public Bunny() {
        super(new Rectangle(0, 0, 14 * 5, 13 * 5));
        velocity = new Vector2();
        texture = new Texture(Gdx.files.internal("bunny.png"));
        jumping = false;
    }

    public Bunny(float x, float y) {
        super(new Rectangle((int) x, (int) y, 14 * 5, 13 * 5));
        this.x = x;
        this.y = y;
        velocity = new Vector2();
        texture = new Texture(Gdx.files.internal("bunny.png"));
        jumping = true;
    }

    public void jump() {
        if (!jumping) {
            jumping = true;
            velocity.y += 15;
            y += 1;
        }
    }

    public void update() {
        if (jumping) {
            velocity.y -= 0.8f;
            if (y <= 0) {
                y = 0;
                velocity.y = 0;
                jumping = false;
            }
        }

        x += velocity.x;
        y += velocity.y;

        collisionBox.x = (int) x;
        collisionBox.y = (int) y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                x,
                y,
                texture.getWidth() / 2,
                texture.getHeight() / 2,
                texture.getWidth() * 5,
                texture.getHeight() * 5,
                1,
                1,
                0,
                0,
                0,
                14,
                13,
                movingRight,
                false
        );
        // TextureRegion region, float x, float y, float originX, float originY, float width, float height,
        // float scaleX, float scaleY, float rotation int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
    }

    public void dispose() {
        texture.dispose();
    }

    public void aDown() {
        if (movingRight) {
            velocity.x = 0;
        } else {
            velocity.x = -5;
        }
        movingLeft = true;
    }

    public void aUp() {
        if (movingRight) {
            velocity.x = 5;
        } else {
            velocity.x = 0;
        }
        movingLeft = false;
    }

    public void dDown() {
        if (movingLeft) {
            velocity.x = 0;
        } else {
            velocity.x = 5;
        }
        movingRight = true;
    }

    public void dUp() {
        if (movingLeft) {
            velocity.x = -5;
        } else {
            velocity.x = 0;
        }
        movingRight = false;
    }
}
