package com.alibaba.ariver.kernel.api.extension.registry;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultExtensionRegistry implements ExtensionRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24204a = "AriverKernel:DefaultExtensionRegistry";
    private BridgeExtensionStore b;
    private final Set<Class<? extends Extension>> c = new HashSet();
    private final Map<String, List<ExtensionMetaInfo>> d = new HashMap();
    private final Map<String, Class<? extends Scope>> e = new HashMap();
    private final PointToExtensionStore f;
    private final List<ExtensionMetaInfo> g;

    public DefaultExtensionRegistry() {
        PointToExtensionStore pointToExtensionStore = new PointToExtensionStore();
        this.f = pointToExtensionStore;
        this.g = new LinkedList();
        BridgeExtensionStore bridgeExtensionStore = new BridgeExtensionStore();
        this.b = bridgeExtensionStore;
        bridgeExtensionStore.setPointToExtensionStore(pointToExtensionStore);
    }

    private void a(String str, Class<? extends Scope> cls) {
        if (this.e.containsKey(str)) {
            return;
        }
        this.e.put(str, cls);
    }

    public Extension createExtensionInstance(Class<? extends Extension> cls) {
        return cls.newInstance();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public ActionMeta findActionMeta(@Nullable InstanceType instanceType, String str) {
        return instanceType != null ? this.b.findActionMeta(instanceType, str) : this.b.findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    @Nullable
    public Collection<Class<? extends Extension>> findExtensions(String str) {
        return findExtensions(null, str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public int getActionCount() {
        return this.b.getRegisteredActionCount();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Extension> getExtensionClass(String str) {
        for (Class<? extends Extension> cls : this.c) {
            if (cls.getName().equals(str)) {
                return cls;
            }
        }
        for (ExtensionMetaInfo extensionMetaInfo : this.g) {
            if (str.equals(extensionMetaInfo.extensionClass)) {
                return ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
            }
        }
        return null;
    }

    @VisibleForTesting
    public PointToExtensionStore getPointToExtensionStore() {
        return this.f;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Scope> getScope(String str) {
        return this.e.get(str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public synchronized void register(Class<? extends Extension> cls) {
        register(cls, null);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public void unRegister(List<String> list) {
        this.b.unRegister(list);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    @Nullable
    public Collection<Class<? extends Extension>> findExtensions(@Nullable InstanceType instanceType, String str) {
        Collection<Class<? extends Extension>> extensionsByPoint;
        List<ExtensionMetaInfo> list = this.d.get(str);
        if (list != null) {
            for (ExtensionMetaInfo extensionMetaInfo : list) {
                Class<? extends Extension> clsLoadClass = ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
                if (clsLoadClass == null) {
                    RVLogger.e(f24204a, "load meta " + extensionMetaInfo.extensionClass + " error!");
                } else {
                    synchronized (this.c) {
                        if (!this.c.contains(clsLoadClass)) {
                            register(clsLoadClass, extensionMetaInfo.scope, extensionMetaInfo.getInstanceType());
                        }
                    }
                }
            }
            this.d.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        if (instanceType != null && instanceType != MultiInstanceUtils.getDefaultInstanceType() && (extensionsByPoint = this.f.getExtensionsByPoint(instanceType, str)) != null) {
            arrayList.addAll(extensionsByPoint);
        }
        Collection<Class<? extends Extension>> extensionsByPoint2 = this.f.getExtensionsByPoint(MultiInstanceUtils.getDefaultInstanceType(), str);
        if (extensionsByPoint2 != null) {
            arrayList.addAll(extensionsByPoint2);
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public Class<? extends Scope> getScope(Class<? extends Extension> cls) {
        return getScope(cls.getName());
    }

    private void a(Class<? extends Extension> cls, Class<? extends Scope> cls2) {
        a(cls.getName(), cls2);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public synchronized void register(Class<? extends Extension> cls, @Nullable Class<? extends Scope> cls2) {
        register(cls, cls2, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[Catch: all -> 0x0085, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0007, B:12:0x0024, B:14:0x002c, B:17:0x0049, B:18:0x004b, B:27:0x0078, B:32:0x0084, B:11:0x001b, B:19:0x004c, B:21:0x0054, B:22:0x006f, B:25:0x0072, B:26:0x0077, B:7:0x000f), top: B:37:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0007, B:12:0x0024, B:14:0x002c, B:17:0x0049, B:18:0x004b, B:27:0x0078, B:32:0x0084, B:11:0x001b, B:19:0x004c, B:21:0x0054, B:22:0x006f, B:25:0x0072, B:26:0x0077, B:7:0x000f), top: B:37:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0049 A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0007, B:12:0x0024, B:14:0x002c, B:17:0x0049, B:18:0x004b, B:27:0x0078, B:32:0x0084, B:11:0x001b, B:19:0x004c, B:21:0x0054, B:22:0x006f, B:25:0x0072, B:26:0x0077, B:7:0x000f), top: B:37:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:19:0x004c, B:21:0x0054, B:22:0x006f, B:25:0x0072, B:26:0x0077), top: B:36:0x004c, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0072 A[Catch: all -> 0x0082, TRY_ENTER, TryCatch #0 {, blocks: (B:19:0x004c, B:21:0x0054, B:22:0x006f, B:25:0x0072, B:26:0x0077), top: B:36:0x004c, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x000f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x002c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0054, please report this as an issue */
    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public synchronized void register(Class<? extends Extension> cls, @Nullable Class<? extends Scope> cls2, InstanceType instanceType) {
        if (instanceType == null) {
            instanceType = MultiInstanceUtils.getDefaultInstanceType();
            if (BridgeExtension.class.isAssignableFrom(cls)) {
                try {
                    this.b.register(cls, true, instanceType);
                    a(cls, cls2);
                    return;
                } catch (Throwable th) {
                    RVLogger.w(f24204a, cls.getSimpleName(), th);
                    if (!Extension.class.isAssignableFrom(cls)) {
                        RVLogger.e(f24204a, "Class " + cls + " is not valid extension");
                        return;
                    }
                    synchronized (this.c) {
                        if (this.c.contains(cls)) {
                            RVLogger.e(f24204a, "Extension " + cls + " is already registered");
                            return;
                        }
                        this.c.add(cls);
                        a(cls, cls2);
                        this.f.registerExtension(instanceType, cls);
                        return;
                    }
                }
            }
            if (!Extension.class.isAssignableFrom(cls)) {
                RVLogger.e(f24204a, "Class " + cls + " is not valid extension");
                return;
            }
            synchronized (this.c) {
                if (this.c.contains(cls)) {
                    RVLogger.e(f24204a, "Extension " + cls + " is already registered");
                    return;
                }
                this.c.add(cls);
                a(cls, cls2);
                this.f.registerExtension(instanceType, cls);
                return;
            }
        }
        if (BridgeExtension.class.isAssignableFrom(cls)) {
            this.b.register(cls, true, instanceType);
            a(cls, cls2);
            return;
        }
        if (!Extension.class.isAssignableFrom(cls)) {
            RVLogger.e(f24204a, "Class " + cls + " is not valid extension");
            return;
        }
        synchronized (this.c) {
            if (this.c.contains(cls)) {
                RVLogger.e(f24204a, "Extension " + cls + " is already registered");
                return;
            }
            this.c.add(cls);
            a(cls, cls2);
            this.f.registerExtension(instanceType, cls);
            return;
        }
        throw th;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry
    public synchronized void register(ExtensionMetaInfo extensionMetaInfo) {
        ExtensionType extensionType = extensionMetaInfo.type;
        ExtensionType extensionType2 = ExtensionType.BRIDGE;
        if (extensionType == extensionType2) {
            RVLogger.d(f24204a, "register meta: " + extensionMetaInfo.extensionClass);
        } else {
            RVLogger.debug(f24204a, "register meta: " + extensionMetaInfo.extensionClass);
        }
        if (!extensionMetaInfo.isLazy) {
            ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
        }
        ExtensionType extensionType3 = ExtensionType.NORMAL;
        ExtensionType extensionType4 = extensionMetaInfo.type;
        if (extensionType3 == extensionType4) {
            List<String> list = extensionMetaInfo.filter;
            if (list != null && list.size() > 0) {
                for (String str : extensionMetaInfo.filter) {
                    List<ExtensionMetaInfo> linkedList = this.d.get(str);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(extensionMetaInfo);
                    this.d.put(str, linkedList);
                }
            }
        } else if (extensionType2 == extensionType4) {
            this.b.register(extensionMetaInfo);
        }
        a(extensionMetaInfo.extensionClass, extensionMetaInfo.scope);
        this.g.add(extensionMetaInfo);
    }
}
