package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.js.s;
import com.alibaba.jsi.standard.js.w;
import com.alibaba.jsi.standard.js.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k extends com.alibaba.jsi.standard.js.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f24517a = "MultiThreadWorkerCallback";
    private V8Worker b;
    private int c = 1;
    private Map<Integer, j> d = new HashMap();

    public class a extends com.alibaba.jsi.standard.js.h {
        private j b;

        public a(j jVar) {
            this.b = jVar;
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            try {
                this.b.a((com.alibaba.jsi.standard.js.j) aVar.a(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(k.f24517a, "failed to set onmessage of JS Worker", th);
                return null;
            }
        }
    }

    public class b extends com.alibaba.jsi.standard.js.h {
        private j b;

        public b(j jVar) {
            this.b = jVar;
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            try {
                this.b.b((com.alibaba.jsi.standard.js.o) aVar.a(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(k.f24517a, "failed to postMessage to JS Worker", th);
                return null;
            }
        }
    }

    public class c extends com.alibaba.jsi.standard.js.h {
        private int b;
        private j c;

        public c(int i, j jVar) {
            this.b = i;
            this.c = jVar;
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            try {
                k.this.a(this.b, this.c);
                return null;
            } catch (Throwable th) {
                RVLogger.e(k.f24517a, "failed to terminate JS Worker", th);
                return null;
            }
        }
    }

    public k(V8Worker v8Worker) {
        this.b = v8Worker;
    }

    public static int a() {
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        int allowCreatedWorkerMaxCount = v8Proxy != null ? v8Proxy.getAllowCreatedWorkerMaxCount() : 1;
        if (allowCreatedWorkerMaxCount > 0) {
            return allowCreatedWorkerMaxCount;
        }
        return 1;
    }

    public void b() {
        Iterator<Map.Entry<Integer, j>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        this.d.clear();
    }

    public void a(int i, j jVar) {
        this.d.remove(Integer.valueOf(i));
        jVar.a();
    }

    @Override // com.alibaba.jsi.standard.js.h
    public w a(com.alibaba.jsi.standard.js.a aVar) {
        try {
            if (this.b.isDestroyed()) {
                return null;
            }
            if (this.d.size() >= a()) {
                RVLogger.e(f24517a, "The number of worker exceeds system limit");
                return null;
            }
            com.alibaba.jsi.standard.js.o oVar = (com.alibaba.jsi.standard.js.o) aVar.a(0);
            String strA_ = oVar.a(aVar.b(), "scriptPath").a_(aVar.b());
            oVar.a();
            String strReplace = this.b.getWorkerId().replace("index.worker.js", strA_);
            String strC = this.b.c(strReplace);
            RVLogger.d(f24517a, "create JS Worker: " + strA_ + ", " + strC.length() + " bytes");
            int i = this.c;
            this.c = i + 1;
            com.alibaba.jsi.standard.b bVarM = this.b.m();
            if (bVarM != null && !bVarM.b()) {
                com.alibaba.jsi.standard.js.o oVar2 = new com.alibaba.jsi.standard.js.o(bVarM);
                j jVar = new j(this.b, "MultiThreadWorker-" + i, oVar2, strReplace, strC);
                com.alibaba.jsi.standard.js.j jVar2 = new com.alibaba.jsi.standard.js.j(bVarM, new a(jVar), "onMessage");
                oVar2.a(bVarM, "onMessage", jVar2);
                jVar2.a();
                com.alibaba.jsi.standard.js.j jVar3 = new com.alibaba.jsi.standard.js.j(bVarM, new b(jVar), com.alibaba.triver.embed.webview.b.f24908a);
                oVar2.a(bVarM, com.alibaba.triver.embed.webview.b.f24908a, jVar3);
                jVar3.a();
                com.alibaba.jsi.standard.js.j jVar4 = new com.alibaba.jsi.standard.js.j(bVarM, new c(i, jVar), "terminate");
                oVar2.a(bVarM, "terminate", jVar4);
                jVar4.a();
                try {
                    a(oVar2);
                } catch (Throwable th) {
                    RVLogger.e(f24517a, "failed to hideWorkerProperty for JSWorker: ", th);
                }
                this.d.put(Integer.valueOf(i), jVar);
                return oVar2;
            }
            return new y(true);
        } catch (Throwable th2) {
            RVLogger.e(f24517a, "failed to create JS Worker", th2);
            return new y(true);
        }
    }

    private void a(com.alibaba.jsi.standard.js.o oVar) {
        w wVar;
        com.alibaba.jsi.standard.b bVarM = this.b.m();
        if (bVarM == null || bVarM.b() || oVar == null) {
            return;
        }
        com.alibaba.jsi.standard.js.o oVarG = bVarM.g();
        com.alibaba.jsi.standard.js.o oVar2 = (com.alibaba.jsi.standard.js.o) oVarG.a(bVarM, "Object");
        com.alibaba.jsi.standard.js.j jVar = (com.alibaba.jsi.standard.js.j) oVar2.a(bVarM, "defineProperty");
        com.alibaba.jsi.standard.js.o oVar3 = new com.alibaba.jsi.standard.js.o(bVarM);
        oVar3.a(bVarM, "writable", new com.alibaba.jsi.standard.js.f(false));
        oVar3.a(bVarM, "configurable", new com.alibaba.jsi.standard.js.f(false));
        oVar3.a(bVarM, "enumerable", new com.alibaba.jsi.standard.js.f(false));
        String[] strArr = {"onMessage", com.alibaba.triver.embed.webview.b.f24908a, "terminate"};
        for (int i = 0; i < 3; i++) {
            w[] wVarArr = {oVar, new s(strArr[i]), oVar3};
            try {
                w wVarA = jVar.a(bVarM, oVar2, wVarArr);
                if (wVarA != null) {
                    wVarA.a();
                }
                wVar = wVarArr[1];
            } catch (Throwable th) {
                try {
                    RVLogger.e(f24517a, "failed to hideWorkerProperty for JS Worker: ", th);
                    wVar = wVarArr[1];
                } catch (Throwable th2) {
                    wVarArr[1].a();
                    throw th2;
                }
            }
            wVar.a();
        }
        oVarG.a();
        oVar2.a();
        jVar.a();
        oVar3.a();
    }
}
