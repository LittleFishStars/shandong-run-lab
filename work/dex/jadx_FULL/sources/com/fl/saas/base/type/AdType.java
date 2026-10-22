package com.fl.saas.base.type;

import android.content.Context;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
import com.fl.saas.base.adapter.AdViewDrawVideoAdapter;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.adapter.manager.AdapterAPIManager;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.manager.AdViewBannerManager;
import com.fl.saas.base.manager.AdViewDrawVideoManager;
import com.fl.saas.base.manager.AdViewFullVideoManager;
import com.fl.saas.base.manager.AdViewInterstitialManager;
import com.fl.saas.base.manager.AdViewNativeManager;
import com.fl.saas.base.manager.AdViewSpreadManager;
import com.fl.saas.base.manager.AdViewTemplateManager;
import com.fl.saas.base.manager.AdViewVideoManager;
import com.fl.saas.base.manager.api.ManagerInfoAPI;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum AdType {
    Spread(1, AdViewSpreadAdapter.class, AdViewSpreadManager.class),
    Banner(2, AdViewBannerAdapter.class, AdViewBannerManager.class),
    Interstitial(3, AdViewInterstitialAdapter.class, AdViewInterstitialManager.class),
    Native(4, AdViewNativeAdapter.class, AdViewNativeManager.class),
    RewardVideo(5, AdViewVideoAdapter.class, AdViewVideoManager.class),
    Template(6, AdViewTemplateAdapter.class, AdViewTemplateManager.class),
    FullVideo(7, AdViewFullVideoAdapter.class, AdViewFullVideoManager.class),
    DrawVideo(8, AdViewDrawVideoAdapter.class, AdViewDrawVideoManager.class);

    private static final Map<AdType, Constructor<? extends ManagerInfoAPI>> managerConstructors = new HashMap();
    private final Class<? extends AdapterAPI> adapterClass;
    private AdapterAPIManager<? extends AdapterAPI> apiManager;
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

    /* JADX WARN: Code duplicated, block: B:18:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public BaseBuilder<?> createDefaultBuilder(Context context) {
        Class cls;
        Class[] clsArr = {InnerSpreadBuilder.Default.class, InnerTemplateBuilder.Default.class, InnerVideoBuilder.Default.class, InnerInterstitialBuilder.Default.class, InnerNativeBuilder.Default.class, InnerBannerBuilder.Default.class, InnerDrawVideoBuilder.Default.class, InnerFullVideoBuilder.Default.class};
        for (int i = 0; i < 8; i++) {
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
                constructor = this.managerClass.getConstructor(new Class[0]);
                map.put(this, constructor);
            }
            return (T) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AdapterAPIManager<? extends AdapterAPI> getAdapterGenerator() {
        if (this.apiManager == null) {
            this.apiManager = new AdapterAPIManager<>(this.adapterClass);
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
