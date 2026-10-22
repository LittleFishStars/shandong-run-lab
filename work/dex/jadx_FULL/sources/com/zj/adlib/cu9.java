package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cu9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41044a = 1380533830;
    public static final int b = 1463899717;
    public static final int c = 1718449184;
    public static final int d = 1684108385;
    public static final int e = 1380333108;
    public static final int f = 1685272116;
    public static final int g = 1;
    public static final int h = 3;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 17;
    public static final int l = 65534;

    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                return 0;
            }
        }
        return gj9.n0(i3);
    }

    public static int b(int i2) {
        if (i2 == 2 || i2 == 3) {
            return 1;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 536870912 || i2 == 805306368) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
