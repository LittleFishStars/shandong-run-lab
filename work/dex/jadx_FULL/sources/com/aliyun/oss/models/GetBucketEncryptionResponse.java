package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketEncryptionResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("ServerSideEncryptionRule")
    @Validation(required = true)
    public GetBucketEncryptionResponseServerSideEncryptionRule serverSideEncryptionRule;

    public static class GetBucketEncryptionResponseServerSideEncryptionRule extends TeaModel {

        @NameInMap("ApplyServerSideEncryptionByDefault")
        @Validation(required = true)
        public GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault applyServerSideEncryptionByDefault;

        public static GetBucketEncryptionResponseServerSideEncryptionRule build(Map<String, ?> map) throws Exception {
            return (GetBucketEncryptionResponseServerSideEncryptionRule) TeaModel.build(map, new GetBucketEncryptionResponseServerSideEncryptionRule());
        }

        public GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault getApplyServerSideEncryptionByDefault() {
            return this.applyServerSideEncryptionByDefault;
        }

        public GetBucketEncryptionResponseServerSideEncryptionRule setApplyServerSideEncryptionByDefault(GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault getBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault) {
            this.applyServerSideEncryptionByDefault = getBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault;
            return this;
        }
    }

    public static class GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault extends TeaModel {

        @NameInMap("KMSMasterKeyID")
        public String kMSMasterKeyID;

        @NameInMap("SSEAlgorithm")
        public String sSEAlgorithm;

        public static GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault build(Map<String, ?> map) throws Exception {
            return (GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault) TeaModel.build(map, new GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault());
        }

        public String getKMSMasterKeyID() {
            return this.kMSMasterKeyID;
        }

        public String getSSEAlgorithm() {
            return this.sSEAlgorithm;
        }

        public GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault setKMSMasterKeyID(String str) {
            this.kMSMasterKeyID = str;
            return this;
        }

        public GetBucketEncryptionResponseServerSideEncryptionRuleApplyServerSideEncryptionByDefault setSSEAlgorithm(String str) {
            this.sSEAlgorithm = str;
            return this;
        }
    }

    public static GetBucketEncryptionResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketEncryptionResponse) TeaModel.build(map, new GetBucketEncryptionResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketEncryptionResponseServerSideEncryptionRule getServerSideEncryptionRule() {
        return this.serverSideEncryptionRule;
    }

    public GetBucketEncryptionResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetBucketEncryptionResponse setServerSideEncryptionRule(GetBucketEncryptionResponseServerSideEncryptionRule getBucketEncryptionResponseServerSideEncryptionRule) {
        this.serverSideEncryptionRule = getBucketEncryptionResponseServerSideEncryptionRule;
        return this;
    }
}
