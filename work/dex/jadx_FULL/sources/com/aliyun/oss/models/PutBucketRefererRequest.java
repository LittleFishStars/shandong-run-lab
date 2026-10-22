package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketRefererRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketRefererRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketRefererRequestBody extends TeaModel {

        @NameInMap("RefererConfiguration")
        @Validation(required = true)
        public PutBucketRefererRequestBodyRefererConfiguration refererConfiguration;

        public static PutBucketRefererRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketRefererRequestBody) TeaModel.build(map, new PutBucketRefererRequestBody());
        }

        public PutBucketRefererRequestBodyRefererConfiguration getRefererConfiguration() {
            return this.refererConfiguration;
        }

        public PutBucketRefererRequestBody setRefererConfiguration(PutBucketRefererRequestBodyRefererConfiguration putBucketRefererRequestBodyRefererConfiguration) {
            this.refererConfiguration = putBucketRefererRequestBodyRefererConfiguration;
            return this;
        }
    }

    public static class PutBucketRefererRequestBodyRefererConfiguration extends TeaModel {

        @NameInMap("AllowEmptyReferer")
        public Boolean allowEmptyReferer;

        @NameInMap("RefererList")
        public PutBucketRefererRequestBodyRefererConfigurationRefererList refererList;

        public static PutBucketRefererRequestBodyRefererConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketRefererRequestBodyRefererConfiguration) TeaModel.build(map, new PutBucketRefererRequestBodyRefererConfiguration());
        }

        public Boolean getAllowEmptyReferer() {
            return this.allowEmptyReferer;
        }

        public PutBucketRefererRequestBodyRefererConfigurationRefererList getRefererList() {
            return this.refererList;
        }

        public PutBucketRefererRequestBodyRefererConfiguration setAllowEmptyReferer(Boolean bool) {
            this.allowEmptyReferer = bool;
            return this;
        }

        public PutBucketRefererRequestBodyRefererConfiguration setRefererList(PutBucketRefererRequestBodyRefererConfigurationRefererList putBucketRefererRequestBodyRefererConfigurationRefererList) {
            this.refererList = putBucketRefererRequestBodyRefererConfigurationRefererList;
            return this;
        }
    }

    public static class PutBucketRefererRequestBodyRefererConfigurationRefererList extends TeaModel {

        @NameInMap("Referer")
        public List<String> referer;

        public static PutBucketRefererRequestBodyRefererConfigurationRefererList build(Map<String, ?> map) throws Exception {
            return (PutBucketRefererRequestBodyRefererConfigurationRefererList) TeaModel.build(map, new PutBucketRefererRequestBodyRefererConfigurationRefererList());
        }

        public List<String> getReferer() {
            return this.referer;
        }

        public PutBucketRefererRequestBodyRefererConfigurationRefererList setReferer(List<String> list) {
            this.referer = list;
            return this;
        }
    }

    public static PutBucketRefererRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketRefererRequest) TeaModel.build(map, new PutBucketRefererRequest());
    }

    public PutBucketRefererRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketRefererRequest setBody(PutBucketRefererRequestBody putBucketRefererRequestBody) {
        this.body = putBucketRefererRequestBody;
        return this;
    }

    public PutBucketRefererRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
