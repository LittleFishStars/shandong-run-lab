package com.byazt.fj;

import android.content.Context;
import android.content.IntentFilter;
import com.byazt.aas.nb;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, 20})
public class c {
    public static volatile c c;
    public String tt = "";

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme("package");
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            context.registerReceiver(miniAppBroadcastReceiver, intentFilter, nb.p(), null);
        } catch (Throwable th) {
            m.uj("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public String tt() {
        return this.tt;
    }

    public void c(String str) {
        this.tt = str;
    }
}
