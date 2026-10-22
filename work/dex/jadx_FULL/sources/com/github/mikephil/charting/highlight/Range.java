package com.github.mikephil.charting.highlight;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Range {
    public float from;
    public float to;

    public Range(float f, float f2) {
        this.from = f;
        this.to = f2;
    }

    public boolean contains(float f) {
        return f > this.from && f <= this.to;
    }

    public boolean isLarger(float f) {
        return f > this.to;
    }

    public boolean isSmaller(float f) {
        return f < this.from;
    }
}
