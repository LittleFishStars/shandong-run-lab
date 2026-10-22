package com.alibaba.ariver.commonability.core.c;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<e> f23942a = new ArrayList();
    private BridgeCallback b;
    private b c;
    private a d;

    public interface a {
        void a(JSONObject jSONObject, BridgeCallback bridgeCallback);
    }

    public interface b {
        void a(JSONObject jSONObject, BridgeCallback bridgeCallback);
    }

    @Deprecated
    private d(BridgeCallback bridgeCallback) {
        this.b = bridgeCallback;
    }

    public static d a(BridgeCallback bridgeCallback) {
        return new d(bridgeCallback);
    }

    private void b(JSONObject jSONObject) {
        b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.a(jSONObject, this.b);
    }

    public d a(String str, String str2, JSONObject jSONObject) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 2) {
                return this;
            }
            this.b = new com.alibaba.ariver.commonability.core.c.a(this.b, jSONObject, stackTrace[1].getMethodName(), str2, str);
        } catch (Exception unused) {
        }
        return this;
    }

    public d a(String str, String str2) {
        a(str, str2, null);
        return this;
    }

    public d a(e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f23942a.add(eVar);
        return this;
    }

    private void a(JSONObject jSONObject) {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.a(jSONObject, this.b);
    }

    public d a(a aVar) {
        this.d = aVar;
        return this;
    }

    public d a(b bVar) {
        this.c = bVar;
        return this;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        for (e eVar : this.f23942a) {
            eVar.a(this.b);
            if (!eVar.a()) {
                eVar.b(this.b);
                b(jSONObject);
                return;
            }
        }
        a(jSONObject);
    }
}
