package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketLoggingRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketLoggingRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketLoggingRequestBody extends TeaModel {

        @NameInMap("BucketLoggingStatus")
        @Validation(required = true)
        public PutBucketLoggingRequestBodyBucketLoggingStatus bucketLoggingStatus;

        public static PutBucketLoggingRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketLoggingRequestBody) TeaModel.build(map, new PutBucketLoggingRequestBody());
        }

        public PutBucketLoggingRequestBodyBucketLoggingStatus getBucketLoggingStatus() {
            return this.bucketLoggingStatus;
        }

        public PutBucketLoggingRequestBody setBucketLoggingStatus(PutBucketLoggingRequestBodyBucketLoggingStatus putBucketLoggingRequestBodyBucketLoggingStatus) {
            this.bucketLoggingStatus = putBucketLoggingRequestBodyBucketLoggingStatus;
            return this;
        }
    }

    public static class PutBucketLoggingRequestBodyBucketLoggingStatus extends TeaModel {

        @NameInMap("LoggingEnabled")
        public PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled loggingEnabled;

        public static PutBucketLoggingRequestBodyBucketLoggingStatus build(Map<String, ?> map) throws Exception {
            return (PutBucketLoggingRequestBodyBucketLoggingStatus) TeaModel.build(map, new PutBucketLoggingRequestBodyBucketLoggingStatus());
        }

        public PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled getLoggingEnabled() {
            return this.loggingEnabled;
        }

        public PutBucketLoggingRequestBodyBucketLoggingStatus setLoggingEnabled(PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled putBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled) {
            this.loggingEnabled = putBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled;
            return this;
        }
    }

    public static class PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled extends TeaModel {

        @NameInMap("TargetBucket")
        public String targetBucket;

        @NameInMap("TargetPrefix")
        public String targetPrefix;

        public static PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled build(Map<String, ?> map) throws Exception {
            return (PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled) TeaModel.build(map, new PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled());
        }

        public String getTargetBucket() {
            return this.targetBucket;
        }

        public String getTargetPrefix() {
            return this.targetPrefix;
        }

        public PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled setTargetBucket(String str) {
            this.targetBucket = str;
            return this;
        }

        public PutBucketLoggingRequestBodyBucketLoggingStatusLoggingEnabled setTargetPrefix(String str) {
            this.targetPrefix = str;
            return this;
        }
    }

    public static PutBucketLoggingRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketLoggingRequest) TeaModel.build(map, new PutBucketLoggingRequest());
    }

    public PutBucketLoggingRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketLoggingRequest setBody(PutBucketLoggingRequestBody putBucketLoggingRequestBody) {
        this.body = putBucketLoggingRequestBody;
        return this;
    }

    public PutBucketLoggingRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
