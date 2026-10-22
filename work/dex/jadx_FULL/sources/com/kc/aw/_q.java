package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _q {
    public List<_h> _a;
    public String _b;
    public long _c;
    public String _d;
    public int _e;
    public String _f;
    public String _g;
    public long _h;
    public String _i;

    public final String toString() {
        StringBuilder sb_a = _jf._a("AdObject{ad=");
        sb_a.append(this._a);
        sb_a.append(", version='");
        StringBuilder sb_a2 = _mm._a(sb_a, this._b, '\'', ", process_time=");
        sb_a2.append(this._c);
        sb_a2.append(", reqid='");
        StringBuilder sb_a3 = _mm._a(sb_a2, this._d, '\'', ", code=");
        sb_a3.append(this._e);
        sb_a3.append(", error_message='");
        StringBuilder sb_a4 = _mm._a(_mm._a(sb_a3, this._f, '\'', ", rawData='"), this._g, '\'', ", requestTime=");
        sb_a4.append(this._h);
        sb_a4.append(", ctl='");
        sb_a4.append(this._i);
        sb_a4.append('\'');
        sb_a4.append('}');
        return sb_a4.toString();
    }
}
