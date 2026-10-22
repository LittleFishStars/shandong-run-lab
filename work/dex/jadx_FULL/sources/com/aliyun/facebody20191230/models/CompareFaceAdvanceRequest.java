package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceAdvanceRequest extends TeaModel {

    @NameInMap("ImageDataA")
    public String imageDataA;

    @NameInMap("ImageDataB")
    public String imageDataB;

    @NameInMap("ImageURLA")
    public InputStream imageURLAObject;

    @NameInMap("ImageURLB")
    public InputStream imageURLBObject;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static CompareFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (CompareFaceAdvanceRequest) TeaModel.build(map, new CompareFaceAdvanceRequest());
    }

    public String getImageDataA() {
        return this.imageDataA;
    }

    public String getImageDataB() {
        return this.imageDataB;
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

    public CompareFaceAdvanceRequest setImageDataA(String str) {
        this.imageDataA = str;
        return this;
    }

    public CompareFaceAdvanceRequest setImageDataB(String str) {
        this.imageDataB = str;
        return this;
    }

    public CompareFaceAdvanceRequest setImageURLAObject(InputStream inputStream) {
        this.imageURLAObject = inputStream;
        return this;
    }

    public CompareFaceAdvanceRequest setImageURLBObject(InputStream inputStream) {
        this.imageURLBObject = inputStream;
        return this;
    }

    public CompareFaceAdvanceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}
