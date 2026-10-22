package com.aliyun.svideosdk.multirecorder.impl.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class f extends a implements c.b {
    private c l = new c(n(), this);

    public final void c(boolean z) {
        this.l.a(k());
        this.l.a(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        this.l.a();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.c.b
    public final void g() {
        o();
        m();
    }

    public abstract void o();

    public final void p() {
        this.l.d();
    }
}
