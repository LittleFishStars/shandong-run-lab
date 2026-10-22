package com.kwad.sdk.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class bo {
    protected final int mHeight;
    protected final int mWidth;

    public bo(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final float Ww() {
        return this.mWidth;
    }

    public final float Wx() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bo) {
            bo boVar = (bo) obj;
            if (this.mWidth == boVar.mWidth && this.mHeight == boVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
