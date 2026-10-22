package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceEntityResponseBody extends TeaModel {

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static AddFaceEntityResponseBody build(Map<String, ?> map) throws Exception {
        return (AddFaceEntityResponseBody) TeaModel.build(map, new AddFaceEntityResponseBody());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AddFaceEntityResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
