package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SearchFaceResponse extends TeaModel {

    @NameInMap("body")
    public SearchFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static SearchFaceResponse build(Map<String, ?> map) throws Exception {
        return (SearchFaceResponse) TeaModel.build(map, new SearchFaceResponse());
    }

    public SearchFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public SearchFaceResponse setBody(SearchFaceResponseBody searchFaceResponseBody) {
        this.body = searchFaceResponseBody;
        return this;
    }

    public SearchFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public SearchFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
