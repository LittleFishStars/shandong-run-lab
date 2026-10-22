package com.byazt.tf;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1042, 20})
public class c {
    public static int c = 6;
    public static tt tt = C0533c.c();

    /* JADX INFO: renamed from: com.byazt.tf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1042, 44})
    public static final class C0533c extends tt {

        /* JADX INFO: renamed from: com.byazt.tf.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 1042, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO})
        public static class C0534c {
            public static final C0533c c = new C0533c();
        }

        public static C0533c c() {
            return C0534c.c;
        }

        @Override // com.byazt.tf.c.tt
        public void tt(String str, String str2) {
            m.uj(str, str2);
        }

        @Override // com.byazt.tf.c.tt
        public void ve(String str, String str2) {
            m.tt(str, str2);
        }

        private C0533c() {
        }

        @Override // com.byazt.tf.c.tt
        public void c(String str, String str2) {
            m.c(str, str2);
        }

        @Override // com.byazt.tf.c.tt
        public void c(String str, String str2, Throwable th) {
            m.ve(str, str2, th);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1042, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static abstract class tt {
        public void c(String str, String str2) {
        }

        public void c(String str, String str2, Throwable th) {
        }

        public boolean c(int i) {
            return c.c() <= i;
        }

        public void tt(String str, String str2) {
        }

        public void ve(String str, String str2) {
        }
    }

    public static int c() {
        return c;
    }

    public static boolean tt() {
        return c <= 3;
    }

    public static void uj(String str, String str2) {
        if (str2 != null && tt.c(6)) {
            tt.tt(str, str2);
        }
    }

    public static void ve(String str, String str2) {
        if (str2 != null && tt.c(5)) {
            tt.ve(str, str2);
        }
    }

    public static void c(String str) {
        c("Logger", str);
    }

    public static void tt(String str, String str2) {
        if (str2 != null && tt.c(4)) {
            tt.c(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        tt.c(3);
    }

    public static void c(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && tt.c(6)) {
            tt.c(str, str2, th);
        }
    }

    public static void tt(String str) {
        uj("Logger", str);
    }
}
