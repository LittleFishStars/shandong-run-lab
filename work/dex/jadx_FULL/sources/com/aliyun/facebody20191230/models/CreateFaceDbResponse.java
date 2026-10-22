package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateFaceDbResponse extends TeaModel {

    @NameInMap("body")
    public CreateFaceDbResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static CreateFaceDbResponse build(Map<String, ?> map) throws Exception {
        return (CreateFaceDbResponse) TeaModel.build(map, new CreateFaceDbResponse());
    }

    public CreateFaceDbResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CreateFaceDbResponse setBody(CreateFaceDbResponseBody createFaceDbResponseBody) {
        this.body = createFaceDbResponseBody;
        return this;
    }

    public CreateFaceDbResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public CreateFaceDbResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
