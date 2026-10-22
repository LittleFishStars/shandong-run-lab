package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LiquifyFaceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("SlimDegree")
    public Float slimDegree;

    public static LiquifyFaceRequest build(Map<String, ?> map) throws Exception {
        return (LiquifyFaceRequest) TeaModel.build(map, new LiquifyFaceRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Float getSlimDegree() {
        return this.slimDegree;
    }

    public LiquifyFaceRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public LiquifyFaceRequest setSlimDegree(Float f) {
        this.slimDegree = f;
        return this;
    }
}
