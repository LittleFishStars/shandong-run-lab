package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdSlot;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _au {
    /* JADX WARN: Multi-variable type inference failed */
    public static LinkedHashMap _a(AdSlot adSlot) {
        String str_c;
        boolean z;
        String str;
        String str2;
        String string;
        int iIntValue;
        int stype = adSlot.getStype();
        String codeId = adSlot.getCodeId();
        long basePrice = adSlot.getBasePrice();
        _c9 deviceInfo = adSlot.getDeviceInfo();
        String ptgSlotID = adSlot.getPtgSlotID();
        String reqId = adSlot.getReqId();
        boolean zIsCountdownVisibility = adSlot.isCountdownVisibility();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str_a = _a1._a("2");
        deviceInfo.getClass();
        linkedHashMap.put(str_a, "client");
        String str_a2 = _a1._a("3");
        if (TextUtils.isEmpty(deviceInfo._z)) {
            ArrayList arrayList = _cb._b;
            str_c = _nw._c;
            if (TextUtils.isEmpty(str_c)) {
                str_c = _jw._c(PtgAdSdk.getContext(), "ptg_ua");
                Context context = PtgAdSdk.getContext();
                if (context != null && _nw._b.get() <= 3 && _nw._a.compareAndSet(false, true)) {
                    com.kc.aw.lib.utils._d._b(new _nv(context, null));
                } else {
                    _nw._a(null, "");
                }
            }
            if (TextUtils.isEmpty(str_c)) {
                str_c = "";
            }
            deviceInfo._z = str_c;
        } else {
            str_c = deviceInfo._z;
        }
        linkedHashMap.put(str_a2, str_c);
        linkedHashMap.put(_a1._a("4"), String.valueOf(deviceInfo._y));
        linkedHashMap.put(_a1._a("5"), "1");
        linkedHashMap.put(_a1._a("6"), "icon,mp4,img,video-icon");
        String str_a3 = _a1._a("7");
        _c9 _c9Var = _cc._a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceIdType.OAID, deviceInfo._a);
            jSONObject.put(DeviceIdType.GAID, deviceInfo._b);
            jSONObject.put(DeviceIdType.IMEI, deviceInfo._c);
            jSONObject.put("android_id", deviceInfo._d);
            jSONObject.put("mac", deviceInfo._e);
            jSONObject.put("vendor", deviceInfo._f);
            jSONObject.put(ze1.k, deviceInfo._g);
            jSONObject.put("os", deviceInfo._h);
            jSONObject.put("os_version", deviceInfo._i);
            jSONObject.put("network", deviceInfo._j);
            jSONObject.put("operator", deviceInfo._k);
            jSONObject.put("operator_code", deviceInfo._l);
            jSONObject.put("width", deviceInfo._n);
            jSONObject.put("height", deviceInfo._o);
            _dz _dzVar = deviceInfo._m;
            if (_dzVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                str = "";
                try {
                    jSONObject2.put("lat", _dzVar._a);
                    str2 = reqId;
                    z = zIsCountdownVisibility;
                    try {
                        jSONObject2.put("lng", _dzVar._b);
                        jSONObject2.put("timestamp", _dzVar._c);
                        jSONObject.put("gps", jSONObject2);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str2 = reqId;
                    z = zIsCountdownVisibility;
                }
            } else {
                z = zIsCountdownVisibility;
                str = "";
                str2 = reqId;
            }
            jSONObject.put("boot_mark", deviceInfo._u);
            jSONObject.put("update_mark", deviceInfo._v);
            jSONObject.put("vercode_of_hms", deviceInfo._w);
            jSONObject.put("vercode_of_ag", deviceInfo._x);
            jSONObject.put("hajs", com.kc.aw.lib.utils._a._b());
        } catch (Exception unused3) {
            z = zIsCountdownVisibility;
            str = "";
            str2 = reqId;
        }
        linkedHashMap.put(str_a3, jSONObject.toString());
        linkedHashMap.put(_a1._a(PrepareException.ERROR_AUTH_FAIL), codeId);
        linkedHashMap.put(_a1._a("9"), String.valueOf(stype));
        linkedHashMap.put(_a1._a("10"), deviceInfo._q);
        linkedHashMap.put(_a1._a("11"), deviceInfo._p);
        linkedHashMap.put(_a1._a("12"), deviceInfo._r);
        linkedHashMap.put(_a1._a("13"), deviceInfo._s);
        linkedHashMap.put(_a1._a("14"), PtgAdSdk.getConfig().getSdkVersionName());
        linkedHashMap.put(_a1._a("15"), PtgAdSdk.getConfig().getSdkVersionCode());
        String str_a4 = _a1._a(TinyApp.SUB_TYPE_BRAND_ZONE);
        PtgAdSdk.getConfig().getClass();
        linkedHashMap.put(str_a4, String.valueOf(1));
        linkedHashMap.put(_a1._a("17"), deviceInfo._a);
        linkedHashMap.put(_a1._a("18"), deviceInfo._b);
        String str_a5 = _a1._a("19");
        AtomicBoolean atomicBoolean = _o1._a;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("gender", 0);
            jSONObject3.put("age", 0);
            jSONObject3.put("tag", new JSONArray((Collection) _o1._f));
            string = jSONObject3.toString();
        } catch (Exception unused4) {
            string = str;
        }
        linkedHashMap.put(str_a5, string);
        linkedHashMap.put(_a1._a("21"), String.valueOf(basePrice));
        linkedHashMap.put(_a1._a("22"), ptgSlotID);
        linkedHashMap.put(_a1._a("23"), str2);
        String str_a6 = _a1._a("24");
        PtgAdSdk.getConfig().getClass();
        linkedHashMap.put(str_a6, "ss");
        String str_a7 = _a1._a("25");
        PtgAdSdk.getConfig().getClass();
        linkedHashMap.put(str_a7, String.valueOf(_jw._a(PtgAdSdk.getContext())));
        linkedHashMap.put(_a1._a("26"), String.valueOf(deviceInfo._B));
        linkedHashMap.put(_a1._a("27"), String.valueOf(deviceInfo._C));
        linkedHashMap.put(_a1._a("28"), String.valueOf(z));
        linkedHashMap.put(_a1._a("29"), String.valueOf(System.currentTimeMillis()));
        String str_a8 = _a1._a("30");
        Boolean bool = PtgAdSdk.getConfig()._F;
        if (bool != null) {
            iIntValue = bool.booleanValue();
        } else {
            if (com.kc.aw.lib.utils._b._a == null) {
                com.kc.aw.lib.utils._b._a();
            }
            iIntValue = com.kc.aw.lib.utils._b._a.intValue();
        }
        linkedHashMap.put(str_a8, String.valueOf(iIntValue));
        if (8 == stype) {
            linkedHashMap.put(_a1._a("31"), String.valueOf(adSlot.isSelfRender()));
        }
        return linkedHashMap;
    }
}
