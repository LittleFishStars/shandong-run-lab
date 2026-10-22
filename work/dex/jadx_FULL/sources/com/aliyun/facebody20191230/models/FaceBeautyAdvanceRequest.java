package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceBeautyAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("Sharp")
    public Float sharp;

    @NameInMap("Smooth")
    public Float smooth;

    @NameInMap("White")
    public Float white;

    public static FaceBeautyAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (FaceBeautyAdvanceRequest) TeaModel.build(map, new FaceBeautyAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
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

    public FaceBeautyAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public FaceBeautyAdvanceRequest setSharp(Float f) {
        this.sharp = f;
        return this;
    }

    public FaceBeautyAdvanceRequest setSmooth(Float f) {
        this.smooth = f;
        return this;
    }

    public FaceBeautyAdvanceRequest setWhite(Float f) {
        this.white = f;
        return this;
    }
}
