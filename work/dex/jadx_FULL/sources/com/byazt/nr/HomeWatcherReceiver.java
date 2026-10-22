package com.byazt.nr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, SecExceptionCode.SEC_ERROR_LBSRISK_INVALID_PARAM2})
public class HomeWatcherReceiver extends BroadcastReceiver {
    public c c;

    public interface c {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            m.c("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                m.c("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    m.c("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    m.c("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    m.c("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            m.uj("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
