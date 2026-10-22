package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceTidyupResponse extends TeaModel {

    @NameInMap("body")
    public FaceTidyupResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static FaceTidyupResponse build(Map<String, ?> map) throws Exception {
        return (FaceTidyupResponse) TeaModel.build(map, new FaceTidyupResponse());
    }

    public FaceTidyupResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public FaceTidyupResponse setBody(FaceTidyupResponseBody faceTidyupResponseBody) {
        this.body = faceTidyupResponseBody;
        return this;
    }

    public FaceTidyupResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public FaceTidyupResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
