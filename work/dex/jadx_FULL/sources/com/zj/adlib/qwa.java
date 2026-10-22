package com.zj.adlib;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qwa {
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19193a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44316a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f19194b = 20;

    public static void a(boolean z) {
        b = z;
    }

    public static boolean b() {
        return b;
    }

    public static void d(boolean z) {
        c = z;
    }

    public static boolean e() {
        return c;
    }

    public static void f(boolean z) {
        d = z;
    }

    public static boolean g() {
        return d;
    }

    public static void k() {
        a7b.m(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (width / 4.0f); i2 < (width * 3) / 4.0f; i2++) {
                    for (int i3 = (int) (height / 4.0f); i3 < (height * 3) / 4.0f; i3++) {
                        int pixel = bitmap.getPixel(i2, i3);
                        if (i == -1) {
                            i = pixel;
                        }
                        if (pixel != i) {
                            this.f19193a = true;
                            return false;
                        }
                        if (pixel != -16777216) {
                            this.f19193a = true;
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    a7b.m(th, "AMapdelegate", "checkBlackScreen");
                } finally {
                    this.f19193a = true;
                }
            }
        }
        return true;
    }

    public final boolean h() {
        return this.f19193a;
    }

    public final void i() {
        this.f44316a++;
    }

    public final boolean j() {
        return this.f44316a >= this.f19194b;
    }
}
