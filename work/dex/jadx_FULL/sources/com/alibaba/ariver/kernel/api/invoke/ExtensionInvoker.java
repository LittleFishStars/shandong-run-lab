package com.alibaba.ariver.kernel.api.invoke;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ExtensionInvoker implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24208a = "AriverKernel:ExtensionInvoker";
    private ImmutableList<Extension> b;
    private AtomicBoolean c;
    protected final InvokeCallback invokeCallback;
    protected final ExtensionInvoker nextInvoker;
    protected Class<? extends Extension> targetExtensionClazz;
    protected final Node targetNode;

    public interface InvokeCallback<T> {
        void onComplete(T t);

        void onFail(Throwable th);
    }

    public static class InvokeResult<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f24209a;
        private T b;

        private InvokeResult(boolean z, T t) {
            this.f24209a = z;
            this.b = t;
        }

        public static InvokeResult decide(Object obj) {
            return new InvokeResult(false, obj);
        }

        public static InvokeResult pending() {
            return new InvokeResult(true, null);
        }

        public static InvokeResult proceed() {
            return null;
        }
    }

    public ExtensionInvoker(ExtensionInvoker extensionInvoker) {
        this.c = new AtomicBoolean(false);
        this.nextInvoker = extensionInvoker;
        if (extensionInvoker != null) {
            this.invokeCallback = extensionInvoker.invokeCallback;
            this.targetNode = extensionInvoker.targetNode;
        } else {
            this.invokeCallback = null;
            this.targetNode = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object a(Method method, Extension extension, Object[] objArr) throws InvokeException {
        ExtensionOpt.MethodInvokeOptimizer methodInvokeOptimizer;
        Class<?> declaringClass = this.targetExtensionClazz;
        if (declaringClass == null && method != null) {
            try {
                declaringClass = method.getDeclaringClass();
            } catch (Throwable th) {
                RVLogger.w(f24208a, "getDeclaringClass error!", th);
            }
        }
        if (declaringClass != null && method != null && extension != null && (methodInvokeOptimizer = getMethodInvokeOptimizer(declaringClass)) != null) {
            try {
                return methodInvokeOptimizer.doMethodInvoke(method.getName(), extension, objArr);
            } catch (ExtensionOpt.MismatchMethodException e) {
                String str = "optimizer.doMethodInvoke occur MismatchMethodException: " + declaringClass.getName() + "#" + method.getName() + "@" + extension.getClass().getName() + ", " + e;
                RVLogger.e(f24208a, str);
                ExtensionOpt.reportException(e, "BIZ_ARIVER", "doMethodInvoke", "MismatchMethod", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(str, e);
                }
                if (ExtensionOpt.shouldThrowOut(e, "doMethodInvoke", "MismatchMethod")) {
                    throw new InvokeException(str, e);
                }
            } catch (ClassCastException e2) {
                String str2 = "optimizer.doMethodInvoke occur ClassCastException: " + declaringClass.getName() + "#" + method.getName() + "@" + extension.getClass().getName() + ", " + e2;
                RVLogger.e(f24208a, str2);
                ExtensionOpt.reportException(e2, "BIZ_ARIVER", "doMethodInvoke", "ClassCast", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(str2, e2);
                }
                if (ExtensionOpt.shouldThrowOut(e2, "doMethodInvoke", "ClassCast")) {
                    throw new InvokeException(str2, e2);
                }
            } catch (IndexOutOfBoundsException e3) {
                String str3 = "optimizer.doMethodInvoke occur IndexOutOfBoundsException: " + declaringClass.getName() + "#" + method.getName() + "@" + extension.getClass().getName() + ", " + e3;
                RVLogger.e(f24208a, str3);
                ExtensionOpt.reportException(e3, "BIZ_ARIVER", "doMethodInvoke", "IndexOutOfBounds", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(str3, e3);
                }
                if (ExtensionOpt.shouldThrowOut(e3, "doMethodInvoke", "IndexOutOfBounds")) {
                    throw new InvokeException(str3, e3);
                }
            } catch (Throwable th2) {
                String str4 = "optimizer.doMethodInvoke occur existing Exception: " + declaringClass.getName() + "#" + method.getName() + "@" + extension.getClass().getName() + ", " + th2;
                RVLogger.e(f24208a, str4);
                ExtensionOpt.reportException(th2, "BIZ_ARIVER", "doMethodInvoke", "FinalCatch", null);
                if (ExtensionOpt.shouldThrowOut(th2, "doMethodInvoke", "FinalCatch")) {
                    throw new InvokeException(str4, th2);
                }
            }
        }
        if (RVKernelUtils.isDebug()) {
            String name = declaringClass == null ? "ClazzName" : declaringClass.getName();
            if (method != null && extension != null && declaringClass != null) {
                RVLogger.w(f24208a, "optimizer.doMethodInvoke is not work, and actually do method.invoke: " + name + "#" + method.getName() + "@" + extension.getClass().getName());
            }
        }
        return method.invoke(extension, objArr);
    }

    public void attacheTargetExtensions(List<Extension> list) {
        this.b = new ImmutableList<>((List) list);
        this.c.set(true);
    }

    public ExtensionOpt.MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls) {
        return ExtensionOpt.getMethodInvokeOptimizer(cls, false);
    }

    public final boolean hasNext() {
        return this.nextInvoker != null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return invokeWithTargetExtensions(this.b, obj, method, objArr);
    }

    public final Object invokeWithTargetExtensions(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        InvokeCallback invokeCallback;
        InvokeCallback invokeCallback2;
        try {
            InvokeResult invokeResultOnInvoke = onInvoke(immutableList, obj, method, objArr);
            if (invokeResultOnInvoke == null) {
                return proceed(immutableList, obj, method, objArr);
            }
            if (invokeResultOnInvoke.f24209a) {
                if (invokeResultOnInvoke.b == null) {
                    invokeResultOnInvoke.b = ReflectUtils.getDefaultValue(method.getReturnType());
                }
                return invokeResultOnInvoke.b;
            }
            if (this.c.get() && (invokeCallback2 = this.invokeCallback) != null) {
                invokeCallback2.onComplete(invokeResultOnInvoke.b);
            }
            return invokeResultOnInvoke.b;
        } catch (Throwable th) {
            RVLogger.e(f24208a, "Java exception happened!\nExtension: " + immutableList.get(0) + "\nMethod: " + method, th);
            if (this.c.get() && (invokeCallback = this.invokeCallback) != null) {
                invokeCallback.onFail(th);
            }
            throw th;
        }
    }

    public abstract InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr);

    public final Object proceed(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws InvokeException {
        if (hasNext()) {
            if (this.c.compareAndSet(true, false)) {
                this.nextInvoker.c.set(true);
            }
            try {
                return this.nextInvoker.invokeWithTargetExtensions(immutableList, obj, method, objArr);
            } catch (InvokeException e) {
                throw e;
            } catch (Throwable th) {
                throw new InvokeException(th);
            }
        }
        if (immutableList.size() != 1) {
            throw new IllegalStateException("only single extension is accepted in last invoker");
        }
        Extension extension = immutableList.get(0);
        String str = RVTraceKey.RV_Extension_invoke_ + extension.getClass().getSimpleName() + LoginConstants.UNDER_LINE + method.getName();
        RVTraceUtils.traceBeginSection(str);
        try {
            try {
                try {
                    Object objA = a(method, extension, objArr);
                    RVTraceUtils.traceEndSection(str);
                    return objA;
                } catch (InvokeException e2) {
                    throw e2;
                }
            } catch (InvocationTargetException e3) {
                throw new InvokeException(e3.getCause());
            } catch (Throwable th2) {
                throw new InvokeException(th2);
            }
        } catch (Throwable th3) {
            RVTraceUtils.traceEndSection(str);
            throw th3;
        }
    }

    public final Object proceedSafe(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        try {
            return proceed(immutableList, obj, method, objArr);
        } catch (Throwable th) {
            RVLogger.e(f24208a, "extension invoke exception!", th);
            return ReflectUtils.getDefaultValue(method.getReturnType());
        }
    }

    public void attacheTargetExtensions(Extension extension) {
        this.b = new ImmutableList<>(extension);
        this.c.set(true);
    }

    public ExtensionInvoker(Node node, InvokeCallback invokeCallback, Class<? extends Extension> cls) {
        this.c = new AtomicBoolean(false);
        this.targetNode = node;
        this.invokeCallback = invokeCallback;
        this.targetExtensionClazz = cls;
        this.nextInvoker = null;
    }
}
