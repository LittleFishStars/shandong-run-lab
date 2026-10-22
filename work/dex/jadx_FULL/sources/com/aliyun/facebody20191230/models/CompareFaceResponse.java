package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceResponse extends TeaModel {

    @NameInMap("body")
    public CompareFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static CompareFaceResponse build(Map<String, ?> map) throws Exception {
        return (CompareFaceResponse) TeaModel.build(map, new CompareFaceResponse());
    }

    public CompareFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CompareFaceResponse setBody(CompareFaceResponseBody compareFaceResponseBody) {
        this.body = compareFaceResponseBody;
        return this;
    }

    public CompareFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public CompareFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
