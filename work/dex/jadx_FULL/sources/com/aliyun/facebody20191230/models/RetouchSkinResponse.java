package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchSkinResponse extends TeaModel {

    @NameInMap("body")
    public RetouchSkinResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RetouchSkinResponse build(Map<String, ?> map) throws Exception {
        return (RetouchSkinResponse) TeaModel.build(map, new RetouchSkinResponse());
    }

    public RetouchSkinResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RetouchSkinResponse setBody(RetouchSkinResponseBody retouchSkinResponseBody) {
        this.body = retouchSkinResponseBody;
        return this;
    }

    public RetouchSkinResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RetouchSkinResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
