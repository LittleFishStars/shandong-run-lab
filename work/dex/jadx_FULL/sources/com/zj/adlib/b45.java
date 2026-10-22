package com.zj.adlib;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Bitmap f15434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15435a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f15436b;
    public final String c;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b45(int i, int i2, String str, String str2, String str3) {
        this.f40675a = i;
        this.b = i2;
        this.f15435a = str;
        this.f15436b = str2;
        this.c = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f15434a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.f15436b;
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.f15435a;
    }

    public int f() {
        return this.f40675a;
    }

    public boolean g() {
        return this.f15434a != null || (this.f15436b.startsWith("data:") && this.f15436b.indexOf("base64,") > 0);
    }

    public void h(@Nullable Bitmap bitmap) {
        this.f15434a = bitmap;
    }
}
