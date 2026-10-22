package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CopyObjectRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("DestObjectName")
    @Validation(required = true)
    public String destObjectName;

    @NameInMap("Header")
    @Validation(required = true)
    public CopyObjectRequestHeader header;

    public static class CopyObjectRequestHeader extends TeaModel {

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

        @NameInMap(OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE)
        public String metadataDirective;

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

        @NameInMap("x-oss-tagging-directive")
        public String taggingDirective;

        public static CopyObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (CopyObjectRequestHeader) TeaModel.build(map, new CopyObjectRequestHeader());
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

        public String getMetadataDirective() {
            return this.metadataDirective;
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

        public String getTaggingDirective() {
            return this.taggingDirective;
        }

        public CopyObjectRequestHeader setCopySource(String str) {
            this.copySource = str;
            return this;
        }

        public CopyObjectRequestHeader setCopySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
            return this;
        }

        public CopyObjectRequestHeader setCopySourceIfModifiedSince(String str) {
            this.copySourceIfModifiedSince = str;
            return this;
        }

        public CopyObjectRequestHeader setCopySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
            return this;
        }

        public CopyObjectRequestHeader setCopySourceIfUnmodifiedSince(String str) {
            this.copySourceIfUnmodifiedSince = str;
            return this;
        }

        public CopyObjectRequestHeader setMetadataDirective(String str) {
            this.metadataDirective = str;
            return this;
        }

        public CopyObjectRequestHeader setObjectAcl(String str) {
            this.objectAcl = str;
            return this;
        }

        public CopyObjectRequestHeader setServerSideEncryption(String str) {
            this.serverSideEncryption = str;
            return this;
        }

        public CopyObjectRequestHeader setServerSideEncryptionKeyId(String str) {
            this.serverSideEncryptionKeyId = str;
            return this;
        }

        public CopyObjectRequestHeader setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }

        public CopyObjectRequestHeader setTagging(String str) {
            this.tagging = str;
            return this;
        }

        public CopyObjectRequestHeader setTaggingDirective(String str) {
            this.taggingDirective = str;
            return this;
        }
    }

    public static CopyObjectRequest build(Map<String, ?> map) throws Exception {
        return (CopyObjectRequest) TeaModel.build(map, new CopyObjectRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDestObjectName() {
        return this.destObjectName;
    }

    public CopyObjectRequestHeader getHeader() {
        return this.header;
    }

    public CopyObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public CopyObjectRequest setDestObjectName(String str) {
        this.destObjectName = str;
        return this;
    }

    public CopyObjectRequest setHeader(CopyObjectRequestHeader copyObjectRequestHeader) {
        this.header = copyObjectRequestHeader;
        return this;
    }
}
