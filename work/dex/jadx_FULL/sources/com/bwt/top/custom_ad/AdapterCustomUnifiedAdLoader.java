package com.bwt.top.custom_ad;

import android.content.Context;
import android.view.View;
import com.bwt.top.UnifiedAD;
import com.bwt.top.UnifiedADContainer;
import com.bwt.top.UnifiedADListener;
import com.bwt.top.ad.adapter.AdapterCustomAdLoader;
import com.bwt.top.ad.bean.UnifiedAdInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdapterCustomUnifiedAdLoader extends AdapterCustomAdLoader<UnifiedAdInfo, UnifiedADListener, UnifiedAD> {
    private CustomUnifiedAdInfo mAdInfo;

    public class AdClickListener implements View.OnClickListener {
        private AdClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdapterCustomUnifiedAdLoader.this.adClick();
        }
    }

    public void bindAdView(Context context, final UnifiedADContainer unifiedADContainer, List<View> list, List<View> list2) {
        if (this.mIsReleased || this.mAdObject == null || unifiedADContainer == null) {
            return;
        }
        if (list != null && list.size() > 0) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(new AdClickListener());
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (View view2 : list2) {
                if (view2 != null) {
                    view2.setOnClickListener(new AdClickListener());
                }
            }
        }
        unifiedADContainer.setOnClickListener(new AdClickListener());
        unifiedADContainer.postDelayed(new Runnable() { // from class: com.bwt.top.custom_ad.AdapterCustomUnifiedAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                if (unifiedADContainer.getChangeCount() > 0 || unifiedADContainer.isRectVisible()) {
                    AdapterCustomUnifiedAdLoader.this.onAdExposeListener();
                }
            }
        }, 400L);
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public UnifiedAdInfo createAdInfo() {
        CustomUnifiedAdInfo customUnifiedAdInfo = new CustomUnifiedAdInfo(this.mPosInfo, this) { // from class: com.bwt.top.custom_ad.AdapterCustomUnifiedAdLoader.1
            @Override // com.bwt.top.ad.bean.UnifiedAdInfo
            public void bindAdToView(Context context, UnifiedADContainer unifiedADContainer, List<View> list, List<View> list2) {
                AdapterCustomUnifiedAdLoader.this.bindAdView(context, unifiedADContainer, list, null);
            }
        };
        this.mAdInfo = customUnifiedAdInfo;
        return customUnifiedAdInfo;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        CustomUnifiedAdInfo customUnifiedAdInfo = this.mAdInfo;
        if (customUnifiedAdInfo != null) {
            customUnifiedAdInfo.setAdObject(this.mAdObject);
        }
        T t = this.mAd;
        if (t == 0 || ((UnifiedAD) t).getAdListener() == null) {
            return;
        }
        ((UnifiedAD) this.mAd).getAdListener().onADLoaded((UnifiedAdInfo) getAdInfo());
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void skipH5Listener(String str) {
        super.skipH5Listener(str);
        T t = this.mAd;
        if (t == 0 || ((UnifiedAD) t).getAdListener() == null) {
            return;
        }
        ((UnifiedAD) this.mAd).getAdListener().onAdClick((UnifiedAdInfo) getAdInfo(), str);
    }
}
