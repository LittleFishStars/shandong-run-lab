package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MergeImageFaceResponse extends TeaModel {

    @NameInMap("body")
    public MergeImageFaceResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static MergeImageFaceResponse build(Map<String, ?> map) throws Exception {
        return (MergeImageFaceResponse) TeaModel.build(map, new MergeImageFaceResponse());
    }

    public MergeImageFaceResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public MergeImageFaceResponse setBody(MergeImageFaceResponseBody mergeImageFaceResponseBody) {
        this.body = mergeImageFaceResponseBody;
        return this;
    }

    public MergeImageFaceResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public MergeImageFaceResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
