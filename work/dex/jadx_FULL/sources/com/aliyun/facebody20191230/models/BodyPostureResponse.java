package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BodyPostureResponse extends TeaModel {

    @NameInMap("body")
    public BodyPostureResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static BodyPostureResponse build(Map<String, ?> map) throws Exception {
        return (BodyPostureResponse) TeaModel.build(map, new BodyPostureResponse());
    }

    public BodyPostureResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public BodyPostureResponse setBody(BodyPostureResponseBody bodyPostureResponseBody) {
        this.body = bodyPostureResponseBody;
        return this;
    }

    public BodyPostureResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public BodyPostureResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
