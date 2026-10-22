package com.byazt.vx;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md {
    public static void c(com.byazt.yl.ve veVar, com.byazt.nbs.da daVar, com.byazt.ll.tt ttVar, boolean z) {
        if (veVar == null || !veVar.isMultiBiddingAd()) {
            return;
        }
        if (daVar == null) {
            veVar.setCpm(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        String levelTag = veVar.getLevelTag();
        Map<String, String> mapEo = daVar.eo();
        if (TextUtils.isEmpty(levelTag)) {
            if (z) {
                com.byazt.ng.a.c(daVar, ttVar, veVar, 40061, com.byazt.pp.c.c(40061));
            }
            veVar.setErrorMsg(com.byazt.pp.c.c(40061));
            veVar.setCpm(AudioStats.AUDIO_AMPLITUDE_NONE);
            return;
        }
        if (mapEo == null) {
            if (z) {
                com.byazt.ng.a.c(daVar, ttVar, veVar, 40062, com.byazt.pp.c.c(40062));
            }
            veVar.setErrorMsg(com.byazt.pp.c.c(40062));
            veVar.setCpm(AudioStats.AUDIO_AMPLITUDE_NONE);
            return;
        }
        String str = mapEo.get(levelTag);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                com.byazt.ng.a.c(daVar, ttVar, veVar, 40062, com.byazt.pp.c.c(40062));
            }
            veVar.setCpm(AudioStats.AUDIO_AMPLITUDE_NONE);
        } else {
            try {
                veVar.setCpm(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                veVar.setCpm(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
        }
    }
}
