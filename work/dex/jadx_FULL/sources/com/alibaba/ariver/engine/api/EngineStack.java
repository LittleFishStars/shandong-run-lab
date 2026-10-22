package com.alibaba.ariver.engine.api;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EngineStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24046a = "AriverEngine:EngineStack";
    private static EngineStack b;
    private Map<String, Stack<WeakReference<RVEngine>>> c = new HashMap();

    private EngineStack() {
    }

    private Stack<WeakReference<RVEngine>> a(String str) {
        Stack<WeakReference<RVEngine>> stack;
        synchronized (this) {
            stack = this.c.get(str);
            if (stack == null) {
                stack = new Stack<>();
                this.c.put(str, stack);
            }
        }
        return stack;
    }

    public static EngineStack getInstance() {
        if (b == null) {
            b = new EngineStack();
        }
        return b;
    }

    public RVEngine getByInstanceId(String str, String str2) {
        synchronized (this) {
            Stack<WeakReference<RVEngine>> stackA = a(str);
            if (stackA.isEmpty()) {
                return null;
            }
            for (WeakReference<RVEngine> weakReference : stackA) {
                if (weakReference != null && weakReference.get() != null && TextUtils.equals(weakReference.get().getInstanceId(), str2)) {
                    return weakReference.get();
                }
            }
            return null;
        }
    }

    public RVEngine getTopProxy(String str) {
        synchronized (this) {
            Stack<WeakReference<RVEngine>> stackA = a(str);
            while (!stackA.isEmpty()) {
                WeakReference<RVEngine> weakReferencePeek = stackA.peek();
                if (weakReferencePeek != null && weakReferencePeek.get() != null) {
                    return weakReferencePeek.get();
                }
                stackA.pop();
            }
            return null;
        }
    }

    public void pushEnginePorxy(RVEngine rVEngine) {
        if (rVEngine == null) {
            RVLogger.d(f24046a, "push  empty engineProxy");
            return;
        }
        RVLogger.d(f24046a, "push proxy appId=" + rVEngine.getAppId() + " ,appinstanceid =" + rVEngine.getInstanceId() + " , obj=" + rVEngine.hashCode() + " targetType=" + rVEngine.getClass());
        synchronized (this) {
            a(rVEngine.getEngineType()).push(new WeakReference<>(rVEngine));
        }
    }

    public void removeProxy(RVEngine rVEngine) {
        if (rVEngine == null) {
            RVLogger.d(f24046a, "reomve  empty engineProxy");
            return;
        }
        RVLogger.d(f24046a, "remove proxy appId=" + rVEngine.getAppId() + " , obj=" + rVEngine.hashCode() + " targetType=" + rVEngine.getClass());
        synchronized (this) {
            Stack<WeakReference<RVEngine>> stackA = a(rVEngine.getEngineType());
            if (stackA.isEmpty()) {
                return;
            }
            WeakReference<RVEngine> weakReference = null;
            for (WeakReference<RVEngine> weakReference2 : stackA) {
                if (weakReference2 != null && weakReference2.get() == rVEngine) {
                    weakReference = weakReference2;
                }
            }
            if (weakReference != null) {
                stackA.remove(weakReference);
            }
        }
    }
}
