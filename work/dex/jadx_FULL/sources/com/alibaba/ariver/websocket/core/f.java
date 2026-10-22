package com.alibaba.ariver.websocket.core;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24538a = "AriverWebSocket:WebSocketSession";
    private static final String b = "DEFAULT-TASK-ID";
    private final Map<String, d> c = new ConcurrentHashMap();
    private String d;

    public f(String str) {
        this.d = str;
    }

    private d b(String str, String str2, Map<String, String> map, c cVar) {
        return ((RVWebSocketProxy) RVProxy.get(RVWebSocketProxy.class)).createWebSocketClient(this.d, str2, map, new a(str, cVar));
    }

    public boolean c() {
        return c(b);
    }

    public int d() {
        return this.c.size();
    }

    public void a(String str, Map<String, String> map, c cVar) {
        a(str, b, map, cVar);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b;
        }
        d dVar = this.c.get(str);
        if (dVar == null) {
            RVLogger.d(f24538a, "isOpen client is null. taskId: " + str);
            return false;
        }
        boolean zI = dVar.i();
        RVLogger.d(f24538a, "isOpen taskId:" + str + " open:" + zI);
        return zI;
    }

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f24539a;
        c b;

        public a(String str, c cVar) {
            this.f24539a = str;
            this.b = cVar;
        }

        @Override // com.alibaba.ariver.websocket.core.c
        public void a() {
            RVLogger.d(f.f24538a, "RVWebSocketCallbackProxy onSocketOpen");
            c cVar = this.b;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.alibaba.ariver.websocket.core.c
        public void b() {
            c cVar;
            RVLogger.d(f.f24538a, "RVWebSocketCallbackProxy onSocketClose");
            if (((d) f.this.c.remove(this.f24539a)) == null || (cVar = this.b) == null) {
                return;
            }
            cVar.b();
        }

        @Override // com.alibaba.ariver.websocket.core.c
        public void a(byte[] bArr) {
            RVLogger.d(f.f24538a, "RVWebSocketCallbackProxy onSocketMessage message " + bArr);
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(bArr);
            }
        }

        @Override // com.alibaba.ariver.websocket.core.c
        public void a(String str) {
            RVLogger.d(f.f24538a, "RVWebSocketCallbackProxy onSocketMessage message " + str);
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(str);
            }
        }

        @Override // com.alibaba.ariver.websocket.core.c
        public void a(int i, String str) {
            RVLogger.d(f.f24538a, "RVWebSocketCallbackProxy onSocketError errCode " + i + " errMsg:" + str);
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, str);
            }
        }
    }

    public void a(String str, String str2, Map<String, String> map, c cVar) {
        if (TextUtils.isEmpty(str2)) {
            str2 = b;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme)) {
            d dVarB = b(str2, str, map, cVar);
            if (dVarB != null) {
                RVLogger.d(f24538a, "startSocketConnect.");
                if ("ws".equalsIgnoreCase(scheme)) {
                    dVarB.f();
                } else if (com.alibaba.ariver.websocket.b.b.equalsIgnoreCase(scheme)) {
                    dVarB.g();
                } else {
                    throw new InvalidParameterException(String.format("url error: %s not ws:// or wss://", uri.toString()));
                }
                this.c.put(str2, dVarB);
                return;
            }
            RVLogger.d(f24538a, "startSocketConnect createClient is null! taskId: " + str2);
            throw new InvalidParameterException("url error: " + str);
        }
        throw new InvalidParameterException("url error: " + str);
    }

    public void b() {
        RVLogger.d(f24538a, "closeAllSocket.");
        Iterator<Map.Entry<String, d>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            d value = it.next().getValue();
            if (value != null) {
                value.h();
            }
            it.remove();
        }
    }

    public void b(String str) {
        a(b, str);
    }

    public void a() {
        a(b);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b;
        }
        d dVar = this.c.get(str);
        if (dVar == null) {
            RVLogger.d(f24538a, "closeSocketConnect client is null. taskId: " + str);
            return;
        }
        RVLogger.d(f24538a, "closeSocketConnect.");
        dVar.h();
    }

    public void a(byte[] bArr) {
        a(b, bArr);
    }

    public void a(String str, byte[] bArr) {
        if (!c(str)) {
            RVLogger.d(f24538a, "sendMessage socket has closed!. taskId: " + str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = b;
        }
        d dVar = this.c.get(str);
        if (dVar == null) {
            RVLogger.d(f24538a, "sendMessage client is null. taskId: " + str);
            return;
        }
        RVLogger.d(f24538a, "sendMessage data:" + bArr);
        dVar.a(bArr);
    }

    public void a(String str, String str2) {
        if (!c(str)) {
            RVLogger.d(f24538a, "sendMessage socket has closed!. taskId: " + str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = b;
        }
        d dVar = this.c.get(str);
        if (dVar == null) {
            RVLogger.d(f24538a, "sendMessage client is null. taskId: " + str);
            return;
        }
        RVLogger.d(f24538a, "sendMessage data:" + str2);
        dVar.a(str2);
    }
}
