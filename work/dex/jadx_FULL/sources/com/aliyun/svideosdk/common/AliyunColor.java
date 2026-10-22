package com.aliyun.svideosdk.common;

import android.graphics.Color;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunColor extends AliyunObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25621a;
    private int b;
    private int g;
    private int r;

    public AliyunColor(int i) {
        int i2 = (i >> 24) & 255;
        this.f25621a = i2;
        int i3 = (i >> 16) & 255;
        this.r = i3;
        int i4 = (i >> 8) & 255;
        this.g = i4;
        int i5 = i & 255;
        this.b = i5;
        if ((i3 > 0 || i4 > 0 || i5 > 0) && i2 <= 0) {
            this.f25621a = 255;
        }
    }

    public AliyunColor(int i, int i2, int i3, int i4) {
        this.r = i;
        this.g = i2;
        this.b = i3;
        this.f25621a = i4;
    }

    public void setAlpha(int i) {
        this.f25621a = i;
    }

    public int toArgb() {
        return Color.argb(this.f25621a, this.r, this.g, this.b);
    }
}
