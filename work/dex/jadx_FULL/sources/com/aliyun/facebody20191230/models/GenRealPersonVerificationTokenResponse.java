package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenRealPersonVerificationTokenResponse extends TeaModel {

    @NameInMap("body")
    public GenRealPersonVerificationTokenResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static GenRealPersonVerificationTokenResponse build(Map<String, ?> map) throws Exception {
        return (GenRealPersonVerificationTokenResponse) TeaModel.build(map, new GenRealPersonVerificationTokenResponse());
    }

    public GenRealPersonVerificationTokenResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GenRealPersonVerificationTokenResponse setBody(GenRealPersonVerificationTokenResponseBody genRealPersonVerificationTokenResponseBody) {
        this.body = genRealPersonVerificationTokenResponseBody;
        return this;
    }

    public GenRealPersonVerificationTokenResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public GenRealPersonVerificationTokenResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
