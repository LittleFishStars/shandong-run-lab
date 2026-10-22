package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeActionResponse extends TeaModel {

    @NameInMap("body")
    public RecognizeActionResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RecognizeActionResponse build(Map<String, ?> map) throws Exception {
        return (RecognizeActionResponse) TeaModel.build(map, new RecognizeActionResponse());
    }

    public RecognizeActionResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RecognizeActionResponse setBody(RecognizeActionResponseBody recognizeActionResponseBody) {
        this.body = recognizeActionResponseBody;
        return this;
    }

    public RecognizeActionResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RecognizeActionResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
