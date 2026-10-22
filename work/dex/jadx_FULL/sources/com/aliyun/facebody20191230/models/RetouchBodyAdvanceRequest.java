package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchBodyAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("LengthenDegree")
    public Float lengthenDegree;

    @NameInMap("SlimDegree")
    public Float slimDegree;

    public static RetouchBodyAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RetouchBodyAdvanceRequest) TeaModel.build(map, new RetouchBodyAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Float getLengthenDegree() {
        return this.lengthenDegree;
    }

    public Float getSlimDegree() {
        return this.slimDegree;
    }

    public RetouchBodyAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public RetouchBodyAdvanceRequest setLengthenDegree(Float f) {
        this.lengthenDegree = f;
        return this;
    }

    public RetouchBodyAdvanceRequest setSlimDegree(Float f) {
        this.slimDegree = f;
        return this;
    }
}
