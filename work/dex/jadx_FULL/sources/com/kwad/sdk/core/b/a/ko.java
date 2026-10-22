package com.kwad.sdk.core.b.a;

import com.kwad.components.core.innerEc.qcpx.ReceiveQcpxBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ko implements com.kwad.sdk.core.d<ReceiveQcpxBody> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ReceiveQcpxBody) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ReceiveQcpxBody) bVar, jSONObject);
    }

    private static void a(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        receiveQcpxBody.flowTag = jSONObject.optString("flowTag");
        if (JSONObject.NULL.toString().equals(receiveQcpxBody.flowTag)) {
            receiveQcpxBody.flowTag = "";
        }
        receiveQcpxBody.llsid = jSONObject.optLong("llsid");
        receiveQcpxBody.creativeId = jSONObject.optLong("creativeId");
    }

    private static JSONObject b(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = receiveQcpxBody.flowTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowTag", receiveQcpxBody.flowTag);
        }
        long j = receiveQcpxBody.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", j);
        }
        long j2 = receiveQcpxBody.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", j2);
        }
        return jSONObject;
    }
}
