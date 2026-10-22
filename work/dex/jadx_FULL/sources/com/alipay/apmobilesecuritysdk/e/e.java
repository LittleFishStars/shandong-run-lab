package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            strA = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            f fVar = new f();
            fVar.a(jSONObject.getString(DeviceIdType.IMEI));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString("mac"));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }

    public static void a(Context context, f fVar) {
        if (fVar == null || context == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceIdType.IMEI, fVar.a());
            jSONObject.put("imsi", fVar.b());
            jSONObject.put("mac", fVar.c());
            jSONObject.put("bluetoothmac", fVar.d());
            jSONObject.put("gsi", fVar.e());
            String string = jSONObject.toString();
            com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", string);
            com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", string);
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
    }
}
