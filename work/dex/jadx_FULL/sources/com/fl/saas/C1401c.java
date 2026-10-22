package com.fl.saas;

import com.fl.saas.adx.util.CommConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.fl.saas.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1401c extends Y {
    private static volatile C1401c c;

    public static C1401c c() {
        if (c == null) {
            synchronized (C1401c.class) {
                if (c == null) {
                    c = new C1401c();
                }
            }
        }
        return c;
    }

    @Override // com.fl.saas.Y
    public Map b() {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.n.c.m, "4.4");
        map.put("sdkVersion", CommConstant.SdkVersion.SDK_VERSION_CODE);
        return map;
    }
}
