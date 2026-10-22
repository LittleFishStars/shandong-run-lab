package com.fl.saas.adx.base.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.B;
import com.fl.saas.C1407f;
import com.fl.saas.C1428p0;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.MixNativeAdManager;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.manager.api.ManagerLoader;
import com.fl.saas.adx.base.manager.loader.BaseLoader;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MixNativeManager implements MixNativeAdManager, ManagerLoader<C1407f> {
    private boolean isFailedCallBack = false;
    private final WeakReference<Context> mContextRef;
    private NativeLoadListener mLoadListener;
    private final BaseLoader<C1407f> mLoader;
    private final AdParams mParams;
    private final OnNativeReleaseListener onNativeReleaseListener;

    public interface OnNativeReleaseListener {
        void release();
    }

    public MixNativeManager(@NonNull Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        this.mParams = adParams;
        this.mContextRef = new WeakReference<>(context);
        this.mLoadListener = nativeLoadListener;
        final BaseLoader<C1407f> baseLoader = new BaseLoader<C1407f>(this, 10) { // from class: com.fl.saas.adx.base.manager.MixNativeManager.1
            @Override // com.fl.saas.adx.base.manager.loader.BaseLoader
            public void loadAdapter(AdapterAPI adapterAPI) {
                if (adapterAPI instanceof C1407f) {
                    C1407f c1407f = (C1407f) adapterAPI;
                    c1407f.b().a(MixNativeManager.this.mParams);
                    c1407f.a(MixNativeManager.this.onNativeReleaseListener);
                }
                super.loadAdapter(adapterAPI);
            }
        };
        this.mLoader = baseLoader;
        this.onNativeReleaseListener = new OnNativeReleaseListener() { // from class: com.zj.adlib.aq5
            @Override // com.fl.saas.adx.base.manager.MixNativeManager.OnNativeReleaseListener
            public final void release() {
                baseLoader.destroy();
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindAdapter$1(FLError fLError) {
        NativeLoadListener nativeLoadListener = this.mLoadListener;
        if (nativeLoadListener == null || this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        nativeLoadListener.onAdFailed(fLError);
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerLoader
    public C1407f bindAdapter(C1407f c1407f) {
        return c1407f.b(new B() { // from class: com.zj.adlib.cq5
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f41023a.lambda$bindAdapter$0((NativeAd) obj);
            }
        }).a(new B() { // from class: com.zj.adlib.dq5
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f41253a.lambda$bindAdapter$1((FLError) obj);
            }
        });
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerLoader
    public Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerLoader
    public C1428p0 getContextOpt() {
        return C1428p0.b(this.mContextRef.get());
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerLoader
    public String getLinkId() {
        AdParams adParams = this.mParams;
        return adParams != null ? adParams.getLinkId() : "";
    }

    @Override // com.fl.saas.adx.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.isFailedCallBack;
    }

    @Override // com.fl.saas.adx.api.mixNative.MixNativeAdManager
    public void load() {
        this.mLoader.request(this.mParams.getKey());
    }

    @Override // com.fl.saas.adx.base.manager.api.FailedLoader
    public void onAdFailed(FLError fLError) {
        if (this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        NativeLoadListener nativeLoadListener = this.mLoadListener;
        if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(fLError);
        }
        this.mLoadListener = null;
    }

    @Override // com.fl.saas.adx.base.interfaces.AdLoadEvent
    public void onLoadFailed(FLError fLError) {
        onAdFailed(fLError);
    }
}
