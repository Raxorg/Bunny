package com.frontanilla.bunny.screens.gameover;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.frontanilla.bunny.helpers.Constants;

public class GameOverStuff extends ScreenAdapter {

    // USAR COMIC SANS MS

    private GameOverObserver observer;
    private GameOverRenderer renderer;

    public GameOverStuff() {
        observer = new GameOverObserver(this);
        renderer = new GameOverRenderer(this);

        Constants.init();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        observer.update();
        renderer.render();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
