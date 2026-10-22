package com.ltmb.beiziadapter.unified;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ltmb.ltsdk.core.load.data.DrawAdDataSource;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import java.util.List;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSVideoConfig;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class UnifiedRender extends AMPSBaseTransformEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LTDrawAd f40262a;
    public final DrawAdDataSource b;
    public Activity c;
    public AMPSUnifiedRootContainer d;

    public UnifiedRender(LTDrawAd lTDrawAd, Context context, int i, AMPSVideoConfig aMPSVideoConfig, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
        super(context, i, aMPSVideoConfig, aMPSUnifiedNativeAdapter);
        this.f40262a = lTDrawAd;
        this.b = lTDrawAd.getDrawAdDataSource();
    }

    public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
        super.bindAdToRootContainer(activity, aMPSUnifiedRootContainer, list, list2);
        this.c = activity;
        this.d = aMPSUnifiedRootContainer;
    }

    public AMPSUnifiedPattern getAdPattern() {
        return AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE;
    }

    public String getAppIconUrl() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.appIcon() : super.getAppIconUrl();
    }

    public String getDesc() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.getDesc() : super.getDesc();
    }

    public int getECPM() {
        LTDrawAd lTDrawAd = this.f40262a;
        return lTDrawAd != null ? (int) lTDrawAd.getEcpm() : super.getECPM();
    }

    public int getImageHeight() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.getImageHeight() : super.getImageHeight();
    }

    public int getImageWidth() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.getImageWidth() : super.getImageWidth();
    }

    public String getMainImageUrl() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.getImageUrl() : super.getMainImageUrl();
    }

    public String getTitle() {
        DrawAdDataSource drawAdDataSource = this.b;
        return drawAdDataSource != null ? drawAdDataSource.getTitle() : super.getTitle();
    }

    public boolean isValid() {
        LTDrawAd lTDrawAd = this.f40262a;
        return (lTDrawAd == null || !lTDrawAd.isReady() || this.f40262a.isDestroy()) ? false : true;
    }

    public boolean isViewObject() {
        return false;
    }

    public void render() {
        super.render();
        CustomDrawAdHolder customDrawAdHolder = new CustomDrawAdHolder(this.c, this.d, this.b);
        this.f40262a.setLTAdEventListener(new LTAdDrawNativeEventListener() { // from class: com.ltmb.beiziadapter.unified.UnifiedRender.1
            public void onAdClicked() {
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter.onAdClicked();
                }
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener.onADClicked();
                }
            }

            public void onAdRenderFail(int i, String str) {
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter.onAdFailed("0", str);
                }
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener.onADExposeError(i, str);
                }
            }

            public void onAdShow() {
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter.onAdShow();
                }
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdEventListener.onADExposed();
                }
            }

            public void onClosed() {
                if (((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter != null) {
                    ((AMPSBaseTransformEntry) UnifiedRender.this).mAdapter.onAdDismiss();
                }
            }
        });
        this.f40262a.setExpressViewHolder(customDrawAdHolder);
        this.f40262a.showAd(customDrawAdHolder.getRootView());
    }
}
