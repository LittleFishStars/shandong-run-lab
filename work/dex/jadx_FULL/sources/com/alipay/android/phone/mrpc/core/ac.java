package com.alipay.android.phone.mrpc.core;

import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ac {
    public static boolean a() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }
}
