package com.zj.adlib;

import com.huachenjie.push.interfaces.InternalShareLink;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class jd4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static jd4 f42561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InternalShareLink f17368a;

    public static jd4 a() {
        jd4 jd4Var;
        synchronized (jd4.class) {
            if (f42561a == null) {
                f42561a = new jd4();
            }
            jd4Var = f42561a;
        }
        return jd4Var;
    }

    public InternalShareLink b() {
        return this.f17368a;
    }

    public void c(InternalShareLink shareLink) {
        this.f17368a = shareLink;
    }
}
