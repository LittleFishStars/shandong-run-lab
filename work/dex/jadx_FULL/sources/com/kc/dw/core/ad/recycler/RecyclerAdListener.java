package com.kc.dw.core.ad.recycler;

import com.kc.dw.core.loader.IAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RecyclerAdListener extends IAdLoadListener<List<FeedAd>> {
    @Override // com.kc.dw.core.loader.IAdLoadListener
    default void onAdExposure() {
    }

    @Override // com.kc.dw.core.loader.IAdLoadListener
    default void onAdRenderFail(String str, int i) {
    }
}
