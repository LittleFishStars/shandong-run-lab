package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectInfraredLivingFaceResponse extends TeaModel {

    @NameInMap("body")
    public DetectInfraredLivingFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DetectInfraredLivingFaceResponse build(Map<String, ?> map) throws Exception {
        return (DetectInfraredLivingFaceResponse) TeaModel.build(map, new DetectInfraredLivingFaceResponse());
    }

    public DetectInfraredLivingFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DetectInfraredLivingFaceResponse setBody(DetectInfraredLivingFaceResponseBody detectInfraredLivingFaceResponseBody) {
        this.body = detectInfraredLivingFaceResponseBody;
        return this;
    }

    public DetectInfraredLivingFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DetectInfraredLivingFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
