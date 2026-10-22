package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BeautifyBodyResponse extends TeaModel {

    @NameInMap("body")
    public BeautifyBodyResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static BeautifyBodyResponse build(Map<String, ?> map) throws Exception {
        return (BeautifyBodyResponse) TeaModel.build(map, new BeautifyBodyResponse());
    }

    public BeautifyBodyResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public BeautifyBodyResponse setBody(BeautifyBodyResponseBody beautifyBodyResponseBody) {
        this.body = beautifyBodyResponseBody;
        return this;
    }

    public BeautifyBodyResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public BeautifyBodyResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
