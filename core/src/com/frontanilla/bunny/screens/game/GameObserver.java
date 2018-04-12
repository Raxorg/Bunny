package com.frontanilla.bunny.screens.game;

import com.badlogic.gdx.Gdx;
import com.frontanilla.bunny.entities.Carrot;
import com.frontanilla.bunny.entities.RainElement;
import com.frontanilla.bunny.helpers.Constants;

import java.util.Random;

public class GameObserver {

    private GameStuff stuff;
    private int score;
    private Random random;

    public GameObserver(GameStuff stuff) {
        this.stuff = stuff;
        score = 0;
        random = new Random();
    }

    public void update() {
        updateEntities();
        checkCarrots();
        checkMeteorites();
    }

    private void updateEntities() {
        stuff.getBunny().update();
        for (Carrot c : stuff.getCarrots()) {
            c.update();
        }
    }

    private void checkCarrots() {
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

    private void checkMeteorites() {
        stuff.getMeteoriteRain().getRainElements().begin();
        for (RainElement meteorite : stuff.getMeteoriteRain().getRainElements()) {
            if(stuff.getBunny().getBounds().overlaps(meteorite.getCollisionBox())) {
                stuff.getMeteoriteRain().getRainElements().removeValue(meteorite,true);
                stuff.damage();
                break;
            }
        }
        stuff.getMeteoriteRain().getRainElements().end();
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
