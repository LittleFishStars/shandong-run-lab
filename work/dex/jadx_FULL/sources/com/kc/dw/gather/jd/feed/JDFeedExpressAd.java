package com.kc.dw.gather.jd.feed;

import android.app.Activity;
import android.view.View;
import com.jd.ad.sdk.feed.JADFeed;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class JDFeedExpressAd extends MsCustomRecyclerExpressAd {
    private final JADFeed jadFeed;

    public JDFeedExpressAd(JADFeed jADFeed) {
        this.jadFeed = jADFeed;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        return getAdView();
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
    }
}
