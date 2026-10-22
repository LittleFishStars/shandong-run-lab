package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompleteMultipartUploadRequest extends TeaModel {

    @NameInMap("Body")
    public CompleteMultipartUploadRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public CompleteMultipartUploadRequestFilter filter;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class CompleteMultipartUploadRequestBody extends TeaModel {

        @NameInMap("CompleteMultipartUpload")
        @Validation(required = true)
        public CompleteMultipartUploadRequestBodyCompleteMultipartUpload completeMultipartUpload;

        public static CompleteMultipartUploadRequestBody build(Map<String, ?> map) throws Exception {
            return (CompleteMultipartUploadRequestBody) TeaModel.build(map, new CompleteMultipartUploadRequestBody());
        }

        public CompleteMultipartUploadRequestBodyCompleteMultipartUpload getCompleteMultipartUpload() {
            return this.completeMultipartUpload;
        }

        public CompleteMultipartUploadRequestBody setCompleteMultipartUpload(CompleteMultipartUploadRequestBodyCompleteMultipartUpload completeMultipartUploadRequestBodyCompleteMultipartUpload) {
            this.completeMultipartUpload = completeMultipartUploadRequestBodyCompleteMultipartUpload;
            return this;
        }
    }

    public static class CompleteMultipartUploadRequestBodyCompleteMultipartUpload extends TeaModel {

        @NameInMap("Part")
        public List<CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart> part;

        public static CompleteMultipartUploadRequestBodyCompleteMultipartUpload build(Map<String, ?> map) throws Exception {
            return (CompleteMultipartUploadRequestBodyCompleteMultipartUpload) TeaModel.build(map, new CompleteMultipartUploadRequestBodyCompleteMultipartUpload());
        }

        public List<CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart> getPart() {
            return this.part;
        }

        public CompleteMultipartUploadRequestBodyCompleteMultipartUpload setPart(List<CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart> list) {
            this.part = list;
            return this;
        }
    }

    public static class CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart extends TeaModel {

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("PartNumber")
        public String partNumber;

        public static CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart build(Map<String, ?> map) throws Exception {
            return (CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart) TeaModel.build(map, new CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart());
        }

        public String getETag() {
            return this.eTag;
        }

        public String getPartNumber() {
            return this.partNumber;
        }

        public CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart setETag(String str) {
            this.eTag = str;
            return this;
        }

        public CompleteMultipartUploadRequestBodyCompleteMultipartUploadPart setPartNumber(String str) {
            this.partNumber = str;
            return this;
        }
    }

    public static class CompleteMultipartUploadRequestFilter extends TeaModel {

        @NameInMap("Encoding-type")
        public String encodingType;

        @NameInMap(RequestParameters.UPLOAD_ID)
        @Validation(required = true)
        public String uploadId;

        public static CompleteMultipartUploadRequestFilter build(Map<String, ?> map) throws Exception {
            return (CompleteMultipartUploadRequestFilter) TeaModel.build(map, new CompleteMultipartUploadRequestFilter());
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public CompleteMultipartUploadRequestFilter setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public CompleteMultipartUploadRequestFilter setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static CompleteMultipartUploadRequest build(Map<String, ?> map) throws Exception {
        return (CompleteMultipartUploadRequest) TeaModel.build(map, new CompleteMultipartUploadRequest());
    }

    public CompleteMultipartUploadRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CompleteMultipartUploadRequestFilter getFilter() {
        return this.filter;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public CompleteMultipartUploadRequest setBody(CompleteMultipartUploadRequestBody completeMultipartUploadRequestBody) {
        this.body = completeMultipartUploadRequestBody;
        return this;
    }

    public CompleteMultipartUploadRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public CompleteMultipartUploadRequest setFilter(CompleteMultipartUploadRequestFilter completeMultipartUploadRequestFilter) {
        this.filter = completeMultipartUploadRequestFilter;
        return this;
    }

    public CompleteMultipartUploadRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
