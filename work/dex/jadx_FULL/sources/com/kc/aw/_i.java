package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i implements _a4 {
    public final CopyOnWriteArraySet _a = new CopyOnWriteArraySet();

    @Override // com.kc.aw._a4
    public final void _a() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            ((_a4) it.next())._a();
        }
    }

    @Override // com.kc.aw._a4
    public final void _b() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            ((_a4) it.next())._b();
        }
    }
}
