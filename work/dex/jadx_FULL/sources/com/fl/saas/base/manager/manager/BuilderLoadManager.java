package com.fl.saas.base.manager.manager;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.base.interfaces.AdReRequestListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.api.ManagerAPI;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.manager.loader.BuilderAdLoader;
import com.fl.saas.base.type.AdType;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.zj.adlib.u41;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BuilderLoadManager<T extends BaseBuilder<?>, S extends AdapterAPI, U extends AdViewListener> implements ManagerLoader<S>, ManagerAPI<T> {
    private AdReRequestListener adReRequestListener;
    private T mBuilder;
    private U mEventListener;
    private BuilderAdLoader<S> mLoader;
    private boolean isFailedCallBack = false;
    private boolean isDestroy = false;

    public BuilderLoadManager(AdType adType) {
        this.mLoader = new BuilderAdLoader<>(adType, this);
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        BuilderAdLoader<S> builderAdLoader = this.mLoader;
        if (builderAdLoader != null) {
            builderAdLoader.biddingResultUpload(z, i, i2);
        }
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public S bindAdapter(S s) {
        return ((BuilderLoadAdapter) s).setBuilder(this.mBuilder).setEventListener(this.mEventListener).setAdReRequestListener(this.adReRequestListener);
    }

    public void destroy() {
        this.isDestroy = true;
        this.mLoader.destroy();
        this.mEventListener = null;
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public AdInfo getAdInfo() {
        return this.mLoader.getAdInfo();
    }

    public AdPlace getAdPlace() {
        return this.mLoader.getAdPlace();
    }

    public T getBuilder() {
        return this.mBuilder;
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public Optional<Context> getContextOpt() {
        return Optional.ofNullable(this.mBuilder).map(new Function() { // from class: com.zj.adlib.q41
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((BaseBuilder) obj).getContextRef();
            }
        }).map(new u41());
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public int getEcpm() {
        return this.mLoader.getEcpm();
    }

    public String getMaterialJson() {
        return this.mLoader.getMaterialJson();
    }

    public String getReqId() {
        return this.mLoader.getReqId();
    }

    public AdapterAPI getShowAdapter() {
        return this.mLoader.getShowAdapter();
    }

    public Optional<S> getValidAdapter() {
        return this.mLoader.getValidAdapter();
    }

    public abstract U initProxyEventListener(T t);

    public boolean isDestroy() {
        return this.isDestroy;
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.isFailedCallBack;
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public void onAdFailed(final YdError ydError) {
        if (this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        Optional.ofNullable(this.mEventListener).ifPresent(new Consumer() { // from class: com.zj.adlib.s41
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewListener) obj).onAdFailed(ydError);
            }
        });
        this.mEventListener = null;
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        if (!(getBuilder() instanceof AdLoadEvent)) {
            onAdFailed(ydError);
        } else {
            if (this.isFailedCallBack) {
                return;
            }
            this.isFailedCallBack = true;
            ((AdLoadEvent) getBuilder()).onLoadFailed(ydError);
        }
    }

    @Override // com.fl.saas.base.manager.api.ManagerAPI
    public void preload(T t, AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        LogcatUtil.d("YdSDK", "preload, isDestroy:" + this.isDestroy);
        if (adPlace == null || preloadDoneCallback == null) {
            return;
        }
        this.mBuilder = t;
        this.mLoader.preload(adPlace, preloadDoneCallback);
    }

    public void request(T t) {
        LogcatUtil.d("YdSDK", "request, isDestroy:" + this.isDestroy);
        this.mBuilder = t;
        this.mEventListener = (U) initProxyEventListener(t);
        this.mLoader.setHot(this.mBuilder.isHot());
        this.mLoader.request(this.mBuilder.getKey());
    }

    public void restManagerLoad(AdType adType) {
        BuilderAdLoader<S> builderAdLoader = new BuilderAdLoader<>(adType, this);
        this.mLoader = builderAdLoader;
        builderAdLoader.request(this.mBuilder.getKey());
    }

    public void selectBottomAd() {
        this.mLoader.selectBottomAd();
    }

    public void setAdReRequestListener(AdReRequestListener adReRequestListener) {
        this.adReRequestListener = adReRequestListener;
    }
}
