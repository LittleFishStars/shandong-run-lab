package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianResponse extends TeaModel {

    @NameInMap("body")
    public DetectPedestrianResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectPedestrianResponse build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianResponse) TeaModel.build(map, new DetectPedestrianResponse());
    }

    public DetectPedestrianResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectPedestrianResponse setBody(DetectPedestrianResponseBody detectPedestrianResponseBody) {
        this.body = detectPedestrianResponseBody;
        return this;
    }

    public DetectPedestrianResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectPedestrianResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
