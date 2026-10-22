package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketTagsRequest extends TeaModel {

    @NameInMap("Body")
    public PutBucketTagsRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static class PutBucketTagsRequestBody extends TeaModel {

        @NameInMap("Tagging")
        @Validation(required = true)
        public PutBucketTagsRequestBodyTagging tagging;

        public static PutBucketTagsRequestBody build(Map<String, ?> map) throws Exception {
            return (PutBucketTagsRequestBody) TeaModel.build(map, new PutBucketTagsRequestBody());
        }

        public PutBucketTagsRequestBodyTagging getTagging() {
            return this.tagging;
        }

        public PutBucketTagsRequestBody setTagging(PutBucketTagsRequestBodyTagging putBucketTagsRequestBodyTagging) {
            this.tagging = putBucketTagsRequestBodyTagging;
            return this;
        }
    }

    public static class PutBucketTagsRequestBodyTagging extends TeaModel {

        @NameInMap("TagSet")
        public PutBucketTagsRequestBodyTaggingTagSet tagSet;

        public static PutBucketTagsRequestBodyTagging build(Map<String, ?> map) throws Exception {
            return (PutBucketTagsRequestBodyTagging) TeaModel.build(map, new PutBucketTagsRequestBodyTagging());
        }

        public PutBucketTagsRequestBodyTaggingTagSet getTagSet() {
            return this.tagSet;
        }

        public PutBucketTagsRequestBodyTagging setTagSet(PutBucketTagsRequestBodyTaggingTagSet putBucketTagsRequestBodyTaggingTagSet) {
            this.tagSet = putBucketTagsRequestBodyTaggingTagSet;
            return this;
        }
    }

    public static class PutBucketTagsRequestBodyTaggingTagSet extends TeaModel {

        @NameInMap("Tag")
        public List<PutBucketTagsRequestBodyTaggingTagSetTag> tag;

        public static PutBucketTagsRequestBodyTaggingTagSet build(Map<String, ?> map) throws Exception {
            return (PutBucketTagsRequestBodyTaggingTagSet) TeaModel.build(map, new PutBucketTagsRequestBodyTaggingTagSet());
        }

        public List<PutBucketTagsRequestBodyTaggingTagSetTag> getTag() {
            return this.tag;
        }

        public PutBucketTagsRequestBodyTaggingTagSet setTag(List<PutBucketTagsRequestBodyTaggingTagSetTag> list) {
            this.tag = list;
            return this;
        }
    }

    public static class PutBucketTagsRequestBodyTaggingTagSetTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static PutBucketTagsRequestBodyTaggingTagSetTag build(Map<String, ?> map) throws Exception {
            return (PutBucketTagsRequestBodyTaggingTagSetTag) TeaModel.build(map, new PutBucketTagsRequestBodyTaggingTagSetTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public PutBucketTagsRequestBodyTaggingTagSetTag setKey(String str) {
            this.key = str;
            return this;
        }

        public PutBucketTagsRequestBodyTaggingTagSetTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static PutBucketTagsRequest build(Map<String, ?> map) throws Exception {
        return (PutBucketTagsRequest) TeaModel.build(map, new PutBucketTagsRequest());
    }

    public PutBucketTagsRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutBucketTagsRequest setBody(PutBucketTagsRequestBody putBucketTagsRequestBody) {
        this.body = putBucketTagsRequestBody;
        return this;
    }

    public PutBucketTagsRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}
