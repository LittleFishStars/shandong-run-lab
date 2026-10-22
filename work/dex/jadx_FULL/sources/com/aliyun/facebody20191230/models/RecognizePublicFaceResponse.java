package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizePublicFaceResponse extends TeaModel {

    @NameInMap("body")
    public RecognizePublicFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RecognizePublicFaceResponse build(Map<String, ?> map) throws Exception {
        return (RecognizePublicFaceResponse) TeaModel.build(map, new RecognizePublicFaceResponse());
    }

    public RecognizePublicFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RecognizePublicFaceResponse setBody(RecognizePublicFaceResponseBody recognizePublicFaceResponseBody) {
        this.body = recognizePublicFaceResponseBody;
        return this;
    }

    public RecognizePublicFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RecognizePublicFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
