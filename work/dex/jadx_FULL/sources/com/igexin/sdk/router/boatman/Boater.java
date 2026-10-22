package com.igexin.sdk.router.boatman;

import com.igexin.sdk.router.boatman.receive.IBoatResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class Boater<Bag, V> {
    public abstract String getTag();

    public void postASync(Bag bag, IBoatResult<V> iBoatResult) {
        ShipsManager.get().getShip().postASync(this, bag, iBoatResult);
    }

    public void postSticky(Bag bag, IBoatResult<V> iBoatResult) {
        ShipsManager.get().getShip().postSticky(this, bag, iBoatResult);
    }

    public V postSync(Bag bag) {
        return (V) ShipsManager.get().getShip().postSync(this, bag);
    }

    public boolean removeSticky(Bag bag) {
        return ShipsManager.get().getShip().removeSticky(this, bag);
    }
}
