package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceTidyupRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("ShapeType")
    public Integer shapeType;

    @NameInMap("Strength")
    public Float strength;

    public static FaceTidyupRequest build(Map<String, ?> map) throws Exception {
        return (FaceTidyupRequest) TeaModel.build(map, new FaceTidyupRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Integer getShapeType() {
        return this.shapeType;
    }

    public Float getStrength() {
        return this.strength;
    }

    public FaceTidyupRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public FaceTidyupRequest setShapeType(Integer num) {
        this.shapeType = num;
        return this;
    }

    public FaceTidyupRequest setStrength(Float f) {
        this.strength = f;
        return this;
    }
}
