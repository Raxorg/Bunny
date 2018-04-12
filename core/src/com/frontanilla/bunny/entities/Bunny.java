package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.frontanilla.bunny.helpers.Constants;

import java.util.Random;

public class Bunny extends Collidable {

    private float x, y;
    private Vector2 velocity;
    private boolean jumping, aPressed, dPressed, facingLeft;
    private Animation<Texture> animation;
    private Texture idle;
    private float time;
    private Sound eatCarrot1, eatCarrot2;

    public Bunny() {
        super(
                new Rectangle(0, 0, 50, 50),
                new Texture("bunny/bunny_jump_3.png")
        );
        velocity = new Vector2();
        jumping = false;
    }

    public Bunny(float x, float y) {
        super(
                new Rectangle((int) x, (int) y, 50, 50),
                new Texture("bunny/bunny_jump_3.png")
        );
        this.x = x;
        this.y = y;
        velocity = new Vector2();
        jumping = true;
        eatCarrot1 = Gdx.audio.newSound(Gdx.files.internal("bunny/carrot1.mp3"));
        eatCarrot2 = Gdx.audio.newSound(Gdx.files.internal("bunny/carrot2.mp3"));
        idle = new Texture("bunny/bunny_jump_3.png");
        createAnimation();
    }

    private void createAnimation() {
        Texture[] walkingFrames = new Texture[4];
        walkingFrames[0] = new Texture("bunny/bunny_walk_1.png");
        walkingFrames[1] = new Texture("bunny/bunny_walk_2.png");
        walkingFrames[2] = new Texture("bunny/bunny_walk_3.png");
        walkingFrames[3] = new Texture("bunny/bunny_walk_4.png");
        animation = new Animation<>(0.1f, walkingFrames);
        time = 0f;
    }

    public void jump() {
        if (!jumping) {
            jumping = true;
            velocity.y += 15;
            y += 1;
        }
    }

    public void update() {
        time += Gdx.graphics.getDeltaTime();

        if (jumping) {
            velocity.y -= 0.8f;
            if (y <= Constants.GROUND_HEIGHT) {
                y = Constants.GROUND_HEIGHT;
                velocity.y = 0;
                jumping = false;
            }
        }

        x += velocity.x;
        y += velocity.y;

        bounds.x = (int) x;
        bounds.y = (int) y;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        Texture currentFrame = animation.getKeyFrame(time, true);
        if (velocity.x == 0) {
            currentFrame = idle;
        }
        batch.draw(
                currentFrame,
                x,
                y,
                currentFrame.getWidth() / 2,
                currentFrame.getHeight() / 2,
                50,
                50,
                1,
                1,
                0,
                0,
                0,
                currentFrame.getWidth(),
                currentFrame.getHeight(),
                facingLeft,
                false
        );
        // TextureRegion region, float x, float y, float originX, float originY, float width, float height,
        // float scaleX, float scaleY, float rotation int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
    }

    public void dispose() {
        texture.dispose();
    }

    public void aDown() {
        if (dPressed) {
            velocity.x = 0;
        } else {
            velocity.x = -5;
        }
        aPressed = true;
        facingLeft = true;
    }

    public void aUp() {
        if (dPressed) {
            velocity.x = 5;
            facingLeft = false;
        } else {
            velocity.x = 0;
        }
        aPressed = false;
    }

    public void dDown() {
        if (aPressed) {
            velocity.x = 0;
        } else {
            velocity.x = 5;
        }
        dPressed = true;
        facingLeft = false;
    }

    public void dUp() {
        if (aPressed) {
            velocity.x = -5;
            facingLeft = true;
        } else {
            velocity.x = 0;
        }
        dPressed = false;
    }

    public void eatCarrot() {
        Random random = new Random();
        if (random.nextBoolean()) {
            eatCarrot1.play();
        } else {
            eatCarrot2.play();
        }
    }
}
