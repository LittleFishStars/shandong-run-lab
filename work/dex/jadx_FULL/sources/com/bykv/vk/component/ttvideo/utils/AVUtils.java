package com.bykv.vk.component.ttvideo.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVUtils {

    public static class ScaleInfo {
        public int h;
        public int w;
        public int x;
        public int y;
    }

    public static final ScaleInfo getScaleInfoFromSize(float f, float f2, float f3, float f4) {
        ScaleInfo scaleInfo = new ScaleInfo();
        float f5 = f / f2;
        scaleInfo.w = (int) f3;
        int i = (int) (f3 / f5);
        scaleInfo.h = i;
        if (i < f4) {
            scaleInfo.h = (int) f4;
            scaleInfo.w = (int) (f5 * f4);
        }
        int i2 = scaleInfo.h;
        int i3 = ((int) (i2 - f4)) >> 1;
        scaleInfo.y = i3;
        int i4 = scaleInfo.w;
        int i5 = ((int) (i4 - f3)) >> 1;
        scaleInfo.x = i5;
        if (i2 > f4) {
            scaleInfo.y = 0 - i3;
        }
        if (i4 > f3) {
            scaleInfo.x = 0 - i5;
        }
        return scaleInfo;
    }
}
