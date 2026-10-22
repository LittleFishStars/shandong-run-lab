package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutObjectAclRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    @Validation(required = true)
    public PutObjectAclRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class PutObjectAclRequestHeader extends TeaModel {

        @NameInMap("x-oss-object-acl")
        @Validation(required = true)
        public String objectAcl;

        public static PutObjectAclRequestHeader build(Map<String, ?> map) throws Exception {
            return (PutObjectAclRequestHeader) TeaModel.build(map, new PutObjectAclRequestHeader());
        }

        public String getObjectAcl() {
            return this.objectAcl;
        }

        public PutObjectAclRequestHeader setObjectAcl(String str) {
            this.objectAcl = str;
            return this;
        }
    }

    public static PutObjectAclRequest build(Map<String, ?> map) throws Exception {
        return (PutObjectAclRequest) TeaModel.build(map, new PutObjectAclRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutObjectAclRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public PutObjectAclRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutObjectAclRequest setHeader(PutObjectAclRequestHeader putObjectAclRequestHeader) {
        this.header = putObjectAclRequestHeader;
        return this;
    }

    public PutObjectAclRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
