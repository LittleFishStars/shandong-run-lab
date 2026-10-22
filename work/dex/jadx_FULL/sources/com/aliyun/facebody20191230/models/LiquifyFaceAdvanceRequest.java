package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LiquifyFaceAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("SlimDegree")
    public Float slimDegree;

    public static LiquifyFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (LiquifyFaceAdvanceRequest) TeaModel.build(map, new LiquifyFaceAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public Float getSlimDegree() {
        return this.slimDegree;
    }

    public LiquifyFaceAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public LiquifyFaceAdvanceRequest setSlimDegree(Float f) {
        this.slimDegree = f;
        return this;
    }
}
