package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeFaceResponse extends TeaModel {

    @NameInMap("body")
    public RecognizeFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RecognizeFaceResponse build(Map<String, ?> map) throws Exception {
        return (RecognizeFaceResponse) TeaModel.build(map, new RecognizeFaceResponse());
    }

    public RecognizeFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RecognizeFaceResponse setBody(RecognizeFaceResponseBody recognizeFaceResponseBody) {
        this.body = recognizeFaceResponseBody;
        return this;
    }

    public RecognizeFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RecognizeFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
