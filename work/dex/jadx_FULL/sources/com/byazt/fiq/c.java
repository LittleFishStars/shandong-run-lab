package com.byazt.fiq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, 20})
public class c {
    public ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();

    private String tt(String str, String str2) {
        return (str == null || !this.c.containsKey(str)) ? str2 : (String) this.c.get(str);
    }

    public void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.c.put(str, str2);
    }

    public String c(String str) {
        return tt(str, "");
    }

    public void c(String str, int i) {
        if (str != null) {
            this.c.put(str, Integer.valueOf(i));
        }
    }

    public int tt(String str) {
        return tt(str, 0);
    }

    private int tt(String str, int i) {
        return (str == null || !this.c.containsKey(str)) ? i : ((Integer) this.c.get(str)).intValue();
    }
}
