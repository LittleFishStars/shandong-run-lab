package com.alibaba.ariver.v8worker;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.js.w;
import com.alibaba.jsi.standard.js.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24510a = "MultiThreadWorker";
    private V8Worker b;
    private HandlerThread c;
    private Handler d;
    private com.alibaba.jsi.standard.js.o e;
    private com.alibaba.jsi.standard.c f;
    private com.alibaba.jsi.standard.b g;
    private com.alibaba.jsi.standard.js.c h;
    private com.alibaba.jsi.standard.js.j i;
    private com.alibaba.jsi.standard.js.j j;

    public class a extends com.alibaba.jsi.standard.js.h {
        public a() {
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            return null;
        }
    }

    public class b extends com.alibaba.jsi.standard.js.h {
        public b() {
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            try {
                j.this.b((com.alibaba.jsi.standard.js.j) aVar.a(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(j.f24510a, "failed to set onmessage in Worker", th);
                return null;
            }
        }
    }

    public class c extends com.alibaba.jsi.standard.js.h {
        public c() {
        }

        @Override // com.alibaba.jsi.standard.js.h
        public w a(com.alibaba.jsi.standard.js.a aVar) {
            try {
                j.this.a((com.alibaba.jsi.standard.js.o) aVar.a(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(j.f24510a, "failed to postMessage in Worker", th);
                return null;
            }
        }
    }

    public j(V8Worker v8Worker, final String str, com.alibaba.jsi.standard.js.o oVar, final String str2, final String str3) {
        this.b = v8Worker;
        this.e = oVar;
        HandlerThread handlerThread = new HandlerThread(str);
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.c.getName());
        } else {
            RVLogger.e(f24510a, "v8Proxy is null, V8Worker Thread will be controlled: " + this.c.getName());
        }
        this.d.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.a(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        com.alibaba.jsi.standard.b bVar = this.g;
        return bVar == null || bVar.b() || this.f == null;
    }

    public void b(com.alibaba.jsi.standard.js.j jVar) {
        com.alibaba.jsi.standard.js.j jVar2 = this.j;
        if (jVar2 != null) {
            jVar2.a();
        }
        this.j = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        String str4 = (v8Proxy != null ? v8Proxy.getPackageName() : "Alipay") + "-JSEngine-" + str;
        Bundle bundle = new Bundle();
        bundle.putString("name", str4);
        bundle.putString("version", "1.0");
        this.f = com.alibaba.jsi.standard.c.a(applicationContext, bundle, this.d);
        if (RVKernelUtils.isDebug()) {
            this.f.b(true);
        }
        this.g = this.f.b(str + "-JSContext");
        this.h = new com.alibaba.jsi.standard.js.c(this.f);
        f.a(this.g, null);
        com.alibaba.jsi.standard.js.o oVarG = this.g.g();
        oVarG.a(this.g, "worker", oVarG);
        w jVar = new com.alibaba.jsi.standard.js.j(this.g, new a(), "importScripts");
        oVarG.a(this.g, "importScripts", jVar);
        jVar.a();
        w jVar2 = new com.alibaba.jsi.standard.js.j(this.g, new b(), "onMessage");
        oVarG.a(this.g, "onMessage", jVar2);
        jVar2.a();
        w jVar3 = new com.alibaba.jsi.standard.js.j(this.g, new c(), com.alibaba.triver.embed.webview.b.f24908a);
        oVarG.a(this.g, com.alibaba.triver.embed.webview.b.f24908a, jVar3);
        jVar3.a();
        oVarG.a();
        a(o.a(applicationContext, R.raw.workerjs_worker), "https://appx/v8.multiworker.js");
        RVLogger.d(f24510a, "Starting JS Worker...");
        a(str3, str2);
        RVLogger.d(f24510a, "JS Worker ready.");
    }

    public void b(com.alibaba.jsi.standard.js.o oVar) {
        a(oVar, this.d, true);
    }

    private void a(String str, String str2) {
        if (b() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            w wVarA = this.g.a(str, str2);
            if (this.g.h()) {
                RVLogger.e(f24510a, "doExecuteScript: " + str2 + " error: " + this.g.i().a(this.g));
            }
            if (wVarA != null) {
                wVarA.a();
            }
        } catch (Throwable th) {
            RVLogger.e(f24510a, "Caught exception when executeScript " + str2 + "\n" + o.a(th));
        }
    }

    public void a() {
        if (b()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.j.2
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.b()) {
                    return;
                }
                try {
                    if (j.this.e != null) {
                        j.this.e.a();
                        j.this.e = null;
                    }
                    if (j.this.i != null) {
                        j.this.i.a();
                        j.this.i = null;
                    }
                    if (j.this.j != null) {
                        j.this.j.a();
                        j.this.j = null;
                    }
                    if (j.this.g != null) {
                        j.this.g.a();
                    }
                    if (j.this.h != null) {
                        j.this.h.b();
                    }
                    if (RVKernelUtils.isDebug()) {
                        RVLogger.e(j.f24510a, "\n******** WARNING ********, These JS Objects will be leaked:\n");
                        j.this.f.j();
                    }
                    if (j.this.f != null) {
                        j.this.f.d();
                    }
                } catch (Throwable th) {
                    try {
                        RVLogger.e(j.f24510a, "Caught exception when release v8 vm", th);
                    } finally {
                        j.this.c.quitSafely();
                    }
                }
            }
        });
    }

    public void a(com.alibaba.jsi.standard.js.j jVar) {
        com.alibaba.jsi.standard.js.j jVar2 = this.i;
        if (jVar2 != null) {
            jVar2.a();
        }
        this.i = jVar;
    }

    public void a(com.alibaba.jsi.standard.js.o oVar) {
        a(oVar, this.b.o(), false);
    }

    private void a(com.alibaba.jsi.standard.js.o oVar, Handler handler, final boolean z) {
        final x xVarV = oVar.v();
        oVar.a();
        if (xVarV == null) {
            RVLogger.e(f24510a, "failed to serialize js object...");
        } else {
            handler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.j.3
                @Override // java.lang.Runnable
                public void run() {
                    w wVar;
                    com.alibaba.jsi.standard.b bVarM = z ? j.this.g : j.this.b.m();
                    com.alibaba.jsi.standard.js.j jVar = z ? j.this.j : j.this.i;
                    if (bVarM == null || bVarM.b() || jVar == null || jVar.u()) {
                        xVarV.a();
                        return;
                    }
                    w[] wVarArr = {xVarV.a(bVarM)};
                    xVarV.a();
                    try {
                        jVar.a(bVarM, (w) null, wVarArr);
                        wVar = wVarArr[0];
                        if (wVar == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            RVLogger.e(j.f24510a, "doPostMessage " + o.a(th));
                            if (wVarArr[0] == null) {
                                return;
                            } else {
                                wVar = wVarArr[0];
                            }
                        } catch (Throwable th2) {
                            w wVar2 = wVarArr[0];
                            if (wVar2 != null) {
                                wVar2.a();
                            }
                            throw th2;
                        }
                    }
                    wVar.a();
                }
            });
        }
    }
}
