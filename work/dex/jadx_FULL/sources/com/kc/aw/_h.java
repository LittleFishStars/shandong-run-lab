package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.model.AppInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h implements Serializable {
    public String _A;
    public _f4 _B;
    public _fm _C;
    public _bb _D;
    public List<String> _E;
    public List<String> _F;
    public Map<String, String> _G;
    public boolean _H;
    public long _I;
    public boolean _J;
    public String _K;
    public int _a;
    public String _b;
    public AppInfo _c;
    public String _d;
    public String _e;
    public List<String> _f;
    public List<String> _g;
    public Map<String, List<String>> _h;
    public String _i;
    public int _j;
    public int _k;
    public int _l;
    public int _m;
    public List<String> _n;
    public Map<Long, List<String>> _o;
    public String _p;
    public _k _q;
    public Map<String, String> _r;
    public _ks _s;
    public _nk _t;
    public String _u;
    public long _v;
    public long _w;
    public boolean _x = false;
    public int _y;
    public _i6 _z;

    public final String _a() {
        return String.valueOf(hashCode());
    }

    public final String _b() {
        List<_j9> list_h = _h();
        return (list_h == null || list_h.isEmpty()) ? "" : list_h.get(0)._a;
    }

    public final AppInfo _c() {
        return this._c;
    }

    public final String _d() {
        AppInfo appInfo = this._c;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getName())) ? "" : this._c.getName();
    }

    public final String _e() {
        _i6 _i6Var = this._z;
        return _i6Var != null ? _i6Var._b : "";
    }

    public final _j9 _f() {
        List<_j9> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return null;
        }
        return list_h.get(0);
    }

    public final int _g() {
        _i6 _i6Var = this._z;
        if (_i6Var._a()) {
            _k8 _k8Var = _i6Var._f;
            if (_k8Var != null) {
                return _k8Var._d;
            }
            return 0;
        }
        List<_j9> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return 0;
        }
        return list_h.get(0)._c;
    }

    public final List<_j9> _h() {
        _i6 _i6Var = this._z;
        if (_i6Var != null) {
            return _i6Var._e;
        }
        return null;
    }

    public final String _i() {
        _i6 _i6Var = this._z;
        if (_i6Var != null) {
            return _i6Var._c;
        }
        return null;
    }

    public final String _j() {
        _i6 _i6Var = this._z;
        return _i6Var != null ? _i6Var._h : "";
    }

    public final String _k() {
        _i6 _i6Var = this._z;
        return _i6Var != null ? _i6Var._a : "";
    }

    public final _k8 _l() {
        _i6 _i6Var = this._z;
        if (_i6Var != null) {
            return _i6Var._f;
        }
        return null;
    }

    public final String _m() {
        _k8 _k8Var_l = _l();
        return _k8Var_l != null ? _k8Var_l._b : "";
    }

    public final int _n() {
        _i6 _i6Var = this._z;
        if (_i6Var._a()) {
            _k8 _k8Var = _i6Var._f;
            if (_k8Var != null) {
                return _k8Var._c;
            }
            return 0;
        }
        List<_j9> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return 0;
        }
        return list_h.get(0)._b;
    }

    public final boolean _o() {
        _k _kVar = this._q;
        if (_kVar != null) {
            return _kVar._n;
        }
        return false;
    }

    public final boolean _p() {
        _k _kVar = this._q;
        if (_kVar != null) {
            return _kVar._u;
        }
        return false;
    }

    public final boolean _q() {
        _k _kVar = this._q;
        if (_kVar != null) {
            return _kVar._o;
        }
        return false;
    }

    public final boolean _r() {
        return this._v <= 0 || this._w <= 0 || System.currentTimeMillis() - this._w < this._v;
    }

    public final boolean _s() {
        _i6 _i6Var = this._z;
        if (_i6Var != null) {
            return _i6Var._a();
        }
        return false;
    }
}
