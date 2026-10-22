package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CopyObjectResponse extends TeaModel {

    @NameInMap("CopyObjectResult")
    @Validation(required = true)
    public CopyObjectResponseCopyObjectResult copyObjectResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class CopyObjectResponseCopyObjectResult extends TeaModel {

        @NameInMap("ETag")
        public String eTag;

        @NameInMap("LastModified")
        public String lastModified;

        public static CopyObjectResponseCopyObjectResult build(Map<String, ?> map) throws Exception {
            return (CopyObjectResponseCopyObjectResult) TeaModel.build(map, new CopyObjectResponseCopyObjectResult());
        }

        public String getETag() {
            return this.eTag;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public CopyObjectResponseCopyObjectResult setETag(String str) {
            this.eTag = str;
            return this;
        }

        public CopyObjectResponseCopyObjectResult setLastModified(String str) {
            this.lastModified = str;
            return this;
        }
    }

    public static CopyObjectResponse build(Map<String, ?> map) throws Exception {
        return (CopyObjectResponse) TeaModel.build(map, new CopyObjectResponse());
    }

    public CopyObjectResponseCopyObjectResult getCopyObjectResult() {
        return this.copyObjectResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CopyObjectResponse setCopyObjectResult(CopyObjectResponseCopyObjectResult copyObjectResponseCopyObjectResult) {
        this.copyObjectResult = copyObjectResponseCopyObjectResult;
        return this;
    }

    public CopyObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
