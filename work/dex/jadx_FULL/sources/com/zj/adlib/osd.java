package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class osd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f18719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18720a;
    public final String b;

    public osd(String str, @Nullable String str2, boolean z, int i, boolean z2) {
        this.b = str;
        this.f18719a = str2;
        this.f43829a = i;
        this.f18720a = z2;
    }

    public final int a() {
        return this.f43829a;
    }

    public final String b() {
        return this.b;
    }

    @Nullable
    public final String c() {
        return this.f18719a;
    }

    public final boolean d() {
        return this.f18720a;
    }
}
