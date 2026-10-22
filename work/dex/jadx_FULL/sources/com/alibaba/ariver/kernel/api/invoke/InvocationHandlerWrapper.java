package com.alibaba.ariver.kernel.api.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InvocationHandlerWrapper implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExtensionInvoker f24210a;
    private Object b = new Object();
    private String c;

    public InvocationHandlerWrapper(Class cls, ExtensionInvoker extensionInvoker) {
        this.f24210a = extensionInvoker;
        this.c = "Proxy@" + cls + "@" + this.b.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getDeclaringClass() == Object.class) {
            return "toString".equals(method.getName()) ? this.c : method.invoke(this.b, objArr);
        }
        return this.f24210a.invoke(obj, method, objArr);
    }
}
