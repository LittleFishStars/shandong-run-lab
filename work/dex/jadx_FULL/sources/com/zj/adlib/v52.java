package com.zj.adlib;

import android.graphics.Canvas;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class v52 extends Thread {
    public static final int K = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u52 f45291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile WeakReference<IDanMuParent> f20178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20180a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ReentrantLock f20179a = new ReentrantLock();
    public boolean b = true;

    public v52(u52 danMuSharedPool, IDanMuParent danMuParent) {
        this.f45291a = danMuSharedPool;
        this.f20178a = new WeakReference<>(danMuParent);
    }

    public void a(final Canvas canvas) {
        u52 u52Var = this.f45291a;
        if (u52Var != null) {
            u52Var.c(canvas);
        }
    }

    public void b() {
        this.f20180a = true;
    }

    public void c() {
        this.b = false;
        this.f20178a.clear();
        interrupt();
        this.f45291a = null;
    }

    public void d() {
        this.f20180a = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (this.b) {
            if (this.f45291a.j() || this.f20180a) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.f20179a.lock();
                try {
                    if (this.f20178a != null && this.f20178a.get() != null) {
                        this.f20178a.get().lockDraw();
                    }
                    this.f20179a.unlock();
                } catch (Throwable th) {
                    this.f20179a.unlock();
                    throw th;
                }
            }
        }
    }
}
