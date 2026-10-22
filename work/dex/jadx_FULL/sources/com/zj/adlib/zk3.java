package com.zj.adlib;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46282a = 21522;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f21078a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{AVMDLDataLoader.KeyIsCacheDirListsStr, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte f21079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ErrorCorrectionLevel f21080a;

    public zk3(int i) {
        this.f21080a = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.f21079a = (byte) (i & 7);
    }

    public static zk3 a(int i, int i2) {
        zk3 zk3VarB = b(i, i2);
        return zk3VarB != null ? zk3VarB : b(i ^ 21522, i2 ^ 21522);
    }

    public static zk3 b(int i, int i2) {
        int iE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f21078a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new zk3(iArr[1]);
            }
            int iE2 = e(i, i5);
            if (iE2 < i3) {
                i4 = iArr[1];
                i3 = iE2;
            }
            if (i != i2 && (iE = e(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iE;
            }
        }
        if (i3 <= 3) {
            return new zk3(i4);
        }
        return null;
    }

    public static int e(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public byte c() {
        return this.f21079a;
    }

    public ErrorCorrectionLevel d() {
        return this.f21080a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zk3)) {
            return false;
        }
        zk3 zk3Var = (zk3) obj;
        return this.f21080a == zk3Var.f21080a && this.f21079a == zk3Var.f21079a;
    }

    public int hashCode() {
        return (this.f21080a.ordinal() << 3) | this.f21079a;
    }
}
