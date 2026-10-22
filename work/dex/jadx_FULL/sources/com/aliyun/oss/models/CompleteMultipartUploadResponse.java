package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompleteMultipartUploadResponse extends TeaModel {

    @NameInMap("CompleteMultipartUploadResult")
    @Validation(required = true)
    public CompleteMultipartUploadResponseCompleteMultipartUploadResult completeMultipartUploadResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class CompleteMultipartUploadResponseCompleteMultipartUploadResult extends TeaModel {

        @NameInMap("Bucket")
        public String bucket;

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("EncodingType")
        public String encodingType;

        @NameInMap("Key")
        public String key;

        @NameInMap("Location")
        public String location;

        public static CompleteMultipartUploadResponseCompleteMultipartUploadResult build(Map<String, ?> map) throws Exception {
            return (CompleteMultipartUploadResponseCompleteMultipartUploadResult) TeaModel.build(map, new CompleteMultipartUploadResponseCompleteMultipartUploadResult());
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getETag() {
            return this.eTag;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getKey() {
            return this.key;
        }

        public String getLocation() {
            return this.location;
        }

        public CompleteMultipartUploadResponseCompleteMultipartUploadResult setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public CompleteMultipartUploadResponseCompleteMultipartUploadResult setETag(String str) {
            this.eTag = str;
            return this;
        }

        public CompleteMultipartUploadResponseCompleteMultipartUploadResult setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public CompleteMultipartUploadResponseCompleteMultipartUploadResult setKey(String str) {
            this.key = str;
            return this;
        }

        public CompleteMultipartUploadResponseCompleteMultipartUploadResult setLocation(String str) {
            this.location = str;
            return this;
        }
    }

    public static CompleteMultipartUploadResponse build(Map<String, ?> map) throws Exception {
        return (CompleteMultipartUploadResponse) TeaModel.build(map, new CompleteMultipartUploadResponse());
    }

    public CompleteMultipartUploadResponseCompleteMultipartUploadResult getCompleteMultipartUploadResult() {
        return this.completeMultipartUploadResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CompleteMultipartUploadResponse setCompleteMultipartUploadResult(CompleteMultipartUploadResponseCompleteMultipartUploadResult completeMultipartUploadResponseCompleteMultipartUploadResult) {
        this.completeMultipartUploadResult = completeMultipartUploadResponseCompleteMultipartUploadResult;
        return this;
    }

    public CompleteMultipartUploadResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
