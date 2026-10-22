package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nk implements Serializable {
    public int _a;
    public int _b;
    public int _c;
    public double _d;
    public float _e;

    public static _nk _a(float f, float f2, float f3, double d, float f4, boolean z) {
        _nk _nkVar = new _nk();
        _nkVar._d = d;
        _nkVar._e = f4;
        int i = (int) (f * 100.0f);
        int i2 = (int) (f2 * 100.0f);
        int i3 = (int) (f3 * 100.0f);
        if (z) {
            float fNextFloat = (com.kc.aw.lib.utils._a._a.nextFloat() * 60.0f) - 30.0f;
            float fAbs = 5.0f - (Math.abs(fNextFloat) / 10.0f);
            float fNextFloat2 = (fAbs * 2.0f * com.kc.aw.lib.utils._a._a.nextFloat()) + (-fAbs);
            float fAbs2 = (12.0f - (Math.abs(fNextFloat) / 10.0f)) - (Math.abs(fNextFloat2) / 10.0f);
            if (fAbs2 < 5.0f) {
                fAbs2 = 5.0f;
            }
            float fNextFloat3 = com.kc.aw.lib.utils._a._a.nextFloat();
            _nkVar._a = (int) (fNextFloat * 100.0f);
            _nkVar._b = (int) (fNextFloat2 * 100.0f);
            _nkVar._c = (int) (((fNextFloat3 * fAbs2) + 5.0f) * 100.0f);
        } else {
            _nkVar._a = i;
            _nkVar._b = i2;
            _nkVar._c = i3;
        }
        return _nkVar;
    }
}
