package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceResponse extends TeaModel {

    @NameInMap("body")
    public AddFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static AddFaceResponse build(Map<String, ?> map) throws Exception {
        return (AddFaceResponse) TeaModel.build(map, new AddFaceResponse());
    }

    public AddFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public AddFaceResponse setBody(AddFaceResponseBody addFaceResponseBody) {
        this.body = addFaceResponseBody;
        return this;
    }

    public AddFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public AddFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
