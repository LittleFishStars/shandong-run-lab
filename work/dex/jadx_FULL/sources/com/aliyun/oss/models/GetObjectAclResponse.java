package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetObjectAclResponse extends TeaModel {

    @NameInMap("AccessControlPolicy")
    @Validation(required = true)
    public GetObjectAclResponseAccessControlPolicy accessControlPolicy;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetObjectAclResponseAccessControlPolicy extends TeaModel {

        @NameInMap("AccessControlList")
        @Validation(required = true)
        public GetObjectAclResponseAccessControlPolicyAccessControlList accessControlList;

        @NameInMap("Owner")
        @Validation(required = true)
        public GetObjectAclResponseAccessControlPolicyOwner owner;

        public static GetObjectAclResponseAccessControlPolicy build(Map<String, ?> map) throws Exception {
            return (GetObjectAclResponseAccessControlPolicy) TeaModel.build(map, new GetObjectAclResponseAccessControlPolicy());
        }

        public GetObjectAclResponseAccessControlPolicyAccessControlList getAccessControlList() {
            return this.accessControlList;
        }

        public GetObjectAclResponseAccessControlPolicyOwner getOwner() {
            return this.owner;
        }

        public GetObjectAclResponseAccessControlPolicy setAccessControlList(GetObjectAclResponseAccessControlPolicyAccessControlList getObjectAclResponseAccessControlPolicyAccessControlList) {
            this.accessControlList = getObjectAclResponseAccessControlPolicyAccessControlList;
            return this;
        }

        public GetObjectAclResponseAccessControlPolicy setOwner(GetObjectAclResponseAccessControlPolicyOwner getObjectAclResponseAccessControlPolicyOwner) {
            this.owner = getObjectAclResponseAccessControlPolicyOwner;
            return this;
        }
    }

    public static class GetObjectAclResponseAccessControlPolicyAccessControlList extends TeaModel {

        @NameInMap("Grant")
        public String grant;

        public static GetObjectAclResponseAccessControlPolicyAccessControlList build(Map<String, ?> map) throws Exception {
            return (GetObjectAclResponseAccessControlPolicyAccessControlList) TeaModel.build(map, new GetObjectAclResponseAccessControlPolicyAccessControlList());
        }

        public String getGrant() {
            return this.grant;
        }

        public GetObjectAclResponseAccessControlPolicyAccessControlList setGrant(String str) {
            this.grant = str;
            return this;
        }
    }

    public static class GetObjectAclResponseAccessControlPolicyOwner extends TeaModel {

        @NameInMap("DisplayName")
        public String displayName;

        @NameInMap("ID")
        public String iD;

        public static GetObjectAclResponseAccessControlPolicyOwner build(Map<String, ?> map) throws Exception {
            return (GetObjectAclResponseAccessControlPolicyOwner) TeaModel.build(map, new GetObjectAclResponseAccessControlPolicyOwner());
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getID() {
            return this.iD;
        }

        public GetObjectAclResponseAccessControlPolicyOwner setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public GetObjectAclResponseAccessControlPolicyOwner setID(String str) {
            this.iD = str;
            return this;
        }
    }

    public static GetObjectAclResponse build(Map<String, ?> map) throws Exception {
        return (GetObjectAclResponse) TeaModel.build(map, new GetObjectAclResponse());
    }

    public GetObjectAclResponseAccessControlPolicy getAccessControlPolicy() {
        return this.accessControlPolicy;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetObjectAclResponse setAccessControlPolicy(GetObjectAclResponseAccessControlPolicy getObjectAclResponseAccessControlPolicy) {
        this.accessControlPolicy = getObjectAclResponseAccessControlPolicy;
        return this;
    }

    public GetObjectAclResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
