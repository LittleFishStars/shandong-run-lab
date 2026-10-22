package com.zj.adlib;

import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class nk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f43542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final double f18427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<j88> f18429a;
    public final double b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f18430b;

    public nk3(List<j88> list, char c, double d, double d2, String str, String str2) {
        this.f18429a = list;
        this.f43542a = c;
        this.f18427a = d;
        this.b = d2;
        this.f18428a = str;
        this.f18430b = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j88> a() {
        return this.f18429a;
    }

    public double b() {
        return this.b;
    }

    public int hashCode() {
        return c(this.f43542a, this.f18430b, this.f18428a);
    }
}
