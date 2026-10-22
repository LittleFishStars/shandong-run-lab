package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alipay.sdk.m.t.e;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InitiateMultipartUploadRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    public InitiateMultipartUploadRequestFilter filter;

    @NameInMap("Header")
    public InitiateMultipartUploadRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class InitiateMultipartUploadRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.ENCODING_TYPE)
        public String encodingType;

        public static InitiateMultipartUploadRequestFilter build(Map<String, ?> map) throws Exception {
            return (InitiateMultipartUploadRequestFilter) TeaModel.build(map, new InitiateMultipartUploadRequestFilter());
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public InitiateMultipartUploadRequestFilter setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }
    }

    public static class InitiateMultipartUploadRequestHeader extends TeaModel {

        @NameInMap("Cache-Control")
        public String cacheControl;

        @NameInMap("Content-Disposition")
        public String contentDisposition;

        @NameInMap("Content-Encoding")
        public String contentEncoding;

        @NameInMap(e.f)
        public String contentType;

        @NameInMap("Expires")
        public String expires;

        @NameInMap(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION)
        public String serverSideEncryption;

        @NameInMap("x-oss-server-side-encryption-key-id")
        public String serverSideEncryptionKeyId;

        @NameInMap(OSSHeaders.STORAGE_CLASS)
        public String storageClass;

        @NameInMap("x-oss-tagging")
        public String tagging;

        public static InitiateMultipartUploadRequestHeader build(Map<String, ?> map) throws Exception {
            return (InitiateMultipartUploadRequestHeader) TeaModel.build(map, new InitiateMultipartUploadRequestHeader());
        }

        public String getCacheControl() {
            return this.cacheControl;
        }

        public String getContentDisposition() {
            return this.contentDisposition;
        }

        public String getContentEncoding() {
            return this.contentEncoding;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getExpires() {
            return this.expires;
        }

        public String getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public String getServerSideEncryptionKeyId() {
            return this.serverSideEncryptionKeyId;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public String getTagging() {
            return this.tagging;
        }

        public InitiateMultipartUploadRequestHeader setCacheControl(String str) {
            this.cacheControl = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setContentDisposition(String str) {
            this.contentDisposition = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setContentEncoding(String str) {
            this.contentEncoding = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setExpires(String str) {
            this.expires = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setServerSideEncryption(String str) {
            this.serverSideEncryption = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setServerSideEncryptionKeyId(String str) {
            this.serverSideEncryptionKeyId = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }

        public InitiateMultipartUploadRequestHeader setTagging(String str) {
            this.tagging = str;
            return this;
        }
    }

    public static InitiateMultipartUploadRequest build(Map<String, ?> map) throws Exception {
        return (InitiateMultipartUploadRequest) TeaModel.build(map, new InitiateMultipartUploadRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public InitiateMultipartUploadRequestFilter getFilter() {
        return this.filter;
    }

    public InitiateMultipartUploadRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public InitiateMultipartUploadRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public InitiateMultipartUploadRequest setFilter(InitiateMultipartUploadRequestFilter initiateMultipartUploadRequestFilter) {
        this.filter = initiateMultipartUploadRequestFilter;
        return this;
    }

    public InitiateMultipartUploadRequest setHeader(InitiateMultipartUploadRequestHeader initiateMultipartUploadRequestHeader) {
        this.header = initiateMultipartUploadRequestHeader;
        return this;
    }

    public InitiateMultipartUploadRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
