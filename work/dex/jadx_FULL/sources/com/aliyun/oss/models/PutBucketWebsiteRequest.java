package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketWebsiteRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketWebsiteRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketWebsiteRequestBody extends TeaModel {

        @NameInMap("WebsiteConfiguration")
        @Validation(required = true)
        public PutBucketWebsiteRequestBodyWebsiteConfiguration websiteConfiguration;

        public static PutBucketWebsiteRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBody) TeaModel.build(map, new PutBucketWebsiteRequestBody());
        }

        public PutBucketWebsiteRequestBodyWebsiteConfiguration getWebsiteConfiguration() {
            return this.websiteConfiguration;
        }

        public PutBucketWebsiteRequestBody setWebsiteConfiguration(PutBucketWebsiteRequestBodyWebsiteConfiguration putBucketWebsiteRequestBodyWebsiteConfiguration) {
            this.websiteConfiguration = putBucketWebsiteRequestBodyWebsiteConfiguration;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfiguration extends TeaModel {

        @NameInMap("ErrorDocument")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument errorDocument;

        @NameInMap("IndexDocument")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument indexDocument;

        @NameInMap("RoutingRules")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules routingRules;

        public static PutBucketWebsiteRequestBodyWebsiteConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfiguration) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfiguration());
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument getErrorDocument() {
            return this.errorDocument;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument getIndexDocument() {
            return this.indexDocument;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules getRoutingRules() {
            return this.routingRules;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfiguration setErrorDocument(PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument putBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument) {
            this.errorDocument = putBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfiguration setIndexDocument(PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument putBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument) {
            this.indexDocument = putBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfiguration setRoutingRules(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules) {
            this.routingRules = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument extends TeaModel {

        @NameInMap("Key")
        public String key;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument());
        }

        public String getKey() {
            return this.key;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationErrorDocument setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument extends TeaModel {

        @NameInMap("Suffix")
        public String suffix;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument());
        }

        public String getSuffix() {
            return this.suffix;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationIndexDocument setSuffix(String str) {
            this.suffix = str;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules extends TeaModel {

        @NameInMap("RoutingRule")
        public List<PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule> routingRule;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules());
        }

        public List<PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule> getRoutingRule() {
            return this.routingRule;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRules setRoutingRule(List<PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule> list) {
            this.routingRule = list;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule extends TeaModel {

        @NameInMap("Condition")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition condition;

        @NameInMap("Redirect")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect redirect;

        @NameInMap("RuleNumber")
        public Integer ruleNumber;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule());
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition getCondition() {
            return this.condition;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect getRedirect() {
            return this.redirect;
        }

        public Integer getRuleNumber() {
            return this.ruleNumber;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule setCondition(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition) {
            this.condition = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule setRedirect(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect) {
            this.redirect = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRule setRuleNumber(Integer num) {
            this.ruleNumber = num;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition extends TeaModel {

        @NameInMap("HttpErrorCodeReturnedEquals")
        public String httpErrorCodeReturnedEquals;

        @NameInMap("IncludeHeader")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader includeHeader;

        @NameInMap("KeyPrefixEquals")
        public String keyPrefixEquals;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition());
        }

        public String getHttpErrorCodeReturnedEquals() {
            return this.httpErrorCodeReturnedEquals;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader getIncludeHeader() {
            return this.includeHeader;
        }

        public String getKeyPrefixEquals() {
            return this.keyPrefixEquals;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition setHttpErrorCodeReturnedEquals(String str) {
            this.httpErrorCodeReturnedEquals = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition setIncludeHeader(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader) {
            this.includeHeader = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleCondition setKeyPrefixEquals(String str) {
            this.keyPrefixEquals = str;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader extends TeaModel {

        @NameInMap("Equals")
        public String equals;

        @NameInMap("Key")
        public String key;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader());
        }

        public String getEquals() {
            return this.equals;
        }

        public String getKey() {
            return this.key;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader setEquals(String str) {
            this.equals = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect extends TeaModel {

        @NameInMap("HostName")
        public String hostName;

        @NameInMap("HttpRedirectCode")
        public String httpRedirectCode;

        @NameInMap("MirrorCheckMd5")
        public Boolean mirrorCheckMd5;

        @NameInMap("MirrorFollowRedirect")
        public Boolean mirrorFollowRedirect;

        @NameInMap("MirrorHeaders")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders mirrorHeaders;

        @NameInMap("MirrorPassQueryString")
        public Boolean mirrorPassQueryString;

        @NameInMap("MirrorURL")
        public String mirrorURL;

        @NameInMap("PassQueryString")
        public Boolean passQueryString;

        @NameInMap("Protocol")
        public String protocol;

        @NameInMap("RedirectType")
        public String redirectType;

        @NameInMap("ReplaceKeyPrefixWith")
        public String replaceKeyPrefixWith;

        @NameInMap("ReplaceKeyWith")
        public String replaceKeyWith;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect());
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getHttpRedirectCode() {
            return this.httpRedirectCode;
        }

        public Boolean getMirrorCheckMd5() {
            return this.mirrorCheckMd5;
        }

        public Boolean getMirrorFollowRedirect() {
            return this.mirrorFollowRedirect;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders getMirrorHeaders() {
            return this.mirrorHeaders;
        }

        public Boolean getMirrorPassQueryString() {
            return this.mirrorPassQueryString;
        }

        public String getMirrorURL() {
            return this.mirrorURL;
        }

        public Boolean getPassQueryString() {
            return this.passQueryString;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public String getRedirectType() {
            return this.redirectType;
        }

        public String getReplaceKeyPrefixWith() {
            return this.replaceKeyPrefixWith;
        }

        public String getReplaceKeyWith() {
            return this.replaceKeyWith;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setHostName(String str) {
            this.hostName = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setHttpRedirectCode(String str) {
            this.httpRedirectCode = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorCheckMd5(Boolean bool) {
            this.mirrorCheckMd5 = bool;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorFollowRedirect(Boolean bool) {
            this.mirrorFollowRedirect = bool;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorHeaders(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders) {
            this.mirrorHeaders = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorPassQueryString(Boolean bool) {
            this.mirrorPassQueryString = bool;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorURL(String str) {
            this.mirrorURL = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setPassQueryString(Boolean bool) {
            this.passQueryString = bool;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setProtocol(String str) {
            this.protocol = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setRedirectType(String str) {
            this.redirectType = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setReplaceKeyPrefixWith(String str) {
            this.replaceKeyPrefixWith = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirect setReplaceKeyWith(String str) {
            this.replaceKeyWith = str;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders extends TeaModel {

        @NameInMap("Pass")
        public String pass;

        @NameInMap("PassAll")
        public Boolean passAll;

        @NameInMap("Remove")
        public String remove;

        @NameInMap("Set")
        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet set;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders());
        }

        public String getPass() {
            return this.pass;
        }

        public Boolean getPassAll() {
            return this.passAll;
        }

        public String getRemove() {
            return this.remove;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet getSet() {
            return this.set;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setPass(String str) {
            this.pass = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setPassAll(Boolean bool) {
            this.passAll = bool;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setRemove(String str) {
            this.remove = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setSet(PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet) {
            this.set = putBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet;
            return this;
        }
    }

    public static class PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet build(Map<String, ?> map) throws Exception {
            return (PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet) TeaModel.build(map, new PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet setKey(String str) {
            this.key = str;
            return this;
        }

        public PutBucketWebsiteRequestBodyWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static PutBucketWebsiteRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketWebsiteRequest) TeaModel.build(map, new PutBucketWebsiteRequest());
    }

    public PutBucketWebsiteRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketWebsiteRequest setBody(PutBucketWebsiteRequestBody putBucketWebsiteRequestBody) {
        this.body = putBucketWebsiteRequestBody;
        return this;
    }

    public PutBucketWebsiteRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
