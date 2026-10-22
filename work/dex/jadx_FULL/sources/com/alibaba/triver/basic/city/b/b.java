package com.alibaba.triver.basic.city.b;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24706a;
    private String b;
    private String c;
    private String d;

    public b(String str, String str2, String str3, String str4) {
        this.f24706a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String a() {
        if (TextUtils.isEmpty(this.c)) {
            return "#";
        }
        String strSubstring = this.c.substring(0, 1);
        if (Pattern.compile("[a-zA-Z]").matcher(strSubstring).matches()) {
            return strSubstring.toUpperCase();
        }
        return (TextUtils.equals(strSubstring, "定") || TextUtils.equals(strSubstring, "热")) ? this.c : "#";
    }

    public String b() {
        return this.f24706a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void a(String str) {
        this.f24706a = str;
    }
}
