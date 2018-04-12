package com.frontanilla.bunny.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.bunny.entities.Carrot;
import com.frontanilla.bunny.helpers.Constants;

public class GameRenderer {

    private GameStuff stuff;
    private SpriteBatch batch;
    private Texture pixel, ground;
    private BitmapFont font;
    private float time, redScreenAlpha;

    public GameRenderer(GameStuff stuff) {
        this.stuff = stuff;
        batch = new SpriteBatch();
        pixel = new Texture("pixel.jpg");
        ground = new Texture("ground.png");
        font = new BitmapFont();
        font.getData().scale(2);
    }

    public void render() {
        batch.begin();

        renderGround();
        renderSky();

        stuff.getLives().render(batch);
        stuff.getWaterRain().render(batch);
        stuff.getMeteoriteRain().render(batch);
        stuff.getBunny().render(batch);
        renderCarrots();
        renderScore();

        renderRedScreen();

        batch.end();
    }

    private void renderRedScreen() {
        redScreenAlpha -= Gdx.graphics.getDeltaTime();
        if(redScreenAlpha < 0) {
            redScreenAlpha = 0;
        }
        batch.setColor(1, 0, 0, redScreenAlpha);
        batch.draw(
                pixel,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
    }

    private void renderScore() {
        font.draw(
                batch,
                "" + stuff.getScore(),
                5,
                Gdx.graphics.getHeight() - 50
        );
    }

    private void renderCarrots() {
        for (Carrot c : stuff.getCarrots()) {
            c.render(batch);
        }
    }

    private void renderGround() {
        batch.setColor(Color.WHITE);
        for (int i = 0; i < 4; i++) {
            batch.draw(
                    ground,
                    i * Gdx.graphics.getWidth() / 4,
                    0,
                    Gdx.graphics.getWidth() / 4,
                    Constants.GROUND_HEIGHT
            );
        }
    }

    private void renderSky() {
        batch.setColor(Color.CYAN);
        batch.draw(
                pixel,
                0,
                Constants.GROUND_HEIGHT,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() - Constants.GROUND_HEIGHT
        );
    }

    public void dispose() {
        batch.dispose();
    }

    public void redScreen() {
        redScreenAlpha = 1;
        time = 1;
    }
}
