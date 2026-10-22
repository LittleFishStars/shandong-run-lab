package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceMakeupRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("MakeupType")
    public String makeupType;

    @NameInMap("ResourceType")
    public String resourceType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceMakeupRequest build(Map<String, ?> map) throws Exception {
        return (FaceMakeupRequest) TeaModel.build(map, new FaceMakeupRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getMakeupType() {
        return this.makeupType;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public Float getStrength() {
        return this.strength;
    }

    public FaceMakeupRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public FaceMakeupRequest setMakeupType(String str) {
        this.makeupType = str;
        return this;
    }

    public FaceMakeupRequest setResourceType(String str) {
        this.resourceType = str;
        return this;
    }

    public FaceMakeupRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
