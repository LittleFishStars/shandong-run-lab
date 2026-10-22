package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteMultipleObjectsRequest extends TeaModel {

    @NameInMap("Body")
    public DeleteMultipleObjectsRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    @Validation(required = true)
    public DeleteMultipleObjectsRequestHeader header;

    public static class DeleteMultipleObjectsRequestBody extends TeaModel {

        @NameInMap("Delete")
        @Validation(required = true)
        public DeleteMultipleObjectsRequestBodyDelete delete;

        public static DeleteMultipleObjectsRequestBody build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsRequestBody) TeaModel.build(map, new DeleteMultipleObjectsRequestBody());
        }

        public DeleteMultipleObjectsRequestBodyDelete getDelete() {
            return this.delete;
        }

        public DeleteMultipleObjectsRequestBody setDelete(DeleteMultipleObjectsRequestBodyDelete deleteMultipleObjectsRequestBodyDelete) {
            this.delete = deleteMultipleObjectsRequestBodyDelete;
            return this;
        }
    }

    public static class DeleteMultipleObjectsRequestBodyDelete extends TeaModel {

        @NameInMap("Object")
        public List<DeleteMultipleObjectsRequestBodyDeleteObject> object;

        @NameInMap("Quiet")
        public String quiet;

        public static DeleteMultipleObjectsRequestBodyDelete build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsRequestBodyDelete) TeaModel.build(map, new DeleteMultipleObjectsRequestBodyDelete());
        }

        public List<DeleteMultipleObjectsRequestBodyDeleteObject> getObject() {
            return this.object;
        }

        public String getQuiet() {
            return this.quiet;
        }

        public DeleteMultipleObjectsRequestBodyDelete setObject(List<DeleteMultipleObjectsRequestBodyDeleteObject> list) {
            this.object = list;
            return this;
        }

        public DeleteMultipleObjectsRequestBodyDelete setQuiet(String str) {
            this.quiet = str;
            return this;
        }
    }

    public static class DeleteMultipleObjectsRequestBodyDeleteObject extends TeaModel {

        @NameInMap("Key")
        public String key;

        public static DeleteMultipleObjectsRequestBodyDeleteObject build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsRequestBodyDeleteObject) TeaModel.build(map, new DeleteMultipleObjectsRequestBodyDeleteObject());
        }

        public String getKey() {
            return this.key;
        }

        public DeleteMultipleObjectsRequestBodyDeleteObject setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static class DeleteMultipleObjectsRequestHeader extends TeaModel {

        @NameInMap("Content-Length")
        @Validation(required = true)
        public String contentLength;

        @NameInMap("Content-MD5")
        @Validation(required = true)
        public String contentMD5;

        @NameInMap("Encoding-type")
        public String encodingType;

        public static DeleteMultipleObjectsRequestHeader build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsRequestHeader) TeaModel.build(map, new DeleteMultipleObjectsRequestHeader());
        }

        public String getContentLength() {
            return this.contentLength;
        }

        public String getContentMD5() {
            return this.contentMD5;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public DeleteMultipleObjectsRequestHeader setContentLength(String str) {
            this.contentLength = str;
            return this;
        }

        public DeleteMultipleObjectsRequestHeader setContentMD5(String str) {
            this.contentMD5 = str;
            return this;
        }

        public DeleteMultipleObjectsRequestHeader setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }
    }

    public static DeleteMultipleObjectsRequest build(Map<String, ?> map) throws Exception {
        return (DeleteMultipleObjectsRequest) TeaModel.build(map, new DeleteMultipleObjectsRequest());
    }

    public DeleteMultipleObjectsRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public DeleteMultipleObjectsRequestHeader getHeader() {
        return this.header;
    }

    public DeleteMultipleObjectsRequest setBody(DeleteMultipleObjectsRequestBody deleteMultipleObjectsRequestBody) {
        this.body = deleteMultipleObjectsRequestBody;
        return this;
    }

    public DeleteMultipleObjectsRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public DeleteMultipleObjectsRequest setHeader(DeleteMultipleObjectsRequestHeader deleteMultipleObjectsRequestHeader) {
        this.header = deleteMultipleObjectsRequestHeader;
        return this;
    }
}
