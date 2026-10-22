package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchSkinRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("RetouchDegree")
    public Float retouchDegree;

    @NameInMap("WhiteningDegree")
    public Float whiteningDegree;

    public static RetouchSkinRequest build(Map<String, ?> map) throws Exception {
        return (RetouchSkinRequest) TeaModel.build(map, new RetouchSkinRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Float getRetouchDegree() {
        return this.retouchDegree;
    }

    public Float getWhiteningDegree() {
        return this.whiteningDegree;
    }

    public RetouchSkinRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public RetouchSkinRequest setRetouchDegree(Float f) {
        this.retouchDegree = f;
        return this;
    }

    public RetouchSkinRequest setWhiteningDegree(Float f) {
        this.whiteningDegree = f;
        return this;
    }
}
