package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class PointToExtensionRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, LinkedHashSet<Class<? extends Extension>>> f24206a = new ConcurrentHashMap();

    public synchronized Collection<Class<? extends Extension>> getExtensionsByPoint(String str) {
        return this.f24206a.get(str);
    }

    public synchronized void registerExtension(Class<? extends Extension> cls) {
        for (Class<? extends Extension> cls2 : ReflectUtils.collectExtensionPoint(cls, null)) {
            LinkedHashSet<Class<? extends Extension>> linkedHashSet = this.f24206a.get(cls2.getName());
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                this.f24206a.put(cls2.getName(), linkedHashSet);
            }
            linkedHashSet.add(cls);
            ExtensionPoint.invalidateExtensionCache(cls2);
        }
    }
}
