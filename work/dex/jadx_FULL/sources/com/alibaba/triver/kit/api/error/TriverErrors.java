package com.alibaba.triver.kit.api.error;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.R;
import com.alibaba.triver.kit.api.utils.InternationalUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum TriverErrors {
    AI_EMPTY_REQUEST_APP("AI_EMPTY_REQUEST_APP", R.string.triver_appinfo_empty_request_app),
    AI_SYSTEM_ERROR("AI_SYSTEM_ERROR", R.string.triver_system_error),
    AI_NO_APP_INFO("AI_NO_APP_INFO", R.string.triver_ai_no_app_info),
    AI_RPC_EXCEPTION("AI_RPC_EXCEPTION", R.string.triver_ai_rpc_error),
    AI_TIMEOUT("AI_TIMEOUT", R.string.triver_ai_timeout),
    PKG_REQ_TIMEOUT("PKG_REQ_TIMEOUT", R.string.triver_pkg_req_timeout),
    PKG_REQ_UNZIP_EXCEPTION("PKG_REQ_UNZIP_EXCEPTION", R.string.triver_pkg_unzip_error),
    PKG_REQ_DOWNLOAD_ERROR("PKG_REQ_DOWNLOAD_ERROR", R.string.triver_pkg_req_error),
    PKG_REQ_PLUGIN_UNZIP_EXCEPTION("PKG_REQ_PLUGIN_UNZIP_EXCEPTION", R.string.triver_pkg_plugin_unzip_error),
    PKG_REQ_PLUGIN_DOWNLOAD_ERROR("PKG_REQ_PLUGIN_DOWNLOAD_ERROR", R.string.triver_pkg_plugin_req_error),
    APPX_CHECK_FAILED("APPX_CHECK_FAILED", R.string.triver_appx_check_fail),
    CTN_LAUNCH_NO_URL("CTN_LAUNCH_NO_URL", R.string.triver_ctn_launch_no_url),
    CTN_ENGINE_INIT_FAIL("CTN_ENGINE_INIT_FAIL", R.string.triver_ctn_engine_init_fail);

    private static final String APP_INFO_PREFIX = "AI_CODE_";
    public static final String ENGINE_INIT_FAIL_CODE = "0";
    private static final String PKG_REQ_PLUGIN_PREFIX = "PKG_REQ_PLUGIN_ERROR_";
    private static final String PKG_REQ_PREFIX = "PKG_REQ_ERROR_";
    public static final String SPLIT = "|";
    public static final String STAGE_PLUGIN = "Plugin";
    private static final String TAG = "TriverErrors";
    public String errorCode;
    public int errorMsgResId;

    TriverErrors(String str, int i) {
        this.errorCode = str;
        this.errorMsgResId = i;
    }

    public static boolean isMtopErrorCodeMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith(str2)) {
            if (!str.startsWith(APP_INFO_PREFIX + str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpdateErrorCode(String str) {
        return TextUtils.equals("AI_CODE_2111", str) || TextUtils.equals("2111", str);
    }

    public static ErrorWrapper mapError(@Nullable String str, String str2, String str3) {
        if (TextUtils.equals(str, StepType.UPDATE.name())) {
            TriverErrors triverErrors = AI_SYSTEM_ERROR;
            if (TextUtils.equals(str2, triverErrors.errorCode)) {
                return ErrorWrapper.convertFrom(triverErrors);
            }
            TriverErrors triverErrors2 = AI_EMPTY_REQUEST_APP;
            if (TextUtils.equals(str2, triverErrors2.errorCode)) {
                return ErrorWrapper.convertFrom(triverErrors2);
            }
            if ("1".equals(str2)) {
                return ErrorWrapper.convertFrom(AI_NO_APP_INFO);
            }
            if ("2".equals(str2)) {
                return ErrorWrapper.convertFrom(AI_RPC_EXCEPTION);
            }
            if ("3".equals(str2)) {
                return ErrorWrapper.convertFrom(AI_TIMEOUT);
            }
            return ErrorWrapper.convertFrom(APP_INFO_PREFIX + str2, str3).setNeedShowErrorMsg(true);
        }
        StepType stepType = StepType.OFFLINE;
        if (!TextUtils.equals(str, stepType.name())) {
            if (TextUtils.equals(str, stepType.name() + "Plugin")) {
                if ("5".equals(str2)) {
                    return ErrorWrapper.convertFrom(PKG_REQ_PLUGIN_UNZIP_EXCEPTION);
                }
                if ("4".equals(str2)) {
                    try {
                        return ErrorWrapper.convertFrom(PKG_REQ_PLUGIN_PREFIX + str3.substring(0, str3.indexOf("|")), str3).setNeedShowErrorMsg(true);
                    } catch (Exception e) {
                        RVLogger.e(TAG, "plugin: " + e);
                        return ErrorWrapper.convertFrom(PKG_REQ_PLUGIN_DOWNLOAD_ERROR.errorCode, str3);
                    }
                }
            } else if (TextUtils.equals(str, StepType.START.name())) {
                if ("6".equals(str2)) {
                    return ErrorWrapper.convertFrom(CTN_LAUNCH_NO_URL.errorCode, str3);
                }
            } else {
                if ("7".equals(str2)) {
                    return ErrorWrapper.convertFrom(APPX_CHECK_FAILED.errorCode, str3);
                }
                if ("0".equals(str2)) {
                    return ErrorWrapper.convertFrom(CTN_ENGINE_INIT_FAIL);
                }
            }
        } else {
            if ("3".equals(str2)) {
                return ErrorWrapper.convertFrom(PKG_REQ_TIMEOUT);
            }
            if ("5".equals(str2)) {
                return ErrorWrapper.convertFrom(PKG_REQ_UNZIP_EXCEPTION);
            }
            if ("4".equals(str2)) {
                try {
                    return ErrorWrapper.convertFrom(PKG_REQ_PREFIX + str3.substring(0, str3.indexOf("|")), str3).setNeedShowErrorMsg(true);
                } catch (Exception e2) {
                    RVLogger.e(TAG, e2);
                    return ErrorWrapper.convertFrom(PKG_REQ_DOWNLOAD_ERROR.errorCode, str3);
                }
            }
        }
        return ErrorWrapper.convertFrom(str2, str3);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", (Object) this.errorCode);
        jSONObject.put("errorMsg", (Object) InternationalUtil.getString(this.errorMsgResId));
        return jSONObject;
    }

    public static class ErrorWrapper {
        public String errorCode;
        public String errorMsg;
        public boolean needShowErrorMsg = false;

        private ErrorWrapper() {
        }

        public static ErrorWrapper convertFrom(TriverErrors triverErrors) {
            if (triverErrors == null) {
                return null;
            }
            ErrorWrapper errorWrapper = new ErrorWrapper();
            errorWrapper.errorCode = triverErrors.errorCode;
            errorWrapper.errorMsg = InternationalUtil.getString(triverErrors.errorMsgResId);
            return errorWrapper;
        }

        public ErrorWrapper setNeedShowErrorMsg(boolean z) {
            this.needShowErrorMsg = z;
            return this;
        }

        public static ErrorWrapper convertFrom(String str, String str2) {
            ErrorWrapper errorWrapper = new ErrorWrapper();
            errorWrapper.errorCode = str;
            errorWrapper.errorMsg = str2;
            return errorWrapper;
        }
    }
}
