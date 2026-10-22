package com.byazt.whk;

import androidx.annotation.NonNull;
import com.hzchengdun.securityguard.SecExceptionCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 91})
public class sp {
    public JSONObject c;

    public sp(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public int c() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.c;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }
}
