package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.el.SSWebView;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 517})
public class l extends com.byazt.pct.n<JSONObject, JSONObject> {
    public SSWebView c;
    public String tt;
    public com.byazt.omf.d ve;

    public l(SSWebView sSWebView, String str, com.byazt.omf.d dVar) {
        this.c = sSWebView;
        this.tt = str;
        this.ve = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, SSWebView sSWebView, com.byazt.omf.d dVar) {
        nuVar.c("closeWebview", (com.byazt.pct.n<?, ?>) new l(sSWebView, "closeWebview", dVar));
        nuVar.c("makeVisible", (com.byazt.pct.n<?, ?>) new l(sSWebView, "makeVisible", dVar));
        nuVar.c("getCurrentVisibleState", (com.byazt.pct.n<?, ?>) new l(sSWebView, "getCurrentVisibleState", dVar));
        nuVar.c("changeSize", (com.byazt.pct.n<?, ?>) new l(sSWebView, "changeSize", dVar));
        nuVar.c("changeFrame", (com.byazt.pct.n<?, ?>) new l(sSWebView, "changeFrame", dVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        JSONObject jSONObject2 = new JSONObject();
        String str = this.tt;
        str.hashCode();
        switch (str) {
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.byazt.omf.d dVar = this.ve;
                    if (dVar != null) {
                        dVar.c(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(SQLiteMTAHelper.TABLE_POINT);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                } else {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                }
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() != 2) {
                    iOptInt3 = Integer.MAX_VALUE;
                } else {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                }
                com.byazt.omf.d dVar2 = this.ve;
                if (dVar2 != null) {
                    dVar2.c(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.byazt.omf.zb.tt(this.c, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.qx.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.c.setVisibility(8);
                    }
                });
                com.byazt.sy.i iVarVe = this.ve.ve();
                if (iVarVe != null) {
                    iVarVe.tt();
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.c != null) {
                    jSONObject2.put("success", true);
                    com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.qx.l.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (l.this.c != null) {
                                l.this.c.setVisibility(0);
                            }
                            com.byazt.sy.i iVarVe2 = l.this.ve.ve();
                            if (iVarVe2 != null) {
                                iVarVe2.L_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
