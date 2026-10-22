package com.kwad.framework.filedownloader.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static boolean cX(int i) {
        return i < 0;
    }

    public static boolean cY(int i) {
        return i > 0;
    }

    public static boolean f(com.kwad.framework.filedownloader.a aVar) {
        return aVar.AH() == 0 || aVar.AH() == 3;
    }

    public static boolean x(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || cX(i)) {
            return false;
        }
        if (i > 0 && i <= 6 && i2 >= 10 && i2 <= 11) {
            return false;
        }
        if (i == 1) {
            return i2 != 0;
        }
        if (i == 2) {
            return (i2 == 0 || i2 == 1 || i2 == 6) ? false : true;
        }
        if (i == 3) {
            return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) ? false : true;
        }
        if (i == 5) {
            return (i2 == 1 || i2 == 6) ? false : true;
        }
        if (i != 6) {
            return true;
        }
        return (i2 == 0 || i2 == 1) ? false : true;
    }

    public static boolean y(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || cX(i)) {
            return false;
        }
        if (i2 == -2 || i2 == -1) {
            return true;
        }
        if (i == 0) {
            return i2 == 10;
        }
        if (i == 1) {
            return i2 == 6;
        }
        if (i == 2 || i == 3) {
            return i2 == -3 || i2 == 3 || i2 == 5;
        }
        if (i == 5 || i == 6) {
            return i2 == 2 || i2 == 5;
        }
        if (i == 10) {
            return i2 == 11;
        }
        if (i != 11) {
            return false;
        }
        return i2 == -4 || i2 == -3 || i2 == 1;
    }
}
