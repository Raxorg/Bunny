package com.frontanilla.bunny.screens.gameover;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverRenderer {

    private GameOverStuff stuff;
    private SpriteBatch batch;
    private Texture gameOver;

    public GameOverRenderer(GameOverStuff stuff) {
        this.stuff = stuff;
        batch = new SpriteBatch();
        gameOver = new Texture("gameover.png");
    }

    public void render() {
        batch.begin();

        batch.draw(
                gameOver,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );

        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }
}
