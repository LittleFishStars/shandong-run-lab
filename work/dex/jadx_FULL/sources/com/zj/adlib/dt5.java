package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class dt5<DH extends DraweeHierarchy> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public boolean f16072a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public ArrayList<nr2<DH>> f41272a = new ArrayList<>();

    public void a(int i, nr2<DH> nr2Var) {
        ax6.i(nr2Var);
        ax6.g(i, this.f41272a.size() + 1);
        this.f41272a.add(i, nr2Var);
        if (this.f16072a) {
            nr2Var.j();
        }
    }

    public void b(nr2<DH> nr2Var) {
        a(this.f41272a.size(), nr2Var);
    }

    public void c() {
        if (this.f16072a) {
            for (int i = 0; i < this.f41272a.size(); i++) {
                this.f41272a.get(i).k();
            }
        }
        this.f41272a.clear();
    }

    public void d(Canvas canvas) {
        for (int i = 0; i < this.f41272a.size(); i++) {
            Drawable drawableH = e(i).h();
            if (drawableH != null) {
                drawableH.draw(canvas);
            }
        }
    }

    public nr2<DH> e(int i) {
        return this.f41272a.get(i);
    }

    public void f() {
        if (this.f16072a) {
            return;
        }
        this.f16072a = true;
        for (int i = 0; i < this.f41272a.size(); i++) {
            this.f41272a.get(i).j();
        }
    }

    public void g() {
        if (this.f16072a) {
            this.f16072a = false;
            for (int i = 0; i < this.f41272a.size(); i++) {
                this.f41272a.get(i).k();
            }
        }
    }

    public boolean h(MotionEvent motionEvent) {
        for (int i = 0; i < this.f41272a.size(); i++) {
            if (this.f41272a.get(i).l(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void i(int i) {
        nr2<DH> nr2Var = this.f41272a.get(i);
        if (this.f16072a) {
            nr2Var.k();
        }
        this.f41272a.remove(i);
    }

    public int j() {
        return this.f41272a.size();
    }

    public boolean k(Drawable drawable) {
        for (int i = 0; i < this.f41272a.size(); i++) {
            if (drawable == e(i).h()) {
                return true;
            }
        }
        return false;
    }
}
