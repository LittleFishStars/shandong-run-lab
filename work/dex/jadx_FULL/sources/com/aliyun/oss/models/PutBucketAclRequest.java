package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketAclRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    @Validation(required = true)
    public PutBucketAclRequestHeader header;

    public static class PutBucketAclRequestHeader extends TeaModel {

        @NameInMap(OSSHeaders.OSS_CANNED_ACL)
        @Validation(required = true)
        public String acl;

        public static PutBucketAclRequestHeader build(Map<String, ?> map) throws Exception {
            return (PutBucketAclRequestHeader) TeaModel.build(map, new PutBucketAclRequestHeader());
        }

        public String getAcl() {
            return this.acl;
        }

        public PutBucketAclRequestHeader setAcl(String str) {
            this.acl = str;
            return this;
        }
    }

    public static PutBucketAclRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketAclRequest) TeaModel.build(map, new PutBucketAclRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketAclRequestHeader getHeader() {
        return this.header;
    }

    public PutBucketAclRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutBucketAclRequest setHeader(PutBucketAclRequestHeader putBucketAclRequestHeader) {
        this.header = putBucketAclRequestHeader;
        return this;
    }
}
