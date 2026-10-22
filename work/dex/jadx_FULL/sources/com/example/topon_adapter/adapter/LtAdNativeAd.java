package com.example.topon_adapter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.example.topon_adapter.views.CustomDrawAdHolder;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdNativeAd extends CustomNativeAd {
    private Context context;
    private LTDrawAd ltDrawAd;

    public LtAdNativeAd(Context context, LTDrawAd lTDrawAd) {
        this.context = context;
        this.ltDrawAd = lTDrawAd;
    }

    public void clear(View view) {
        super.clear(view);
    }

    public void destroy() {
        super.destroy();
    }

    public View getAdMediaView(Object... objArr) {
        return super.getAdMediaView(objArr);
    }

    public ViewGroup getCustomAdContainer() {
        return super.getCustomAdContainer();
    }

    public String getDescriptionText() {
        LTDrawAd lTDrawAd = this.ltDrawAd;
        return (lTDrawAd == null || lTDrawAd.isExpress() || this.ltDrawAd.getDrawAdDataSource() == null) ? super.getDescriptionText() : this.ltDrawAd.getDrawAdDataSource().getDesc();
    }

    public String getIconImageUrl() {
        LTDrawAd lTDrawAd = this.ltDrawAd;
        return (lTDrawAd == null || lTDrawAd.isExpress() || this.ltDrawAd.getDrawAdDataSource() == null) ? super.getIconImageUrl() : this.ltDrawAd.getDrawAdDataSource().getIconUrl();
    }

    public String getMainImageUrl() {
        LTDrawAd lTDrawAd = this.ltDrawAd;
        return (lTDrawAd == null || lTDrawAd.isExpress() || this.ltDrawAd.getDrawAdDataSource() == null) ? super.getMainImageUrl() : this.ltDrawAd.getDrawAdDataSource().getImageUrl();
    }

    public String getTitle() {
        LTDrawAd lTDrawAd = this.ltDrawAd;
        return (lTDrawAd == null || lTDrawAd.isExpress() || this.ltDrawAd.getDrawAdDataSource() == null) ? super.getTitle() : this.ltDrawAd.getDrawAdDataSource().getTitle();
    }

    public boolean isNativeExpress() {
        LTDrawAd lTDrawAd = this.ltDrawAd;
        return lTDrawAd != null && lTDrawAd.isExpress();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        super.prepare(view, aTNativePrepareInfo);
        this.ltDrawAd.setLTAdEventListener(new LTAdDrawNativeEventListener() { // from class: com.example.topon_adapter.adapter.LtAdNativeAd.1
            public void onAdClicked() {
                LtAdNativeAd.this.notifyAdClicked();
            }

            public void onAdRenderFail(int i, String str) {
            }

            public void onAdShow() {
                LtAdNativeAd.this.notifyAdImpression();
            }

            public void onClosed() {
                LtAdNativeAd.this.notifyAdDislikeClick();
            }
        });
        if (this.ltDrawAd.isExpress()) {
            this.ltDrawAd.showAd((ATNativeAdView) view);
        } else {
            ATNativeAdView aTNativeAdView = (ATNativeAdView) view;
            this.ltDrawAd.setExpressViewHolder(new CustomDrawAdHolder(aTNativeAdView.getContext(), new FrameLayout(aTNativeAdView.getContext()), this.ltDrawAd.getDrawAdDataSource(), aTNativePrepareInfo));
            this.ltDrawAd.showAd(aTNativeAdView);
        }
    }

    public void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams) {
        super.registerListener(view, list, layoutParams);
    }

    public void registerListener(View view, ATNativeAdInfo.AdPrepareInfo adPrepareInfo) {
        super.registerListener(view, adPrepareInfo);
    }
}
