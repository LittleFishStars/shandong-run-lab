package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.dw.core.safe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdVideoTextureView f39192a;

    public g(SsdVideoTextureView ssdVideoTextureView) {
        this.f39192a = ssdVideoTextureView;
    }

    @Override // com.kc.dw.core.safe.e
    public void a(MediaPlayer mediaPlayer) {
        MediaPlayer.OnCompletionListener onCompletionListener = this.f39192a.g;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }
}
