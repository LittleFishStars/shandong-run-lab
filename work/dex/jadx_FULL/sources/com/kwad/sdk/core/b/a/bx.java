package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bx implements com.kwad.sdk.core.d<Backtrace> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((Backtrace) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((Backtrace) bVar, jSONObject);
    }

    private static void a(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backtrace.mBacktraces = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mBacktraces");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                BackTraceElement backTraceElement = new BackTraceElement();
                backTraceElement.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                backtrace.mBacktraces.add(backTraceElement);
            }
        }
        backtrace.mFrame = jSONObject.optInt("mFrame");
    }

    private static JSONObject b(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "mBacktraces", backtrace.mBacktraces);
        int i = backtrace.mFrame;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mFrame", i);
        }
        return jSONObject;
    }
}
