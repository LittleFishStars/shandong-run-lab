package com.alibaba.ariver.resource.content;

import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourcePackagePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24447a = "AriverRes:PackagePool";
    private static final ResourcePackagePool b = new ResourcePackagePool();
    private final Map<String, ResourcePackage> c = new ConcurrentHashMap();
    private final Map<String, Integer> d = new ConcurrentHashMap();

    private void a(String str) {
        if (!this.d.containsKey(str)) {
            this.d.put(str, 1);
        } else {
            Map<String, Integer> map = this.d;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        }
    }

    private boolean b(String str) {
        if (this.d.containsKey(str)) {
            int iIntValue = this.d.get(str).intValue() - 1;
            this.d.put(str, Integer.valueOf(iIntValue));
            boolean z = iIntValue == 0;
            if (z) {
                this.d.remove(str);
            }
            return z;
        }
        RVLogger.w(f24447a, "cannot detach " + str + " because it not attached!");
        return true;
    }

    public static ResourcePackagePool getInstance() {
        return b;
    }

    public synchronized void attach(ResourcePackage resourcePackage) {
        String strAppId = resourcePackage.appId();
        if (!this.c.containsKey(strAppId)) {
            RVLogger.d(f24447a, "attach resource package: " + strAppId);
            resourcePackage.setup(false);
            this.c.put(strAppId, resourcePackage);
        }
        a(strAppId);
    }

    public boolean contains(String str) {
        return this.c.containsKey(str);
    }

    public synchronized void detach(String str) {
        if (b(str)) {
            RVLogger.d(f24447a, "detach resource package: " + str);
            ResourcePackage resourcePackageRemove = this.c.remove(str);
            if (resourcePackageRemove != null) {
                resourcePackageRemove.teardown();
            }
        }
    }

    public Resource get(@NonNull ResourceQuery resourceQuery) {
        Iterator<ResourcePackage> it = this.c.values().iterator();
        while (it.hasNext()) {
            Resource resource = it.next().get(resourceQuery);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    public ResourcePackage getPackage(@NonNull String str) {
        return this.c.get(str);
    }

    public synchronized void removeAll() {
        Set<String> setKeySet = this.c.keySet();
        if (setKeySet != null && !setKeySet.isEmpty()) {
            for (String str : setKeySet) {
                RVLogger.d(f24447a, "remove appId = " + str);
                ResourcePackage resourcePackageRemove = this.c.remove(str);
                if (resourcePackageRemove != null) {
                    resourcePackageRemove.teardown();
                }
            }
        }
        RVLogger.d(f24447a, "removeAll");
    }

    public synchronized ResourcePackage attach(String str, ResourceContext resourceContext) {
        ResourcePackage normalResourcePackage;
        if (GlobalPackagePool.getInstance().contains(str)) {
            return GlobalPackagePool.getInstance().getPackage(str);
        }
        if (!this.c.containsKey(str)) {
            RVLogger.d(f24447a, "attach resource package: " + str);
            if (RVConstants.TINY_WEB_COMMON_APPID.equalsIgnoreCase(str)) {
                normalResourcePackage = new AppxResourcePackage(resourceContext);
            } else {
                normalResourcePackage = new NormalResourcePackage(str, resourceContext);
            }
            normalResourcePackage.setup(false);
            this.c.put(str, normalResourcePackage);
        } else {
            normalResourcePackage = this.c.get(str);
        }
        a(str);
        return normalResourcePackage;
    }
}
