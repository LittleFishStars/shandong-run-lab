package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceEntityResponse extends TeaModel {

    @NameInMap("body")
    public AddFaceEntityResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static AddFaceEntityResponse build(Map<String, ?> map) throws Exception {
        return (AddFaceEntityResponse) TeaModel.build(map, new AddFaceEntityResponse());
    }

    public AddFaceEntityResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public AddFaceEntityResponse setBody(AddFaceEntityResponseBody addFaceEntityResponseBody) {
        this.body = addFaceEntityResponseBody;
        return this;
    }

    public AddFaceEntityResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public AddFaceEntityResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
