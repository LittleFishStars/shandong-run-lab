package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f32642a;
    public final /* synthetic */ l b;

    public e(l lVar, v vVar) {
        this.b = lVar;
        this.f32642a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.b) {
            return;
        }
        this.b.b = true;
        this.b.getClass();
        this.b.f32657a = new WeakReference<>(this.f32642a.f32677a);
        this.b.c = this.f32642a.b;
        this.b.d = new s(this.f32642a.f32677a);
        if (this.b.c) {
            l lVar = this.b;
            lVar.a(new f(lVar, null, true), (HonorPushCallback<?>) null);
        }
    }
}
