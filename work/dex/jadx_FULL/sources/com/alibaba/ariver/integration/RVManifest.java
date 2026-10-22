package com.alibaba.ariver.integration;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVManifest {

    public static class BridgeExtensionManifest {
        List<BridgeDSL> bridgeDSLs;
        ExtensionMetaInfo extensionMetaInfo;
        InstanceType instanceType;
        boolean isRawType;
        Class<? extends Scope> scope;
        Class<? extends BridgeExtension> target;

        private BridgeExtensionManifest() {
        }

        public static BridgeExtensionManifest make(Class<? extends BridgeExtension> cls) {
            return make(cls, null);
        }

        public static BridgeExtensionManifest makeRaw(String str, String str2, List<String> list) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.isRawType = true;
            bridgeExtensionManifest.extensionMetaInfo = new ExtensionMetaInfo(str, str2, list, (Class<? extends Scope>) null, ExtensionType.BRIDGE, true);
            return bridgeExtensionManifest;
        }

        public void addBridgeExtensionDSL(BridgeDSL bridgeDSL) {
            if (this.bridgeDSLs == null) {
                this.bridgeDSLs = new ArrayList();
            }
            this.bridgeDSLs.add(bridgeDSL);
        }

        public BridgeExtensionManifest instanceType(InstanceType instanceType) {
            ExtensionMetaInfo extensionMetaInfo;
            if (!this.isRawType || (extensionMetaInfo = this.extensionMetaInfo) == null) {
                this.instanceType = instanceType;
            } else {
                extensionMetaInfo.instanceType(instanceType);
            }
            return this;
        }

        public String toString() {
            return "BridgeExtensionManifest{target=" + this.target + ", scope=" + this.scope + '}';
        }

        public static BridgeExtensionManifest make(Class<? extends BridgeExtension> cls, Class<? extends Scope> cls2) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.target = cls;
            bridgeExtensionManifest.scope = cls2;
            return bridgeExtensionManifest;
        }

        public static BridgeExtensionManifest makeRaw(String str, String str2, List<String> list, Class<? extends Scope> cls) {
            BridgeExtensionManifest bridgeExtensionManifest = new BridgeExtensionManifest();
            bridgeExtensionManifest.isRawType = true;
            bridgeExtensionManifest.extensionMetaInfo = new ExtensionMetaInfo(str, str2, list, cls, ExtensionType.BRIDGE, true);
            return bridgeExtensionManifest;
        }
    }

    public static abstract class IProxyManifest {
        InstanceType instanceType;

        public InstanceType getInstanceType() {
            return this.instanceType;
        }

        public IProxyManifest instanceType(@NonNull InstanceType instanceType) {
            this.instanceType = instanceType;
            return this;
        }
    }

    @Deprecated
    public static class ProxyManifest extends IProxyManifest {
        Proxiable implObject;
        Class<? extends Proxiable> proxiableClass;

        public ProxyManifest(Class<? extends Proxiable> cls, Proxiable proxiable) {
            RVProxy.getPrinter().print("new ProxyManifest " + cls);
            this.proxiableClass = cls;
            this.implObject = proxiable;
        }

        public String toString() {
            return "ProxyManifest{proxiableClass=" + this.proxiableClass + ", implObject=" + this.implObject + '}';
        }
    }

    public static class ServiceBeanManifest<T> {
        Class<T> beanClass;
        RVProxy.LazyGetter<T> beanObject;

        public ServiceBeanManifest(Class<T> cls, RVProxy.LazyGetter<T> lazyGetter) {
            this.beanClass = cls;
            this.beanObject = lazyGetter;
        }
    }

    @Nullable
    AccessController getAccessController();

    List<AppUpdaterFactory.Rule> getAppUpdaterRules();

    List<BridgeDSL> getBridgeDSLs();

    List<BridgeExtensionManifest> getBridgeExtensions();

    @Nullable
    Map<String, EmbedViewMetaInfo> getEmbedViews();

    List<ExtensionMetaInfo> getExtensions();

    List<IProxyManifest> getProxies();

    @Nullable
    RemoteController getRemoteController();

    List<ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager);

    public static class LazyProxyManifest<T extends Proxiable> extends IProxyManifest {
        String implClass;
        String implClassBundle;
        RVProxy.LazyGetter<T> implObject;
        Class<T> proxiableClass;

        public LazyProxyManifest(Class<T> cls, RVProxy.LazyGetter<T> lazyGetter) {
            RVProxy.getPrinter().print("new LazyProxyManifest " + cls);
            this.proxiableClass = cls;
            this.implObject = lazyGetter;
        }

        public String toString() {
            return "LazyProxyManifest{proxiableClass=" + this.proxiableClass + ", implObject=" + this.implObject + '}';
        }

        public LazyProxyManifest(final Class<T> cls, final String str, final String str2) {
            RVProxy.getPrinter().print("new LazyProxyManifest " + cls + " with class: " + str2);
            this.proxiableClass = cls;
            this.implClassBundle = str;
            this.implClass = str2;
            this.implObject = (RVProxy.LazyGetter<T>) new RVProxy.LazyGetter<T>() { // from class: com.alibaba.ariver.integration.RVManifest.LazyProxyManifest.1
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public T get() {
                    try {
                        Class<?> clsLoadClass = ((RVClassLoaderFactory) RVProxy.get(RVClassLoaderFactory.class)).getClassLoader(str).loadClass(str2);
                        if (cls.isAssignableFrom(clsLoadClass)) {
                            return (T) clsLoadClass.newInstance();
                        }
                        RVProxy.getPrinter().print(cls + " with implClassName: " + str2 + " type error!!!");
                        return null;
                    } catch (Throwable th) {
                        RVProxy.getPrinter().print(cls + " with implClassName: " + str2 + " init failed!!! " + Log.getStackTraceString(th));
                        return null;
                    }
                }
            };
        }
    }
}
