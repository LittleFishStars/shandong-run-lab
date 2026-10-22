package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InitiateMultipartUploadResponse extends TeaModel {

    @NameInMap("InitiateMultipartUploadResult")
    @Validation(required = true)
    public InitiateMultipartUploadResponseInitiateMultipartUploadResult initiateMultipartUploadResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class InitiateMultipartUploadResponseInitiateMultipartUploadResult extends TeaModel {

        @NameInMap("Bucket")
        public String bucket;

        @NameInMap("Key")
        public String key;

        @NameInMap("UploadId")
        public String uploadId;

        public static InitiateMultipartUploadResponseInitiateMultipartUploadResult build(Map<String, ?> map) throws Exception {
            return (InitiateMultipartUploadResponseInitiateMultipartUploadResult) TeaModel.build(map, new InitiateMultipartUploadResponseInitiateMultipartUploadResult());
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getKey() {
            return this.key;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public InitiateMultipartUploadResponseInitiateMultipartUploadResult setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public InitiateMultipartUploadResponseInitiateMultipartUploadResult setKey(String str) {
            this.key = str;
            return this;
        }

        public InitiateMultipartUploadResponseInitiateMultipartUploadResult setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static InitiateMultipartUploadResponse build(Map<String, ?> map) throws Exception {
        return (InitiateMultipartUploadResponse) TeaModel.build(map, new InitiateMultipartUploadResponse());
    }

    public InitiateMultipartUploadResponseInitiateMultipartUploadResult getInitiateMultipartUploadResult() {
        return this.initiateMultipartUploadResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public InitiateMultipartUploadResponse setInitiateMultipartUploadResult(InitiateMultipartUploadResponseInitiateMultipartUploadResult initiateMultipartUploadResponseInitiateMultipartUploadResult) {
        this.initiateMultipartUploadResult = initiateMultipartUploadResponseInitiateMultipartUploadResult;
        return this;
    }

    public InitiateMultipartUploadResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
