package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nl implements Serializable {
    public int _a;
    public int _b;
    public long _c;
    public int _d;
    public int _e;
    public long _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;

    public _nl(int i, int i2, long j) {
        this._a = i;
        this._b = i2;
        this._c = j;
    }

    public _nl(View view) {
        _m1._a(this, view);
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("TInfo{downX=");
        sb_a.append(this._a);
        sb_a.append(", downY=");
        sb_a.append(this._b);
        sb_a.append(", downTime=");
        sb_a.append(this._c);
        sb_a.append(", upX=");
        sb_a.append(this._d);
        sb_a.append(", upY=");
        sb_a.append(this._e);
        sb_a.append(", upTime=");
        sb_a.append(this._f);
        sb_a.append(", mDx=");
        sb_a.append(this._g);
        sb_a.append(", mDy=");
        sb_a.append(this._h);
        sb_a.append(", mUx=");
        sb_a.append(this._i);
        sb_a.append(", mUy=");
        sb_a.append(this._j);
        sb_a.append('}');
        return sb_a.toString();
    }
}
