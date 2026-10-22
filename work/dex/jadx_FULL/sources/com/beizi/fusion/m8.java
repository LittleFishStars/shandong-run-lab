package com.beizi.fusion;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.SlideModel;
import com.beizi.fusion.widget.ScrollClickView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class m8 extends q3 {
    private a i;
    private final boolean j;

    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27536a;
        private float b;
        private float c;
        private final float d;

        private b(SlideModel slideModel, String str) {
            this.f27536a = slideModel.getSlideDirection(str);
            this.d = slideModel.getSlideDistance(str);
        }

        @Override // com.beizi.fusion.m8.a
        public boolean a(MotionEvent motionEvent) {
            String str;
            if (motionEvent.getAction() == 0) {
                this.b = motionEvent.getX();
                this.c = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                m8 m8Var = m8.this;
                if (m8Var.j) {
                    m8Var.f();
                    return true;
                }
                int scaledTouchSlop = ViewConfiguration.get(m8Var.d.getContext()).getScaledTouchSlop();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = scaledTouchSlop;
                if ((Math.abs(this.b - x) > f || Math.abs(this.c - y) > f) && (Math.abs(this.b - x) > this.d || Math.abs(this.c - y) > this.d)) {
                    if ("all".equalsIgnoreCase(this.f27536a)) {
                        m8.this.f();
                        return true;
                    }
                    if (Math.abs(this.b - x) > Math.abs(this.c - y)) {
                        str = this.b > x ? "left" : "right";
                    } else {
                        str = this.c > y ? ScrollClickView.DIR_UP : ScrollClickView.DIR_DOWN;
                    }
                    if (str.equalsIgnoreCase(this.f27536a)) {
                        m8.this.f();
                    }
                }
            }
            return true;
        }
    }

    public m8(Context context, boolean z) {
        super(context);
        this.j = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i = null;
        a(dd.a.GESTURE_INTERACTIVE_TRIGGER);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void a(dc dcVar) {
        super.a(dcVar);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.wa
    public /* bridge */ /* synthetic */ va d() {
        return super.d();
    }

    @Override // com.beizi.fusion.q3
    public void e() {
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || interactionModel.getSlideModel() == null) {
            return;
        }
        ko koVar = (ko) tp.a().b(this.b);
        if (koVar.a(this.f.getProtectTime()) || koVar.a(this.g, this.f.getCoolTime())) {
            this.i = new b(this.f.getSlideModel(), "Cooling");
        } else {
            this.i = new b(this.f.getSlideModel(), "Normal");
        }
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(InteractionModel interactionModel) {
        super.a(interactionModel);
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(View view, d dVar) {
        super.a(view, dVar);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public boolean a(MotionEvent motionEvent) {
        a aVar = this.i;
        if (aVar != null) {
            return aVar.a(motionEvent);
        }
        return false;
    }
}
