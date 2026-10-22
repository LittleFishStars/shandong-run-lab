package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchSkinAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("RetouchDegree")
    public Float retouchDegree;

    @NameInMap("WhiteningDegree")
    public Float whiteningDegree;

    public static RetouchSkinAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RetouchSkinAdvanceRequest) TeaModel.build(map, new RetouchSkinAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Float getRetouchDegree() {
        return this.retouchDegree;
    }

    public Float getWhiteningDegree() {
        return this.whiteningDegree;
    }

    public RetouchSkinAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public RetouchSkinAdvanceRequest setRetouchDegree(Float f) {
        this.retouchDegree = f;
        return this;
    }

    public RetouchSkinAdvanceRequest setWhiteningDegree(Float f) {
        this.whiteningDegree = f;
        return this;
    }
}
