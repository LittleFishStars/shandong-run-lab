package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceWithMaskRequest extends TeaModel {

    @NameInMap("ImageURLA")
    public String imageURLA;

    @NameInMap("ImageURLB")
    public String imageURLB;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static CompareFaceWithMaskRequest build(Map<String, ?> map) throws Exception {
        return (CompareFaceWithMaskRequest) TeaModel.build(map, new CompareFaceWithMaskRequest());
    }

    public String getImageURLA() {
        return this.imageURLA;
    }

    public String getImageURLB() {
        return this.imageURLB;
    }

    public Float getQualityScoreThreshold() {
        return this.qualityScoreThreshold;
    }

    public CompareFaceWithMaskRequest setImageURLA(String str) {
        this.imageURLA = str;
        return this;
    }

    public CompareFaceWithMaskRequest setImageURLB(String str) {
        this.imageURLB = str;
        return this;
    }

    public CompareFaceWithMaskRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}
