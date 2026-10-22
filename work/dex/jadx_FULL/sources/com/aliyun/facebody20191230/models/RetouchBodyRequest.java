package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchBodyRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("LengthenDegree")
    public Float lengthenDegree;

    @NameInMap("SlimDegree")
    public Float slimDegree;

    public static RetouchBodyRequest build(Map<String, ?> map) throws Exception {
        return (RetouchBodyRequest) TeaModel.build(map, new RetouchBodyRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Float getLengthenDegree() {
        return this.lengthenDegree;
    }

    public Float getSlimDegree() {
        return this.slimDegree;
    }

    public RetouchBodyRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public RetouchBodyRequest setLengthenDegree(Float f) {
        this.lengthenDegree = f;
        return this;
    }

    public RetouchBodyRequest setSlimDegree(Float f) {
        this.slimDegree = f;
        return this;
    }
}
