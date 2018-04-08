package com.frontanilla.bunny;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.bunny.effects.Rain;
import com.frontanilla.bunny.entities.Bunny;
import com.frontanilla.bunny.entities.Carrot;
import com.frontanilla.bunny.helpers.Constants;
import com.frontanilla.bunny.helpers.InputManager;
import com.frontanilla.bunny.hud.Lives;

public class BunnyWorldStuff extends Game {

    private BunnyWorldObserver observer;
    private BunnyWorldRenderer renderer;
    private DelayedRemovalArray<Carrot> carrots;
    private Bunny bunny;
    private Rain waterRain, meteoriteRain;
    private Lives lives;

    @Override
    public void create() {
        observer = new BunnyWorldObserver(this);
        renderer = new BunnyWorldRenderer(this);

        carrots = new DelayedRemovalArray<>();
        Constants.init();

        Gdx.input.setInputProcessor(new InputManager(this));

        bunny = new Bunny(100, 300);
        waterRain = new Rain(10, 30, 0.5f, new Texture(Gdx.files.internal("drop.png")));
        meteoriteRain = new Rain(30, 60, 0, new Texture(Gdx.files.internal("meteorite.png")));
        lives = new Lives();

        observer.init();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        observer.update();
        renderer.render();
    }

    @Override
    public void dispose() {
        observer.dispose();
        renderer.dispose();
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

    public Lives getLives() {
        return lives;
    }

    public Rain getWaterRain() {
        return waterRain;
    }

    public Rain getMeteoriteRain() {
        return meteoriteRain;
    }

    public String getScore() {
        return observer.getScore() + "";
    }

    public Bunny getBunny() {
        return bunny;
    }

    public DelayedRemovalArray<Carrot> getCarrots() {
        return carrots;
    }
}
