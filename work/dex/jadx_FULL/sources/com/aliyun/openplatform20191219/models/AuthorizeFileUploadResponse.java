package com.aliyun.openplatform20191219.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthorizeFileUploadResponse extends TeaModel {

    @NameInMap("body")
    public AuthorizeFileUploadResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static AuthorizeFileUploadResponse build(Map<String, ?> map) throws Exception {
        return (AuthorizeFileUploadResponse) TeaModel.build(map, new AuthorizeFileUploadResponse());
    }

    public AuthorizeFileUploadResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public AuthorizeFileUploadResponse setBody(AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody) {
        this.body = authorizeFileUploadResponseBody;
        return this;
    }

    public AuthorizeFileUploadResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public AuthorizeFileUploadResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
