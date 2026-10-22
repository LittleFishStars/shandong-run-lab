package com.kc.aw;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.cea.a;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kt {
    public static byte[] _a = {a.e, 12, 82};

    public static String _a(String str, String str2, String str3) {
        return (str3 == null || str3.trim().isEmpty()) ? str : str.replaceAll(str2, com.kc.aw.lib.utils._a._b(str3));
    }

    public static String _a(Map<String, String> map, AdSlot adSlot) {
        _a6 _a6Var;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("env", Integer.valueOf(com.kc.aw.lib.utils._a._a()));
            if (adSlot != null) {
                jSONObject.putOpt("ct", Integer.valueOf(adSlot.getCt()));
                _nr trackingData = adSlot.getTrackingData();
                if (trackingData != null) {
                    _nq _nqVar = trackingData._t;
                    if (_nqVar != null) {
                        jSONObject.putOpt("appVersion", _nqVar._a("appVersion"));
                        jSONObject.putOpt("appVersionCode", _nqVar._a("appVersionCode"));
                        jSONObject.putOpt("mpSdkVersion", _nqVar._a("sdkVersion"));
                        jSONObject.putOpt("mpSdkVersionName", _nqVar._a("sdkVersionName"));
                    }
                    jSONObject.putOpt("pkgName", (!TextUtils.isEmpty(trackingData._m) || (_a6Var = trackingData._e) == null || TextUtils.isEmpty(_a6Var._d)) ? trackingData._m : trackingData._e._d);
                }
            }
            jSONObject.putOpt("cpSx", map.get("__HW_SLOT_SCREEN_X__"));
            jSONObject.putOpt("cpSy", map.get("__HW_SLOT_SCREEN_Y__"));
            jSONObject.putOpt("cpW", map.get("__HW_W__"));
            jSONObject.putOpt("cpH", map.get("__HW_H__"));
            jSONObject.putOpt("cpDx", map.get("__HW_DOWN_X__"));
            jSONObject.putOpt("cpDy", map.get("__HW_DOWN_Y__"));
            jSONObject.putOpt("cpUx", map.get("__HW_UP_X__"));
            jSONObject.putOpt("cpUy", map.get("__HW_UP_Y__"));
            jSONObject.putOpt("cpDt", map.get("__HW_DOWN_TIME__"));
            jSONObject.putOpt("cpUt", map.get("__HW_UP_TIME__"));
            jSONObject.putOpt("cpAX", map.get("__MP_X_MAX_ACC__"));
            jSONObject.putOpt("cpAY", map.get("__MP_Y_MAX_ACC__"));
            jSONObject.putOpt("cpAZ", map.get("__MP_Z_MAX_ACC__"));
            jSONObject.putOpt("st", map.get("__MP_SPEED_ACC__"));
            jSONObject.putOpt("sd", map.get("__MP_DEGREE__"));
            jSONObject.putOpt("enh", map.get("__MP_ENH__"));
            jSONObject.putOpt("enhRea", map.get("__MP_ENH_REA__"));
            jSONObject.putOpt("enhC", map.get("__MP_ENH_C__"));
            jSONObject.putOpt("enhCRea", map.get("__MP_ENH_C_REA__"));
            jSONObject.putOpt("expCt", map.get("__MP_ENH_EXP_CT__"));
            jSONObject.putOpt("iRm", map.get("iReportM"));
            return com.kc.aw.lib.utils._a._a(jSONObject.toString(), _nj._a());
        } catch (Exception unused) {
            return "";
        }
    }
}
