package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends com.kc.dw.core.safe.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdVideoTextureView f39190a;

    public e(SsdVideoTextureView ssdVideoTextureView) {
        this.f39190a = ssdVideoTextureView;
    }

    @Override // com.kc.dw.core.safe.h
    public void a(MediaPlayer mediaPlayer) {
        SsdVideoTextureView ssdVideoTextureView = this.f39190a;
        ssdVideoTextureView.j = true;
        d dVar = ssdVideoTextureView.e;
        if (dVar != null) {
            dVar.onPrepared(mediaPlayer);
        }
        MediaPlayer.OnPreparedListener onPreparedListener = this.f39190a.c;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(mediaPlayer);
        }
        a aVar = this.f39190a.f;
        if (aVar != null) {
            StringBuilder sbA = com.kc.dw.activity.a.a("onPrepared ");
            sbA.append(aVar.e[0]);
            LogUtil.d("NotifyCacheStateHelper", sbA.toString());
            aVar.c[0] = true;
            aVar.a(mediaPlayer);
            if (aVar.f) {
                return;
            }
            SdkHandler.runOnMainThread(new b(aVar, mediaPlayer));
        }
    }
}
