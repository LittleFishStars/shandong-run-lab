package com.byazt.b;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 42})
public class i implements com.byazt.zz.sl {
    @Override // com.byazt.zz.sl
    public int c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strN = com.byazt.w.a.n(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strN)) {
            return 0;
        }
        return strN.hashCode();
    }
}
