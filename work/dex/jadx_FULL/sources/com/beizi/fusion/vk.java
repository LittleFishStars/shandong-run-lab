package com.beizi.fusion;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vk implements xc, wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final cd f27871a = new cd();
    protected OptimizeModel b;
    private dc c;
    protected View d;
    protected b e;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b bVar = vk.this.e;
            if (bVar != null) {
                bVar.a(view, motionEvent);
            }
            if (motionEvent.getAction() == 1) {
                vk.this.c();
            }
            return true;
        }
    }

    public interface b {
        void a(View view, MotionEvent motionEvent);
    }

    public vk(Context context) {
    }

    @Override // com.beizi.fusion.xc
    public void b() {
    }

    public void b(OptimizeModel optimizeModel) {
        View view = this.d;
        if (view != null) {
            view.setOnTouchListener(new a());
        }
    }

    public void c() {
        cd cdVar = this.f27871a;
        dd.a aVar = dd.a.OPTIMIZE_INTERACTIVE_TRIGGER;
        cdVar.a(aVar, this.d, null);
        dc dcVar = this.c;
        if (dcVar != null) {
            dcVar.a(this.d, aVar.getEventCode());
        }
    }

    @Override // com.beizi.fusion.wa
    public va d() {
        return this.f27871a;
    }

    public void e() {
        this.d = null;
        b();
    }

    @Override // com.beizi.fusion.xc
    public void a(View view, d dVar) {
        this.d = view;
        this.f27871a.a((Object) null);
    }

    @Override // com.beizi.fusion.xc
    public void a() {
        this.f27871a.a();
    }

    @Override // com.beizi.fusion.xc
    public void a(dc dcVar) {
        this.c = dcVar;
    }

    @Override // com.beizi.fusion.xc
    public void a(OptimizeModel optimizeModel) {
        this.b = optimizeModel;
        b(optimizeModel);
    }

    public void a(b bVar) {
        this.e = bVar;
    }
}
