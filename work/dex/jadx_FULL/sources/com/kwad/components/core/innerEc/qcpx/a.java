package com.kwad.components.core.innerEc.qcpx;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.core.innerEc.b.a {
    private ReceiveQcpxBody aaF;

    public a(Map<String, String> map, ReceiveQcpxBody receiveQcpxBody) {
        super(map);
        this.aaF = receiveQcpxBody;
        rp();
    }

    private void rp() {
        ReceiveQcpxBody receiveQcpxBody = this.aaF;
        if (receiveQcpxBody == null) {
            return;
        }
        JSONObject json = receiveQcpxBody.toJson();
        Iterator<String> itKeys = json.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = json.optString(next);
            c.d("ReceiveQcpxRequest", "appendBody putBody key: " + next + ", value: " + strOptString);
            putBody(next, strOptString);
        }
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final boolean encryptDisable() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        if (com.kwad.components.core.a.pe.booleanValue()) {
            try {
                d.f(DevelopMangerComponents.class);
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
        return i.EN();
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean needDeviceInfoBody() {
        return false;
    }
}
