package com.kc.aw;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _it {
    public final SortedSet _b;
    public final _ck _d;
    public final Error _e;
    public final AtomicBoolean _h = new AtomicBoolean();
    public final long _g = 3500;
    public final AtomicBoolean _c = new AtomicBoolean(false);
    public final Timer _f = new Timer();
    public final HashSet _a = new HashSet();

    @Keep
    public final class _a extends TimerTask {
        public final _it _a;

        public _a(_it _itVar) {
            this._a = _itVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                _it _itVar = this._a;
                Logger.e("ConcurrentHolder", "doCallback:CALL--TIMER_OVER cost(ms):" + this._a._g + " execute:" + _it._a(_itVar, _itVar._c, _itVar._d, _itVar._b, _itVar._e));
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e("ConcurrentHolder", e.getMessage());
            }
        }
    }

    @Keep
    public static abstract class _b<E extends _bh> extends TreeSet<E> {
        public _ck _a;
        public ArrayList _b;

        public _b(_c _cVar, _ck _ckVar) {
            super(_cVar);
            this._a = _ckVar;
            ArrayList arrayList_a = _ckVar._a();
            this._b = new ArrayList(arrayList_a.size());
            Iterator it = arrayList_a.iterator();
            while (it.hasNext()) {
                this._b.add(Integer.valueOf(((_cl) it.next())._h()));
            }
            Collections.sort(this._b, new _iy());
        }

        public abstract void _a();

        @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: _a, reason: merged with bridge method [inline-methods] */
        public final boolean add(E e) {
            AtomicInteger atomicInteger;
            boolean z = false;
            if (e != null) {
                boolean zAdd = e._g() ? super.add(e) : false;
                if (e._f.compareAndSet(false, true) && (atomicInteger = e._e) != null) {
                    atomicInteger.decrementAndGet();
                }
                z = zAdd;
            }
            if (e._f()) {
                Iterator it = this._b.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (num.intValue() == e._e()) {
                        it.remove();
                        Logger.e("ConcurrentHolder", "addCallback:ERROR_REMOVE--" + e._d()._b + " weight:" + num);
                        break;
                    }
                }
            }
            Iterator it2 = this._b.iterator();
            if (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                int i = this._a._e;
                if (i == 0) {
                    Iterator<E> it3 = iterator();
                    if (it3.hasNext()) {
                        E next = it3.next();
                        StringBuilder sb_a = _jf._a("addCallback:TIME_PRIORITY--");
                        sb_a.append(next._d()._b);
                        sb_a.append("--targetWeight:");
                        sb_a.append(num2);
                        sb_a.append("--isLoaded:");
                        sb_a.append(next._g());
                        Logger.e("ConcurrentHolder", sb_a.toString());
                        _a();
                        return z;
                    }
                } else if (i == 1) {
                    StringBuilder sb_a2 = _jf._a("addCallback:WEIGHT_PRIORITY--");
                    sb_a2.append(e._d()._b);
                    sb_a2.append("--targetWeight:");
                    sb_a2.append(num2);
                    sb_a2.append("--runningCounter:");
                    sb_a2.append(e._c());
                    sb_a2.append("--isLoaded:");
                    sb_a2.append(e._g());
                    Logger.e("ConcurrentHolder", sb_a2.toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                } else if (i == 3) {
                    StringBuilder sb_a3 = _jf._a("addCallback:SERIAL_PRIORITY--");
                    sb_a3.append(e._d()._b);
                    sb_a3.append("--targetWeight:");
                    sb_a3.append(num2);
                    sb_a3.append("--runningCounter:");
                    sb_a3.append(e._c());
                    sb_a3.append("--isLoaded:");
                    sb_a3.append(e._g());
                    Logger.e("ConcurrentHolder", sb_a3.toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                } else if (i == 4) {
                    StringBuilder sb_a4 = _jf._a("addCallback: ");
                    sb_a4.append(e.toString());
                    Logger.d("ConcurrentHolder", sb_a4.toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                }
            } else {
                _a();
            }
            return z;
        }
    }

    @Keep
    public static final class _c implements Comparator<_bh> {
        public _ck _a;

        public _c(_ck _ckVar) {
            this._a = _ckVar;
        }

        @Override // java.util.Comparator
        public final int compare(_bh _bhVar, _bh _bhVar2) {
            _bh _bhVar3 = _bhVar;
            _bh _bhVar4 = _bhVar2;
            if (this._a._e != 1) {
                if (!_bhVar3.equals(_bhVar4)) {
                    return 1;
                }
            } else if (!_bhVar3.equals(_bhVar4)) {
                int i_e = _bhVar4._e() - _bhVar3._e();
                if (i_e == 0) {
                    return 1;
                }
                return i_e;
            }
            return 0;
        }
    }

    public _it(_ck _ckVar, Error error) {
        this._d = _ckVar;
        this._e = error;
        this._b = Collections.synchronizedSortedSet(new _is(this, new _c(_ckVar), _ckVar, _ckVar, error));
    }

    public static AdSlot _a(Context context, AdSlot adSlot, _cl _clVar) {
        AdSlot adSlotCreateCustomerAdSlot = adSlot.createCustomerAdSlot(_clVar);
        ViewGroup adContainer = adSlot.getAdContainer();
        if (adContainer != null) {
            ViewGroup.LayoutParams layoutParams = adContainer.getLayoutParams();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(layoutParams));
            adSlotCreateCustomerAdSlot.setAdContainer(frameLayout);
        }
        return adSlotCreateCustomerAdSlot;
    }

    public static boolean _a(_it _itVar, AtomicBoolean atomicBoolean, _ck _ckVar, Set set, Error error) {
        _itVar.getClass();
        if (!atomicBoolean.compareAndSet(false, true)) {
            return false;
        }
        _itVar._a(new AtomicInteger(), _ckVar, set, new ArrayList(), error);
        return true;
    }

    public static boolean _a(AdSlot adSlot, _ck _ckVar, _cl _clVar) {
        if (_ckVar == null || _clVar == null) {
            return true;
        }
        int i = _clVar._e;
        int i2 = _ckVar._e;
        return ((i2 == 2 || i2 == 1) && i == 0) ? false : true;
    }

    public final void _a() {
        this._h.set(true);
    }

    /* JADX WARN: Code duplicated, block: B:203:0x057c  */
    public final boolean _a(AtomicInteger atomicInteger, _ck _ckVar, Collection collection, ArrayList arrayList, Error error) {
        boolean z;
        Object obj;
        StringBuilder sb_a;
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2;
        atomicInteger.incrementAndGet();
        int i = _ckVar._e;
        ArrayList<_bh> arrayList2 = new ArrayList(collection);
        int i2 = _ckVar._b;
        int i3 = _ckVar._a;
        int i4 = 3;
        if (i2 != 0 && i3 > 0) {
            Logger.e("ConcurrentHolder", "doCallback:FILTER_START--ACTION:" + i2);
            arrayList2.clear();
            int i5 = 0;
            for (_bh _bhVar : this._a) {
                if (_bhVar != null) {
                    if (i2 == 2 || i2 == 3) {
                        _bhVar._d();
                    }
                    if (i3 <= 0) {
                        StringBuilder sb_a2 = _jf._a("doCallback:UP_TO_MAX(");
                        sb_a2.append(_bhVar._d()._b);
                        sb_a2.append(")--count:");
                        sb_a2.append(0);
                        Logger.e("ConcurrentHolder", sb_a2.toString());
                        i5++;
                    }
                }
            }
            for (_bh _bhVar2 : new ArrayList(arrayList2)) {
                if (_bhVar2 != null && _bhVar2._d() != null) {
                    if (i2 == 2) {
                        _bhVar2._d();
                        str = "doCallback:FILTER--IMP(";
                        if (arrayList == null || i3 > 0) {
                            arrayList2.add(_bhVar2);
                            sb = new StringBuilder();
                            StringBuilder sb4 = sb;
                            String str3 = str;
                            sb3 = sb4;
                            sb3.append(str3);
                            sb3.append(0);
                            str2 = ")--ADD_FIRST:";
                        } else {
                            arrayList.add(_bhVar2);
                            sb2 = new StringBuilder();
                            StringBuilder sb5 = sb2;
                            String str4 = str;
                            sb3 = sb5;
                            sb3.append(str4);
                            sb3.append(0);
                            str2 = ")--ADD_SECOND:";
                        }
                    } else if (i2 != 3) {
                        sb3 = new StringBuilder();
                        sb3.append("doCallback:FILTER--UNKNOWN--");
                        sb3.append(i2);
                        str2 = "--SKIP:";
                    } else {
                        _bhVar2._d();
                        str = "doCallback:FILTER--CLK(";
                        if (arrayList == null || i3 > 0) {
                            arrayList2.add(_bhVar2);
                            sb = new StringBuilder();
                            StringBuilder sb6 = sb;
                            String str5 = str;
                            sb3 = sb6;
                            sb3.append(str5);
                            sb3.append(0);
                            str2 = ")--ADD_FIRST:";
                        } else {
                            arrayList.add(_bhVar2);
                            sb2 = new StringBuilder();
                            StringBuilder sb7 = sb2;
                            String str6 = str;
                            sb3 = sb7;
                            sb3.append(str6);
                            sb3.append(0);
                            str2 = ")--ADD_SECOND:";
                        }
                    }
                    sb3.append(str2);
                    sb3.append(_bhVar2._d()._b);
                    Logger.e("ConcurrentHolder", sb3.toString());
                }
            }
            if (i5 == this._a.size()) {
                Logger.e("ConcurrentHolder", "doCallback:FILTER--RESET_ALL");
                Iterator it = this._a.iterator();
                while (it.hasNext()) {
                    _nr _nrVar_d = ((_bh) it.next())._d();
                    if (i2 == 2 || i2 == 3) {
                        String str7 = _nrVar_d._a;
                    }
                }
            }
            if (arrayList2.isEmpty() && arrayList != null && !arrayList.isEmpty()) {
                Logger.e("ConcurrentHolder", "doCallback:FILTER--RESET_SECOND_TO_FIRST");
                arrayList2.addAll(arrayList);
                arrayList.clear();
            }
        }
        int i_e = Integer.MAX_VALUE;
        int i_e2 = 0;
        _bh _bhVar3 = null;
        for (_bh _bhVar4 : arrayList2) {
            i_e2 = _bhVar4._e() + i_e2;
            if (i == 0) {
                _bhVar4._a();
                _bhVar4._i();
                Logger.e("ConcurrentHolder", "doCallback:TIME_PRIORITY--" + _bhVar4._d()._b);
                Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bhVar4._d()._b + "):" + _bhVar4._b());
                return true;
            }
            if (i == 1) {
                sb_a = _jf._a("doCallback:COUNT_ALL_WEIGHT(");
                sb_a.append(_bhVar4._d()._b);
                sb_a.append(")--WEIGHT--");
                sb_a.append(_bhVar4._e());
            } else if (i == 3) {
                if (_bhVar4._g() && _bhVar4._e() < i_e) {
                    i_e = _bhVar4._e();
                    _bhVar3 = _bhVar4;
                }
                sb_a = _jf._a("doCallback:");
                sb_a.append(i2 == 0 ? "LEVEL_PRIORITY--" : "SMART_PRIORITY--");
                sb_a.append(_bhVar4._d()._b);
                sb_a.append("（");
                sb_a.append(_bhVar4._e());
                sb_a.append("）");
            } else {
                if (i != 4) {
                    StringBuilder sb_a3 = _jf._a("doCallback:END--UNKNOWN--");
                    sb_a3.append(_bhVar4._d()._b);
                    sb_a3.append("--TYPE:");
                    sb_a3.append(i);
                    Logger.e("ConcurrentHolder", sb_a3.toString());
                    _bhVar4._a(new AdErrorImpl(10000, "priorityPolicy is not supported", (Object) null));
                    return true;
                }
                StringBuilder sb_a4 = _jf._a("doCallback: ");
                sb_a4.append(_bhVar4.toString());
                Logger.d("ConcurrentHolder", sb_a4.toString());
            }
            Logger.e("ConcurrentHolder", sb_a.toString());
        }
        if (i == 1) {
            z = false;
            if (i_e2 > 0) {
                int iNextInt = new Random().nextInt(i_e2);
                StringBuilder sb_a5 = _jf._a("doCallback:SELECTING--COUNT_SIZE: ");
                sb_a5.append(arrayList2.size());
                sb_a5.append("--TOTAL:");
                sb_a5.append(i_e2);
                sb_a5.append("--RAND:");
                sb_a5.append(iNextInt);
                Logger.e("ConcurrentHolder", sb_a5.toString());
                int i_e3 = 0;
                for (_bh _bhVar5 : arrayList2) {
                    i_e3 += _bhVar5._e();
                    StringBuilder sb_a6 = _jf._a("doCallback:SELECTING(");
                    sb_a6.append(_bhVar5._d()._b);
                    sb_a6.append(")--SUM:");
                    sb_a6.append(i_e3);
                    sb_a6.append("--RAND:");
                    sb_a6.append(iNextInt);
                    Logger.e("ConcurrentHolder", sb_a6.toString());
                    if (i_e3 > iNextInt) {
                        com.kc.aw.lib.utils._d._c(new _iv(_bhVar5));
                        _bhVar5._i();
                        Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bhVar5._d()._b + "):" + _bhVar5._b());
                        return true;
                    }
                }
            }
        } else if (i != 3) {
            if (i == 4) {
                Collections.sort(arrayList2, new _iw());
                if (!arrayList2.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList();
                    _cl _clVar = ((_bh) arrayList2.get(0))._c;
                    long j = _clVar != null ? _clVar._h : 0L;
                    for (_bh _bhVar6 : arrayList2) {
                        _cl _clVar2 = _bhVar6._c;
                        if ((_clVar2 != null ? _clVar2._h : 0L) != j) {
                            break;
                        }
                        arrayList3.add(_bhVar6);
                    }
                    _bh _bhVar7 = (_bh) arrayList3.get(new Random().nextInt(arrayList3.size()));
                    StringBuilder sb_a7 = _jf._a("bingo: ");
                    sb_a7.append(_bhVar7.toString());
                    Logger.d("ConcurrentHolder", sb_a7.toString());
                    com.kc.aw.lib.utils._d._c(new _ix(_bhVar7));
                    _bhVar7._i();
                    return true;
                }
            }
            z = false;
        } else {
            z = false;
            if (_bhVar3 != null && _bhVar3._g()) {
                com.kc.aw.lib.utils._d._c(new _iu(_bhVar3));
                _bhVar3._i();
                Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bhVar3._d()._b + "):" + _bhVar3._b());
                return true;
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            return _a(atomicInteger, _ckVar, arrayList, (ArrayList) null, error);
        }
        Logger.e("ConcurrentHolder", "doCallback:END--No ad");
        HashSet hashSet = this._a;
        if (hashSet == null || hashSet.isEmpty()) {
            obj = null;
        } else {
            _bh _bhVar8 = (_bh) this._a.iterator().next();
            HashSet<_bh> hashSet2 = this._a;
            _nr _nrVar = _bhVar8._d;
            AdSlot adSlot = _bhVar8._b;
            if (_nrVar == null || adSlot == null || adSlot.getDispatchPolicyCustomerItem() == null) {
                obj = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (_bh _bhVar9 : hashSet2) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", _bhVar9._d()._f);
                        jSONObject.put("message", _bhVar9._d()._g);
                        jSONObject.put("domain", _bhVar9._b());
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                adSlot.setRandomTime(_nrVar._o);
                adSlot.setRandomToken(_nrVar._q);
                _nr _nrVar2 = new _nr("", _nrVar._b, adSlot);
                _nrVar2._h = _nrVar2._h;
                _nq _nqVar = _nrVar2._t;
                boolean z2 = true;
                boolean z3 = true;
                boolean z4 = true;
                for (_bh _bhVar10 : hashSet2) {
                    int i6 = _bhVar10._d()._f;
                    if (i6 != 20001 && i6 != 5004 && i6 != 40003 && i6 != 3000 && i6 != 100001 && i6 != 20001 && i6 != 10000) {
                        z3 = z;
                    }
                    if (i6 != 10001) {
                        z2 = z;
                    }
                    String str_b = _bhVar10._b();
                    if ((("tt".equals(str_b) || "gdt".equals(str_b) || PtgApiProvider.providerName.equals(str_b) || "qm".equals(str_b) || "ubix_non_agg".equals(str_b)) ? true : z) && i6 != 40025 && i6 != 5011 && i6 != 5022 && i6 != 33017 && i6 != 33018 && i6 != 30004 && i6 != 10000) {
                        z4 = z;
                    }
                }
                if (z2) {
                    i4 = 1;
                } else if (z3) {
                    i4 = 2;
                } else if (z4) {
                    i4 = 4;
                }
                _nqVar._f(i4);
                _nrVar2._t._e(10000);
                _nrVar2._t._g(jSONArray.toString());
                _nrVar2._t._m(adSlot.getPtgSlotID());
                _nrVar2._t._a(adSlot.getCategoryType());
                _nrVar2._t._c(PtgAdSdk.getConfig()._n);
                _nrVar2._t._b(PtgAdSdk.getConfig()._o);
                _nrVar2._t._l(PtgAdSdk.getConfig().getSdkVersionName());
                _nrVar2._t._k(PtgAdSdk.getConfig().getSdkVersionCode());
                _nrVar2._t._i(PtgAdSdk.getConfig()._a);
                _nrVar2._t._j(PtgAdSdk.getConfig()._g);
                _nrVar2._t._c(adSlot.getDispatchPolicyCustomerItem()._T);
                obj = null;
                _nt._a()._a(adSlot.getDispatchPolicyCustomerItem()._f(), "inAppErr", _nrVar2, null);
            }
        }
        error.onError(new AdErrorImpl(10000, "No ad", obj));
        return true;
    }

    public final void _b() {
        this._f.schedule(new _a(this), this._g);
    }
}
