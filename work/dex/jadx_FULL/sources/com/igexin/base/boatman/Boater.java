package com.igexin.base.boatman;

import com.igexin.base.api.ShipsManager;
import com.igexin.base.boatman.receive.IBoatResult;
import com.igexin.base.boatman.receive.Site;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class Boater<Bag, V> {
    public abstract String getTag();

    public void postASync(Bag bag, IBoatResult<V> iBoatResult) {
        ShipsManager.get().getShip().a(this, bag, iBoatResult);
    }

    public void postSticky(Bag bag, IBoatResult<V> iBoatResult) {
        b ship = ShipsManager.get().getShip();
        String tag = getTag();
        ship.f37805a.lock();
        try {
            boolean zContainsKey = ship.b.containsKey(getTag());
            if (!zContainsKey) {
                if (ship.c.get(tag) == null) {
                    ship.c.put(tag, new ArrayList());
                }
                ship.c.get(tag).add(new a(bag, iBoatResult));
            }
            ship.f37805a.unlock();
            if (zContainsKey) {
                ship.a(this, bag, iBoatResult);
            }
        } catch (Throwable th) {
            ship.f37805a.unlock();
            throw th;
        }
    }

    public V postSync(Bag bag) {
        Site site = ShipsManager.get().getShip().b.get(getTag());
        if (site == null) {
            return null;
        }
        return (V) site.onArrived(bag);
    }

    public boolean removeSticky(Bag bag) {
        return ShipsManager.get().getShip().a(this, bag);
    }
}
