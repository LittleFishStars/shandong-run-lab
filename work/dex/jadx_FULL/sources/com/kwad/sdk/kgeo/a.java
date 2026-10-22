package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static String bhx;
    private static KGeoInfo bhy;
    private static final AtomicBoolean bhz = new AtomicBoolean();

    @Nullable
    public static String Fy() {
        return bhx;
    }

    @Nullable
    public static KGeoInfo RB() {
        return bhy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RC() {
        try {
            if (bhz.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Ud(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.bhx = str;
                    a.RD();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void rc() {
                    a.RD();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RD() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                private static KGeoResultData gO(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ BaseResultData parseData(String str) {
                    return gO(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.bhy = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void fc(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            RC();
        } else if (i == 2) {
            com.kwad.components.core.request.b.vQ().a(new com.kwad.components.core.request.b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void vS() {
                    com.kwad.components.core.request.b.vQ().b(this);
                    a.RC();
                }
            });
        }
    }
}
