package com.frontanilla.bunny.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.bunny.entities.RainElement;

import java.util.Random;

public class Rain {

    private DelayedRemovalArray<RainElement> rainElements;

    public Rain(float xSize, float ySize, float xModifier, Texture texture, int quantity) {
        rainElements = new DelayedRemovalArray<>();
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            rainElements.add(new RainElement(
                    new Rectangle(
                            random.nextInt(Gdx.graphics.getWidth()),
                            Gdx.graphics.getHeight() + random.nextInt(Gdx.graphics.getHeight()),
                            xSize,
                            ySize
                    ),
                    xSize,
                    ySize,
                    xModifier,
                    texture
            ));
        }
    }

    public void render(SpriteBatch batch) {
        for (RainElement d : rainElements) {
            d.update();
            d.render(batch);
        }
    }

    public DelayedRemovalArray<RainElement> getRainElements() {
        return rainElements;
    }
}
