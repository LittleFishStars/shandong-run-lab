package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeExpressionResponse extends TeaModel {

    @NameInMap("body")
    public RecognizeExpressionResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RecognizeExpressionResponse build(Map<String, ?> map) throws Exception {
        return (RecognizeExpressionResponse) TeaModel.build(map, new RecognizeExpressionResponse());
    }

    public RecognizeExpressionResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RecognizeExpressionResponse setBody(RecognizeExpressionResponseBody recognizeExpressionResponseBody) {
        this.body = recognizeExpressionResponseBody;
        return this;
    }

    public RecognizeExpressionResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RecognizeExpressionResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
