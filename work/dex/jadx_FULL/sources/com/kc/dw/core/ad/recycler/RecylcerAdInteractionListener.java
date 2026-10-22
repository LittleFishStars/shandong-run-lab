package com.kc.dw.core.ad.recycler;

import com.kc.dw.core.loader.InteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RecylcerAdInteractionListener extends InteractionListener {
    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdClosed();

    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdExposure();

    void onAdRenderFailed();
}
