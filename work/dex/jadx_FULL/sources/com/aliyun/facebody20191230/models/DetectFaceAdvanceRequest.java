package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectFaceAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("Landmark")
    public Boolean landmark;

    @NameInMap("MaxFaceNumber")
    public Long maxFaceNumber;

    @NameInMap("Pose")
    public Boolean pose;

    @NameInMap("Quality")
    public Boolean quality;

    public static DetectFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectFaceAdvanceRequest) TeaModel.build(map, new DetectFaceAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Boolean getLandmark() {
        return this.landmark;
    }

    public Long getMaxFaceNumber() {
        return this.maxFaceNumber;
    }

    public Boolean getPose() {
        return this.pose;
    }

    public Boolean getQuality() {
        return this.quality;
    }

    public DetectFaceAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public DetectFaceAdvanceRequest setLandmark(Boolean bool) {
        this.landmark = bool;
        return this;
    }

    public DetectFaceAdvanceRequest setMaxFaceNumber(Long l) {
        this.maxFaceNumber = l;
        return this;
    }

    public DetectFaceAdvanceRequest setPose(Boolean bool) {
        this.pose = bool;
        return this;
    }

    public DetectFaceAdvanceRequest setQuality(Boolean bool) {
        this.quality = bool;
        return this;
    }
}
