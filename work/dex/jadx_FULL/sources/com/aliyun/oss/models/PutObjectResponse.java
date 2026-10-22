package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutObjectResponse extends TeaModel {

    @NameInMap("x-oss-bucket-version")
    @Validation(required = true)
    public String bucketVersion;

    @NameInMap(OSSHeaders.OSS_HASH_CRC64_ECMA)
    @Validation(required = true)
    public String hashCrc64ecma;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("x-oss-server-time")
    @Validation(required = true)
    public String serverTime;

    public static PutObjectResponse build(Map<String, ?> map) throws Exception {
        return (PutObjectResponse) TeaModel.build(map, new PutObjectResponse());
    }

    public String getBucketVersion() {
        return this.bucketVersion;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getServerTime() {
        return this.serverTime;
    }

    public PutObjectResponse setBucketVersion(String str) {
        this.bucketVersion = str;
        return this;
    }

    public PutObjectResponse setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public PutObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public PutObjectResponse setServerTime(String str) {
        this.serverTime = str;
        return this;
    }
}
