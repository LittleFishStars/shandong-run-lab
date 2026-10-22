package com.zj.adlib;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class fr2 {
    public static final int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41737a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16601a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f16600a = null;
    public int b = -1;
    public int c = -1;

    public void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        int i = this.f41737a;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (this.f16601a) {
            drawable.setColorFilter(this.f16600a);
        }
        int i2 = this.b;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = this.c;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    public void b(int i) {
        this.f41737a = i;
    }

    public void c(ColorFilter colorFilter) {
        this.f16600a = colorFilter;
        this.f16601a = true;
    }

    public void d(boolean z) {
        this.b = z ? 1 : 0;
    }

    public void e(boolean z) {
        this.c = z ? 1 : 0;
    }
}
