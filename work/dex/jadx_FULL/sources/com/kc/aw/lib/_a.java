package com.kc.aw.lib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kc.aw._av;
import com.kc.aw._cg;
import com.kc.aw._ch;
import com.kc.aw._cj;
import com.kc.aw._cl;
import com.kc.aw._cn;
import com.kc.aw._e0;
import com.kc.aw._ea;
import com.kc.aw._ed;
import com.kc.aw._ft;
import com.kc.aw._gb;
import com.kc.aw._hg;
import com.kc.aw._hq;
import com.kc.aw._hv;
import com.kc.aw._i2;
import com.kc.aw._jw;
import com.kc.aw._k6;
import com.kc.aw._kx;
import com.kc.aw._ky;
import com.kc.aw._mi;
import com.kc.aw._nb;
import com.kc.aw._nd;
import com.kc.aw._nm;
import com.kc.aw._nt;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a {

    /* JADX INFO: renamed from: com.kc.aw.lib._a$_a, reason: collision with other inner class name */
    @Keep
    public final class C0954_a implements Error {
        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            Logger.e(adError.getMessage());
        }
    }

    static {
        new C0954_a();
    }

    public static com.kc.aw.lib.provider._c _a(_ch _chVar, PtgAdNative... ptgAdNativeArr) {
        com.kc.aw.lib.provider._c _cVar = new com.kc.aw.lib.provider._c();
        for (PtgAdNative ptgAdNative : ptgAdNativeArr) {
            if (ptgAdNative != null) {
                _cVar._b.put(ptgAdNative.getName(), ptgAdNative);
                _cVar._a.put(ptgAdNative.getName(), new com.kc.aw.lib.provider._b(new _k6(new com.kc.aw.lib.provider._b(new _hv(ptgAdNative.getName(), new com.kc.aw.lib.provider._b(ptgAdNative))))));
            }
        }
        _cVar._c = _chVar;
        return _cVar;
    }

    public static void _a(Context context, _ch _chVar) {
        PtgSDKConfig ptgSDKConfig;
        _cn _cnVar = _chVar._d;
        if (_cnVar == null || (ptgSDKConfig = PtgAdSdk.config) == null) {
            return;
        }
        TextUtils.isEmpty(_cnVar._b);
        if (!TextUtils.isEmpty(_cnVar._c)) {
            ptgSDKConfig._b = _cnVar._c;
        }
        ptgSDKConfig._p = _cnVar._q;
        if (!TextUtils.isEmpty(_cnVar._d)) {
            ptgSDKConfig._e = _cnVar._d;
        }
        if (!TextUtils.isEmpty(_cnVar._v)) {
            ptgSDKConfig._q = _cnVar._v;
        }
        List<String> list = _cnVar._w;
        if (list != null) {
            ptgSDKConfig._r = list;
        }
        ptgSDKConfig._u = _cnVar._g;
        ptgSDKConfig._v = _cnVar._h;
        ptgSDKConfig._w = _cnVar._i;
        if (!TextUtils.isEmpty(_cnVar._e)) {
            ptgSDKConfig._f = _cnVar._e;
        }
        if (!TextUtils.isEmpty(_cnVar._f)) {
            ptgSDKConfig._g = _cnVar._f;
        }
        ptgSDKConfig._G = _cnVar._J;
        ptgSDKConfig._D = _cnVar._j;
        _jw._a(context, "rtb_log_interval", _cnVar._p);
        _jw._a(context, "rtb_log_url", _cnVar._o);
        _jw._a(context, "p_url", _cnVar._s);
        int i = _cnVar._x;
        ptgSDKConfig._I = Integer.valueOf(i);
        if (context != null) {
            _jw._a(context, "sdk_local_less_than", String.valueOf(i));
        }
        ptgSDKConfig._E = _cnVar._l;
        ptgSDKConfig._y = _cnVar._L;
        ptgSDKConfig._x = _cnVar._K;
        ptgSDKConfig._z = _cnVar._P;
        ptgSDKConfig._A = _cnVar._M;
        ptgSDKConfig._B = _cnVar._N;
        ptgSDKConfig._C = _cnVar._O;
        if (_cnVar._Q == null) {
            _cnVar._Q = new ArrayList();
        }
        ptgSDKConfig._H = _cnVar._Q;
        _i2 _i2Var = _i2._f;
        _i2Var._a = _cnVar._t;
        List<String> list2 = _cnVar._u;
        synchronized (_i2Var._e) {
            _i2Var._e.clear();
            if (list2 != null) {
                _i2Var._e.addAll(list2);
            }
        }
    }

    public static void _a(Context context, PtgSDKConfig ptgSDKConfig, PtgAdSdk.Callback callback, PtgAdNative[] ptgAdNativeArr) {
        try {
            com.kc.aw._b _bVar = com.kc.aw._b._a;
            _nt _ntVar_a = _nt._a();
            synchronized (_ntVar_a._a) {
                _ntVar_a._a.add(_bVar);
            }
            _ch _chVar = new _ch();
            com.kc.aw.lib.provider._c _cVar_a = _a(_chVar, ptgAdNativeArr);
            com.kc.aw.lib.provider._b _bVar2 = new com.kc.aw.lib.provider._b(_cVar_a);
            PtgAdSdk.globalProvider = _bVar2;
            _chVar._a = new _mi(new _gb(new _ft(), new _ed()), new _d(callback));
            _e0 _e0Var = new _e0(new _ea(), new _hg(Build.VERSION.RELEASE), new _hq());
            _e0Var.start();
            _chVar._b = _e0Var;
            _i2._f._b = _chVar;
            ArrayList arrayList = _nd._a;
            com.kc.aw.lib.utils._d._b(new _nb(context, ptgSDKConfig));
            _chVar._a._a(new _cg(_chVar, _chVar, new _nm(_chVar, new _e(context, _chVar, _cVar_a, _bVar2, ptgSDKConfig))));
            _a(context, _chVar);
            _a(_chVar);
        } catch (Exception e) {
            if (callback != null) {
                callback.fail(100, e.getMessage());
            }
        }
    }

    public static void _a(_ch _chVar) {
        List listEmptyList;
        _cj _cjVar = _chVar._c;
        if (_cjVar == null) {
            listEmptyList = Collections.emptyList();
        } else {
            Collection<List> collectionValues = _cjVar._a.values();
            ArrayList arrayList = new ArrayList();
            if (collectionValues != null) {
                for (List list : collectionValues) {
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                }
            }
            listEmptyList = arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (listEmptyList != null) {
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                for (_av _avVar : ((_cl) it.next())._M) {
                    if (_avVar != null) {
                        linkedHashMap.put(_avVar._b, _avVar._c);
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Collection collectionValues2 = linkedHashMap.values();
        ConcurrentHashMap concurrentHashMap = _kx._a;
        if (collectionValues2 == null || collectionValues2.isEmpty()) {
            return;
        }
        _kx._b.execute(new _ky(collectionValues2));
    }
}
