package com.amap.api.col.p0003l;

import android.os.Build;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum gh {
    MIUI("xiaomi"),
    Flyme(AssistUtils.BRAND_MZ),
    EMUI(AssistUtils.BRAND_HW),
    ColorOS("oppo"),
    FuntouchOS("vivo"),
    SmartisanOS("smartisan"),
    AmigoOS("amigo"),
    EUI("letv"),
    Sense("htc"),
    LG("lge"),
    Google("google"),
    NubiaUI("nubia"),
    Other("");

    private String n;
    private int o;
    private String p;
    private String q;
    private String r = Build.MANUFACTURER;

    gh(String str) {
        this.n = str;
    }

    public final String a() {
        return this.n;
    }

    public final String b() {
        return this.p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void b(String str) {
        this.q = str;
    }

    public final void a(String str) {
        this.p = str;
    }
}
