package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnhanceFaceResponse extends TeaModel {

    @NameInMap("body")
    public EnhanceFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static EnhanceFaceResponse build(Map<String, ?> map) throws Exception {
        return (EnhanceFaceResponse) TeaModel.build(map, new EnhanceFaceResponse());
    }

    public EnhanceFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public EnhanceFaceResponse setBody(EnhanceFaceResponseBody enhanceFaceResponseBody) {
        this.body = enhanceFaceResponseBody;
        return this;
    }

    public EnhanceFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public EnhanceFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
