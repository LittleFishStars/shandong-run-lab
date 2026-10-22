package com.zj.adlib;

import android.content.Context;
import com.huachenjie.base.view.danmuku.control.dispatcher.IDanMuDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class z52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46188a = 40;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f20984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IDanMuDispatcher f20985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public t52[] f20988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile ArrayList<y52> f20986a = new ArrayList<>();
    public volatile ArrayList<y52> b = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ReentrantLock f20987a = new ReentrantLock();

    public z52(Context context) {
        this.f20984a = context.getApplicationContext();
    }

    public void a(int index, y52 danMuView) {
        this.f20987a.lock();
        try {
            if (index > -1) {
                this.f20986a.add(index, danMuView);
            } else {
                this.f20986a.add(danMuView);
            }
            this.f20987a.unlock();
        } catch (Throwable th) {
            this.f20987a.unlock();
            throw th;
        }
    }

    public void b() {
        this.b.clear();
        this.f20986a.clear();
        this.f20984a = null;
    }

    public synchronized ArrayList<y52> c(int drawnQueueLeave) {
        if (e()) {
            return null;
        }
        ArrayList<y52> arrayList = this.b.size() > 0 ? this.b : this.f20986a;
        ArrayList<y52> arrayList2 = new ArrayList<>();
        int iMin = Math.min(arrayList.size(), drawnQueueLeave);
        for (int i = 0; i < iMin; i++) {
            y52 y52Var = arrayList.get(i);
            this.f20985a.a(y52Var, this.f20988a);
            arrayList2.add(y52Var);
        }
        arrayList.removeAll(arrayList2);
        if (arrayList2.size() > 0) {
            return arrayList2;
        }
        return null;
    }

    public void d(int width, int height) {
        int iB = vn2.b(this.f20984a, 40);
        int i = height / iB;
        this.f20988a = new t52[i];
        for (int i2 = 0; i2 < i; i2++) {
            t52 t52Var = new t52();
            t52Var.f19708a = width;
            t52Var.f19710b = iB;
            t52Var.c = i2 * iB;
            this.f20988a[i2] = t52Var;
        }
    }

    public boolean e() {
        return this.b.size() == 0 && this.f20986a.size() == 0;
    }

    public void f(List<y52> danMuViews) {
        this.f20987a.lock();
        try {
            this.b.addAll(danMuViews);
        } finally {
            this.f20987a.unlock();
        }
    }

    public void g(IDanMuDispatcher iDanMuDispatcher) {
        this.f20985a = iDanMuDispatcher;
    }
}
