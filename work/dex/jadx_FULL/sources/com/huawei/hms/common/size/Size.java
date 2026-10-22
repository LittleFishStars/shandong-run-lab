package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37505a;
    private final int b;

    public Size(int i, int i2) {
        this.f37505a = i;
        this.b = i2;
    }

    public static Size parseSize(String str) {
        try {
            int iIndexOf = str.indexOf("x");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f37505a == size.f37505a && this.b == size.b;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.f37505a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f37505a + " Height is " + this.b;
    }
}
