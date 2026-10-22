package com.alibaba.sdk.android.oss.model;

import android.net.Uri;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MultipartUploadRequest<T extends MultipartUploadRequest> extends OSSRequest {
    protected String bucketName;
    protected Map<String, String> callbackParam;
    protected Map<String, String> callbackVars;
    protected ObjectMetadata metadata;
    protected String objectKey;
    protected long partSize;
    protected OSSProgressCallback<T> progressCallback;
    protected String uploadFilePath;
    protected String uploadId;
    protected Uri uploadUri;

    public MultipartUploadRequest(String str, String str2, String str3) {
        this(str, str2, str3, (ObjectMetadata) null);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Map<String, String> getCallbackParam() {
        return this.callbackParam;
    }

    public Map<String, String> getCallbackVars() {
        return this.callbackVars;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public OSSProgressCallback<T> getProgressCallback() {
        return this.progressCallback;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public Uri getUploadUri() {
        return this.uploadUri;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCallbackParam(Map<String, String> map) {
        this.callbackParam = map;
    }

    public void setCallbackVars(Map<String, String> map) {
        this.callbackVars = map;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setProgressCallback(OSSProgressCallback<T> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadFilePath(String str) {
        this.uploadFilePath = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public void setUploadUri(Uri uri) {
        this.uploadUri = uri;
    }

    public MultipartUploadRequest(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        this.partSize = 262144L;
        setBucketName(str);
        setObjectKey(str2);
        setUploadFilePath(str3);
        setMetadata(objectMetadata);
    }

    public MultipartUploadRequest(String str, String str2, Uri uri) {
        this(str, str2, uri, (ObjectMetadata) null);
    }

    public MultipartUploadRequest(String str, String str2, Uri uri, ObjectMetadata objectMetadata) {
        this.partSize = 262144L;
        setBucketName(str);
        setObjectKey(str2);
        setUploadUri(uri);
        setMetadata(objectMetadata);
    }
}
