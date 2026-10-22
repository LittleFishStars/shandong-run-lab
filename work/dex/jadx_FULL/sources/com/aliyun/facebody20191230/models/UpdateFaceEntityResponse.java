package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdateFaceEntityResponse extends TeaModel {

    @NameInMap("body")
    public UpdateFaceEntityResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static UpdateFaceEntityResponse build(Map<String, ?> map) throws Exception {
        return (UpdateFaceEntityResponse) TeaModel.build(map, new UpdateFaceEntityResponse());
    }

    public UpdateFaceEntityResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public UpdateFaceEntityResponse setBody(UpdateFaceEntityResponseBody updateFaceEntityResponseBody) {
        this.body = updateFaceEntityResponseBody;
        return this;
    }

    public UpdateFaceEntityResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public UpdateFaceEntityResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
