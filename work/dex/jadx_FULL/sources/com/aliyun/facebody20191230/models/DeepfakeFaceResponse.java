package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeepfakeFaceResponse extends TeaModel {

    @NameInMap("body")
    public DeepfakeFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static DeepfakeFaceResponse build(Map<String, ?> map) throws Exception {
        return (DeepfakeFaceResponse) TeaModel.build(map, new DeepfakeFaceResponse());
    }

    public DeepfakeFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeepfakeFaceResponse setBody(DeepfakeFaceResponseBody deepfakeFaceResponseBody) {
        this.body = deepfakeFaceResponseBody;
        return this;
    }

    public DeepfakeFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public DeepfakeFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
