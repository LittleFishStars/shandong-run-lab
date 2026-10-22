package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketCORSResponse extends TeaModel {

    @NameInMap("CORSConfiguration")
    @Validation(required = true)
    public GetBucketCORSResponseCORSConfiguration cORSConfiguration;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketCORSResponseCORSConfiguration extends TeaModel {

        @NameInMap("CORSRule")
        public List<GetBucketCORSResponseCORSConfigurationCORSRule> cORSRule;

        public static GetBucketCORSResponseCORSConfiguration build(Map<String, ?> map) throws Exception {
            return (GetBucketCORSResponseCORSConfiguration) TeaModel.build(map, new GetBucketCORSResponseCORSConfiguration());
        }

        public List<GetBucketCORSResponseCORSConfigurationCORSRule> getCORSRule() {
            return this.cORSRule;
        }

        public GetBucketCORSResponseCORSConfiguration setCORSRule(List<GetBucketCORSResponseCORSConfigurationCORSRule> list) {
            this.cORSRule = list;
            return this;
        }
    }

    public static class GetBucketCORSResponseCORSConfigurationCORSRule extends TeaModel {

        @NameInMap("MaxAgeSeconds")
        public String maxAgeSeconds;

        public static GetBucketCORSResponseCORSConfigurationCORSRule build(Map<String, ?> map) throws Exception {
            return (GetBucketCORSResponseCORSConfigurationCORSRule) TeaModel.build(map, new GetBucketCORSResponseCORSConfigurationCORSRule());
        }

        public String getMaxAgeSeconds() {
            return this.maxAgeSeconds;
        }

        public GetBucketCORSResponseCORSConfigurationCORSRule setMaxAgeSeconds(String str) {
            this.maxAgeSeconds = str;
            return this;
        }
    }

    public static GetBucketCORSResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketCORSResponse) TeaModel.build(map, new GetBucketCORSResponse());
    }

    public GetBucketCORSResponseCORSConfiguration getCORSConfiguration() {
        return this.cORSConfiguration;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketCORSResponse setCORSConfiguration(GetBucketCORSResponseCORSConfiguration getBucketCORSResponseCORSConfiguration) {
        this.cORSConfiguration = getBucketCORSResponseCORSConfiguration;
        return this;
    }

    public GetBucketCORSResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
