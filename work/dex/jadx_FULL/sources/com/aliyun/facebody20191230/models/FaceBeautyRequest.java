package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceBeautyRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("Sharp")
    public Float sharp;

    @NameInMap("Smooth")
    public Float smooth;

    @NameInMap("White")
    public Float white;

    public static FaceBeautyRequest build(Map<String, ?> map) throws Exception {
        return (FaceBeautyRequest) TeaModel.build(map, new FaceBeautyRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Float getSharp() {
        return this.sharp;
    }

    public Float getSmooth() {
        return this.smooth;
    }

    public Float getWhite() {
        return this.white;
    }

    public FaceBeautyRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public FaceBeautyRequest setSharp(Float f) {
        this.sharp = f;
        return this;
    }

    public FaceBeautyRequest setSmooth(Float f) {
        this.smooth = f;
        return this;
    }

    public FaceBeautyRequest setWhite(Float f) {
        this.white = f;
        return this;
    }
}
