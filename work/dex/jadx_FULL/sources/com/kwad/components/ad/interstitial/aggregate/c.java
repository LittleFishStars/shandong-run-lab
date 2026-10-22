package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.interstitial.h.c {
    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        super(context, null);
        setTkLoadListenerAdapter(new g() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1
            @Override // com.kwad.components.core.webview.tachikoma.f.b
            public final void x(String str) {
                if ("tk_interstitial".equals(str)) {
                    b bVar = new b(c.this.mContext);
                    bVar.a(c.this.mAdResultData, c.this.lx, c.this.ce, c.this.ls, 0, false);
                    c.this.oC.removeAllViews();
                    c.this.oC.addView(bVar);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.h.c
    public final void a(AdResultData adResultData, int i) {
        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
        if (adTemplateList == null || i >= adTemplateList.size()) {
            this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
        } else {
            this.mAdTemplate = adTemplateList.get(i);
        }
        this.mAdResultData = adResultData;
        this.mAdInfo = e.eO(this.mAdTemplate);
    }
}
