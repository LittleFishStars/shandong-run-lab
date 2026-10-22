package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListMultipartUploadsRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    public ListMultipartUploadsRequestFilter filter;

    public static class ListMultipartUploadsRequestFilter extends TeaModel {

        @NameInMap("delimiter")
        public String delimiter;

        @NameInMap(RequestParameters.ENCODING_TYPE)
        public String encodingType;

        @NameInMap(RequestParameters.KEY_MARKER)
        public String keyMarker;

        @NameInMap(RequestParameters.MAX_UPLOADS)
        public String maxUploads;

        @NameInMap(RequestParameters.PREFIX)
        public String prefix;

        @NameInMap(RequestParameters.UPLOAD_ID_MARKER)
        public String uploadIdMarker;

        public static ListMultipartUploadsRequestFilter build(Map<String, ?> map) throws Exception {
            return (ListMultipartUploadsRequestFilter) TeaModel.build(map, new ListMultipartUploadsRequestFilter());
        }

        public String getDelimiter() {
            return this.delimiter;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getKeyMarker() {
            return this.keyMarker;
        }

        public String getMaxUploads() {
            return this.maxUploads;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getUploadIdMarker() {
            return this.uploadIdMarker;
        }

        public ListMultipartUploadsRequestFilter setDelimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListMultipartUploadsRequestFilter setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListMultipartUploadsRequestFilter setKeyMarker(String str) {
            this.keyMarker = str;
            return this;
        }

        public ListMultipartUploadsRequestFilter setMaxUploads(String str) {
            this.maxUploads = str;
            return this;
        }

        public ListMultipartUploadsRequestFilter setPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListMultipartUploadsRequestFilter setUploadIdMarker(String str) {
            this.uploadIdMarker = str;
            return this;
        }
    }

    public static ListMultipartUploadsRequest build(Map<String, ?> map) throws Exception {
        return (ListMultipartUploadsRequest) TeaModel.build(map, new ListMultipartUploadsRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public ListMultipartUploadsRequestFilter getFilter() {
        return this.filter;
    }

    public ListMultipartUploadsRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public ListMultipartUploadsRequest setFilter(ListMultipartUploadsRequestFilter listMultipartUploadsRequestFilter) {
        this.filter = listMultipartUploadsRequestFilter;
        return this;
    }
}
