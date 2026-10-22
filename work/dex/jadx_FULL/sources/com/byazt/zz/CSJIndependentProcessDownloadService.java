package com.byazt.zz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME})
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.byazt.zz.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ve.c(this);
        if (ve.pu() == null) {
            ve.c(new qy());
        }
        z zVarP = ve.p();
        this.c = zVarP;
        zVarP.c(new WeakReference(this));
    }
}
