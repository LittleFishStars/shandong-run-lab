package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetVodPlaylistResponse extends TeaModel {

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static GetVodPlaylistResponse build(Map<String, ?> map) throws Exception {
        return (GetVodPlaylistResponse) TeaModel.build(map, new GetVodPlaylistResponse());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetVodPlaylistResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
