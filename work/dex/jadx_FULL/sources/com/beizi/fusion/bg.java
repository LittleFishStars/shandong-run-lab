package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class bg extends q3 {
    public bg(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(InteractionModel interactionModel) {
        super.a(interactionModel);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void b() {
        super.b();
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.wa
    public /* bridge */ /* synthetic */ va d() {
        return super.d();
    }

    @Override // com.beizi.fusion.q3
    public void e() {
    }

    public synchronized void f() {
        try {
            Thread.sleep(1000L);
            this.f27677a.a(dd.a.LANDING_PAGE_ENDCARD_INTERACTIVE_TRIGGER, this.d, null);
            dc dcVar = this.c;
            if (dcVar instanceof j1) {
                ((j1) dcVar).a(this.d);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(View view, d dVar) {
        super.a(view, dVar);
    }

    public synchronized void b(dd.a aVar) {
        this.f27677a.a(aVar, this.d, null);
        dc dcVar = this.c;
        if (dcVar != null) {
            dcVar.a(this.d, aVar.getEventCode());
        }
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public synchronized void a(Context context, String str) {
        this.f27677a.a(dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER, this.d, null);
        dc dcVar = this.c;
        if (dcVar instanceof g1) {
            ((g1) dcVar).b(context, str);
        }
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void a(dc dcVar) {
        super.a(dcVar);
    }
}
