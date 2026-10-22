package com.aliyun.teaopenapi.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OpenApiRequest extends TeaModel {

    @NameInMap("body")
    public Object body;

    @NameInMap("endpointOverride")
    public String endpointOverride;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("hostMap")
    public Map<String, String> hostMap;

    @NameInMap("query")
    public Map<String, String> query;

    @NameInMap("stream")
    public InputStream stream;

    public static OpenApiRequest build(Map<String, ?> map) throws Exception {
        return (OpenApiRequest) TeaModel.build(map, new OpenApiRequest());
    }

    public Object getBody() {
        return this.body;
    }

    public String getEndpointOverride() {
        return this.endpointOverride;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getHostMap() {
        return this.hostMap;
    }

    public Map<String, String> getQuery() {
        return this.query;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public OpenApiRequest setBody(Object obj) {
        this.body = obj;
        return this;
    }

    public OpenApiRequest setEndpointOverride(String str) {
        this.endpointOverride = str;
        return this;
    }

    public OpenApiRequest setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public OpenApiRequest setHostMap(Map<String, String> map) {
        this.hostMap = map;
        return this;
    }

    public OpenApiRequest setQuery(Map<String, String> map) {
        this.query = map;
        return this;
    }

    public OpenApiRequest setStream(InputStream inputStream) {
        this.stream = inputStream;
        return this;
    }
}
