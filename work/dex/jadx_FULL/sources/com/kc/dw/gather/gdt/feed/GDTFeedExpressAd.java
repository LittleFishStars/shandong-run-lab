package com.kc.dw.gather.gdt.feed;

import android.app.Activity;
import android.view.View;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.nativ.NativeExpressADView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTFeedExpressAd extends MsCustomRecyclerExpressAd {
    private final NativeExpressADView nativeExpressADView;

    public GDTFeedExpressAd(NativeExpressADView nativeExpressADView) {
        this.nativeExpressADView = nativeExpressADView;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        return this.nativeExpressADView;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        NativeExpressADView nativeExpressADView = this.nativeExpressADView;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }
}
