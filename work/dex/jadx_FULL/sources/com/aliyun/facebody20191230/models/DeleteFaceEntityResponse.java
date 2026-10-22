package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceEntityResponse extends TeaModel {

    @NameInMap("body")
    public DeleteFaceEntityResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DeleteFaceEntityResponse build(Map<String, ?> map) throws Exception {
        return (DeleteFaceEntityResponse) TeaModel.build(map, new DeleteFaceEntityResponse());
    }

    public DeleteFaceEntityResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteFaceEntityResponse setBody(DeleteFaceEntityResponseBody deleteFaceEntityResponseBody) {
        this.body = deleteFaceEntityResponseBody;
        return this;
    }

    public DeleteFaceEntityResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DeleteFaceEntityResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
