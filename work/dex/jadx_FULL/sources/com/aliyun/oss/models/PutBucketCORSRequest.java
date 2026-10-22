package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketCORSRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketCORSRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketCORSRequestBody extends TeaModel {

        @NameInMap("CORSConfiguration")
        @Validation(required = true)
        public PutBucketCORSRequestBodyCORSConfiguration cORSConfiguration;

        public static PutBucketCORSRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketCORSRequestBody) TeaModel.build(map, new PutBucketCORSRequestBody());
        }

        public PutBucketCORSRequestBodyCORSConfiguration getCORSConfiguration() {
            return this.cORSConfiguration;
        }

        public PutBucketCORSRequestBody setCORSConfiguration(PutBucketCORSRequestBodyCORSConfiguration putBucketCORSRequestBodyCORSConfiguration) {
            this.cORSConfiguration = putBucketCORSRequestBodyCORSConfiguration;
            return this;
        }
    }

    public static class PutBucketCORSRequestBodyCORSConfiguration extends TeaModel {

        @NameInMap("CORSRule")
        public List<PutBucketCORSRequestBodyCORSConfigurationCORSRule> cORSRule;

        public static PutBucketCORSRequestBodyCORSConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketCORSRequestBodyCORSConfiguration) TeaModel.build(map, new PutBucketCORSRequestBodyCORSConfiguration());
        }

        public List<PutBucketCORSRequestBodyCORSConfigurationCORSRule> getCORSRule() {
            return this.cORSRule;
        }

        public PutBucketCORSRequestBodyCORSConfiguration setCORSRule(List<PutBucketCORSRequestBodyCORSConfigurationCORSRule> list) {
            this.cORSRule = list;
            return this;
        }
    }

    public static class PutBucketCORSRequestBodyCORSConfigurationCORSRule extends TeaModel {

        @NameInMap("AllowedHeader")
        public List<String> allowedHeader;

        @NameInMap("AllowedMethod")
        public List<String> allowedMethod;

        @NameInMap("AllowedOrigin")
        public List<String> allowedOrigin;

        @NameInMap("ExposeHeader")
        public List<String> exposeHeader;

        @NameInMap("MaxAgeSeconds")
        public String maxAgeSeconds;

        public static PutBucketCORSRequestBodyCORSConfigurationCORSRule build(Map<String, ?> map) throws Exception {
            return (PutBucketCORSRequestBodyCORSConfigurationCORSRule) TeaModel.build(map, new PutBucketCORSRequestBodyCORSConfigurationCORSRule());
        }

        public List<String> getAllowedHeader() {
            return this.allowedHeader;
        }

        public List<String> getAllowedMethod() {
            return this.allowedMethod;
        }

        public List<String> getAllowedOrigin() {
            return this.allowedOrigin;
        }

        public List<String> getExposeHeader() {
            return this.exposeHeader;
        }

        public String getMaxAgeSeconds() {
            return this.maxAgeSeconds;
        }

        public PutBucketCORSRequestBodyCORSConfigurationCORSRule setAllowedHeader(List<String> list) {
            this.allowedHeader = list;
            return this;
        }

        public PutBucketCORSRequestBodyCORSConfigurationCORSRule setAllowedMethod(List<String> list) {
            this.allowedMethod = list;
            return this;
        }

        public PutBucketCORSRequestBodyCORSConfigurationCORSRule setAllowedOrigin(List<String> list) {
            this.allowedOrigin = list;
            return this;
        }

        public PutBucketCORSRequestBodyCORSConfigurationCORSRule setExposeHeader(List<String> list) {
            this.exposeHeader = list;
            return this;
        }

        public PutBucketCORSRequestBodyCORSConfigurationCORSRule setMaxAgeSeconds(String str) {
            this.maxAgeSeconds = str;
            return this;
        }
    }

    public static PutBucketCORSRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketCORSRequest) TeaModel.build(map, new PutBucketCORSRequest());
    }

    public PutBucketCORSRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketCORSRequest setBody(PutBucketCORSRequestBody putBucketCORSRequestBody) {
        this.body = putBucketCORSRequestBody;
        return this;
    }

    public PutBucketCORSRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
