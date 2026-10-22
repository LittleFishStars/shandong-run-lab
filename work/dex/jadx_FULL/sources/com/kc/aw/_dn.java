package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dn {
    public PtgNativeExpressAd.AdInteractionListener _a;
    public AdSlot _b;
    public _h _c;
    public ViewGroup _d;
    public List<View> _e;
    public List<View> _f;
    public View _g;
    public _er _h;
    public _gu _i;

    public _dn(Context context, _h _hVar, AdSlot adSlot) {
        this._b = adSlot;
        this._c = _hVar;
        this._i = new _gu(context, _hVar, adSlot);
        _er _gpVar = this._c._s() ? new _gp() : new _gl();
        this._h = _gpVar;
        _gpVar._a(context, _hVar);
    }

    public final void _a() {
        _gu._a _aVar;
        try {
            _gu _guVar = this._i;
            if (_guVar != null) {
                if (_ib._a(_guVar._d)) {
                    Handler handler = _guVar._t;
                    if (handler != null && (_aVar = _guVar._u) != null) {
                        handler.removeCallbacks(_aVar);
                    }
                    String str = _guVar._d;
                    if (!TextUtils.isEmpty(str)) {
                        _ib._a.remove(str);
                    }
                    _mg._a(_guVar._d);
                }
                if (_guVar._e != null) {
                    _guVar._e = null;
                }
                ViewGroup viewGroup = _guVar._f;
                if (viewGroup != null) {
                    viewGroup.setOnTouchListener(null);
                }
                List<View> list = _guVar._g;
                if (list != null && !list.isEmpty()) {
                    Iterator<View> it = _guVar._g.iterator();
                    while (it.hasNext()) {
                        it.next().setOnTouchListener(null);
                    }
                }
                this._i = null;
            }
            _er _erVar = this._h;
            if (_erVar != null) {
                _erVar._a();
                this._h = null;
            }
            if (this._a != null) {
                this._a = null;
            }
            List<View> list2 = this._e;
            if (list2 != null) {
                list2.clear();
            }
            List<View> list3 = this._f;
            if (list3 != null) {
                list3.clear();
            }
        } catch (Exception unused) {
        }
    }
}
