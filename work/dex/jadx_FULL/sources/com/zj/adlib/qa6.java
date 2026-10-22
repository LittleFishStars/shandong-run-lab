package com.zj.adlib;

import com.huachenjie.common.util.open.OpenThirdApp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class qa6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qa6 f44163a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19040a = "OpenThirdAppUtil";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OpenThirdApp f19041a;

    public static qa6 a() {
        qa6 qa6Var;
        synchronized (qa6.class) {
            if (f44163a == null) {
                f44163a = new qa6();
            }
            qa6Var = f44163a;
        }
        return qa6Var;
    }

    public OpenThirdApp b() {
        return this.f19041a;
    }

    public void c(OpenThirdApp openThirdApp) {
        this.f19041a = openThirdApp;
    }
}
