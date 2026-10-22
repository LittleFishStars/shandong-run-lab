package com.kc.dw.core.ad.fullscreenvideo;

import android.app.Activity;
import com.kc.dw.core.ad.IAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IFullScreenVideoAd extends IAd {
    void render();

    void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener);

    void showAd(Activity activity);
}
