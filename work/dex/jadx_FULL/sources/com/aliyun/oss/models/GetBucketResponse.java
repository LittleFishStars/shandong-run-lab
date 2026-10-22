package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketResponse extends TeaModel {

    @NameInMap("ListBucketResult")
    @Validation(required = true)
    public GetBucketResponseListBucketResult listBucketResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketResponseListBucketResult extends TeaModel {

        @NameInMap("CommonPrefixes")
        public String commonPrefixes;

        @NameInMap("Contents")
        public List<GetBucketResponseListBucketResultContents> contents;

        @NameInMap("Delimiter")
        public String delimiter;

        @NameInMap("EncodingType")
        public String encodingType;

        @NameInMap("IsTruncated")
        public String isTruncated;

        @NameInMap("Marker")
        public String marker;

        @NameInMap("MaxKeys")
        public String maxKeys;

        @NameInMap("Name")
        public String name;

        @NameInMap("Prefix")
        public String prefix;

        public static GetBucketResponseListBucketResult build(Map<String, ?> map) throws Exception {
            return (GetBucketResponseListBucketResult) TeaModel.build(map, new GetBucketResponseListBucketResult());
        }

        public String getCommonPrefixes() {
            return this.commonPrefixes;
        }

        public List<GetBucketResponseListBucketResultContents> getContents() {
            return this.contents;
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

        public String getMarker() {
            return this.marker;
        }

        public String getMaxKeys() {
            return this.maxKeys;
        }

        public String getName() {
            return this.name;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public GetBucketResponseListBucketResult setCommonPrefixes(String str) {
            this.commonPrefixes = str;
            return this;
        }

        public GetBucketResponseListBucketResult setContents(List<GetBucketResponseListBucketResultContents> list) {
            this.contents = list;
            return this;
        }

        public GetBucketResponseListBucketResult setDelimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public GetBucketResponseListBucketResult setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public GetBucketResponseListBucketResult setIsTruncated(String str) {
            this.isTruncated = str;
            return this;
        }

        public GetBucketResponseListBucketResult setMarker(String str) {
            this.marker = str;
            return this;
        }

        public GetBucketResponseListBucketResult setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public GetBucketResponseListBucketResult setName(String str) {
            this.name = str;
            return this;
        }

        public GetBucketResponseListBucketResult setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static class GetBucketResponseListBucketResultContents extends TeaModel {

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("Key")
        public String key;

        @NameInMap("LastModified")
        public String lastModified;

        @NameInMap("Owner")
        @Validation(required = true)
        public GetBucketResponseListBucketResultContentsOwner owner;

        @NameInMap("Size")
        public String size;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static GetBucketResponseListBucketResultContents build(Map<String, ?> map) throws Exception {
            return (GetBucketResponseListBucketResultContents) TeaModel.build(map, new GetBucketResponseListBucketResultContents());
        }

        public String getETag() {
            return this.eTag;
        }

        public String getKey() {
            return this.key;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public GetBucketResponseListBucketResultContentsOwner getOwner() {
            return this.owner;
        }

        public String getSize() {
            return this.size;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public GetBucketResponseListBucketResultContents setETag(String str) {
            this.eTag = str;
            return this;
        }

        public GetBucketResponseListBucketResultContents setKey(String str) {
            this.key = str;
            return this;
        }

        public GetBucketResponseListBucketResultContents setLastModified(String str) {
            this.lastModified = str;
            return this;
        }

        public GetBucketResponseListBucketResultContents setOwner(GetBucketResponseListBucketResultContentsOwner getBucketResponseListBucketResultContentsOwner) {
            this.owner = getBucketResponseListBucketResultContentsOwner;
            return this;
        }

        public GetBucketResponseListBucketResultContents setSize(String str) {
            this.size = str;
            return this;
        }

        public GetBucketResponseListBucketResultContents setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static class GetBucketResponseListBucketResultContentsOwner extends TeaModel {

        @NameInMap("DisplayName")
        public String displayName;

        @NameInMap("ID")
        public String iD;

        public static GetBucketResponseListBucketResultContentsOwner build(Map<String, ?> map) throws Exception {
            return (GetBucketResponseListBucketResultContentsOwner) TeaModel.build(map, new GetBucketResponseListBucketResultContentsOwner());
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getID() {
            return this.iD;
        }

        public GetBucketResponseListBucketResultContentsOwner setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public GetBucketResponseListBucketResultContentsOwner setID(String str) {
            this.iD = str;
            return this;
        }
    }

    public static GetBucketResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketResponse) TeaModel.build(map, new GetBucketResponse());
    }

    public GetBucketResponseListBucketResult getListBucketResult() {
        return this.listBucketResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketResponse setListBucketResult(GetBucketResponseListBucketResult getBucketResponseListBucketResult) {
        this.listBucketResult = getBucketResponseListBucketResult;
        return this;
    }

    public GetBucketResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
