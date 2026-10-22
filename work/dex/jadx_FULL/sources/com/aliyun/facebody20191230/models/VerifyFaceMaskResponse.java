package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VerifyFaceMaskResponse extends TeaModel {

    @NameInMap("body")
    public VerifyFaceMaskResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static VerifyFaceMaskResponse build(Map<String, ?> map) throws Exception {
        return (VerifyFaceMaskResponse) TeaModel.build(map, new VerifyFaceMaskResponse());
    }

    public VerifyFaceMaskResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public VerifyFaceMaskResponse setBody(VerifyFaceMaskResponseBody verifyFaceMaskResponseBody) {
        this.body = verifyFaceMaskResponseBody;
        return this;
    }

    public VerifyFaceMaskResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public VerifyFaceMaskResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
