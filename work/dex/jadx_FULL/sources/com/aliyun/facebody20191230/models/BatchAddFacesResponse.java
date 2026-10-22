package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BatchAddFacesResponse extends TeaModel {

    @NameInMap("body")
    public BatchAddFacesResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static BatchAddFacesResponse build(Map<String, ?> map) throws Exception {
        return (BatchAddFacesResponse) TeaModel.build(map, new BatchAddFacesResponse());
    }

    public BatchAddFacesResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public BatchAddFacesResponse setBody(BatchAddFacesResponseBody batchAddFacesResponseBody) {
        this.body = batchAddFacesResponseBody;
        return this;
    }

    public BatchAddFacesResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public BatchAddFacesResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
