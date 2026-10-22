package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceFilterResponse extends TeaModel {

    @NameInMap("body")
    public FaceFilterResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static FaceFilterResponse build(Map<String, ?> map) throws Exception {
        return (FaceFilterResponse) TeaModel.build(map, new FaceFilterResponse());
    }

    public FaceFilterResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public FaceFilterResponse setBody(FaceFilterResponseBody faceFilterResponseBody) {
        this.body = faceFilterResponseBody;
        return this;
    }

    public FaceFilterResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public FaceFilterResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
