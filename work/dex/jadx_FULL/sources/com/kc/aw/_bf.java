package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bf implements Runnable {
    public final Context _a;

    public _bf(Context context) {
        this._a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _bg._a(this._a);
    }
}
