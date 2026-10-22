package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.js.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class h extends m {
    private i g;
    private com.alibaba.jsi.standard.b h;
    private com.alibaba.jsi.standard.js.j i;
    private int j;
    private boolean k;
    private final String f = "JsTimerTask";
    private volatile boolean l = false;

    public h(i iVar, com.alibaba.jsi.standard.b bVar, com.alibaba.jsi.standard.js.j jVar, int i, boolean z) {
        this.g = iVar;
        this.h = bVar;
        this.i = jVar;
        this.j = i;
        this.k = z;
    }

    @Override // com.alibaba.ariver.v8worker.m, java.lang.Runnable
    public void run() {
        if (this.k && this.l) {
            return;
        }
        try {
            com.alibaba.jsi.standard.b bVar = this.h;
            if (bVar != null && !bVar.b()) {
                this.g.a().post(new Runnable() { // from class: com.alibaba.ariver.v8worker.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (h.this.g != null && h.this.i != null && h.this.h != null && !h.this.h.b()) {
                                if (h.this.k) {
                                    h.this.l = true;
                                } else {
                                    h.this.g.a(h.this.j);
                                }
                                w wVarA = h.this.i.a(h.this.h, (w) null, (w[]) null);
                                if (wVarA != null) {
                                    wVarA.a();
                                }
                                if (h.this.k) {
                                    h.this.l = false;
                                } else {
                                    h.this.a();
                                }
                            }
                        } catch (Throwable th) {
                            RVLogger.e("JsTimerTask", "JSTimerTask error : " + th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            RVLogger.d("JsTimerTask", "JsTimerTask.run error: " + th);
        }
    }

    @Override // com.alibaba.ariver.v8worker.m
    public boolean a() {
        com.alibaba.jsi.standard.js.j jVar = this.i;
        if (jVar != null) {
            jVar.a();
            this.i = null;
        }
        return super.a();
    }
}
