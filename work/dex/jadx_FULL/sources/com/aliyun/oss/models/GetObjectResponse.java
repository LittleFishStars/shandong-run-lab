package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetObjectResponse extends TeaModel {

    @NameInMap("body")
    @Validation(required = true)
    public InputStream body;

    @NameInMap(OSSHeaders.OSS_OBJECT_TYPE)
    @Validation(required = true)
    public String objectType;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("x-oss-restore")
    @Validation(required = true)
    public String restore;

    @NameInMap(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION)
    @Validation(required = true)
    public String serverSideEncryption;

    @NameInMap("x-oss-tagging-count")
    @Validation(required = true)
    public String taggingCount;

    public static GetObjectResponse build(Map<String, ?> map) throws Exception {
        return (GetObjectResponse) TeaModel.build(map, new GetObjectResponse());
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getRestore() {
        return this.restore;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getTaggingCount() {
        return this.taggingCount;
    }

    public GetObjectResponse setBody(InputStream inputStream) {
        this.body = inputStream;
        return this;
    }

    public GetObjectResponse setObjectType(String str) {
        this.objectType = str;
        return this;
    }

    public GetObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetObjectResponse setRestore(String str) {
        this.restore = str;
        return this;
    }

    public GetObjectResponse setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
        return this;
    }

    public GetObjectResponse setTaggingCount(String str) {
        this.taggingCount = str;
        return this;
    }
}
