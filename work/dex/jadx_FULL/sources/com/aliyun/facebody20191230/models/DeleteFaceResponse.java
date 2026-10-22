package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceResponse extends TeaModel {

    @NameInMap("body")
    public DeleteFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DeleteFaceResponse build(Map<String, ?> map) throws Exception {
        return (DeleteFaceResponse) TeaModel.build(map, new DeleteFaceResponse());
    }

    public DeleteFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteFaceResponse setBody(DeleteFaceResponseBody deleteFaceResponseBody) {
        this.body = deleteFaceResponseBody;
        return this;
    }

    public DeleteFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DeleteFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
