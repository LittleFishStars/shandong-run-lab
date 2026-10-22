package com.kc.aw.lib.provider;

import android.content.Context;
import com.kc.aw._aa;
import com.kc.aw._au;
import com.kc.aw._bi;
import com.kc.aw._bj;
import com.kc.aw._bk;
import com.kc.aw._bl;
import com.kc.aw._bm;
import com.kc.aw._cc;
import com.kc.aw._ch;
import com.kc.aw._ck;
import com.kc.aw._cl;
import com.kc.aw._db;
import com.kc.aw._dc;
import com.kc.aw._eq;
import com.kc.aw._f7;
import com.kc.aw._f8;
import com.kc.aw._gi;
import com.kc.aw._gj;
import com.kc.aw._it;
import com.kc.aw._j3;
import com.kc.aw._jf;
import com.kc.aw._k6;
import com.kc.aw._lc;
import com.kc.aw._ld;
import com.kc.aw._m9;
import com.kc.aw._ma;
import com.kc.aw._mb;
import com.kc.aw._mc;
import com.kc.aw._md;
import com.kc.aw._me;
import com.kc.aw._mp;
import com.kc.aw._mq;
import com.kc.aw._nj;
import com.kc.aw._oi;
import com.kc.aw._oj;
import com.kc.aw._ok;
import com.kc.aw._w;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c implements PtgAdNative {
    public static final _k6 _d = new _k6(null);
    public static final Random _e = new Random();
    public HashMap _a = new HashMap();
    public HashMap _b = new HashMap();
    public _ch _c;

    @Keep
    public final class _a implements _eq<AdSlot, _gj> {
        public final Context _a;
        public final _c _b;

        public _a(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            AdSlot adSlot = (AdSlot) obj;
            _gj _gjVar = (_gj) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 5;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(5);
                    _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
                    _cVar._a(dispatchPolicyCustomerItem).loadBannerExpressAd(context, adSlot.createCustomerAdSlot(dispatchPolicyCustomerItem), new com.kc.aw.lib.provider._d(_gjVar, adSlot));
                    return;
                }
                String str = ", weight == 0";
                if (!_ckVar._d) {
                    _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                    for (_cl _clVar : arrayList) {
                        AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                        adSlot_a.setStype(5);
                        if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                            _j3Var._a(new _m9(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, _gjVar._a));
                            context = context;
                            str = str;
                        } else {
                            Logger.d("abandon nativeExpressAd request, consumer == " + _clVar._c + str);
                        }
                    }
                    _j3Var._b();
                    return;
                }
                adSlot.setConcurrent(true);
                _it _itVar = new _it(_ckVar, _gjVar);
                AtomicInteger atomicInteger = new AtomicInteger();
                ArrayList arrayList2 = new ArrayList();
                for (_cl _clVar2 : arrayList) {
                    AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                    adSlot_a2.setStype(i);
                    if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                        adSlot_a2.setCategoryType(i2);
                        _bk _bkVar = new _bk(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), atomicInteger, _gjVar._a);
                        _itVar._a.add(_bkVar);
                        _bkVar._h();
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(new com.kc.aw.lib.provider._e(_cVar, _clVar2, context, adSlot_a2, _bkVar));
                        arrayList2 = arrayList3;
                        atomicInteger = atomicInteger;
                        i2 = 1;
                        i = 5;
                    } else {
                        Logger.d("abandon banner request, consumer == " + _clVar2._c + ", weight == 0");
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                _itVar._a();
                _itVar._b();
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("loadBannerExpressAd 失败，");
                sb_a.append(e.getMessage());
                Logger.e(sb_a.toString());
                StringBuilder sb_a2 = _jf._a("loadBannerExpressAd 失败，");
                sb_a2.append(e.getMessage());
                _gjVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a2.toString(), (Object) null));
            }
        }
    }

    @Keep
    public final class _b implements _eq<AdSlot, _f8> {
        public final Context _a;
        public final _c _b;

        public _b(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            _f8 _f8Var;
            AdSlot adSlot = (AdSlot) obj;
            _f8 _f8Var2 = (_f8) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 7;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(7);
                    if (adSlot.getTimeoutMs() < 500) {
                        adSlot.setTimeoutMs(3500);
                    }
                    _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
                    _cVar._a(dispatchPolicyCustomerItem).loadInteractionExpressAd(context, adSlot.createCustomerAdSlot(dispatchPolicyCustomerItem), new com.kc.aw.lib.provider._f(_f8Var2, adSlot));
                    return;
                }
                String str = "abandon interaction ad request, consumer == ";
                String str2 = ", weight == 0";
                try {
                    if (!_ckVar._d) {
                        _f8 _f8Var3 = _f8Var2;
                        _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                        for (_cl _clVar : arrayList) {
                            AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                            adSlot_a.setStype(7);
                            if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                                _f8Var = _f8Var3;
                                try {
                                    _j3Var._a(new _mb(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, _f8Var._a));
                                    context = context;
                                    str2 = str2;
                                    str = str;
                                    _f8Var3 = _f8Var;
                                } catch (Exception e) {
                                    e = e;
                                    StringBuilder sb_a = _jf._a("loadInteractionExpressAd 失败，");
                                    sb_a.append(e.getMessage());
                                    Logger.e(sb_a.toString());
                                    StringBuilder sb_a2 = _jf._a("loadInteractionExpressAd 失败，");
                                    sb_a2.append(e.getMessage());
                                    _f8Var.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a2.toString(), (Object) null));
                                }
                            } else {
                                Logger.d(str + _clVar._c + str2);
                            }
                        }
                        _f8Var = _f8Var3;
                        _j3Var._b();
                        return;
                    }
                    try {
                        adSlot.setConcurrent(true);
                        _it _itVar = new _it(_ckVar, _f8Var2);
                        AtomicInteger atomicInteger = new AtomicInteger();
                        ArrayList arrayList2 = new ArrayList();
                        for (_cl _clVar2 : arrayList) {
                            AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                            adSlot_a2.setStype(i);
                            if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                                adSlot_a2.setCategoryType(i2);
                                _bj _bjVar = new _bj(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), atomicInteger, _f8Var2._a);
                                _itVar._a.add(_bjVar);
                                _bjVar._h();
                                _f8 _f8Var4 = _f8Var2;
                                ArrayList arrayList3 = arrayList2;
                                AtomicInteger atomicInteger2 = atomicInteger;
                                _it _itVar2 = _itVar;
                                arrayList3.add(new _g(_cVar, _clVar2, context, adSlot_a2, _bjVar));
                                arrayList2 = arrayList3;
                                _itVar = _itVar2;
                                atomicInteger = atomicInteger2;
                                _f8Var2 = _f8Var4;
                                i2 = 1;
                                i = 7;
                            } else {
                                Logger.d("abandon interaction ad request, consumer == " + _clVar2._c + ", weight == 0");
                            }
                        }
                        _it _itVar3 = _itVar;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        _itVar3._a();
                        _itVar3._b();
                    } catch (Exception e2) {
                        e = e2;
                        _f8 _f8Var5 = _f8Var2;
                        _f8Var = _f8Var5;
                        StringBuilder sb_a3 = _jf._a("loadInteractionExpressAd 失败，");
                        sb_a3.append(e.getMessage());
                        Logger.e(sb_a3.toString());
                        StringBuilder sb_a4 = _jf._a("loadInteractionExpressAd 失败，");
                        sb_a4.append(e.getMessage());
                        _f8Var.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a4.toString(), (Object) null));
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                _f8Var = _f8Var2;
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.aw.lib.provider._c$_c, reason: collision with other inner class name */
    @Keep
    public final class C0957_c implements _eq<AdSlot, _dc> {
        public final Context _a;
        public final _c _b;

        public C0957_c(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            AdSlot adSlot = (AdSlot) obj;
            _dc _dcVar = (_dc) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 101;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(101);
                    if (adSlot.getTimeoutMs() < 500) {
                        adSlot.setTimeoutMs(3500);
                    }
                    _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
                    _cVar._a(dispatchPolicyCustomerItem).loadDrawExpressAd(context, adSlot.createCustomerAdSlot(dispatchPolicyCustomerItem), new _h(_dcVar, adSlot));
                    return;
                }
                String str = ", weight == 0";
                if (!_ckVar._d) {
                    _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                    for (_cl _clVar : arrayList) {
                        AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                        adSlot_a.setStype(101);
                        if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                            _j3Var._a(new _ma(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, _dcVar._a));
                            context = context;
                            str = str;
                        } else {
                            Logger.d("abandon drawFeed ad request, consumer == " + _clVar._c + str);
                        }
                    }
                    _j3Var._b();
                    return;
                }
                adSlot.setConcurrent(true);
                _it _itVar = new _it(_ckVar, _dcVar);
                AtomicInteger atomicInteger = new AtomicInteger();
                ArrayList arrayList2 = new ArrayList();
                for (_cl _clVar2 : arrayList) {
                    AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                    adSlot_a2.setStype(i);
                    if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                        adSlot_a2.setCategoryType(i2);
                        _bi _biVar = new _bi(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), atomicInteger, _dcVar._a);
                        _itVar._a.add(_biVar);
                        _biVar._h();
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(new _i(_cVar, _clVar2, context, adSlot_a2, _biVar));
                        arrayList2 = arrayList3;
                        atomicInteger = atomicInteger;
                        i2 = 1;
                        i = 101;
                    } else {
                        Logger.d("abandon interaction ad request, consumer == " + _clVar2._c + ", weight == 0");
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                _itVar._a();
                _itVar._b();
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("loadDrawFeedAd fail，");
                sb_a.append(e.getMessage());
                Logger.e(sb_a.toString());
                StringBuilder sb_a2 = _jf._a("loadDrawFeedAd fail，");
                sb_a2.append(e.getMessage());
                _dcVar.onError(new AdErrorImpl(PtgErrorCode.SDK_NO_MATCHED_POLICY, sb_a2.toString(), (Object) null));
            }
        }
    }

    @Keep
    public final class _d implements _eq<AdSlot, _mq> {
        public final Context _a;
        public final _c _b;

        public _d(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            AdSlot adSlot = (AdSlot) obj;
            _mq _mqVar = (_mq) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 6;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(6);
                    if (adSlot.getTimeoutMs() < 500) {
                        adSlot.setTimeoutMs(3500);
                    }
                    _cVar._a(adSlot.getDispatchPolicyCustomerItem()).loadSplashAd(context, adSlot.createCustomerAdSlot(adSlot.getDispatchPolicyCustomerItem()), new _j(_mqVar, _mqVar, adSlot));
                    return;
                }
                String str = "abandon splash request, consumer == ";
                String str2 = ", weight == 0";
                if (!_ckVar._d) {
                    _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                    for (_cl _clVar : arrayList) {
                        AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                        adSlot_a.setStype(6);
                        if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                            _j3Var._a(new _me(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, adSlot_a.getOriginalAdContainer(), adSlot_a.getAdContainer(), _mqVar._a));
                            context = context;
                            str2 = str2;
                            str = str;
                        } else {
                            Logger.d(str + _clVar._c + str2);
                        }
                    }
                    _j3Var._b();
                    return;
                }
                adSlot.setConcurrent(true);
                _it _itVar = new _it(_ckVar, _mqVar);
                AtomicInteger atomicInteger = new AtomicInteger();
                ArrayList arrayList2 = new ArrayList();
                for (_cl _clVar2 : arrayList) {
                    AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                    adSlot_a2.setStype(i);
                    if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                        adSlot_a2.setCategoryType(i2);
                        _bm _bmVar = new _bm(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), adSlot.getAdContainer(), adSlot_a2.getAdContainer(), atomicInteger, _mqVar._a);
                        _itVar._a.add(_bmVar);
                        _bmVar._h();
                        _clVar2.getClass();
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(new _k(_cVar, _clVar2, context, adSlot_a2, _bmVar));
                        arrayList2 = arrayList3;
                        _itVar = _itVar;
                        i2 = 1;
                        i = 6;
                    } else {
                        Logger.d("abandon splash request, consumer == " + _clVar2._c + ", weight == 0");
                    }
                }
                _it _itVar2 = _itVar;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                _itVar2._a();
                _itVar2._b();
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("loadSplashAd 失败，");
                sb_a.append(e.getMessage());
                Logger.e(sb_a.toString());
                StringBuilder sb_a2 = _jf._a("loadSplashAd 失败，");
                sb_a2.append(e.getMessage());
                _mqVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a2.toString(), (Object) null));
            }
        }
    }

    @Keep
    public final class _e implements _eq<AdSlot, _gj> {
        public final Context _a;
        public final _c _b;

        public _e(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            _gj _gjVar;
            AdSlot adSlot = (AdSlot) obj;
            _gj _gjVar2 = (_gj) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 8;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(8);
                    if (adSlot.getTimeoutMs() < 500) {
                        adSlot.setTimeoutMs(3500);
                    }
                    _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
                    _cVar._a(dispatchPolicyCustomerItem).loadNativeExpressAd(context, adSlot.createCustomerAdSlot(dispatchPolicyCustomerItem), new _l(_gjVar2, adSlot));
                    return;
                }
                String str = "abandon nativeExpressAd request, consumer == ";
                String str2 = ", weight == 0";
                try {
                    if (!_ckVar._d) {
                        _gj _gjVar3 = _gjVar2;
                        _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                        for (_cl _clVar : arrayList) {
                            AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                            adSlot_a.setStype(8);
                            if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                                _gjVar = _gjVar3;
                                try {
                                    _j3Var._a(new _mc(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, _gjVar._a));
                                    context = context;
                                    str2 = str2;
                                    str = str;
                                    _gjVar3 = _gjVar;
                                } catch (Exception e) {
                                    e = e;
                                    StringBuilder sb_a = _jf._a("loadNativeExpressAd 失败，");
                                    sb_a.append(e.getMessage());
                                    Logger.e(sb_a.toString());
                                    StringBuilder sb_a2 = _jf._a("loadNativeExpressAd 失败，");
                                    sb_a2.append(e.getMessage());
                                    _gjVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a2.toString(), (Object) null));
                                }
                            } else {
                                Logger.d(str + _clVar._c + str2);
                            }
                        }
                        _gjVar = _gjVar3;
                        _j3Var._b();
                        return;
                    }
                    try {
                        adSlot.setConcurrent(true);
                        _it _itVar = new _it(_ckVar, _gjVar2);
                        AtomicInteger atomicInteger = new AtomicInteger();
                        ArrayList arrayList2 = new ArrayList();
                        for (_cl _clVar2 : arrayList) {
                            AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                            adSlot_a2.setStype(i);
                            if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                                adSlot_a2.setCategoryType(i2);
                                _bk _bkVar = new _bk(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), atomicInteger, _gjVar2._a);
                                _itVar._a.add(_bkVar);
                                _bkVar._h();
                                _gj _gjVar4 = _gjVar2;
                                ArrayList arrayList3 = arrayList2;
                                AtomicInteger atomicInteger2 = atomicInteger;
                                _it _itVar2 = _itVar;
                                arrayList3.add(new _m(_cVar, _clVar2, context, adSlot_a2, _bkVar));
                                arrayList2 = arrayList3;
                                _itVar = _itVar2;
                                atomicInteger = atomicInteger2;
                                _gjVar2 = _gjVar4;
                                i2 = 1;
                                i = 8;
                            } else {
                                Logger.d("abandon nativeExpressAd request, consumer == " + _clVar2._c + ", weight == 0");
                            }
                        }
                        _it _itVar3 = _itVar;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        _itVar3._a();
                        _itVar3._b();
                    } catch (Exception e2) {
                        e = e2;
                        _gj _gjVar5 = _gjVar2;
                        _gjVar = _gjVar5;
                        StringBuilder sb_a3 = _jf._a("loadNativeExpressAd 失败，");
                        sb_a3.append(e.getMessage());
                        Logger.e(sb_a3.toString());
                        StringBuilder sb_a4 = _jf._a("loadNativeExpressAd 失败，");
                        sb_a4.append(e.getMessage());
                        _gjVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a4.toString(), (Object) null));
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                _gjVar = _gjVar2;
            }
        }
    }

    @Keep
    public final class _f implements _eq<AdSlot, _ld> {
        public final Context _a;
        public final _c _b;

        public _f(_c _cVar, Context context) {
            this._b = _cVar;
            this._a = context;
        }

        @Override // com.kc.aw._eq
        public final void _a(Object obj, _ck _ckVar, Error error) {
            _ld _ldVar;
            AdSlot adSlot = (AdSlot) obj;
            _ld _ldVar2 = (_ld) error;
            _c _cVar = this._b;
            Context context = this._a;
            _cVar.getClass();
            try {
                ArrayList<_cl> arrayList = _ckVar._c;
                int i = 100;
                int i2 = 1;
                if (1 == arrayList.size()) {
                    adSlot.setUniqueReq(true);
                    adSlot.setDispatchPolicyCustomerItem((_cl) arrayList.get(0));
                    adSlot.setCodeID(adSlot.getDispatchPolicyCustomerItem()._Q);
                    adSlot.setStype(100);
                    if (adSlot.getTimeoutMs() < 500) {
                        adSlot.setTimeoutMs(3500);
                    }
                    _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
                    _cVar._a(dispatchPolicyCustomerItem).loadRewardVideoAd(context, adSlot.createCustomerAdSlot(dispatchPolicyCustomerItem), new _n(_ldVar2, adSlot));
                    return;
                }
                String str = "abandon rewardVideoAd request, consumer == ";
                String str2 = ", weight == 0";
                try {
                    if (!_ckVar._d) {
                        _ld _ldVar3 = _ldVar2;
                        _j3 _j3Var = new _j3(_ckVar._e, _ckVar._b);
                        for (_cl _clVar : arrayList) {
                            AdSlot adSlot_a = _j3._a(context, adSlot, _clVar);
                            adSlot_a.setStype(100);
                            if (_j3._a(adSlot_a, _ckVar, _clVar)) {
                                _ldVar = _ldVar3;
                                try {
                                    _j3Var._a(new _md(_j3Var, _clVar, _cVar._a(_clVar), context, adSlot_a, _ldVar._a));
                                    context = context;
                                    str2 = str2;
                                    str = str;
                                    _ldVar3 = _ldVar;
                                } catch (Exception e) {
                                    e = e;
                                    StringBuilder sb_a = _jf._a("loadRewardVideoAd 失败，");
                                    sb_a.append(e.getMessage());
                                    Logger.e(sb_a.toString());
                                    StringBuilder sb_a2 = _jf._a("loadRewardVideoAd 失败，");
                                    sb_a2.append(e.getMessage());
                                    _ldVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a2.toString(), (Object) null));
                                }
                            } else {
                                Logger.d(str + _clVar._c + str2);
                            }
                        }
                        _ldVar = _ldVar3;
                        _j3Var._b();
                        return;
                    }
                    try {
                        adSlot.setConcurrent(true);
                        _it _itVar = new _it(_ckVar, _ldVar2);
                        AtomicInteger atomicInteger = new AtomicInteger();
                        ArrayList arrayList2 = new ArrayList();
                        for (_cl _clVar2 : arrayList) {
                            AdSlot adSlot_a2 = _it._a(context, adSlot, _clVar2);
                            adSlot_a2.setStype(i);
                            if (_it._a(adSlot_a2, _ckVar, _clVar2)) {
                                adSlot_a2.setCategoryType(i2);
                                _bl _blVar = new _bl(_itVar._b, adSlot_a2.getDispatchPolicyCustomerItem(), atomicInteger, _ldVar2._a);
                                _itVar._a.add(_blVar);
                                _blVar._h();
                                _ld _ldVar4 = _ldVar2;
                                ArrayList arrayList3 = arrayList2;
                                AtomicInteger atomicInteger2 = atomicInteger;
                                _it _itVar2 = _itVar;
                                arrayList3.add(new _o(_cVar, _clVar2, context, adSlot_a2, _blVar));
                                arrayList2 = arrayList3;
                                _itVar = _itVar2;
                                atomicInteger = atomicInteger2;
                                _ldVar2 = _ldVar4;
                                i2 = 1;
                                i = 100;
                            } else {
                                Logger.d("abandon rewardVideoAd request, consumer == " + _clVar2._c + ", weight == 0");
                            }
                        }
                        _it _itVar3 = _itVar;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        _itVar3._a();
                        _itVar3._b();
                    } catch (Exception e2) {
                        e = e2;
                        _ld _ldVar5 = _ldVar2;
                        _ldVar = _ldVar5;
                        StringBuilder sb_a3 = _jf._a("loadRewardVideoAd 失败，");
                        sb_a3.append(e.getMessage());
                        Logger.e(sb_a3.toString());
                        StringBuilder sb_a4 = _jf._a("loadRewardVideoAd 失败，");
                        sb_a4.append(e.getMessage());
                        _ldVar.onError(new AdErrorImpl(PtgErrorCode.SDK_UNKNOWN, sb_a4.toString(), (Object) null));
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                _ldVar = _ldVar2;
            }
        }
    }

    public static boolean _a(Error error) {
        if (!com.kc.aw.lib.utils._a._d()) {
            return false;
        }
        if (error == null) {
            return true;
        }
        error.onError(new AdErrorImpl(10000, "No ad", (Object) null));
        return true;
    }

    public final PtgAdNative _a(_cl _clVar) {
        PtgAdNative ptgAdNative;
        return (_clVar == null || (ptgAdNative = (PtgAdNative) this._a.get(_clVar._c)) == null) ? _d : ptgAdNative;
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        _w _wVar_a = _oi._e._b(adSlot)._a(new _ok())._a(new _oj());
        _wVar_a._p = System.currentTimeMillis();
        int i2 = 100;
        _wVar_a._q = _e.nextInt(100);
        adSlot.setDeviceInfo(_cc._b());
        adSlot.setRandomTime(_wVar_a._p);
        adSlot.setRandomToken(_wVar_a._q);
        if (i == 1) {
            i2 = 6;
        } else if (i == 2) {
            i2 = 8;
        } else if (i == 3) {
            i2 = 5;
        } else if (i == 4) {
            i2 = 7;
        } else if (i != 5) {
            i2 = -1;
        }
        adSlot.setStype(i2);
        try {
            LinkedHashMap linkedHashMap_a = _au._a(adSlot);
            if (!linkedHashMap_a.isEmpty()) {
                return com.kc.aw.lib.utils._a._a(new JSONObject(linkedHashMap_a).toString(), _nj._a());
            }
        } catch (Exception e) {
            StringBuilder sb_a = _jf._a("buildBiddingToken error: ");
            sb_a.append(e.getMessage());
            Logger.e(sb_a.toString());
        }
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getName() {
        return "dispatcher";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void init(Context context) {
        Iterator it = this._a.entrySet().iterator();
        while (it.hasNext()) {
            ((PtgAdNative) ((Map.Entry) it.next()).getValue()).init(context);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _aa._a(this._c, adSlot, nativeExpressAdListener, new _a(this, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _db._a(this._c, adSlot, nativeExpressAdListener, new C0957_c(this, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        if (_a(interactionExpressAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _f7._a(this._c, adSlot, interactionExpressAdListener, new _b(this, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _gi._a(this._c, adSlot, nativeExpressAdListener, new _e(this, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (_a(rewardVideoAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _lc._a(this._c, adSlot, rewardVideoAdListener, new _f(this, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        if (_a(splashAdListener)) {
            return;
        }
        _oi _oiVar = _oi._e;
        if (!_oiVar._a(adSlot)) {
            _w _wVar_a = _oiVar._b(adSlot)._a(new _ok())._a(new _oj());
            _wVar_a._p = System.currentTimeMillis();
            _wVar_a._q = _e.nextInt(100);
            adSlot.setDeviceInfo(_cc._b());
            adSlot.setRandomTime(_wVar_a._p);
            adSlot.setRandomToken(_wVar_a._q);
        }
        _mp._a(this._c, adSlot, splashAdListener, new _d(this, context));
    }
}
