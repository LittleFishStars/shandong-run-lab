package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.openset.ad._native.OSETNativeAd;
import com.kc.openset.ad.listener.OSETNativeListener;
import com.kc.openset.util.ContextUtils;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETToBidExpressAdData extends WMNativeAdData {
    private final WeakReference<Activity> activityWeakReference;
    private final WMCustomNativeAdapter adAdapter;
    private WMNativeAdData.NativeAdInteractionListener adInteractionListener;
    private WeakReference<FrameLayout> expressAdViewWeakReference;
    private final OSETNativeAd mOsetNativeAd;

    public OSETToBidExpressAdData(Activity activity, OSETNativeAd oSETNativeAd, WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.mOsetNativeAd = oSETNativeAd;
        this.adAdapter = wMCustomNativeAdapter;
        FrameLayout frameLayout = activity != null ? new FrameLayout(activity) : new FrameLayout(ContextUtils.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.expressAdViewWeakReference = new WeakReference<>(frameLayout);
    }

    public void bindImageViews(Context context, List<ImageView> list, int i) {
    }

    public void bindMediaView(Context context, ViewGroup viewGroup) {
    }

    public void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
    }

    public void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
    }

    public void destroy() {
        OSETNativeAd oSETNativeAd = this.mOsetNativeAd;
        if (oSETNativeAd != null) {
            oSETNativeAd.destroy();
        }
    }

    public Bitmap getAdLogo() {
        return null;
    }

    public int getAdPatternType() {
        return 0;
    }

    public String getCTAText() {
        return "";
    }

    public String getDesc() {
        return "";
    }

    public View getExpressAdView() {
        if (this.expressAdViewWeakReference.get() == null) {
            FrameLayout frameLayout = this.activityWeakReference.get() != null ? new FrameLayout(this.activityWeakReference.get()) : new FrameLayout(ContextUtils.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.expressAdViewWeakReference = new WeakReference<>(frameLayout);
        }
        return this.expressAdViewWeakReference.get();
    }

    public String getIconUrl() {
        return "";
    }

    public List<WMImage> getImageList() {
        return null;
    }

    public List<String> getImageUrlList() {
        return null;
    }

    public int getInteractionType() {
        return 0;
    }

    public OSETNativeAd getNativeExpressAd() {
        return this.mOsetNativeAd;
    }

    public int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.adAdapter;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public String getTitle() {
        return "";
    }

    public boolean isExpressAd() {
        return true;
    }

    public boolean isNativeDrawAd() {
        return false;
    }

    public void render() {
        if (this.mOsetNativeAd == null || this.activityWeakReference.get() == null) {
            return;
        }
        this.mOsetNativeAd.render(this.activityWeakReference.get(), new OSETNativeListener() { // from class: com.kc.openset.third.custom.tobid.OSETToBidExpressAdData.1
            @Override // com.kc.openset.ad.listener.OSETNativeListener
            public void onClick(View view) {
                if (OSETToBidExpressAdData.this.adInteractionListener != null && OSETToBidExpressAdData.this.adAdapter != null) {
                    OSETToBidExpressAdData.this.adInteractionListener.onADClicked(OSETToBidExpressAdData.this.adAdapter.getAdInFo(OSETToBidExpressAdData.this));
                }
                if (OSETToBidExpressAdData.this.adAdapter != null) {
                    OSETToBidExpressAdData.this.adAdapter.callNativeAdClick(OSETToBidExpressAdData.this);
                }
            }

            @Override // com.kc.openset.ad.listener.OSETNativeListener
            public void onClose(View view) {
            }

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public void onError(String str, String str2) {
                if (OSETToBidExpressAdData.this.adInteractionListener != null && OSETToBidExpressAdData.this.adAdapter != null) {
                    WindMillError windMillError = WindMillError.ERROR_AD_ADAPTER_PLAY;
                    windMillError.setMessage("code : " + str + " msg : " + str2);
                    OSETToBidExpressAdData.this.adInteractionListener.onADError(OSETToBidExpressAdData.this.adAdapter.getAdInFo(OSETToBidExpressAdData.this), windMillError);
                }
                if (OSETToBidExpressAdData.this.adAdapter != null) {
                    try {
                        OSETToBidExpressAdData.this.adAdapter.callNativeAdShowError(OSETToBidExpressAdData.this, new WMAdapterError(Integer.parseInt(str), "奇点渲染广告失败:" + str2));
                    } catch (Exception unused) {
                        OSETToBidExpressAdData.this.adAdapter.callNativeAdShowError(OSETToBidExpressAdData.this, new WMAdapterError(WindMillError.ERROR_AD_PLAY.getErrorCode(), "奇点渲染广告失败:" + str2));
                    }
                }
            }

            @Override // com.kc.openset.ad.listener.OSETNativeListener
            public void onRenderSuccess(View view) {
                if (OSETToBidExpressAdData.this.expressAdViewWeakReference.get() != null) {
                    ((FrameLayout) OSETToBidExpressAdData.this.expressAdViewWeakReference.get()).addView(view);
                }
                if (OSETToBidExpressAdData.this.adInteractionListener == null || OSETToBidExpressAdData.this.adAdapter == null) {
                    return;
                }
                OSETToBidExpressAdData.this.adInteractionListener.onADRenderSuccess(OSETToBidExpressAdData.this.adAdapter.getAdInFo(OSETToBidExpressAdData.this), view, 0.0f, 0.0f);
            }

            @Override // com.kc.openset.ad.listener.OSETNativeListener
            public void onShow(View view) {
                if (OSETToBidExpressAdData.this.adInteractionListener != null && OSETToBidExpressAdData.this.adAdapter.getNativeAdDataList() != null && OSETToBidExpressAdData.this.adAdapter.getNativeAdDataList().size() > 0) {
                    OSETToBidExpressAdData.this.adInteractionListener.onADExposed(OSETToBidExpressAdData.this.adAdapter.getAdInFo(OSETToBidExpressAdData.this));
                }
                if (OSETToBidExpressAdData.this.adAdapter != null) {
                    OSETToBidExpressAdData.this.adAdapter.callNativeAdShow(OSETToBidExpressAdData.this);
                }
            }
        });
    }

    public void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
    }

    public void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        this.adInteractionListener = nativeAdInteractionListener;
    }

    public void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
    }
}
