package com.frontanilla.bunny.effects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.bunny.entities.Drop;

import java.util.ArrayList;

public class Rain {

    private ArrayList<Drop> drops;

    public Rain() {
        drops = new ArrayList<>();
    }

    public void render(SpriteBatch batch) {
        for (Drop d : drops) {
            d.render(batch);
        }
    }

}
