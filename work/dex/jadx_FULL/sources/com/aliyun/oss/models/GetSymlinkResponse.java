package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetSymlinkResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    @NameInMap(OSSHeaders.OSS_HEADER_SYMLINK_TARGET)
    @Validation(required = true)
    public String symlinkTarget;

    public static GetSymlinkResponse build(Map<String, ?> map) throws Exception {
        return (GetSymlinkResponse) TeaModel.build(map, new GetSymlinkResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public GetSymlinkResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public GetSymlinkResponse setSymlinkTarget(String str) {
        this.symlinkTarget = str;
        return this;
    }
}
