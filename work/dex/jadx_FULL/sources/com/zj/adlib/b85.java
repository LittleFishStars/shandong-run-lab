package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b85 {
    public static final String b = "\r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f40696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15461a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float f15462b;

    public b85(String str, float f, float f2) {
        this.f15461a = str;
        this.f15462b = f2;
        this.f40696a = f;
    }

    public float a() {
        return this.f15462b;
    }

    public String b() {
        return this.f15461a;
    }

    public float c() {
        return this.f40696a;
    }

    public boolean d(String str) {
        if (this.f15461a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f15461a.endsWith(b)) {
            String str2 = this.f15461a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
