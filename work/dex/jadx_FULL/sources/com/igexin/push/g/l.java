package com.igexin.push.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class l {
    public static Bitmap a(String str) {
        if (str != null) {
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                if (bitmapDecodeFile != null) {
                    return bitmapDecodeFile;
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        return null;
    }
}
