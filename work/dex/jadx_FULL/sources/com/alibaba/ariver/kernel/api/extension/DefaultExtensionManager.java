package com.alibaba.ariver.kernel.api.extension;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.BridgeDSLRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultExtensionManager implements ExtensionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24197a = "AriverKernel:ExtensionManager";
    private static ExtensionCreator b;
    private ExtensionRegistry c;
    private BridgeDSLRegistry d;
    private AccessController e;
    private RemoteController f;
    private final Map<Class<? extends Extension>, ExtensionFilter> g = new ConcurrentHashMap();
    private final Map<Class<? extends Extension>, Comparator> h = new ConcurrentHashMap();
    private final Map<String, Extension> i = new HashMap();
    private final Map<Node, Map<String, Extension>> j = new HashMap();
    private final Map<Node, Map<Class<? extends Extension>, List<Extension>>> k = new HashMap();

    public interface ExtensionCreator {
        Extension createExtensionInstance(Class<? extends Extension> cls);
    }

    public DefaultExtensionManager(AccessController accessController, RemoteController remoteController, ExtensionRegistry extensionRegistry) {
        this.e = accessController;
        this.f = remoteController;
        remoteController.bindExtensionManager(this);
        this.c = extensionRegistry;
    }

    private List<Extension> a(Node node, Class<? extends Extension> cls) {
        List<Extension> list;
        ArrayList arrayList = new ArrayList();
        while (node != null) {
            if (this.k.get(node) != null && (list = this.k.get(node).get(cls)) != null) {
                arrayList.addAll(list);
            }
            node = node.getParentNode();
        }
        return arrayList;
    }

    private synchronized List<? extends Extension> b(Node node, Class<? extends Extension> cls) {
        Extension extensionA;
        try {
            Collection<Class<? extends Extension>> collectionFindExtensions = this.c.findExtensions(node == null ? MultiInstanceUtils.getDefaultInstanceType() : node.getInstanceType(), cls.getName());
            if (collectionFindExtensions == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (Class<? extends Extension> cls2 : collectionFindExtensions) {
                Class<? extends Scope> scope = this.c.getScope(cls2);
                if (scope == null) {
                    Extension extensionA2 = a(this.i, cls2);
                    if (extensionA2 != null) {
                        linkedList.add(extensionA2);
                    }
                } else {
                    Node parentNode = node;
                    while (parentNode != null && !scope.isAssignableFrom(parentNode.getClass())) {
                        parentNode = parentNode.getParentNode();
                    }
                    if (parentNode != null && (extensionA = a(this.j.get(parentNode), cls2)) != null) {
                        linkedList.add(extensionA);
                    }
                }
            }
            return linkedList;
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    public static void setExtensionCreator(ExtensionCreator extensionCreator) {
        b = extensionCreator;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public synchronized void enterNode(Node node) {
        RVLogger.d(f24197a, "enterNode " + node);
        this.j.put(node, new HashMap());
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public synchronized void exitNode(Node node) {
        RVLogger.d(f24197a, "exitNode " + node);
        ExtensionPoint.exitNode(node);
        Map<String, Extension> mapRemove = this.j.remove(node);
        if (mapRemove != null) {
            for (Extension extension : mapRemove.values()) {
                RVLogger.debug(f24197a, "finalize " + extension + " from exitNode");
                extension.onFinalized();
            }
            mapRemove.clear();
        }
        Map<Class<? extends Extension>, List<Extension>> mapRemove2 = this.k.remove(node);
        if (mapRemove2 != null) {
            for (List<Extension> list : mapRemove2.values()) {
                HashSet hashSet = new HashSet();
                for (Extension extension2 : list) {
                    if (!hashSet.contains(extension2)) {
                        RVLogger.debug(f24197a, "exitNode finalize" + extension2);
                        extension2.onFinalized();
                        hashSet.add(extension2);
                    }
                }
            }
            mapRemove2.clear();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ActionMeta findActionMeta(Node node, String str) {
        InstanceType defaultInstanceType;
        InstanceType defaultInstanceType2 = node == null ? MultiInstanceUtils.getDefaultInstanceType() : node.getInstanceType();
        if (defaultInstanceType2 == null || defaultInstanceType2 == (defaultInstanceType = MultiInstanceUtils.getDefaultInstanceType())) {
            return this.c.findActionMeta(defaultInstanceType2, str);
        }
        ActionMeta actionMetaFindActionMeta = this.c.findActionMeta(defaultInstanceType2, str);
        if (actionMetaFindActionMeta == null) {
            return this.c.findActionMeta(defaultInstanceType, str);
        }
        RVLogger.d(f24197a, "findActionMeta with instanceType: " + defaultInstanceType2 + " result: " + actionMetaFindActionMeta);
        return actionMetaFindActionMeta;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public AccessController getAccessController() {
        return this.e;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public BridgeDSLRegistry getBridgeDSLRegistry() {
        return this.d;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<BridgeDSL> getBridgeDSLs() {
        BridgeDSLRegistry bridgeDSLRegistry = this.d;
        return bridgeDSLRegistry != null ? bridgeDSLRegistry.getBridgeDSLs() : new ArrayList();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public BridgeExtension getBridgeExtensionByActionMeta(Node node, ActionMeta actionMeta) {
        Class<? extends Scope> scope = this.c.getScope(actionMeta.bridgeExtensionClazz);
        if (scope == null) {
            return a(actionMeta.actionName, actionMeta);
        }
        if (!scope.isAssignableFrom(node.getClass())) {
            return getBridgeExtensionByActionMeta(node.getParentNode(), actionMeta);
        }
        Map map = this.j.get(node);
        if (map == null) {
            return null;
        }
        if (map.get(actionMeta.bridgeExtensionClazz.getName()) != null) {
            return (BridgeExtension) map.get(actionMeta.bridgeExtensionClazz.getName());
        }
        BridgeExtension bridgeExtension = (BridgeExtension) a(actionMeta.bridgeExtensionClazz);
        map.put(actionMeta.bridgeExtensionClazz.getName(), bridgeExtension);
        return bridgeExtension;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public Extension getExtensionByName(Node node, String str) {
        Extension extensionA;
        ExtensionRegistry extensionRegistry = this.c;
        if (extensionRegistry == null) {
            throw new RuntimeException("ExtensionRegistry not setup");
        }
        try {
            Class<? extends Extension> extensionClass = extensionRegistry.getExtensionClass(str);
            Class<? extends Scope> scope = this.c.getScope(str);
            if (scope == null) {
                extensionA = a(this.i, extensionClass);
            } else {
                Node parentNode = node;
                while (parentNode != null && !scope.isAssignableFrom(parentNode.getClass())) {
                    parentNode = parentNode.getParentNode();
                }
                extensionA = parentNode != null ? a(this.j.get(parentNode), extensionClass) : null;
            }
            if (extensionA == null) {
                RVLogger.w(f24197a, "getExtensionByName found null for extensionName: " + str + ", node: " + node + ", clazz: " + extensionClass + ", scope: " + scope);
            }
            return extensionA;
        } catch (Throwable th) {
            RVLogger.w(f24197a, "getExtensionByName", th);
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<Extension> getExtensionByPoint(Class<? extends Extension> cls) {
        return getExtensionByPoint(null, cls);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ExtensionRegistry getExtensionRegistry() {
        return this.c;
    }

    public Map<Node, Map<String, Extension>> getNodeExtensionMap() {
        return this.j;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public RemoteController getRemoteController() {
        return this.f;
    }

    public Map<String, Extension> getSingletonExtensionMap() {
        return this.i;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public <T extends Extension> void registerExtensionByPoint(Node node, Class<T> cls, T t) {
        if (node != null) {
            Map<Class<? extends Extension>, List<Extension>> concurrentHashMap = this.k.get(node);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.k.put(node, concurrentHashMap);
            }
            List<Extension> copyOnWriteArrayList = concurrentHashMap.get(cls);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                concurrentHashMap.put(cls, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(t);
            ExtensionPoint.invalidateExtensionCache(node, cls);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setAccessControlManagement(AccessControlManagement accessControlManagement) {
        AccessController accessController = this.e;
        if (accessController != null) {
            accessController.setAccessControlManagement(accessControlManagement);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setExtensionFilter(Class<? extends Extension> cls, ExtensionFilter extensionFilter) {
        this.g.put(cls, extensionFilter);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public <T extends Extension> void setExtensionSorter(Class<T> cls, Comparator<? super T> comparator) {
        this.h.put(cls, comparator);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public void setRemoteControlManagement(RemoteControlManagement remoteControlManagement) {
        RemoteController remoteController = this.f;
        if (remoteController != null) {
            remoteController.setRemoteControlManagement(remoteControlManagement);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public List<Extension> getExtensionByPoint(Node node, Class<? extends Extension> cls) {
        if (this.c == null) {
            throw new RuntimeException("ExtensionRegistry not setup");
        }
        RVLogger.d(f24197a, "getExtensionsByPoint " + cls.getName());
        List<Extension> arrayList = new ArrayList<>();
        List<? extends Extension> listB = b(node, cls);
        if (listB != null) {
            arrayList.addAll(listB);
        }
        List<Extension> listA = a(node, cls);
        if (listA != null) {
            arrayList.addAll(listA);
        }
        if (arrayList.isEmpty()) {
            RVLogger.w(f24197a, "cannot find extension by point: " + cls);
            return null;
        }
        ExtensionFilter extensionFilter = this.g.get(cls);
        if (extensionFilter != null) {
            arrayList = extensionFilter.filter(arrayList);
        }
        Comparator comparator = this.h.get(cls);
        if (comparator != null) {
            Collections.sort(arrayList, comparator);
        } else if (SimpleSorter.class.isAssignableFrom(cls)) {
            Collections.sort(arrayList, new Comparator<Extension>() { // from class: com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager.1
                @Override // java.util.Comparator
                public int compare(Extension extension, Extension extension2) {
                    return (SimpleSortable.class.isAssignableFrom(extension2.getClass()) ? ((SimpleSortable) extension2).priority() : 0) - (SimpleSortable.class.isAssignableFrom(extension.getClass()) ? ((SimpleSortable) extension).priority() : 0);
                }
            });
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[Catch: all -> 0x000e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:12:0x0015, B:23:0x0040), top: B:32:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0025 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0012 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0025, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0012, please report this as an issue */
    private synchronized BridgeExtension a(String str, @Nullable ActionMeta actionMeta) {
        BridgeExtension bridgeExtension;
        BridgeExtension bridgeExtension2;
        Throwable th;
        if (actionMeta != null) {
            if (actionMeta == null) {
                return null;
            }
            bridgeExtension = (BridgeExtension) this.i.get(actionMeta.bridgeExtensionClazz.getName());
            if (bridgeExtension != null) {
                return bridgeExtension;
            }
            bridgeExtension2 = (BridgeExtension) a(actionMeta.bridgeExtensionClazz);
            this.i.put(actionMeta.bridgeExtensionClazz.getName(), bridgeExtension2);
            return bridgeExtension2;
        }
        actionMeta = this.c.findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
        if (actionMeta == null) {
            return null;
        }
        bridgeExtension = (BridgeExtension) this.i.get(actionMeta.bridgeExtensionClazz.getName());
        if (bridgeExtension != null) {
            return bridgeExtension;
        }
        try {
            bridgeExtension2 = (BridgeExtension) a(actionMeta.bridgeExtensionClazz);
            try {
                this.i.put(actionMeta.bridgeExtensionClazz.getName(), bridgeExtension2);
            } catch (Throwable th2) {
                th = th2;
                RVLogger.e(f24197a, th);
            }
        } catch (Throwable th3) {
            bridgeExtension2 = bridgeExtension;
            th = th3;
        }
        return bridgeExtension2;
        throw th;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionManager
    public ActionMeta findActionMeta(@NonNull InstanceType instanceType, Node node, String str) {
        return this.c.findActionMeta(instanceType, str);
    }

    public DefaultExtensionManager(AccessController accessController, RemoteController remoteController, ExtensionRegistry extensionRegistry, BridgeDSLRegistry bridgeDSLRegistry) {
        this.e = accessController;
        this.f = remoteController;
        remoteController.bindExtensionManager(this);
        this.c = extensionRegistry;
        this.d = bridgeDSLRegistry;
    }

    private static Extension a(Map<String, Extension> map, Class<? extends Extension> cls) {
        if (map == null || cls == null) {
            return null;
        }
        Extension extensionA = map.get(cls.getName());
        if (extensionA != null) {
            return extensionA;
        }
        try {
            extensionA = a(cls);
            map.put(cls.getName(), extensionA);
            return extensionA;
        } catch (Throwable th) {
            RVLogger.e(f24197a, cls + " failed to initialize", th);
            return extensionA;
        }
    }

    private static Extension a(Class<? extends Extension> cls) throws IllegalAccessException, InstantiationException {
        Extension extensionNewInstance;
        RVLogger.d(f24197a, "createExtensionInstance " + cls.getName());
        ExtensionCreator extensionCreator = b;
        if (extensionCreator != null) {
            extensionNewInstance = extensionCreator.createExtensionInstance(cls);
        } else {
            extensionNewInstance = cls.newInstance();
        }
        extensionNewInstance.onInitialized();
        return extensionNewInstance;
    }
}
