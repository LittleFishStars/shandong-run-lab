package com.alipay.sdk.m.r;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25493a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: com.alipay.sdk.m.r.a$a, reason: collision with other inner class name */
    public static class C0204a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f25494a = "0";
        public static String b = "1";
        public static String c = "2";
    }

    public a(String str, String str2, String str3) {
        this.f25493a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.f25493a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @NonNull
    public String toString() {
        return "updateStrategy: " + this.c + " sha256:" + this.f25493a + " sourceUrl:" + this.b;
    }
}
