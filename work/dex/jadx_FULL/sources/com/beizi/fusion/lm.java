package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.s2s.S2SAdVerifyModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdResponseModel f27522a;
    private final String b;

    public lm(String str) {
        this.b = str;
    }

    public void a(Context context) {
        JSONObject jSONObjectC;
        if (TextUtils.isEmpty(this.b) || (jSONObjectC = mg.c(((id) dh.a().b(context)).a(this.b, "101,1001", id.a.STEP_BY_STEP, true))) == null) {
            return;
        }
        this.f27522a = new AdResponseModel(jSONObjectC);
    }

    public AdResponseModel b() {
        return this.f27522a;
    }

    public String c() {
        S2SAdVerifyModel s2SAdVerify;
        AdResponseModel adResponseModel = this.f27522a;
        return (adResponseModel == null || (s2SAdVerify = adResponseModel.getS2SAdVerify()) == null) ? "" : s2SAdVerify.getS2sReqId();
    }

    public String a() {
        S2SAdVerifyModel s2SAdVerify;
        AdResponseModel adResponseModel = this.f27522a;
        return (adResponseModel == null || (s2SAdVerify = adResponseModel.getS2SAdVerify()) == null) ? "" : s2SAdVerify.getS2sSpaceId();
    }
}
