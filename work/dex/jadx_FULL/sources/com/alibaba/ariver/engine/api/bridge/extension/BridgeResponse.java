package com.alibaba.ariver.engine.api.bridge.extension;

import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeResponse {
    public static final int ERROR_CODE_FORBIDDEN_ERROR = 4;
    public static final int ERROR_CODE_INVALID_PARAM = 2;
    public static final int ERROR_CODE_JAVA_EXCEPTION = 6;
    public static final int ERROR_CODE_NATIVE_NODE_NULL = 30;
    public static final int ERROR_CODE_NOT_FOUND = 1;
    public static final int ERROR_CODE_SILENT_DENY = 2002;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_SYSTEM_ERROR = 5;
    public static final int ERROR_CODE_TIMEOUT = 9;
    public static final int ERROR_CODE_UNAUTHORIZED_USERINFO = 10;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 3;
    public static final int ERROR_CODE_USER_NOT_GRANT = 2001;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24049a = "success";
    private JSONObject b;
    public static BridgeResponse SUCCESS = new BridgeResponse(null) { // from class: com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.1
        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse
        public JSONObject get() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            return jSONObject;
        }
    };
    public static BridgeResponse NOT_FOUND = new Error(1, "not implemented!");
    public static BridgeResponse INVALID_PARAM = new Error(2, "invalid parameter!");
    public static BridgeResponse UNKNOWN_ERROR = new Error(3, "unknown error!");
    public static BridgeResponse FORBIDDEN_ERROR = new Error(4, "forbidden error!");
    public static BridgeResponse NATIVE_NODE_NULL = new Error(10, "native node is null");

    public static class Error extends BridgeResponse {
        int errorCode;
        String errorMessage;

        public Error(int i, String str) {
            super(null);
            this.errorCode = i;
            this.errorMessage = str;
        }

        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse
        public JSONObject get() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) Integer.valueOf(this.errorCode));
            jSONObject.put("message", (Object) this.errorMessage);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) this.errorMessage);
            return jSONObject;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public static class NamedValue extends BridgeResponse {
        JSONObject response;

        public NamedValue(String str, Object obj) {
            super(null);
            JSONObject jSONObject = new JSONObject();
            this.response = jSONObject;
            jSONObject.put(str, obj);
        }

        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse
        public JSONObject get() {
            return this.response;
        }
    }

    public BridgeResponse() {
    }

    public static Error newError(int i, String str) {
        return new Error(i, str);
    }

    public static NamedValue newValue(String str, Object obj) {
        return new NamedValue(str, obj);
    }

    public JSONObject get() {
        return this.b;
    }

    public BridgeResponse(JSONObject jSONObject) {
        this.b = jSONObject;
    }
}
