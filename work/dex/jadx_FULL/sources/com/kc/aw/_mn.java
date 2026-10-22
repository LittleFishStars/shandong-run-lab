package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mn {
    public final String _a;
    public final long _b;
    public final String _c;

    public _mn(long j, String str, String str2) {
        this._a = str;
        this._b = j;
        this._c = str2;
    }

    public final String toString() {
        StringBuilder sb_a = _mm._a(_jf._a("SourceInfo{url='"), this._a, '\'', ", length=");
        sb_a.append(this._b);
        sb_a.append(", mime='");
        sb_a.append(this._c);
        sb_a.append('\'');
        sb_a.append('}');
        return sb_a.toString();
    }
}
