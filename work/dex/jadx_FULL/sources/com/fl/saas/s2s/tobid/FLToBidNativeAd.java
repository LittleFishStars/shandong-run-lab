package com.fl.saas.s2s.tobid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidNativeAd extends WMNativeAdData {
    private WeakReference<Activity> activityWeakReference;
    private Context context;
    private WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback;
    private NativeMaterial material;
    private WMNativeAdData.NativeADMediaListener nativeADMediaListener;
    private NativeAd nativeAd;
    private WMNativeAdData nativeAdData = this;
    private WMNativeAdData.NativeAdInteractionListener nativeAdListener;
    private NativeAdView nativeAdView;
    private WMCustomNativeAdapter nativeAdapter;

    public FLToBidNativeAd(NativeAd nativeAd, WMCustomNativeAdapter wMCustomNativeAdapter, Context context) {
        this.nativeAd = nativeAd;
        this.nativeAdapter = wMCustomNativeAdapter;
        this.context = context;
        this.material = nativeAd.getAdMaterial();
        if (this.nativeAdView == null) {
            this.nativeAdView = new NativeAdView(context);
        }
    }

    public void bindImageViews(Context context, List<ImageView> list, int i) {
        if (this.material == null || list == null || list.isEmpty() || this.material.getImageUrlList() == null) {
            return;
        }
        int iMin = Math.min(list.size(), this.material.getImageUrlList().size());
        for (int i2 = 0; i2 < iMin; i2++) {
            ImageLoader.loadImage(this.material.getImageUrlList().get(i2), list.get(i2));
        }
    }

    public void bindMediaView(Context context, ViewGroup viewGroup) {
        NativeMaterial nativeMaterial;
        View adMediaView;
        if (viewGroup == null || (nativeMaterial = this.material) == null || (adMediaView = nativeMaterial.getAdMediaView()) == null || adMediaView.getParent() != null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(adMediaView, ViewHelper.getMatchParent());
    }

    public void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.tobid.FLToBidNativeAd.2
                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdClicked(NativeAdView nativeAdView) {
                    if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdListener.onADClicked(FLToBidNativeAd.this.nativeAdapter.getAdInFo());
                    }
                    if (FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdapter.callNativeAdClick(FLToBidNativeAd.this.nativeAdData);
                    }
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdClose(NativeAdView nativeAdView) {
                    if (FLToBidNativeAd.this.dislikeInteractionCallback == null || FLToBidNativeAd.this.nativeAdapter == null) {
                        return;
                    }
                    FLToBidNativeAd.this.dislikeInteractionCallback.onSelected(0, "", true);
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                    if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdListener.onADError(FLToBidNativeAd.this.nativeAdapter.getAdInFo(), WindMillError.ERROR_AD_NO_FILL);
                    }
                    if (FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdapter.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
                    }
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdImpressed(NativeAdView nativeAdView) {
                    if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdListener.onADExposed(FLToBidNativeAd.this.nativeAdapter.getAdInFo());
                    }
                    if (FLToBidNativeAd.this.nativeAdapter != null) {
                        FLToBidNativeAd.this.nativeAdapter.callNativeAdShow(FLToBidNativeAd.this.nativeAdData);
                    }
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoEnd(NativeAdView nativeAdView) {
                    if (FLToBidNativeAd.this.nativeADMediaListener != null) {
                        FLToBidNativeAd.this.nativeADMediaListener.onVideoCompleted();
                    }
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoStart(NativeAdView nativeAdView) {
                    if (FLToBidNativeAd.this.nativeADMediaListener != null) {
                        FLToBidNativeAd.this.nativeADMediaListener.onVideoStart();
                    }
                }
            });
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            nativePrepareInfo.setActivity(this.activityWeakReference.get());
            nativePrepareInfo.setCloseView(view2);
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
            }
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            nativePrepareInfo.setClickView((View[]) arrayList.toArray(new View[0]));
            this.nativeAd.prepare(nativePrepareInfo);
        }
    }

    public void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
        this.activityWeakReference = new WeakReference<>(activity);
        if (this.nativeAd == null || wMNativeAdContainer == null || wMNativeAdRender == null) {
            return;
        }
        ViewHelper.removeParent(this.nativeAdView);
        View viewCreateView = wMNativeAdRender.createView(activity, getAdPatternType());
        ViewHelper.removeParent(viewCreateView);
        NativeAdView nativeAdView = this.nativeAdView;
        if (nativeAdView != null) {
            nativeAdView.removeAllViews();
            this.nativeAdView.addView(viewCreateView, ViewHelper.getWrapParent());
        }
        wMNativeAdContainer.addView(this.nativeAdView, ViewHelper.getWrapParent());
        this.nativeAd.renderAdContainer(this.nativeAdView, viewCreateView);
        wMNativeAdRender.renderAdView(viewCreateView, this);
    }

    public void destroy() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.release();
            this.nativeAd = null;
        }
    }

    public Bitmap getAdLogo() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getAdLogo();
        }
        return null;
    }

    public int getAdPatternType() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial == null) {
            return 0;
        }
        int adType = nativeMaterial.getAdType();
        if (adType == 1) {
            return 1;
        }
        if (adType != 2) {
            return adType != 3 ? 0 : 4;
        }
        return 3;
    }

    public String getCTAText() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getCallToAction();
        }
        return null;
    }

    public String getDesc() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getDescription();
        }
        return null;
    }

    public View getExpressAdView() {
        if (isExpressAd()) {
            return this.nativeAdView;
        }
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getAdMediaView();
        }
        return null;
    }

    public String getIconUrl() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getIconUrl();
        }
        return null;
    }

    public List<WMImage> getImageList() {
        return null;
    }

    public List<String> getImageUrlList() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getImageUrlList();
        }
        return null;
    }

    public int getInteractionType() {
        NativeMaterial nativeMaterial = this.material;
        return (nativeMaterial == null || !nativeMaterial.isNativeAppAd()) ? 2 : 1;
    }

    public NativeAd getNativeAd() {
        return this.nativeAd;
    }

    public int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.nativeAdapter;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public String getTitle() {
        NativeMaterial nativeMaterial = this.material;
        if (nativeMaterial != null) {
            return nativeMaterial.getTitle();
        }
        return null;
    }

    public boolean isExpressAd() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            return nativeAd.isNativeExpress();
        }
        return false;
    }

    public boolean isNativeDrawAd() {
        return false;
    }

    public void render() {
        WMCustomNativeAdapter wMCustomNativeAdapter;
        NativeMaterial nativeMaterial;
        if (!(this.context instanceof Activity)) {
            this.context = DeviceUtil.getTopActivity();
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd == null || !(this.context instanceof Activity)) {
            WMCustomNativeAdapter wMCustomNativeAdapter2 = this.nativeAdapter;
            if (wMCustomNativeAdapter2 != null) {
                wMCustomNativeAdapter2.callLoadFail(new WMAdapterError(-1, "context not activity"));
                return;
            }
            return;
        }
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.tobid.FLToBidNativeAd.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdListener.onADClicked(FLToBidNativeAd.this.nativeAdapter.getAdInFo());
                }
                if (FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdapter.callNativeAdClick(FLToBidNativeAd.this.nativeAdData);
                }
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                if (FLToBidNativeAd.this.dislikeInteractionCallback == null || FLToBidNativeAd.this.nativeAdapter == null) {
                    return;
                }
                FLToBidNativeAd.this.dislikeInteractionCallback.onSelected(0, "", true);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdListener.onADError(FLToBidNativeAd.this.nativeAdapter.getAdInFo(), WindMillError.ERROR_AD_NO_FILL);
                }
                if (FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdapter.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
                }
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (FLToBidNativeAd.this.nativeAdListener != null && FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdListener.onADExposed(FLToBidNativeAd.this.nativeAdapter.getAdInFo());
                }
                if (FLToBidNativeAd.this.nativeAdapter != null) {
                    FLToBidNativeAd.this.nativeAdapter.callNativeAdShow(FLToBidNativeAd.this.nativeAdData);
                }
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                if (FLToBidNativeAd.this.nativeADMediaListener != null) {
                    FLToBidNativeAd.this.nativeADMediaListener.onVideoCompleted();
                }
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                if (FLToBidNativeAd.this.nativeADMediaListener != null) {
                    FLToBidNativeAd.this.nativeADMediaListener.onVideoStart();
                }
            }
        });
        if (this.nativeAdView == null) {
            this.nativeAdView = new NativeAdView(this.context);
        }
        if (this.nativeAdView != null && (nativeMaterial = this.material) != null && nativeMaterial.getAdMediaView() != null) {
            this.nativeAdView.removeAllViews();
            this.nativeAdView.addView(this.material.getAdMediaView(), ViewHelper.getWrapParent());
        }
        this.nativeAd.renderAdContainer(this.nativeAdView, null);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity((Activity) this.context);
        this.nativeAd.prepare(nativePrepareInfo);
        WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener = this.nativeAdListener;
        if (nativeAdInteractionListener == null || (wMCustomNativeAdapter = this.nativeAdapter) == null) {
            return;
        }
        AdInfo adInFo = wMCustomNativeAdapter.getAdInFo();
        NativeAdView nativeAdView = this.nativeAdView;
        nativeAdInteractionListener.onADRenderSuccess(adInFo, nativeAdView, nativeAdView.getWidth(), this.nativeAdView.getHeight());
    }

    public void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.dislikeInteractionCallback = dislikeInteractionCallback;
        }
    }

    public void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.nativeAdListener = nativeAdInteractionListener;
        }
    }

    public void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (nativeADMediaListener != null) {
            this.nativeADMediaListener = nativeADMediaListener;
        }
    }
}
