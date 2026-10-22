package com.kc.aw;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.baidu.mapapi.UIMsg;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.model.AppInfo;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _z {

    @Keep
    public static final class _a {
        public final boolean _a;
        public final _q _b;
        public final AdError _c;

        public _a(boolean z, _q _qVar, AdErrorImpl adErrorImpl) {
            this._a = z;
            this._b = _qVar;
            this._c = adErrorImpl;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0064  */
    public static _i6 _a(JSONObject jSONObject) {
        ArrayList arrayList;
        int length;
        _k8 _k8Var = null;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(_y._c("1"));
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString(_y._d("1"));
                if (!TextUtils.isEmpty(strOptString)) {
                    _j9 _j9Var = new _j9();
                    _j9Var._a = strOptString;
                    _j9Var._b = jSONObjectOptJSONObject.optInt(_y._d("2"));
                    _j9Var._c = jSONObjectOptJSONObject.optInt(_y._d("3"));
                    jSONObjectOptJSONObject.optString(_y._d("5"));
                    arrayList.add(_j9Var);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(_y._c("2"));
        if (jSONObjectOptJSONObject2 != null) {
            String strOptString2 = jSONObjectOptJSONObject2.optString(_y._d("1"));
            if (!TextUtils.isEmpty(strOptString2)) {
                _k8Var = new _k8();
                _k8Var._a = strOptString2;
                _k8Var._c = jSONObjectOptJSONObject2.optInt(_y._d("2"));
                _k8Var._d = jSONObjectOptJSONObject2.optInt(_y._d("3"));
                _k8Var._e = jSONObjectOptJSONObject2.optInt(_y._d("4"));
                jSONObjectOptJSONObject2.optString(_y._d("5"));
                _k8Var._b = jSONObjectOptJSONObject2.optString(_y._d("6"));
            }
        }
        _i6 _i6Var = new _i6();
        _i6Var._a = jSONObject.optString(_y._c("3"));
        _i6Var._b = jSONObject.optString(_y._c("4"));
        _i6Var._c = jSONObject.optString(_y._c("5"));
        _i6Var._d = jSONObject.optString(_y._c("6"));
        _i6Var._g = jSONObject.optString(_y._c("7"));
        _i6Var._h = jSONObject.optString(_y._c(PrepareException.ERROR_AUTH_FAIL));
        _i6Var._i = jSONObject.optString(_y._c("9"));
        _i6Var._e = arrayList;
        _i6Var._f = _k8Var;
        return _i6Var;
    }

    public static _k _a(String str) {
        ArrayList arrayList;
        try {
            str = com.kc.aw.lib.utils._a._a(Base64.decode(str, 2), _nj._a());
        } catch (Exception unused) {
        }
        try {
            _k _kVar = new _k();
            JSONObject jSONObject = new JSONObject(str);
            _kVar._a = jSONObject.optInt(_y._f("1"));
            _kVar._b = jSONObject.optInt(_y._f("2"), UIMsg.f_FUN.FUN_ID_UTIL_ACTION);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(_y._f("19"));
            HashMap map = null;
            if (jSONArrayOptJSONArray == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            _kVar._g = arrayList;
            _kVar._h = jSONObject.optInt(_y._f("3"), UIMsg.f_FUN.FUN_ID_UTIL_ACTION);
            _kVar._d = jSONObject.optBoolean(_y._f("4"));
            _kVar._e = jSONObject.optInt(_y._f("5"));
            _kVar._f = jSONObject.optInt(_y._f("6"));
            _kVar._c = jSONObject.optInt(_y._f("7"), 1);
            _kVar._i = jSONObject.optBoolean(_y._f(PrepareException.ERROR_AUTH_FAIL));
            _kVar._j = jSONObject.optInt(_y._f("9"));
            _kVar._k = jSONObject.optLong(_y._f("10"));
            _kVar._l = jSONObject.optInt(_y._f("11"));
            _kVar._m = jSONObject.optBoolean(_y._f("12"));
            _kVar._n = jSONObject.optBoolean(_y._f("13"));
            _kVar._o = jSONObject.optBoolean(_y._f("14"));
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(_y._f("15"));
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            _kVar._p = arrayList2;
            _kVar._q = (float) jSONObject.optDouble(_y._f("17"), 36.0d);
            _kVar._r = (float) jSONObject.optDouble(_y._f("18"), 36.0d);
            _kVar._s = (float) jSONObject.optDouble(_y._f("23"), 3.0d);
            _kVar._t = (float) jSONObject.optDouble(_y._f("24"), 3.0d);
            _kVar._u = jSONObject.optBoolean(_y._f("20"), false);
            _kVar._v = jSONObject.optBoolean(_y._f("21"), false);
            String strOptString = jSONObject.optString(_y._f("22"));
            try {
                if (!TextUtils.isEmpty(strOptString)) {
                    HashMap map2 = new HashMap();
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map2.put(next, jSONObject2.optString(next));
                    }
                    map = map2;
                }
            } catch (Exception unused2) {
            }
            _kVar._w = map;
            return _kVar;
        } catch (Exception unused3) {
            return new _k();
        }
    }

    public static _a _a(_q _qVar, AdSlot adSlot) {
        String str_j;
        boolean z_s;
        boolean z_b;
        boolean z_b2;
        if (adSlot == null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            adErrorImpl._a = PtgErrorCode.SDK_AD_SLOT_ERR;
            adErrorImpl._b = PtgErrorCode.AD_SLOT_ERROR();
            return new _a(false, null, adErrorImpl);
        }
        List<_h> list = _qVar._a;
        if (list == null || list.isEmpty()) {
            AdErrorImpl adErrorImpl2 = new AdErrorImpl();
            adErrorImpl2._a = PtgErrorCode.SDK_AD_DATA_ERR;
            adErrorImpl2._b = PtgErrorCode.AD_DATA_ERROR();
            return new _a(false, null, adErrorImpl2);
        }
        int stype = adSlot.getStype();
        _h _hVar = list.get(0);
        if (_hVar != null) {
            str_j = _hVar._j();
            z_s = _hVar._s();
        } else {
            str_j = "";
            z_s = false;
        }
        if (adSlot.isSelfRender()) {
            return new _a(true, _qVar, null);
        }
        if (6 == stype) {
            if ("101".equals(str_j)) {
                return new _a(true, _qVar, null);
            }
            AdErrorImpl adErrorImpl3 = new AdErrorImpl();
            adErrorImpl3._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl3._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl3);
        }
        if (8 == stype) {
            int[] iArr_b = _i8._b(6);
            int length = iArr_b.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z_b2 = false;
                    break;
                }
                int i2 = iArr_b[i];
                if (_i9._a(i2).equals(str_j)) {
                    if (!z_s) {
                        z_b2 = _i9._b(i2);
                        break;
                    }
                    z_b2 = _i9._c(i2);
                    break;
                }
                i++;
            }
            if (z_b2) {
                return new _a(true, _qVar, null);
            }
            AdErrorImpl adErrorImpl4 = new AdErrorImpl();
            adErrorImpl4._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl4._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl4);
        }
        if (5 != stype) {
            if (7 == stype) {
                if ("201".equals(str_j)) {
                    return new _a(true, _qVar, null);
                }
                AdErrorImpl adErrorImpl5 = new AdErrorImpl();
                adErrorImpl5._a = PtgErrorCode.SDK_AD_STYLE_ERR;
                adErrorImpl5._b = PtgErrorCode.AD_STYLE_ERROR();
                return new _a(false, null, adErrorImpl5);
            }
            if (100 != stype) {
                AdErrorImpl adErrorImpl6 = new AdErrorImpl();
                adErrorImpl6._a = PtgErrorCode.SDK_AD_STYLE_ERR;
                adErrorImpl6._b = PtgErrorCode.AD_STYLE_ERROR();
                return new _a(false, null, adErrorImpl6);
            }
            if ("401".equals(str_j)) {
                return new _a(true, _qVar, null);
            }
            AdErrorImpl adErrorImpl7 = new AdErrorImpl();
            adErrorImpl7._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl7._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl7);
        }
        int[] iArr_b2 = _i8._b(7);
        int length2 = iArr_b2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                z_b = false;
                break;
            }
            int i4 = iArr_b2[i3];
            if (_i7._a(i4).equals(str_j)) {
                if (!z_s) {
                    z_b = _i7._b(i4);
                    break;
                }
                z_b = _i7._c(i4);
                break;
            }
            i3++;
        }
        if (z_b) {
            return new _a(true, _qVar, null);
        }
        AdErrorImpl adErrorImpl8 = new AdErrorImpl();
        adErrorImpl8._a = PtgErrorCode.SDK_AD_STYLE_ERR;
        adErrorImpl8._b = PtgErrorCode.AD_STYLE_ERROR();
        return new _a(false, null, adErrorImpl8);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0322  */
    /* JADX WARN: Code duplicated, block: B:103:0x032b A[Catch: Exception -> 0x0455, LOOP:7: B:101:0x0323->B:103:0x032b, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0337  */
    /* JADX WARN: Code duplicated, block: B:108:0x0378  */
    /* JADX WARN: Code duplicated, block: B:111:0x037f A[Catch: Exception -> 0x0455, LOOP:8: B:109:0x0379->B:111:0x037f, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:114:0x039c  */
    /* JADX WARN: Code duplicated, block: B:117:0x03a3 A[Catch: Exception -> 0x0455, LOOP:9: B:115:0x039d->B:117:0x03a3, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:120:0x03df A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:127:0x03ef A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:134:0x043c A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0443 A[Catch: Exception -> 0x0455, TRY_LEAVE, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0283 A[EDGE_INSN: B:171:0x0283->B:75:0x0283 BREAK  A[LOOP:2: B:71:0x026d->B:73:0x0275], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0171 A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0183 A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:56:0x019c A[Catch: Exception -> 0x0455, TRY_LEAVE, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:61:0x0201  */
    /* JADX WARN: Code duplicated, block: B:67:0x0231 A[Catch: Exception -> 0x0455, TRY_ENTER, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:70:0x026c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0275 A[Catch: Exception -> 0x0455, LOOP:2: B:71:0x026d->B:73:0x0275, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0281  */
    /* JADX WARN: Code duplicated, block: B:77:0x0294  */
    /* JADX WARN: Code duplicated, block: B:80:0x029b A[Catch: Exception -> 0x0455, LOOP:3: B:78:0x0295->B:80:0x029b, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:83:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:86:0x02bf A[Catch: Exception -> 0x0455, LOOP:4: B:84:0x02b9->B:86:0x02bf, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:89:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:92:0x02e3 A[Catch: Exception -> 0x0455, LOOP:5: B:90:0x02dd->B:92:0x02e3, LOOP_END, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0301 A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:98:0x030b A[Catch: Exception -> 0x0455, TryCatch #8 {Exception -> 0x0455, blocks: (B:3:0x001d, B:5:0x0076, B:6:0x0083, B:8:0x00a3, B:12:0x00aa, B:50:0x0160, B:52:0x0171, B:54:0x0183, B:56:0x019c, B:64:0x020b, B:67:0x0231, B:68:0x024d, B:71:0x026d, B:73:0x0275, B:75:0x0283, B:78:0x0295, B:80:0x029b, B:81:0x02a5, B:84:0x02b9, B:86:0x02bf, B:87:0x02c9, B:90:0x02dd, B:92:0x02e3, B:93:0x02ed, B:95:0x0301, B:96:0x0305, B:98:0x030b, B:101:0x0323, B:103:0x032b, B:105:0x0339, B:106:0x0345, B:109:0x0379, B:111:0x037f, B:112:0x0389, B:115:0x039d, B:117:0x03a3, B:118:0x03ad, B:120:0x03df, B:122:0x03e6, B:129:0x03f1, B:131:0x040b, B:62:0x0203, B:132:0x0430, B:134:0x043c, B:136:0x0443), top: B:162:0x001d }] */
    public static _a _a(AdSlot adSlot, String str) {
        _k _kVar;
        HashMap map;
        _f4 _f4Var_a;
        _fm _fmVar;
        _bb _bbVar;
        _f4 _f4Var;
        _bb _bbVar2;
        _fm _fmVar2;
        HashMap map2;
        HashMap map3;
        ArrayList arrayList;
        JSONArray jSONArrayOptJSONArray;
        _bb _bbVar3;
        long jCurrentTimeMillis;
        _fm _fmVar3;
        int length;
        _f4 _f4Var2;
        int i;
        _h _hVar;
        JSONObject jSONObjectOptJSONObject;
        String str2;
        String str3;
        String str4;
        String str5;
        HashMap map4;
        _k _kVar2;
        _bb _bbVar4;
        _f4 _f4Var3;
        _fm _fmVar4;
        String strOptString;
        String strDecode;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray2;
        ArrayList arrayList2;
        JSONArray jSONArrayOptJSONArray3;
        ArrayList arrayList3;
        JSONArray jSONArrayOptJSONArray4;
        ArrayList arrayList4;
        JSONArray jSONArrayOptJSONArray5;
        ArrayList arrayList5;
        JSONObject jSONObjectOptJSONObject3;
        HashMap map5;
        JSONArray jSONArrayOptJSONArray6;
        ArrayList arrayList6;
        JSONArray jSONArrayOptJSONArray7;
        ArrayList arrayList7;
        int i2;
        int i3;
        int i4;
        Iterator<String> itKeys;
        JSONArray jSONArrayOptJSONArray8;
        ArrayList arrayList8;
        String str6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        _bb _bbVar5;
        _fm _fmVar5;
        String str7 = "3";
        String str8 = "2";
        String str9 = "1";
        String str10 = "10";
        String str11 = "6";
        String str12 = "9";
        _q _qVar = new _q();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString2 = jSONObject.optString(_y._a("1"));
            _qVar._d = strOptString2;
            _qVar._e = jSONObject.optInt(_y._a("2"));
            _qVar._f = jSONObject.optString(_y._a("3"));
            _qVar._c = jSONObject.optLong(_y._a("4"));
            _qVar._b = jSONObject.optString(_y._a("5"));
            _qVar._h = jSONObject.optLong(_y._a("6"));
            _qVar._i = jSONObject.optString(_y._a("7"));
            if (_qVar._h == 0) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                _qVar._h = jCurrentTimeMillis2;
                jSONObject.put(_y._a("6"), jCurrentTimeMillis2);
            }
            _qVar._g = jSONObject.toString();
            _k _kVar_a = _a(jSONObject.optString(_y._a(PrepareException.ERROR_AUTH_FAIL)));
            HashMap map_b = _b(_qVar._i);
            map_b.put("iReportM", String.valueOf(_kVar_a._c() && _kVar_a._m));
            try {
                String strOptString3 = jSONObject.optString(_y._a("10"));
                if (TextUtils.isEmpty(strOptString3)) {
                    _kVar = _kVar_a;
                    map = map_b;
                    _fmVar2 = null;
                    _bbVar2 = null;
                    _f4Var = null;
                    map2 = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString3);
                    _f4Var_a = _f4._a(jSONObject2.optJSONObject("incentiveVideoConfig"));
                    try {
                        JSONObject jSONObjectOptJSONObject4 = jSONObject2.optJSONObject("interstitialConfig");
                        map = map_b;
                        try {
                            _fm _fmVar6 = new _fm();
                            if (jSONObjectOptJSONObject4 != null) {
                                _kVar = _kVar_a;
                                try {
                                    _fmVar6._a = jSONObjectOptJSONObject4.optInt("screenType");
                                    _fmVar6._b = jSONObjectOptJSONObject4.optInt("screenMode");
                                } catch (Exception unused) {
                                    _fmVar = null;
                                    _bbVar = null;
                                    _f4Var = _f4Var_a;
                                    _fmVar2 = _fmVar;
                                    _bbVar2 = _bbVar;
                                    map2 = null;
                                    map3 = map2;
                                    arrayList = new ArrayList();
                                    jSONArrayOptJSONArray = jSONObject.optJSONArray(_y._a("9"));
                                    if (jSONArrayOptJSONArray != null) {
                                        _fm _fmVar7 = _fmVar2;
                                        _bbVar3 = _bbVar2;
                                        jCurrentTimeMillis = System.currentTimeMillis();
                                        _fmVar3 = _fmVar7;
                                        length = jSONArrayOptJSONArray.length();
                                        _f4Var2 = _f4Var;
                                        i = 0;
                                        while (i < length) {
                                            int i10 = length;
                                            _hVar = new _h();
                                            _hVar._u = strOptString2;
                                            _hVar._w = jCurrentTimeMillis;
                                            long j = jCurrentTimeMillis;
                                            _hVar._y = adSlot.getStype();
                                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                                            if (jSONObjectOptJSONObject != null) {
                                                _hVar._a = jSONObjectOptJSONObject.optInt(_y._b(str9));
                                                _hVar._b = jSONObjectOptJSONObject.optString(_y._b(str8));
                                                _hVar._m = jSONObjectOptJSONObject.optInt(_y._b(str7));
                                                jSONObjectOptJSONObject.optString(_y._b("4"));
                                                _hVar._l = jSONObjectOptJSONObject.optInt(_y._b("5"));
                                                _hVar._d = jSONObjectOptJSONObject.optString(_y._b(str11));
                                                _hVar._e = jSONObjectOptJSONObject.optString(_y._b("7"));
                                                _hVar._i = jSONObjectOptJSONObject.optString(_y._b(PrepareException.ERROR_AUTH_FAIL));
                                                jSONObjectOptJSONObject.optString(_y._b(str12));
                                                strOptString = jSONObjectOptJSONObject.optString(_y._b(str10));
                                                strDecode = "";
                                                if (strOptString == null) {
                                                    str2 = str7;
                                                } else {
                                                    str2 = str7;
                                                    try {
                                                        strDecode = URLDecoder.decode(strOptString, "utf-8");
                                                    } catch (UnsupportedEncodingException unused2) {
                                                    }
                                                }
                                                _hVar._p = strDecode;
                                                _kVar2 = _kVar;
                                                _hVar._q = _kVar2;
                                                HashMap map6 = map;
                                                _hVar._r = map6;
                                                map = map6;
                                                _hVar._v = jSONObjectOptJSONObject.optLong(_y._b("11"));
                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_y._b("12"));
                                                if (jSONObjectOptJSONObject2 != null) {
                                                    jSONObjectOptJSONObject2.optString(_y._e(str10));
                                                    jSONObjectOptJSONObject2.optString(_y._e("11"));
                                                    jSONObjectOptJSONObject2.optString(_y._e("12"));
                                                    jSONObjectOptJSONObject2.optString(_y._e("13"));
                                                }
                                                _hVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_y._b("13")));
                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_y._b("14"));
                                                arrayList2 = new ArrayList();
                                                if (jSONArrayOptJSONArray2 != null) {
                                                    i9 = 0;
                                                    while (true) {
                                                        str3 = str10;
                                                        if (i9 >= jSONArrayOptJSONArray2.length()) {
                                                            break;
                                                        }
                                                        arrayList2.add(jSONArrayOptJSONArray2.optString(i9));
                                                        i9++;
                                                        str10 = str3;
                                                    }
                                                } else {
                                                    str3 = str10;
                                                }
                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_y._b("15"));
                                                arrayList3 = new ArrayList();
                                                if (jSONArrayOptJSONArray3 != null) {
                                                    for (i8 = 0; i8 < jSONArrayOptJSONArray3.length(); i8++) {
                                                        arrayList3.add(jSONArrayOptJSONArray3.optString(i8));
                                                    }
                                                }
                                                _hVar._f = arrayList3;
                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_y._b(TinyApp.SUB_TYPE_BRAND_ZONE));
                                                arrayList4 = new ArrayList();
                                                if (jSONArrayOptJSONArray4 != null) {
                                                    for (i7 = 0; i7 < jSONArrayOptJSONArray4.length(); i7++) {
                                                        arrayList4.add(jSONArrayOptJSONArray4.optString(i7));
                                                    }
                                                }
                                                _hVar._g = arrayList4;
                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_y._b("17"));
                                                arrayList5 = new ArrayList();
                                                if (jSONArrayOptJSONArray5 != null) {
                                                    for (i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                                                        arrayList5.add(jSONArrayOptJSONArray5.optString(i6));
                                                    }
                                                }
                                                _a(jSONObjectOptJSONObject, _hVar);
                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_y._b("18"));
                                                map5 = new HashMap();
                                                if (jSONObjectOptJSONObject3 != null) {
                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                    while (itKeys.hasNext()) {
                                                        String next = itKeys.next();
                                                        Iterator<String> it = itKeys;
                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next);
                                                        JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                                                        arrayList8 = new ArrayList();
                                                        String str13 = str11;
                                                        if (jSONArrayOptJSONArray8 != null) {
                                                            i5 = 0;
                                                            while (true) {
                                                                str6 = str12;
                                                                if (i5 < jSONArrayOptJSONArray8.length()) {
                                                                    arrayList8.add(jSONArrayOptJSONArray8.optString(i5));
                                                                    i5++;
                                                                    str12 = str6;
                                                                }
                                                            }
                                                        } else {
                                                            str6 = str12;
                                                        }
                                                        map5.put(next, arrayList8);
                                                        itKeys = it;
                                                        jSONObjectOptJSONObject3 = jSONObject3;
                                                        str11 = str13;
                                                        str12 = str6;
                                                    }
                                                }
                                                str4 = str11;
                                                str5 = str12;
                                                _hVar._h = map5;
                                                _hVar._z = _a(jSONObjectOptJSONObject.optJSONObject(_y._b("19")));
                                                _hVar._A = jSONObjectOptJSONObject.optString(_y._b("20"));
                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_y._b("21"));
                                                arrayList6 = new ArrayList();
                                                if (jSONArrayOptJSONArray6 != null) {
                                                    for (i4 = 0; i4 < jSONArrayOptJSONArray6.length(); i4++) {
                                                        arrayList6.add(jSONArrayOptJSONArray6.optString(i4));
                                                    }
                                                }
                                                _hVar._E = arrayList6;
                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_y._b("22"));
                                                arrayList7 = new ArrayList();
                                                if (jSONArrayOptJSONArray7 != null) {
                                                    for (i3 = 0; i3 < jSONArrayOptJSONArray7.length(); i3++) {
                                                        arrayList7.add(jSONArrayOptJSONArray7.optString(i3));
                                                    }
                                                }
                                                _hVar._F = arrayList7;
                                                _hVar._K = jSONObjectOptJSONObject.optString(_y._b("23"));
                                                _hVar._j = jSONObjectOptJSONObject.optInt(_y._b("24"), 3000);
                                                _bbVar4 = _bbVar3;
                                                _hVar._D = _bbVar4;
                                                _f4Var3 = _f4Var2;
                                                _hVar._B = _f4Var3;
                                                _fmVar4 = _fmVar3;
                                                _hVar._C = _fmVar4;
                                                map4 = map3;
                                                _hVar._G = map4;
                                                _hVar._J = !adSlot.isSelfRender() && adSlot.getUsedFor() == 1 && ((i2 = _kVar2._a) == 1 || i2 == 2);
                                            } else {
                                                str2 = str7;
                                                str3 = str10;
                                                str4 = str11;
                                                str5 = str12;
                                                map4 = map3;
                                                _kVar2 = _kVar;
                                                _bbVar4 = _bbVar3;
                                                _f4Var3 = _f4Var2;
                                                _fmVar4 = _fmVar3;
                                            }
                                            ArrayList arrayList9 = arrayList;
                                            arrayList9.add(_hVar);
                                            i++;
                                            _bbVar3 = _bbVar4;
                                            _f4Var2 = _f4Var3;
                                            _fmVar3 = _fmVar4;
                                            map3 = map4;
                                            arrayList = arrayList9;
                                            str8 = str8;
                                            length = i10;
                                            str9 = str9;
                                            str7 = str2;
                                            str10 = str3;
                                            str11 = str4;
                                            str12 = str5;
                                            _kVar = _kVar2;
                                            jCurrentTimeMillis = j;
                                        }
                                    }
                                    ArrayList arrayList10 = arrayList;
                                    _qVar._a = arrayList10;
                                    return !arrayList10.isEmpty() ? _a(_qVar, adSlot) : new _a(false, null, new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null));
                                }
                            } else {
                                _kVar = _kVar_a;
                            }
                            try {
                                _bb _bbVar_a = _bb._a(jSONObject2.optJSONObject("commonConfig"));
                                try {
                                    HashMap map7 = new HashMap();
                                    try {
                                        Iterator<String> itKeys2 = jSONObject2.keys();
                                        while (itKeys2.hasNext()) {
                                            _bbVar5 = _bbVar_a;
                                            try {
                                                String next2 = itKeys2.next();
                                                _fmVar5 = _fmVar6;
                                                try {
                                                    map7.put(next2, jSONObject2.optString(next2));
                                                    _fmVar6 = _fmVar5;
                                                    _bbVar_a = _bbVar5;
                                                } catch (Exception unused3) {
                                                }
                                            } catch (Exception unused4) {
                                                _fmVar5 = _fmVar6;
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                    _bbVar5 = _bbVar_a;
                                    _fmVar5 = _fmVar6;
                                    map2 = map7;
                                    _f4Var = _f4Var_a;
                                    _fmVar2 = _fmVar5;
                                    _bbVar2 = _bbVar5;
                                } catch (Exception unused6) {
                                    _bbVar = _bbVar_a;
                                    _fmVar = _fmVar6;
                                    _f4Var = _f4Var_a;
                                    _fmVar2 = _fmVar;
                                    _bbVar2 = _bbVar;
                                    map2 = null;
                                }
                            } catch (Exception unused7) {
                                _fmVar = _fmVar6;
                                _bbVar = null;
                                _f4Var = _f4Var_a;
                                _fmVar2 = _fmVar;
                                _bbVar2 = _bbVar;
                                map2 = null;
                                map3 = map2;
                                arrayList = new ArrayList();
                                jSONArrayOptJSONArray = jSONObject.optJSONArray(_y._a("9"));
                                if (jSONArrayOptJSONArray != null) {
                                    _fm _fmVar8 = _fmVar2;
                                    _bbVar3 = _bbVar2;
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                    _fmVar3 = _fmVar8;
                                    length = jSONArrayOptJSONArray.length();
                                    _f4Var2 = _f4Var;
                                    i = 0;
                                    while (i < length) {
                                        int i11 = length;
                                        _hVar = new _h();
                                        _hVar._u = strOptString2;
                                        _hVar._w = jCurrentTimeMillis;
                                        long j2 = jCurrentTimeMillis;
                                        _hVar._y = adSlot.getStype();
                                        jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                                        if (jSONObjectOptJSONObject != null) {
                                            _hVar._a = jSONObjectOptJSONObject.optInt(_y._b(str9));
                                            _hVar._b = jSONObjectOptJSONObject.optString(_y._b(str8));
                                            _hVar._m = jSONObjectOptJSONObject.optInt(_y._b(str7));
                                            jSONObjectOptJSONObject.optString(_y._b("4"));
                                            _hVar._l = jSONObjectOptJSONObject.optInt(_y._b("5"));
                                            _hVar._d = jSONObjectOptJSONObject.optString(_y._b(str11));
                                            _hVar._e = jSONObjectOptJSONObject.optString(_y._b("7"));
                                            _hVar._i = jSONObjectOptJSONObject.optString(_y._b(PrepareException.ERROR_AUTH_FAIL));
                                            jSONObjectOptJSONObject.optString(_y._b(str12));
                                            strOptString = jSONObjectOptJSONObject.optString(_y._b(str10));
                                            strDecode = "";
                                            if (strOptString == null) {
                                                str2 = str7;
                                            } else {
                                                str2 = str7;
                                                strDecode = URLDecoder.decode(strOptString, "utf-8");
                                            }
                                            _hVar._p = strDecode;
                                            _kVar2 = _kVar;
                                            _hVar._q = _kVar2;
                                            HashMap map8 = map;
                                            _hVar._r = map8;
                                            map = map8;
                                            _hVar._v = jSONObjectOptJSONObject.optLong(_y._b("11"));
                                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_y._b("12"));
                                            if (jSONObjectOptJSONObject2 != null) {
                                                jSONObjectOptJSONObject2.optString(_y._e(str10));
                                                jSONObjectOptJSONObject2.optString(_y._e("11"));
                                                jSONObjectOptJSONObject2.optString(_y._e("12"));
                                                jSONObjectOptJSONObject2.optString(_y._e("13"));
                                            }
                                            _hVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_y._b("13")));
                                            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_y._b("14"));
                                            arrayList2 = new ArrayList();
                                            if (jSONArrayOptJSONArray2 != null) {
                                                i9 = 0;
                                                while (true) {
                                                    str3 = str10;
                                                    if (i9 >= jSONArrayOptJSONArray2.length()) {
                                                        break;
                                                        break;
                                                    }
                                                    arrayList2.add(jSONArrayOptJSONArray2.optString(i9));
                                                    i9++;
                                                    str10 = str3;
                                                }
                                            } else {
                                                str3 = str10;
                                            }
                                            jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_y._b("15"));
                                            arrayList3 = new ArrayList();
                                            if (jSONArrayOptJSONArray3 != null) {
                                                while (i8 < jSONArrayOptJSONArray3.length()) {
                                                    arrayList3.add(jSONArrayOptJSONArray3.optString(i8));
                                                }
                                            }
                                            _hVar._f = arrayList3;
                                            jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_y._b(TinyApp.SUB_TYPE_BRAND_ZONE));
                                            arrayList4 = new ArrayList();
                                            if (jSONArrayOptJSONArray4 != null) {
                                                while (i7 < jSONArrayOptJSONArray4.length()) {
                                                    arrayList4.add(jSONArrayOptJSONArray4.optString(i7));
                                                }
                                            }
                                            _hVar._g = arrayList4;
                                            jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_y._b("17"));
                                            arrayList5 = new ArrayList();
                                            if (jSONArrayOptJSONArray5 != null) {
                                                while (i6 < jSONArrayOptJSONArray5.length()) {
                                                    arrayList5.add(jSONArrayOptJSONArray5.optString(i6));
                                                }
                                            }
                                            _a(jSONObjectOptJSONObject, _hVar);
                                            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_y._b("18"));
                                            map5 = new HashMap();
                                            if (jSONObjectOptJSONObject3 != null) {
                                                itKeys = jSONObjectOptJSONObject3.keys();
                                                while (itKeys.hasNext()) {
                                                    String next3 = itKeys.next();
                                                    Iterator<String> it2 = itKeys;
                                                    jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next3);
                                                    JSONObject jSONObject4 = jSONObjectOptJSONObject3;
                                                    arrayList8 = new ArrayList();
                                                    String str14 = str11;
                                                    if (jSONArrayOptJSONArray8 != null) {
                                                        i5 = 0;
                                                        while (true) {
                                                            str6 = str12;
                                                            if (i5 < jSONArrayOptJSONArray8.length()) {
                                                                arrayList8.add(jSONArrayOptJSONArray8.optString(i5));
                                                                i5++;
                                                                str12 = str6;
                                                            }
                                                        }
                                                    } else {
                                                        str6 = str12;
                                                    }
                                                    map5.put(next3, arrayList8);
                                                    itKeys = it2;
                                                    jSONObjectOptJSONObject3 = jSONObject4;
                                                    str11 = str14;
                                                    str12 = str6;
                                                }
                                            }
                                            str4 = str11;
                                            str5 = str12;
                                            _hVar._h = map5;
                                            _hVar._z = _a(jSONObjectOptJSONObject.optJSONObject(_y._b("19")));
                                            _hVar._A = jSONObjectOptJSONObject.optString(_y._b("20"));
                                            jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_y._b("21"));
                                            arrayList6 = new ArrayList();
                                            if (jSONArrayOptJSONArray6 != null) {
                                                while (i4 < jSONArrayOptJSONArray6.length()) {
                                                    arrayList6.add(jSONArrayOptJSONArray6.optString(i4));
                                                }
                                            }
                                            _hVar._E = arrayList6;
                                            jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_y._b("22"));
                                            arrayList7 = new ArrayList();
                                            if (jSONArrayOptJSONArray7 != null) {
                                                while (i3 < jSONArrayOptJSONArray7.length()) {
                                                    arrayList7.add(jSONArrayOptJSONArray7.optString(i3));
                                                }
                                            }
                                            _hVar._F = arrayList7;
                                            _hVar._K = jSONObjectOptJSONObject.optString(_y._b("23"));
                                            _hVar._j = jSONObjectOptJSONObject.optInt(_y._b("24"), 3000);
                                            _bbVar4 = _bbVar3;
                                            _hVar._D = _bbVar4;
                                            _f4Var3 = _f4Var2;
                                            _hVar._B = _f4Var3;
                                            _fmVar4 = _fmVar3;
                                            _hVar._C = _fmVar4;
                                            map4 = map3;
                                            _hVar._G = map4;
                                            _hVar._J = !adSlot.isSelfRender() && adSlot.getUsedFor() == 1 && ((i2 = _kVar2._a) == 1 || i2 == 2);
                                        } else {
                                            str2 = str7;
                                            str3 = str10;
                                            str4 = str11;
                                            str5 = str12;
                                            map4 = map3;
                                            _kVar2 = _kVar;
                                            _bbVar4 = _bbVar3;
                                            _f4Var3 = _f4Var2;
                                            _fmVar4 = _fmVar3;
                                        }
                                        ArrayList arrayList11 = arrayList;
                                        arrayList11.add(_hVar);
                                        i++;
                                        _bbVar3 = _bbVar4;
                                        _f4Var2 = _f4Var3;
                                        _fmVar3 = _fmVar4;
                                        map3 = map4;
                                        arrayList = arrayList11;
                                        str8 = str8;
                                        length = i11;
                                        str9 = str9;
                                        str7 = str2;
                                        str10 = str3;
                                        str11 = str4;
                                        str12 = str5;
                                        _kVar = _kVar2;
                                        jCurrentTimeMillis = j2;
                                    }
                                }
                                ArrayList arrayList12 = arrayList;
                                _qVar._a = arrayList12;
                                if (!arrayList12.isEmpty()) {
                                }
                            }
                        } catch (Exception unused8) {
                            _kVar = _kVar_a;
                        }
                    } catch (Exception unused9) {
                        _kVar = _kVar_a;
                        map = map_b;
                    }
                }
            } catch (Exception unused10) {
                _kVar = _kVar_a;
                map = map_b;
                _f4Var_a = null;
            }
            map3 = map2;
            arrayList = new ArrayList();
            jSONArrayOptJSONArray = jSONObject.optJSONArray(_y._a("9"));
            if (jSONArrayOptJSONArray != null) {
                _fm _fmVar9 = _fmVar2;
                _bbVar3 = _bbVar2;
                jCurrentTimeMillis = System.currentTimeMillis();
                _fmVar3 = _fmVar9;
                length = jSONArrayOptJSONArray.length();
                _f4Var2 = _f4Var;
                i = 0;
                while (i < length) {
                    int i12 = length;
                    _hVar = new _h();
                    _hVar._u = strOptString2;
                    _hVar._w = jCurrentTimeMillis;
                    long j3 = jCurrentTimeMillis;
                    _hVar._y = adSlot.getStype();
                    jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        _hVar._a = jSONObjectOptJSONObject.optInt(_y._b(str9));
                        _hVar._b = jSONObjectOptJSONObject.optString(_y._b(str8));
                        _hVar._m = jSONObjectOptJSONObject.optInt(_y._b(str7));
                        jSONObjectOptJSONObject.optString(_y._b("4"));
                        _hVar._l = jSONObjectOptJSONObject.optInt(_y._b("5"));
                        _hVar._d = jSONObjectOptJSONObject.optString(_y._b(str11));
                        _hVar._e = jSONObjectOptJSONObject.optString(_y._b("7"));
                        _hVar._i = jSONObjectOptJSONObject.optString(_y._b(PrepareException.ERROR_AUTH_FAIL));
                        jSONObjectOptJSONObject.optString(_y._b(str12));
                        strOptString = jSONObjectOptJSONObject.optString(_y._b(str10));
                        strDecode = "";
                        if (strOptString == null) {
                            str2 = str7;
                        } else {
                            str2 = str7;
                            strDecode = URLDecoder.decode(strOptString, "utf-8");
                        }
                        _hVar._p = strDecode;
                        _kVar2 = _kVar;
                        _hVar._q = _kVar2;
                        HashMap map9 = map;
                        _hVar._r = map9;
                        map = map9;
                        _hVar._v = jSONObjectOptJSONObject.optLong(_y._b("11"));
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_y._b("12"));
                        if (jSONObjectOptJSONObject2 != null) {
                            jSONObjectOptJSONObject2.optString(_y._e(str10));
                            jSONObjectOptJSONObject2.optString(_y._e("11"));
                            jSONObjectOptJSONObject2.optString(_y._e("12"));
                            jSONObjectOptJSONObject2.optString(_y._e("13"));
                        }
                        _hVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_y._b("13")));
                        jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_y._b("14"));
                        arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            i9 = 0;
                            while (true) {
                                str3 = str10;
                                if (i9 >= jSONArrayOptJSONArray2.length()) {
                                    break;
                                    break;
                                }
                                arrayList2.add(jSONArrayOptJSONArray2.optString(i9));
                                i9++;
                                str10 = str3;
                            }
                        } else {
                            str3 = str10;
                        }
                        jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_y._b("15"));
                        arrayList3 = new ArrayList();
                        if (jSONArrayOptJSONArray3 != null) {
                            while (i8 < jSONArrayOptJSONArray3.length()) {
                                arrayList3.add(jSONArrayOptJSONArray3.optString(i8));
                            }
                        }
                        _hVar._f = arrayList3;
                        jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_y._b(TinyApp.SUB_TYPE_BRAND_ZONE));
                        arrayList4 = new ArrayList();
                        if (jSONArrayOptJSONArray4 != null) {
                            while (i7 < jSONArrayOptJSONArray4.length()) {
                                arrayList4.add(jSONArrayOptJSONArray4.optString(i7));
                            }
                        }
                        _hVar._g = arrayList4;
                        jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_y._b("17"));
                        arrayList5 = new ArrayList();
                        if (jSONArrayOptJSONArray5 != null) {
                            while (i6 < jSONArrayOptJSONArray5.length()) {
                                arrayList5.add(jSONArrayOptJSONArray5.optString(i6));
                            }
                        }
                        _a(jSONObjectOptJSONObject, _hVar);
                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_y._b("18"));
                        map5 = new HashMap();
                        if (jSONObjectOptJSONObject3 != null) {
                            itKeys = jSONObjectOptJSONObject3.keys();
                            while (itKeys.hasNext()) {
                                String next4 = itKeys.next();
                                Iterator<String> it3 = itKeys;
                                jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next4);
                                JSONObject jSONObject5 = jSONObjectOptJSONObject3;
                                arrayList8 = new ArrayList();
                                String str15 = str11;
                                if (jSONArrayOptJSONArray8 != null) {
                                    i5 = 0;
                                    while (true) {
                                        str6 = str12;
                                        if (i5 < jSONArrayOptJSONArray8.length()) {
                                            arrayList8.add(jSONArrayOptJSONArray8.optString(i5));
                                            i5++;
                                            str12 = str6;
                                        }
                                    }
                                } else {
                                    str6 = str12;
                                }
                                map5.put(next4, arrayList8);
                                itKeys = it3;
                                jSONObjectOptJSONObject3 = jSONObject5;
                                str11 = str15;
                                str12 = str6;
                            }
                        }
                        str4 = str11;
                        str5 = str12;
                        _hVar._h = map5;
                        _hVar._z = _a(jSONObjectOptJSONObject.optJSONObject(_y._b("19")));
                        _hVar._A = jSONObjectOptJSONObject.optString(_y._b("20"));
                        jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_y._b("21"));
                        arrayList6 = new ArrayList();
                        if (jSONArrayOptJSONArray6 != null) {
                            while (i4 < jSONArrayOptJSONArray6.length()) {
                                arrayList6.add(jSONArrayOptJSONArray6.optString(i4));
                            }
                        }
                        _hVar._E = arrayList6;
                        jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_y._b("22"));
                        arrayList7 = new ArrayList();
                        if (jSONArrayOptJSONArray7 != null) {
                            while (i3 < jSONArrayOptJSONArray7.length()) {
                                arrayList7.add(jSONArrayOptJSONArray7.optString(i3));
                            }
                        }
                        _hVar._F = arrayList7;
                        _hVar._K = jSONObjectOptJSONObject.optString(_y._b("23"));
                        _hVar._j = jSONObjectOptJSONObject.optInt(_y._b("24"), 3000);
                        _bbVar4 = _bbVar3;
                        _hVar._D = _bbVar4;
                        _f4Var3 = _f4Var2;
                        _hVar._B = _f4Var3;
                        _fmVar4 = _fmVar3;
                        _hVar._C = _fmVar4;
                        map4 = map3;
                        _hVar._G = map4;
                        _hVar._J = !adSlot.isSelfRender() && adSlot.getUsedFor() == 1 && ((i2 = _kVar2._a) == 1 || i2 == 2);
                    } else {
                        str2 = str7;
                        str3 = str10;
                        str4 = str11;
                        str5 = str12;
                        map4 = map3;
                        _kVar2 = _kVar;
                        _bbVar4 = _bbVar3;
                        _f4Var3 = _f4Var2;
                        _fmVar4 = _fmVar3;
                    }
                    ArrayList arrayList13 = arrayList;
                    arrayList13.add(_hVar);
                    i++;
                    _bbVar3 = _bbVar4;
                    _f4Var2 = _f4Var3;
                    _fmVar3 = _fmVar4;
                    map3 = map4;
                    arrayList = arrayList13;
                    str8 = str8;
                    length = i12;
                    str9 = str9;
                    str7 = str2;
                    str10 = str3;
                    str11 = str4;
                    str12 = str5;
                    _kVar = _kVar2;
                    jCurrentTimeMillis = j3;
                }
            }
            ArrayList arrayList14 = arrayList;
            _qVar._a = arrayList14;
            if (!arrayList14.isEmpty()) {
            }
        } catch (Exception e) {
            return new _a(false, null, new AdErrorImpl(1004, e.getMessage(), (Object) null));
        }
    }

    public static void _a(JSONObject jSONObject, _h _hVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(QdActivityType.IMP);
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("0");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            _hVar._n = arrayList;
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (TextUtils.isDigitsOnly(next) && Long.parseLong(next) != 0) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                        }
                    }
                    map.put(Long.valueOf(next), arrayList2);
                }
            }
            _hVar._o = map;
        }
    }

    public static AppInfo _b(JSONObject jSONObject) {
        _od _odVar = null;
        if (jSONObject == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setIcon_url(jSONObject.optString(_y._e("1")));
        appInfo.setName(jSONObject.optString(_y._e("2")));
        appInfo.setPackage_name(jSONObject.optString(_y._e("3")));
        appInfo.setAppVersion(jSONObject.optString(_y._e("4")));
        appInfo.setDevelopers(jSONObject.optString(_y._e("5")));
        appInfo.setPrivacyProtocolUrl(jSONObject.optString(_y._e("6")));
        appInfo.setPermissionProtocolUrl(jSONObject.optString(_y._e("7")));
        appInfo.setFunctionDescUrl(jSONObject.optString(_y._e(PrepareException.ERROR_AUTH_FAIL)));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(_y._e("9"));
        if (jSONObjectOptJSONObject != null) {
            _odVar = new _od();
            LinkedHashMap linkedHashMap = _y._g;
            int iOptInt = jSONObjectOptJSONObject.optInt(com.kc.aw.lib.utils._a._a((String) linkedHashMap.get("1")));
            String strOptString = jSONObjectOptJSONObject.optString(com.kc.aw.lib.utils._a._a((String) linkedHashMap.get("2")));
            String strOptString2 = jSONObjectOptJSONObject.optString(com.kc.aw.lib.utils._a._a((String) linkedHashMap.get("3")));
            String strOptString3 = jSONObjectOptJSONObject.optString(com.kc.aw.lib.utils._a._a((String) linkedHashMap.get("4")));
            String strOptString4 = jSONObjectOptJSONObject.optString(com.kc.aw.lib.utils._a._a((String) linkedHashMap.get("5")));
            _odVar._a = iOptInt;
            _odVar._b = strOptString;
            _odVar._c = strOptString2;
            _odVar._d = strOptString3;
            _odVar._e = strOptString4;
        }
        appInfo.setWechatExt(_odVar);
        return appInfo;
    }

    public static HashMap _b(String str) {
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("sundryParams");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject.optString(next));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }
}
