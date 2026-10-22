package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HeadObjectRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    public HeadObjectRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class HeadObjectRequestHeader extends TeaModel {

        @NameInMap("If-Match")
        public String ifMatch;

        @NameInMap("If-Modified-Since")
        public String ifModifiedSince;

        @NameInMap("If-None-Match")
        public String ifNoneMatch;

        @NameInMap("If-Unmodified-Since")
        public String ifUnmodifiedSince;

        public static HeadObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (HeadObjectRequestHeader) TeaModel.build(map, new HeadObjectRequestHeader());
        }

        public String getIfMatch() {
            return this.ifMatch;
        }

        public String getIfModifiedSince() {
            return this.ifModifiedSince;
        }

        public String getIfNoneMatch() {
            return this.ifNoneMatch;
        }

        public String getIfUnmodifiedSince() {
            return this.ifUnmodifiedSince;
        }

        public HeadObjectRequestHeader setIfMatch(String str) {
            this.ifMatch = str;
            return this;
        }

        public HeadObjectRequestHeader setIfModifiedSince(String str) {
            this.ifModifiedSince = str;
            return this;
        }

        public HeadObjectRequestHeader setIfNoneMatch(String str) {
            this.ifNoneMatch = str;
            return this;
        }

        public HeadObjectRequestHeader setIfUnmodifiedSince(String str) {
            this.ifUnmodifiedSince = str;
            return this;
        }
    }

    public static HeadObjectRequest build(Map<String, ?> map) throws Exception {
        return (HeadObjectRequest) TeaModel.build(map, new HeadObjectRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public HeadObjectRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public HeadObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public HeadObjectRequest setHeader(HeadObjectRequestHeader headObjectRequestHeader) {
        this.header = headObjectRequestHeader;
        return this;
    }

    public HeadObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
