package com.frontanilla.bunny.helpers;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static float GROUND_HEIGHT;

    public static void init() {
        GROUND_HEIGHT = Gdx.graphics.getHeight() * 0.175f;
    }
}
