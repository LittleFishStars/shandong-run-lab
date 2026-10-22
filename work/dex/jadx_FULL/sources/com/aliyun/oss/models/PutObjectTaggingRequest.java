package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutObjectTaggingRequest extends TeaModel {

    @NameInMap("Body")
    public PutObjectTaggingRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class PutObjectTaggingRequestBody extends TeaModel {

        @NameInMap("Tagging")
        @Validation(required = true)
        public PutObjectTaggingRequestBodyTagging tagging;

        public static PutObjectTaggingRequestBody build(Map<String, ?> map) throws Exception {
            return (PutObjectTaggingRequestBody) TeaModel.build(map, new PutObjectTaggingRequestBody());
        }

        public PutObjectTaggingRequestBodyTagging getTagging() {
            return this.tagging;
        }

        public PutObjectTaggingRequestBody setTagging(PutObjectTaggingRequestBodyTagging putObjectTaggingRequestBodyTagging) {
            this.tagging = putObjectTaggingRequestBodyTagging;
            return this;
        }
    }

    public static class PutObjectTaggingRequestBodyTagging extends TeaModel {

        @NameInMap("TagSet")
        public PutObjectTaggingRequestBodyTaggingTagSet tagSet;

        public static PutObjectTaggingRequestBodyTagging build(Map<String, ?> map) throws Exception {
            return (PutObjectTaggingRequestBodyTagging) TeaModel.build(map, new PutObjectTaggingRequestBodyTagging());
        }

        public PutObjectTaggingRequestBodyTaggingTagSet getTagSet() {
            return this.tagSet;
        }

        public PutObjectTaggingRequestBodyTagging setTagSet(PutObjectTaggingRequestBodyTaggingTagSet putObjectTaggingRequestBodyTaggingTagSet) {
            this.tagSet = putObjectTaggingRequestBodyTaggingTagSet;
            return this;
        }
    }

    public static class PutObjectTaggingRequestBodyTaggingTagSet extends TeaModel {

        @NameInMap("Tag")
        public List<PutObjectTaggingRequestBodyTaggingTagSetTag> tag;

        public static PutObjectTaggingRequestBodyTaggingTagSet build(Map<String, ?> map) throws Exception {
            return (PutObjectTaggingRequestBodyTaggingTagSet) TeaModel.build(map, new PutObjectTaggingRequestBodyTaggingTagSet());
        }

        public List<PutObjectTaggingRequestBodyTaggingTagSetTag> getTag() {
            return this.tag;
        }

        public PutObjectTaggingRequestBodyTaggingTagSet setTag(List<PutObjectTaggingRequestBodyTaggingTagSetTag> list) {
            this.tag = list;
            return this;
        }
    }

    public static class PutObjectTaggingRequestBodyTaggingTagSetTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static PutObjectTaggingRequestBodyTaggingTagSetTag build(Map<String, ?> map) throws Exception {
            return (PutObjectTaggingRequestBodyTaggingTagSetTag) TeaModel.build(map, new PutObjectTaggingRequestBodyTaggingTagSetTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public PutObjectTaggingRequestBodyTaggingTagSetTag setKey(String str) {
            this.key = str;
            return this;
        }

        public PutObjectTaggingRequestBodyTaggingTagSetTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static PutObjectTaggingRequest build(Map<String, ?> map) throws Exception {
        return (PutObjectTaggingRequest) TeaModel.build(map, new PutObjectTaggingRequest());
    }

    public PutObjectTaggingRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public PutObjectTaggingRequest setBody(PutObjectTaggingRequestBody putObjectTaggingRequestBody) {
        this.body = putObjectTaggingRequestBody;
        return this;
    }

    public PutObjectTaggingRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutObjectTaggingRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}
