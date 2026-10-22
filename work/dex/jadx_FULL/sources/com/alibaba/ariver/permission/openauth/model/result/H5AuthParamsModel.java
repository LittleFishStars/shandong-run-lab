package com.alibaba.ariver.permission.openauth.model.result;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class H5AuthParamsModel {
    private String appId;
    private Map<String, String> params;

    public H5AuthParamsModel(H5AuthParamsModel h5AuthParamsModel) {
        if (h5AuthParamsModel == null) {
            return;
        }
        this.appId = h5AuthParamsModel.appId;
        this.params = h5AuthParamsModel.params;
    }

    public String getAppId() {
        return this.appId;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public H5AuthParamsModel() {
    }
}
