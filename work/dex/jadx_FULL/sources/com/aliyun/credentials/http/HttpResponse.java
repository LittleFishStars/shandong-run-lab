package com.aliyun.credentials.http;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpResponse extends HttpMessage {
    private int responseCode;
    private String responseMessage;

    public HttpResponse(String str) {
        super(str);
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }
}
