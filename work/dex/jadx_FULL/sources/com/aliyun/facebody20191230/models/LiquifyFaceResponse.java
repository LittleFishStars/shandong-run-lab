package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LiquifyFaceResponse extends TeaModel {

    @NameInMap("body")
    public LiquifyFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static LiquifyFaceResponse build(Map<String, ?> map) throws Exception {
        return (LiquifyFaceResponse) TeaModel.build(map, new LiquifyFaceResponse());
    }

    public LiquifyFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public LiquifyFaceResponse setBody(LiquifyFaceResponseBody liquifyFaceResponseBody) {
        this.body = liquifyFaceResponseBody;
        return this;
    }

    public LiquifyFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public LiquifyFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
