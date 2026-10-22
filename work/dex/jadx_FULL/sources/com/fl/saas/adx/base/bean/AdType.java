package com.fl.saas.adx.base.bean;

import android.content.Context;
import com.fl.saas.AbstractC1403d;
import com.fl.saas.AbstractC1405e;
import com.fl.saas.AbstractC1409g;
import com.fl.saas.AbstractC1411h;
import com.fl.saas.C1413i;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.base.builder.InnerBannerBuilder;
import com.fl.saas.adx.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.adx.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.adx.base.base.builder.InnerVideoBuilder;
import com.fl.saas.adx.base.manager.AdViewBannerManager;
import com.fl.saas.adx.base.manager.AdViewInterstitialManager;
import com.fl.saas.adx.base.manager.AdViewSpreadManager;
import com.fl.saas.adx.base.manager.AdViewVideoManager;
import com.fl.saas.adx.base.manager.api.ManagerInfoAPI;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum AdType {
    Spread(1, AbstractC1409g.class, AdViewSpreadManager.class),
    Banner(2, AbstractC1403d.class, AdViewBannerManager.class),
    Interstitial(3, AbstractC1405e.class, AdViewInterstitialManager.class),
    RewardVideo(5, AbstractC1411h.class, AdViewVideoManager.class);

    private static final Map<AdType, Constructor<? extends ManagerInfoAPI>> managerConstructors = new HashMap();
    private final Class<? extends AdapterAPI> adapterClass;
    private C1413i apiManager;
    private final Class<? extends ManagerInfoAPI> managerClass;
    private final int pos;

    AdType(int i, Class cls, Class cls2) {
        this.adapterClass = cls;
        this.managerClass = cls2;
        this.pos = i;
    }

    public static AdType fromPosition(int i) {
        if (1 > i || i > values().length) {
            return null;
        }
        return values()[i - 1];
    }

    public static AdType getType(Class<?> cls) {
        for (AdType adType : values()) {
            if (adType.isAssignable(cls)) {
                return adType;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public BaseBuilder<?> createDefaultBuilder(Context context) {
        Class cls;
        Class[] clsArr = {InnerSpreadBuilder.Default.class, InnerVideoBuilder.Default.class, InnerInterstitialBuilder.Default.class, InnerBannerBuilder.Default.class};
        for (int i = 0; i < 4; i++) {
            cls = clsArr[i];
            API api = (API) cls.getAnnotation(API.class);
            if (api != null && this == api.value()) {
                if (cls != null) {
                    try {
                        return (BaseBuilder) cls.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }
        cls = null;
        if (cls != null) {
            return (BaseBuilder) cls.getConstructor(Context.class).newInstance(context);
        }
        return null;
    }

    public <T extends ManagerInfoAPI> T createManager() {
        try {
            Map<AdType, Constructor<? extends ManagerInfoAPI>> map = managerConstructors;
            Constructor<? extends ManagerInfoAPI> constructor = map.get(this);
            if (constructor == null) {
                constructor = this.managerClass.getConstructor(null);
                map.put(this, constructor);
            }
            return (T) constructor.newInstance(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1413i getAdapterGenerator() {
        if (this.apiManager == null) {
            this.apiManager = new C1413i(this.adapterClass);
        }
        return this.apiManager;
    }

    public int getPos() {
        return this.pos;
    }

    public boolean isAssignable(Class<?> cls) {
        return this.managerClass.isAssignableFrom(cls) || this.adapterClass.isAssignableFrom(cls);
    }
}
