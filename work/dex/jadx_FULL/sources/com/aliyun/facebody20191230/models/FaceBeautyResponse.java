package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceBeautyResponse extends TeaModel {

    @NameInMap("body")
    public FaceBeautyResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static FaceBeautyResponse build(Map<String, ?> map) throws Exception {
        return (FaceBeautyResponse) TeaModel.build(map, new FaceBeautyResponse());
    }

    public FaceBeautyResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public FaceBeautyResponse setBody(FaceBeautyResponseBody faceBeautyResponseBody) {
        this.body = faceBeautyResponseBody;
        return this;
    }

    public FaceBeautyResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public FaceBeautyResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
