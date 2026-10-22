package com.alipay.android.phone.mrpc.core;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e("IOUtil", "", e);
            }
        }
    }
}
