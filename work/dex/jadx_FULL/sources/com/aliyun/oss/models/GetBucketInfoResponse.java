package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketInfoResponse extends TeaModel {

    @NameInMap("BucketInfo")
    @Validation(required = true)
    public GetBucketInfoResponseBucketInfo bucketInfo;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketInfoResponseBucketInfo extends TeaModel {

        @NameInMap("Bucket")
        @Validation(required = true)
        public GetBucketInfoResponseBucketInfoBucket bucket;

        public static GetBucketInfoResponseBucketInfo build(Map<String, ?> map) throws Exception {
            return (GetBucketInfoResponseBucketInfo) TeaModel.build(map, new GetBucketInfoResponseBucketInfo());
        }

        public GetBucketInfoResponseBucketInfoBucket getBucket() {
            return this.bucket;
        }

        public GetBucketInfoResponseBucketInfo setBucket(GetBucketInfoResponseBucketInfoBucket getBucketInfoResponseBucketInfoBucket) {
            this.bucket = getBucketInfoResponseBucketInfoBucket;
            return this;
        }
    }

    public static class GetBucketInfoResponseBucketInfoBucket extends TeaModel {

        @NameInMap("AccessControlList")
        @Validation(required = true)
        public GetBucketInfoResponseBucketInfoBucketAccessControlList accessControlList;

        @NameInMap("Comment")
        public String comment;

        @NameInMap("CreationDate")
        public String creationDate;

        @NameInMap("DataRedundancyType")
        public String dataRedundancyType;

        @NameInMap("ExtranetEndpoint")
        public String extranetEndpoint;

        @NameInMap("IntranetEndpoint")
        public String intranetEndpoint;

        @NameInMap("Location")
        public String location;

        @NameInMap("Name")
        public String name;

        @NameInMap("Owner")
        @Validation(required = true)
        public GetBucketInfoResponseBucketInfoBucketOwner owner;

        @NameInMap(CreateBucketRequest.TAB_STORAGECLASS)
        public String storageClass;

        public static GetBucketInfoResponseBucketInfoBucket build(Map<String, ?> map) throws Exception {
            return (GetBucketInfoResponseBucketInfoBucket) TeaModel.build(map, new GetBucketInfoResponseBucketInfoBucket());
        }

        public GetBucketInfoResponseBucketInfoBucketAccessControlList getAccessControlList() {
            return this.accessControlList;
        }

        public String getComment() {
            return this.comment;
        }

        public String getCreationDate() {
            return this.creationDate;
        }

        public String getDataRedundancyType() {
            return this.dataRedundancyType;
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

        public GetBucketInfoResponseBucketInfoBucketOwner getOwner() {
            return this.owner;
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public GetBucketInfoResponseBucketInfoBucket setAccessControlList(GetBucketInfoResponseBucketInfoBucketAccessControlList getBucketInfoResponseBucketInfoBucketAccessControlList) {
            this.accessControlList = getBucketInfoResponseBucketInfoBucketAccessControlList;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setComment(String str) {
            this.comment = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setCreationDate(String str) {
            this.creationDate = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setDataRedundancyType(String str) {
            this.dataRedundancyType = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setExtranetEndpoint(String str) {
            this.extranetEndpoint = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setIntranetEndpoint(String str) {
            this.intranetEndpoint = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setLocation(String str) {
            this.location = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setName(String str) {
            this.name = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setOwner(GetBucketInfoResponseBucketInfoBucketOwner getBucketInfoResponseBucketInfoBucketOwner) {
            this.owner = getBucketInfoResponseBucketInfoBucketOwner;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucket setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }
    }

    public static class GetBucketInfoResponseBucketInfoBucketAccessControlList extends TeaModel {

        @NameInMap("Grant")
        public String grant;

        public static GetBucketInfoResponseBucketInfoBucketAccessControlList build(Map<String, ?> map) throws Exception {
            return (GetBucketInfoResponseBucketInfoBucketAccessControlList) TeaModel.build(map, new GetBucketInfoResponseBucketInfoBucketAccessControlList());
        }

        public String getGrant() {
            return this.grant;
        }

        public GetBucketInfoResponseBucketInfoBucketAccessControlList setGrant(String str) {
            this.grant = str;
            return this;
        }
    }

    public static class GetBucketInfoResponseBucketInfoBucketOwner extends TeaModel {

        @NameInMap("DisplayName")
        public String displayName;

        @NameInMap("ID")
        public String iD;

        public static GetBucketInfoResponseBucketInfoBucketOwner build(Map<String, ?> map) throws Exception {
            return (GetBucketInfoResponseBucketInfoBucketOwner) TeaModel.build(map, new GetBucketInfoResponseBucketInfoBucketOwner());
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getID() {
            return this.iD;
        }

        public GetBucketInfoResponseBucketInfoBucketOwner setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public GetBucketInfoResponseBucketInfoBucketOwner setID(String str) {
            this.iD = str;
            return this;
        }
    }

    public static GetBucketInfoResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketInfoResponse) TeaModel.build(map, new GetBucketInfoResponse());
    }

    public GetBucketInfoResponseBucketInfo getBucketInfo() {
        return this.bucketInfo;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketInfoResponse setBucketInfo(GetBucketInfoResponseBucketInfo getBucketInfoResponseBucketInfo) {
        this.bucketInfo = getBucketInfoResponseBucketInfo;
        return this;
    }

    public GetBucketInfoResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
