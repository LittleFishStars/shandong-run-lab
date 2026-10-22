package com.zj.adlib;

import android.media.AudioManager;
import android.os.Build;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rs9 {
    public static int a(int i) {
        return ((AudioManager) Utils.a().getSystemService("audio")).getStreamMaxVolume(i);
    }

    public static int b(int i) {
        AudioManager audioManager = (AudioManager) Utils.a().getSystemService("audio");
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager.getStreamMinVolume(i);
        }
        return 0;
    }

    public static int c(int i) {
        return ((AudioManager) Utils.a().getSystemService("audio")).getStreamVolume(i);
    }

    public static void d(int i, int i2, int i3) {
        try {
            ((AudioManager) Utils.a().getSystemService("audio")).setStreamVolume(i, i2, i3);
        } catch (SecurityException unused) {
        }
    }
}
