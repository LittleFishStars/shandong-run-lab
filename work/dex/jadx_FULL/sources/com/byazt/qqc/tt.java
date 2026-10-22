package com.byazt.qqc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, 13})
public class tt {
    public static boolean c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        int i = calendar.get(7);
        return i == 1 || i == 7;
    }

    public static boolean tt() {
        return Calendar.getInstance().get(11) >= 18;
    }

    public static boolean ve() {
        int i = Calendar.getInstance().get(11);
        return i >= 6 && i < 18;
    }
}
