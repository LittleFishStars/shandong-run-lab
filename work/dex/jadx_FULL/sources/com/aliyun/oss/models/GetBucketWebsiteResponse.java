package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketWebsiteResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("WebsiteConfiguration")
    @Validation(required = true)
    public GetBucketWebsiteResponseWebsiteConfiguration websiteConfiguration;

    public static class GetBucketWebsiteResponseWebsiteConfiguration extends TeaModel {

        @NameInMap("ErrorDocument")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationErrorDocument errorDocument;

        @NameInMap("IndexDocument")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationIndexDocument indexDocument;

        @NameInMap("RoutingRules")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRules routingRules;

        public static GetBucketWebsiteResponseWebsiteConfiguration build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfiguration) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfiguration());
        }

        public GetBucketWebsiteResponseWebsiteConfigurationErrorDocument getErrorDocument() {
            return this.errorDocument;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationIndexDocument getIndexDocument() {
            return this.indexDocument;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRules getRoutingRules() {
            return this.routingRules;
        }

        public GetBucketWebsiteResponseWebsiteConfiguration setErrorDocument(GetBucketWebsiteResponseWebsiteConfigurationErrorDocument getBucketWebsiteResponseWebsiteConfigurationErrorDocument) {
            this.errorDocument = getBucketWebsiteResponseWebsiteConfigurationErrorDocument;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfiguration setIndexDocument(GetBucketWebsiteResponseWebsiteConfigurationIndexDocument getBucketWebsiteResponseWebsiteConfigurationIndexDocument) {
            this.indexDocument = getBucketWebsiteResponseWebsiteConfigurationIndexDocument;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfiguration setRoutingRules(GetBucketWebsiteResponseWebsiteConfigurationRoutingRules getBucketWebsiteResponseWebsiteConfigurationRoutingRules) {
            this.routingRules = getBucketWebsiteResponseWebsiteConfigurationRoutingRules;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationErrorDocument extends TeaModel {

        @NameInMap("Key")
        public String key;

        public static GetBucketWebsiteResponseWebsiteConfigurationErrorDocument build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationErrorDocument) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationErrorDocument());
        }

        public String getKey() {
            return this.key;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationErrorDocument setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationIndexDocument extends TeaModel {

        @NameInMap("Suffix")
        public String suffix;

        public static GetBucketWebsiteResponseWebsiteConfigurationIndexDocument build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationIndexDocument) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationIndexDocument());
        }

        public String getSuffix() {
            return this.suffix;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationIndexDocument setSuffix(String str) {
            this.suffix = str;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRules extends TeaModel {

        @NameInMap("RoutingRule")
        public List<GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule> routingRule;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRules build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRules) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRules());
        }

        public List<GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule> getRoutingRule() {
            return this.routingRule;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRules setRoutingRule(List<GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule> list) {
            this.routingRule = list;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule extends TeaModel {

        @NameInMap("Condition")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition condition;

        @NameInMap("Redirect")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect redirect;

        @NameInMap("RuleNumber")
        public Integer ruleNumber;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule());
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition getCondition() {
            return this.condition;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect getRedirect() {
            return this.redirect;
        }

        public Integer getRuleNumber() {
            return this.ruleNumber;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule setCondition(GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition) {
            this.condition = getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule setRedirect(GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect) {
            this.redirect = getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRule setRuleNumber(Integer num) {
            this.ruleNumber = num;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition extends TeaModel {

        @NameInMap("HttpErrorCodeReturnedEquals")
        public String httpErrorCodeReturnedEquals;

        @NameInMap("IncludeHeader")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader includeHeader;

        @NameInMap("KeyPrefixEquals")
        public String keyPrefixEquals;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition());
        }

        public String getHttpErrorCodeReturnedEquals() {
            return this.httpErrorCodeReturnedEquals;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader getIncludeHeader() {
            return this.includeHeader;
        }

        public String getKeyPrefixEquals() {
            return this.keyPrefixEquals;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition setHttpErrorCodeReturnedEquals(String str) {
            this.httpErrorCodeReturnedEquals = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition setIncludeHeader(GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader) {
            this.includeHeader = getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleCondition setKeyPrefixEquals(String str) {
            this.keyPrefixEquals = str;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader extends TeaModel {

        @NameInMap("Equals")
        public String equals;

        @NameInMap("Key")
        public String key;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader());
        }

        public String getEquals() {
            return this.equals;
        }

        public String getKey() {
            return this.key;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader setEquals(String str) {
            this.equals = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleConditionIncludeHeader setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect extends TeaModel {

        @NameInMap("HostName")
        public String hostName;

        @NameInMap("HttpRedirectCode")
        public String httpRedirectCode;

        @NameInMap("MirrorCheckMd5")
        public Boolean mirrorCheckMd5;

        @NameInMap("MirrorFollowRedirect")
        public Boolean mirrorFollowRedirect;

        @NameInMap("MirrorHeaders")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders mirrorHeaders;

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

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect());
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

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders getMirrorHeaders() {
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

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setHostName(String str) {
            this.hostName = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setHttpRedirectCode(String str) {
            this.httpRedirectCode = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorCheckMd5(Boolean bool) {
            this.mirrorCheckMd5 = bool;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorFollowRedirect(Boolean bool) {
            this.mirrorFollowRedirect = bool;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorHeaders(GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders) {
            this.mirrorHeaders = getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorPassQueryString(Boolean bool) {
            this.mirrorPassQueryString = bool;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setMirrorURL(String str) {
            this.mirrorURL = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setPassQueryString(Boolean bool) {
            this.passQueryString = bool;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setProtocol(String str) {
            this.protocol = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setRedirectType(String str) {
            this.redirectType = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setReplaceKeyPrefixWith(String str) {
            this.replaceKeyPrefixWith = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirect setReplaceKeyWith(String str) {
            this.replaceKeyWith = str;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders extends TeaModel {

        @NameInMap("Pass")
        public String pass;

        @NameInMap("PassAll")
        public Boolean passAll;

        @NameInMap("Remove")
        public String remove;

        @NameInMap("Set")
        @Validation(required = true)
        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet set;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders());
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

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet getSet() {
            return this.set;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setPass(String str) {
            this.pass = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setPassAll(Boolean bool) {
            this.passAll = bool;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setRemove(String str) {
            this.remove = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeaders setSet(GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet) {
            this.set = getBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet;
            return this;
        }
    }

    public static class GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet build(Map<String, ?> map) throws Exception {
            return (GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet) TeaModel.build(map, new GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet setKey(String str) {
            this.key = str;
            return this;
        }

        public GetBucketWebsiteResponseWebsiteConfigurationRoutingRulesRoutingRuleRedirectMirrorHeadersSet setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static GetBucketWebsiteResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketWebsiteResponse) TeaModel.build(map, new GetBucketWebsiteResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketWebsiteResponseWebsiteConfiguration getWebsiteConfiguration() {
        return this.websiteConfiguration;
    }

    public GetBucketWebsiteResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetBucketWebsiteResponse setWebsiteConfiguration(GetBucketWebsiteResponseWebsiteConfiguration getBucketWebsiteResponseWebsiteConfiguration) {
        this.websiteConfiguration = getBucketWebsiteResponseWebsiteConfiguration;
        return this;
    }
}
