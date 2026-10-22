package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceMakeupAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("MakeupType")
    public String makeupType;

    @NameInMap("ResourceType")
    public String resourceType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceMakeupAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (FaceMakeupAdvanceRequest) TeaModel.build(map, new FaceMakeupAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
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

    public FaceMakeupAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public FaceMakeupAdvanceRequest setMakeupType(String str) {
        this.makeupType = str;
        return this;
    }

    public FaceMakeupAdvanceRequest setResourceType(String str) {
        this.resourceType = str;
        return this;
    }

    public FaceMakeupAdvanceRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
