package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketAclResponse extends TeaModel {

    @NameInMap("AccessControlPolicy")
    @Validation(required = true)
    public GetBucketAclResponseAccessControlPolicy accessControlPolicy;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketAclResponseAccessControlPolicy extends TeaModel {

        @NameInMap("AccessControlList")
        @Validation(required = true)
        public GetBucketAclResponseAccessControlPolicyAccessControlList accessControlList;

        @NameInMap("Owner")
        @Validation(required = true)
        public GetBucketAclResponseAccessControlPolicyOwner owner;

        public static GetBucketAclResponseAccessControlPolicy build(Map<String, ?> map) throws Exception {
            return (GetBucketAclResponseAccessControlPolicy) TeaModel.build(map, new GetBucketAclResponseAccessControlPolicy());
        }

        public GetBucketAclResponseAccessControlPolicyAccessControlList getAccessControlList() {
            return this.accessControlList;
        }

        public GetBucketAclResponseAccessControlPolicyOwner getOwner() {
            return this.owner;
        }

        public GetBucketAclResponseAccessControlPolicy setAccessControlList(GetBucketAclResponseAccessControlPolicyAccessControlList getBucketAclResponseAccessControlPolicyAccessControlList) {
            this.accessControlList = getBucketAclResponseAccessControlPolicyAccessControlList;
            return this;
        }

        public GetBucketAclResponseAccessControlPolicy setOwner(GetBucketAclResponseAccessControlPolicyOwner getBucketAclResponseAccessControlPolicyOwner) {
            this.owner = getBucketAclResponseAccessControlPolicyOwner;
            return this;
        }
    }

    public static class GetBucketAclResponseAccessControlPolicyAccessControlList extends TeaModel {

        @NameInMap("Grant")
        public String grant;

        public static GetBucketAclResponseAccessControlPolicyAccessControlList build(Map<String, ?> map) throws Exception {
            return (GetBucketAclResponseAccessControlPolicyAccessControlList) TeaModel.build(map, new GetBucketAclResponseAccessControlPolicyAccessControlList());
        }

        public String getGrant() {
            return this.grant;
        }

        public GetBucketAclResponseAccessControlPolicyAccessControlList setGrant(String str) {
            this.grant = str;
            return this;
        }
    }

    public static class GetBucketAclResponseAccessControlPolicyOwner extends TeaModel {

        @NameInMap("DisplayName")
        public String displayName;

        @NameInMap("ID")
        public String iD;

        public static GetBucketAclResponseAccessControlPolicyOwner build(Map<String, ?> map) throws Exception {
            return (GetBucketAclResponseAccessControlPolicyOwner) TeaModel.build(map, new GetBucketAclResponseAccessControlPolicyOwner());
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getID() {
            return this.iD;
        }

        public GetBucketAclResponseAccessControlPolicyOwner setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public GetBucketAclResponseAccessControlPolicyOwner setID(String str) {
            this.iD = str;
            return this;
        }
    }

    public static GetBucketAclResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketAclResponse) TeaModel.build(map, new GetBucketAclResponse());
    }

    public GetBucketAclResponseAccessControlPolicy getAccessControlPolicy() {
        return this.accessControlPolicy;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketAclResponse setAccessControlPolicy(GetBucketAclResponseAccessControlPolicy getBucketAclResponseAccessControlPolicy) {
        this.accessControlPolicy = getBucketAclResponseAccessControlPolicy;
        return this;
    }

    public GetBucketAclResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
