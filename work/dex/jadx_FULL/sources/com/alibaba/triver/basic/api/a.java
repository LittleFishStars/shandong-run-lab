package com.alibaba.triver.basic.api;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static volatile a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AMapLocationClient f24686a;

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void b() {
        AMapLocationClient aMapLocationClient = this.f24686a;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }

    public void c() {
        AMapLocationClient aMapLocationClient = this.f24686a;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.f24686a.onDestroy();
            this.f24686a = null;
        }
    }

    public AMapLocationClient a(Context context) {
        if (context != null && this.f24686a == null) {
            this.f24686a = new AMapLocationClient(context);
        }
        return this.f24686a;
    }
}
