package com.zj.adlib;

import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class kk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Typeface f17717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17718a;
    public final String b;
    public final String c;

    public kk3(String str, String str2, String str3, float f) {
        this.f17718a = str;
        this.b = str2;
        this.c = str3;
        this.f42837a = f;
    }

    public float a() {
        return this.f42837a;
    }

    public String b() {
        return this.f17718a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Nullable
    public Typeface e() {
        return this.f17717a;
    }

    public void f(@Nullable Typeface typeface) {
        this.f17717a = typeface;
    }
}
