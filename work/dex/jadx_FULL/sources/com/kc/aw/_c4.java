package com.kc.aw;

import android.content.Context;
import android.net.Uri;
import com.ipd.dsp.internal.n.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c4 {
    public final int _a;
    public final int _b;
    public final _l2 _c;
    public _c1 _d;

    public _c4(_l2 _l2Var) {
        this._c = _l2Var;
        String str = _l2Var._b;
        this._a = _l2Var._d;
        this._b = _l2Var._e;
    }

    public final byte[] _a() throws IOException {
        _c1 _c1Var_b = _b();
        if (_c1Var_b._f == null) {
            _c1Var_b._f = _c1Var_b._b._b();
        }
        return _c1Var_b._f;
    }

    public final _c1 _b() throws IOException {
        _c1._a _cVar;
        Context context;
        String str_c;
        if (this._d == null) {
            _l2 _l2Var = this._c;
            String str = _l2Var._b;
            boolean z = false;
            if (str.startsWith("http")) {
                _az _azVar = new _az(str);
                com.kc.aw.lib.doodle._a _aVar = com.kc.aw.lib.doodle._b._a;
                synchronized (_aVar) {
                    if (_aVar._a()) {
                        com.kc.aw.lib.doodle._a._b _bVar = (com.kc.aw.lib.doodle._a._b) _aVar._h.get(_azVar);
                        if (_bVar != null) {
                            int i = _aVar._e;
                            _bVar._c = i;
                            _aVar._g.putInt(_bVar._b, i);
                            _aVar._e++;
                        }
                        str_c = _bVar != null ? _aVar._c(_azVar) : null;
                    } else {
                        str_c = null;
                    }
                }
                if (str_c == null || !new File(str_c).exists()) {
                    _aVar._a(_azVar);
                    str_c = null;
                }
                if (str_c != null) {
                    _cVar = new _c1._b(new File(str_c));
                    z = true;
                } else {
                    if (_l2Var._i) {
                        throw new IOException("No cache");
                    }
                    int i2 = _l2Var._k;
                    _i8._a(i2);
                    if (i2 == 4 || i2 == 2) {
                        String str2 = _bn._a;
                        _cVar = new _c1._b(com.kc.aw.lib.doodle._b._a(com.kc.aw.lib.doodle._b._a(1, str), _azVar, true));
                    } else {
                        String str3 = _bn._a;
                        _cVar = new _c1._c(str, com.kc.aw.lib.doodle._b._a(1, str), null);
                    }
                }
            } else if (str.startsWith(a.d)) {
                _cVar = new _c1._c(str, _o2._a.getAssets().open(str.substring(22)), null);
            } else if (str.startsWith("file://")) {
                _cVar = new _c1._b(new File(str.substring(7)));
            } else {
                String str4 = _bn._a;
                Uri uri = _l2Var._c;
                if (uri == null) {
                    uri = Uri.parse(str);
                }
                if (_o2._b == null && (context = _o2._a) != null) {
                    _o2._b = context.getContentResolver();
                }
                _cVar = new _c1._c(str, _o2._b.openInputStream(uri), uri);
            }
            this._d = new _c1(str, _cVar, z);
        }
        return this._d;
    }
}
