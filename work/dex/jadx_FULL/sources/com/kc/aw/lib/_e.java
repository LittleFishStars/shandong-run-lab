package com.kc.aw.lib;

import android.content.Context;
import android.os.Looper;
import com.kc.aw._bf;
import com.kc.aw._ch;
import com.kc.aw._cj;
import com.kc.aw._cn;
import com.kc.aw._g7;
import com.kc.aw._g8;
import com.kc.aw._ho;
import com.kc.aw._i2;
import com.kc.aw._l0;
import com.kc.aw._nc;
import com.kc.aw._nd;
import com.kc.aw._nt;
import com.kc.aw._ny;
import com.kc.aw._nz;
import com.kc.aw._o1;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e implements _ho {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final Context _b;
    public final _ch _c;
    public final com.kc.aw.lib.provider._c _d;
    public final PtgAdNative _e;
    public final PtgSDKConfig _f;

    public _e(Context context, _ch _chVar, com.kc.aw.lib.provider._c _cVar, com.kc.aw.lib.provider._b _bVar, PtgSDKConfig ptgSDKConfig) {
        this._b = context;
        this._c = _chVar;
        this._d = _cVar;
        this._e = _bVar;
        this._f = ptgSDKConfig;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    /* JADX WARN: Code duplicated, block: B:26:0x0091  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be  */
    /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.kc.aw._ho
    public final void _a(_cj _cjVar, _cn _cnVar) {
        Runnable _nzVar;
        _i2 _i2Var;
        HashMap map;
        Set setKeySet;
        _nt _ntVar_a;
        PtgSDKConfig ptgSDKConfig;
        long j;
        long j2;
        _l0 _l0Var;
        _g8 _g8Var;
        int i;
        int i2;
        Context context;
        long j3;
        PtgAdSdk.mergeCustomController();
        _a._a(this._b, this._c);
        _a._a(this._c);
        AtomicBoolean atomicBoolean = _o1._a;
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig()._m;
        int i3 = PtgAdSdk.getConfig()._w;
        boolean z = ptgCustomController != null && ptgCustomController.isAllowSDKInstallList();
        if (i3 > 0 || z) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                _nzVar = new _nz(true);
            } else {
                _o1._b(_o1._a(true));
            }
            _i2Var = _i2._f;
            map = this._d._a;
            if (map == null) {
                setKeySet = Collections.emptySet();
            } else {
                setKeySet = map.keySet();
            }
            _i2Var._c.clear();
            if (setKeySet != null) {
                _i2Var._c.addAll(setKeySet);
            }
            com.kc.aw.lib.provider._c _cVar = this._d;
            _cVar.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(_cVar._b.values());
            _i2Var._d.clear();
            _i2Var._d.addAll(arrayList);
            if (this._a.compareAndSet(false, true)) {
                this._e.init(this._b);
                PtgSDKConfig ptgSDKConfig2 = this._f;
                ptgSDKConfig2.getClass();
                ptgSDKConfig2._t = System.currentTimeMillis();
                _ntVar_a = _nt._a();
                ptgSDKConfig = this._f;
                j = ptgSDKConfig._s;
                j2 = 0;
                if (j > 0) {
                    j3 = ptgSDKConfig._t;
                    if (j3 > 0) {
                        j2 = j3 - j;
                    }
                }
                _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(j2);
                CopyOnWriteArraySet<String> copyOnWriteArraySet = _g8._h;
                _g8Var = _g8._b._a;
                _g8Var.getClass();
                i = PtgAdSdk.getConfig()._x;
                _g8Var._a = PtgAdSdk.getConfig()._y == 1;
                i2 = PtgAdSdk.config._z;
                if (i != 0 && !_g8Var._f) {
                    _g8Var._g.removeCallbacksAndMessages(null);
                    _g8Var._g.postDelayed(new _g7(_g8Var), ((long) i2) * 1000);
                }
                context = PtgAdSdk.getContext();
                if (PtgAdSdk.getConfig()._C == 1) {
                    com.kc.aw.lib.utils._d._b.postDelayed(new com.kc.aw.lib.utils._d._c(new _bf(context)), ((long) PtgAdSdk.config._z) * 1000);
                }
                com.kc.aw._c._a()._b();
                Context context2 = this._b;
                ArrayList arrayList2 = _nd._a;
                com.kc.aw.lib.utils._d._b(new _nc(context2, _cnVar));
            }
        }
        _nzVar = new _ny();
        com.kc.aw.lib.utils._d._b(_nzVar);
        _i2Var = _i2._f;
        map = this._d._a;
        if (map == null) {
            setKeySet = Collections.emptySet();
        } else {
            setKeySet = map.keySet();
        }
        _i2Var._c.clear();
        if (setKeySet != null) {
            _i2Var._c.addAll(setKeySet);
        }
        com.kc.aw.lib.provider._c _cVar2 = this._d;
        _cVar2.getClass();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(_cVar2._b.values());
        _i2Var._d.clear();
        _i2Var._d.addAll(arrayList3);
        if (this._a.compareAndSet(false, true)) {
            this._e.init(this._b);
            PtgSDKConfig ptgSDKConfig3 = this._f;
            ptgSDKConfig3.getClass();
            ptgSDKConfig3._t = System.currentTimeMillis();
            _ntVar_a = _nt._a();
            ptgSDKConfig = this._f;
            j = ptgSDKConfig._s;
            j2 = 0;
            if (j > 0) {
                j3 = ptgSDKConfig._t;
                if (j3 > 0) {
                    j2 = j3 - j;
                }
            }
            _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._a(j2);
            CopyOnWriteArraySet<String> copyOnWriteArraySet2 = _g8._h;
            _g8Var = _g8._b._a;
            _g8Var.getClass();
            i = PtgAdSdk.getConfig()._x;
            _g8Var._a = PtgAdSdk.getConfig()._y == 1;
            i2 = PtgAdSdk.config._z;
            if (i != 0) {
                _g8Var._g.removeCallbacksAndMessages(null);
                _g8Var._g.postDelayed(new _g7(_g8Var), ((long) i2) * 1000);
            }
            context = PtgAdSdk.getContext();
            if (PtgAdSdk.getConfig()._C == 1) {
                com.kc.aw.lib.utils._d._b.postDelayed(new com.kc.aw.lib.utils._d._c(new _bf(context)), ((long) PtgAdSdk.config._z) * 1000);
            }
            com.kc.aw._c._a()._b();
            Context context3 = this._b;
            ArrayList arrayList4 = _nd._a;
            com.kc.aw.lib.utils._d._b(new _nc(context3, _cnVar));
        }
    }

    @Override // com.kc.aw._ho
    public final void _a(String str) {
    }

    @Override // com.kc.aw._ho
    public final void _b(String str) {
    }

    @Override // com.kc.aw._ho
    public final void _c(String str) {
        Logger.e(str);
        _i2 _i2Var = _i2._f;
        HashMap map = this._d._a;
        Set setEmptySet = map == null ? Collections.emptySet() : map.keySet();
        _i2Var._c.clear();
        if (setEmptySet != null) {
            _i2Var._c.addAll(setEmptySet);
        }
        com.kc.aw.lib.provider._c _cVar = this._d;
        _cVar.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(_cVar._b.values());
        _i2Var._d.clear();
        _i2Var._d.addAll(arrayList);
    }
}
