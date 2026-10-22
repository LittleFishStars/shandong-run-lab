package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HandPostureResponse extends TeaModel {

    @NameInMap("body")
    public HandPostureResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static HandPostureResponse build(Map<String, ?> map) throws Exception {
        return (HandPostureResponse) TeaModel.build(map, new HandPostureResponse());
    }

    public HandPostureResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public HandPostureResponse setBody(HandPostureResponseBody handPostureResponseBody) {
        this.body = handPostureResponseBody;
        return this;
    }

    public HandPostureResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public HandPostureResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
