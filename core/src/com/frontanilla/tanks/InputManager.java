package com.frontanilla.tanks;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter {

    private BunnyGame bunnyGame;

    public InputManager(BunnyGame bunnyGame) {
        this.bunnyGame = bunnyGame;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.SPACE:
                bunnyGame.spacePressed();
                break;
            case Input.Keys.W:
                bunnyGame.wDown();
                break;
            case Input.Keys.A:
                bunnyGame.aDown();
                break;
            case Input.Keys.D:
                bunnyGame.dDown();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                bunnyGame.aUp();
                break;
            case Input.Keys.D:
                bunnyGame.dUp();
                break;
        }
        return true;
    }
}
