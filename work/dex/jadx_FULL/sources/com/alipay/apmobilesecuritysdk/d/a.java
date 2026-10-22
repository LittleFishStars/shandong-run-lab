package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        String strA = com.alipay.sdk.m.d0.a.a(map, "appchannel", "");
        map2 = new HashMap();
        map2.put("AA1", context.getPackageName());
        map2.put("AA2", com.alipay.sdk.m.f0.a.a().a(context));
        map2.put("AA3", "APPSecuritySDK-ALIPAYSDK");
        map2.put("AA4", "3.4.0.202507280853");
        map2.put("AA6", strA);
        return map2;
    }
}
