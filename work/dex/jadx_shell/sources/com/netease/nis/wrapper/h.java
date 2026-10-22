package com.netease.nis.wrapper;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class h {
    public static String a() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(a.auu.a.c("YRUGCgJc") + Process.myPid() + a.auu.a.c("YQYZAQ0aCys="))));
            String strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return strTrim;
        } catch (Exception e) {
            String str = MyApplication.TAG;
            e.toString();
            return null;
        }
    }

    private static boolean a(Context context) {
        String strA = a();
        return !TextUtils.isEmpty(strA) && strA.equals(context.getPackageName());
    }
}
