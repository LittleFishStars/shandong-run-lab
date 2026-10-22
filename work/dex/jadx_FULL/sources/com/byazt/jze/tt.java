package com.byazt.jze;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.dna.qp;
import com.byazt.it.n;
import com.byazt.nr.m;
import com.byazt.vif.uj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 250, 13})
public class tt {
    public static volatile Handler c;

    public static void c(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("url");
                String strOptString2 = jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    c(strOptString2, strOptString, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n ve(String str) {
        return uj.tt(str, "feature_data");
    }

    private static void c(final String str, String str2, final String str3) {
        com.byazt.va.c cVarN;
        if (c(str, str3) || (cVarN = com.byazt.hy.n.c().tt().n()) == null) {
            return;
        }
        cVarN.c(str2);
        cVarN.c(new com.byazt.mh.c() { // from class: com.byazt.jze.tt.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar != null) {
                    try {
                        if (ttVar.i()) {
                            String str4 = new String(ttVar.sl());
                            tt.ve(str3).put(str, str4);
                            com.byazt.feb.tt.c().c(new JSONObject(str4).optJSONArray("rules"));
                        }
                    } catch (Throwable th) {
                        m.ve("Tmee_TTFeatureUtils", "download rule error, md5:" + str, th);
                    }
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                m.uj("Tmee_TTFeatureUtils", "download rule failed error");
            }
        });
    }

    private static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str3 = ve(str2).get(str, "");
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            com.byazt.feb.tt.c().c(new JSONObject(str3).optJSONArray("rules"));
            return true;
        } catch (Throwable th) {
            m.uj("Tmee_TTFeatureUtils", "get feature rule error :" + th.toString());
            return false;
        }
    }

    public static Handler c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = ((qp) com.byazt.ut.uj.getService("thread_service")).obtainHandler("tt_csj_feature_handler");
                }
            }
        }
        return c;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (str.startsWith("${") && str.endsWith("}")) ? str.substring(2, str.length() - 1) : str;
    }
}
