package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetObjectRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    public GetObjectRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class GetObjectRequestHeader extends TeaModel {

        @NameInMap("Accept-Encoding")
        public String acceptEncoding;

        @NameInMap("If-Match")
        public String ifMatch;

        @NameInMap("If-Modified-Since")
        public String ifModifiedSince;

        @NameInMap("If-None-Match")
        public String ifNoneMatch;

        @NameInMap("If-Unmodified-Since")
        public String ifUnmodifiedSince;

        @NameInMap("Range")
        public String range;

        @NameInMap(RequestParameters.RESPONSE_HEADER_CACHE_CONTROL)
        public String responseCacheControl;

        @NameInMap(RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION)
        public String responseContentDisposition;

        @NameInMap(RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING)
        public String responseContentEncoding;

        @NameInMap(RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE)
        public String responseContentLanguage;

        @NameInMap(RequestParameters.RESPONSE_HEADER_CONTENT_TYPE)
        public String responseContentType;

        @NameInMap(RequestParameters.RESPONSE_HEADER_EXPIRES)
        public String responseExpires;

        public static GetObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (GetObjectRequestHeader) TeaModel.build(map, new GetObjectRequestHeader());
        }

        public String getAcceptEncoding() {
            return this.acceptEncoding;
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

        public String getRange() {
            return this.range;
        }

        public String getResponseCacheControl() {
            return this.responseCacheControl;
        }

        public String getResponseContentDisposition() {
            return this.responseContentDisposition;
        }

        public String getResponseContentEncoding() {
            return this.responseContentEncoding;
        }

        public String getResponseContentLanguage() {
            return this.responseContentLanguage;
        }

        public String getResponseContentType() {
            return this.responseContentType;
        }

        public String getResponseExpires() {
            return this.responseExpires;
        }

        public GetObjectRequestHeader setAcceptEncoding(String str) {
            this.acceptEncoding = str;
            return this;
        }

        public GetObjectRequestHeader setIfMatch(String str) {
            this.ifMatch = str;
            return this;
        }

        public GetObjectRequestHeader setIfModifiedSince(String str) {
            this.ifModifiedSince = str;
            return this;
        }

        public GetObjectRequestHeader setIfNoneMatch(String str) {
            this.ifNoneMatch = str;
            return this;
        }

        public GetObjectRequestHeader setIfUnmodifiedSince(String str) {
            this.ifUnmodifiedSince = str;
            return this;
        }

        public GetObjectRequestHeader setRange(String str) {
            this.range = str;
            return this;
        }

        public GetObjectRequestHeader setResponseCacheControl(String str) {
            this.responseCacheControl = str;
            return this;
        }

        public GetObjectRequestHeader setResponseContentDisposition(String str) {
            this.responseContentDisposition = str;
            return this;
        }

        public GetObjectRequestHeader setResponseContentEncoding(String str) {
            this.responseContentEncoding = str;
            return this;
        }

        public GetObjectRequestHeader setResponseContentLanguage(String str) {
            this.responseContentLanguage = str;
            return this;
        }

        public GetObjectRequestHeader setResponseContentType(String str) {
            this.responseContentType = str;
            return this;
        }

        public GetObjectRequestHeader setResponseExpires(String str) {
            this.responseExpires = str;
            return this;
        }
    }

    public static GetObjectRequest build(Map<String, ?> map) throws Exception {
        return (GetObjectRequest) TeaModel.build(map, new GetObjectRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public GetObjectRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public GetObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetObjectRequest setHeader(GetObjectRequestHeader getObjectRequestHeader) {
        this.header = getObjectRequestHeader;
        return this;
    }

    public GetObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
