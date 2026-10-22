package com.beizi.fusion;

import android.util.Base64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class g3 {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
