package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static boolean e(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.lx;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo adInfoEO = e.eO(cVar.mAdTemplate);
            int iDV = com.kwad.components.ad.interstitial.c.b.dV();
            int iDW = com.kwad.components.ad.interstitial.c.b.dW();
            if (iDV > com.kwad.sdk.core.response.helper.a.cD(adInfoEO) && iDW < com.kwad.sdk.core.response.helper.a.cE(adInfoEO)) {
                if (com.kwad.sdk.core.response.helper.a.cF(adInfoEO) == 2) {
                    com.kwad.components.ad.interstitial.h.b.f(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.helper.a.cF(adInfoEO) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.helper.a.cG(adInfoEO), new com.kwad.components.core.page.widget.a.InterfaceC1224a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(cVar.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ej(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = cVar;
                            cVar2.a(false, -1, cVar2.cB);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(cVar.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(151).ej(8));
                            cVar.lx.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().ee(149).ej(8));
                    return true;
                }
            }
        }
        return false;
    }
}
