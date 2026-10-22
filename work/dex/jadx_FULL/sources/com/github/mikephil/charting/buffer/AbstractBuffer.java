package com.github.mikephil.charting.buffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected float phaseX = 1.0f;
    protected float phaseY = 1.0f;
    protected int mFrom = 0;
    protected int mTo = 0;
    protected int index = 0;

    public AbstractBuffer(int i) {
        this.buffer = new float[i];
    }

    public abstract void feed(T t);

    public void limitFrom(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mFrom = i;
    }

    public void limitTo(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mTo = i;
    }

    public void reset() {
        this.index = 0;
    }

    public void setPhases(float f, float f2) {
        this.phaseX = f;
        this.phaseY = f2;
    }

    public int size() {
        return this.buffer.length;
    }
}
