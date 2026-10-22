package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PostObjectResponse extends TeaModel {

    @NameInMap("PostResponse")
    @Validation(required = true)
    public PostObjectResponsePostResponse postResponse;

    public static class PostObjectResponsePostResponse extends TeaModel {

        @NameInMap("Bucket")
        @Validation(required = true)
        public String bucket;

        @NameInMap("ETag")
        @Validation(required = true)
        public String eTag;

        @NameInMap("Location")
        @Validation(required = true)
        public String location;

        public static PostObjectResponsePostResponse build(Map<String, ?> map) throws Exception {
            return (PostObjectResponsePostResponse) TeaModel.build(map, new PostObjectResponsePostResponse());
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getETag() {
            return this.eTag;
        }

        public String getLocation() {
            return this.location;
        }

        public PostObjectResponsePostResponse setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public PostObjectResponsePostResponse setETag(String str) {
            this.eTag = str;
            return this;
        }

        public PostObjectResponsePostResponse setLocation(String str) {
            this.location = str;
            return this;
        }
    }

    public static PostObjectResponse build(Map<String, ?> map) throws Exception {
        return (PostObjectResponse) TeaModel.build(map, new PostObjectResponse());
    }

    public PostObjectResponsePostResponse getPostResponse() {
        return this.postResponse;
    }

    public PostObjectResponse setPostResponse(PostObjectResponsePostResponse postObjectResponsePostResponse) {
        this.postResponse = postObjectResponsePostResponse;
        return this;
    }
}
