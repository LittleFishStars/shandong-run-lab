package com.kc.dw.core.ad.splash;

import com.kc.dw.core.loader.InteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface SplashInteractionListener extends InteractionListener {
    void onSkip();

    void onTick(long j);

    void onTimeOver();
}
