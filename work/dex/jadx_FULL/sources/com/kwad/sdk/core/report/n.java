package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class n extends e {
    public String OQ;
    public String OR;
    public long OT;
    public String QY;
    public long aRP;
    public long aVB;
    public URLPackage aVC;
    public String aVD;
    public JSONArray aVE;
    public JSONArray aVF;
    public a aVG;
    public int aVH;
    public int aVI;
    public int aVJ;
    public int aVK;
    public String aVL;
    public int aVM;
    public int aVN;
    public String aVO;
    public JSONObject aVP;
    public JSONArray aVQ;
    public int aVR;
    public int aVS;
    public int aVT;
    public JSONArray aVV;
    public boolean aVW;
    public String aVX;
    public long aVs;
    public JSONObject aVt;
    public JSONObject aVu;
    public long aVv;
    public long aVw;
    public long aVx;
    public long aVy;
    public long aVz;
    public String aWA;
    public long aWa;
    public int aWb;
    public String aWc;
    public long aWd;
    public long aWe;
    public long aWf;
    public long aWg;
    public String aWh;
    public int aWi;
    public JSONArray aWj;
    public long aWk;
    public long aWl;
    public JSONArray aWm;
    public String aWn;
    public String aWo;
    public String aWp;
    public String aWq;
    public String aWr;
    public String aWt;
    public String aWu;
    public int aWv;
    public long aWy;
    public long aWz;
    public long actionType;
    public transient SceneImpl adScene;
    public String ajo;
    public long ajv;
    public long ajw;
    public long ajx;
    public long apv;
    public int aqR;
    public long authorId;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sdkApiVersion;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aVA = -1;
    public int aMA = 0;
    public long aVU = 0;
    public int aVY = 0;
    public int aVZ = -1;
    public int aWs = 0;
    public int aWw = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aWx = BuildConfig.VERSION_NAME;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aWB;
        public int aWC;

        public static a Ne() {
            a aVar = new a();
            aVar.aWB = b.aWB;
            aVar.aWC = b.aWC;
            return aVar;
        }
    }

    public static class b {
        public static int aWB;
        public static int aWC;
    }

    public n(long j) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aWA = "";
        this.actionType = j;
    }

    private void cJ(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.aVI = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.aVY = sVar.Af();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.Nj();
            try {
                this.OT = t.Nk();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            this.aVs = t.Nl();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aVv = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.helper.e.eL(adTemplate);
                String strEM = com.kwad.sdk.core.response.helper.e.eM(adTemplate);
                if (!TextUtils.isEmpty(strEM)) {
                    try {
                        this.aVt = new JSONObject(strEM);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                }
                String strEN = com.kwad.sdk.core.response.helper.e.eN(adTemplate);
                if (!TextUtils.isEmpty(strEN)) {
                    try {
                        this.aVu = new JSONObject(strEN);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.helper.e.eH(adTemplate);
                this.contentType = com.kwad.sdk.core.response.helper.e.eK(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.helper.e.eU(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
                    this.creativeId = adInfoEO.adBaseInfo.creativeId;
                    this.aVw = com.kwad.sdk.core.response.helper.a.N(adInfoEO) * 1000;
                    this.authorId = adInfoEO.advertiserInfo.userId;
                }
                this.aVH = adTemplate.mMediaPlayerType;
                this.aVJ = adTemplate.mIsLeftSlipStatus;
                this.aVK = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.helper.e.eV(adTemplate);
            }
            this.aVG = a.Ne();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e4);
        }
    }

    public final n Nc() {
        cJ(this.mAdTemplate);
        return this;
    }

    public final void Nd() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.aVR = jVar.wg() ? 1 : 0;
        this.aVS = jVar.wh();
        this.aVT = jVar.wi();
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aVI = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aVN = jSONObject.optInt("num");
        this.aVM = jSONObject.optInt("state");
        this.aVU = jSONObject.optLong("timeSpend");
        this.aWk = jSONObject.optLong("loadingDuration");
        this.aWl = jSONObject.optLong("loadingDurationLimt");
        this.aVZ = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        ac.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            ac.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.aVN;
        if (i2 > 0) {
            ac.putValue(jSONObject, "num", i2);
        }
        int i3 = this.aVM;
        if (i3 != 0) {
            ac.putValue(jSONObject, "state", i3);
        }
        long j = this.aVU;
        if (j > 0) {
            ac.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.aWk;
        if (j2 > 0) {
            ac.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.aWl;
        if (j3 > 0) {
            ac.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        ac.putValue(jSONObject, "playerTypeInfo", this.aVZ);
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.aWA)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aWA + '}';
    }

    public n(long j, @Nullable AdTemplate adTemplate) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aWA = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public n(long j, @Nullable AdTemplate adTemplate, String str) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aWA = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.QY = str;
    }

    public n(String str, String str2, boolean z) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.actionId = str;
        this.aWA = str2;
    }
}
