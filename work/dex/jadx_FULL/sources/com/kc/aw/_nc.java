package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nc implements Runnable {
    public final Context _a;
    public final _cn _b;

    public _nc(Context context, _cn _cnVar) {
        this._a = context;
        this._b = _cnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ArrayList arrayList = _nd._a;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_et) it.next())._a(this._a, this._b);
            }
            ArrayList arrayList2 = _nd._a;
        } catch (Exception unused) {
        }
    }
}
