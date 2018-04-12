package com.frontanilla.bunny;

import com.badlogic.gdx.Game;
import com.frontanilla.bunny.screens.game.GameStuff;

public class BunnyGame extends Game {

    @Override
    public void create() {
        setScreen(new GameStuff(this));
    }
}
