package com.zj.adlib;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class sd6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44666a = 48000;
    public static final int b = 3840;
    public static final int c = 3;

    public static List<byte[]> a(byte[] bArr) {
        long jE = e(d(bArr));
        long jE2 = e(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(jE));
        arrayList.add(b(jE2));
        return arrayList;
    }

    public static byte[] b(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int d(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static long e(long j) {
        return (j * 1000000000) / jk7.c;
    }
}
