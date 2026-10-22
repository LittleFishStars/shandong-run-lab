package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectFaceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("Landmark")
    public Boolean landmark;

    @NameInMap("MaxFaceNumber")
    public Long maxFaceNumber;

    @NameInMap("Pose")
    public Boolean pose;

    @NameInMap("Quality")
    public Boolean quality;

    public static DetectFaceRequest build(Map<String, ?> map) throws Exception {
        return (DetectFaceRequest) TeaModel.build(map, new DetectFaceRequest());
    }

    public String getImageURL() {
        return this.imageURL;
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

    public DetectFaceRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public DetectFaceRequest setLandmark(Boolean bool) {
        this.landmark = bool;
        return this;
    }

    public DetectFaceRequest setMaxFaceNumber(Long l) {
        this.maxFaceNumber = l;
        return this;
    }

    public DetectFaceRequest setPose(Boolean bool) {
        this.pose = bool;
        return this;
    }

    public DetectFaceRequest setQuality(Boolean bool) {
        this.quality = bool;
        return this;
    }
}
