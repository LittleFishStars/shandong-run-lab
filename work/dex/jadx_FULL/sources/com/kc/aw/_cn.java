package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.permission.b;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.Constant;
import com.kc.aw.lib.utils.Logger;
import com.kuaishou.weapon.p0.t;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cn {
    public Set<String> _A;
    public Set<String> _B;
    public Set<String> _C;
    public Set<String> _D;
    public Set<String> _E;
    public Set<String> _F;
    public Set<String> _G;
    public Set<String> _H;
    public Set<String> _I;
    public String _J;
    public int _K;
    public int _L;
    public int _M;
    public int _N;
    public int _O;
    public int _P;
    public List<String> _Q;
    public String _a;
    public String _b;
    public String _c;
    public String _d;
    public String _e;
    public String _f;
    public String _g;
    public long _h;
    public int _i;
    public int _j;
    public long _k;
    public int _l;
    public String _o;
    public long _p;
    public HashMap _q;
    public HashMap _r;
    public String _s;
    public String _t;
    public List<String> _u;
    public String _v;
    public int _x;
    public Set<String> _y;
    public Set<String> _z;
    public HashMap _m = new HashMap();
    public HashMap _n = new HashMap();
    public List<String> _w = new ArrayList();

    public static HashSet _a(String str) {
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            hashSet.add(str);
        }
        return hashSet;
    }

    public final void _a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("baseTracking");
        this._J = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            try {
                this._J = URLDecoder.decode("http%3A%2F%2Ft2.fancyapi.com%2F__ACTION__%3Fct%3D__CLIENTTYPE__%26dt%3D__DATA__%26mo%3D__OS__%26m11%3D__OAID__%26m1a%3D__ANDROIDID__%26m2%3D__IMEI__%26m5%3D__IDFA__%26m70%3D__CAID__%26pr%3D__PRICE__%26tr%3D__REQUESTID__%26ver%3D0%26o%3D+", "UTF-8");
            } catch (Exception unused) {
            }
        }
        String str_b = _b("initTracking");
        if (!TextUtils.isEmpty(str_b)) {
            this._e = str_b;
        }
        String str_b2 = _b("bidSelectedTracking");
        if (!TextUtils.isEmpty(str_b2)) {
            this._D = _a(str_b2);
        }
        String str_b3 = _b("bidSucTracking");
        if (!TextUtils.isEmpty(str_b3)) {
            this._C = _a(str_b3);
        }
        String str_b4 = _b("bidTracking");
        if (!TextUtils.isEmpty(str_b4)) {
            this._y = _a(str_b4);
        }
        String str_b5 = _b("clickTracking");
        if (!TextUtils.isEmpty(str_b5)) {
            this._A = _a(str_b5);
        }
        String str_b6 = _b("dpTracking");
        if (!TextUtils.isEmpty(str_b6)) {
            this._E = _a(str_b6);
        }
        String str_b7 = _b("errorTracking");
        if (!TextUtils.isEmpty(str_b7)) {
            this._B = _a(str_b7);
        }
        String str_b8 = _b("impTracking");
        if (!TextUtils.isEmpty(str_b8)) {
            this._z = _a(str_b8);
        }
        String str_b9 = _b("vpTracking");
        if (!TextUtils.isEmpty(str_b9)) {
            this._F = _a(str_b9);
        }
        String str_b10 = _b("filterTracking");
        if (!TextUtils.isEmpty(str_b10)) {
            this._G = _a(str_b10);
        }
        String str_b11 = _b("noticeBidLossTracking");
        if (!TextUtils.isEmpty(str_b11)) {
            this._H = _a(str_b11);
        }
        String str_b12 = _b("noticeBidWinTracking");
        if (TextUtils.isEmpty(str_b12)) {
            return;
        }
        this._I = _a(str_b12);
    }

    public final boolean _a() {
        if (!Constant.CP) {
            return true;
        }
        try {
            return PtgAdSdk.getContext().getPackageName().equals(this._b);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    public final String _b(String str) {
        String str2;
        if (TextUtils.isEmpty(this._J)) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            switch (str) {
                case "dpTracking":
                    str2 = t.q;
                    break;
                case "vpTracking":
                    str2 = "vp";
                    break;
                case "initTracking":
                    str2 = "in";
                    break;
                case "bidSucTracking":
                    str2 = "s";
                    break;
                case "bidSelectedTracking":
                    str2 = "bs";
                    break;
                case "errorTracking":
                    str2 = "e";
                    break;
                case "filterTracking":
                    str2 = "filter";
                    break;
                case "impTracking":
                    str2 = "i";
                    break;
                case "clickTracking":
                    str2 = "c";
                    break;
                case "noticeBidLossTracking":
                    str2 = "noticeBidLoss";
                    break;
                case "bidTracking":
                    str2 = "b";
                    break;
                case "noticeBidWinTracking":
                    str2 = "noticeBidWin";
                    break;
                default:
                    str2 = null;
                    break;
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return this._J.replace("__ACTION__", str2);
    }

    public final boolean _b(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        int length;
        JSONArray jSONArrayNames2;
        int length2;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject == null) {
            return true;
        }
        this._b = jSONObject.optString(ALPParamConstant.PACKAGENAME);
        this._c = jSONObject.optString("vendorId");
        this._d = jSONObjectOptJSONObject.optString("ptgApiUrl");
        this._v = jSONObjectOptJSONObject.optString("wechatAppId");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("qaList");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            try {
                int length3 = jSONArrayOptJSONArray.length();
                if (length3 > 0) {
                    for (int i = 0; i < length3; i++) {
                        if (i < 10) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        this._w = arrayList;
        this._f = jSONObjectOptJSONObject.optString("policyVersion");
        this._k = jSONObjectOptJSONObject.optLong("fetchInterval");
        this._o = jSONObjectOptJSONObject.optString("rtbLogUrl");
        this._p = jSONObjectOptJSONObject.optLong("rtbLogInterval");
        this._g = jSONObjectOptJSONObject.optString("detectRule");
        this._h = jSONObjectOptJSONObject.optLong("detectRuleInterval");
        this._i = jSONObjectOptJSONObject.optInt("fdRule", 0);
        this._j = jSONObjectOptJSONObject.optInt("qaNRTime", 0);
        this._l = jSONObjectOptJSONObject.optInt("imageUpgrade", 0);
        this._x = jSONObjectOptJSONObject.optInt("lessThanVc", 24);
        this._t = jSONObjectOptJSONObject.optString(RVParams.LONG_REPORTURL);
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("hostWhiteList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            try {
                int length4 = jSONArrayOptJSONArray2.length();
                if (length4 > 0) {
                    for (int i2 = 0; i2 < length4; i2++) {
                        arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                    }
                }
            } catch (Exception unused2) {
            }
        }
        this._u = arrayList2;
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("lisAct");
        if (jSONObjectOptJSONObject2 != null) {
            this._L = jSONObjectOptJSONObject2.optInt("blin", 0);
            this._K = jSONObjectOptJSONObject2.optInt("lin", 0);
            this._O = jSONObjectOptJSONObject2.optInt("slin", 0);
            this._M = jSONObjectOptJSONObject2.optInt("linc", 0);
            this._N = jSONObjectOptJSONObject2.optInt("lind", 0);
            this._P = jSONObjectOptJSONObject2.optInt("delayLin", 60);
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("wlist");
            if (jSONArrayOptJSONArray3 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    arrayList3.add(jSONArrayOptJSONArray3.optString(i3));
                }
                this._Q = arrayList3;
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(b.c);
            if (jSONArrayOptJSONArray4 != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray4.getJSONObject(i4);
                    if (jSONObject2 != null) {
                        _av _avVar_a = new _av()._a(jSONObject2);
                        if (_avVar_a._a()) {
                            if (this._m == null) {
                                this._m = new LinkedHashMap();
                            }
                            this._m.put(_avVar_a._b, _avVar_a);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("parse white list error," + e.getMessage());
        }
        try {
            JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("blockPacket");
            if (jSONArrayOptJSONArray5 != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray5.getJSONObject(i5);
                    if (jSONObject3 != null) {
                        _av _avVar_a2 = new _av()._a(jSONObject3);
                        if (_avVar_a2._a()) {
                            if (this._n == null) {
                                this._n = new LinkedHashMap();
                            }
                            this._n.put(_avVar_a2._b, _avVar_a2);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("parse block packets app list error," + e2.getMessage());
        }
        _a(jSONObjectOptJSONObject);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("appId");
            if (jSONObjectOptJSONObject3 != null && (jSONArrayNames2 = jSONObjectOptJSONObject3.names()) != null && (length2 = jSONArrayNames2.length()) > 0) {
                this._q = new HashMap();
                for (int i6 = 0; i6 < length2; i6++) {
                    String strOptString = jSONArrayNames2.optString(i6);
                    this._q.put(strOptString, jSONObjectOptJSONObject3.optString(strOptString));
                }
            }
        } catch (Exception unused3) {
        }
        try {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("appKey");
            if (jSONObjectOptJSONObject4 != null && (jSONArrayNames = jSONObjectOptJSONObject4.names()) != null && (length = jSONArrayNames.length()) > 0) {
                this._r = new HashMap();
                for (int i7 = 0; i7 < length; i7++) {
                    String strOptString2 = jSONArrayNames.optString(i7);
                    this._r.put(strOptString2, jSONObjectOptJSONObject4.optString(strOptString2));
                }
            }
        } catch (Exception unused4) {
        }
        try {
            this._s = jSONObjectOptJSONObject.optString("pUrl", "");
        } catch (Exception unused5) {
        }
        return true;
    }

    public final boolean _c(String str) {
        try {
            boolean z_b = _b(new JSONObject(str));
            if (z_b) {
                this._a = str;
            }
            return z_b;
        } catch (JSONException e) {
            Logger.d(e.getMessage());
            return false;
        }
    }
}
