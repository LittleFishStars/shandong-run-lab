package com.google.zxing;

import com.zj.adlib.dh4;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32492a;
    public final int b;

    public LuminanceSource(int i, int i2) {
        this.f32492a = i;
        this.b = i2;
    }

    public LuminanceSource a(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int b() {
        return this.b;
    }

    public abstract byte[] c();

    public abstract byte[] d(int i, byte[] bArr);

    public final int e() {
        return this.f32492a;
    }

    public LuminanceSource f() {
        return new dh4(this);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public LuminanceSource i() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource j() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        char c;
        int i = this.f32492a;
        byte[] bArrD = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrD = d(i2, bArrD);
            for (int i3 = 0; i3 < this.f32492a; i3++) {
                int i4 = bArrD[i3] & 255;
                if (i4 < 64) {
                    c = '#';
                } else if (i4 < 128) {
                    c = '+';
                } else {
                    c = i4 < 192 ? '.' : ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
