package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetObjectTaggingResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap("Tagging")
    @Validation(required = true)
    public GetObjectTaggingResponseTagging tagging;

    public static class GetObjectTaggingResponseTagging extends TeaModel {

        @NameInMap("TagSet")
        @Validation(required = true)
        public GetObjectTaggingResponseTaggingTagSet tagSet;

        public static GetObjectTaggingResponseTagging build(Map<String, ?> map) throws Exception {
            return (GetObjectTaggingResponseTagging) TeaModel.build(map, new GetObjectTaggingResponseTagging());
        }

        public GetObjectTaggingResponseTaggingTagSet getTagSet() {
            return this.tagSet;
        }

        public GetObjectTaggingResponseTagging setTagSet(GetObjectTaggingResponseTaggingTagSet getObjectTaggingResponseTaggingTagSet) {
            this.tagSet = getObjectTaggingResponseTaggingTagSet;
            return this;
        }
    }

    public static class GetObjectTaggingResponseTaggingTagSet extends TeaModel {

        @NameInMap("Tag")
        public List<GetObjectTaggingResponseTaggingTagSetTag> tag;

        public static GetObjectTaggingResponseTaggingTagSet build(Map<String, ?> map) throws Exception {
            return (GetObjectTaggingResponseTaggingTagSet) TeaModel.build(map, new GetObjectTaggingResponseTaggingTagSet());
        }

        public List<GetObjectTaggingResponseTaggingTagSetTag> getTag() {
            return this.tag;
        }

        public GetObjectTaggingResponseTaggingTagSet setTag(List<GetObjectTaggingResponseTaggingTagSetTag> list) {
            this.tag = list;
            return this;
        }
    }

    public static class GetObjectTaggingResponseTaggingTagSetTag extends TeaModel {

        @NameInMap("Key")
        public String key;

        @NameInMap("Value")
        public String value;

        public static GetObjectTaggingResponseTaggingTagSetTag build(Map<String, ?> map) throws Exception {
            return (GetObjectTaggingResponseTaggingTagSetTag) TeaModel.build(map, new GetObjectTaggingResponseTaggingTagSetTag());
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public GetObjectTaggingResponseTaggingTagSetTag setKey(String str) {
            this.key = str;
            return this;
        }

        public GetObjectTaggingResponseTaggingTagSetTag setValue(String str) {
            this.value = str;
            return this;
        }
    }

    public static GetObjectTaggingResponse build(Map<String, ?> map) throws Exception {
        return (GetObjectTaggingResponse) TeaModel.build(map, new GetObjectTaggingResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetObjectTaggingResponseTagging getTagging() {
        return this.tagging;
    }

    public GetObjectTaggingResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetObjectTaggingResponse setTagging(GetObjectTaggingResponseTagging getObjectTaggingResponseTagging) {
        this.tagging = getObjectTaggingResponseTagging;
        return this;
    }
}
