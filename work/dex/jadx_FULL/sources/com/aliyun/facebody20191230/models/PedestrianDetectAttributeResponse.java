package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PedestrianDetectAttributeResponse extends TeaModel {

    @NameInMap("body")
    public PedestrianDetectAttributeResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static PedestrianDetectAttributeResponse build(Map<String, ?> map) throws Exception {
        return (PedestrianDetectAttributeResponse) TeaModel.build(map, new PedestrianDetectAttributeResponse());
    }

    public PedestrianDetectAttributeResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public PedestrianDetectAttributeResponse setBody(PedestrianDetectAttributeResponseBody pedestrianDetectAttributeResponseBody) {
        this.body = pedestrianDetectAttributeResponseBody;
        return this;
    }

    public PedestrianDetectAttributeResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public PedestrianDetectAttributeResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
