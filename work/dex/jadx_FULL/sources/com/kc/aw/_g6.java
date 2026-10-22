package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g6 {
    public HashMap _a = new HashMap(100);

    public final void _a(String str) {
        this._a.remove(str);
    }

    public final _ds _b(String str) {
        return (_ds) this._a.get(str);
    }
}
