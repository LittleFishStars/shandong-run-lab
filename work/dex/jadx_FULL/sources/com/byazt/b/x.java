package com.byazt.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.byazt.zz.CSJDownloadService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 71})
public class x extends com.byazt.zz.c {
    public static final String n = "x";

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void c(Intent intent, int i, int i2) {
        if (com.byazt.x.c.c()) {
            com.byazt.x.c.tt(n, "onStartCommand");
        }
        if (!com.byazt.w.c.c(262144)) {
            this.tt = true;
        }
        n();
    }

    @Override // com.byazt.zz.c
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    @Override // com.byazt.zz.c
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.tt = false;
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void ve() {
        if (com.byazt.w.c.c(262144)) {
            this.tt = true;
            this.uj = false;
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.tt(n, "onStartCommandOnMainThread");
            }
        }
    }
}
