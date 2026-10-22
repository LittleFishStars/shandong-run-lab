package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.adn.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class mp extends a1 implements ze {
    private final a b;

    public static class a extends a1.a {
        private a() {
        }
    }

    public mp(rd rdVar) {
        super(rdVar.getContext(), rdVar.c(), rdVar.b(), rdVar.a());
        this.b = new a();
    }

    @Override // com.beizi.fusion.a1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public wc a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        return wc.a.a(context, adItemModel, baVar, adTraceModel);
    }

    @Override // com.beizi.fusion.ze
    public List c() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).c() : Collections.EMPTY_LIST;
    }

    @Override // com.beizi.fusion.ze
    public bf d() {
        ib ibVar = this.f26990a;
        if (ibVar != null) {
            return ((wc) ibVar).d();
        }
        return null;
    }

    @Override // com.beizi.fusion.ze
    public String g() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).g() : "";
    }

    @Override // com.beizi.fusion.ze
    public String getAdLogoUrl() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).getAdLogoUrl() : "";
    }

    @Override // com.beizi.fusion.ze
    public String getDesc() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).getDesc() : "";
    }

    @Override // com.beizi.fusion.ze
    public String getIconUrl() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).getIconUrl() : "";
    }

    @Override // com.beizi.fusion.ze
    public String getTitle() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).getTitle() : "";
    }

    @Override // com.beizi.fusion.ze
    public String h() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ((wc) ibVar).h() : "";
    }

    @Override // com.beizi.fusion.ze
    public u0 i() {
        ib ibVar = this.f26990a;
        if (ibVar != null) {
            return ((wc) ibVar).i();
        }
        return null;
    }

    @Override // com.beizi.fusion.jb
    public void a(sd sdVar) {
        this.b.a(sdVar);
        ((wc) this.f26990a).a((ec) this.b);
    }

    @Override // com.beizi.fusion.jb
    public void a(td tdVar) {
        this.b.a(tdVar);
        ((wc) this.f26990a).a((ad) this.b);
    }

    @Override // com.beizi.fusion.ze
    public void a(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List list) {
        ib ibVar = this.f26990a;
        if (ibVar != null) {
            ((wc) ibVar).a(activity, aSNPUnifiedExpressContainer, list);
        }
    }
}
