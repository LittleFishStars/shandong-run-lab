package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MonitorExaminationRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("Type")
    public Long type;

    public static MonitorExaminationRequest build(Map<String, ?> map) throws Exception {
        return (MonitorExaminationRequest) TeaModel.build(map, new MonitorExaminationRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Long getType() {
        return this.type;
    }

    public MonitorExaminationRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public MonitorExaminationRequest setType(Long l) {
        this.type = l;
        return this;
    }
}
