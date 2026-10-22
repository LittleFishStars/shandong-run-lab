package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MonitorExaminationAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("Type")
    public Long type;

    public static MonitorExaminationAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (MonitorExaminationAdvanceRequest) TeaModel.build(map, new MonitorExaminationAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Long getType() {
        return this.type;
    }

    public MonitorExaminationAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public MonitorExaminationAdvanceRequest setType(Long l) {
        this.type = l;
        return this;
    }
}
