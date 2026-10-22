package com.igexin.base.api;

import com.igexin.base.boatman.a;
import com.igexin.base.boatman.b;
import com.igexin.base.boatman.receive.IBoatResult;
import com.igexin.base.boatman.receive.Site;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ShipsManager {
    public static final String TAG_EXTENSION_INIT = "tag_extension_init";
    public static final String TAG_FEEDBACK = "tag_feedback";
    public static final String TAG_GKT = "tag_gkt";
    public static final String TAG_GT = "tag_gt";
    private static ShipsManager mInstance;
    private final b mBase = new b();

    private ShipsManager() {
    }

    public static ShipsManager get() {
        if (mInstance == null) {
            synchronized (ShipsManager.class) {
                if (mInstance == null) {
                    mInstance = new ShipsManager();
                }
            }
        }
        return mInstance;
    }

    public b getShip() {
        return this.mBase;
    }

    public boolean isRegistered(Site site) {
        return this.mBase.b.containsKey(site.getTag());
    }

    public void register(Site site) {
        b bVar = this.mBase;
        String tag = site.getTag();
        bVar.f37805a.lock();
        try {
            bVar.b.put(tag, site);
            List<a> list = bVar.c.get(tag);
            if (list != null && list.size() > 0) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    IBoatResult iBoatResult = next.b;
                    if (iBoatResult != null) {
                        site.onArrived(next.f37804a, iBoatResult);
                    }
                    it.remove();
                }
            }
        } finally {
            bVar.f37805a.unlock();
        }
    }

    public void unRegister(Site site) {
        b bVar = this.mBase;
        bVar.f37805a.lock();
        try {
            bVar.b.remove(site.getTag());
        } finally {
            bVar.f37805a.unlock();
        }
    }
}
