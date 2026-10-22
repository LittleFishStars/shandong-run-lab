package com.alibaba.ariver.resource.content;

import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GlobalPackagePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24442a = "AriverRes:GlobalPackagePool";
    private static final GlobalPackagePool b = new GlobalPackagePool();
    private Map<String, ResourcePackage> c = new ConcurrentHashMap();

    public static GlobalPackagePool getInstance() {
        return b;
    }

    public synchronized void add(ResourcePackage resourcePackage) {
        ResourcePackage resourcePackage2 = this.c.get(resourcePackage.appId());
        if (resourcePackage2 != null) {
            resourcePackage2.teardown();
            this.c.remove(resourcePackage2.appId());
            RVLogger.d(f24442a, "attach global resource package: " + resourcePackage2);
        }
        this.c.put(resourcePackage.appId(), resourcePackage);
        resourcePackage.setup(false);
    }

    public synchronized boolean contains(String str) {
        return this.c.containsKey(str);
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

    public synchronized ResourcePackage getPackage(@NonNull String str) {
        return this.c.get(str);
    }

    public synchronized Collection<ResourcePackage> getPackages() {
        return new HashSet(this.c.values());
    }

    public synchronized void remove(String str) {
        this.c.remove(str);
    }

    public synchronized void removeAll() {
        Set<String> setKeySet = this.c.keySet();
        if (setKeySet != null && !setKeySet.isEmpty()) {
            for (String str : setKeySet) {
                RVLogger.d(f24442a, "remove appId = " + str);
                ResourcePackage resourcePackageRemove = this.c.remove(str);
                if (resourcePackageRemove != null) {
                    resourcePackageRemove.teardown();
                }
            }
        }
        RVLogger.d(f24442a, "removeAll");
    }

    public synchronized void waitForSetup(String str) {
        if (this.c.containsKey(str)) {
            this.c.get(str).waitForSetup();
        }
    }

    public synchronized ResourcePackage add(String str) {
        ResourcePackage globalResourcePackage;
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Package_globalAdd_ + str);
            globalResourcePackage = this.c.get(str);
            if (globalResourcePackage == null) {
                if (RVConstants.TINY_WEB_COMMON_APPID.equalsIgnoreCase(str)) {
                    globalResourcePackage = new AppxResourcePackage(null);
                } else if (RVConstants.TINY_APPX_NG_APPID.equalsIgnoreCase(str)) {
                    globalResourcePackage = new AppxNgResourcePackage(null);
                } else {
                    globalResourcePackage = new GlobalResourcePackage(str);
                }
                this.c.put(globalResourcePackage.appId(), globalResourcePackage);
                globalResourcePackage.setup(false);
                RVLogger.d(f24442a, "attach global resource package: " + globalResourcePackage);
            }
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Package_globalAdd_ + str);
        } catch (Throwable th) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Package_globalAdd_ + str);
            throw th;
        }
        return globalResourcePackage;
    }
}
