package com.alibaba.ariver.resource.runtime;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.RefAware;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ResourceContextManager {
    private static final String TAG = "Ariver:ResourceContextManager";
    private static volatile ResourceContextManager instance;
    private final Map<String, RefAware<ResourceContext>> resourceContextMap = new ConcurrentHashMap();

    public static ResourceContextManager getInstance() {
        if (instance == null) {
            synchronized (ResourceContextManager.class) {
                if (instance == null) {
                    instance = new ResourceContextManager();
                }
            }
        }
        return instance;
    }

    @NonNull
    private synchronized RefAware<ResourceContext> getRef(String str) {
        RefAware<ResourceContext> refAware;
        refAware = this.resourceContextMap.get(str);
        if (refAware == null) {
            ResourceContext resourceContext = new ResourceContext();
            resourceContext.setAppId(str);
            RefAware<ResourceContext> refAware2 = new RefAware<>(resourceContext);
            this.resourceContextMap.put(str, refAware2);
            refAware = refAware2;
        }
        return refAware;
    }

    public ResourceContext get(String str) {
        return getRef(str).get();
    }

    public void onAppDestroy(String str) {
        RefAware<ResourceContext> refAware = this.resourceContextMap.get(str);
        if (refAware == null) {
            return;
        }
        boolean zDecrementRef = refAware.decrementRef();
        RVLogger.d(TAG, "onAppDestroy " + str + " needDestroy " + zDecrementRef);
        if (zDecrementRef) {
            this.resourceContextMap.remove(str);
            refAware.get().releaseResourcePackages();
        }
    }

    public ResourceContext onAppLoad(String str) {
        RVLogger.d(TAG, "onAppLoad " + str + " increment ref");
        RefAware<ResourceContext> ref = getRef(str);
        ref.incrementRef();
        return ref.get();
    }
}
