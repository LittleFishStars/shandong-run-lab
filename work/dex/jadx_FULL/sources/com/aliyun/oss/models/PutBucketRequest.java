package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    public PutBucketRequestHeader header;

    public static class PutBucketRequestBody extends TeaModel {

        @NameInMap("CreateBucketConfiguration")
        @Validation(required = true)
        public PutBucketRequestBodyCreateBucketConfiguration createBucketConfiguration;

        public static PutBucketRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketRequestBody) TeaModel.build(map, new PutBucketRequestBody());
        }

        public PutBucketRequestBodyCreateBucketConfiguration getCreateBucketConfiguration() {
            return this.createBucketConfiguration;
        }

        public PutBucketRequestBody setCreateBucketConfiguration(PutBucketRequestBodyCreateBucketConfiguration putBucketRequestBodyCreateBucketConfiguration) {
            this.createBucketConfiguration = putBucketRequestBodyCreateBucketConfiguration;
            return this;
        }
    }

    public static class PutBucketRequestBodyCreateBucketConfiguration extends TeaModel {

        @NameInMap("DataRedundancyType")
        public String dataRedundancyType;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static PutBucketRequestBodyCreateBucketConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketRequestBodyCreateBucketConfiguration) TeaModel.build(map, new PutBucketRequestBodyCreateBucketConfiguration());
        }

        public String getDataRedundancyType() {
            return this.dataRedundancyType;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public PutBucketRequestBodyCreateBucketConfiguration setDataRedundancyType(String str) {
            this.dataRedundancyType = str;
            return this;
        }

        public PutBucketRequestBodyCreateBucketConfiguration setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static class PutBucketRequestHeader extends TeaModel {

        @NameInMap(OSSHeaders.OSS_CANNED_ACL)
        public String acl;

        public static PutBucketRequestHeader build(Map<String, ?> map) throws Exception {
            return (PutBucketRequestHeader) TeaModel.build(map, new PutBucketRequestHeader());
        }

        public String getAcl() {
            return this.acl;
        }

        public PutBucketRequestHeader setAcl(String str) {
            this.acl = str;
            return this;
        }
    }

    public static PutBucketRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketRequest) TeaModel.build(map, new PutBucketRequest());
    }

    public PutBucketRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketRequestHeader getHeader() {
        return this.header;
    }

    public PutBucketRequest setBody(PutBucketRequestBody putBucketRequestBody) {
        this.body = putBucketRequestBody;
        return this;
    }

    public PutBucketRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutBucketRequest setHeader(PutBucketRequestHeader putBucketRequestHeader) {
        this.header = putBucketRequestHeader;
        return this;
    }
}
