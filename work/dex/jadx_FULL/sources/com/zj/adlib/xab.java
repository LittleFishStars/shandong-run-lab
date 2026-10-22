package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class xab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ceb f45780a;
    public final /* synthetic */ String f;

    public xab(String str, ceb cebVar) {
        this.f = str;
        this.f45780a = cebVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            mib.i(this.f, null, this.f45780a);
        } catch (Throwable unused) {
        }
    }
}
