package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectBodyCountResponse extends TeaModel {

    @NameInMap("body")
    public DetectBodyCountResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectBodyCountResponse build(Map<String, ?> map) throws Exception {
        return (DetectBodyCountResponse) TeaModel.build(map, new DetectBodyCountResponse());
    }

    public DetectBodyCountResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectBodyCountResponse setBody(DetectBodyCountResponseBody detectBodyCountResponseBody) {
        this.body = detectBodyCountResponseBody;
        return this;
    }

    public DetectBodyCountResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectBodyCountResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
