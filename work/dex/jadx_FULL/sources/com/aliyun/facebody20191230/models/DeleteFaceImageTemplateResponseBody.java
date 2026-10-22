package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceImageTemplateResponseBody extends TeaModel {

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static DeleteFaceImageTemplateResponseBody build(Map<String, ?> map) throws Exception {
        return (DeleteFaceImageTemplateResponseBody) TeaModel.build(map, new DeleteFaceImageTemplateResponseBody());
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DeleteFaceImageTemplateResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
