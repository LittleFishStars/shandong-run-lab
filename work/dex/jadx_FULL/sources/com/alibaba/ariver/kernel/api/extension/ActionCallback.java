package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionCallback<T> implements ExtensionCallback<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24196a = "AriverKernel:ActionCallback";
    private final Map<Action, ExecutorType> b;
    private final RVExecutorService c = (RVExecutorService) RVProxy.get(RVExecutorService.class);
    private final T d;

    public ActionCallback(Map<Action, ExecutorType> map, T t) {
        this.b = map;
        this.d = t;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
    public void onComplete(T t) {
        if (t == null) {
            t = this.d;
        }
        for (final Action action : this.b.keySet()) {
            if (action instanceof Action.Complete) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final T t2 = t;
                this.c.getExecutor(this.b.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        RVLogger.debug(ActionCallback.f24196a, "onComplete for " + action.getClass().getName() + " schedule " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        ((Action.Complete) action).onComplete(t2);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onException(final Extension extension, final Throwable th) {
        for (final Action action : this.b.keySet()) {
            if (action instanceof Action.Exception) {
                this.c.getExecutor(this.b.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Exception) action).onException(extension, th);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
    public void onFail(Throwable th) {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onInterrupt(final Extension extension) {
        for (final Action action : this.b.keySet()) {
            if (action instanceof Action.Interrupt) {
                this.c.getExecutor(this.b.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Interrupt) action).onInterrupt(extension);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onProgress(final Extension extension, final T t) {
        for (final Action action : this.b.keySet()) {
            if (action instanceof Action.Progress) {
                this.c.getExecutor(this.b.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Progress) action).onProgress(extension, t);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onStart(final List<Extension> list) {
        for (final Action action : this.b.keySet()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (action instanceof Action.Start) {
                this.c.getExecutor(this.b.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RVLogger.debug(ActionCallback.f24196a, "onComplete for " + action.getClass().getName() + " schedule " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        ((Action.Start) action).onStart(list);
                    }
                });
            }
        }
    }
}
