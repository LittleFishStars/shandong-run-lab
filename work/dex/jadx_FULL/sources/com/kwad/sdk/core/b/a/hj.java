package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.JavaBackTraceElement;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hj implements com.kwad.sdk.core.d<JavaBackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((JavaBackTraceElement) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((JavaBackTraceElement) bVar, jSONObject);
    }

    private static void a(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        javaBackTraceElement.mDeclaringClass = jSONObject.optString("mDeclaringClass");
        if (JSONObject.NULL.toString().equals(javaBackTraceElement.mDeclaringClass)) {
            javaBackTraceElement.mDeclaringClass = "";
        }
        javaBackTraceElement.mIsTitle = jSONObject.optBoolean("mIsTitle");
        javaBackTraceElement.mIsCausedBy = jSONObject.optBoolean("mIsCausedBy");
        javaBackTraceElement.mIsNative = jSONObject.optBoolean("mIsNative");
    }

    private static JSONObject b(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = javaBackTraceElement.mDeclaringClass;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mDeclaringClass", javaBackTraceElement.mDeclaringClass);
        }
        boolean z = javaBackTraceElement.mIsTitle;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsTitle", z);
        }
        boolean z2 = javaBackTraceElement.mIsCausedBy;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsCausedBy", z2);
        }
        boolean z3 = javaBackTraceElement.mIsNative;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsNative", z3);
        }
        return jSONObject;
    }
}
