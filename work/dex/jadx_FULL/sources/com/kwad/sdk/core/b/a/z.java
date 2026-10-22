package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class z implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    private static JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adInsertScreenInfo.cycleAggregateSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregateSwitch", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i = adInsertScreenInfo.cycleAggregateStyle;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregateStyle", i);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i2 = adInsertScreenInfo.autoCloseTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "autoCloseTime", i2);
        }
        int i3 = adInsertScreenInfo.retainWindowStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retainWindowStyle", i3);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i4 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retainWindowBasedAdShowCount", i4);
        }
        int i5 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retainWindowDailyShowCount", i5);
        }
        return jSONObject;
    }
}
