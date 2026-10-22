package com.kwad.sdk.utils.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class b extends com.kwad.sdk.utils.c.a<com.kwad.sdk.core.request.model.b, a> {

    public static class a {
        public int aXf;
        public boolean bsM;
    }

    public b() {
        super("ksad_device_info");
    }

    private static String a(com.kwad.sdk.core.request.model.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            return bVar.toJson().toString();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static com.kwad.sdk.core.request.model.b iB(String str) {
        try {
            com.kwad.sdk.core.request.model.b bVar = new com.kwad.sdk.core.request.model.b();
            bVar.parseJson(new JSONObject(str));
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ String dataToString(com.kwad.sdk.core.request.model.b bVar) {
        return a(bVar);
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ com.kwad.sdk.core.request.model.b iA(String str) {
        return iB(str);
    }

    @Override // com.kwad.sdk.utils.c.a
    public final /* synthetic */ com.kwad.sdk.core.request.model.b x(a aVar) {
        return a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.utils.c.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.kwad.sdk.core.request.model.b bVar, a aVar) {
        super.b(bVar, aVar);
        bVar.i(aVar.bsM, aVar.aXf);
    }

    private static com.kwad.sdk.core.request.model.b a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return com.kwad.sdk.core.request.model.b.h(aVar.bsM, aVar.aXf);
    }
}
