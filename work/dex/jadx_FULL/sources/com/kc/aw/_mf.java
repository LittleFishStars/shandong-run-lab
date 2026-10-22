package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mf {
    public String _a;
    public int _b;
    public int _c;
    public boolean _d;
    public long _e;
    public _m6 _f;

    public static _mf _a(String str, _k _kVar) {
        _mf _mfVar = new _mf();
        _mfVar._a = str;
        if (_kVar != null) {
            _mfVar._b = _kVar._b;
            _mfVar._c = 1;
            _mfVar._d = false;
            _mfVar._e = _kVar._c;
            _mfVar._f = _m6._a(_kVar._q, _kVar._s);
        }
        return _mfVar;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    public static _mf _a(String str, boolean z, _k _kVar) {
        int i;
        int i2;
        List<Integer> list;
        boolean z2;
        float f;
        float f2;
        _m6 _m6Var_a;
        List<Integer> list2;
        _mf _mfVar = new _mf();
        _mfVar._a = str;
        if (_kVar != null) {
            if (_kVar._b()) {
                i = 0;
            } else {
                List<Integer> list3 = _kVar._g;
                i = (list3 != null && list3.contains(1) && _kVar._c()) ? _kVar._h : _kVar._b;
            }
            _mfVar._b = i;
            if (_kVar._b()) {
                i2 = 7;
            } else {
                i2 = _kVar._c() && (list = _kVar._g) != null && list.contains(1) ? 5 : 1;
            }
            _mfVar._c = i2;
            if (!z) {
                z2 = _kVar._c() && (list2 = _kVar._g) != null && list2.contains(1);
            }
            _mfVar._d = z2;
            _mfVar._e = z ? _kVar._a() : _kVar._c;
            if (_kVar._b()) {
                _m6Var_a = _m6._a(0.0f, 0.0f);
            } else {
                List<Integer> list4 = _kVar._g;
                if (list4 != null && list4.contains(1) && _kVar._c()) {
                    f = _kVar._r;
                    f2 = _kVar._t;
                } else {
                    f = _kVar._q;
                    f2 = _kVar._s;
                }
                _m6Var_a = _m6._a(f, f2);
            }
            _mfVar._f = _m6Var_a;
        }
        return _mfVar;
    }
}
