package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ao extends q3 {
    public ao(Context context) {
        super(context);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(dd.a.CLICK_INTERACTIVE_TRIGGER);
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(InteractionModel interactionModel) {
        super.a(interactionModel);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void a(View view, d dVar) {
        super.a(view, dVar);
        if (view != 0) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mja
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f43316a.a(view2);
                }
            });
            if (view instanceof ic) {
                ((ic) view).addExtraExecutor(new bd() { // from class: com.zj.adlib.nja
                    @Override // com.beizi.fusion.bd
                    public final void a(View view2) {
                        this.f43538a.b(view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(dd.a.CLICK_INTERACTIVE_TRIGGER);
    }
}
