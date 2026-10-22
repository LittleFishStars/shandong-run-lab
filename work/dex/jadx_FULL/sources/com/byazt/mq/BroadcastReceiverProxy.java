package com.byazt.mq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.th.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 1545})
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (tt.c().c(hashCode())) {
            tt.c().c(context, intent);
        } else {
            n.ve(new Runnable() { // from class: com.byazt.mq.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    tt.c().c(context, intent);
                }
            });
        }
    }
}
