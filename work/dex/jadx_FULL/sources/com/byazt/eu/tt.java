package com.byazt.eu;

import com.byazt.nr.m;
import com.byazt.vx.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 13})
public class tt {
    public static boolean c = true;
    public static boolean tt = false;
    public static int ve = 4;

    public static void c(int i) {
        ve = i;
    }

    public static boolean tt() {
        return da.c || tt;
    }

    public static void uj(String str, String str2) {
        if (tt() && str2 != null && ve <= 6) {
            m.uj(str, str2);
        }
    }

    public static void ve(String str, String str2) {
        if (tt() && str2 != null && ve <= 5) {
            m.tt(str, str2);
        }
    }

    public static void c() {
        tt = true;
        c(3);
    }

    public static void tt(String str) {
        if (tt()) {
            tt("Logger", str);
        }
    }

    public static void c(String str) {
        if (tt()) {
            c("Logger", str);
        }
    }

    public static void tt(String str, String str2) {
        if (tt() && str2 != null && ve <= 4) {
            m.c(str, str2);
        }
    }

    public static void ve(String str) {
        if (tt()) {
            uj("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        tt();
    }

    public static void c(String str, String str2, Throwable th) {
        tt();
    }

    public static void tt(String str, String str2, Throwable th) {
        if (tt()) {
            if (!(str2 == null && th == null) && ve <= 6) {
                m.ve(str, str2, th);
            }
        }
    }
}
