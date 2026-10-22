package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianIntrusionShrinkRequest extends TeaModel {

    @NameInMap("DetectRegion")
    public String detectRegionShrink;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("RegionType")
    public String regionType;

    public static DetectPedestrianIntrusionShrinkRequest build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianIntrusionShrinkRequest) TeaModel.build(map, new DetectPedestrianIntrusionShrinkRequest());
    }

    public String getDetectRegionShrink() {
        return this.detectRegionShrink;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getRegionType() {
        return this.regionType;
    }

    public DetectPedestrianIntrusionShrinkRequest setDetectRegionShrink(String str) {
        this.detectRegionShrink = str;
        return this;
    }

    public DetectPedestrianIntrusionShrinkRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public DetectPedestrianIntrusionShrinkRequest setRegionType(String str) {
        this.regionType = str;
        return this;
    }
}
