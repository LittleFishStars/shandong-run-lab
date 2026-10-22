package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"ParcelCreator"})
public class BubbleEntry extends Entry {
    private float mSize;

    public BubbleEntry(float f, float f2, float f3) {
        super(f, f2);
        this.mSize = f3;
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f) {
        this.mSize = f;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.mSize, getData());
    }

    public BubbleEntry(float f, float f2, float f3, Object obj) {
        super(f, f2, obj);
        this.mSize = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable) {
        super(f, f2, drawable);
        this.mSize = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
        this.mSize = f3;
    }
}
