package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.t;
import com.zj.adlib.xh9;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean ajD = true;
    ImpInfo abn;
    private int ajB;
    private boolean ajC;

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            gVar.thirdAge = i;
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            gVar.thirdGender = i2;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (ajD && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) ab.callMethodOrThrow(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                ajD = false;
            }
        }
        return "";
    }

    public final void bS(int i) {
        this.ajB = i;
    }

    public final int getAdNum() {
        return this.abn.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.abn;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        if (com.kwad.components.ad.f.a.pd.booleanValue()) {
            try {
                if (((com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class)) != null) {
                    return com.kwad.sdk.i.Fb();
                }
            } catch (Throwable unused) {
            }
        }
        return com.kwad.sdk.i.EK();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        t.ct(true);
        b.vQ().vR();
        super.onCreate();
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.abn, aVar.ajM, aVar.ajN, aVar.ajP);
        this.ajB = aVar.ajO ? 1 : 0;
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.ajC = false;
        this.abn = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.Np(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        ac.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i = this.ajB;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String strID = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)).ID() : "";
        if (!TextUtils.isEmpty(strID)) {
            putBody("universeDebugParam", strID);
        }
        String strD = d(impInfo);
        if (!TextUtils.isEmpty(strD)) {
            putBody("sdkDebugReqInfo", strD);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", ai.Vo());
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.abn.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g gVarNw = com.kwad.sdk.core.request.model.g.Nw();
        try {
            String strF = ai.f(ServiceProvider.getContext(), false);
            if (!TextUtils.isEmpty(strF)) {
                InnerEcLocalLoginInfo innerEcLocalLoginInfo = new InnerEcLocalLoginInfo();
                innerEcLocalLoginInfo.parseJson(new JSONObject(strF));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!TextUtils.isEmpty(innerEcLocalLoginInfo.serviceToken) && jCurrentTimeMillis < innerEcLocalLoginInfo.expire) {
                    gVarNw.fk(innerEcLocalLoginInfo.serviceToken);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (rewardCallbackExtraByKey != null) {
            gVarNw.fi(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(gVarNw, adLabelFromAdScene);
        }
        putBody("userInfo", gVarNw);
        if (com.kwad.components.ad.f.a.pd.booleanValue()) {
            try {
                com.kwad.sdk.components.a aVar = (com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
                if (aVar != null) {
                    putBody("adBrowseParam", aVar.IC());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            ac.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            ac.putValue(jSONObject2, PostListActivity.z, adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            ac.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            ac.putValue(jSONObject2, xh9.WEBSITE_PARAMS_CHANNEL, adLabelImpl.channel);
        }
        ac.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
