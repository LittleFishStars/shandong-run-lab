package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceImageTemplateRequest extends TeaModel {

    @NameInMap("TemplateId")
    public String templateId;

    public static DeleteFaceImageTemplateRequest build(Map<String, ?> map) throws Exception {
        return (DeleteFaceImageTemplateRequest) TeaModel.build(map, new DeleteFaceImageTemplateRequest());
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public DeleteFaceImageTemplateRequest setTemplateId(String str) {
        this.templateId = str;
        return this;
    }
}
