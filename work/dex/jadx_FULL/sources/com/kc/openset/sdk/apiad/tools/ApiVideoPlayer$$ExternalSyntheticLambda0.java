package com.kc.openset.sdk.apiad.tools;

import android.media.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class ApiVideoPlayer$$ExternalSyntheticLambda0 implements MediaPlayer.OnCompletionListener {
    public final ApiVideoPlayer f$0;
    public final ApiVideoPlayer.ADVPlayerListener f$1;

    static {
        OSETSDKProtected.interface11(4867);
    }

    public /* synthetic */ ApiVideoPlayer$$ExternalSyntheticLambda0(ApiVideoPlayer apiVideoPlayer, ApiVideoPlayer.ADVPlayerListener aDVPlayerListener) {
        this.f$0 = apiVideoPlayer;
        this.f$1 = aDVPlayerListener;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final native void onCompletion(MediaPlayer mediaPlayer);
}
