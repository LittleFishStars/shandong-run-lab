package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d implements m {
    private AdTemplate a(n.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        return adTemplate != null ? adTemplate : zq();
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        try {
            n.a aVar = new n.a();
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    aVar.parseJson(new JSONObject((String) obj));
                }
            }
            com.kwad.sdk.core.download.a.ew(com.kwad.sdk.core.response.helper.e.eO(a(aVar)).adConversionInfo.appDownloadUrl);
            return Boolean.TRUE;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public abstract AdTemplate zq();
}
