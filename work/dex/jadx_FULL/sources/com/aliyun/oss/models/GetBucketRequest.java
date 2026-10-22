package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    public GetBucketRequestFilter filter;

    public static class GetBucketRequestFilter extends TeaModel {

        @NameInMap("delimiter")
        public String delimiter;

        @NameInMap(RequestParameters.ENCODING_TYPE)
        public String encodingType;

        @NameInMap(RequestParameters.MARKER)
        public String marker;

        @NameInMap(RequestParameters.MAX_KEYS)
        public String maxKeys;

        @NameInMap(RequestParameters.PREFIX)
        public String prefix;

        public static GetBucketRequestFilter build(Map<String, ?> map) throws Exception {
            return (GetBucketRequestFilter) TeaModel.build(map, new GetBucketRequestFilter());
        }

        public String getDelimiter() {
            return this.delimiter;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getMarker() {
            return this.marker;
        }

        public String getMaxKeys() {
            return this.maxKeys;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public GetBucketRequestFilter setDelimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public GetBucketRequestFilter setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public GetBucketRequestFilter setMarker(String str) {
            this.marker = str;
            return this;
        }

        public GetBucketRequestFilter setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public GetBucketRequestFilter setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static GetBucketRequest build(Map<String, ?> map) throws Exception {
        return (GetBucketRequest) TeaModel.build(map, new GetBucketRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public GetBucketRequestFilter getFilter() {
        return this.filter;
    }

    public GetBucketRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetBucketRequest setFilter(GetBucketRequestFilter getBucketRequestFilter) {
        this.filter = getBucketRequestFilter;
        return this;
    }
}
