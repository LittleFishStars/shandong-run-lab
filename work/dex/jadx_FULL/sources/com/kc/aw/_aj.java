package com.kc.aw;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _aj extends LinearLayout implements _ai {
    public View _a;
    public _j _b;
    public _t _c;
    public PtgVideoAdListener _d;
    public _a _e;

    @Keep
    public interface _a {
    }

    public _aj(Context context) {
        super(context);
        _a(context);
    }

    public abstract void _a(Context context);

    @Override // com.kc.aw._ai
    public final boolean _a() {
        return _fp._a(getContext());
    }

    @Override // com.kc.aw._ai
    public final boolean _b() {
        return !hasWindowFocus();
    }

    public void _c() {
        this._b = null;
        this._c = null;
        this._e = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        _n9 _n9Var;
        Context context;
        _h _hVar;
        _ai _aiVar;
        LinearLayout linearLayout;
        _j _jVar;
        String str;
        _k _kVar;
        long j;
        boolean z;
        super.onWindowVisibilityChanged(i);
        _a _aVar = this._e;
        if (_aVar != null) {
            _n6 _n6Var = (_n6) _aVar;
            if (i != 0) {
                _mg._a(_n6Var._g);
                return;
            }
            if (_n6Var._i._a(_n6Var._a)) {
                _n9Var = _n6Var._i;
                z = true;
                if (1 != _n9Var._e) {
                    return;
                }
                context = _n6Var._b;
                _hVar = _n6Var._c;
                _aiVar = _n6Var._d;
                linearLayout = _n6Var._e;
                _jVar = _n6Var._f;
                str = _n6Var._g;
                _kVar = _n6Var._a;
                j = _n6Var._h;
            } else {
                _n9Var = _n6Var._i;
                if (!_n9Var._c && !_n9Var._d) {
                    return;
                }
                context = _n6Var._b;
                _hVar = _n6Var._c;
                _aiVar = _n6Var._d;
                linearLayout = _n6Var._e;
                _jVar = _n6Var._f;
                str = _n6Var._g;
                _kVar = _n6Var._a;
                j = _n6Var._h;
                z = false;
            }
            LinearLayout linearLayout2 = linearLayout;
            long j2 = j;
            _mf _mfVar_a = _mf._a(str, z, _kVar);
            _mg._a(context, new _n7(_n9Var, linearLayout2, _mfVar_a, j2, _aiVar, _hVar, str, _kVar, z, _jVar), _mfVar_a);
        }
    }

    public abstract void setAd(_h _hVar);

    public void setAdClickListener(_j _jVar) {
        this._b = _jVar;
    }

    public void setAdRenderListener(_t _tVar) {
        this._c = _tVar;
    }

    public void setAdShowListener(_u _uVar) {
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._d = ptgVideoAdListener;
    }

    public void setVisibilityChanged(_a _aVar) {
        this._e = _aVar;
    }
}
