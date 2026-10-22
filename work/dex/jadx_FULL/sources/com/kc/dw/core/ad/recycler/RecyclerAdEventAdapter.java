package com.kc.dw.core.ad.recycler;

import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.AdErrorInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RecyclerAdEventAdapter implements RecyclerAdEventAdapterListener {
    private RecyclerAdEventListener adEventListener;
    private RecyclerAdLoadListener adLoadListener;

    public RecyclerAdEventAdapter(RecyclerAdEventListener recyclerAdEventListener) {
        this.adEventListener = recyclerAdEventListener;
    }

    public RecyclerAdEventAdapter(RecyclerAdLoadListener recyclerAdLoadListener) {
        this.adLoadListener = recyclerAdLoadListener;
    }

    @Override // com.kc.dw.core.ad.IAdEventListener
    public void onAdFail(List<RecyclerAdData> list, AdError adError, int i) {
    }

    @Override // com.kc.dw.core.ad.IAdEventListener
    public void onLoadFail(AdError adError) {
        RecyclerAdLoadListener recyclerAdLoadListener = this.adLoadListener;
        if (recyclerAdLoadListener != null) {
            recyclerAdLoadListener.onLoadFail(adError);
        }
        RecyclerAdEventListener recyclerAdEventListener = this.adEventListener;
        if (recyclerAdEventListener != null) {
            recyclerAdEventListener.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, adError.getCode(), adError.getMessage()));
        }
    }

    @Override // com.kc.dw.core.ad.IAdEventListener
    public void onLoadSuccess(List<RecyclerAdData> list) {
        RecyclerAdLoadListener recyclerAdLoadListener = this.adLoadListener;
        if (recyclerAdLoadListener != null) {
            recyclerAdLoadListener.onLoadedSuccess(list);
        }
        RecyclerAdEventListener recyclerAdEventListener = this.adEventListener;
        if (recyclerAdEventListener != null) {
            recyclerAdEventListener.onAdReady(list);
        }
    }

    @Override // com.kc.dw.core.ad.IAdEventListener
    public void onRenderSuccess(List<RecyclerAdData> list) {
    }
}
