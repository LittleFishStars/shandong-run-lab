package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.fileform.models.FileField;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PostObjectRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("header")
    @Validation(required = true)
    public PostObjectRequestHeader header;

    public static class PostObjectRequestHeader extends TeaModel {

        @NameInMap(RequestParameters.OSS_ACCESS_KEY_ID)
        @Validation(required = true)
        public String accessKeyId;

        @NameInMap("file")
        @Validation(required = true)
        public FileField file;

        @NameInMap(CachedContentIndex.a.e)
        @Validation(required = true)
        public String key;

        @NameInMap(AuthConstant.INI_POLICY)
        @Validation(required = true)
        public String policy;

        @NameInMap("Signature")
        @Validation(required = true)
        public String signature;

        @NameInMap("success_action_status")
        public String successActionStatus;

        @NameInMap("UserMeta")
        public Map<String, String> userMeta;

        public static PostObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (PostObjectRequestHeader) TeaModel.build(map, new PostObjectRequestHeader());
        }

        public String getAccessKeyId() {
            return this.accessKeyId;
        }

        public FileField getFile() {
            return this.file;
        }

        public String getKey() {
            return this.key;
        }

        public String getPolicy() {
            return this.policy;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getSuccessActionStatus() {
            return this.successActionStatus;
        }

        public Map<String, String> getUserMeta() {
            return this.userMeta;
        }

        public PostObjectRequestHeader setAccessKeyId(String str) {
            this.accessKeyId = str;
            return this;
        }

        public PostObjectRequestHeader setFile(FileField fileField) {
            this.file = fileField;
            return this;
        }

        public PostObjectRequestHeader setKey(String str) {
            this.key = str;
            return this;
        }

        public PostObjectRequestHeader setPolicy(String str) {
            this.policy = str;
            return this;
        }

        public PostObjectRequestHeader setSignature(String str) {
            this.signature = str;
            return this;
        }

        public PostObjectRequestHeader setSuccessActionStatus(String str) {
            this.successActionStatus = str;
            return this;
        }

        public PostObjectRequestHeader setUserMeta(Map<String, String> map) {
            this.userMeta = map;
            return this;
        }
    }

    public static PostObjectRequest build(Map<String, ?> map) throws Exception {
        return (PostObjectRequest) TeaModel.build(map, new PostObjectRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PostObjectRequestHeader getHeader() {
        return this.header;
    }

    public PostObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PostObjectRequest setHeader(PostObjectRequestHeader postObjectRequestHeader) {
        this.header = postObjectRequestHeader;
        return this;
    }
}
