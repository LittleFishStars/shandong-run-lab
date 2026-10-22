package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    public static synchronized Map<String, String> a(Context context) {
        HashMap map;
        com.alipay.sdk.m.f0.e eVarA = com.alipay.sdk.m.f0.e.a();
        com.alipay.sdk.m.f0.b bVarA = com.alipay.sdk.m.f0.b.a(APSecuritySdk.getInstance(context));
        map = new HashMap();
        map.put("AE1", eVarA.b());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(eVarA.c() ? "1" : "0");
        map.put("AE2", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(eVarA.a(context) ? "1" : "0");
        map.put("AE3", sb2.toString());
        map.put("AE4", eVarA.d());
        map.put("AE5", eVarA.e());
        map.put("AE6", eVarA.f());
        map.put("AE7", eVarA.g());
        map.put("AE8", eVarA.h());
        map.put("AE9", eVarA.i());
        map.put("AE10", eVarA.j());
        map.put("AE11", eVarA.k());
        map.put("AE12", eVarA.l());
        map.put("AE13", eVarA.m());
        map.put("AE14", eVarA.n());
        map.put("AE15", eVarA.o());
        map.put("AE21", bVarA.f());
        return map;
    }

    public static synchronized Map<String, String> b(Context context) {
        HashMap map;
        map = new HashMap();
        try {
            map.put("AE16", com.alipay.apmobilesecuritysdk.c.c.a(context).a());
        } catch (Throwable unused) {
        }
        return map;
    }
}
