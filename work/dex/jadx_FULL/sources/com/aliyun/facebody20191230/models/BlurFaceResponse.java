package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BlurFaceResponse extends TeaModel {

    @NameInMap("body")
    public BlurFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static BlurFaceResponse build(Map<String, ?> map) throws Exception {
        return (BlurFaceResponse) TeaModel.build(map, new BlurFaceResponse());
    }

    public BlurFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public BlurFaceResponse setBody(BlurFaceResponseBody blurFaceResponseBody) {
        this.body = blurFaceResponseBody;
        return this;
    }

    public BlurFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public BlurFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
