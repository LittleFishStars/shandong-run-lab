package com.baidu.mshield.core;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26710a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        try {
            char[] charArray = f26710a.toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
            }
            return new String(cArr).getBytes();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return new byte[0];
        }
    }
}
