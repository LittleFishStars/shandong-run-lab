package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListPartsRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public ListPartsRequestFilter filter;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class ListPartsRequestFilter extends TeaModel {

        @NameInMap("Encoding-type")
        public String encodingType;

        @NameInMap(RequestParameters.MAX_PARTS)
        public Integer maxParts;

        @NameInMap(RequestParameters.PART_NUMBER_MARKER)
        public Integer partNumberMarker;

        @NameInMap(RequestParameters.UPLOAD_ID)
        @Validation(required = true)
        public String uploadId;

        public static ListPartsRequestFilter build(Map<String, ?> map) throws Exception {
            return (ListPartsRequestFilter) TeaModel.build(map, new ListPartsRequestFilter());
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public Integer getMaxParts() {
            return this.maxParts;
        }

        public Integer getPartNumberMarker() {
            return this.partNumberMarker;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public ListPartsRequestFilter setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListPartsRequestFilter setMaxParts(Integer num) {
            this.maxParts = num;
            return this;
        }

        public ListPartsRequestFilter setPartNumberMarker(Integer num) {
            this.partNumberMarker = num;
            return this;
        }

        public ListPartsRequestFilter setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static ListPartsRequest build(Map<String, ?> map) throws Exception {
        return (ListPartsRequest) TeaModel.build(map, new ListPartsRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public ListPartsRequestFilter getFilter() {
        return this.filter;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public ListPartsRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public ListPartsRequest setFilter(ListPartsRequestFilter listPartsRequestFilter) {
        this.filter = listPartsRequestFilter;
        return this;
    }

    public ListPartsRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
