package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetObjectMetaResponse extends TeaModel {

    @NameInMap("content-length")
    @Validation(required = true)
    public String contentLength;

    @NameInMap("etag")
    @Validation(required = true)
    public String eTag;

    @NameInMap("last-modified")
    @Validation(required = true)
    public String lastModified;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static GetObjectMetaResponse build(Map<String, ?> map) throws Exception {
        return (GetObjectMetaResponse) TeaModel.build(map, new GetObjectMetaResponse());
    }

    public String getContentLength() {
        return this.contentLength;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetObjectMetaResponse setContentLength(String str) {
        this.contentLength = str;
        return this;
    }

    public GetObjectMetaResponse setETag(String str) {
        this.eTag = str;
        return this;
    }

    public GetObjectMetaResponse setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public GetObjectMetaResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
