package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianIntrusionResponse extends TeaModel {

    @NameInMap("body")
    public DetectPedestrianIntrusionResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectPedestrianIntrusionResponse build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianIntrusionResponse) TeaModel.build(map, new DetectPedestrianIntrusionResponse());
    }

    public DetectPedestrianIntrusionResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectPedestrianIntrusionResponse setBody(DetectPedestrianIntrusionResponseBody detectPedestrianIntrusionResponseBody) {
        this.body = detectPedestrianIntrusionResponseBody;
        return this;
    }

    public DetectPedestrianIntrusionResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectPedestrianIntrusionResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
