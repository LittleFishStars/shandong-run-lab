package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadPartCopyRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public UploadPartCopyRequestFilter filter;

    @NameInMap("Header")
    @Validation(required = true)
    public UploadPartCopyRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class UploadPartCopyRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.PART_NUMBER)
        @Validation(required = true)
        public String partNumber;

        @NameInMap(RequestParameters.UPLOAD_ID)
        @Validation(required = true)
        public String uploadId;

        public static UploadPartCopyRequestFilter build(Map<String, ?> map) throws Exception {
            return (UploadPartCopyRequestFilter) TeaModel.build(map, new UploadPartCopyRequestFilter());
        }

        public String getPartNumber() {
            return this.partNumber;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public UploadPartCopyRequestFilter setPartNumber(String str) {
            this.partNumber = str;
            return this;
        }

        public UploadPartCopyRequestFilter setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static class UploadPartCopyRequestHeader extends TeaModel {

        @NameInMap(OSSHeaders.COPY_OBJECT_SOURCE)
        @Validation(required = true)
        public String copySource;

        @NameInMap(OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH)
        public String copySourceIfMatch;

        @NameInMap(OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE)
        public String copySourceIfModifiedSince;

        @NameInMap(OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH)
        public String copySourceIfNoneMatch;

        @NameInMap(OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE)
        public String copySourceIfUnmodifiedSince;

        @NameInMap(OSSHeaders.COPY_SOURCE_RANGE)
        @Validation(required = true)
        public String copySourceRange;

        public static UploadPartCopyRequestHeader build(Map<String, ?> map) throws Exception {
            return (UploadPartCopyRequestHeader) TeaModel.build(map, new UploadPartCopyRequestHeader());
        }

        public String getCopySource() {
            return this.copySource;
        }

        public String getCopySourceIfMatch() {
            return this.copySourceIfMatch;
        }

        public String getCopySourceIfModifiedSince() {
            return this.copySourceIfModifiedSince;
        }

        public String getCopySourceIfNoneMatch() {
            return this.copySourceIfNoneMatch;
        }

        public String getCopySourceIfUnmodifiedSince() {
            return this.copySourceIfUnmodifiedSince;
        }

        public String getCopySourceRange() {
            return this.copySourceRange;
        }

        public UploadPartCopyRequestHeader setCopySource(String str) {
            this.copySource = str;
            return this;
        }

        public UploadPartCopyRequestHeader setCopySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
            return this;
        }

        public UploadPartCopyRequestHeader setCopySourceIfModifiedSince(String str) {
            this.copySourceIfModifiedSince = str;
            return this;
        }

        public UploadPartCopyRequestHeader setCopySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
            return this;
        }

        public UploadPartCopyRequestHeader setCopySourceIfUnmodifiedSince(String str) {
            this.copySourceIfUnmodifiedSince = str;
            return this;
        }

        public UploadPartCopyRequestHeader setCopySourceRange(String str) {
            this.copySourceRange = str;
            return this;
        }
    }

    public static UploadPartCopyRequest build(Map<String, ?> map) throws Exception {
        return (UploadPartCopyRequest) TeaModel.build(map, new UploadPartCopyRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public UploadPartCopyRequestFilter getFilter() {
        return this.filter;
    }

    public UploadPartCopyRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public UploadPartCopyRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public UploadPartCopyRequest setFilter(UploadPartCopyRequestFilter uploadPartCopyRequestFilter) {
        this.filter = uploadPartCopyRequestFilter;
        return this;
    }

    public UploadPartCopyRequest setHeader(UploadPartCopyRequestHeader uploadPartCopyRequestHeader) {
        this.header = uploadPartCopyRequestHeader;
        return this;
    }

    public UploadPartCopyRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
