package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketRequestPaymentResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("RequestPaymentConfiguration")
    @Validation(required = true)
    public GetBucketRequestPaymentResponseRequestPaymentConfiguration requestPaymentConfiguration;

    public static class GetBucketRequestPaymentResponseRequestPaymentConfiguration extends TeaModel {

        @NameInMap("Payer")
        public String payer;

        public static GetBucketRequestPaymentResponseRequestPaymentConfiguration build(Map<String, ?> map) throws Exception {
            return (GetBucketRequestPaymentResponseRequestPaymentConfiguration) TeaModel.build(map, new GetBucketRequestPaymentResponseRequestPaymentConfiguration());
        }

        public String getPayer() {
            return this.payer;
        }

        public GetBucketRequestPaymentResponseRequestPaymentConfiguration setPayer(String str) {
            this.payer = str;
            return this;
        }
    }

    public static GetBucketRequestPaymentResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketRequestPaymentResponse) TeaModel.build(map, new GetBucketRequestPaymentResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketRequestPaymentResponseRequestPaymentConfiguration getRequestPaymentConfiguration() {
        return this.requestPaymentConfiguration;
    }

    public GetBucketRequestPaymentResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetBucketRequestPaymentResponse setRequestPaymentConfiguration(GetBucketRequestPaymentResponseRequestPaymentConfiguration getBucketRequestPaymentResponseRequestPaymentConfiguration) {
        this.requestPaymentConfiguration = getBucketRequestPaymentResponseRequestPaymentConfiguration;
        return this;
    }
}
