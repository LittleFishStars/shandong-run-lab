package com.zj.adlib;

import android.content.Context;
import android.graphics.Canvas;
import com.huachenjie.base.view.danmuku.control.speed.SpeedController;
import com.huachenjie.base.view.danmuku.model.painter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class u52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45065a = 10;
    public static final int b = 40;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f19964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SpeedController f19965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public t52[] f19969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<Integer, a> f19967a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile ArrayList<y52> f19966a = new ArrayList<>();

    public u52(Context c) {
        this.f19964a = c.getApplicationContext();
        i();
        g(false);
    }

    public void a(a danMuPainter, int key) {
        if (danMuPainter == null) {
            return;
        }
        if (this.f19967a.containsKey(Integer.valueOf(key))) {
            throw new IllegalArgumentException("Already has the key of painter");
        }
        this.f19967a.put(Integer.valueOf(key), danMuPainter);
    }

    public void b(int width, int height) {
        int iB = vn2.b(this.f19964a, 40);
        int i = height / iB;
        this.f19969a = new t52[i];
        for (int i2 = 0; i2 < i; i2++) {
            t52 t52Var = new t52();
            t52Var.f19708a = width;
            t52Var.f19710b = iB;
            t52Var.c = i2 * iB;
            this.f19969a[i2] = t52Var;
        }
    }

    public void c(Canvas canvas) {
        d(this.f19966a, canvas);
    }

    public final synchronized void d(ArrayList<y52> danMuViewQueue, Canvas canvas) {
        this.f19968a = true;
        if (danMuViewQueue != null && danMuViewQueue.size() != 0) {
            int i = 0;
            while (i < Math.min(danMuViewQueue.size(), 10)) {
                y52 y52Var = danMuViewQueue.get(i);
                if (y52Var.o()) {
                    a aVarF = f(y52Var);
                    t52 t52Var = this.f19969a[y52Var.f()];
                    t52Var.a(y52Var);
                    if (y52Var.p()) {
                        k(y52Var, aVarF, canvas, t52Var);
                    }
                } else {
                    danMuViewQueue.remove(i);
                    i--;
                }
                i++;
            }
            this.f19968a = false;
        }
    }

    public int e() {
        return 10 - this.f19966a.size();
    }

    public final a f(y52 danMuView) {
        return this.f19967a.get(Integer.valueOf(danMuView.g()));
    }

    public void g(boolean hide) {
        Iterator<Integer> it = this.f19967a.keySet().iterator();
        while (it.hasNext()) {
            this.f19967a.get(it.next()).c(hide);
        }
    }

    public void h(boolean hide) {
        Iterator<Integer> it = this.f19967a.keySet().iterator();
        while (it.hasNext()) {
            this.f19967a.get(it.next()).b(hide);
        }
    }

    public final void i() {
        b77 b77Var = new b77();
        this.f19967a.put(2, new xs4());
        this.f19967a.put(1, b77Var);
    }

    public boolean j() {
        if (this.f19966a != null && this.f19966a.size() != 0) {
            return false;
        }
        this.f19968a = false;
        return true;
    }

    public final void k(y52 danMuView, a danMuPainter, Canvas canvas, t52 danMuChannel) {
        danMuPainter.a(canvas, danMuView, danMuChannel);
    }

    public void l(ArrayList<y52> danMuViews) {
        if (danMuViews == null || danMuViews.size() <= 0) {
            return;
        }
        this.f19966a.addAll(danMuViews);
    }

    public final int m() {
        return (int) ((Math.random() * 20.0d) + 15.0d);
    }

    public void n(SpeedController speedController) {
        this.f19965a = speedController;
    }
}
