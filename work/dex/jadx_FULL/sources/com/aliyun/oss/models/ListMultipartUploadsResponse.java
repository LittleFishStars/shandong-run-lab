package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListMultipartUploadsResponse extends TeaModel {

    @NameInMap("ListMultipartUploadsResult")
    @Validation(required = true)
    public ListMultipartUploadsResponseListMultipartUploadsResult listMultipartUploadsResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class ListMultipartUploadsResponseListMultipartUploadsResult extends TeaModel {

        @NameInMap("Bucket")
        public String bucket;

        @NameInMap("Delimiter")
        public String delimiter;

        @NameInMap("EncodingType")
        public String encodingType;

        @NameInMap("IsTruncated")
        public String isTruncated;

        @NameInMap("KeyMarker")
        public String keyMarker;

        @NameInMap("MaxUploads")
        public String maxUploads;

        @NameInMap("NextKeyMarker")
        public String nextKeyMarker;

        @NameInMap("NextUploadIdMarker")
        public String nextUploadIdMarker;

        @NameInMap("Upload")
        public List<ListMultipartUploadsResponseListMultipartUploadsResultUpload> upload;

        @NameInMap("UploadIdMarker")
        public String uploadIdMarker;

        public static ListMultipartUploadsResponseListMultipartUploadsResult build(Map<String, ?> map) throws Exception {
            return (ListMultipartUploadsResponseListMultipartUploadsResult) TeaModel.build(map, new ListMultipartUploadsResponseListMultipartUploadsResult());
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getDelimiter() {
            return this.delimiter;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getIsTruncated() {
            return this.isTruncated;
        }

        public String getKeyMarker() {
            return this.keyMarker;
        }

        public String getMaxUploads() {
            return this.maxUploads;
        }

        public String getNextKeyMarker() {
            return this.nextKeyMarker;
        }

        public String getNextUploadIdMarker() {
            return this.nextUploadIdMarker;
        }

        public List<ListMultipartUploadsResponseListMultipartUploadsResultUpload> getUpload() {
            return this.upload;
        }

        public String getUploadIdMarker() {
            return this.uploadIdMarker;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setDelimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setIsTruncated(String str) {
            this.isTruncated = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setKeyMarker(String str) {
            this.keyMarker = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setMaxUploads(String str) {
            this.maxUploads = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setNextKeyMarker(String str) {
            this.nextKeyMarker = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setNextUploadIdMarker(String str) {
            this.nextUploadIdMarker = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setUpload(List<ListMultipartUploadsResponseListMultipartUploadsResultUpload> list) {
            this.upload = list;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResult setUploadIdMarker(String str) {
            this.uploadIdMarker = str;
            return this;
        }
    }

    public static class ListMultipartUploadsResponseListMultipartUploadsResultUpload extends TeaModel {

        @NameInMap("Initiated")
        public String initiated;

        @NameInMap("Key")
        public String key;

        @NameInMap("UploadId")
        public String uploadId;

        public static ListMultipartUploadsResponseListMultipartUploadsResultUpload build(Map<String, ?> map) throws Exception {
            return (ListMultipartUploadsResponseListMultipartUploadsResultUpload) TeaModel.build(map, new ListMultipartUploadsResponseListMultipartUploadsResultUpload());
        }

        public String getInitiated() {
            return this.initiated;
        }

        public String getKey() {
            return this.key;
        }

        public String getUploadId() {
            return this.uploadId;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResultUpload setInitiated(String str) {
            this.initiated = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResultUpload setKey(String str) {
            this.key = str;
            return this;
        }

        public ListMultipartUploadsResponseListMultipartUploadsResultUpload setUploadId(String str) {
            this.uploadId = str;
            return this;
        }
    }

    public static ListMultipartUploadsResponse build(Map<String, ?> map) throws Exception {
        return (ListMultipartUploadsResponse) TeaModel.build(map, new ListMultipartUploadsResponse());
    }

    public ListMultipartUploadsResponseListMultipartUploadsResult getListMultipartUploadsResult() {
        return this.listMultipartUploadsResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ListMultipartUploadsResponse setListMultipartUploadsResult(ListMultipartUploadsResponseListMultipartUploadsResult listMultipartUploadsResponseListMultipartUploadsResult) {
        this.listMultipartUploadsResult = listMultipartUploadsResponseListMultipartUploadsResult;
        return this;
    }

    public ListMultipartUploadsResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
