package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alipay.sdk.m.t.e;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutObjectRequest extends TeaModel {

    @NameInMap("body")
    public InputStream body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    public PutObjectRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    @NameInMap("UserMeta")
    public Map<String, String> userMeta;

    public static class PutObjectRequestHeader extends TeaModel {

        @NameInMap("Authorization")
        public String authorization;

        @NameInMap("Cache-Control")
        public String cacheControl;

        @NameInMap("Content-Disposition")
        public String contentDisposition;

        @NameInMap("Content-Encoding")
        public String contentEncoding;

        @NameInMap("Content-Length")
        public String contentLength;

        @NameInMap("Content-MD5")
        public String contentMD5;

        @NameInMap(e.f)
        public String contentType;

        @NameInMap("CETag")
        public String eTag;

        @NameInMap("Expires")
        public String expires;

        @NameInMap("x-oss-object-acl")
        public String objectAcl;

        @NameInMap(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION)
        public String serverSideEncryption;

        @NameInMap("x-oss-server-side-encryption-key-id")
        public String serverSideEncryptionKeyId;

        @NameInMap(OSSHeaders.STORAGE_CLASS)
        public String storageClass;

        @NameInMap("x-oss-tagging")
        public String tagging;

        public static PutObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (PutObjectRequestHeader) TeaModel.build(map, new PutObjectRequestHeader());
        }

        public String getAuthorization() {
            return this.authorization;
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

        public String getContentLength() {
            return this.contentLength;
        }

        public String getContentMD5() {
            return this.contentMD5;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getETag() {
            return this.eTag;
        }

        public String getExpires() {
            return this.expires;
        }

        public String getObjectAcl() {
            return this.objectAcl;
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

        public PutObjectRequestHeader setAuthorization(String str) {
            this.authorization = str;
            return this;
        }

        public PutObjectRequestHeader setCacheControl(String str) {
            this.cacheControl = str;
            return this;
        }

        public PutObjectRequestHeader setContentDisposition(String str) {
            this.contentDisposition = str;
            return this;
        }

        public PutObjectRequestHeader setContentEncoding(String str) {
            this.contentEncoding = str;
            return this;
        }

        public PutObjectRequestHeader setContentLength(String str) {
            this.contentLength = str;
            return this;
        }

        public PutObjectRequestHeader setContentMD5(String str) {
            this.contentMD5 = str;
            return this;
        }

        public PutObjectRequestHeader setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public PutObjectRequestHeader setETag(String str) {
            this.eTag = str;
            return this;
        }

        public PutObjectRequestHeader setExpires(String str) {
            this.expires = str;
            return this;
        }

        public PutObjectRequestHeader setObjectAcl(String str) {
            this.objectAcl = str;
            return this;
        }

        public PutObjectRequestHeader setServerSideEncryption(String str) {
            this.serverSideEncryption = str;
            return this;
        }

        public PutObjectRequestHeader setServerSideEncryptionKeyId(String str) {
            this.serverSideEncryptionKeyId = str;
            return this;
        }

        public PutObjectRequestHeader setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }

        public PutObjectRequestHeader setTagging(String str) {
            this.tagging = str;
            return this;
        }
    }

    public static PutObjectRequest build(Map<String, ?> map) throws Exception {
        return (PutObjectRequest) TeaModel.build(map, new PutObjectRequest());
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutObjectRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public Map<String, String> getUserMeta() {
        return this.userMeta;
    }

    public PutObjectRequest setBody(InputStream inputStream) {
        this.body = inputStream;
        return this;
    }

    public PutObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutObjectRequest setHeader(PutObjectRequestHeader putObjectRequestHeader) {
        this.header = putObjectRequestHeader;
        return this;
    }

    public PutObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }

    public PutObjectRequest setUserMeta(Map<String, String> map) {
        this.userMeta = map;
        return this;
    }
}
