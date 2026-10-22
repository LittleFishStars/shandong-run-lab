package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dj {
    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static void _a(_h _hVar) {
        _k _kVar;
        boolean z;
        if (_hVar == null || (_kVar = _hVar._q) == null) {
            return;
        }
        String str = "3";
        if (!_kVar._d) {
            _kVar._x = "0";
            _kVar._y = "0";
            _kVar._z = "0";
            _kVar._A = "0";
        } else {
            if (com.kc.aw.lib.utils._a._a(_kVar._p)) {
                boolean z2 = _jw._a("sdk_local_enhance_limit", "enhanceLimit") < ((long) _kVar._e);
                boolean z3 = System.currentTimeMillis() - _jw._a("sdk_local_enhance_last_time", "enhanceLastTime") > ((long) _kVar._f) * 1000;
                if (z2 && z3) {
                    _kVar._x = "2";
                    _kVar._y = "0";
                    _kVar._B = _kVar._a(true);
                    z = true;
                } else {
                    _kVar._x = "1";
                    if (z2) {
                        _kVar._y = "2";
                        _kVar._z = "1";
                        _kVar._A = "2";
                    } else {
                        _kVar._y = "3";
                        _kVar._z = "1";
                        _kVar._A = "3";
                    }
                }
                if (z) {
                    if (_kVar._i) {
                        if (_jw._a("sdk_local_enhance_f_click_limit", "fClickLimit") < ((long) _kVar._l)) {
                            _kVar._z = "2";
                        } else {
                            _kVar._z = "1";
                        }
                        _kVar._A = str;
                    }
                    _kVar._z = "0";
                    str = "0";
                    _kVar._A = str;
                }
            }
            _kVar._x = "1";
            _kVar._y = "1";
            _kVar._z = "1";
            _kVar._A = "1";
        }
        _kVar._B = _kVar._a(false);
        z = false;
        if (z) {
            if (_kVar._i) {
                if (_jw._a("sdk_local_enhance_f_click_limit", "fClickLimit") < ((long) _kVar._l)) {
                    _kVar._z = "2";
                } else {
                    _kVar._z = "1";
                }
                _kVar._A = str;
            }
            _kVar._z = "0";
            str = "0";
            _kVar._A = str;
        }
    }
}
