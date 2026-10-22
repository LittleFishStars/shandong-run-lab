package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetFaceEntityResponse extends TeaModel {

    @NameInMap("body")
    public GetFaceEntityResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static GetFaceEntityResponse build(Map<String, ?> map) throws Exception {
        return (GetFaceEntityResponse) TeaModel.build(map, new GetFaceEntityResponse());
    }

    public GetFaceEntityResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GetFaceEntityResponse setBody(GetFaceEntityResponseBody getFaceEntityResponseBody) {
        this.body = getFaceEntityResponseBody;
        return this;
    }

    public GetFaceEntityResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public GetFaceEntityResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
