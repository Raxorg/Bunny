package com.frontanilla.bunny.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.bunny.entities.Drop;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Rain {

    private ArrayList<Drop> drops;
    private Random random;

    public Rain() {
        drops = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 300; i++) {
            drops.add(new Drop(new Rectangle(
                    random.nextInt(Gdx.graphics.getWidth()),
                    random.nextInt(Gdx.graphics.getHeight()),
                    10,
                    30
            )));
        }
    }

    public void render(SpriteBatch batch) {
        for (Drop d : drops) {
            d.update();
            d.render(batch);
        }
    }

}
