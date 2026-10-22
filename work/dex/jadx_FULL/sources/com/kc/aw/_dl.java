package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dl implements _gd {
    public final _dn _a;

    public _dl(_dn _dnVar) {
        this._a = _dnVar;
    }

    public final void _a() {
        _h _hVar;
        Context context;
        _mf _mfVar_a;
        _gv _gvVar;
        List<Integer> list;
        _gu _guVar = this._a._i;
        if (_guVar != null) {
            _guVar._o = System.currentTimeMillis();
            ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
            if ((!concurrentHashMap.isEmpty()) || (_hVar = _guVar._c) == null) {
                return;
            }
            _k _kVar = _hVar._q;
            _guVar._h = _kVar;
            if (_kVar == null || !_kVar._c()) {
                return;
            }
            String str = _guVar._d;
            if (!TextUtils.isEmpty(str)) {
                concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            _guVar._j = _guVar._h._b(_guVar._i);
            _guVar._k = _guVar._h._d(_guVar._i);
            _guVar._l = _guVar._h._c(_guVar._i);
            _k _kVar2 = _guVar._h;
            _guVar._m = _kVar2._j;
            _guVar._n = _guVar._i && (list = _kVar2._g) != null && list.contains(4);
            if (_guVar._a(true)) {
                if (1 != _guVar._m) {
                    long j_a = _guVar._h._a();
                    _guVar._t.removeCallbacks(_guVar._u);
                    _guVar._t.postDelayed(_guVar._u, j_a);
                    return;
                } else {
                    context = _guVar._a;
                    _k _kVar3 = _guVar._h;
                    _guVar._x.set(true);
                    _mfVar_a = _mf._a(_guVar._d, true, _kVar3);
                    _gvVar = new _gv(_guVar, _mfVar_a);
                }
            } else {
                if (!_guVar._b(true)) {
                    return;
                }
                context = _guVar._a;
                _k _kVar4 = _guVar._h;
                _guVar._x.set(true);
                _mfVar_a = _mf._a(_guVar._d, false, _kVar4);
                _gvVar = new _gv(_guVar, _mfVar_a);
            }
            _mg._a(context, _gvVar, _mfVar_a);
        }
    }

    public final void _a(int i) {
        Context context;
        _mf _mfVar_a;
        _gv _gvVar;
        _gu _guVar = this._a._i;
        if (_guVar != null) {
            try {
                if (i != 0) {
                    if (_guVar._x.get()) {
                        _guVar._x.set(false);
                        String str = _guVar._d;
                        ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
                        if (!TextUtils.isEmpty(str)) {
                            concurrentHashMap.remove(str);
                        }
                        _mg._a(_guVar._d);
                        return;
                    }
                    return;
                }
                if (_guVar._x.get()) {
                    return;
                }
                if (_guVar._a(false) || _guVar._b(false)) {
                    ConcurrentHashMap<String, Long> concurrentHashMap2 = _ib._a;
                    if (!(!concurrentHashMap2.isEmpty())) {
                        String str2 = _guVar._d;
                        if (!TextUtils.isEmpty(str2)) {
                            concurrentHashMap2.put(str2, Long.valueOf(System.currentTimeMillis()));
                        }
                    }
                }
                if (_guVar._a(true)) {
                    if (1 != _guVar._m) {
                        return;
                    }
                    context = _guVar._a;
                    _k _kVar = _guVar._h;
                    _guVar._x.set(true);
                    _mfVar_a = _mf._a(_guVar._d, true, _kVar);
                    _gvVar = new _gv(_guVar, _mfVar_a);
                } else {
                    if (!_guVar._b(true)) {
                        return;
                    }
                    context = _guVar._a;
                    _k _kVar2 = _guVar._h;
                    _guVar._x.set(true);
                    _mfVar_a = _mf._a(_guVar._d, false, _kVar2);
                    _gvVar = new _gv(_guVar, _mfVar_a);
                }
                _mg._a(context, _gvVar, _mfVar_a);
            } catch (Exception unused) {
            }
        }
    }
}
