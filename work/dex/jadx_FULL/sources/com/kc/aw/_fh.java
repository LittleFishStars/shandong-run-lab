package com.kc.aw;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fh {
    public String _c;
    public _h _d;
    public AdSlot _e;
    public boolean _f;
    public _in _g;
    public FrameLayout _i;
    public _fa _j;
    public View _k;
    public int _a = 0;
    public int _b = 0;
    public final _a _h = new _a(this);

    @Keep
    public final class _a implements _in._b {
        public final _fh _a;

        public _a(_fh _fhVar) {
            this._a = _fhVar;
        }

        @Override // com.kc.aw._in._b
        public final void _a(View view, int i, _nk _nkVar) {
            _fh _fhVar = this._a;
            _fhVar._a(view, i, _nkVar, true);
            _m1._a(_fhVar._k, view, null);
        }

        @Override // com.kc.aw._in._b
        public final void _a(boolean z) {
            _fa _faVar = this._a._j;
            if (_faVar != null) {
                _faVar.setShakeLayoutVisible(z);
            }
        }

        @Override // com.kc.aw._in._b
        public final void _b(View view, int i, _nk _nkVar) {
            this._a._a(view, i, _nkVar, false);
        }
    }

    public final void _a(View view, int i, _nk _nkVar, boolean z) {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        _h _hVar;
        if (view == null || this._d == null) {
            return;
        }
        AdSlot adSlot = this._e;
        if (adSlot != null) {
            adSlot.setCt(i);
        }
        _h _hVar2 = this._d;
        if (_hVar2 != null) {
            _hVar2._t = _nkVar;
        }
        _dj._a(_hVar2);
        boolean z2 = z && (_hVar = this._d) != null && _hVar._p();
        _h _hVar3 = this._d;
        if (z2) {
            i = 0;
        }
        _m2 _m2Var = _m1._a;
        if (_m2Var != null) {
            _m2Var._a(view, _hVar3, i);
        }
        _fk _fkVar_a = _fk._a();
        String str = this._c;
        _fkVar_a.getClass();
        if (!TextUtils.isEmpty(str) && (adInteractionListener = _fkVar_a._d.get(str)) != null) {
            adInteractionListener.onAdClicked();
        }
        _b2._a(view.getContext(), this._d, this._e);
        _in _inVar = this._g;
        if (_inVar != null) {
            _jw._a(_inVar._i, _inVar._k);
            this._g._a(false);
        }
    }
}
