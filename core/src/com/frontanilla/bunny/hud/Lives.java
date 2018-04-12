package com.frontanilla.bunny.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Lives {

    private int quantity;
    private Texture texture;
    private float xPos, yPos, spacing, size;

    public Lives() {
        quantity = 3;
        texture = new Texture(Gdx.files.internal("bunny.png"));
        spacing = 40;
        size = 35;
        xPos = 5;
        yPos = Gdx.graphics.getHeight() - spacing;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        for (int i = 0; i < quantity; i++) {
            batch.draw(
                    texture,
                    xPos + spacing * i,
                    yPos,
                    size,
                    size
            );
        }
    }

    public void damage() {
        quantity--;
    }

    public int getQuantity() {
        return quantity;
    }
}
