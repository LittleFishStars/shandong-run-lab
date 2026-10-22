package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteMultipleObjectsResponse extends TeaModel {

    @NameInMap("DeleteResult")
    @Validation(required = true)
    public DeleteMultipleObjectsResponseDeleteResult deleteResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class DeleteMultipleObjectsResponseDeleteResult extends TeaModel {

        @NameInMap("Deleted")
        public List<DeleteMultipleObjectsResponseDeleteResultDeleted> deleted;

        @NameInMap("EncodingType")
        public String encodingType;

        @NameInMap("Quiet")
        public String quiet;

        public static DeleteMultipleObjectsResponseDeleteResult build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsResponseDeleteResult) TeaModel.build(map, new DeleteMultipleObjectsResponseDeleteResult());
        }

        public List<DeleteMultipleObjectsResponseDeleteResultDeleted> getDeleted() {
            return this.deleted;
        }

        public String getEncodingType() {
            return this.encodingType;
        }

        public String getQuiet() {
            return this.quiet;
        }

        public DeleteMultipleObjectsResponseDeleteResult setDeleted(List<DeleteMultipleObjectsResponseDeleteResultDeleted> list) {
            this.deleted = list;
            return this;
        }

        public DeleteMultipleObjectsResponseDeleteResult setEncodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public DeleteMultipleObjectsResponseDeleteResult setQuiet(String str) {
            this.quiet = str;
            return this;
        }
    }

    public static class DeleteMultipleObjectsResponseDeleteResultDeleted extends TeaModel {

        @NameInMap("Key")
        public String key;

        public static DeleteMultipleObjectsResponseDeleteResultDeleted build(Map<String, ?> map) throws Exception {
            return (DeleteMultipleObjectsResponseDeleteResultDeleted) TeaModel.build(map, new DeleteMultipleObjectsResponseDeleteResultDeleted());
        }

        public String getKey() {
            return this.key;
        }

        public DeleteMultipleObjectsResponseDeleteResultDeleted setKey(String str) {
            this.key = str;
            return this;
        }
    }

    public static DeleteMultipleObjectsResponse build(Map<String, ?> map) throws Exception {
        return (DeleteMultipleObjectsResponse) TeaModel.build(map, new DeleteMultipleObjectsResponse());
    }

    public DeleteMultipleObjectsResponseDeleteResult getDeleteResult() {
        return this.deleteResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DeleteMultipleObjectsResponse setDeleteResult(DeleteMultipleObjectsResponseDeleteResult deleteMultipleObjectsResponseDeleteResult) {
        this.deleteResult = deleteMultipleObjectsResponseDeleteResult;
        return this;
    }

    public DeleteMultipleObjectsResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
