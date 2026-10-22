package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceTidyupAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("ShapeType")
    public Integer shapeType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceTidyupAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (FaceTidyupAdvanceRequest) TeaModel.build(map, new FaceTidyupAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Integer getShapeType() {
        return this.shapeType;
    }

    public Float getStrength() {
        return this.strength;
    }

    public FaceTidyupAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public FaceTidyupAdvanceRequest setShapeType(Integer num) {
        this.shapeType = num;
        return this;
    }

    public FaceTidyupAdvanceRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
