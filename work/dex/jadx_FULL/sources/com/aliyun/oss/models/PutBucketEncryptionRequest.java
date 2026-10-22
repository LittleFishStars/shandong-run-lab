package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketEncryptionRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketEncryptionRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketEncryptionRequestBody extends TeaModel {

        @NameInMap("ServerSideEncryptionRule")
        @Validation(required = true)
        public PutBucketEncryptionRequestBodyServerSideEncryptionRule serverSideEncryptionRule;

        public static PutBucketEncryptionRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketEncryptionRequestBody) TeaModel.build(map, new PutBucketEncryptionRequestBody());
        }

        public PutBucketEncryptionRequestBodyServerSideEncryptionRule getServerSideEncryptionRule() {
            return this.serverSideEncryptionRule;
        }

        public PutBucketEncryptionRequestBody setServerSideEncryptionRule(PutBucketEncryptionRequestBodyServerSideEncryptionRule putBucketEncryptionRequestBodyServerSideEncryptionRule) {
            this.serverSideEncryptionRule = putBucketEncryptionRequestBodyServerSideEncryptionRule;
            return this;
        }
    }

    public static class PutBucketEncryptionRequestBodyServerSideEncryptionRule extends TeaModel {

        @NameInMap("ApplyServerSideEncryptionByDefault")
        public PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault applyServerSideEncryptionByDefault;

        public static PutBucketEncryptionRequestBodyServerSideEncryptionRule build(Map<String, ?> map) throws Exception {
            return (PutBucketEncryptionRequestBodyServerSideEncryptionRule) TeaModel.build(map, new PutBucketEncryptionRequestBodyServerSideEncryptionRule());
        }

        public PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault getApplyServerSideEncryptionByDefault() {
            return this.applyServerSideEncryptionByDefault;
        }

        public PutBucketEncryptionRequestBodyServerSideEncryptionRule setApplyServerSideEncryptionByDefault(PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault putBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault) {
            this.applyServerSideEncryptionByDefault = putBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault;
            return this;
        }
    }

    public static class PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault extends TeaModel {

        @NameInMap("KMSMasterKeyID")
        public String kMSMasterKeyID;

        @NameInMap("SSEAlgorithm")
        public String sSEAlgorithm;

        public static PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault build(Map<String, ?> map) throws Exception {
            return (PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault) TeaModel.build(map, new PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault());
        }

        public String getKMSMasterKeyID() {
            return this.kMSMasterKeyID;
        }

        public String getSSEAlgorithm() {
            return this.sSEAlgorithm;
        }

        public PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault setKMSMasterKeyID(String str) {
            this.kMSMasterKeyID = str;
            return this;
        }

        public PutBucketEncryptionRequestBodyServerSideEncryptionRuleApplyServerSideEncryptionByDefault setSSEAlgorithm(String str) {
            this.sSEAlgorithm = str;
            return this;
        }
    }

    public static PutBucketEncryptionRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketEncryptionRequest) TeaModel.build(map, new PutBucketEncryptionRequest());
    }

    public PutBucketEncryptionRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketEncryptionRequest setBody(PutBucketEncryptionRequestBody putBucketEncryptionRequestBody) {
        this.body = putBucketEncryptionRequestBody;
        return this;
    }

    public PutBucketEncryptionRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
