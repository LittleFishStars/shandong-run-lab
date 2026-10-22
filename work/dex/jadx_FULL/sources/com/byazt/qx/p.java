package com.byazt.qx;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 350})
public class p extends com.byazt.pct.n<JSONObject, JSONObject> {
    public Context c;
    public com.byazt.ete.ic tt;

    public p(Context context, com.byazt.ete.ic icVar) {
        this.c = context;
        this.tt = icVar;
    }

    public static void c(com.byazt.pct.nu nuVar, Context context, com.byazt.ete.ic icVar) {
        nuVar.c("openNewCommonWebPage", (com.byazt.pct.n<?, ?>) new p(context, icVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "";
            }
            TTDelegateActivity.uj(this.c, strOptString, strOptString2);
            return null;
        } catch (Throwable th) {
            com.byazt.nr.m.uj("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
