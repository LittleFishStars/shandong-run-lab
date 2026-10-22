package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchBodyResponse extends TeaModel {

    @NameInMap("body")
    public RetouchBodyResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static RetouchBodyResponse build(Map<String, ?> map) throws Exception {
        return (RetouchBodyResponse) TeaModel.build(map, new RetouchBodyResponse());
    }

    public RetouchBodyResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public RetouchBodyResponse setBody(RetouchBodyResponseBody retouchBodyResponseBody) {
        this.body = retouchBodyResponseBody;
        return this;
    }

    public RetouchBodyResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public RetouchBodyResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
