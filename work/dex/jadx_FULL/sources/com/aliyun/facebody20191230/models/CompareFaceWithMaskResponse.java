package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceWithMaskResponse extends TeaModel {

    @NameInMap("body")
    public CompareFaceWithMaskResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static CompareFaceWithMaskResponse build(Map<String, ?> map) throws Exception {
        return (CompareFaceWithMaskResponse) TeaModel.build(map, new CompareFaceWithMaskResponse());
    }

    public CompareFaceWithMaskResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CompareFaceWithMaskResponse setBody(CompareFaceWithMaskResponseBody compareFaceWithMaskResponseBody) {
        this.body = compareFaceWithMaskResponseBody;
        return this;
    }

    public CompareFaceWithMaskResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public CompareFaceWithMaskResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
