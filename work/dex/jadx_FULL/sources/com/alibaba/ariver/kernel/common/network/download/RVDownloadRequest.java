package com.alibaba.ariver.kernel.common.network.download;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVDownloadRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24262a;
    private String b;
    private String c;
    private boolean d;
    private JSONObject e;

    public String getDownloadDir() {
        return this.b;
    }

    public String getDownloadFileName() {
        return this.c;
    }

    public String getDownloadUrl() {
        return this.f24262a;
    }

    public JSONObject getHeaders() {
        return this.e;
    }

    public boolean isUrgentResource() {
        return this.d;
    }

    public void setDownloadDir(String str) {
        this.b = str;
    }

    public void setDownloadFileName(String str) {
        this.c = str;
    }

    public void setDownloadUrl(String str) {
        this.f24262a = str;
    }

    public void setHeaders(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void setIsUrgentResource(boolean z) {
        this.d = z;
    }
}
