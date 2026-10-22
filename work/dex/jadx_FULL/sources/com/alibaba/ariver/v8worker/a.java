package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.js.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.alibaba.jsi.standard.js.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24491a = "AsyncJSCallback";
    private V8Worker b;

    public a(V8Worker v8Worker) {
        this.b = v8Worker;
    }

    @Override // com.alibaba.jsi.standard.js.h
    public w a(com.alibaba.jsi.standard.js.a aVar) {
        try {
            this.b.q();
            if (this.b.k() || this.b.a(aVar)) {
                return null;
            }
            w wVarA = aVar.a(2);
            JSONObject jSONObjectA = o.a(wVarA, aVar.b());
            if (this.b.i() != null) {
                this.b.i().a(jSONObjectA);
            }
            wVarA.a();
        } catch (Throwable th) {
            RVLogger.e(f24491a, "onCallFunction error: ", th);
        }
        return null;
    }
}
