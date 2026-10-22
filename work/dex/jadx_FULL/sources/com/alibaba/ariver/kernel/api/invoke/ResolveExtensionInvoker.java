package com.alibaba.ariver.kernel.api.invoke;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionCallback;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.scheduler.Interruptable;
import com.alibaba.ariver.kernel.api.scheduler.Interruptor;
import com.alibaba.ariver.kernel.api.scheduler.internal.DefaultInterruptor;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResolveExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24212a = "AriverKernel:ExtensionInvoker:Resolve";
    private static final ResultResolver b = new ResultResolver() { // from class: com.alibaba.ariver.kernel.api.invoke.ResolveExtensionInvoker.1
        @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
        public Object resolve(List list) {
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) != null) {
                    return list.get(size);
                }
            }
            return null;
        }
    };
    private static Map<Integer, Stack<Interruptor>> d = new ConcurrentHashMap();
    private ResultResolver c;

    public ResolveExtensionInvoker(ResultResolver resultResolver, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.c = resultResolver;
        if (resultResolver == null) {
            RVLogger.d(f24212a, "use default resolver!");
            this.c = b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c9  */
    /* JADX WARN: Instruction removed from duplicated block: B:79:0x01c9, please report this as an issue */
    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        String str;
        Extension extension;
        Throwable th;
        ResultResolver resultResolver;
        Object obj2;
        if (!hasNext()) {
            return ExtensionInvoker.InvokeResult.decide(ReflectUtils.getDefaultValue(method.getReturnType()));
        }
        ArrayList arrayList = new ArrayList();
        ExtensionInvoker.InvokeCallback invokeCallback = this.invokeCallback;
        ExtensionCallback extensionCallback = invokeCallback instanceof ExtensionCallback ? (ExtensionCallback) invokeCallback : null;
        if (extensionCallback != null) {
            extensionCallback.onStart(immutableList.mutable());
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = immutableList.iterator();
        DefaultInterruptor defaultInterruptor = null;
        Object defaultValue = null;
        while (true) {
            boolean zHasNext = it.hasNext();
            str = f24212a;
            if (!zHasNext) {
                defaultValue = defaultValue;
                str = f24212a;
                break;
            }
            extension = (Extension) it.next();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (RVKernelUtils.isDebug()) {
                RVLogger.d(f24212a, "onInvoke method: " + method.toGenericString() + "@" + jElapsedRealtime + " on extension " + extension.getClass() + " begin");
            }
            boolean z = extension instanceof Interruptable;
            if (z) {
                if (defaultInterruptor == null) {
                    defaultInterruptor = new DefaultInterruptor();
                } else {
                    defaultInterruptor.setInterrupted(false);
                }
                Interruptable interruptable = (Interruptable) extension;
                Stack<Interruptor> stack = d.get(Integer.valueOf(interruptable.hashCode()));
                if (stack == null) {
                    stack = new Stack<>();
                    d.put(Integer.valueOf(interruptable.hashCode()), stack);
                }
                stack.push(defaultInterruptor);
                interruptable.setInterruptor(defaultInterruptor);
            } else {
                jElapsedRealtime2 = jElapsedRealtime2;
            }
            try {
                try {
                    Object objInvokeWithTargetExtensions = this.nextInvoker.invokeWithTargetExtensions(new ImmutableList<>(extension), obj, method, objArr);
                    try {
                        arrayList.add(objInvokeWithTargetExtensions);
                        if (extensionCallback != null) {
                            try {
                                extensionCallback.onProgress(extension, objInvokeWithTargetExtensions);
                            } catch (Throwable th2) {
                                th = th2;
                                defaultValue = objInvokeWithTargetExtensions;
                                if (extensionCallback != null) {
                                    extensionCallback.onException(extension, th);
                                }
                            }
                        }
                        if (z) {
                            Interruptable interruptable2 = (Interruptable) extension;
                            obj2 = objInvokeWithTargetExtensions;
                            Stack<Interruptor> stack2 = d.get(Integer.valueOf(interruptable2.hashCode()));
                            if (stack2 != null) {
                                if (stack2.size() > 0) {
                                    stack2.pop();
                                }
                                if (stack2.size() > 0) {
                                    interruptable2.setInterruptor(stack2.peek());
                                } else {
                                    d.remove(Integer.valueOf(interruptable2.hashCode()));
                                }
                            }
                        } else {
                            obj2 = objInvokeWithTargetExtensions;
                        }
                        boolean z2 = defaultInterruptor != null && defaultInterruptor.isInterrupted();
                        if (RVKernelUtils.isDebug()) {
                            str = str;
                            RVLogger.d(str, "onInvoke method: " + method.toGenericString() + "@" + jElapsedRealtime + " on extension " + extension.getClass() + " done cost " + (SystemClock.elapsedRealtime() - jElapsedRealtime2) + " interruptor: " + defaultInterruptor + " interrupted: " + z2);
                        } else {
                            str = str;
                        }
                        if (z2) {
                            if (extensionCallback != null) {
                                extensionCallback.onInterrupt(extension);
                            }
                            defaultValue = obj2;
                            break;
                        }
                        it = it;
                        defaultValue = obj2;
                    } catch (Throwable th3) {
                        th = th3;
                        defaultValue = objInvokeWithTargetExtensions;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    if (extensionCallback != null) {
                        extensionCallback.onException(extension, th);
                    }
                    resultResolver = this.c;
                    if (resultResolver != null) {
                        defaultValue = resultResolver.resolve(arrayList);
                    }
                    if (th != null) {
                        RVLogger.e(str, "return defaultValue due to exception " + th + " in ext: " + extension);
                        defaultValue = ReflectUtils.getDefaultValue(method.getReturnType());
                    }
                    return ExtensionInvoker.InvokeResult.decide(defaultValue);
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        th = null;
        extension = null;
        resultResolver = this.c;
        if (resultResolver != null) {
            defaultValue = resultResolver.resolve(arrayList);
        }
        if (th != null) {
            RVLogger.e(str, "return defaultValue due to exception " + th + " in ext: " + extension);
            defaultValue = ReflectUtils.getDefaultValue(method.getReturnType());
        }
        return ExtensionInvoker.InvokeResult.decide(defaultValue);
    }
}
