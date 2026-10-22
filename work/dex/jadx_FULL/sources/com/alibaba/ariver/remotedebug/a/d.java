package com.alibaba.ariver.remotedebug.a;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.websocket.core.e;
import com.alibaba.ariver.websocket.core.f;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends a implements com.alibaba.ariver.websocket.core.c {
    private static final String b = "AriverRemoteDebug:WebSocketDataChannel";
    private boolean c;
    private String d;
    private f e;

    public d(String str, b.a aVar) {
        super(str, aVar);
        this.d = com.alibaba.ariver.remotedebug.b.f24379a + str;
    }

    @Override // com.alibaba.ariver.remotedebug.a.b
    public void a(String str, Map<String, String> map, JSONObject jSONObject) {
        RVLogger.d(b, "connect...  url: " + str);
        if (this.c) {
            RVLogger.d(b, "connect...  connecting! url: " + str);
            return;
        }
        this.c = true;
        f fVarA = e.a().a(this.d);
        this.e = fVarA;
        fVarA.a(str, map, this);
    }

    @Override // com.alibaba.ariver.remotedebug.a.b
    public boolean b(String str) {
        if (!this.c) {
            RVLogger.d(b, "send... not connecting!");
            return false;
        }
        RVLogger.d(b, "send...  msg: " + str);
        f fVar = this.e;
        if (fVar == null) {
            return false;
        }
        fVar.b(str);
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.a.b
    public void b(int i, String str) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(this.d);
        }
        this.c = false;
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a() {
        if (c() != null) {
            c().c(d());
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(byte[] bArr) {
        if (c() != null) {
            c().a(bArr);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void b() {
        if (c() != null) {
            c().d(d());
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(String str) {
        if (c() != null) {
            c().e(str);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(int i, String str) {
        if (c() != null) {
            c().a(d(), i, str);
        }
    }
}
