package com.frontanilla.bunny.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.bunny.entities.RainElement;

import java.util.ArrayList;
import java.util.Random;

public class Rain {

    private ArrayList<RainElement> rainElements;
    private Random random;

    public Rain(float xSize, float ySize, float xModifier, Texture texture) {
        rainElements = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 300; i++) {
            rainElements.add(new RainElement(
                    new Rectangle(
                            random.nextInt(Gdx.graphics.getWidth()),
                            random.nextInt(Gdx.graphics.getHeight()),
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

}
