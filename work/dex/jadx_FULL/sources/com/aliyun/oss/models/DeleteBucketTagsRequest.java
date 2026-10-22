package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteBucketTagsRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public DeleteBucketTagsRequestFilter filter;

    public static class DeleteBucketTagsRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.X_OSS_TAGGING)
        @Validation(required = true)
        public String tagging;

        public static DeleteBucketTagsRequestFilter build(Map<String, ?> map) throws Exception {
            return (DeleteBucketTagsRequestFilter) TeaModel.build(map, new DeleteBucketTagsRequestFilter());
        }

        public String getTagging() {
            return this.tagging;
        }

        public DeleteBucketTagsRequestFilter setTagging(String str) {
            this.tagging = str;
            return this;
        }
    }

    public static DeleteBucketTagsRequest build(Map<String, ?> map) throws Exception {
        return (DeleteBucketTagsRequest) TeaModel.build(map, new DeleteBucketTagsRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public DeleteBucketTagsRequestFilter getFilter() {
        return this.filter;
    }

    public DeleteBucketTagsRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public DeleteBucketTagsRequest setFilter(DeleteBucketTagsRequestFilter deleteBucketTagsRequestFilter) {
        this.filter = deleteBucketTagsRequestFilter;
        return this;
    }
}
