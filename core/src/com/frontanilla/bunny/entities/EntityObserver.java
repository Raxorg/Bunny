package com.frontanilla.bunny.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.bunny.helpers.CollisionDetector;
import com.frontanilla.bunny.helpers.Constants;

import java.util.Random;

public class EntityObserver {

    private Bunny bunny;
    private DelayedRemovalArray<Carrot> carrots;
    private CollisionDetector collisionDetector;

    private int score;
    private BitmapFont font;

    private Random random;

    public EntityObserver() {
        bunny = new Bunny(100, 300);
        carrots = new DelayedRemovalArray<>();

        collisionDetector = new CollisionDetector();
        collisionDetector.updateBunny(bunny);
        collisionDetector.updateCarrots(carrots);

        font = new BitmapFont();
        font.getData().scale(2);

        random = new Random();
    }

    public void update() {
        carrots.begin();
        for (Carrot c : carrots) {
            if (bunny.collides(c)) {
                carrots.removeValue(c, true);
                score += 4;
                bunny.eatCarrot();
            }
        }
        carrots.end();
    }

    public void render(SpriteBatch batch) {
        bunny.update();
        for (Carrot c : carrots) {
            c.update();
        }

        bunny.render(batch);
        for (Carrot c : carrots) {
            c.render(batch);
        }

        font.draw(
                batch,
                "" + score,
                5,
                Gdx.graphics.getHeight() - 50
        );
    }

    public void dispose() {
        bunny.dispose();
        for (Carrot c : carrots) {
            c.dispose();
        }
    }

    // TODO Stam PLAY
    public void addCarrot() {
        carrots.add(new Carrot(
                random.nextFloat() * (Gdx.graphics.getWidth() - 14 * 5),
                Constants.GROUND_HEIGHT - 6.5f * 5
        ));
        collisionDetector.updateCarrots(carrots);
    }

    public void aDown() {
        bunny.aDown();
    }

    public void aUp() {
        bunny.aUp();
    }

    public void dUp() {
        bunny.dUp();
    }

    public void dDown() {
        bunny.dDown();
    }

    public void wDown() {
        bunny.jump();
    }
}
