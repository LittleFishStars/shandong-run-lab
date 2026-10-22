package com.fl.saas;

import com.fl.saas.adx.base.widget.ShakeView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class U0 {
    private static U0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f30088a = new CopyOnWriteArrayList();

    private U0() {
    }

    public void a(ShakeView shakeView) {
        try {
            Iterator it = this.f30088a.iterator();
            while (it.hasNext()) {
                ((ShakeView) it.next()).unRegisterAccelerometer(false);
            }
            if (this.f30088a.contains(shakeView)) {
                return;
            }
            this.f30088a.add(shakeView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(ShakeView shakeView) {
        try {
            this.f30088a.remove(shakeView);
            if (this.f30088a.isEmpty()) {
                return;
            }
            List list = this.f30088a;
            ((ShakeView) list.get(list.size() - 1)).registerAccelerometer(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static U0 a() {
        if (b == null) {
            synchronized (U0.class) {
                b = new U0();
            }
        }
        return b;
    }
}
