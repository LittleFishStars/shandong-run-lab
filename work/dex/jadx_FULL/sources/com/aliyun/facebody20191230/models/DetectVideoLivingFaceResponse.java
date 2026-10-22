package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectVideoLivingFaceResponse extends TeaModel {

    @NameInMap("body")
    public DetectVideoLivingFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectVideoLivingFaceResponse build(Map<String, ?> map) throws Exception {
        return (DetectVideoLivingFaceResponse) TeaModel.build(map, new DetectVideoLivingFaceResponse());
    }

    public DetectVideoLivingFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectVideoLivingFaceResponse setBody(DetectVideoLivingFaceResponseBody detectVideoLivingFaceResponseBody) {
        this.body = detectVideoLivingFaceResponseBody;
        return this;
    }

    public DetectVideoLivingFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectVideoLivingFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
