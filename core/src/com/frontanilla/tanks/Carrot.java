package com.frontanilla.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class Carrot extends Collidable {

    private float x, y;
    private Texture texture;

    public Carrot(float x, float y) {
        super(new Rectangle((int) x, (int) y, 14 * 5, 13 * 5));
        this.x = x;
        this.y = y;
        texture = new Texture(Gdx.files.internal("carrot.png"));
    }

    public void update() {

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
                true,
                false
        );
        // TextureRegion region, float x, float y, float originX, float originY, float width, float height,
        // float scaleX, float scaleY, float rotation int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
    }

    public void dispose() {
        texture.dispose();
    }
}
