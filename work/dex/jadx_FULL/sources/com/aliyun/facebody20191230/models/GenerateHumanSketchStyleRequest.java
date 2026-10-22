package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanSketchStyleRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("ReturnType")
    public String returnType;

    public static GenerateHumanSketchStyleRequest build(Map<String, ?> map) throws Exception {
        return (GenerateHumanSketchStyleRequest) TeaModel.build(map, new GenerateHumanSketchStyleRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public GenerateHumanSketchStyleRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public GenerateHumanSketchStyleRequest setReturnType(String str) {
        this.returnType = str;
        return this;
    }
}
