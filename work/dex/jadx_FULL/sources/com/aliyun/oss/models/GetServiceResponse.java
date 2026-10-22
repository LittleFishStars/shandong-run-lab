package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetServiceResponse extends TeaModel {

    @NameInMap("ListAllMyBucketsResult")
    @Validation(required = true)
    public GetServiceResponseListAllMyBucketsResult listAllMyBucketsResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetServiceResponseListAllMyBucketsResult extends TeaModel {

        @NameInMap("Buckets")
        @Validation(required = true)
        public GetServiceResponseListAllMyBucketsResultBuckets buckets;

        @NameInMap("IsTruncated")
        public String isTruncated;

        @NameInMap("Marker")
        public String marker;

        @NameInMap("MaxKeys")
        public String maxKeys;

        @NameInMap("NextMarker")
        public String nextMarker;

        @NameInMap("Owner")
        @Validation(required = true)
        public GetServiceResponseListAllMyBucketsResultOwner owner;

        @NameInMap("Prefix")
        public String prefix;

        public static GetServiceResponseListAllMyBucketsResult build(Map<String, ?> map) throws Exception {
            return (GetServiceResponseListAllMyBucketsResult) TeaModel.build(map, new GetServiceResponseListAllMyBucketsResult());
        }

        public GetServiceResponseListAllMyBucketsResultBuckets getBuckets() {
            return this.buckets;
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

        public String getNextMarker() {
            return this.nextMarker;
        }

        public GetServiceResponseListAllMyBucketsResultOwner getOwner() {
            return this.owner;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public GetServiceResponseListAllMyBucketsResult setBuckets(GetServiceResponseListAllMyBucketsResultBuckets getServiceResponseListAllMyBucketsResultBuckets) {
            this.buckets = getServiceResponseListAllMyBucketsResultBuckets;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setIsTruncated(String str) {
            this.isTruncated = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setMarker(String str) {
            this.marker = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setNextMarker(String str) {
            this.nextMarker = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setOwner(GetServiceResponseListAllMyBucketsResultOwner getServiceResponseListAllMyBucketsResultOwner) {
            this.owner = getServiceResponseListAllMyBucketsResultOwner;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResult setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static class GetServiceResponseListAllMyBucketsResultBuckets extends TeaModel {

        @NameInMap("Bucket")
        public List<GetServiceResponseListAllMyBucketsResultBucketsBucket> bucket;

        public static GetServiceResponseListAllMyBucketsResultBuckets build(Map<String, ?> map) throws Exception {
            return (GetServiceResponseListAllMyBucketsResultBuckets) TeaModel.build(map, new GetServiceResponseListAllMyBucketsResultBuckets());
        }

        public List<GetServiceResponseListAllMyBucketsResultBucketsBucket> getBucket() {
            return this.bucket;
        }

        public GetServiceResponseListAllMyBucketsResultBuckets setBucket(List<GetServiceResponseListAllMyBucketsResultBucketsBucket> list) {
            this.bucket = list;
            return this;
        }
    }

    public static class GetServiceResponseListAllMyBucketsResultBucketsBucket extends TeaModel {

        @NameInMap("CreateDate")
        public String createDate;

        @NameInMap("ExtranetEndpoint")
        public String extranetEndpoint;

        @NameInMap("IntranetEndpoint")
        public String intranetEndpoint;

        @NameInMap("Location")
        public String location;

        @NameInMap("Name")
        public String name;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static GetServiceResponseListAllMyBucketsResultBucketsBucket build(Map<String, ?> map) throws Exception {
            return (GetServiceResponseListAllMyBucketsResultBucketsBucket) TeaModel.build(map, new GetServiceResponseListAllMyBucketsResultBucketsBucket());
        }

        public String getCreateDate() {
            return this.createDate;
        }

        public String getExtranetEndpoint() {
            return this.extranetEndpoint;
        }

        public String getIntranetEndpoint() {
            return this.intranetEndpoint;
        }

        public String getLocation() {
            return this.location;
        }

        public String getName() {
            return this.name;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setCreateDate(String str) {
            this.createDate = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setExtranetEndpoint(String str) {
            this.extranetEndpoint = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setIntranetEndpoint(String str) {
            this.intranetEndpoint = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setLocation(String str) {
            this.location = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setName(String str) {
            this.name = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultBucketsBucket setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static class GetServiceResponseListAllMyBucketsResultOwner extends TeaModel {

        @NameInMap("DisplayName")
        public String displayName;

        @NameInMap("ID")
        public String iD;

        public static GetServiceResponseListAllMyBucketsResultOwner build(Map<String, ?> map) throws Exception {
            return (GetServiceResponseListAllMyBucketsResultOwner) TeaModel.build(map, new GetServiceResponseListAllMyBucketsResultOwner());
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getID() {
            return this.iD;
        }

        public GetServiceResponseListAllMyBucketsResultOwner setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public GetServiceResponseListAllMyBucketsResultOwner setID(String str) {
            this.iD = str;
            return this;
        }
    }

    public static GetServiceResponse build(Map<String, ?> map) throws Exception {
        return (GetServiceResponse) TeaModel.build(map, new GetServiceResponse());
    }

    public GetServiceResponseListAllMyBucketsResult getListAllMyBucketsResult() {
        return this.listAllMyBucketsResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetServiceResponse setListAllMyBucketsResult(GetServiceResponseListAllMyBucketsResult getServiceResponseListAllMyBucketsResult) {
        this.listAllMyBucketsResult = getServiceResponseListAllMyBucketsResult;
        return this;
    }

    public GetServiceResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
