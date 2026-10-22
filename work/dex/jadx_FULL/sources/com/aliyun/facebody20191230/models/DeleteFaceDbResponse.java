package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceDbResponse extends TeaModel {

    @NameInMap("body")
    public DeleteFaceDbResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DeleteFaceDbResponse build(Map<String, ?> map) throws Exception {
        return (DeleteFaceDbResponse) TeaModel.build(map, new DeleteFaceDbResponse());
    }

    public DeleteFaceDbResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteFaceDbResponse setBody(DeleteFaceDbResponseBody deleteFaceDbResponseBody) {
        this.body = deleteFaceDbResponseBody;
        return this;
    }

    public DeleteFaceDbResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DeleteFaceDbResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
