package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface d {
    void a();

    void a(MediaPlayer mediaPlayer, boolean z);

    void onPrepareError(int i, String str);

    void onPrepared(MediaPlayer mediaPlayer);

    void onStartDownload();
}
