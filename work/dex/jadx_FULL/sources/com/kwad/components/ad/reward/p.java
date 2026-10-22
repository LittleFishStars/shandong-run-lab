package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.br;
import com.zj.adlib.c49;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class p {

    public static class a {
        private String errorMsg;
        private boolean un;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = c49.f40900a;
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.un = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.un = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.un;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String strBY = com.kwad.sdk.core.response.helper.a.bY(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + strBY);
        if (br.isNullString(strBY)) {
            return;
        }
        com.kwad.sdk.utils.i.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            private void L(String str) {
                com.kwad.components.core.p.a.vL().h(adTemplate, 1, str);
            }

            private void hK() {
                com.kwad.components.core.p.a.vL().h(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c cVarDoGet = com.kwad.sdk.h.EG().doGet(strBY, null);
                    if (cVarDoGet == null) {
                        L("Network Error: url invalid");
                        return;
                    }
                    if (cVarDoGet.code != 200) {
                        L("Network Error: " + cVarDoGet.aSY);
                    } else {
                        a aVar = new a(cVarDoGet.aSY);
                        if (aVar.isValid()) {
                            hK();
                        } else {
                            L(aVar.errorMsg);
                        }
                    }
                } catch (Throwable th) {
                    L("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
