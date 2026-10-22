package com.alibaba.triver.basic.a;

import android.content.Intent;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.sdk.m.y.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24674a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public b(Intent intent) {
        try {
            this.f24674a = intent.getStringExtra(o.f25542a);
            this.b = intent.getStringExtra(o.b);
            this.c = intent.getStringExtra("result");
            this.d = intent.getStringExtra("openTime");
            this.g = intent.getStringExtra("extendInfo");
            this.e = "{\"result\":\"" + this.c + "\",\"memo\":\"" + this.b + "\",\",\"code\":\"" + this.f24674a + "\"}";
        } catch (Exception e) {
            RVLogger.w(b.class.getSimpleName(), "Result parse error!=" + e.getMessage());
        }
    }
}
