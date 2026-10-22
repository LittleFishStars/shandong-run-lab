package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.br;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class am implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private int aqP = 0;
    private a aqQ;

    public interface a {
        void onAdShow();
    }

    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String PC;
        private String QY;
        private int actionType;
        private AdTemplate adTemplate;
        private int aqR;

        public final int getActionType() {
            return this.actionType;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.aqR = jSONObject.optInt("refreshType");
            this.QY = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
            this.PC = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.helper.c.a(com.kwad.components.core.offline.a.f.a.a.bp(jSONObject.optInt("adCacheId")), this.PC);
            }
        }

        public final String pc() {
            return this.PC;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.ac.putValue(jSONObject, AssistPushConsts.MSG_TYPE_PAYLOAD, this.QY);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "refreshType", this.aqR);
            com.kwad.sdk.utils.ac.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", this.PC);
            return jSONObject;
        }

        public final String yv() {
            return this.QY;
        }
    }

    public am(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.apJ.dU(bVar.PC);
    }

    public final void a(a aVar) {
        this.aqQ = aVar;
    }

    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.t.b.wF().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.b(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b bVarEc = new com.kwad.sdk.core.adlog.c.b().ec(bVar.QY);
            a aVar = this.aqQ;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                bVarEc.eg(this.aqP);
                b(true, bVar.adTemplate, null, bVarEc);
                return;
            }
            if (br.isNullString(bVar.pc())) {
                b(true, this.apJ.getAdTemplate(), null, bVarEc);
                return;
            }
            if (this.apJ.Pu() != null) {
                for (AdTemplate adTemplate : this.apJ.Pu()) {
                    if (br.isEquals(bVar.pc(), String.valueOf(com.kwad.sdk.core.response.helper.e.eY(adTemplate)))) {
                        b(false, adTemplate, null, bVarEc);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (bVar.actionType == 2) {
            com.kwad.sdk.widget.g gVar = this.apJ.bbV;
            com.kwad.sdk.core.adlog.c.b bVarEc2 = new com.kwad.sdk.core.adlog.c.b().eg(this.aqP).ec(bVar.QY);
            if (gVar != null) {
                bVarEc2.f(gVar.getTouchCoords());
            }
            a(bVarEc2);
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVarEc2, this.apJ.mReportExtData);
            return;
        }
        if (bVar.actionType == 12006) {
            com.kwad.components.core.p.a.vL().l(c(bVar), bVar.aqR, this.aqP);
            return;
        }
        if (bVar.actionType == 140) {
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.apJ.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ec(bVar.QY));
        } else if (bVar.actionType == 141) {
            com.kwad.sdk.core.adlog.c.e(c(bVar), this.apJ.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ec(bVar.QY));
        } else {
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.apJ.mReportExtData, bVar.QY);
            com.kwad.components.core.webview.tachikoma.e.a.zA().bR(bVar.QY);
        }
    }
}
