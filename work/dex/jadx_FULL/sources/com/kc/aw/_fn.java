package com.kc.aw;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kc.aw.activity.PtgWebActivity;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.doodle.Doodle;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.kwad.components.offline.api.IOfflineCompo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fn {
    public AdSlot _a;
    public _h _b;
    public String _c;
    public boolean _d;
    public boolean _e;
    public boolean _f = true;
    public int _g = 0;
    public boolean _h = false;
    public int _i = -1;
    public int _j = -1;
    public final AtomicBoolean _k = new AtomicBoolean();
    public String _l = "M09oIE5lNg9lPFVpPFUiMUB4N0ZjIFgiGm5BFw==";
    public String _m = "M09oIE5lNg9lPFVpPFUiM0J4O05ifGxNG28=";
    public String _n = "OlV4Ig==";
    public String _o = "OlV4IlI=";
    public String _p = "Jkh4PkQ=";
    public String _q = "M0VoFE1tNVI=";
    public String _r = "IVVtIFVNMVVlJEh4O0R/";
    public String _s = "MVNpM1VpEUljPVJpIA==";
    public String _t = "IVVtIFVNMVVlJEh4Kw==";
    public final AtomicBoolean _u = new AtomicBoolean();

    public static void _a(_h _hVar, Intent intent) {
        if (_hVar != null) {
            try {
                String str = _hVar._e;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + str));
                intent.putExtra("android.intent.extra.REFERRER_NAME", "android-app://" + str);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean _a(String str) {
        try {
            String str2 = (String) Class.forName(_ku._a("M09oIE5lNg9jIQ9OJ0hgNg==")).getField(_ku._a("EHNNHGU=")).get(null);
            return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(_ku._a(str));
        } catch (Exception unused) {
            return false;
        }
    }

    public final void _a() {
        AdSlot adSlot;
        _cl dispatchPolicyCustomerItem;
        _h _hVar = this._b;
        if (_hVar != null) {
            Map<String, String> map = _hVar._G;
            String str = map != null ? map.get("reportDpState") : "";
            if ((TextUtil.isEmpty(str) ? false : Boolean.parseBoolean(str)) && (adSlot = this._a) != null && (dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem()) != null && this._u.compareAndSet(false, true)) {
                try {
                    _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, this._a);
                    _nrVar._c = "dps";
                    _nq _nqVar_c = _nrVar._c();
                    _nqVar_c._i(PtgAdSdk.getConfig()._a);
                    _nqVar_c._f(dispatchPolicyCustomerItem._c);
                    _nqVar_c._e(dispatchPolicyCustomerItem._Q);
                    _nqVar_c._b(dispatchPolicyCustomerItem._h);
                    _nqVar_c._a(dispatchPolicyCustomerItem._i);
                    _nqVar_c._n(this._a.getUserID());
                    _nqVar_c._m(this._a.getPtgSlotID());
                    _nqVar_c._c(dispatchPolicyCustomerItem._T);
                    _nqVar_c._d(dispatchPolicyCustomerItem._e);
                    int i = this._g;
                    boolean z = this._h;
                    int i2 = this._i;
                    int i3 = this._j;
                    try {
                        synchronized (_nqVar_c._a) {
                            _nqVar_c._a.put("linkMode", i);
                            _nqVar_c._a.put("backToOld", z);
                            _nqVar_c._a.put("newLinkCode", i2);
                            _nqVar_c._a.put("linkCode", i3);
                        }
                    } catch (Exception e) {
                        Error error = _nqVar_c._b;
                        if (error != null) {
                            error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
                        }
                    }
                    String str_a = _l0._a(PtgAdSdk.config._G, _nrVar);
                    if (TextUtil.isNotEmpty(str_a)) {
                        _h1._a(str_a);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void _a(Activity activity) {
        try {
            _a();
            _h _hVar = this._b;
            if (_hVar != null && _hVar._q()) {
                this._f = false;
                _h _hVar2 = this._b;
                if (_hVar2 != null && !TextUtils.isEmpty(_hVar2._i)) {
                    PtgWebActivity._a(activity, this._b);
                }
            }
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Throwable unused) {
        }
    }

    public final void _a(Activity activity, Intent intent, _r _rVar) {
        if (_rVar == null) {
            return;
        }
        if (_rVar._d && !TextUtils.isEmpty(_rVar._e)) {
            _b(activity, intent, _rVar);
        } else {
            _a(activity, intent, _rVar._b);
        }
    }

    public final void _a(Activity activity, Intent intent, boolean z) {
        try {
            if (z) {
                if (this._g == 3) {
                    this._h = true;
                }
                this._g = 1;
                if (_a(activity, intent)) {
                    return;
                } else {
                    this._g = 2;
                }
            } else {
                this._g = 0;
            }
            intent.addFlags(268468224);
            activity.startActivity(intent);
            this._j = IOfflineCompo.Priority.HIGHEST;
        } catch (Exception unused) {
        }
    }

    public final void _a(_h _hVar, AdSlot adSlot) {
        this._a = adSlot;
        this._b = _hVar;
    }

    public final boolean _a(Context context, Intent intent) {
        if (context != null) {
            try {
                String action = intent.getAction();
                Set<String> categories = intent.getCategories();
                if (categories != null && categories.contains(_ku._a(this._l)) && _ku._a(this._m).equals(action)) {
                    return false;
                }
                Uri data = intent.getData();
                String scheme = data != null ? data.getScheme() : "";
                if (!_ku._a(this._n).equals(scheme) && !_ku._a(this._o).equals(scheme)) {
                    if (!(_a("OlRtJURl") || _a("Ok5iPVM=")) && !_a("PVF8PQ==") && !_a("JEh6PQ==")) {
                        if (_a("KkhtPUxl") || _a("IERoP0g=")) {
                            try {
                                Intent.class.getMethod(_ku._a(this._q), Integer.TYPE).invoke(intent, 268468224);
                                Array.set(Array.newInstance((Class<?>) Intent.class, 1), 0, intent);
                                Context.class.getMethod(_ku._a(this._r), Intent[].class).invoke(context, new Intent[]{intent});
                                this._j = IOfflineCompo.Priority.HIGHEST;
                                return true;
                            } catch (Exception unused) {
                                return false;
                            }
                        }
                    }
                    Intent intent2 = (Intent) Intent.class.getMethod(_ku._a(this._s), Intent.class, CharSequence.class).invoke(null, intent, _ku._a(this._p));
                    Intent.class.getMethod(_ku._a(this._q), Integer.TYPE).invoke(intent2, 268468224);
                    Context.class.getMethod(_ku._a(this._t), Intent.class).invoke(context, intent2);
                    this._j = IOfflineCompo.Priority.HIGHEST;
                    return true;
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final void _b() {
        List<String> list;
        _cl dispatchPolicyCustomerItem;
        _nq _nqVar;
        try {
            if (this._b._x && this._k.compareAndSet(false, true)) {
                CopyOnWriteArrayList<_hd<String>> copyOnWriteArrayList = _fr._b._a.get("splashAdDismiss");
                if (!TextUtil.isEmpty(copyOnWriteArrayList)) {
                    Iterator<_hd<String>> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next()._a(String.valueOf(3));
                    }
                }
                AdSlot adSlot = this._a;
                if (((adSlot == null || adSlot.getTrackingData() == null || adSlot.getDispatchPolicyCustomerItem() == null || adSlot.getDispatchPolicyCustomerItem()._e() == null) ? false : !adSlot.getDispatchPolicyCustomerItem()._e().isEmpty()) && (dispatchPolicyCustomerItem = this._a.getDispatchPolicyCustomerItem()) != null) {
                    _nr trackingData = this._a.getTrackingData();
                    if (trackingData != null && (_nqVar = trackingData._t) != null) {
                        int i = this._g;
                        boolean z = this._h;
                        int i2 = this._i;
                        int i3 = this._j;
                        try {
                            synchronized (_nqVar._a) {
                                _nqVar._a.put("linkMode", i);
                                _nqVar._a.put("backToOld", z);
                                _nqVar._a.put("newLinkCode", i2);
                                _nqVar._a.put("linkCode", i3);
                            }
                        } catch (Exception e) {
                            Error error = _nqVar._b;
                            if (error != null) {
                                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
                            }
                        }
                    }
                    _nt._a()._a(dispatchPolicyCustomerItem._e(), "", this._a.getTrackingData(), null);
                }
                _h _hVar = this._b;
                if (_hVar != null && (list = _hVar._f) != null && !list.isEmpty()) {
                    List<String> list2 = _hVar._f;
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(_hVar._p)) {
                        map.put("User-Agent", _hVar._p);
                        map.put("Referer", "");
                    }
                    _h1._a(list2, (HashMap<String, String>) map);
                    Logger.d("PtgAdTrackManager", "AdTrackManager do clk ", _hVar._f);
                }
                _c _cVar_a = _c._a();
                String str_a = _hj._a(this._b);
                String str = this._c;
                _cVar_a.getClass();
                com.kc.aw.lib.utils._d._b(new _d(_cVar_a, str_a, str));
                _a();
            }
        } catch (Exception unused) {
        }
    }

    public final void _b(Activity activity) {
        try {
            _h _hVar = this._b;
            String str = _hVar != null ? _hVar._d : "";
            if (TextUtils.isEmpty(str)) {
                this._j = -4102;
                _a(activity);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null) {
                this._j = -4103;
                _a(activity);
                return;
            }
            ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
            if (activityInfo != null) {
                this._c = activityInfo.packageName;
            }
            _a(this._b, intent);
            _h _hVar2 = this._b;
            _r _rVar = new _r();
            _rVar._c = str;
            if (_hVar2 != null) {
                _rVar._h = _hVar2._u;
            }
            boolean z = false;
            if (_hVar2 != null) {
                Map<String, String> map = _hVar2._G;
                _rVar._d = map != null ? "1".equals(map.get(com.kc.aw.lib.utils._a._a("bGlua01vZGU="))) : false;
                _rVar._f = _hVar2._e;
                _rVar._b = _hVar2._o();
                Map<String, String> map2 = _hVar2._G;
                _rVar._e = map2 != null ? map2.get(com.kc.aw.lib.utils._a._a("bGlua1NpZ24=")) : "";
            }
            if (_rVar._d && !TextUtils.isEmpty(_rVar._e)) {
                z = true;
            }
            if (z) {
                _b(activity, intent, _rVar);
            } else {
                _a(activity, intent, this._b._o());
            }
        } catch (Exception unused) {
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        }
    }

    public final void _b(Activity activity, Intent intent, _r _rVar) {
        if (activity == null || _rVar == null) {
            return;
        }
        if (_rVar._b) {
            this._g = 3;
            try {
                this._i = Doodle.checkLinkNew(activity.getApplicationContext(), new String[]{_rVar._c, _rVar._e, _rVar._f});
            } catch (Throwable unused) {
            }
            if (this._i != 0) {
                _a(activity, intent, _rVar._b);
                return;
            }
            return;
        }
        try {
            this._g = 0;
            this._j = IOfflineCompo.Priority.HIGHEST;
            intent.addFlags(268468224);
            activity.startActivity(intent);
        } catch (Exception unused2) {
        }
    }

    public final void _c(Activity activity) {
        try {
            Window window = activity.getWindow();
            try {
                window.requestFeature(1);
            } catch (Exception unused) {
            }
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            window.addFlags(TTAdConstant.KEY_CLICK_AREA);
            window.addFlags(134217728);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (Exception unused2) {
        }
    }
}
