package com.frontanilla.tanks;

import com.badlogic.gdx.utils.DelayedRemovalArray;

import java.util.ArrayList;

public class CollisionDetector {

    private Bunny bunny;
    private DelayedRemovalArray<Carrot> carrots;

    public  void updateBunny(Bunny bunny) {
        this.bunny = bunny;
    }

    public  void updateCarrots(DelayedRemovalArray<Carrot> carrots) {
        this.carrots = carrots;
    }
}
