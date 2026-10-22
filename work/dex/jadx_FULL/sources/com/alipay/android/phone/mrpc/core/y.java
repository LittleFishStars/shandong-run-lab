package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f25336a;
    private aa b = new aa(this);

    public y(g gVar) {
        this.f25336a = gVar;
    }

    public g a() {
        return this.f25336a;
    }

    public <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new z(this.f25336a, cls, this.b));
    }
}
