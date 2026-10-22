package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectFaceResponse extends TeaModel {

    @NameInMap("body")
    public DetectFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectFaceResponse build(Map<String, ?> map) throws Exception {
        return (DetectFaceResponse) TeaModel.build(map, new DetectFaceResponse());
    }

    public DetectFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectFaceResponse setBody(DetectFaceResponseBody detectFaceResponseBody) {
        this.body = detectFaceResponseBody;
        return this;
    }

    public DetectFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
