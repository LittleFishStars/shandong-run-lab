package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.xh9;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c {
    public static volatile _c _a;

    @Keep
    public final class _a implements Runnable {
        public final String _a;
        public final long _b;
        public final _c _c;

        public _a(_c _cVar, String str, long j) {
            this._c = _cVar;
            this._a = str;
            this._b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = _i2._f._a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strReplace = str.replace("__ACTION__", "closeAd");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reqId", this._a);
                jSONObject.putOpt("time", Long.valueOf(this._b));
            } catch (Exception unused) {
            }
            String str_a = _hj._a(strReplace.replace("__DATA__", com.kc.aw.lib.utils._a._b(jSONObject.toString())), _c._a(this._c));
            _nt _ntVar_a = _nt._a();
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._a(str_a);
        }
    }

    @Keep
    public final class _b extends _nh {
        public final _c _a;

        public _b(_c _cVar) {
            this._a = _cVar;
        }
    }

    public static _c _a() {
        if (_a == null) {
            synchronized (_c.class) {
                try {
                    if (_a == null) {
                        _a = new _c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return _a;
    }

    public static HashMap _a(_c _cVar) {
        _cVar.getClass();
        HashMap map = new HashMap();
        try {
            if (TextUtils.isEmpty(_a5._d)) {
                try {
                    Context context = PtgAdSdk.getContext();
                    if (context != null) {
                        _a5._d = context.getPackageName();
                    }
                } catch (Exception unused) {
                }
            }
            map.put("appPkgName", _a5._d);
            if (TextUtils.isEmpty(_a5._b)) {
                try {
                    Context context2 = PtgAdSdk.getContext();
                    if (context2 != null) {
                        _a5._b = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                    }
                } catch (Exception unused2) {
                }
            }
            map.put("appVersionName", _a5._b);
            map.put("mpSdkVersionName", PtgAdSdk.getConfig().getSdkVersionName());
            map.put("env", String.valueOf(com.kc.aw.lib.utils._a._a()));
            PtgAdSdk.getConfig().getClass();
            map.put("support", String.valueOf(1));
            PtgAdSdk.getConfig().getClass();
            map.put(xh9.WEBSITE_PARAMS_CHANNEL, "ss");
            _c9 _c9Var_b = _cc._b();
            if (_c9Var_b != null) {
                map.put("brand", _c9Var_b._f);
                map.put(DeviceIdType.ANDROID_ID, _c9Var_b._d);
                map.put(DeviceIdType.OAID, _c9Var_b._a);
                map.put(DeviceIdType.GAID, _c9Var_b._b);
            }
        } catch (Exception unused3) {
        }
        return map;
    }

    public final void _a(String str, long j) {
        com.kc.aw.lib.utils._d._b(new _a(this, str, j));
    }

    public final void _b() {
        _g _gVar;
        if (TextUtils.isEmpty(_i2._f._a)) {
            return;
        }
        _ni _niVar = _ni._a._a;
        _b _bVar = new _b(this);
        synchronized (_niVar) {
            if (_niVar._a == null) {
                _niVar._a = Collections.synchronizedMap(new HashMap());
            }
            if (TextUtils.isEmpty("sync_status")) {
                if (!TextUtils.isEmpty("sync_status")) {
                    _niVar._a.put("sync_status", Long.valueOf(System.currentTimeMillis()));
                }
                _gVar = new _g(_bVar);
            } else {
                Long l = _niVar._a.get("sync_status");
                long jLongValue = l == null ? 0L : l.longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > ((long) 1800000)) {
                    _niVar._a.put("sync_status", Long.valueOf(jCurrentTimeMillis));
                    _gVar = new _g(_bVar);
                }
            }
            com.kc.aw.lib.utils._d._b(_gVar);
        }
    }
}
