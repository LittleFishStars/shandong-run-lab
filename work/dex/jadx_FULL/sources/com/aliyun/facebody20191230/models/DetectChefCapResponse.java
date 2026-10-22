package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectChefCapResponse extends TeaModel {

    @NameInMap("body")
    public DetectChefCapResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectChefCapResponse build(Map<String, ?> map) throws Exception {
        return (DetectChefCapResponse) TeaModel.build(map, new DetectChefCapResponse());
    }

    public DetectChefCapResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectChefCapResponse setBody(DetectChefCapResponseBody detectChefCapResponseBody) {
        this.body = detectChefCapResponseBody;
        return this;
    }

    public DetectChefCapResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectChefCapResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
