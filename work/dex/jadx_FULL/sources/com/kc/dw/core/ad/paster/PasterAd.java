package com.kc.dw.core.ad.paster;

import com.kc.dw.ad.nativ.IPreparedListener;
import com.kc.dw.core.ad.IAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PasterAd extends IAd {
    void destroy();

    long getCurrentPosition();

    long getDuration();

    void mute();

    void onPause();

    void onResume();

    void pause();

    void render();

    void replay();

    void resume();

    void setOnPreparedListener(IPreparedListener iPreparedListener);

    void start();

    void unmute();
}
