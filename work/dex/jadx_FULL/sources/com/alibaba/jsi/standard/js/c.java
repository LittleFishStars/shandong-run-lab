package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.jsi.standard.c f24579a;
    private long b = 0;
    private Thread c = null;

    public c(com.alibaba.jsi.standard.c cVar) {
        this.f24579a = cVar;
        a();
    }

    public synchronized boolean a() {
        if (this.b != 0) {
            if (this.c == Thread.currentThread()) {
                return true;
            }
            a("enter");
        }
        if (this.f24579a.e()) {
            throw new Error("JSEngine '" + this.f24579a.c() + "' has been disposed!");
        }
        Object objEngineCmd = Bridge.engineCmd(this.f24579a, 1, 0L);
        if (objEngineCmd != null && (objEngineCmd instanceof Long)) {
            this.b = ((Long) objEngineCmd).longValue();
            this.c = Thread.currentThread();
        }
        return this.b != 0;
    }

    public synchronized void b() {
        if (this.b == 0) {
            return;
        }
        if (this.c != Thread.currentThread()) {
            a(com.alipay.sdk.m.c0.d.A);
        }
        if (this.f24579a.e()) {
            return;
        }
        Bridge.engineCmd(this.f24579a, 2, this.b);
        this.b = 0L;
        this.c = null;
    }

    private void a(String str) {
        throw new Error("Can not call EngineScope." + str + " across thread: current is" + Thread.currentThread() + ", while the scope has thread " + this.c);
    }
}
