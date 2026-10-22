package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HeadObjectResponse extends TeaModel {

    @NameInMap("access-control-allow-headers")
    @Validation(required = true)
    public String accessControlAllowHeaders;

    @NameInMap("access-control-allow-methods")
    @Validation(required = true)
    public String accessControlAllowMethods;

    @NameInMap("access-control-allow-origin")
    @Validation(required = true)
    public String accessControlAllowOrigin;

    @NameInMap("access-control-expose-headers")
    @Validation(required = true)
    public String accessControlExposeHeaders;

    @NameInMap("access-control-max-age")
    @Validation(required = true)
    public String accessControlMaxAge;

    @NameInMap("content-md5")
    @Validation(required = true)
    public String contentMd5;

    @NameInMap("x-oss-expiration")
    @Validation(required = true)
    public String expiration;

    @NameInMap(OSSHeaders.OSS_HASH_CRC64_ECMA)
    @Validation(required = true)
    public String hashCrc64ecma;

    @NameInMap("last-modified")
    @Validation(required = true)
    public String lastModified;

    @NameInMap(OSSHeaders.OSS_NEXT_APPEND_POSITION)
    @Validation(required = true)
    public String nextAppendPosition;

    @NameInMap(OSSHeaders.OSS_OBJECT_TYPE)
    @Validation(required = true)
    public String objectType;

    @NameInMap("x-oss-process-status")
    @Validation(required = true)
    public String processStatus;

    @NameInMap("x-oss-request-charged")
    @Validation(required = true)
    public String requestCharged;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("x-oss-restore")
    @Validation(required = true)
    public String restore;

    @NameInMap(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION)
    @Validation(required = true)
    public String serverSideEncryption;

    @NameInMap("x-oss-server-side-encryption-key-id")
    @Validation(required = true)
    public String serverSideEncryptionKeyId;

    @NameInMap(OSSHeaders.STORAGE_CLASS)
    @Validation(required = true)
    public String storageClass;

    @NameInMap("x-oss-tagging-count")
    @Validation(required = true)
    public String taggingCount;

    @NameInMap("usermeta")
    @Validation(required = true)
    public Map<String, String> userMeta;

    public static HeadObjectResponse build(Map<String, ?> map) throws Exception {
        return (HeadObjectResponse) TeaModel.build(map, new HeadObjectResponse());
    }

    public String getAccessControlAllowHeaders() {
        return this.accessControlAllowHeaders;
    }

    public String getAccessControlAllowMethods() {
        return this.accessControlAllowMethods;
    }

    public String getAccessControlAllowOrigin() {
        return this.accessControlAllowOrigin;
    }

    public String getAccessControlExposeHeaders() {
        return this.accessControlExposeHeaders;
    }

    public String getAccessControlMaxAge() {
        return this.accessControlMaxAge;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getNextAppendPosition() {
        return this.nextAppendPosition;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getProcessStatus() {
        return this.processStatus;
    }

    public String getRequestCharged() {
        return this.requestCharged;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getRestore() {
        return this.restore;
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

    public String getTaggingCount() {
        return this.taggingCount;
    }

    public Map<String, String> getUserMeta() {
        return this.userMeta;
    }

    public HeadObjectResponse setAccessControlAllowHeaders(String str) {
        this.accessControlAllowHeaders = str;
        return this;
    }

    public HeadObjectResponse setAccessControlAllowMethods(String str) {
        this.accessControlAllowMethods = str;
        return this;
    }

    public HeadObjectResponse setAccessControlAllowOrigin(String str) {
        this.accessControlAllowOrigin = str;
        return this;
    }

    public HeadObjectResponse setAccessControlExposeHeaders(String str) {
        this.accessControlExposeHeaders = str;
        return this;
    }

    public HeadObjectResponse setAccessControlMaxAge(String str) {
        this.accessControlMaxAge = str;
        return this;
    }

    public HeadObjectResponse setContentMd5(String str) {
        this.contentMd5 = str;
        return this;
    }

    public HeadObjectResponse setExpiration(String str) {
        this.expiration = str;
        return this;
    }

    public HeadObjectResponse setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public HeadObjectResponse setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public HeadObjectResponse setNextAppendPosition(String str) {
        this.nextAppendPosition = str;
        return this;
    }

    public HeadObjectResponse setObjectType(String str) {
        this.objectType = str;
        return this;
    }

    public HeadObjectResponse setProcessStatus(String str) {
        this.processStatus = str;
        return this;
    }

    public HeadObjectResponse setRequestCharged(String str) {
        this.requestCharged = str;
        return this;
    }

    public HeadObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public HeadObjectResponse setRestore(String str) {
        this.restore = str;
        return this;
    }

    public HeadObjectResponse setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
        return this;
    }

    public HeadObjectResponse setServerSideEncryptionKeyId(String str) {
        this.serverSideEncryptionKeyId = str;
        return this;
    }

    public HeadObjectResponse setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public HeadObjectResponse setTaggingCount(String str) {
        this.taggingCount = str;
        return this;
    }

    public HeadObjectResponse setUserMeta(Map<String, String> map) {
        this.userMeta = map;
        return this;
    }
}
