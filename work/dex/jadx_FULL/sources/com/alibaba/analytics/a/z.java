package com.alibaba.analytics.a;

import android.content.Context;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z {
    public static String D() {
        try {
            long jCurrentTimeMillis = j.isDebug() ? System.currentTimeMillis() : 0L;
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            Object objInvoke = cls.getMethod("getInterface", Class.class).invoke(cls.getMethod("getInstance", Context.class).invoke(null, com.alibaba.analytics.core.d.a().getContext()), ISecurityBodyComponent.class);
            Class<?> cls2 = Class.forName("com.alibaba.wireless.security.open.securitybody.SecurityBodyDefine");
            int i = cls2.getField("OPEN_SECURITYBODY_FLAG_FORMAT_MINI").getInt(cls2);
            int i2 = cls2.getField("OPEN_SECURITYBODY_ENV_ONLINE").getInt(cls2);
            j.d("OPEN_SECURITYBODY_FLAG_FORMAT_MINI:" + i, new Object[0]);
            j.d("OPEN_SECURITYBODY_ENV_ONLINE:" + i2, new Object[0]);
            Class cls3 = Integer.TYPE;
            String str = (String) ISecurityBodyComponent.class.getMethod("getSecurityBodyDataEx", String.class, String.class, String.class, HashMap.class, cls3, cls3).invoke(objInvoke, null, null, null, null, Integer.valueOf(i), Integer.valueOf(i2));
            if (j.isDebug()) {
                j.d("Mini Wua: " + str + ",waste time:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            }
            return str;
        } catch (Throwable th) {
            j.d("", th.toString());
            return null;
        }
    }
}
