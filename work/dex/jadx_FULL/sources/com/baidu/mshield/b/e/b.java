package com.baidu.mshield.b.e;

import android.content.Context;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {
    public static NetworkInfo a(Context context) {
        com.baidu.mshield.b.c.a.a("---privacy getActiveNetworkInfo---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.b.a(context).a();
    }
}
