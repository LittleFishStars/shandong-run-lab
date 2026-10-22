package com.zj.adlib;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class u69 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45076a = 1296891946;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?> f19983a = u69.class;
    public static final int b = 1229531648;
    public static final int c = 274;
    public static final int d = 3;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45077a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19984a;
        public int b;

        public b() {
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 6) {
            return 90;
        }
        if (i == 8) {
            return 270;
        }
        ad3.B(f19983a, "Unsupported orientation");
        return 0;
    }

    public static int b(InputStream inputStream, int i, boolean z) throws IOException {
        if (i < 10 || gs8.a(inputStream, 2, z) != 3 || gs8.a(inputStream, 4, z) != 1) {
            return 0;
        }
        int iA = gs8.a(inputStream, 2, z);
        gs8.a(inputStream, 2, z);
        return iA;
    }

    public static int c(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        if (i < 14) {
            return 0;
        }
        int iA = gs8.a(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = iA - 1;
            if (iA <= 0 || i3 < 12) {
                break;
            }
            int i5 = i3 - 2;
            if (gs8.a(inputStream, 2, z) == i2) {
                return i5;
            }
            inputStream.skip(10L);
            i3 = i5 - 10;
            iA = i4;
        }
        return 0;
    }

    public static int d(InputStream inputStream, int i) throws IOException {
        b bVar = new b();
        int iE = e(inputStream, i, bVar);
        int i2 = bVar.b - 8;
        if (iE == 0 || i2 > iE) {
            return 0;
        }
        inputStream.skip(i2);
        return b(inputStream, c(inputStream, iE - i2, bVar.f19984a, 274), bVar.f19984a);
    }

    public static int e(InputStream inputStream, int i, b bVar) throws IOException {
        if (i <= 8) {
            return 0;
        }
        int iA = gs8.a(inputStream, 4, false);
        bVar.f45077a = iA;
        int i2 = i - 4;
        if (iA != 1229531648 && iA != 1296891946) {
            ad3.q(f19983a, "Invalid TIFF header");
            return 0;
        }
        boolean z = iA == 1229531648;
        bVar.f19984a = z;
        int iA2 = gs8.a(inputStream, 4, z);
        bVar.b = iA2;
        int i3 = i2 - 4;
        if (iA2 >= 8 && iA2 - 8 <= i3) {
            return i3;
        }
        ad3.q(f19983a, "Invalid offset");
        return 0;
    }
}
