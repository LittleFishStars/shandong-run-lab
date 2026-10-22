package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractPedestrianFeatureAttrResponse extends TeaModel {

    @NameInMap("body")
    public ExtractPedestrianFeatureAttrResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static ExtractPedestrianFeatureAttrResponse build(Map<String, ?> map) throws Exception {
        return (ExtractPedestrianFeatureAttrResponse) TeaModel.build(map, new ExtractPedestrianFeatureAttrResponse());
    }

    public ExtractPedestrianFeatureAttrResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ExtractPedestrianFeatureAttrResponse setBody(ExtractPedestrianFeatureAttrResponseBody extractPedestrianFeatureAttrResponseBody) {
        this.body = extractPedestrianFeatureAttrResponseBody;
        return this;
    }

    public ExtractPedestrianFeatureAttrResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public ExtractPedestrianFeatureAttrResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
