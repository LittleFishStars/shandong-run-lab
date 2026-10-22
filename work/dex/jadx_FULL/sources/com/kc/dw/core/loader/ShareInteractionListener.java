package com.kc.dw.core.loader;

import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ShareInteractionListener extends InteractionListener, RecylcerAdInteractionListener {
    @Override // com.kc.dw.core.loader.InteractionListener
    void onAdClosed();

    void onShareButtonClicked(ShareInfo shareInfo);
}
