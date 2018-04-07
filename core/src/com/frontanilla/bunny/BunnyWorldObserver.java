package com.frontanilla.bunny;

import com.badlogic.gdx.Gdx;
import com.frontanilla.bunny.entities.Carrot;
import com.frontanilla.bunny.helpers.CollisionDetector;
import com.frontanilla.bunny.helpers.Constants;

import java.util.Random;

public class BunnyWorldObserver {

    private BunnyWorldStuff stuff;
    private CollisionDetector collisionDetector;
    private int score;
    private Random random;

    public BunnyWorldObserver(BunnyWorldStuff stuff) {
        this.stuff = stuff;
        collisionDetector = new CollisionDetector();
        collisionDetector.updateBunny(stuff.getBunny());
        collisionDetector.updateCarrots(stuff.getCarrots());
        score = 0;
        random = new Random();
    }

    public void update() {
        stuff.getBunny().update();
        for (Carrot c : stuff.getCarrots()) {
            c.update();
        }
        stuff.getCarrots().begin();
        for (Carrot c : stuff.getCarrots()) {
            if (stuff.getBunny().collides(c)) {
                stuff.getCarrots().removeValue(c, true);
                score += 4;
                stuff.getBunny().eatCarrot();
            }
        }
        stuff.getCarrots().end();
    }

    public void dispose() {
        stuff.getBunny().dispose();
        for (Carrot c : stuff.getCarrots()) {
            c.dispose();
        }
    }

    // TODO Stam PLAY
    public void addCarrot() {
        stuff.getCarrots().add(new Carrot(
                random.nextFloat() * (Gdx.graphics.getWidth() - 14 * 5),
                Constants.GROUND_HEIGHT - 6.5f * 5
        ));
        collisionDetector.updateCarrots(stuff.getCarrots());
    }

    public void aDown() {
        stuff.getBunny().aDown();
    }

    public void aUp() {
        stuff.getBunny().aUp();
    }

    public void dUp() {
        stuff.getBunny().dUp();
    }

    public void dDown() {
        stuff.getBunny().dDown();
    }

    public void wDown() {
        stuff.getBunny().jump();
    }

    public int getScore() {
        return score;
    }
}
