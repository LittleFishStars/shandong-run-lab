package com.aliyun.openplatform20191219.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthorizeFileUploadResponseBody extends TeaModel {

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID)
    public String accessKeyId;

    @NameInMap("Bucket")
    public String bucket;

    @NameInMap("EncodedPolicy")
    public String encodedPolicy;

    @NameInMap("Endpoint")
    public String endpoint;

    @NameInMap("ObjectKey")
    public String objectKey;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    @NameInMap("Signature")
    public String signature;

    @NameInMap("UseAccelerate")
    public Boolean useAccelerate;

    public static AuthorizeFileUploadResponseBody build(Map<String, ?> map) throws Exception {
        return (AuthorizeFileUploadResponseBody) TeaModel.build(map, new AuthorizeFileUploadResponseBody());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getEncodedPolicy() {
        return this.encodedPolicy;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSignature() {
        return this.signature;
    }

    public Boolean getUseAccelerate() {
        return this.useAccelerate;
    }

    public AuthorizeFileUploadResponseBody setAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setEncodedPolicy(String str) {
        this.encodedPolicy = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setObjectKey(String str) {
        this.objectKey = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setSignature(String str) {
        this.signature = str;
        return this;
    }

    public AuthorizeFileUploadResponseBody setUseAccelerate(Boolean bool) {
        this.useAccelerate = bool;
        return this;
    }
}
