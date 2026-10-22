package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class z implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private DialogInterface.OnDismissListener Cs;
    protected final com.kwad.sdk.core.webview.b apJ;
    private int apU;
    private boolean apV;
    private final boolean apW;
    private boolean apX;
    private List<com.kwad.components.core.e.d.d> apY;
    private boolean apZ;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a fl;

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.apV = false;
        this.apY = new ArrayList();
        this.apV = z;
        this.apJ = bVar;
        this.apU = i;
        if (dVar != null) {
            dVar.aS(1);
            this.apY.add(dVar);
        }
        this.fl = aVar;
        this.apW = z2;
        this.apZ = z3;
    }

    @Nullable
    public final com.kwad.components.core.e.d.d W(long j) {
        List<com.kwad.components.core.e.d.d> list = this.apY;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.apY.get(0);
        }
        for (com.kwad.components.core.e.d.d dVar : this.apY) {
            if (com.kwad.sdk.core.response.helper.e.eY(dVar.qt()) == j) {
                return dVar;
            }
        }
        return null;
    }

    public void ai(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    public void kN() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fl = null;
    }

    public static /* synthetic */ boolean a(z zVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.ara == 1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.apJ.Pv() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.apJ.bbX && !aVar.bdi) {
            by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.z.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    String strB;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = z.this.apJ;
                    if (bVar.bbY) {
                        com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                        AdTemplate adTemplate = aVar2.adTemplate;
                        if (adTemplate != null) {
                            z.this.apY.add(new com.kwad.components.core.e.d.d(adTemplate));
                        } else if (aVar2.creativeId >= 0) {
                            List<AdTemplate> listPu = bVar.Pu();
                            com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                            adTemplate = com.kwad.sdk.core.response.helper.e.a(listPu, aVar3.creativeId, aVar3.adStyle);
                        } else {
                            adTemplate = bVar.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.helper.e.eJ(adTemplate);
                        }
                        com.kwad.components.core.e.d.d dVarW = z.this.W(aVar.creativeId);
                        if (z.this.Cs != null && dVarW != null) {
                            dVarW.setOnDismissListener(z.this.Cs);
                        }
                        if (TextUtils.isEmpty(aVar.Rk)) {
                            strB = (adTemplate == null || (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) == null) ? null : tKAdLiveShopItemInfo.itemId;
                        } else {
                            try {
                                strB = com.kwad.components.core.e.b.a.B(Long.parseLong(aVar.Rk));
                            } catch (Exception unused) {
                                strB = aVar.Rk;
                            }
                        }
                        z.this.ai(com.kwad.components.core.e.d.a.a(z.this.a(new com.kwad.components.core.e.d.a.C1201a(z.this.apJ.adW.getContext()).aJ(adTemplate).b(dVarW).ap(strB).as(z.a(z.this, aVar)).at(z.this.apV).d(z.this.apJ.mReportExtData).aN(aVar.ara).aL(aVar.bdh).aM(aVar.nm).au(z.this.apW || aVar.needReport).aR(z.this.apU).ap(z.this.apZ).aw(z.this.apX).aA(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                z.this.kN();
                                if (z.this.fl != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aVar.bdj) {
                                        return;
                                    }
                                    z.this.fl.a(aVar);
                                }
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.fl != null) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (z.this.fl == null || aVar.bdj) {
                        return;
                    }
                    z.this.fl.a(aVar);
                }
            });
        }
        cVar.b(null);
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, dVar, aVar, false, 0, false, false);
        this.Cs = onDismissListener;
    }

    public com.kwad.components.core.e.d.a.C1201a a(com.kwad.components.core.e.d.a.C1201a c1201a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.d dVar;
        int i;
        com.kwad.sdk.core.webview.d.b.d dVar2 = aVar.arb;
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.QY)) {
            c1201a.aq(aVar.arb.QY);
        }
        com.kwad.sdk.core.webview.d.b.d dVar3 = aVar.arb;
        if (dVar3 != null && (i = dVar3.convertType) != 0) {
            c1201a.aP(i);
        }
        if (com.kwad.sdk.core.response.helper.e.fh(adTemplate) && (dVar = aVar.arb) != null && dVar.bdk != null) {
            com.kwad.sdk.utils.al.a aVar2 = new com.kwad.sdk.utils.al.a();
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.arb.bdk;
            aVar2.k((float) cVar.x, (float) cVar.y);
            com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.arb.bdk;
            aVar2.j((float) cVar2.x, (float) cVar2.y);
            com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.arb.bdk;
            aVar2.H(cVar3.width, cVar3.height);
            c1201a.d(aVar2);
        } else {
            com.kwad.sdk.widget.g gVar = this.apJ.bbV;
            if (gVar != null) {
                c1201a.d(gVar.getTouchCoords());
            }
        }
        c1201a.a(null, null, null);
        return c1201a;
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, dVar, aVar, false, 0, false, false);
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, dVar, aVar, false, 0, false, false);
        this.apX = true;
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, dVar, null, false, 2, z, false);
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, dVar, aVar, false, 1, false, false);
    }

    public z(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.e.d.d> list, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.apY.addAll(list);
        }
    }
}
