package com.alibaba.ariver.kernel.api.extension.registry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class PointToExtensionStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<InstanceType, Map<String, LinkedHashSet<Class<? extends Extension>>>> f24207a = new HashMap();

    @Nullable
    public synchronized Collection<Class<? extends Extension>> getExtensionsByPoint(@NonNull InstanceType instanceType, String str) {
        Map<String, LinkedHashSet<Class<? extends Extension>>> map = this.f24207a.get(instanceType);
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized void registerExtension(@NonNull InstanceType instanceType, Class<? extends Extension> cls) {
        Map<String, LinkedHashSet<Class<? extends Extension>>> map = this.f24207a.get(instanceType);
        if (map == null) {
            map = new HashMap<>();
            this.f24207a.put(instanceType, map);
        }
        for (Class<? extends Extension> cls2 : ReflectUtils.collectExtensionPoint(cls, null)) {
            LinkedHashSet<Class<? extends Extension>> linkedHashSet = map.get(cls2.getName());
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                map.put(cls2.getName(), linkedHashSet);
            }
            linkedHashSet.add(cls);
            ExtensionPoint.invalidateExtensionCache(cls2);
        }
    }
}
