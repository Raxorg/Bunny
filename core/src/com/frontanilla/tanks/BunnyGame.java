package com.frontanilla.tanks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BunnyGame extends Game {

    private SpriteBatch batch;
    private EntityObserver observer;
    public Texture pixel, ground;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputManager(this));

        observer = new EntityObserver();

        pixel = new Texture("pixel.jpg");
        ground = new Texture("ground.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.setColor(Color.WHITE);
        for (int i = 0; i < 4; i++) {
            batch.draw(
                    ground,
                    i * Gdx.graphics.getWidth() / 4,
                    0,
                    Gdx.graphics.getWidth() / 4,
                    Gdx.graphics.getHeight() * 0.2f
            );
        }
        batch.setColor(Color.CYAN);
        batch.draw(
                pixel,
                0,
                Gdx.graphics.getHeight() * 0.2f,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() * 0.8f
        );
        batch.setColor(Color.WHITE);

        observer.update();
        observer.render(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        observer.dispose();
    }

    public void spacePressed() {
        observer.addCarrot();
    }

    public void aDown() {
        observer.aDown();
    }

    public void aUp() {
        observer.aUp();
    }

    public void dUp() {
        observer.dUp();
    }

    public void dDown() {
        observer.dDown();
    }

    public void wDown() {
        observer.wDown();
    }
}
