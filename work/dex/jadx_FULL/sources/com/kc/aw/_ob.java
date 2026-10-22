package com.kc.aw;

import android.util.Pair;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ob {
    public int _a;
    public long _b;
    public long _c;
    public int _d = 0;
    public boolean _e;

    public _ob(String str, Map map) {
        this._a = 1;
        this._b = 0L;
        this._e = false;
        try {
            Pair pair_a = _a(map);
            this._e = ((Boolean) pair_a.first).booleanValue();
            if (((Integer) pair_a.second).intValue() > 0) {
                _a(((Integer) pair_a.second).intValue(), str);
            }
            if (!this._e) {
                this._a = 1;
                this._b = 0L;
                return;
            }
            this._c = System.currentTimeMillis();
            Object obj = map.get("maxTri");
            if (obj instanceof String) {
                this._a = Integer.parseInt(obj.toString());
            }
            Object obj2 = map.get("minSt");
            if (obj2 instanceof String) {
                this._b = Long.parseLong(obj2.toString());
            }
            int i = this._a;
            if (i > 1) {
                this._a = com.kc.aw.lib.utils._a._a.nextInt(i) + 1;
            } else {
                this._a = 1;
            }
        } catch (Exception unused) {
        }
    }

    public static Pair _a(Map map) {
        if (map == null) {
            return new Pair(Boolean.FALSE, -1);
        }
        try {
            Object obj = map.get("doWb");
            if (obj == null) {
                return new Pair(Boolean.FALSE, -3);
            }
            if (!Boolean.parseBoolean(obj.toString())) {
                return new Pair(Boolean.FALSE, -4);
            }
            Object obj2 = map.get("limit");
            Object obj3 = map.get("interval");
            boolean z = true;
            if (obj2 == null || obj3 == null) {
                return new Pair(Boolean.FALSE, 1);
            }
            int i = Integer.parseInt(obj2.toString());
            long j = Integer.parseInt(obj3.toString());
            long j_a = _jw._a("sdk_local_web_limit", "limit");
            long j_a2 = _jw._a("sdk_local_web_last_time", "lastTime");
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = j_a < ((long) i);
            if (jCurrentTimeMillis - j_a2 <= j * 1000) {
                z = false;
            }
            return (z2 && z) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, 2);
        } catch (Exception unused) {
            return new Pair(Boolean.FALSE, -2);
        }
    }

    public static void _a(int i, String str) {
        try {
            _nr _nrVar = new _nr(_m4._a);
            _nrVar._h = str;
            _nrVar._c = "iwc";
            _nq _nqVar_c = _nrVar._c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", i);
                _nqVar_c._a.put("iwc", jSONObject);
            } catch (Exception unused) {
            }
            _nqVar_c._i(PtgAdSdk.config._a);
            String str_a = _l0._a(PtgAdSdk.config._G, _nrVar);
            if (TextUtil.isNotEmpty(str_a)) {
                _h1._a(str_a);
            }
        } catch (Exception unused2) {
        }
    }

    public final boolean _a() {
        synchronized (this) {
            boolean z = true;
            if (!this._e) {
                return true;
            }
            synchronized (this) {
                if (System.currentTimeMillis() - this._c <= this._b) {
                    int i = this._d + 1;
                    this._d = i;
                    if (i <= this._a) {
                        z = false;
                    }
                } else if (this._d == 0) {
                    this._e = false;
                }
                if (z) {
                    _jw._a(_jw._a("sdk_local_web_limit", "limit") + 1, "sdk_local_web_limit", "limit");
                    _jw._a(System.currentTimeMillis(), "sdk_local_web_last_time", "lastTime");
                }
            }
            return z;
        }
    }
}
