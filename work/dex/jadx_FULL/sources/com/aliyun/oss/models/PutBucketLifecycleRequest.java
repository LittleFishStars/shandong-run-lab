package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketLifecycleRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketLifecycleRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketLifecycleRequestBody extends TeaModel {

        @NameInMap("LifecycleConfiguration")
        @Validation(required = true)
        public PutBucketLifecycleRequestBodyLifecycleConfiguration lifecycleConfiguration;

        public static PutBucketLifecycleRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBody) TeaModel.build(map, new PutBucketLifecycleRequestBody());
        }

        public PutBucketLifecycleRequestBodyLifecycleConfiguration getLifecycleConfiguration() {
            return this.lifecycleConfiguration;
        }

        public PutBucketLifecycleRequestBody setLifecycleConfiguration(PutBucketLifecycleRequestBodyLifecycleConfiguration putBucketLifecycleRequestBodyLifecycleConfiguration) {
            this.lifecycleConfiguration = putBucketLifecycleRequestBodyLifecycleConfiguration;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfiguration extends TeaModel {

        @NameInMap("Rule")
        public List<PutBucketLifecycleRequestBodyLifecycleConfigurationRule> rule;

        public static PutBucketLifecycleRequestBodyLifecycleConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfiguration) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfiguration());
        }

        public List<PutBucketLifecycleRequestBodyLifecycleConfigurationRule> getRule() {
            return this.rule;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfiguration setRule(List<PutBucketLifecycleRequestBodyLifecycleConfigurationRule> list) {
            this.rule = list;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfigurationRule extends TeaModel {

        @NameInMap("AbortMultipartUpload")
        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload abortMultipartUpload;

        @NameInMap("Expiration")
        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration expiration;

        @NameInMap("ID")
        public String iD;

        @NameInMap("Prefix")
        public String prefix;

        @NameInMap("Status")
        public String status;

        @NameInMap("Tag")
        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag tag;

        @NameInMap("Transition")
        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition transition;

        public static PutBucketLifecycleRequestBodyLifecycleConfigurationRule build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfigurationRule) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfigurationRule());
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload getAbortMultipartUpload() {
            return this.abortMultipartUpload;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration getExpiration() {
            return this.expiration;
        }

        public String getID() {
            return this.iD;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getStatus() {
            return this.status;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag getTag() {
            return this.tag;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition getTransition() {
            return this.transition;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setAbortMultipartUpload(PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload putBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload) {
            this.abortMultipartUpload = putBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setExpiration(PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration putBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration) {
            this.expiration = putBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setID(String str) {
            this.iD = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setStatus(String str) {
            this.status = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setTag(PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag putBucketLifecycleRequestBodyLifecycleConfigurationRuleTag) {
            this.tag = putBucketLifecycleRequestBodyLifecycleConfigurationRuleTag;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRule setTransition(PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition putBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition) {
            this.transition = putBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload extends TeaModel {

        @NameInMap("CreatedBeforeDate")
        public String createdBeforeDate;

        @NameInMap("Days")
        public Integer days;

        public static PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload());
        }

        public String getCreatedBeforeDate() {
            return this.createdBeforeDate;
        }

        public Integer getDays() {
            return this.days;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload setCreatedBeforeDate(String str) {
            this.createdBeforeDate = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleAbortMultipartUpload setDays(Integer num) {
            this.days = num;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration extends TeaModel {

        @NameInMap("CreatedBeforeDate")
        public String createdBeforeDate;

        @NameInMap("Days")
        public Integer days;

        public static PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration());
        }

        public String getCreatedBeforeDate() {
            return this.createdBeforeDate;
        }

        public Integer getDays() {
            return this.days;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration setCreatedBeforeDate(String str) {
            this.createdBeforeDate = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleExpiration setDays(Integer num) {
            this.days = num;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag setKey(String str) {
            this.key = str;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static class PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition extends TeaModel {

        @NameInMap("Days")
        public Integer days;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition build(Map<String, ?> map) throws Exception {
            return (PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition) TeaModel.build(map, new PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition());
        }

        public Integer getDays() {
            return this.days;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition setDays(Integer num) {
            this.days = num;
            return this;
        }

        public PutBucketLifecycleRequestBodyLifecycleConfigurationRuleTransition setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static PutBucketLifecycleRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketLifecycleRequest) TeaModel.build(map, new PutBucketLifecycleRequest());
    }

    public PutBucketLifecycleRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketLifecycleRequest setBody(PutBucketLifecycleRequestBody putBucketLifecycleRequestBody) {
        this.body = putBucketLifecycleRequestBody;
        return this;
    }

    public PutBucketLifecycleRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
