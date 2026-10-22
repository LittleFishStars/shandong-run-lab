package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class AdCouponReceiveParam extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 3401922564904240855L;
    public String ext = "";
    public int flowType;
    public String receiveFailToast;
    public String receiveToast;
    public String sign;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        ac.putValue(jSONObject, "receiveToast", this.receiveToast);
        ac.putValue(jSONObject, UserTrackConstant.SIGN, this.sign);
        ac.putValue(jSONObject, LoginConstants.EXT, this.ext);
        ac.putValue(jSONObject, "receiveFailToast", this.receiveFailToast);
        ac.putValue(jSONObject, "flowType", this.flowType);
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.sign) || this.flowType == 0;
    }
}
