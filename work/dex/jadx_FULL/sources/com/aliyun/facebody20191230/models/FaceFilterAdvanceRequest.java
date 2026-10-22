package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceFilterAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("ResourceType")
    public String resourceType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceFilterAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (FaceFilterAdvanceRequest) TeaModel.build(map, new FaceFilterAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public Float getStrength() {
        return this.strength;
    }

    public FaceFilterAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public FaceFilterAdvanceRequest setResourceType(String str) {
        this.resourceType = str;
        return this;
    }

    public FaceFilterAdvanceRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
