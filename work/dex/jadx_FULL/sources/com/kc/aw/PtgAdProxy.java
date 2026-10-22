package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgAdProxy {
    private static _bu core;

    public static void getBannerAd(Context context, AdSlot adSlot, _b3<_q> _b3Var) {
        if (core != null) {
            adSlot.setStype(5);
            _h4 _h4Var = new _h4();
            ArrayList arrayList = new ArrayList();
            _ah _ahVar = new _ah();
            _ahVar._a();
            arrayList.add(_h4Var);
            _0 _0 = new _0(_ahVar, arrayList.size(), _b3Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_x) it.next())._a(adSlot, _0);
            }
        }
    }

    public static void getFeedAd(Context context, AdSlot adSlot, _b3<_q> _b3Var) {
        if (core != null) {
            adSlot.setStype(adSlot.getUsedFor() == 1 ? 6 : 8);
            _h4 _h4Var = new _h4();
            ArrayList arrayList = new ArrayList();
            _ah _ahVar = new _ah();
            _ahVar._a();
            arrayList.add(_h4Var);
            _0 _0 = new _0(_ahVar, arrayList.size(), _b3Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_x) it.next())._a(adSlot, _0);
            }
        }
    }

    public static void getInteractionAd(Context context, AdSlot adSlot, _b3<_q> _b3Var) {
        if (core != null) {
            adSlot.setStype(7);
            _h4 _h4Var = new _h4();
            ArrayList arrayList = new ArrayList();
            _ah _ahVar = new _ah();
            _ahVar._a();
            arrayList.add(_h4Var);
            _0 _0 = new _0(_ahVar, arrayList.size(), _b3Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_x) it.next())._a(adSlot, _0);
            }
        }
    }

    public static void getRewardVideoAd(Context context, AdSlot adSlot, _b3<_q> _b3Var) {
        if (core != null) {
            adSlot.setStype(100);
            _h4 _h4Var = new _h4();
            ArrayList arrayList = new ArrayList();
            _ah _ahVar = new _ah();
            _ahVar._a();
            arrayList.add(_h4Var);
            _0 _0 = new _0(_ahVar, arrayList.size(), _b3Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_x) it.next())._a(adSlot, _0);
            }
        }
    }

    public static void getSplashAd(Context context, AdSlot adSlot, _b3<_q> _b3Var) {
        if (core != null) {
            adSlot.setStype(6);
            _h4 _h4Var = new _h4();
            ArrayList arrayList = new ArrayList();
            _ah _ahVar = new _ah();
            _ahVar._a();
            arrayList.add(_h4Var);
            _0 _0 = new _0(_ahVar, arrayList.size(), _b3Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_x) it.next())._a(adSlot, _0);
            }
        }
    }

    public static void initialize(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        core = new _f5();
    }

    public static void onAdClicked(_h _hVar, AdSlot adSlot) {
        if (core == null || _hVar == null) {
            return;
        }
        _nt _ntVar_a = _nt._a();
        _l0 _l0Var = _ntVar_a._b;
        if (_l0Var == null) {
            _l0Var = new _l0();
            _ntVar_a._b = _l0Var;
        }
        _l0Var._a(_hVar, adSlot);
    }
}
