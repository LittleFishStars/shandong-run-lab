package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceRequest extends TeaModel {

    @NameInMap("ImageDataA")
    public String imageDataA;

    @NameInMap("ImageDataB")
    public String imageDataB;

    @NameInMap("ImageURLA")
    public String imageURLA;

    @NameInMap("ImageURLB")
    public String imageURLB;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static CompareFaceRequest build(Map<String, ?> map) throws Exception {
        return (CompareFaceRequest) TeaModel.build(map, new CompareFaceRequest());
    }

    public String getImageDataA() {
        return this.imageDataA;
    }

    public String getImageDataB() {
        return this.imageDataB;
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

    public CompareFaceRequest setImageDataA(String str) {
        this.imageDataA = str;
        return this;
    }

    public CompareFaceRequest setImageDataB(String str) {
        this.imageDataB = str;
        return this;
    }

    public CompareFaceRequest setImageURLA(String str) {
        this.imageURLA = str;
        return this;
    }

    public CompareFaceRequest setImageURLB(String str) {
        this.imageURLB = str;
        return this;
    }

    public CompareFaceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}
