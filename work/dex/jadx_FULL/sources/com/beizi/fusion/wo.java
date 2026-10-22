package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class wo extends a1 implements pd {
    protected final a b;

    public static class a extends a1.a implements de {
        private ud d;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ud udVar) {
            this.d = udVar;
        }

        @Override // com.beizi.fusion.de
        public void a(View view) {
            ud udVar = this.d;
            if (udVar != null) {
                udVar.a(view);
            }
        }

        @Override // com.beizi.fusion.de
        public void a(sf sfVar) {
            ud udVar = this.d;
            if (udVar != null) {
                udVar.f();
            }
        }
    }

    public wo(rd rdVar) {
        super(rdVar.getContext(), rdVar.c(), rdVar.b(), rdVar.a());
        this.b = l();
    }

    @Override // com.beizi.fusion.a1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public vc a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        return vc.a.a(context, adItemModel, baVar, adTraceModel);
    }

    public a l() {
        return new a();
    }

    @Override // com.beizi.fusion.pd
    public void a(ud udVar) {
        this.b.a(udVar);
        ((vc) this.f26990a).a((de) this.b);
        ((vc) this.f26990a).k();
    }

    @Override // com.beizi.fusion.pd
    public View a() {
        ib ibVar = this.f26990a;
        if (ibVar != null) {
            return ((vc) ibVar).a();
        }
        return null;
    }

    @Override // com.beizi.fusion.jb
    public void a(sd sdVar) {
        this.b.a(sdVar);
        ((vc) this.f26990a).a((ec) this.b);
    }

    @Override // com.beizi.fusion.jb
    public void a(td tdVar) {
        this.b.a(tdVar);
        ((vc) this.f26990a).a((ad) this.b);
    }

    @Override // com.beizi.fusion.jb
    public void a(vd vdVar) {
        this.b.a(vdVar);
        ((vc) this.f26990a).a((ef) this.b);
    }
}
