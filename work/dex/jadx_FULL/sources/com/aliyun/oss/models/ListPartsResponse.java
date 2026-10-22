package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListPartsResponse extends TeaModel {

    @NameInMap("ListPartsResult")
    @Validation(required = true)
    public ListPartsResponseListPartsResult listPartsResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class ListPartsResponseListPartsResult extends TeaModel {

        @NameInMap("Bucket")
        public String bucket;

        @NameInMap("EncodingType")
        public String encodingType;

        @NameInMap("IsTruncated")
        public String isTruncated;

        @NameInMap("Key")
        public String key;

        @NameInMap("MaxParts")
        public String maxParts;

        @NameInMap("NextPartNumberMarker")
        public String nextPartNumberMarker;

        @NameInMap("Part")
        public List<ListPartsResponseListPartsResultPart> part;

        @NameInMap("PartNumberMarker")
        public String partNumberMarker;

        @NameInMap("UploadId")
        public String uploadId;

        public static ListPartsResponseListPartsResult build(Map<String, ?> map) throws Exception {
            return (ListPartsResponseListPartsResult) TeaModel.build(map, new ListPartsResponseListPartsResult());
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getIsTruncated() {
            return this.isTruncated;
        }

        public String getKey() {
            return this.key;
        }

        public String getMaxParts() {
            return this.maxParts;
        }

        public String getNextPartNumberMarker() {
            return this.nextPartNumberMarker;
        }

        public List<ListPartsResponseListPartsResultPart> getPart() {
            return this.part;
        }

        public String getPartNumberMarker() {
            return this.partNumberMarker;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public ListPartsResponseListPartsResult setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListPartsResponseListPartsResult setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListPartsResponseListPartsResult setIsTruncated(String str) {
            this.isTruncated = str;
            return this;
        }

        public ListPartsResponseListPartsResult setKey(String str) {
            this.key = str;
            return this;
        }

        public ListPartsResponseListPartsResult setMaxParts(String str) {
            this.maxParts = str;
            return this;
        }

        public ListPartsResponseListPartsResult setNextPartNumberMarker(String str) {
            this.nextPartNumberMarker = str;
            return this;
        }

        public ListPartsResponseListPartsResult setPart(List<ListPartsResponseListPartsResultPart> list) {
            this.part = list;
            return this;
        }

        public ListPartsResponseListPartsResult setPartNumberMarker(String str) {
            this.partNumberMarker = str;
            return this;
        }

        public ListPartsResponseListPartsResult setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static class ListPartsResponseListPartsResultPart extends TeaModel {

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("LastModified")
        public String lastModified;

        @NameInMap("PartNumber")
        public String partNumber;

        @NameInMap("Size")
        public String size;

        public static ListPartsResponseListPartsResultPart build(Map<String, ?> map) throws Exception {
            return (ListPartsResponseListPartsResultPart) TeaModel.build(map, new ListPartsResponseListPartsResultPart());
        }

        public String getETag() {
            return this.eTag;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public String getPartNumber() {
            return this.partNumber;
        }

        public String getSize() {
            return this.size;
        }

        public ListPartsResponseListPartsResultPart setETag(String str) {
            this.eTag = str;
            return this;
        }

        public ListPartsResponseListPartsResultPart setLastModified(String str) {
            this.lastModified = str;
            return this;
        }

        public ListPartsResponseListPartsResultPart setPartNumber(String str) {
            this.partNumber = str;
            return this;
        }

        public ListPartsResponseListPartsResultPart setSize(String str) {
            this.size = str;
            return this;
        }
    }

    public static ListPartsResponse build(Map<String, ?> map) throws Exception {
        return (ListPartsResponse) TeaModel.build(map, new ListPartsResponse());
    }

    public ListPartsResponseListPartsResult getListPartsResult() {
        return this.listPartsResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ListPartsResponse setListPartsResult(ListPartsResponseListPartsResult listPartsResponseListPartsResult) {
        this.listPartsResult = listPartsResponseListPartsResult;
        return this;
    }

    public ListPartsResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
