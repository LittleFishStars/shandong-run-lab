package com.alibaba.ariver.permission.openauth.model.result;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class JsApiInvokeResultModel {
    private Map<String, String> extInfo;
    private String response;

    public JsApiInvokeResultModel(JsApiInvokeResultModel jsApiInvokeResultModel) {
        if (jsApiInvokeResultModel == null) {
            return;
        }
        this.response = jsApiInvokeResultModel.response;
        this.extInfo = jsApiInvokeResultModel.extInfo;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public String getResponse() {
        return this.response;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public JsApiInvokeResultModel() {
    }
}
