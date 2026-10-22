package com.example.topon_adapter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdNativeExpressAd extends CustomNativeAd {
    private FrameLayout mAdContainer;
    private final Context mContext;
    private final LTDrawAd mLtDrawAd;
    private int mVideoAutoPlay;
    private int mVideoDuration;
    private int mVideoMuted;
    private boolean mIsDestroyed = false;
    private boolean mIsShown = false;
    private boolean mIsClicked = false;

    public LtAdNativeExpressAd(Context context, LTDrawAd lTDrawAd, int i, int i2, int i3) {
        this.mContext = context.getApplicationContext();
        this.mLtDrawAd = lTDrawAd;
        this.mVideoMuted = i;
        this.mVideoAutoPlay = i2;
        this.mVideoDuration = i3;
        setupAdData();
        setupEventListeners();
    }

    private View createAdContainer() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    private void setupAdData() {
        setNativeInteractionType(0);
        if (getECPM() > 0) {
            try {
                ((CustomNativeAd) this).mAdSourceType = "1";
            } catch (Exception unused) {
                ((CustomNativeAd) this).mAdSourceType = String.valueOf(1);
            }
        } else {
            try {
                ((CustomNativeAd) this).mAdSourceType = "2";
            } catch (Exception unused2) {
                ((CustomNativeAd) this).mAdSourceType = String.valueOf(0);
            }
        }
    }

    private void setupEventListeners() {
        LTDrawAd lTDrawAd = this.mLtDrawAd;
        if (lTDrawAd == null) {
            return;
        }
        lTDrawAd.setLTAdEventListener(new LTAdDrawNativeEventListener() { // from class: com.example.topon_adapter.adapter.LtAdNativeExpressAd.1
            public void onAdClicked() {
                if (LtAdNativeExpressAd.this.mIsClicked) {
                    return;
                }
                LtAdNativeExpressAd.this.mIsClicked = true;
                LtAdNativeExpressAd.this.notifyAdClicked();
            }

            public void onAdRenderFail(int i, String str) {
            }

            public void onAdShow() {
                if (LtAdNativeExpressAd.this.mIsShown) {
                    return;
                }
                LtAdNativeExpressAd.this.mIsShown = true;
                LtAdNativeExpressAd.this.notifyAdImpression();
            }

            public void onClosed() {
                LtAdNativeExpressAd.this.notifyAdDislikeClick();
            }
        });
    }

    public void clear(View view) {
        LTDrawAd lTDrawAd = this.mLtDrawAd;
        if (lTDrawAd != null) {
            lTDrawAd.destroy();
        }
        FrameLayout frameLayout = this.mAdContainer;
        if (frameLayout == null || frameLayout.getParent() == null) {
            return;
        }
        ((ViewGroup) this.mAdContainer.getParent()).removeView(this.mAdContainer);
    }

    public void destroy() {
        super.destroy();
        this.mIsDestroyed = true;
        LTDrawAd lTDrawAd = this.mLtDrawAd;
        if (lTDrawAd != null) {
            lTDrawAd.destroy();
        }
        FrameLayout frameLayout = this.mAdContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mAdContainer = null;
        }
    }

    public View getAdMediaView(Object... objArr) {
        if (this.mAdContainer == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            this.mAdContainer = frameLayout;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        return this.mAdContainer;
    }

    public int getECPM() {
        LTDrawAd lTDrawAd = this.mLtDrawAd;
        if (lTDrawAd != null) {
            return (int) lTDrawAd.getEcpm();
        }
        return 0;
    }

    public int getNativeType() {
        return 0;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    public boolean isNativeExpress() {
        return true;
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        FrameLayout frameLayout;
        LTDrawAd lTDrawAd = this.mLtDrawAd;
        if (lTDrawAd != null && (view instanceof FrameLayout)) {
            try {
                lTDrawAd.showAd((FrameLayout) view);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (lTDrawAd == null || (frameLayout = this.mAdContainer) == null) {
            return;
        }
        try {
            lTDrawAd.showAd(frameLayout);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(this.mAdContainer);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setNativeType(int i) {
        try {
            Method declaredMethod = getClass().getSuperclass().getDeclaredMethod("setNativeType", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
