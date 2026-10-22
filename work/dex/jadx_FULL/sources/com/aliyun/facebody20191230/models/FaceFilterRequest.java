package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceFilterRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("ResourceType")
    public String resourceType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceFilterRequest build(Map<String, ?> map) throws Exception {
        return (FaceFilterRequest) TeaModel.build(map, new FaceFilterRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public Float getStrength() {
        return this.strength;
    }

    public FaceFilterRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public FaceFilterRequest setResourceType(String str) {
        this.resourceType = str;
        return this;
    }

    public FaceFilterRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
