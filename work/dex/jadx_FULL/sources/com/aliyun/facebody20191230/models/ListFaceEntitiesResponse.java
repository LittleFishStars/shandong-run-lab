package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceEntitiesResponse extends TeaModel {

    @NameInMap("body")
    public ListFaceEntitiesResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static ListFaceEntitiesResponse build(Map<String, ?> map) throws Exception {
        return (ListFaceEntitiesResponse) TeaModel.build(map, new ListFaceEntitiesResponse());
    }

    public ListFaceEntitiesResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListFaceEntitiesResponse setBody(ListFaceEntitiesResponseBody listFaceEntitiesResponseBody) {
        this.body = listFaceEntitiesResponseBody;
        return this;
    }

    public ListFaceEntitiesResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public ListFaceEntitiesResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
