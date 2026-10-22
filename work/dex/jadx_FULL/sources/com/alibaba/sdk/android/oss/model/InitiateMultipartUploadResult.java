package com.alibaba.sdk.android.oss.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InitiateMultipartUploadResult extends OSSResult {
    private String bucketName;
    private String objectKey;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
