package com.alibaba.ariver.kernel.api.extension.registry;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.NativePermissionRequire;
import com.alibaba.ariver.kernel.api.annotation.ParamRequired;
import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class BridgeExtensionStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24202a = "AriverKernel:BridgeExtensionStore";
    private final Map<InstanceType, Map<String, ActionMeta>> b = new ConcurrentHashMap();
    private final Set<Class<? extends BridgeExtension>> c = new HashSet();
    private final Map<InstanceType, Map<String, ExtensionMetaInfo>> d = new ConcurrentHashMap();
    private Set<String> e = null;
    private PointToExtensionStore f = null;

    private void a(Class<? extends BridgeExtension> cls, boolean z) {
        register(cls, z, MultiInstanceUtils.getDefaultInstanceType());
    }

    public ActionMeta findActionMeta(String str) {
        return findActionMeta(MultiInstanceUtils.getDefaultInstanceType(), str);
    }

    public int getRegisteredActionCount() {
        return this.b.size() + this.d.size();
    }

    @NonNull
    public Map<String, ActionMeta> getRegisteredActionMethodMap(InstanceType instanceType) {
        Map<String, ActionMeta> concurrentHashMap = this.b.get(instanceType);
        if (concurrentHashMap == null) {
            synchronized (this.b) {
                concurrentHashMap = this.b.get(instanceType);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.b.put(instanceType, concurrentHashMap);
                }
            }
        }
        return concurrentHashMap;
    }

    public void register(ExtensionMetaInfo extensionMetaInfo) {
        InstanceType instanceType = extensionMetaInfo.getInstanceType();
        Map<String, ExtensionMetaInfo> concurrentHashMap = this.d.get(instanceType);
        if (concurrentHashMap == null) {
            synchronized (this.d) {
                concurrentHashMap = this.d.get(instanceType);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.d.put(instanceType, concurrentHashMap);
                }
            }
        }
        for (String str : extensionMetaInfo.filter) {
            if (concurrentHashMap.containsKey(str)) {
                RVLogger.w(f24202a, "register " + str + " override by " + extensionMetaInfo + " with instanceType: " + instanceType);
            } else if (RVKernelUtils.isDebug()) {
                RVLogger.w(f24202a, "register " + str + " with meta " + extensionMetaInfo);
            }
            concurrentHashMap.put(str, extensionMetaInfo);
        }
    }

    public void setPointToExtensionStore(PointToExtensionStore pointToExtensionStore) {
        this.f = pointToExtensionStore;
    }

    public void unRegister(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            RVLogger.d(f24202a, "unRegister \t" + str);
            Iterator<Map<String, ActionMeta>> it = this.b.values().iterator();
            while (it.hasNext()) {
                it.next().remove(str);
            }
        }
    }

    private List<ActionMeta> a(InstanceType instanceType, Class<? extends BridgeExtension> cls) {
        Method[] declaredMethods;
        ArrayList arrayList = new ArrayList();
        if (cls != null && cls.getDeclaredMethods() != null) {
            if (cls.getSuperclass() == null || !BridgeExtension.class.isAssignableFrom(cls.getSuperclass())) {
                declaredMethods = cls.getDeclaredMethods();
            } else {
                RVLogger.d(f24202a, "initActionMeta found has super BridgeExtension, getAllMethods!");
                declaredMethods = cls.getMethods();
            }
            Set<String> setA = a();
            for (Method method : declaredMethods) {
                try {
                    boolean z = true;
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    ActionFilter actionFilter = (ActionFilter) method.getAnnotation(ActionFilter.class);
                    if (actionFilter != null) {
                        String strValue = actionFilter.value();
                        if (strValue == null || strValue.length() <= 0) {
                            strValue = method.getName();
                        }
                        if (setA == null || !setA.contains(strValue)) {
                            ActionMeta actionMeta = new ActionMeta();
                            actionMeta.actionMethod = method;
                            actionMeta.paramRequired = method.getAnnotation(ParamRequired.class) != null;
                            actionMeta.bridgeExtensionClazz = cls;
                            if (method.getAnnotation(AutoCallback.class) == null) {
                                z = false;
                            }
                            actionMeta.autoCallback = z;
                            actionMeta.usePermission = (UsePermission) method.getAnnotation(UsePermission.class);
                            actionMeta.actionName = strValue;
                            actionMeta.paramTypes = method.getParameterTypes();
                            actionMeta.paramAnnotationArray = method.getParameterAnnotations();
                            NativePermissionRequire nativePermissionRequire = (NativePermissionRequire) method.getAnnotation(NativePermissionRequire.class);
                            if (nativePermissionRequire != null) {
                                actionMeta.nativePermissions = nativePermissionRequire.value();
                            }
                            if (!getRegisteredActionMethodMap(instanceType).containsKey(strValue)) {
                                arrayList.add(actionMeta);
                            } else if (actionFilter.canOverride()) {
                                getRegisteredActionMethodMap(instanceType).remove(strValue);
                                RVLogger.w(f24202a, "initActionMeta BridgeExtension action [" + strValue + "] override by " + cls.getName());
                                RVProxy.getPrinter().print("BridgeExtension action duplicate [" + strValue + "]");
                                arrayList.add(actionMeta);
                            } else {
                                RVLogger.w(f24202a, "BridgeExtension action [" + strValue + "] is not allow duplicate register");
                            }
                        } else {
                            RVLogger.d(f24202a, "ignore action:\t" + strValue);
                        }
                    }
                } catch (Throwable th) {
                    RVLogger.w(f24202a, "initActionMeta " + method + " exception!", th);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionMeta findActionMeta(@NonNull InstanceType instanceType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, ActionMeta> registeredActionMethodMap = getRegisteredActionMethodMap(instanceType);
        if (registeredActionMethodMap.get(str) == null) {
            synchronized (this.b) {
                if (registeredActionMethodMap.get(str) == null) {
                    Map<String, ExtensionMetaInfo> map = this.d.get(instanceType);
                    if (map == null) {
                        return null;
                    }
                    ExtensionMetaInfo extensionMetaInfoRemove = map.remove(str);
                    if (extensionMetaInfoRemove == null) {
                        RVLogger.w(f24202a, "findActionMeta failed for " + str + " instanceType: " + instanceType);
                        return null;
                    }
                    RVLogger.d(f24202a, "findActionMeta lazy init " + str + " instanceType: " + instanceType);
                    Class<? extends Extension> clsLoadClass = ClassLoaderUtils.loadClass(extensionMetaInfoRemove.bundleName, extensionMetaInfoRemove.extensionClass);
                    if (clsLoadClass == null) {
                        return null;
                    }
                    register(clsLoadClass, true, instanceType);
                }
            }
        }
        return registeredActionMethodMap.get(str);
    }

    public void register(Class<? extends BridgeExtension> cls) {
        a(cls, false);
    }

    public void register(Class<? extends BridgeExtension> cls, boolean z, @NonNull InstanceType instanceType) {
        PointToExtensionStore pointToExtensionStore;
        a(cls);
        List<ActionMeta> listA = a(instanceType, cls);
        if (listA.isEmpty()) {
            RVLogger.w(f24202a, "action method not found in bridgeExtension: " + cls);
            return;
        }
        for (ActionMeta actionMeta : listA) {
            RVLogger.d(f24202a, "register " + actionMeta + " with instanceType: " + instanceType);
            getRegisteredActionMethodMap(instanceType).put(actionMeta.actionName, actionMeta);
        }
        this.c.add(cls);
        if (!z || (pointToExtensionStore = this.f) == null) {
            return;
        }
        pointToExtensionStore.registerExtension(instanceType, cls);
    }

    private Set<String> a() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e != null) {
                    RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                    JSONArray jSONArray = rVConfigService != null ? JSONUtils.getJSONArray(rVConfigService.getConfigJSONObject("h5_jsapiandPluginsConfig"), "extensions", null) : null;
                    if (jSONArray != null && jSONArray.size() != 0) {
                        this.e = new HashSet();
                        int size = jSONArray.size();
                        for (int i = 0; i < size; i++) {
                            this.e.add(jSONArray.getString(i));
                        }
                    } else {
                        this.e = Collections.emptySet();
                    }
                }
            }
        }
        return this.e;
    }

    private void a(Class<? extends BridgeExtension> cls) {
        if (cls != null) {
            if (this.c.contains(cls)) {
                throw new IllegalArgumentException("extension has registered");
            }
            return;
        }
        throw new IllegalArgumentException("extension is null");
    }
}
