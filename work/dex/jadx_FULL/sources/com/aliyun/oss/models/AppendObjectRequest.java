package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alipay.sdk.m.t.e;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppendObjectRequest extends TeaModel {

    @NameInMap("body")
    public InputStream body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public AppendObjectRequestFilter filter;

    @NameInMap("Header")
    public AppendObjectRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    @NameInMap("UserMeta")
    public Map<String, String> userMeta;

    public static class AppendObjectRequestFilter extends TeaModel {

        @NameInMap("position")
        @Validation(required = true)
        public String position;

        public static AppendObjectRequestFilter build(Map<String, ?> map) throws Exception {
            return (AppendObjectRequestFilter) TeaModel.build(map, new AppendObjectRequestFilter());
        }

        public String getPosition() {
            return this.position;
        }

        public AppendObjectRequestFilter setPosition(String str) {
            this.position = str;
            return this;
        }
    }

    public static class AppendObjectRequestHeader extends TeaModel {

        @NameInMap("Cache-Control")
        public String cacheControl;

        @NameInMap("Content-Disposition")
        public String contentDisposition;

        @NameInMap("Content-Encoding")
        public String contentEncoding;

        @NameInMap("Content-MD5")
        public String contentMD5;

        @NameInMap(e.f)
        public String contentType;

        @NameInMap("Expires")
        public String expires;

        @NameInMap("x-oss-object-acl")
        public String objectAcl;

        @NameInMap(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION)
        public String serverSideEncryption;

        @NameInMap(OSSHeaders.STORAGE_CLASS)
        public String storageClass;

        public static AppendObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (AppendObjectRequestHeader) TeaModel.build(map, new AppendObjectRequestHeader());
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

        public String getContentMD5() {
            return this.contentMD5;
        }

        public String getContentType() {
            return this.contentType;
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

        public String getStorageClass() {
            return this.storageClass;
        }

        public AppendObjectRequestHeader setCacheControl(String str) {
            this.cacheControl = str;
            return this;
        }

        public AppendObjectRequestHeader setContentDisposition(String str) {
            this.contentDisposition = str;
            return this;
        }

        public AppendObjectRequestHeader setContentEncoding(String str) {
            this.contentEncoding = str;
            return this;
        }

        public AppendObjectRequestHeader setContentMD5(String str) {
            this.contentMD5 = str;
            return this;
        }

        public AppendObjectRequestHeader setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public AppendObjectRequestHeader setExpires(String str) {
            this.expires = str;
            return this;
        }

        public AppendObjectRequestHeader setObjectAcl(String str) {
            this.objectAcl = str;
            return this;
        }

        public AppendObjectRequestHeader setServerSideEncryption(String str) {
            this.serverSideEncryption = str;
            return this;
        }

        public AppendObjectRequestHeader setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static AppendObjectRequest build(Map<String, ?> map) throws Exception {
        return (AppendObjectRequest) TeaModel.build(map, new AppendObjectRequest());
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public AppendObjectRequestFilter getFilter() {
        return this.filter;
    }

    public AppendObjectRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public Map<String, String> getUserMeta() {
        return this.userMeta;
    }

    public AppendObjectRequest setBody(InputStream inputStream) {
        this.body = inputStream;
        return this;
    }

    public AppendObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public AppendObjectRequest setFilter(AppendObjectRequestFilter appendObjectRequestFilter) {
        this.filter = appendObjectRequestFilter;
        return this;
    }

    public AppendObjectRequest setHeader(AppendObjectRequestHeader appendObjectRequestHeader) {
        this.header = appendObjectRequestHeader;
        return this;
    }

    public AppendObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }

    public AppendObjectRequest setUserMeta(Map<String, String> map) {
        this.userMeta = map;
        return this;
    }
}
