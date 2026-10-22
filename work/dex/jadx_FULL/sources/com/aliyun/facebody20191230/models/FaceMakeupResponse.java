package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceMakeupResponse extends TeaModel {

    @NameInMap("body")
    public FaceMakeupResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static FaceMakeupResponse build(Map<String, ?> map) throws Exception {
        return (FaceMakeupResponse) TeaModel.build(map, new FaceMakeupResponse());
    }

    public FaceMakeupResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public FaceMakeupResponse setBody(FaceMakeupResponseBody faceMakeupResponseBody) {
        this.body = faceMakeupResponseBody;
        return this;
    }

    public FaceMakeupResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public FaceMakeupResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
