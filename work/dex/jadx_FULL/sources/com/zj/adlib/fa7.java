package com.zj.adlib;

import com.huachenjie.base.view.danmuku.control.speed.SpeedController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class fa7 implements SpeedController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41634a = 1000;
    public static float b = 3.5f;
    public static float c = 8.5f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f16502a;

    @Override // com.huachenjie.base.view.danmuku.control.speed.SpeedController
    public float a() {
        return c;
    }

    @Override // com.huachenjie.base.view.danmuku.control.speed.SpeedController
    public void b(int width) {
        this.f16502a = width;
    }

    @Override // com.huachenjie.base.view.danmuku.control.speed.SpeedController
    public float c() {
        return b;
    }

    @Override // com.huachenjie.base.view.danmuku.control.speed.SpeedController
    public float getSpeed() {
        double dRandom = Math.random();
        float f = b;
        float f2 = c;
        return ((float) (((dRandom * ((double) (f - f2))) + ((double) f2)) / 1000.0d)) * this.f16502a;
    }
}
