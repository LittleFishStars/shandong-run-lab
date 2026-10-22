package com.kc.aw;

import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _w extends _v implements _oe<AdSlot> {
    public final _of _U;
    public final LinkedHashSet _V;
    public final _oe<?> _W;
    public WeakReference<AdSlot> _X;

    public _w() {
        throw null;
    }

    public _w(_oe<?> _oeVar, AdSlot adSlot, _of _ofVar) {
        super(0);
        this._V = new LinkedHashSet();
        this._W = _oeVar;
        UUID.randomUUID().toString();
        this._U = _ofVar;
        adSlot.write(this);
        this._X = new WeakReference<>(adSlot);
        _ofVar._a(_oeVar, this);
    }

    @Override // com.kc.aw._oe
    public final _of _a() {
        return this._U;
    }

    @Override // com.kc.aw._oe
    /* JADX INFO: renamed from: _b, reason: merged with bridge method [inline-methods] */
    public final _w _a(_og _ogVar) {
        boolean zAdd;
        synchronized (this._V) {
            zAdd = !this._V.contains(_ogVar) ? this._V.add(_ogVar) : false;
        }
        if (zAdd) {
            boolean z = _ogVar instanceof _ok;
            boolean z2 = _ogVar instanceof _oj;
            _of _ofVar = this._U;
            _ofVar.getClass();
            ArrayList arrayList = new ArrayList();
            synchronized (_ofVar._b) {
                arrayList.addAll(_ofVar._b.keySet());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_oe) it.next())._a(_ogVar);
            }
            this._U._a(_ogVar);
        }
        return this;
    }

    @Override // com.kc.aw._v, com.kc.aw.lib.model.AdSlot
    public final AdSlot createCustomerAdSlot(_cl _clVar) {
        _w _wVar = new _w(this._W, super.createCustomerAdSlot(_clVar), this._U);
        _wVar._X = this._X;
        _wVar._V.clear();
        _wVar._V.addAll(this._V);
        return _wVar;
    }

    @Override // com.kc.aw._v, com.kc.aw.lib.model.AdSlot
    public final AdSlot write(AdSlot adSlot) {
        super.write(adSlot);
        if (adSlot instanceof _w) {
            _w _wVar = (_w) adSlot;
            _wVar.getClass();
            _wVar._X = this._X;
            _wVar._V.clear();
            _wVar._V.addAll(this._V);
        }
        return adSlot;
    }
}
