package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadPartRequest extends TeaModel {

    @NameInMap("body")
    public InputStream body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public UploadPartRequestFilter filter;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class UploadPartRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.PART_NUMBER)
        @Validation(required = true)
        public String partNumber;

        @NameInMap(RequestParameters.UPLOAD_ID)
        @Validation(required = true)
        public String uploadId;

        public static UploadPartRequestFilter build(Map<String, ?> map) throws Exception {
            return (UploadPartRequestFilter) TeaModel.build(map, new UploadPartRequestFilter());
        }

        public String getPartNumber() {
            return this.partNumber;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public UploadPartRequestFilter setPartNumber(String str) {
            this.partNumber = str;
            return this;
        }

        public UploadPartRequestFilter setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static UploadPartRequest build(Map<String, ?> map) throws Exception {
        return (UploadPartRequest) TeaModel.build(map, new UploadPartRequest());
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public UploadPartRequestFilter getFilter() {
        return this.filter;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public UploadPartRequest setBody(InputStream inputStream) {
        this.body = inputStream;
        return this;
    }

    public UploadPartRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public UploadPartRequest setFilter(UploadPartRequestFilter uploadPartRequestFilter) {
        this.filter = uploadPartRequestFilter;
        return this;
    }

    public UploadPartRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
