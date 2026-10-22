package com.alibaba.sdk.android.oss.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutObjectResult extends OSSResult {
    private String eTag;
    private String serverCallbackReturnBody;

    public String getETag() {
        return this.eTag;
    }

    public String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setServerCallbackReturnBody(String str) {
        this.serverCallbackReturnBody = str;
    }
}
