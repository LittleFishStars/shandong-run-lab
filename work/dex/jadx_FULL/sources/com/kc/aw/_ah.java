package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ah implements _s {
    public final ArrayList _a = new ArrayList();
    public final ArrayList _b = new ArrayList();
    public final ArrayList _c = new ArrayList();
    public final AtomicBoolean _d = new AtomicBoolean();
    public volatile boolean _e = false;

    public final void _a() {
        if (this._e || this._d.get()) {
            return;
        }
        this._e = true;
        this._d.compareAndSet(false, true);
    }

    public final void _b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this._c) {
            arrayList.addAll(this._c);
        }
        synchronized (this._b) {
            arrayList2.addAll(this._b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((_s._a) it.next())._a();
        }
    }
}
