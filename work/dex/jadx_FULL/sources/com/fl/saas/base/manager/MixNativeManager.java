package com.fl.saas.base.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.MixNativeAdManager;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.adapter.AdViewMixNativeAdapter;
import com.fl.saas.base.adapter.MixNativeAPI;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.adapter.manager.MixNativeAPIManager;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MixNativeManager implements MixNativeAdManager, ManagerLoader<AdViewMixNativeAdapter> {
    private static final MixNativeAPIManager<? extends MixNativeAPI> mMixNativeManager = new MixNativeAPIManager<>(MixNativeHandler.class);
    private boolean isFailedCallBack = false;
    private final WeakReference<Context> mContextRef;
    private NativeLoadListener mLoadListener;
    private final BaseLoader<AdViewMixNativeAdapter> mLoader;
    private final AdParams mParams;
    private final OnNativeReleaseListener onNativeReleaseListener;

    /* JADX INFO: renamed from: com.fl.saas.base.manager.MixNativeManager$1, reason: invalid class name */
    public class AnonymousClass1 extends BaseLoader<AdViewMixNativeAdapter> {
        public AnonymousClass1(ManagerLoader managerLoader, int i) {
            super(managerLoader, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadAdapter$0(MixNativeAPI mixNativeAPI, AdSource adSource, Context context) {
            mixNativeAPI.setContext(context);
            mixNativeAPI.setAdSource(adSource);
            mixNativeAPI.setAdParams(MixNativeManager.this.mParams);
            AdViewMixNativeAdapter adViewMixNativeAdapter = new AdViewMixNativeAdapter(mixNativeAPI);
            adViewMixNativeAdapter.setOnNativeReleaseListener(MixNativeManager.this.onNativeReleaseListener);
            adViewMixNativeAdapter.setKey(adViewMixNativeAdapter.getKey());
            adViewMixNativeAdapter.setContext(context);
            adViewMixNativeAdapter.setAdSource(adSource);
            loadAdapter(adViewMixNativeAdapter);
        }

        private void loadAdapter(final MixNativeAPI mixNativeAPI, final AdSource adSource) {
            if (mixNativeAPI == null || adSource == null) {
                return;
            }
            this.mLoader.getContextOpt().ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.c
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f1754a.lambda$loadAdapter$0(mixNativeAPI, adSource, (Context) obj);
                }
            });
        }

        @Override // com.fl.saas.base.manager.loader.BaseLoader
        public void handleSDKBidAd(@NonNull AdSource adSource, Object obj) {
            if (obj instanceof MixNativeHandler) {
                loadAdapter((MixNativeAPI) obj, adSource);
            } else {
                requestAd(adSource);
            }
        }

        @Override // com.fl.saas.base.manager.api.AdapterGenerator
        public void requestAd(AdSource adSource) {
            loadAdapter((MixNativeAPI) MixNativeManager.mMixNativeManager.loadAdapter(adSource.adv_id, adSource.customClassName), adSource);
        }
    }

    public interface OnNativeReleaseListener {
        void release();
    }

    public MixNativeManager(@NonNull Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        this.mParams = adParams;
        this.mContextRef = new WeakReference<>(context);
        this.mLoadListener = nativeLoadListener;
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this, 10);
        this.mLoader = anonymousClass1;
        this.onNativeReleaseListener = new OnNativeReleaseListener() { // from class: com.zj.adlib.zp5
            @Override // com.fl.saas.base.manager.MixNativeManager.OnNativeReleaseListener
            public final void release() {
                anonymousClass1.destroy();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindAdapter$0(NativeAd nativeAd) {
        if (this.mLoadListener != null) {
            if (nativeAd != null) {
                nativeAd.setNativeAdParams(this.mParams);
            }
            this.mLoadListener.onNativeAdLoaded(nativeAd);
        }
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public AdViewMixNativeAdapter bindAdapter(AdViewMixNativeAdapter adViewMixNativeAdapter) {
        return adViewMixNativeAdapter.setLoadListener(new Consumer() { // from class: com.zj.adlib.bq5
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f40813a.lambda$bindAdapter$0((NativeAd) obj);
            }
        });
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public Optional<Context> getContextOpt() {
        return Optional.ofNullable(this.mContextRef.get());
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.isFailedCallBack;
    }

    @Override // com.fl.saas.api.mixNative.MixNativeAdManager
    public void load() {
        this.mLoader.request(this.mParams.getKey());
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public void onAdFailed(YdError ydError) {
        if (this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        NativeLoadListener nativeLoadListener = this.mLoadListener;
        if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(ydError);
        }
        this.mLoadListener = null;
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        onAdFailed(ydError);
    }

    public void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        this.mLoader.preload(adPlace, preloadDoneCallback);
    }
}
