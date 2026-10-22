package com.byazt.iyp;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 72})
public final class da {
    public static boolean c() {
        return a.c();
    }

    public static void n() {
        c("redetect cache invalid -> clear cached tabs");
    }

    public static void tt() {
        c("bottomBar not found");
    }

    public static void uj() {
        c("redetectSelectedTab start");
    }

    public static void ve() {
        c("install warning: tabs empty");
    }

    public static void c(String str) {
        m.tt("BtTabF", str);
    }

    public static void tt(int i, int i2, String str) {
        c("redetect result index=" + i + " confidence=" + i2 + " reason=" + c((Object) str));
    }

    public static void c(int i) {
        c("selected by history index=" + i);
    }

    public static String tt(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        return "len=" + strTrim.length() + ",hash=" + strTrim.hashCode();
    }

    public static void c(int i, int i2, String str) {
        c("selected by score index=" + i + " confidence=" + i2 + " reason=" + c((Object) str));
    }

    public static void c(int i, String str) {
        c("install success tabs=" + i + " selectedLabel{" + tt(str) + "}");
    }

    private static String c(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }
}
