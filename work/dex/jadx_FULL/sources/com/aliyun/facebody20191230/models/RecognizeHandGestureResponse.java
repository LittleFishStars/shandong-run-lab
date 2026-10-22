package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeHandGestureResponse extends TeaModel {

    @NameInMap("body")
    public RecognizeHandGestureResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RecognizeHandGestureResponse build(Map<String, ?> map) throws Exception {
        return (RecognizeHandGestureResponse) TeaModel.build(map, new RecognizeHandGestureResponse());
    }

    public RecognizeHandGestureResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RecognizeHandGestureResponse setBody(RecognizeHandGestureResponseBody recognizeHandGestureResponseBody) {
        this.body = recognizeHandGestureResponseBody;
        return this;
    }

    public RecognizeHandGestureResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RecognizeHandGestureResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
