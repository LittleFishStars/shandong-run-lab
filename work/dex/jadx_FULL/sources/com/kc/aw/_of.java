package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _of {
    public final WeakHashMap _a = new WeakHashMap();
    public final WeakHashMap _b = new WeakHashMap();
    public WeakReference<_oe<?>> _c;

    @Keep
    public static final class _a {
    }

    public final void _a(_oe<?> _oeVar, _oe<?> _oeVar2) {
        WeakReference<_oe<?>> weakReference = this._c;
        if (weakReference == null || weakReference.get() == null || this._c.get() == _oeVar) {
            if (this._c == null) {
                this._c = new WeakReference<>(_oeVar);
            }
            if (_oeVar != null && _oeVar._a() != null) {
                _of _ofVar_a = _oeVar._a();
                if (_oeVar2 != null) {
                    synchronized (_ofVar_a._a) {
                        if (!_ofVar_a._a.containsKey(_oeVar2)) {
                            _ofVar_a._a.put(_oeVar2, new _a());
                        }
                    }
                } else {
                    _ofVar_a.getClass();
                }
            }
            synchronized (this._b) {
                if (!this._b.containsKey(_oeVar2)) {
                    this._b.put(_oeVar2, new _a());
                }
            }
        }
    }

    public final void _a(_og _ogVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this._a) {
            arrayList.addAll(this._a.keySet());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((_oe) it.next())._a(_ogVar);
        }
    }
}
