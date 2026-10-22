package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutBucketLoggingResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static PutBucketLoggingResponse build(Map<String, ?> map) throws Exception {
        return (PutBucketLoggingResponse) TeaModel.build(map, new PutBucketLoggingResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public PutBucketLoggingResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
