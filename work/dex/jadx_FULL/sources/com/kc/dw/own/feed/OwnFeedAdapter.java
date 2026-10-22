package com.kc.dw.own.feed;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.ad_adapter.recycler.SsdRecyclerOwnListener;
import com.kc.dw.platform.ad_adapter.recycler.e;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnFeedAdapter extends MsCustomRecyclerAdapter {
    private e aDelegate;
    private final SsdRecyclerOwnListener ownListener = new SsdRecyclerOwnListener(this) { // from class: com.kc.dw.own.feed.OwnFeedAdapter.1
        public final OwnFeedAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(List<FeedAd> list, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(List<FeedAd> list) {
            this.this$0.callLoadedSuccess(list);
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(List<FeedAd> list) {
        }
    };

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        a.a(5, "e2", this);
        e eVar = this.aDelegate;
        if (eVar != null) {
            eVar.setLocalParams(getLocalParams());
            e eVar2 = this.aDelegate;
            eVar2.g = this.ownListener;
            eVar2.loadAd();
        }
    }

    public void setOwnAdDelegate(b bVar) {
        this.aDelegate = (e) bVar;
    }
}
