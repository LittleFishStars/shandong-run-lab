package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.helper.f;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "llsid", this.llsid);
        ac.putValue(jSONObject, "extra", this.extra);
        ac.putValue(jSONObject, "result", this.result);
        ac.putValue(jSONObject, "hasAd", this.hasAd);
        ac.putValue(jSONObject, "errorMsg", this.errorMsg);
        ac.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        ac.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString("errorMsg");
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String strOptString = jSONObject.optString("extra");
        if (!br.isNullString(strOptString)) {
            this.extra = ((e) d.f(e.class)).getResponseData(strOptString);
        }
        h hVar = (h) d.f(h.class);
        if (hVar != null) {
            hVar.av(jSONObject.optString("egid"));
            hVar.F(jSONObject.optLong("gidExpireTimeMs"));
        }
        String strOptString2 = jSONObject.optString("cookie");
        this.cookie = strOptString2;
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        f.Nz().fn(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
