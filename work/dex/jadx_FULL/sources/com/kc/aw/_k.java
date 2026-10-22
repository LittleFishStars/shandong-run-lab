package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k implements Serializable {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;
    public int _e;
    public int _f;
    public List<Integer> _g;
    public int _h;
    public boolean _i;
    public int _j;
    public long _k;
    public int _l;
    public boolean _m;
    public boolean _n;
    public boolean _o;
    public List<String> _p;
    public float _q;
    public float _r;
    public float _s;
    public float _t;
    public boolean _u;
    public boolean _v;
    public Map<String, Object> _w;
    public String _x = "0";
    public String _y = "0";
    public String _z = "0";
    public String _A = "0";
    public String _B = "0";

    public static HashMap _a(_k _kVar) {
        String str;
        HashMap map = new HashMap();
        if (_kVar != null) {
            map.put("__MP_ENH__", _kVar._x);
            map.put("__MP_ENH_REA__", _kVar._y);
            map.put("__MP_ENH_C__", _kVar._z);
            map.put("__MP_ENH_C_REA__", _kVar._A);
            str = _kVar._B;
        } else {
            map.put("__MP_ENH__", "0");
            map.put("__MP_ENH_REA__", "0");
            map.put("__MP_ENH_C__", "0");
            map.put("__MP_ENH_C_REA__", "0");
            str = "";
        }
        map.put("__MP_ENH_EXP_CT__", str);
        return map;
    }

    public final long _a() {
        long j = this._k;
        if (j <= 0 || j > 5000) {
            return 300L;
        }
        return j;
    }

    public final String _a(boolean z) {
        List<Integer> list;
        List<Integer> list2;
        List<Integer> list3;
        List<Integer> list4;
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z2 = false;
            jSONArray.put(0);
            int i = this._a;
            if (i == 1 || i == 2) {
                jSONArray.put(1);
            }
            if (z) {
                if (_c() && (list4 = this._g) != null && list4.contains(4)) {
                    jSONArray.put(2);
                }
                if (_c() && (list3 = this._g) != null && list3.contains(3)) {
                    jSONArray.put(3);
                }
                if (_c() && (list2 = this._g) != null && list2.contains(2)) {
                    jSONArray.put(4);
                }
                if (_c() && (list = this._g) != null && list.contains(1)) {
                    z2 = true;
                }
                if (z2) {
                    jSONArray.put(5);
                }
                if (_b()) {
                    if (1 == this._j) {
                        jSONArray.put(7);
                    } else {
                        jSONArray.put(6);
                    }
                }
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean _b() {
        return _c() && this._i && _jw._a("sdk_local_enhance_f_click_limit", "fClickLimit") < ((long) this._l);
    }

    public final boolean _b(boolean z) {
        List<Integer> list;
        return z && (list = this._g) != null && list.contains(1);
    }

    public final boolean _c() {
        return this._d && com.kc.aw.lib.utils._a._a(this._p) && _jw._a("sdk_local_enhance_limit", "enhanceLimit") < ((long) this._e) && System.currentTimeMillis() - _jw._a("sdk_local_enhance_last_time", "enhanceLastTime") > ((long) this._f) * 1000;
    }

    public final boolean _c(boolean z) {
        return z && this._i && _jw._a("sdk_local_enhance_f_click_limit", "fClickLimit") < ((long) this._l);
    }

    public final boolean _d(boolean z) {
        List<Integer> list;
        return z && (list = this._g) != null && list.contains(2);
    }
}
