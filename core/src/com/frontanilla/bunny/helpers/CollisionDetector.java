package com.frontanilla.bunny.helpers;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.bunny.entities.Bunny;
import com.frontanilla.bunny.entities.Carrot;

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
