package com.kc.dw.ad;

import android.view.View;
import android.view.ViewParent;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a0 {

    @Keep
    public interface a {
        void onCompleted();
    }

    @Keep
    public interface b {
        void onKeepTimeFinished();
    }

    @Keep
    public interface c {
    }

    void a(a aVar);

    void a(b bVar, long j);

    boolean a();

    ViewParent getParent();

    View getVideoView();

    void mute();

    void pause();

    void replay();

    void resume();

    void setNativeAdMediaListener(com.kc.dw.ad.nativ.h hVar);

    void setPreparedStartPlayListener(com.kc.dw.ad.nativ.c cVar);

    void setVideoPath(String str);

    void start();

    void unmute();
}
