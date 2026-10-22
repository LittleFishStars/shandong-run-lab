package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.timepicker.TimeModel;
import com.ipd.dsp.internal.v0.q;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.xh9;
import com.zj.adlib.ze1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l0 {
    public static String _a(String str, _nr _nrVar) {
        _c9 _c9Var;
        _c9 _c9Var2;
        _a6 _a6Var;
        _c9 _c9Var3;
        _c9 _c9Var4;
        _dz _dzVar;
        String str_a;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        _nrVar._c();
        String str_a2 = _a(_a(_a(str, "__SDK_VERSION__", PtgAdSdk.getConfig().getSdkVersionCode()), "__ERR__", String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(_nrVar._f))), "__OS__", "1");
        TextUtils.isEmpty(_nrVar._i);
        String str_a3 = _a(_a(_a(_a(_a(_a(_a(_a(_a(_a(_a(_a(_a(_a(_a(str_a2, "__IMEI__", _nrVar._i), "__MAC__", (!TextUtils.isEmpty(_nrVar._j) || (_c9Var = _nrVar._d) == null || TextUtils.isEmpty(_c9Var._e)) ? _nrVar._j : _nr._a(_nrVar._d._e)), "__ANDROIDID__", (!TextUtils.isEmpty(_nrVar._k) || (_c9Var2 = _nrVar._d) == null || TextUtils.isEmpty(_c9Var2._d)) ? _nrVar._k : _nrVar._d._d), "__REQUESTID__", _nrVar._h), "__APP__", (!TextUtils.isEmpty(_nrVar._m) || (_a6Var = _nrVar._e) == null || TextUtils.isEmpty(_a6Var._d)) ? _nrVar._m : _nrVar._e._d), "__AD__", String.format(TimeModel.NUMBER_FORMAT, Long.valueOf(_nrVar._o))), "__TS__", String.format(TimeModel.NUMBER_FORMAT, Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue()))), "__SLOTID__", _nrVar._a), "__CID__", _nrVar._b), "__OAID__", (!TextUtils.isEmpty(_nrVar._l) || (_c9Var3 = _nrVar._d) == null || TextUtils.isEmpty(_c9Var3._a)) ? _nrVar._l : _nrVar._d._a), "__ACTION__", _nrVar._c), "__LBS__", (!TextUtils.isEmpty(_nrVar._n) || (_c9Var4 = _nrVar._d) == null || (_dzVar = _c9Var4._m) == null) ? _nrVar._n : String.format("%fx%f", Double.valueOf(_dzVar._a), Double.valueOf(_dzVar._b))), "__IP__", q.i), "__CLIENTTYPE__", "2"), "__PRICE__", _nrVar._a());
        _nq _nqVar = _nrVar._t;
        _nqVar.getClass();
        try {
            synchronized (_nqVar._a) {
                JSONObject jSONObject = _nqVar._a;
                str_a = com.kc.aw.lib.utils._a._a(jSONObject == null ? "" : jSONObject.toString(), _nj._a());
            }
        } catch (Exception unused) {
            str_a = "";
        }
        return _a(str_a3, "__DATA__", str_a);
    }

    public static String _a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str3) ? str : str.replaceAll(str2, com.kc.aw.lib.utils._a._b(str3));
    }

    public static JSONObject _a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlibcCommonConstant.APP_VERSION, _cc._a()._a);
            jSONObject.put("app_version_code", _cc._a()._b);
            jSONObject.put("app_name", _cc._a()._c);
            jSONObject.put("pkg_name", _cc._a()._d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject _b() {
        JSONObject jSONObject = new JSONObject();
        if (PtgAdSdk.getConfig() == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("mediaId", PtgAdSdk.getConfig()._a);
            jSONObject.put("ptgAppId", PtgAdSdk.getConfig()._b);
            jSONObject.put("ttAppId", PtgAdSdk.getConfig()._a("tt"));
            jSONObject.put("gdtAppId", PtgAdSdk.getConfig()._a("gdt"));
            jSONObject.put("viAppId", PtgAdSdk.getConfig()._a(AliyunLogKey.KEY_VIDEOID));
            jSONObject.put("ksAppId", PtgAdSdk.getConfig()._a(MediationConstant.ADN_KS));
            jSONObject.put("jdAppId", PtgAdSdk.getConfig()._a("jd"));
            jSONObject.put("qmAppId", PtgAdSdk.getConfig()._a("qm"));
            jSONObject.put("policyVersion", PtgAdSdk.getConfig()._g);
            PtgAdSdk.getConfig().getClass();
            Context context = PtgAdSdk.getContext();
            String str = "";
            String str_c = context != null ? _jw._c(context, "ptg_policy_url") : "";
            if (str_c != null) {
                str = str_c;
            }
            jSONObject.put("policyUrl", str);
            jSONObject.put("sdkVersion", PtgAdSdk.getConfig().getSdkVersionCode());
            PtgAdSdk.getConfig().getClass();
            jSONObject.put("support", 1);
            PtgAdSdk.getConfig().getClass();
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, "ss");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject _c() {
        JSONObject jSONObject = new JSONObject();
        try {
            _c9 _c9Var = _m4._a;
            jSONObject.put("width", _c9Var._n);
            jSONObject.put("height", _c9Var._o);
            jSONObject.put(DeviceIdType.OAID, _c9Var._a);
            jSONObject.put(DeviceIdType.GAID, _c9Var._b);
            jSONObject.put(DeviceIdType.IMEI, _c9Var._c);
            jSONObject.put(DeviceIdType.ANDROID_ID, _c9Var._d);
            jSONObject.put("udid", (Object) null);
            jSONObject.put("mac", _c9Var._e);
            jSONObject.put("vendor", _c9Var._f);
            jSONObject.put(ze1.k, _c9Var._g);
            jSONObject.put("os", _c9Var._h);
            jSONObject.put("osVersion", _c9Var._i);
            jSONObject.put("network", _c9Var._j);
            jSONObject.put("operator", _c9Var._k);
            jSONObject.put("operatorCode", _c9Var._l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void _a(long j) {
        com.kc.aw.lib.utils._d._b(new _kz(this, j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public final void _a(_h _hVar) {
        ?? r5;
        Map<String, String> map;
        ?? EmptyList;
        List<String> list;
        boolean zContains;
        if (_hVar == null) {
            Logger.d("Frequency api imp err ad is null");
            return;
        }
        Logger.d("Frequency api imp");
        _ks _ksVar = _hVar._s;
        if (_ksVar == null || (map = _ksVar._a) == null || map.isEmpty()) {
            r5 = _hVar._n;
        } else {
            List<String> list2 = _hVar._n;
            Map<String, String> map2 = _hVar._s._a;
            synchronized (_kt.class) {
                try {
                    if (list2 == null || map2 == null) {
                        EmptyList = Collections.emptyList();
                    } else {
                        String sdkVersionCode = PtgAdSdk.getConfig().getSdkVersionCode();
                        String str_a = _kt._a(map2, null);
                        EmptyList = new ArrayList();
                        Iterator<String> it = list2.iterator();
                        while (it.hasNext()) {
                            String str_a2 = _kt._a(it.next(), "__SDK_VERSION__", sdkVersionCode);
                            for (Map.Entry<String, String> entry : map2.entrySet()) {
                                str_a2 = _kt._a(str_a2, entry.getKey(), entry.getValue());
                            }
                            Random random = com.kc.aw.lib.utils._a._a;
                            if (TextUtils.isEmpty(str_a2) || (list = _i2._f._e) == null || list.isEmpty()) {
                                zContains = false;
                            } else {
                                try {
                                    zContains = list.contains(new URL(str_a2).getHost());
                                } catch (Exception unused) {
                                    zContains = false;
                                }
                            }
                            if (zContains) {
                                str_a2 = _kt._a(str_a2, "__DATA__", str_a);
                            }
                            EmptyList.add(str_a2);
                        }
                    }
                    r5 = EmptyList;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (r5 != 0) {
            _h1._a((List<String>) r5, (HashMap<String, String>) null);
        } else {
            _h1._f _fVar = _h1._a;
            Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
        }
        Map<Long, List<String>> map3 = _hVar._o;
        if (map3 == null || map3.isEmpty() || map3.isEmpty()) {
            Logger.e(Logger.ILogger.TAG, "delayImp is null");
            return;
        }
        for (Map.Entry entry2 : new HashMap(map3).entrySet()) {
            Long l = (Long) entry2.getKey();
            List list3 = (List) entry2.getValue();
            if (l != null && l.longValue() >= 0) {
                _fz._a.postDelayed(new _h1._e(list3), l.longValue());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:10:0x0018, B:27:0x0067, B:29:0x0072, B:30:0x0076, B:32:0x007c, B:14:0x0028, B:17:0x0037, B:20:0x0046, B:23:0x0055, B:26:0x0063), top: B:43:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007c A[Catch: all -> 0x009a, LOOP:0: B:30:0x0076->B:32:0x007c, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x009a, blocks: (B:10:0x0018, B:27:0x0067, B:29:0x0072, B:30:0x0076, B:32:0x007c, B:14:0x0028, B:17:0x0037, B:20:0x0046, B:23:0x0055, B:26:0x0063), top: B:43:0x0018 }] */
    public final void _a(_h _hVar, AdBidLossReason adBidLossReason) {
        String str;
        ArrayList arrayList;
        Iterator it;
        if (_hVar == null) {
            Logger.d("Frequency api fail err ad is null");
            return;
        }
        Logger.d("Frequency api fail");
        List arrayList2 = _hVar._E;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        synchronized (_kt.class) {
            String str2 = "";
            String lossOtherReason = "";
            try {
                if ("1001".equals(adBidLossReason.getLossCode())) {
                    str = "202";
                } else if ("1002".equals(adBidLossReason.getLossCode())) {
                    str = "203";
                } else if ("1003".equals(adBidLossReason.getLossCode())) {
                    str = "100";
                } else {
                    if ("1004".equals(adBidLossReason.getLossCode())) {
                        str = "201";
                    } else if ("1005".equals(adBidLossReason.getLossCode())) {
                        str2 = "900";
                        lossOtherReason = adBidLossReason.getLossOtherReason();
                    }
                    arrayList = new ArrayList();
                    if (TextUtil.isNotEmpty(arrayList2)) {
                        it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(_kt._a(_kt._a((String) it.next(), "__REASON__", str2), "__MSG__", lossOtherReason));
                        }
                    }
                }
                str2 = str;
                arrayList = new ArrayList();
                if (TextUtil.isNotEmpty(arrayList2)) {
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(_kt._a(_kt._a((String) it.next(), "__REASON__", str2), "__MSG__", lossOtherReason));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        _h1._a(arrayList, (HashMap<String, String>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final void _a(_h _hVar, AdSlot adSlot) {
        ?? r2;
        Map<String, String> map;
        ?? EmptyList;
        List<String> list;
        boolean zContains;
        if (_hVar == null || adSlot == null) {
            Logger.d("Frequency api clk err ad is null");
            return;
        }
        Logger.d("Frequency api clk");
        _ks _ksVar = _hVar._s;
        if (_ksVar == null || (map = _ksVar._b) == null || map.isEmpty()) {
            r2 = _hVar._g;
        } else {
            List<String> list2 = _hVar._g;
            Map<String, String> map2 = _hVar._s._b;
            synchronized (_kt.class) {
                try {
                    if (list2 == null || map2 == null) {
                        EmptyList = Collections.emptyList();
                    } else {
                        String sdkVersionCode = PtgAdSdk.getConfig().getSdkVersionCode();
                        String str_a = _kt._a(map2, adSlot);
                        EmptyList = new ArrayList();
                        Iterator<String> it = list2.iterator();
                        while (it.hasNext()) {
                            String str_a2 = _kt._a(it.next(), "__SDK_VERSION__", sdkVersionCode);
                            for (Map.Entry<String, String> entry : map2.entrySet()) {
                                str_a2 = _kt._a(str_a2, entry.getKey(), entry.getValue());
                            }
                            Random random = com.kc.aw.lib.utils._a._a;
                            if (TextUtils.isEmpty(str_a2) || (list = _i2._f._e) == null || list.isEmpty()) {
                                zContains = false;
                            } else {
                                try {
                                    zContains = list.contains(new URL(str_a2).getHost());
                                } catch (Exception unused) {
                                    zContains = false;
                                }
                            }
                            if (zContains) {
                                str_a2 = _kt._a(str_a2, "__DATA__", str_a);
                            }
                            EmptyList.add(str_a2);
                        }
                    }
                    r2 = EmptyList;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (r2 != 0) {
            _h1._a((List<String>) r2, (HashMap<String, String>) null);
        } else {
            _h1._f _fVar = _h1._a;
            Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
        }
    }

    public final void _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        _h1._a(str);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009f  */
    public final void _a(Collection<String> collection, String str, _nr _nrVar, String str2) {
        try {
            if (TextUtils.isEmpty(_nrVar._t._a("layer"))) {
                System.out.println();
            }
        } catch (Exception unused) {
        }
        if (str != null && _nrVar != null) {
            ArrayList arrayList = new ArrayList();
            synchronized (_nt._a()._a) {
                if (_nt._a()._a != null) {
                    arrayList.addAll(_nt._a()._a);
                }
                if (!arrayList.isEmpty()) {
                    switch (str) {
                        case "inAppBid":
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((_np) it.next())._e(_nrVar);
                            }
                            break;
                        case "inAppBidSuc":
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ((_np) it2.next())._h(_nrVar);
                            }
                            break;
                        case "bidSel":
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                ((_np) it3.next())._b(_nrVar);
                            }
                            break;
                        case "inAppImp":
                            Iterator it4 = arrayList.iterator();
                            while (it4.hasNext()) {
                                ((_np) it4.next())._a(_nrVar);
                            }
                            break;
                        case "inAppClick":
                            Iterator it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                ((_np) it5.next())._g(_nrVar);
                            }
                            break;
                        case "inAppErr":
                            Iterator it6 = arrayList.iterator();
                            while (it6.hasNext()) {
                                ((_np) it6.next())._d(_nrVar);
                            }
                            break;
                        case "inAppVp":
                            Iterator it7 = arrayList.iterator();
                            while (it7.hasNext()) {
                                ((_np) it7.next())._i(_nrVar);
                            }
                            break;
                        case "inAppBidLoss":
                            Iterator it8 = arrayList.iterator();
                            while (it8.hasNext()) {
                                ((_np) it8.next())._f(_nrVar);
                            }
                            break;
                        case "inAppBidWin":
                            Iterator it9 = arrayList.iterator();
                            while (it9.hasNext()) {
                                ((_np) it9.next())._c(_nrVar);
                            }
                            break;
                    }
                }
            }
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (!collection.isEmpty()) {
                _nrVar._c = str;
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it10 = collection.iterator();
                while (it10.hasNext()) {
                    String str_a = _a(it10.next(), _nrVar);
                    if (!TextUtils.isEmpty(str_a)) {
                        arrayList2.add(str_a);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Logger.d("TrackingManager:", String.format("DoTracking url [get] action :%s", str));
                    _h1._a(arrayList2, (HashMap<String, String>) null);
                }
            }
        } else if (!collection.isEmpty()) {
            _nrVar._c = str;
            HashSet<String> hashSet = new HashSet();
            Iterator<String> it11 = collection.iterator();
            while (it11.hasNext()) {
                String str_a2 = _a(it11.next(), _nrVar);
                if (!TextUtils.isEmpty(str_a2)) {
                    hashSet.add(str_a2);
                }
            }
            if (!hashSet.isEmpty()) {
                Logger.d("TrackingManager:", String.format("DoTracking url [post] action :%s", str));
                hashSet.toArray(new String[hashSet.size()]);
                for (String str3 : hashSet) {
                    _h1._f _fVar = _h1._a;
                    _ee _eeVar = new _ee(str3);
                    if (!TextUtils.isEmpty(str2)) {
                        _eeVar._e = str2;
                        _eeVar._d = "POST";
                    }
                    _eeVar._h = _fVar;
                    _h1._b.offer(_eeVar);
                }
            }
        }
        if (!"inAppBidSuc".equals(str) || _nrVar == null) {
            return;
        }
        _nq _nqVar = _nrVar._t;
        _nqVar.getClass();
        try {
            synchronized (_nqVar._a) {
                JSONObject jSONObject = _nqVar._a;
                if (jSONObject != null) {
                    jSONObject.remove("successType");
                }
            }
        } catch (Exception unused2) {
        }
    }

    public final void _b(_h _hVar) {
        ArrayList arrayList;
        if (_hVar == null) {
            Logger.d("Frequency api win err ad is null");
            return;
        }
        Logger.d("Frequency api win");
        List arrayList2 = _hVar._F;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        int i = _hVar._l;
        synchronized (_kt.class) {
            try {
                arrayList = new ArrayList();
                if (TextUtil.isNotEmpty(arrayList2)) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(_kt._a((String) it.next(), "__WIN__PRICE__", String.valueOf(i)));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        _h1._a(arrayList, (HashMap<String, String>) null);
    }
}
