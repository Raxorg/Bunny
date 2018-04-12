package com.frontanilla.bunny.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.frontanilla.bunny.screens.game.GameStuff;

public class InputManager extends InputAdapter {

    private GameStuff gameStuff;

    public InputManager(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.SPACE:
                gameStuff.spacePressed();
                break;
            case Input.Keys.W:
                gameStuff.wDown();
                break;
            case Input.Keys.A:
                gameStuff.aDown();
                break;
            case Input.Keys.D:
                gameStuff.dDown();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                gameStuff.aUp();
                break;
            case Input.Keys.D:
                gameStuff.dUp();
                break;
        }
        return true;
    }
}
