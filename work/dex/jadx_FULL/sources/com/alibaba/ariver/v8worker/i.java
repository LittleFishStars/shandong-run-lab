package com.alibaba.ariver.v8worker;

import android.os.Handler;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.js.w;
import com.zj.adlib.c49;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {
    private static int b = 5000;
    private static int c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24507a = "V8Worker_JSI_JsTimers";
    private int d = 0;
    private boolean e = false;
    private Map<Integer, h> f = new ConcurrentHashMap();
    private l g;
    private Handler h;

    public i(final com.alibaba.jsi.standard.b bVar, Handler handler, V8Worker v8Worker) {
        if (v8Worker != null && v8Worker.c() != null) {
            this.f24507a += c49.f40900a + v8Worker.c().getAppId();
        }
        this.g = new l();
        this.h = handler;
        if (bVar == null || bVar.b()) {
            return;
        }
        com.alibaba.jsi.standard.js.o oVarG = bVar.g();
        com.alibaba.jsi.standard.js.j jVar = new com.alibaba.jsi.standard.js.j(bVar, new com.alibaba.jsi.standard.js.h() { // from class: com.alibaba.ariver.v8worker.i.1
            @Override // com.alibaba.jsi.standard.js.h
            public w a(com.alibaba.jsi.standard.js.a aVar) {
                try {
                    com.alibaba.jsi.standard.b bVar2 = bVar;
                    if (bVar2 != null && !bVar2.b()) {
                        if (i.this.f.size() >= i.b) {
                            RVLogger.e(i.this.f24507a, "CreateTimer too many active timers.");
                            return new com.alibaba.jsi.standard.js.m(0);
                        }
                        com.alibaba.jsi.standard.js.j jVar2 = (com.alibaba.jsi.standard.js.j) aVar.a(0);
                        w wVarA = aVar.a(1);
                        w wVarA2 = aVar.a(2);
                        int iL = ((com.alibaba.jsi.standard.js.m) wVarA).l();
                        boolean zB_ = ((com.alibaba.jsi.standard.js.f) wVarA2).b_();
                        int iB = i.this.b();
                        if (iB < 0) {
                            RVLogger.e(i.this.f24507a, "CreateTimer failed to allocate timer Id.");
                            return new com.alibaba.jsi.standard.js.m(0);
                        }
                        int i = iB + 1;
                        h hVar = new h(i.this, bVar, jVar2, iB, zB_);
                        i.this.f.put(Integer.valueOf(iB), hVar);
                        if (iL < 0) {
                            iL = 0;
                        }
                        if (zB_) {
                            long j = iL;
                            i.this.g.a(hVar, j, j);
                        } else {
                            i.this.g.a(hVar, iL);
                        }
                        wVarA.a();
                        wVarA2.a();
                        return new com.alibaba.jsi.standard.js.m(i);
                    }
                    return new com.alibaba.jsi.standard.js.m(0);
                } catch (Throwable th) {
                    RVLogger.e(i.this.f24507a, "__nativeCreateTimer__ onCallFunction error" + th);
                    return new com.alibaba.jsi.standard.js.m(0);
                }
            }
        }, "__nativeCreateTimer__");
        oVarG.a(bVar, "__nativeCreateTimer__", jVar);
        jVar.a();
        com.alibaba.jsi.standard.js.j jVar2 = new com.alibaba.jsi.standard.js.j(bVar, new com.alibaba.jsi.standard.js.h() { // from class: com.alibaba.ariver.v8worker.i.2
            @Override // com.alibaba.jsi.standard.js.h
            public w a(com.alibaba.jsi.standard.js.a aVar) {
                try {
                    w wVarA = aVar.a(0);
                    int iL = ((com.alibaba.jsi.standard.js.m) wVarA).l() - 1;
                    wVarA.a();
                    RVLogger.d(i.this.f24507a, "delete JsTimers id: " + iL);
                    h hVar = (h) i.this.f.get(Integer.valueOf(iL));
                    if (hVar == null) {
                        return null;
                    }
                    i.this.a(iL);
                    hVar.a();
                } catch (Throwable th) {
                    RVLogger.e(i.this.f24507a, "__nativeDeleteTimer__ onCallFunction error" + th);
                }
                return null;
            }
        }, "__nativeDeleteTimer__");
        oVarG.a(bVar, "__nativeDeleteTimer__", jVar2);
        jVar2.a();
        oVarG.a();
    }

    public void d() {
        if (this.e) {
            this.e = false;
            RVLogger.d(this.f24507a, " Timer resume()");
            this.g.b();
        }
    }

    public void e() {
        RVLogger.d(this.f24507a, " Timer terminate()");
        this.g.c();
        this.g.d();
        Iterator<Map.Entry<Integer, h>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            h value = it.next().getValue();
            if (value != null) {
                value.a();
            }
        }
        this.f.clear();
    }

    public Handler a() {
        return this.h;
    }

    public int b() {
        int i = 0;
        while (i < 2) {
            int i2 = this.d;
            int i3 = i2 + 1;
            this.d = i3;
            if (i3 >= c) {
                this.d = 0;
                i++;
            }
            if (!this.f.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public void c() {
        if (this.e) {
            return;
        }
        RVLogger.d(this.f24507a, " Timer pause()");
        this.e = true;
        this.g.a();
    }

    public void a(int i) {
        this.f.remove(Integer.valueOf(i));
    }
}
