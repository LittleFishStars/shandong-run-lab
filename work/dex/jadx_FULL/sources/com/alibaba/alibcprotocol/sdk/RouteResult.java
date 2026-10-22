package com.alibaba.alibcprotocol.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RouteResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23635a;
    private boolean b = true;
    private Object c = null;

    public Object getResult() {
        return this.c;
    }

    public boolean isHandled() {
        return this.f23635a;
    }

    public boolean isSync() {
        return this.b;
    }

    public void setHandled(boolean z) {
        this.f23635a = z;
    }

    public void setResult(Object obj, boolean z) {
        this.c = obj;
        this.f23635a = z;
    }

    public void setSync(boolean z) {
        this.b = z;
    }

    public String toString() {
        return "RouteResult{handled=" + this.f23635a + ", sync=" + this.b + ", result=" + this.c + '}';
    }
}
