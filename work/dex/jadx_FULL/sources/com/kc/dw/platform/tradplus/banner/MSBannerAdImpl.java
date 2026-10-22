package com.kc.dw.platform.tradplus.banner;

import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.banner.TPBannerAdImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MSBannerAdImpl extends TPBannerAdImpl {
    private String[] eventUrl;
    private long loadedTime;
    private String posId;
    private boolean reportEventUrl;

    public MSBannerAdImpl(Object obj, View view) {
        super(obj, view);
        this.reportEventUrl = false;
    }

    public MSBannerAdImpl(Object obj, View view, ViewGroup viewGroup) {
        super(obj, view, viewGroup);
        this.reportEventUrl = false;
    }

    private void reportEventUrl() {
        try {
            if (this.reportEventUrl) {
                return;
            }
            View renderView = getRenderView();
            if (renderView != null) {
                try {
                } catch (Exception unused) {
                }
            }
            s1.b(this.eventUrl);
            this.reportEventUrl = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdShown() {
        super/*com.tradplus.ads.base.bean.TPBaseAd*/.setAdShown();
        reportEventUrl();
    }

    public void setMsData(String str, long j, String[] strArr) {
        this.posId = str;
        this.loadedTime = j;
        this.eventUrl = strArr;
    }
}
