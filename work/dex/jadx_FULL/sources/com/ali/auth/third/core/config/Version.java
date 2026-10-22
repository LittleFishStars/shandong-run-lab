package com.ali.auth.third.core.config;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Version {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23411a;
    private int b;
    private int c;

    public Version(int i, int i2, int i3) {
        this.f23411a = i;
        this.b = i2;
        this.c = i3;
    }

    public String toString() {
        return this.f23411a + Consts.DOT + this.b + Consts.DOT + this.c;
    }
}
