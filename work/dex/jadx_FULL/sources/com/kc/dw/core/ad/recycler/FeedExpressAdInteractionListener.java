package com.kc.dw.core.ad.recycler;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface FeedExpressAdInteractionListener extends FeedInteractionListener {
    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdClicked();

    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdClosed();

    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdExposure();

    void onRenderError(int i, String str);

    void onRenderSuccess();
}
