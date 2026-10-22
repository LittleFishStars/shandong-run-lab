package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectBodyCountAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    public static DetectBodyCountAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectBodyCountAdvanceRequest) TeaModel.build(map, new DetectBodyCountAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public DetectBodyCountAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }
}
