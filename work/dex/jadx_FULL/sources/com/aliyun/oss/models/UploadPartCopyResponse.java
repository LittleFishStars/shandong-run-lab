package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadPartCopyResponse extends TeaModel {

    @NameInMap("CopyPartResult")
    @Validation(required = true)
    public UploadPartCopyResponseCopyPartResult copyPartResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class UploadPartCopyResponseCopyPartResult extends TeaModel {

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("LastModified")
        public String lastModified;

        public static UploadPartCopyResponseCopyPartResult build(Map<String, ?> map) throws Exception {
            return (UploadPartCopyResponseCopyPartResult) TeaModel.build(map, new UploadPartCopyResponseCopyPartResult());
        }

        public String getETag() {
            return this.eTag;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public UploadPartCopyResponseCopyPartResult setETag(String str) {
            this.eTag = str;
            return this;
        }

        public UploadPartCopyResponseCopyPartResult setLastModified(String str) {
            this.lastModified = str;
            return this;
        }
    }

    public static UploadPartCopyResponse build(Map<String, ?> map) throws Exception {
        return (UploadPartCopyResponse) TeaModel.build(map, new UploadPartCopyResponse());
    }

    public UploadPartCopyResponseCopyPartResult getCopyPartResult() {
        return this.copyPartResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public UploadPartCopyResponse setCopyPartResult(UploadPartCopyResponseCopyPartResult uploadPartCopyResponseCopyPartResult) {
        this.copyPartResult = uploadPartCopyResponseCopyPartResult;
        return this;
    }

    public UploadPartCopyResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
