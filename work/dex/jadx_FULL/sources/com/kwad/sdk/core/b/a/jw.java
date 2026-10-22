package com.kwad.sdk.core.b.a;

import com.alibaba.ariver.kernel.RVConstants;
import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jw implements com.kwad.sdk.core.d<PageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PageInfo) bVar, jSONObject);
    }

    private static void a(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt(RVConstants.EXTRA_PAGETYPE);
    }

    private static JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = pageInfo.pageType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, RVConstants.EXTRA_PAGETYPE, i);
        }
        return jSONObject;
    }
}
