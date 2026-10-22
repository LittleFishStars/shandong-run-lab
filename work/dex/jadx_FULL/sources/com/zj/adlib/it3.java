package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class it3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final it3 f42437a = new it3(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);
    public static final it3 b = new it3(1033, 1024, 1);
    public static final it3 c;
    public static final it3 d;
    public static final it3 e;
    public static final it3 f;
    public static final it3 g;
    public static final it3 h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jt3 f17267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f17268a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f17269b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final jt3 f17270b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f17271b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f17272c;

    static {
        it3 it3Var = new it3(67, 64, 1);
        c = it3Var;
        d = new it3(19, 16, 1);
        e = new it3(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        it3 it3Var2 = new it3(301, 256, 1);
        f = it3Var2;
        g = it3Var2;
        h = it3Var;
    }

    public it3(int i, int i2, int i3) {
        this.f17269b = i;
        this.f17266a = i2;
        this.f17272c = i3;
        this.f17268a = new int[i2];
        this.f17271b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f17268a[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f17271b[this.f17268a[i6]] = i6;
        }
        this.f17267a = new jt3(this, new int[]{0});
        this.f17270b = new jt3(this, new int[]{1});
    }

    public static int a(int i, int i2) {
        return i ^ i2;
    }

    public jt3 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f17267a;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new jt3(this, iArr);
    }

    public int c(int i) {
        return this.f17268a[i];
    }

    public int d() {
        return this.f17272c;
    }

    public jt3 e() {
        return this.f17270b;
    }

    public int f() {
        return this.f17266a;
    }

    public jt3 g() {
        return this.f17267a;
    }

    public int h(int i) {
        if (i != 0) {
            return this.f17268a[(this.f17266a - this.f17271b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i) {
        if (i != 0) {
            return this.f17271b[i];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f17268a;
        int[] iArr2 = this.f17271b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f17266a - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f17269b) + ',' + this.f17266a + ')';
    }
}
