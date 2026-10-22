package com.kc.aw;

import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _bh {
    public Set<_bh> _a;
    public AdSlot _b;
    public _cl _c;
    public _nr _d;
    public AtomicInteger _e;
    public AtomicBoolean _f = new AtomicBoolean();
    public AtomicBoolean _g = new AtomicBoolean();

    public _bh(SortedSet sortedSet, _cl _clVar, AtomicInteger atomicInteger) {
        this._a = sortedSet;
        this._c = _clVar;
        this._e = atomicInteger;
    }

    public abstract void _a();

    public abstract void _a(AdErrorImpl adErrorImpl);

    public final String _b() {
        _cl _clVar = this._c;
        return _clVar != null ? _clVar._c : "";
    }

    public final int _c() {
        AtomicInteger atomicInteger = this._e;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public final _nr _d() {
        AdSlot adSlot = this._b;
        if (adSlot != null) {
            return adSlot.getTrackingData();
        }
        return null;
    }

    public final int _e() {
        _cl _clVar = this._c;
        if (_clVar != null) {
            return _clVar._e;
        }
        return 0;
    }

    public abstract boolean _f();

    public abstract boolean _g();

    public final void _h() {
        AtomicInteger atomicInteger;
        if (!this._g.compareAndSet(false, true) || (atomicInteger = this._e) == null) {
            return;
        }
        atomicInteger.incrementAndGet();
    }

    public final void _i() {
        AdSlot adSlot;
        if (this._d == null || (adSlot = this._b) == null || adSlot.getDispatchPolicyCustomerItem() == null) {
            return;
        }
        _nt._a()._a(this._b.getDispatchPolicyCustomerItem()._a(), "bidSel", this._d, null);
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("codeId(");
        sb_a.append(_d()._b);
        sb_a.append(")-type(");
        sb_a.append(_b());
        sb_a.append(")-price(");
        _cl _clVar = this._c;
        sb_a.append(_clVar != null ? _clVar._h : 0L);
        sb_a.append(")-runningCounter(");
        sb_a.append(_c());
        sb_a.append(")-isLoaded(");
        sb_a.append(_g());
        sb_a.append(")");
        return sb_a.toString();
    }
}
