package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketTagsResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("Tagging")
    @Validation(required = true)
    public GetBucketTagsResponseTagging tagging;

    public static class GetBucketTagsResponseTagging extends TeaModel {

        @NameInMap("TagSet")
        @Validation(required = true)
        public GetBucketTagsResponseTaggingTagSet tagSet;

        public static GetBucketTagsResponseTagging build(Map<String, ?> map) throws Exception {
            return (GetBucketTagsResponseTagging) TeaModel.build(map, new GetBucketTagsResponseTagging());
        }

        public GetBucketTagsResponseTaggingTagSet getTagSet() {
            return this.tagSet;
        }

        public GetBucketTagsResponseTagging setTagSet(GetBucketTagsResponseTaggingTagSet getBucketTagsResponseTaggingTagSet) {
            this.tagSet = getBucketTagsResponseTaggingTagSet;
            return this;
        }
    }

    public static class GetBucketTagsResponseTaggingTagSet extends TeaModel {

        @NameInMap("Tag")
        public List<GetBucketTagsResponseTaggingTagSetTag> tag;

        public static GetBucketTagsResponseTaggingTagSet build(Map<String, ?> map) throws Exception {
            return (GetBucketTagsResponseTaggingTagSet) TeaModel.build(map, new GetBucketTagsResponseTaggingTagSet());
        }

        public List<GetBucketTagsResponseTaggingTagSetTag> getTag() {
            return this.tag;
        }

        public GetBucketTagsResponseTaggingTagSet setTag(List<GetBucketTagsResponseTaggingTagSetTag> list) {
            this.tag = list;
            return this;
        }
    }

    public static class GetBucketTagsResponseTaggingTagSetTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static GetBucketTagsResponseTaggingTagSetTag build(Map<String, ?> map) throws Exception {
            return (GetBucketTagsResponseTaggingTagSetTag) TeaModel.build(map, new GetBucketTagsResponseTaggingTagSetTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public GetBucketTagsResponseTaggingTagSetTag setKey(String str) {
            this.key = str;
            return this;
        }

        public GetBucketTagsResponseTaggingTagSetTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static GetBucketTagsResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketTagsResponse) TeaModel.build(map, new GetBucketTagsResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketTagsResponseTagging getTagging() {
        return this.tagging;
    }

    public GetBucketTagsResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetBucketTagsResponse setTagging(GetBucketTagsResponseTagging getBucketTagsResponseTagging) {
        this.tagging = getBucketTagsResponseTagging;
        return this;
    }
}
