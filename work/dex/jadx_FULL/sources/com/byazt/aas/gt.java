package com.byazt.aas;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static void c(final Uri uri, final com.byazt.omf.d dVar) {
        if (dVar == null || !dVar.c(uri)) {
            return;
        }
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.gt.1
                @Override // java.lang.Runnable
                public void run() {
                    dVar.tt(uri);
                }
            });
        } catch (Exception e) {
            com.byazt.nr.m.tt("WebView", "TTAndroidObj handleUri exception: ".concat(String.valueOf(e)));
        }
    }

    public static void c(final com.byazt.nl.uj ujVar, final int i, final boolean z) {
        if (ujVar == null) {
            return;
        }
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.aas.gt.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = ujVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/");
                sb.append(i);
                if (z) {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(nb.x());
                }
                ujVar.setUserAgentString(sb.toString());
            }
        });
    }
}
