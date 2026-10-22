package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeFaceRequest extends TeaModel {

    @NameInMap(b.X)
    public Boolean age;

    @NameInMap("Beauty")
    public Boolean beauty;

    @NameInMap("Expression")
    public Boolean expression;

    @NameInMap("Gender")
    public Boolean gender;

    @NameInMap("Glass")
    public Boolean glass;

    @NameInMap("Hat")
    public Boolean hat;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("Mask")
    public Boolean mask;

    @NameInMap("MaxFaceNumber")
    public Long maxFaceNumber;

    @NameInMap("Quality")
    public Boolean quality;

    public static RecognizeFaceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeFaceRequest) TeaModel.build(map, new RecognizeFaceRequest());
    }

    public Boolean getAge() {
        return this.age;
    }

    public Boolean getBeauty() {
        return this.beauty;
    }

    public Boolean getExpression() {
        return this.expression;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public Boolean getGlass() {
        return this.glass;
    }

    public Boolean getHat() {
        return this.hat;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Boolean getMask() {
        return this.mask;
    }

    public Long getMaxFaceNumber() {
        return this.maxFaceNumber;
    }

    public Boolean getQuality() {
        return this.quality;
    }

    public RecognizeFaceRequest setAge(Boolean bool) {
        this.age = bool;
        return this;
    }

    public RecognizeFaceRequest setBeauty(Boolean bool) {
        this.beauty = bool;
        return this;
    }

    public RecognizeFaceRequest setExpression(Boolean bool) {
        this.expression = bool;
        return this;
    }

    public RecognizeFaceRequest setGender(Boolean bool) {
        this.gender = bool;
        return this;
    }

    public RecognizeFaceRequest setGlass(Boolean bool) {
        this.glass = bool;
        return this;
    }

    public RecognizeFaceRequest setHat(Boolean bool) {
        this.hat = bool;
        return this;
    }

    public RecognizeFaceRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public RecognizeFaceRequest setMask(Boolean bool) {
        this.mask = bool;
        return this;
    }

    public RecognizeFaceRequest setMaxFaceNumber(Long l) {
        this.maxFaceNumber = l;
        return this;
    }

    public RecognizeFaceRequest setQuality(Boolean bool) {
        this.quality = bool;
        return this;
    }
}
