package com.fl.saas.base.adapter.base;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.AdReRequestListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BuilderLoadAdapter<T extends BaseBuilder<?>, S extends AdViewListener> extends BaseAdAdapter<S> {
    private AdReRequestListener adReRequestListener;

    @Nullable
    private T builder;
    private String key;
    private S mAdEventListener;

    public AdViewListener getBuilder() {
        return this.builder;
    }

    public <U> Optional<U> getBuilderFieldOptional(Function<? super T, ? extends U> function) {
        try {
            return Optional.ofNullable(this.builder).map(function);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public AdViewListener getEventListener() {
        return this.mAdEventListener;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public String getKey() {
        return this.key;
    }

    public Optional<S> getListenerOptional() {
        return Optional.ofNullable(this.mAdEventListener);
    }

    public void handleListenerEvent(Consumer<? super S> consumer) {
        getListenerOptional().ifPresent(consumer);
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        S s = this.mAdEventListener;
        if (s != null) {
            s.onAdFailed(ydError);
        }
    }

    public void reRequest() {
        AdReRequestListener adReRequestListener = this.adReRequestListener;
        if (adReRequestListener != null) {
            adReRequestListener.onReRequest();
        }
    }

    public BuilderLoadAdapter<T, S> setAdReRequestListener(AdReRequestListener adReRequestListener) {
        this.adReRequestListener = adReRequestListener;
        return this;
    }

    public BuilderLoadAdapter<T, S> setBuilder(T t) {
        this.builder = t;
        this.key = t.getKey();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void setCache() {
        super.setCache();
        this.builder = null;
    }

    public BuilderLoadAdapter<T, S> setEventListener(S s) {
        this.mAdEventListener = s;
        return this;
    }
}
