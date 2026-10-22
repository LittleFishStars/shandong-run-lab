package com.kc.aw;

import android.content.Context;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _j3 {
    public final ArrayList _a = new ArrayList();
    public int _b;
    public int _c;

    public _j3(int i, int i2) {
        this._b = i;
        if (i == 0) {
            this._b = 1;
        }
        this._c = i2;
    }

    public static AdSlot _a(Context context, AdSlot adSlot, _cl _clVar) {
        AdSlot adSlotCreateCustomerAdSlot = adSlot.createCustomerAdSlot(_clVar);
        ViewGroup adContainer = adSlotCreateCustomerAdSlot.getAdContainer();
        if (adContainer != null) {
            ViewGroup.LayoutParams layoutParams = adContainer.getLayoutParams();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(layoutParams));
            adSlotCreateCustomerAdSlot.setAdContainer(frameLayout);
        }
        return adSlotCreateCustomerAdSlot;
    }

    public static void _a(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Random random = new Random();
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    synchronized (arrayList) {
                        Collections.sort(arrayList, new _j1());
                    }
                    return;
                } else {
                    if (i != 4) {
                        return;
                    }
                    synchronized (arrayList) {
                        Collections.sort(arrayList, new _j2());
                    }
                    return;
                }
            }
            synchronized (arrayList) {
                arrayList2.addAll(arrayList);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList3.add((_m8) arrayList2.remove(random.nextInt(arrayList2.size())));
            }
            synchronized (arrayList) {
                arrayList.clear();
                arrayList.addAll(arrayList3);
            }
            return;
        }
        synchronized (arrayList) {
            Collections.sort(arrayList, new _j0());
        }
        synchronized (arrayList) {
            arrayList2.addAll(arrayList);
        }
        Iterator it = arrayList2.iterator();
        int i_f = 0;
        while (it.hasNext()) {
            i_f += ((_m8) it.next())._f();
        }
        int i_f2 = i_f > 0 ? i_f : 1;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iNextInt = random.nextInt(i_f2);
            Iterator it2 = arrayList2.iterator();
            int i_f3 = 0;
            while (it2.hasNext()) {
                _m8 _m8Var = (_m8) it2.next();
                i_f3 += _m8Var._f();
                if (iNextInt <= i_f3) {
                    i_f2 -= _m8Var._f();
                    arrayList3.add(_m8Var);
                    it2.remove();
                    break;
                }
            }
        }
        synchronized (arrayList) {
            arrayList.clear();
            arrayList.addAll(arrayList3);
        }
    }

    public static boolean _a(AdSlot adSlot, _ck _ckVar, _cl _clVar) {
        if (_ckVar == null || _clVar == null) {
            return true;
        }
        int i = _clVar._e;
        int i2 = _ckVar._e;
        return ((i2 == 2 || i2 == 1) && i == 0) ? false : true;
    }

    public final void _a(_m8 _m8Var) {
        synchronized (this._a) {
            this._a.add(_m8Var);
            Logger.d("PtgDispatchProviderSerialHolder", "add serial request : " + _m8Var._c());
        }
    }

    public final void _a(_m8 _m8Var, AdError adError) {
        StringBuilder sb_a = _jf._a("doOnError : ");
        sb_a.append(_m8Var._c());
        sb_a.append(" code: ");
        sb_a.append(adError.getErrorCode());
        sb_a.append(" msg: ");
        sb_a.append(adError.getMessage());
        Logger.e("PtgDispatchProviderSerialHolder", sb_a.toString());
        if (_c() == null) {
            _m8Var._a(new AdErrorImpl(10000, adError.getMessage(), (Object) null));
        }
    }

    public final boolean _a() {
        boolean zIsEmpty;
        synchronized (this._a) {
            zIsEmpty = this._a.isEmpty();
        }
        return !zIsEmpty;
    }

    public final void _b() {
        int i = this._c;
        boolean z = false;
        if (i != 0) {
            int i2 = this._b;
            ArrayList<_m8> arrayList = this._a;
            synchronized (arrayList) {
                ArrayList<Pair> arrayList2 = new ArrayList();
                if (i == 2) {
                    for (_m8 _m8Var : arrayList) {
                        _m8Var._e();
                        arrayList2.add(new Pair(0, _m8Var));
                    }
                } else if (i == 3) {
                    for (_m8 _m8Var2 : arrayList) {
                        _m8Var2._e();
                        arrayList2.add(new Pair(0, _m8Var2));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Collections.sort(arrayList2, new _iz());
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    int iIntValue = -1;
                    for (Pair pair : arrayList2) {
                        if (iIntValue >= 0) {
                            if (iIntValue != ((Integer) pair.first).intValue()) {
                                _a(i2, arrayList3);
                                arrayList4.addAll(arrayList3);
                                arrayList3.clear();
                            }
                            arrayList3.add((_m8) pair.second);
                        }
                        iIntValue = ((Integer) pair.first).intValue();
                        arrayList3.add((_m8) pair.second);
                    }
                    if (!arrayList3.isEmpty()) {
                        _a(i2, arrayList3);
                        arrayList4.addAll(arrayList3);
                        arrayList3.clear();
                    }
                    arrayList.clear();
                    arrayList.addAll(arrayList4);
                    z = true;
                }
            }
        }
        if (!z) {
            _a(this._b, this._a);
        }
        _c();
    }

    public final void _b(_m8 _m8Var) {
        StringBuilder sb_a = _jf._a("doOnLoad : ");
        sb_a.append(_m8Var._c());
        Logger.d("PtgDispatchProviderSerialHolder", sb_a.toString());
        if (_m8Var._g()) {
            _m8Var._a();
        } else {
            _a(_m8Var, new AdErrorImpl(10000, "request no ad", (Object) null));
        }
    }

    public final _m8 _c() {
        _m8 _m8Var = null;
        if (_a()) {
            synchronized (this._a) {
                _m8Var = this._a.size() > 0 ? (_m8) this._a.remove(0) : null;
            }
            if (_m8Var != null) {
                _m8Var._b();
                Logger.d("PtgDispatchProviderSerialHolder", "doRequest : " + _m8Var._c());
            }
        }
        return _m8Var;
    }
}
