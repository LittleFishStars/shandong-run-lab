package com.autonavi.base.amap.mapcore;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i) {
        this.colorIndex = i;
    }

    public FPoint3(float f, float f2, int i) {
        super(f, f2);
        this.colorIndex = i;
    }
}
