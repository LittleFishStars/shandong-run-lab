package com.aliyun.tea.okhttp;

import com.aliyun.tea.TeaRequest;
import java.net.URL;
import java.util.Map;
import okhttp3.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OkRequestBuilder {
    private Request.Builder builder;

    public OkRequestBuilder(Request.Builder builder) {
        this.builder = builder;
    }

    public Request buildRequest(TeaRequest teaRequest) {
        String upperCase = teaRequest.method.toUpperCase();
        upperCase.hashCode();
        switch (upperCase) {
            case "PUT":
                this.builder.put(new OkRequestBody(teaRequest));
                break;
            case "HEAD":
                this.builder.head();
                break;
            case "POST":
                this.builder.post(new OkRequestBody(teaRequest));
                break;
            case "PATCH":
                this.builder.patch(new OkRequestBody(teaRequest));
                break;
            case "DELETE":
                this.builder.delete(new OkRequestBody(teaRequest));
                break;
            default:
                this.builder.get();
                break;
        }
        return this.builder.build();
    }

    public OkRequestBuilder header(Map<String, String> map) {
        for (String str : map.keySet()) {
            this.builder.header(str, map.get(str));
        }
        return this;
    }

    public OkRequestBuilder url(URL url) {
        this.builder.url(url);
        return this;
    }
}
