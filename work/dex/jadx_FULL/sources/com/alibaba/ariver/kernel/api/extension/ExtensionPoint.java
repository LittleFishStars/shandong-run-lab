package com.alibaba.ariver.kernel.api.extension;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.invoke.InvocationHandlerWrapper;
import com.alibaba.ariver.kernel.api.invoke.RemoteNormalExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ResolveExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.ValueStore;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtensionPoint<T extends Extension> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24198a = "AriverKernel:ExtensionPoint";
    private static ExtensionManager b = null;
    private static final int c = 10;
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static int e = 10;
    private static boolean f = true;
    private static final Map<Long, LruCache<Class<? extends Extension>, Extension>> g = new ConcurrentHashMap();
    private static Map<Class, ProxyGenerator> s = new ConcurrentHashMap();
    private static Map<Class<? extends Extension>, Extension> t = new ConcurrentHashMap();
    private Node h;
    private Class<T> i;
    private Object j;
    private ResultResolver k;
    private boolean l;
    private ExtensionManager o;
    private boolean m = true;
    private ExecutorType n = ExecutorType.SYNC;
    private Map<Action, ExecutorType> p = new HashMap();
    private Object q = new Object();
    private InvocationHandler r = new InvocationHandler() { // from class: com.alibaba.ariver.kernel.api.extension.ExtensionPoint.1
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(ExtensionPoint.this.q, objArr);
            }
            Object defaultValue = ExtensionPoint.this.j;
            if (defaultValue == null) {
                defaultValue = ReflectUtils.getDefaultValue(method.getReturnType());
            }
            ActionCallback actionCallback = new ActionCallback(ExtensionPoint.this.p, defaultValue);
            actionCallback.onStart(null);
            actionCallback.onComplete(null);
            return defaultValue;
        }
    };

    public interface ProxyGenerator<T> {
        T createProxyInstance(InvocationHandler invocationHandler);
    }

    private ExtensionPoint(Class<T> cls) {
        this.i = cls;
    }

    private void a() {
        if (d.getAndSet(true)) {
            return;
        }
        e = TypeUtils.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ariver_extensionPointCacheCount", String.valueOf(10), new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.kernel.api.extension.ExtensionPoint.2
            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public void onChange(String str) {
                int unused = ExtensionPoint.e = TypeUtils.parseInt(str);
                RVLogger.d(ExtensionPoint.f24198a, "onChange sMasCacheCount: " + ExtensionPoint.e);
            }
        }));
        f = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_createExtWhenFinalized", true);
        RVLogger.d(f24198a, "initConfig sMasCacheCount: " + e);
    }

    public static <T extends Extension> ExtensionPoint<T> as(Class<T> cls) {
        return new ExtensionPoint<>(cls);
    }

    private InvocationHandler b() {
        Extension extensionD;
        if (!c()) {
            RVLogger.w(f24198a, "create extension: " + this.i + " when node isFinalized! can create? " + f);
            if (!f) {
                if (this.l) {
                    return null;
                }
                return this.r;
            }
        }
        ExtensionManager extensionManager = this.o;
        if (extensionManager == null) {
            extensionManager = b;
        }
        List<Extension> extensionByPoint = extensionManager != null ? extensionManager.getExtensionByPoint(this.h, this.i) : null;
        if ((extensionByPoint == null || extensionByPoint.size() == 0) && (extensionD = d()) != null) {
            extensionByPoint = Collections.singletonList(extensionD);
        }
        if (extensionByPoint != null && !extensionByPoint.isEmpty()) {
            ExtensionInvoker extensionInvokerA = a(extensionManager);
            extensionInvokerA.attacheTargetExtensions(extensionByPoint);
            return new InvocationHandlerWrapper(this.i, extensionInvokerA);
        }
        RVLogger.w("AriverKernel", "cannot find extension for " + this.i);
        if (this.l) {
            return null;
        }
        return this.r;
    }

    public static void bind(ExtensionManager extensionManager) {
        b = extensionManager;
    }

    private boolean c() {
        Node node = this.h;
        if (node == null) {
            RVLogger.w(f24198a, "validateNode but is null!");
            return false;
        }
        if (!(node instanceof ValueStore) || !((ValueStore) node).getBooleanValue(Node.KEY_IS_FINALIZED)) {
            return true;
        }
        RVLogger.w(f24198a, "validateNode but is finalized!");
        return false;
    }

    public static void clearProxyGenerator() {
        s.clear();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private T d() {
        try {
            if (t.containsKey(this.i)) {
                return (T) t.get(this.i);
            }
            DefaultImpl defaultImpl = (DefaultImpl) this.i.getAnnotation(DefaultImpl.class);
            if (defaultImpl == null) {
                return null;
            }
            String strValue = defaultImpl.value();
            RVLogger.d("AriverKernel", "newInstance for " + this.i + " to defaultImpl: " + strValue);
            T t2 = (T) Class.forName(strValue).newInstance();
            t.put((Class<? extends Extension>) this.i, t2);
            return t2;
        } catch (Throwable th) {
            RVLogger.e("AriverKernel", "getDefaultImpl exception!", th);
            return null;
        }
    }

    public static void exitNode(Node node) {
        if (node != null) {
            g.remove(Long.valueOf(node.getNodeId()));
        }
    }

    @VisibleForTesting
    public static LruCache<Class<? extends Extension>, Extension> getExtensionCache(Node node) {
        if (node == null) {
            return null;
        }
        return g.get(Long.valueOf(node.getNodeId()));
    }

    public static void invalidateExtensionCache() {
        RVLogger.d(f24198a, "invalidateAllExtensionCache");
        g.clear();
    }

    public static void registerProxyGenerator(Class cls, ProxyGenerator proxyGenerator) {
        s.put(cls, proxyGenerator);
    }

    public static void reportException(Throwable th) {
        if (RVKernelUtils.isDebug()) {
            throw new RuntimeException(th);
        }
        RVLogger.e(f24198a, "reportException", th);
    }

    public ExtensionPoint<T> actionOn(ExecutorType executorType) {
        this.n = executorType;
        return this;
    }

    public T create() {
        T t2;
        Node node;
        LruCache<Class<? extends Extension>, Extension> lruCache;
        T t3;
        a();
        if (this.p.size() > 0 || this.k != null) {
            this.m = false;
        }
        if (this.m && (node = this.h) != null && e > 0 && (lruCache = g.get(Long.valueOf(node.getNodeId()))) != null && (t3 = (T) lruCache.get(this.i)) != null) {
            RVLogger.d(f24198a, "find Extension " + this.i + " cache hit : " + t3);
            return t3;
        }
        InvocationHandler invocationHandlerB = b();
        if (invocationHandlerB == null) {
            return null;
        }
        ProxyGenerator proxyGenerator = s.get(this.i);
        if (proxyGenerator != null) {
            RVLogger.d(f24198a, "use proxy generator for " + this.i);
            t2 = (T) proxyGenerator.createProxyInstance(invocationHandlerB);
        } else {
            t2 = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.i}, invocationHandlerB);
        }
        if (this.m && e > 0 && c()) {
            Map<Long, LruCache<Class<? extends Extension>, Extension>> map = g;
            LruCache<Class<? extends Extension>, Extension> lruCache2 = map.get(Long.valueOf(this.h.getNodeId()));
            if (lruCache2 == null) {
                lruCache2 = new LruCache<>(e);
                map.put(Long.valueOf(this.h.getNodeId()), lruCache2);
            }
            lruCache2.put(this.i, t2);
        }
        return t2;
    }

    public ExtensionPoint<T> defaultValue(Object obj) {
        this.j = obj;
        return this;
    }

    public ExtensionPoint<T> extensionManager(ExtensionManager extensionManager) {
        this.o = extensionManager;
        return this;
    }

    public ExtensionPoint<T> node(Node node) {
        this.h = node;
        return this;
    }

    public ExtensionPoint<T> nullable() {
        this.l = true;
        return this;
    }

    public ExtensionPoint<T> resolve(ResultResolver resultResolver) {
        this.k = resultResolver;
        return this;
    }

    public ExtensionPoint<T> useCache(boolean z) {
        this.m = z;
        return this;
    }

    public ExtensionPoint<T> when(Action action) {
        this.p.put(action, this.n);
        return this;
    }

    public static void invalidateExtensionCache(@NonNull Class<? extends Extension> cls) {
        RVLogger.d(f24198a, "invalidateExtensionCache " + cls);
        Iterator<LruCache<Class<? extends Extension>, Extension>> it = g.values().iterator();
        while (it.hasNext()) {
            it.next().remove(cls);
        }
    }

    private ExtensionInvoker a(ExtensionManager extensionManager) {
        ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
        ExtensionInvoker extensionInvokerCreateAwareExtensionInvoker = extensionInvokerFactory.createAwareExtensionInvoker(this.h, new ActionCallback(this.p, this.j), this.i);
        if (!ProcessUtils.isMainProcess()) {
            extensionInvokerCreateAwareExtensionInvoker = new RemoteNormalExtensionInvoker(extensionManager.getRemoteController(), extensionInvokerCreateAwareExtensionInvoker);
        }
        return extensionInvokerFactory.createScheduleExtensionInvoker(new ResolveExtensionInvoker(this.k, extensionInvokerCreateAwareExtensionInvoker));
    }

    public static void invalidateExtensionCache(@NonNull Node node, @NonNull Class<? extends Extension> cls) {
        RVLogger.d(f24198a, "invalidateExtensionCache node: " + node + " extension: " + cls);
        LruCache<Class<? extends Extension>, Extension> lruCache = g.get(Long.valueOf(node.getNodeId()));
        if (lruCache != null) {
            lruCache.remove(cls);
        }
    }
}
