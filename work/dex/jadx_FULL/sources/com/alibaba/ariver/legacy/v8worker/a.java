package com.alibaba.ariver.legacy.v8worker;

import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements JavaVoidCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f24297a;

    public a(n nVar) {
        this.f24297a = nVar;
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
    public void invoke(V8Object v8Object, V8Array v8Array) {
        if (this.f24297a.tryPostMessageByMessageChannel(v8Array)) {
            return;
        }
        this.f24297a.getJsApiHandler().a(m.a(v8Array.get(2)));
    }
}
