package com.kc.openset.ad.listener;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OSETDrawNativeListener extends OSETBaseListener {
    void onClicked(View view);

    void onRenderSuccess(View view);

    void onShow(View view);

    void onVideoAdComplete(View view);

    void onVideoAdContinuePlay(View view);

    void onVideoAdPaused(View view);

    void onVideoAdStartPlay(View view);
}
