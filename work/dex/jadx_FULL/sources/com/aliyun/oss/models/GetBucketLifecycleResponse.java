package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketLifecycleResponse extends TeaModel {

    @NameInMap("LifecycleConfiguration")
    @Validation(required = true)
    public GetBucketLifecycleResponseLifecycleConfiguration lifecycleConfiguration;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketLifecycleResponseLifecycleConfiguration extends TeaModel {

        @NameInMap("Rule")
        public List<GetBucketLifecycleResponseLifecycleConfigurationRule> rule;

        public static GetBucketLifecycleResponseLifecycleConfiguration build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfiguration) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfiguration());
        }

        public List<GetBucketLifecycleResponseLifecycleConfigurationRule> getRule() {
            return this.rule;
        }

        public GetBucketLifecycleResponseLifecycleConfiguration setRule(List<GetBucketLifecycleResponseLifecycleConfigurationRule> list) {
            this.rule = list;
            return this;
        }
    }

    public static class GetBucketLifecycleResponseLifecycleConfigurationRule extends TeaModel {

        @NameInMap("AbortMultipartUpload")
        @Validation(required = true)
        public GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload abortMultipartUpload;

        @NameInMap("Expiration")
        @Validation(required = true)
        public GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration expiration;

        @NameInMap("ID")
        public String iD;

        @NameInMap("Prefix")
        public String prefix;

        @NameInMap("Status")
        public String status;

        @NameInMap("Tag")
        @Validation(required = true)
        public GetBucketLifecycleResponseLifecycleConfigurationRuleTag tag;

        @NameInMap("Transition")
        @Validation(required = true)
        public GetBucketLifecycleResponseLifecycleConfigurationRuleTransition transition;

        public static GetBucketLifecycleResponseLifecycleConfigurationRule build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfigurationRule) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfigurationRule());
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload getAbortMultipartUpload() {
            return this.abortMultipartUpload;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration getExpiration() {
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

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTag getTag() {
            return this.tag;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTransition getTransition() {
            return this.transition;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setAbortMultipartUpload(GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload getBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload) {
            this.abortMultipartUpload = getBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setExpiration(GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration getBucketLifecycleResponseLifecycleConfigurationRuleExpiration) {
            this.expiration = getBucketLifecycleResponseLifecycleConfigurationRuleExpiration;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setID(String str) {
            this.iD = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setStatus(String str) {
            this.status = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setTag(GetBucketLifecycleResponseLifecycleConfigurationRuleTag getBucketLifecycleResponseLifecycleConfigurationRuleTag) {
            this.tag = getBucketLifecycleResponseLifecycleConfigurationRuleTag;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRule setTransition(GetBucketLifecycleResponseLifecycleConfigurationRuleTransition getBucketLifecycleResponseLifecycleConfigurationRuleTransition) {
            this.transition = getBucketLifecycleResponseLifecycleConfigurationRuleTransition;
            return this;
        }
    }

    public static class GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload extends TeaModel {

        @NameInMap("CreatedBeforeDate")
        public String createdBeforeDate;

        @NameInMap("Days")
        public Integer days;

        public static GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload());
        }

        public String getCreatedBeforeDate() {
            return this.createdBeforeDate;
        }

        public Integer getDays() {
            return this.days;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload setCreatedBeforeDate(String str) {
            this.createdBeforeDate = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleAbortMultipartUpload setDays(Integer num) {
            this.days = num;
            return this;
        }
    }

    public static class GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration extends TeaModel {

        @NameInMap("CreatedBeforeDate")
        public String createdBeforeDate;

        @NameInMap("Days")
        public Integer days;

        public static GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration());
        }

        public String getCreatedBeforeDate() {
            return this.createdBeforeDate;
        }

        public Integer getDays() {
            return this.days;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration setCreatedBeforeDate(String str) {
            this.createdBeforeDate = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleExpiration setDays(Integer num) {
            this.days = num;
            return this;
        }
    }

    public static class GetBucketLifecycleResponseLifecycleConfigurationRuleTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static GetBucketLifecycleResponseLifecycleConfigurationRuleTag build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfigurationRuleTag) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfigurationRuleTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTag setKey(String str) {
            this.key = str;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static class GetBucketLifecycleResponseLifecycleConfigurationRuleTransition extends TeaModel {

        @NameInMap("Days")
        public Integer days;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static GetBucketLifecycleResponseLifecycleConfigurationRuleTransition build(Map<String, ?> map) throws Exception {
            return (GetBucketLifecycleResponseLifecycleConfigurationRuleTransition) TeaModel.build(map, new GetBucketLifecycleResponseLifecycleConfigurationRuleTransition());
        }

        public Integer getDays() {
            return this.days;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTransition setDays(Integer num) {
            this.days = num;
            return this;
        }

        public GetBucketLifecycleResponseLifecycleConfigurationRuleTransition setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static GetBucketLifecycleResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketLifecycleResponse) TeaModel.build(map, new GetBucketLifecycleResponse());
    }

    public GetBucketLifecycleResponseLifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketLifecycleResponse setLifecycleConfiguration(GetBucketLifecycleResponseLifecycleConfiguration getBucketLifecycleResponseLifecycleConfiguration) {
        this.lifecycleConfiguration = getBucketLifecycleResponseLifecycleConfiguration;
        return this;
    }

    public GetBucketLifecycleResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
