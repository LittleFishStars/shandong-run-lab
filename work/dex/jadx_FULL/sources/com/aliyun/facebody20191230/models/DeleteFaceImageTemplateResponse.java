package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceImageTemplateResponse extends TeaModel {

    @NameInMap("body")
    public DeleteFaceImageTemplateResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DeleteFaceImageTemplateResponse build(Map<String, ?> map) throws Exception {
        return (DeleteFaceImageTemplateResponse) TeaModel.build(map, new DeleteFaceImageTemplateResponse());
    }

    public DeleteFaceImageTemplateResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteFaceImageTemplateResponse setBody(DeleteFaceImageTemplateResponseBody deleteFaceImageTemplateResponseBody) {
        this.body = deleteFaceImageTemplateResponseBody;
        return this;
    }

    public DeleteFaceImageTemplateResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DeleteFaceImageTemplateResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
