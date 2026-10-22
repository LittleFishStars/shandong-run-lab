package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppendObjectResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HASH_CRC64_ECMA)
    @Validation(required = true)
    public String hashCrc64ecma;

    @NameInMap(OSSHeaders.OSS_NEXT_APPEND_POSITION)
    @Validation(required = true)
    public String nextAppendPosition;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static AppendObjectResponse build(Map<String, ?> map) throws Exception {
        return (AppendObjectResponse) TeaModel.build(map, new AppendObjectResponse());
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getNextAppendPosition() {
        return this.nextAppendPosition;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AppendObjectResponse setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public AppendObjectResponse setNextAppendPosition(String str) {
        this.nextAppendPosition = str;
        return this;
    }

    public AppendObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
