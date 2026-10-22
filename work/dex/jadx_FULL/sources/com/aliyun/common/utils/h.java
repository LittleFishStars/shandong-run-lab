package com.aliyun.common.utils;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char f25579a;

    static {
        Character.toString('.');
        f25579a = File.separatorChar;
        a();
    }

    public static boolean a() {
        return f25579a == '\\';
    }
}
