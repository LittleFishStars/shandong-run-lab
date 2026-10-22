package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectCelebrityResponse extends TeaModel {

    @NameInMap("body")
    public DetectCelebrityResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectCelebrityResponse build(Map<String, ?> map) throws Exception {
        return (DetectCelebrityResponse) TeaModel.build(map, new DetectCelebrityResponse());
    }

    public DetectCelebrityResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectCelebrityResponse setBody(DetectCelebrityResponseBody detectCelebrityResponseBody) {
        this.body = detectCelebrityResponseBody;
        return this;
    }

    public DetectCelebrityResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectCelebrityResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
