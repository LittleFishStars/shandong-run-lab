package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeFaceAdvanceRequest extends TeaModel {

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
    public InputStream imageURLObject;

    @NameInMap("Mask")
    public Boolean mask;

    @NameInMap("MaxFaceNumber")
    public Long maxFaceNumber;

    @NameInMap("Quality")
    public Boolean quality;

    public static RecognizeFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeFaceAdvanceRequest) TeaModel.build(map, new RecognizeFaceAdvanceRequest());
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

    public InputStream getImageURLObject() {
        return this.imageURLObject;
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

    public RecognizeFaceAdvanceRequest setAge(Boolean bool) {
        this.age = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setBeauty(Boolean bool) {
        this.beauty = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setExpression(Boolean bool) {
        this.expression = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setGender(Boolean bool) {
        this.gender = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setGlass(Boolean bool) {
        this.glass = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setHat(Boolean bool) {
        this.hat = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public RecognizeFaceAdvanceRequest setMask(Boolean bool) {
        this.mask = bool;
        return this;
    }

    public RecognizeFaceAdvanceRequest setMaxFaceNumber(Long l) {
        this.maxFaceNumber = l;
        return this;
    }

    public RecognizeFaceAdvanceRequest setQuality(Boolean bool) {
        this.quality = bool;
        return this;
    }
}
