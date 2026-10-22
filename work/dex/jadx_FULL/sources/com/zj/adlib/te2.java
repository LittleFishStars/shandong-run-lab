package com.zj.adlib;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class te2 implements Supplier<ul5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44898a = 256;
    public static final int b = Integer.MAX_VALUE;
    public static final int c = Integer.MAX_VALUE;
    public static final int d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActivityManager f19782a;

    public te2(ActivityManager activityManager) {
        this.f19782a = activityManager;
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ul5 get() {
        return new ul5(b(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public final int b() {
        int iMin = Math.min(this.f19782a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (iMin < 33554432) {
            return 4194304;
        }
        if (iMin < 67108864) {
            return 6291456;
        }
        return iMin / 4;
    }
}
