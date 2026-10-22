package com.zj.adlib;

import android.graphics.Canvas;
import android.view.View;
import com.huachenjie.base.view.danmuku.control.speed.SpeedController;
import com.huachenjie.base.view.danmuku.model.channel.a;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class w52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpeedController f45525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f20369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x52 f20370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20371a = false;

    /* JADX WARN: Multi-variable type inference failed */
    public w52(View view) {
        if (this.f45525a == null) {
            this.f45525a = new fa7();
        }
        if (this.f20369a == null) {
            this.f20369a = new a(view.getContext(), (IDanMuParent) view);
        }
        if (this.f20370a == null) {
            this.f20370a = new x52(view.getContext());
        }
        this.f20369a.g(this.f20370a);
    }

    public void a(int index, y52 danMuView) {
        this.f20369a.f(index, danMuView);
    }

    public void b(com.huachenjie.base.view.danmuku.model.painter.a danMuPainter, int key) {
        this.f20369a.h(danMuPainter, key);
    }

    public void c(Canvas canvas) {
        this.f20369a.i(canvas);
    }

    public void d() {
        this.f20369a.j();
    }

    public void e() {
        a aVar = this.f20369a;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void f(boolean hide) {
        a aVar = this.f20369a;
        if (aVar != null) {
            aVar.b(hide);
        }
    }

    public void g(boolean hideAll) {
        a aVar = this.f20369a;
        if (aVar != null) {
            aVar.a(hideAll);
        }
    }

    public void h(Canvas canvas) {
        if (this.f20371a) {
            return;
        }
        this.f45525a.b(canvas.getWidth());
        this.f20369a.d(this.f45525a);
        this.f20369a.e(canvas.getWidth(), canvas.getHeight());
        this.f20371a = true;
    }

    public boolean i() {
        return this.f20371a;
    }

    public void j(List<y52> danMuViews) {
        this.f20369a.jumpQueue(danMuViews);
    }

    public void k() {
        this.f20369a.c();
    }

    public void l() {
        a aVar = this.f20369a;
        if (aVar != null) {
            aVar.k();
            this.f20369a = null;
        }
        x52 x52Var = this.f20370a;
        if (x52Var != null) {
            x52Var.c();
        }
    }

    public void m(SpeedController speedController) {
        if (speedController != null) {
            this.f45525a = speedController;
        }
    }
}
