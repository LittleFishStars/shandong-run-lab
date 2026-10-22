package com.alibaba.triver.kit.api.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.R;
import com.alibaba.triver.kit.api.utils.InternationalUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum TriverError {
    EMPTY_REQUEST_APP("AI_EMPTY_REQUEST_APP", R.string.triver_appinfo_empty_request_app),
    SYSTEM_ERROR("AC_SYSTEM_ERROR", R.string.triver_system_error),
    INVALID_APP_URL("AC_INVALID_APP_URL", R.string.triver_appinfo_invalid_app_url),
    BAD_APP_CONFIG("AC_BAD_APP_CONFIG", R.string.triver_appinfo_bad_app_config),
    PARAM_ERROR("AC_PARAM_ERROR", R.string.triver_appinfo_param_error),
    INVALID_OPERATION("INVALID_OPERATION", R.string.triver_appinfo_invalid_operation),
    JSC_INIT_TIMEOUT("RT_JSC_INIT_TIMEOUT", R.string.triver_appinfo_jsc_init_timeout),
    LAUNCHER_COMMON_ERROR("AC_LAUNCHER_COMMON_ERROR", R.string.triver_appinfo_launcher_common_error);

    public String errorCode;
    public int errorMsgResId;

    TriverError(String str, int i) {
        this.errorCode = str;
        this.errorMsgResId = i;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", (Object) this.errorCode);
        jSONObject.put("errorMsg", (Object) InternationalUtil.getString(this.errorMsgResId));
        return jSONObject;
    }
}
