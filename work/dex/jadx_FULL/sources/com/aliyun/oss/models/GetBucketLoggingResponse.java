package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketLoggingResponse extends TeaModel {

    @NameInMap("BucketLoggingStatus")
    @Validation(required = true)
    public GetBucketLoggingResponseBucketLoggingStatus bucketLoggingStatus;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketLoggingResponseBucketLoggingStatus extends TeaModel {

        @NameInMap("LoggingEnabled")
        @Validation(required = true)
        public GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled loggingEnabled;

        public static GetBucketLoggingResponseBucketLoggingStatus build(Map<String, ?> map) throws Exception {
            return (GetBucketLoggingResponseBucketLoggingStatus) TeaModel.build(map, new GetBucketLoggingResponseBucketLoggingStatus());
        }

        public GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled getLoggingEnabled() {
            return this.loggingEnabled;
        }

        public GetBucketLoggingResponseBucketLoggingStatus setLoggingEnabled(GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled getBucketLoggingResponseBucketLoggingStatusLoggingEnabled) {
            this.loggingEnabled = getBucketLoggingResponseBucketLoggingStatusLoggingEnabled;
            return this;
        }
    }

    public static class GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled extends TeaModel {

        @NameInMap("TargetBucket")
        public String targetBucket;

        @NameInMap("TargetPrefix")
        public String targetPrefix;

        public static GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled build(Map<String, ?> map) throws Exception {
            return (GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled) TeaModel.build(map, new GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled());
        }

        public String getTargetBucket() {
            return this.targetBucket;
        }

        public String getTargetPrefix() {
            return this.targetPrefix;
        }

        public GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled setTargetBucket(String str) {
            this.targetBucket = str;
            return this;
        }

        public GetBucketLoggingResponseBucketLoggingStatusLoggingEnabled setTargetPrefix(String str) {
            this.targetPrefix = str;
            return this;
        }
    }

    public static GetBucketLoggingResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketLoggingResponse) TeaModel.build(map, new GetBucketLoggingResponse());
    }

    public GetBucketLoggingResponseBucketLoggingStatus getBucketLoggingStatus() {
        return this.bucketLoggingStatus;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketLoggingResponse setBucketLoggingStatus(GetBucketLoggingResponseBucketLoggingStatus getBucketLoggingResponseBucketLoggingStatus) {
        this.bucketLoggingStatus = getBucketLoggingResponseBucketLoggingStatus;
        return this;
    }

    public GetBucketLoggingResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
