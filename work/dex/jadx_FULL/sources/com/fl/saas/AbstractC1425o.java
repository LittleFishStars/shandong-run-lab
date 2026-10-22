package com.fl.saas;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdReRequestListener;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: renamed from: com.fl.saas.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1425o extends AbstractC1423n {
    private AdReRequestListener adReRequestListener;

    @Nullable
    private BaseBuilder<?> builder;
    private AdViewListener mAdEventListener;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FLError fLError) {
        AdViewListener adViewListener = this.mAdEventListener;
        if (adViewListener != null) {
            adViewListener.onAdFailed(fLError);
        }
    }

    public AdViewListener getBuilder() {
        return this.builder;
    }

    public <U> C1428p0 getBuilderFieldOptional(Function<BaseBuilder<?>, ? extends U> function) {
        try {
            return C1428p0.b(this.builder).a((Function) function);
        } catch (Exception e) {
            e.printStackTrace();
            return C1428p0.a();
        }
    }

    public AdViewListener getEventListener() {
        return this.mAdEventListener;
    }

    public String getKey() {
        return this.mPlaceId;
    }

    public C1428p0 getListenerOptional() {
        return C1428p0.b(this.mAdEventListener);
    }

    public void handleListenerEvent(B b) {
        getListenerOptional().a(b);
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(final FLError fLError) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.qkb
            @Override // java.lang.Runnable
            public final void run() {
                this.f19142a.a(fLError);
            }
        });
    }

    public void reRequest() {
        AdReRequestListener adReRequestListener = this.adReRequestListener;
        if (adReRequestListener != null) {
            adReRequestListener.onReRequest();
        }
    }

    public AbstractC1425o setAdReRequestListener(AdReRequestListener adReRequestListener) {
        this.adReRequestListener = adReRequestListener;
        return this;
    }

    public AbstractC1425o setBuilder(BaseBuilder<?> baseBuilder) {
        this.builder = baseBuilder;
        this.mPlaceId = baseBuilder.getKey();
        return this;
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void setCache() {
        super.setCache();
        this.builder = null;
    }

    public AbstractC1425o setEventListener(AdViewListener adViewListener) {
        this.mAdEventListener = adViewListener;
        return this;
    }
}
