package com.alipay.sdk.m.h0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25442a;

    public c(b bVar) {
        this.f25442a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f25442a.a();
        } catch (Exception e) {
            d.a(e);
        }
    }
}
