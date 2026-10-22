package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
abstract class q3 implements xc, wa {
    protected final Context b;
    protected dc c;
    protected View d;
    protected InteractionModel f;
    protected d g;
    protected boolean e = false;
    protected boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final cd f27677a = new cd();

    public q3(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // com.beizi.fusion.xc
    public void b() {
        this.e = false;
        this.f27677a.b();
    }

    public va d() {
        return this.f27677a;
    }

    public abstract void e();

    @Override // com.beizi.fusion.xc
    public void a(View view, d dVar) {
        this.d = view;
        this.g = dVar;
        this.f27677a.a((Object) null);
    }

    @Override // com.beizi.fusion.xc
    public void a() {
        this.e = true;
        this.f27677a.a();
    }

    @Override // com.beizi.fusion.xc
    public void a(dc dcVar) {
        this.c = dcVar;
    }

    public void a(dd.a aVar) {
        if (aVar == dd.a.EULER_INTERACTIVE_TRIGGER || aVar == dd.a.SHAKE_INTERACTIVE_TRIGGER) {
            ((ko) tp.a().b(this.b)).b(this.g);
        }
        this.f27677a.a(aVar, this.d, null);
        dc dcVar = this.c;
        if (dcVar != null) {
            dcVar.a(this.d, aVar.getEventCode());
        }
    }

    @Override // com.beizi.fusion.xc
    public void a(InteractionModel interactionModel) {
        this.f = interactionModel;
        e();
    }
}
