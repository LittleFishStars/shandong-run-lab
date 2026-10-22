package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceWithMaskAdvanceRequest extends TeaModel {

    @NameInMap("ImageURLA")
    public InputStream imageURLAObject;

    @NameInMap("ImageURLB")
    public InputStream imageURLBObject;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static CompareFaceWithMaskAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (CompareFaceWithMaskAdvanceRequest) TeaModel.build(map, new CompareFaceWithMaskAdvanceRequest());
    }

    public InputStream getImageURLAObject() {
        return this.imageURLAObject;
    }

    public InputStream getImageURLBObject() {
        return this.imageURLBObject;
    }

    public Float getQualityScoreThreshold() {
        return this.qualityScoreThreshold;
    }

    public CompareFaceWithMaskAdvanceRequest setImageURLAObject(InputStream inputStream) {
        this.imageURLAObject = inputStream;
        return this;
    }

    public CompareFaceWithMaskAdvanceRequest setImageURLBObject(InputStream inputStream) {
        this.imageURLBObject = inputStream;
        return this;
    }

    public CompareFaceWithMaskAdvanceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}
