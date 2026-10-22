package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.model.message.AnrReason;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bj implements com.kwad.sdk.core.d<AnrReason> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AnrReason) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AnrReason) bVar, jSONObject);
    }

    private static void a(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        anrReason.mTag = jSONObject.optString("mTag");
        if (JSONObject.NULL.toString().equals(anrReason.mTag)) {
            anrReason.mTag = "";
        }
        anrReason.mShortMsg = jSONObject.optString("mShortMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mShortMsg)) {
            anrReason.mShortMsg = "";
        }
        anrReason.mLongMsg = jSONObject.optString("mLongMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mLongMsg)) {
            anrReason.mLongMsg = "";
        }
    }

    private static JSONObject b(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = anrReason.mTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        String str2 = anrReason.mShortMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        String str3 = anrReason.mLongMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }
}
