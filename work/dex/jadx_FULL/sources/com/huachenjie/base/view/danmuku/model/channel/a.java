package com.huachenjie.base.view.danmuku.model.channel;

import android.content.Context;
import android.graphics.Canvas;
import com.huachenjie.base.view.danmuku.control.dispatcher.IDanMuDispatcher;
import com.huachenjie.base.view.danmuku.control.speed.SpeedController;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;
import com.zj.adlib.a62;
import com.zj.adlib.u52;
import com.zj.adlib.v52;
import com.zj.adlib.y52;
import com.zj.adlib.z52;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a implements IDanMuPoolManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a62 f32978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u52 f7300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v52 f7301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z52 f7302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7303a;

    public a(Context context, IDanMuParent danMuParent) {
        this.f7300a = new u52(context);
        this.f7302a = new z52(context);
        this.f7301a = new v52(this.f7300a, danMuParent);
        this.f32978a = new a62(this.f7302a, this.f7300a);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void a(boolean hideAll) {
        this.f7300a.h(hideAll);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void b(boolean hide) {
        this.f7300a.g(hide);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void c() {
        if (this.f7303a) {
            return;
        }
        this.f7303a = true;
        this.f7301a.start();
        this.f32978a.f();
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void d(SpeedController speedController) {
        this.f7300a.n(speedController);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void e(int width, int height) {
        this.f7302a.d(width, height);
        this.f7300a.b(width, height);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void f(int index, y52 danMuView) {
        this.f32978a.d(index, danMuView);
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void g(IDanMuDispatcher iDanMuDispatcher) {
        this.f7302a.g(iDanMuDispatcher);
    }

    public void h(com.huachenjie.base.view.danmuku.model.painter.a danMuPainter, int key) {
        this.f7300a.a(danMuPainter, key);
    }

    public void i(Canvas canvas) {
        this.f7301a.a(canvas);
    }

    public void j() {
        this.f7301a.b();
    }

    @Override // com.huachenjie.base.view.danmuku.model.channel.IDanMuPoolManager
    public void jumpQueue(List<y52> danMuViews) {
        this.f32978a.c(danMuViews);
    }

    public void k() {
        this.f7303a = false;
        this.f7301a.c();
        this.f32978a.e();
        this.f7300a = null;
    }

    public void l() {
        this.f7301a.d();
    }
}
