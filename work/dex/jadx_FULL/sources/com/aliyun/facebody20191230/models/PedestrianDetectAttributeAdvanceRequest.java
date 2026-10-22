package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PedestrianDetectAttributeAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    public static PedestrianDetectAttributeAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (PedestrianDetectAttributeAdvanceRequest) TeaModel.build(map, new PedestrianDetectAttributeAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public PedestrianDetectAttributeAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }
}
