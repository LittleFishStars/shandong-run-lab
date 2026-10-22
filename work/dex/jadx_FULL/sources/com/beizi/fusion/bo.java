package com.beizi.fusion;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par.SlideParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class bo extends vk {
    private ViewTreeObserver.OnScrollChangedListener f;
    private Rect g;
    private int h;
    private int i;
    private SlideParams j;
    private final long k;
    private boolean l;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            bo boVar = bo.this;
            if (boVar.l) {
                boVar.d.getGlobalVisibleRect(boVar.g);
                bo boVar2 = bo.this;
                if (boVar2.i == 0) {
                    boVar2.i = boVar2.g.top;
                }
                boVar2.h += Math.abs(boVar2.g.top - boVar2.i);
                bo boVar3 = bo.this;
                if (boVar3.h > boVar3.j.getDistance()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    bo boVar4 = bo.this;
                    if (jCurrentTimeMillis - boVar4.k > boVar4.j.getNeedTime()) {
                        bo.this.c();
                        bo.this.d.getViewTreeObserver().removeOnScrollChangedListener(bo.this.f);
                    }
                }
            }
        }
    }

    public bo(Context context) {
        super(context);
        this.l = false;
        this.k = System.currentTimeMillis();
    }

    private ViewTreeObserver.OnScrollChangedListener f() {
        if (this.j == null) {
            return null;
        }
        this.g = new Rect();
        return new a();
    }

    @Override // com.beizi.fusion.vk, com.beizi.fusion.xc
    public void b() {
        super.b();
        this.l = false;
    }

    @Override // com.beizi.fusion.vk, com.beizi.fusion.xc
    public void a() {
        super.a();
        this.l = true;
    }

    @Override // com.beizi.fusion.vk
    public void b(OptimizeModel optimizeModel) {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        this.j = optimizeModel.getSlide();
        if (this.d != null) {
            this.f = f();
            ViewTreeObserver viewTreeObserver = this.d.getViewTreeObserver();
            if (viewTreeObserver == null || (onScrollChangedListener = this.f) == null) {
                return;
            }
            viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    @Override // com.beizi.fusion.vk, com.beizi.fusion.xc
    public void a(View view, d dVar) {
        super.a(view, dVar);
    }
}
