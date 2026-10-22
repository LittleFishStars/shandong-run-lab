package com.alibaba.alibcprotocol.route.proxy.impl;

import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23632a = "a";
    private Object b;
    private String c;

    public a() {
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.impl.b
    public final Object a(Object obj, Method method, Object[] objArr) {
        if (this.c == null || this.b == null) {
            AlibcLogger.e(f23632a, "[class name is null]not found instance of annotation");
            return super.a(obj, method, objArr);
        }
        AlibcSdkManager.getInstance().supportComp(this.c);
        return Boolean.TRUE;
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.impl.b, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object objA = a(obj, method, objArr);
        if (objA == null) {
            return super.invoke(obj, method, objArr);
        }
        if (((Boolean) objA).booleanValue()) {
            return method.invoke(this.b, objArr);
        }
        AlibcLogger.e(f23632a, "[component is not supported] className = " + this.c);
        return null;
    }

    public a(Object obj, String str) {
        this.b = obj;
        this.c = str;
    }
}
