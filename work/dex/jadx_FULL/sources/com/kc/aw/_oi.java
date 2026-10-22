package com.kc.aw;

import com.kc.aw.lib.interf.PtgAd;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _oi {
    public static final _oi _e = new _oi();
    public final WeakHashMap _a = new WeakHashMap();
    public final WeakHashMap _b = new WeakHashMap();
    public final WeakHashMap _c = new WeakHashMap();
    public final _a7 _d = new _a7();

    public final void _a(AdSlot adSlot, PtgAd ptgAd) {
        if (adSlot == null || ptgAd == null) {
            return;
        }
        _w _wVar_b = _b(adSlot);
        ArrayList<_i5> arrayList = new ArrayList();
        synchronized (this._a) {
            List list = (List) this._a.get(_wVar_b);
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        _i5 _i5Var = null;
        if (!arrayList.isEmpty()) {
            for (_i5 _i5Var2 : arrayList) {
                WeakReference<PtgAd> weakReference = _i5Var2._c;
                if ((weakReference != null ? weakReference.get() : null) == ptgAd) {
                    _i5Var = _i5Var2;
                    break;
                }
            }
        }
        if (_i5Var == null) {
            _i5 _i5Var3 = new _i5(_wVar_b, ptgAd);
            synchronized (this._a) {
                List arrayList2 = (List) this._a.get(_wVar_b);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(_i5Var3);
                this._a.put(_wVar_b, arrayList2);
            }
            synchronized (this._b) {
                this._b.put(ptgAd, _wVar_b);
            }
        }
    }

    public final boolean _a(AdSlot adSlot) {
        synchronized (this._c) {
            if (adSlot != null) {
                if (this._c.containsKey(adSlot)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final _w _b(AdSlot adSlot) {
        AdSlot adSlot2;
        _w _wVar;
        if (adSlot instanceof _w) {
            _wVar = (_w) adSlot;
            adSlot2 = _wVar._X.get();
        } else {
            adSlot2 = adSlot;
            _wVar = null;
        }
        synchronized (this._c) {
            if (adSlot2 != null) {
                if (!this._c.containsKey(adSlot2)) {
                    _wVar = new _w(this._d, adSlot2, new _of());
                    this._c.put(adSlot2, _wVar);
                }
            }
        }
        return _wVar;
    }
}
