package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27356a;
    private final String b;
    private final String c;

    public h6(String str, String str2) {
        this.f27356a = str;
        this.b = str2;
        this.c = a(str);
    }

    private String a(String str) {
        if (str.contains("biz.beizi.adn")) {
            return "AdScope-ASNP";
        }
        return str.contains("xyz.adscope.common") ? "AdScope-Foundation" : "";
    }

    public String b() {
        return this.f27356a;
    }

    public String c() {
        return TextUtils.isEmpty(this.b) ? "" : this.b;
    }

    public String a() {
        return this.c;
    }
}
