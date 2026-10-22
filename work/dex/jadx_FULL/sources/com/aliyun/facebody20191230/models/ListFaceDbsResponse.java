package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceDbsResponse extends TeaModel {

    @NameInMap("body")
    public ListFaceDbsResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static ListFaceDbsResponse build(Map<String, ?> map) throws Exception {
        return (ListFaceDbsResponse) TeaModel.build(map, new ListFaceDbsResponse());
    }

    public ListFaceDbsResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListFaceDbsResponse setBody(ListFaceDbsResponseBody listFaceDbsResponseBody) {
        this.body = listFaceDbsResponseBody;
        return this;
    }

    public ListFaceDbsResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public ListFaceDbsResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
