package com.kwad.sdk.utils.c;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class c extends a<com.kwad.sdk.k.a.d, Context> {
    public c() {
        super("ksad_env_info");
    }

    private static com.kwad.sdk.k.a.d XH() {
        return s.UE();
    }

    private static String a(com.kwad.sdk.k.a.d dVar) {
        try {
            return dVar.toJson().toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return "";
        }
    }

    private static com.kwad.sdk.k.a.d iC(String str) {
        try {
            com.kwad.sdk.k.a.d dVar = new com.kwad.sdk.k.a.d(ServiceProvider.getContext().getApplicationContext());
            dVar.parseJson(new JSONObject(str));
            return dVar;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ String dataToString(com.kwad.sdk.k.a.d dVar) {
        return a(dVar);
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ com.kwad.sdk.k.a.d iA(String str) {
        return iC(str);
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ com.kwad.sdk.k.a.d x(Context context) {
        return XH();
    }
}
