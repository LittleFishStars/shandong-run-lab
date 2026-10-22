package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8JSErrorPoint;
import com.alipay.mobile.jsengine.v8.V8Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class h extends k {
    private i f;
    private V8Function g;
    private int h;
    private boolean i;

    public h(i iVar, V8Function v8Function, int i, boolean z) {
        this.f = iVar;
        this.g = v8Function;
        this.h = i;
        this.i = z;
    }

    @Override // com.alibaba.ariver.legacy.v8worker.k, java.lang.Runnable
    public void run() {
        this.f.a().post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (!h.this.i) {
                    h.this.f.a(h.this.h);
                }
                if (h.this.g != null) {
                    try {
                        h.this.g.call(null, null);
                    } catch (Throwable th) {
                        ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).create()).onException(th.getMessage(), "", "");
                    }
                }
                if (h.this.i) {
                    return;
                }
                h.this.a();
            }
        });
    }

    @Override // com.alibaba.ariver.legacy.v8worker.k
    public boolean a() {
        V8Function v8Function = this.g;
        if (v8Function != null) {
            v8Function.release();
            this.g = null;
        }
        return super.a();
    }
}
