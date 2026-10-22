package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketRequestPaymentRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketRequestPaymentRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketRequestPaymentRequestBody extends TeaModel {

        @NameInMap("RequestPaymentConfiguration")
        @Validation(required = true)
        public PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration requestPaymentConfiguration;

        public static PutBucketRequestPaymentRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketRequestPaymentRequestBody) TeaModel.build(map, new PutBucketRequestPaymentRequestBody());
        }

        public PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration getRequestPaymentConfiguration() {
            return this.requestPaymentConfiguration;
        }

        public PutBucketRequestPaymentRequestBody setRequestPaymentConfiguration(PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration putBucketRequestPaymentRequestBodyRequestPaymentConfiguration) {
            this.requestPaymentConfiguration = putBucketRequestPaymentRequestBodyRequestPaymentConfiguration;
            return this;
        }
    }

    public static class PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration extends TeaModel {

        @NameInMap("Payer")
        public String payer;

        public static PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration build(Map<String, ?> map) throws Exception {
            return (PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration) TeaModel.build(map, new PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration());
        }

        public String getPayer() {
            return this.payer;
        }

        public PutBucketRequestPaymentRequestBodyRequestPaymentConfiguration setPayer(String str) {
            this.payer = str;
            return this;
        }
    }

    public static PutBucketRequestPaymentRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketRequestPaymentRequest) TeaModel.build(map, new PutBucketRequestPaymentRequest());
    }

    public PutBucketRequestPaymentRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketRequestPaymentRequest setBody(PutBucketRequestPaymentRequestBody putBucketRequestPaymentRequestBody) {
        this.body = putBucketRequestPaymentRequestBody;
        return this;
    }

    public PutBucketRequestPaymentRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
