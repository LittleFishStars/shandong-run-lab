package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jb implements com.kwad.sdk.core.d<StatusInfo.NativeAdRequestInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.NativeAdRequestInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.NativeAdRequestInfo) bVar, jSONObject);
    }

    private static void a(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        nativeAdRequestInfo.nativeAdStyleControl = nativeAdStyleControl;
        nativeAdStyleControl.parseJson(jSONObject.optJSONObject("nativeAdStyleControl"));
    }

    private static JSONObject b(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "nativeAdStyleControl", nativeAdRequestInfo.nativeAdStyleControl);
        return jSONObject;
    }
}
