package com.beizi.fusion;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.TouchOptimizeFrame;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class bp extends vk {
    private boolean f;
    private View.OnTouchListener g;
    private boolean h;
    private boolean i;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                bp bpVar = bp.this;
                if (bpVar.f) {
                    bpVar.c();
                    bp bpVar2 = bp.this;
                    bpVar2.f = false;
                    bpVar2.h();
                    return true;
                }
            }
            return false;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            bp bpVar = bp.this;
            bpVar.f = true;
            if (bpVar.i) {
                bpVar.c();
                return false;
            }
            bpVar.g();
            return false;
        }
    }

    public bp(Context context) {
        super(context);
        this.f = false;
        this.h = false;
        this.i = false;
    }

    private View.OnTouchListener f() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.g == null && this.h) {
            View.OnTouchListener onTouchListenerF = f();
            this.g = onTouchListenerF;
            a(this.d, onTouchListenerF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(this.d, (View.OnTouchListener) null);
    }

    @Override // com.beizi.fusion.vk
    public void b(OptimizeModel optimizeModel) {
        super.b(optimizeModel);
        View view = this.d;
        if (view != null) {
            view.setOnTouchListener(new b());
        }
    }

    @Override // com.beizi.fusion.vk, com.beizi.fusion.xc
    public void a(View view, d dVar) {
        super.a(view, dVar);
        if (view instanceof TouchOptimizeFrame) {
            TouchOptimizeFrame touchOptimizeFrame = (TouchOptimizeFrame) view;
            this.h = touchOptimizeFrame.isParentUp();
            this.i = touchOptimizeFrame.isQuickTouch();
        }
    }

    private void a(View view, View.OnTouchListener onTouchListener) {
        if (view != null) {
            for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ((ViewGroup) parent).setOnTouchListener(onTouchListener);
            }
        }
    }
}
