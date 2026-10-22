package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import com.kuaishou.weapon.p0.t;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f29286a;
    public String b;
    public String g;
    public String c = "";
    public String d = "";
    public String e = "";
    public int h = Integer.MIN_VALUE;
    public String f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    public c(a aVar, Context context) {
        this.f29286a = aVar;
    }

    public void a() {
        b();
    }

    public void a(String str) {
        this.b = str;
        this.f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b() {
        Map mapVersionInfo;
        a aVar = this.f29286a;
        if (aVar == null || (mapVersionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.c = (String) mapVersionInfo.get(t.x);
        this.d = (String) mapVersionInfo.get(com.alipay.sdk.m.w.a.v);
        this.e = (String) mapVersionInfo.get("sdk_version");
    }

    public void b(String str) {
    }
}
