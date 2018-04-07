package com.frontanilla.bunny.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.frontanilla.bunny.BunnyWorldStuff;

public class InputManager extends InputAdapter {

    private BunnyWorldStuff bunnyWorldStuff;

    public InputManager(BunnyWorldStuff bunnyWorldStuff) {
        this.bunnyWorldStuff = bunnyWorldStuff;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.SPACE:
                bunnyWorldStuff.spacePressed();
                break;
            case Input.Keys.W:
                bunnyWorldStuff.wDown();
                break;
            case Input.Keys.A:
                bunnyWorldStuff.aDown();
                break;
            case Input.Keys.D:
                bunnyWorldStuff.dDown();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                bunnyWorldStuff.aUp();
                break;
            case Input.Keys.D:
                bunnyWorldStuff.dUp();
                break;
        }
        return true;
    }
}
