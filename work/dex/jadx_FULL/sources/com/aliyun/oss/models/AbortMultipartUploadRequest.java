package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AbortMultipartUploadRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public AbortMultipartUploadRequestFilter filter;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class AbortMultipartUploadRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.UPLOAD_ID)
        @Validation(required = true)
        public String uploadId;

        public static AbortMultipartUploadRequestFilter build(Map<String, ?> map) throws Exception {
            return (AbortMultipartUploadRequestFilter) TeaModel.build(map, new AbortMultipartUploadRequestFilter());
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public AbortMultipartUploadRequestFilter setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static AbortMultipartUploadRequest build(Map<String, ?> map) throws Exception {
        return (AbortMultipartUploadRequest) TeaModel.build(map, new AbortMultipartUploadRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public AbortMultipartUploadRequestFilter getFilter() {
        return this.filter;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public AbortMultipartUploadRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public AbortMultipartUploadRequest setFilter(AbortMultipartUploadRequestFilter abortMultipartUploadRequestFilter) {
        this.filter = abortMultipartUploadRequestFilter;
        return this;
    }

    public AbortMultipartUploadRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
