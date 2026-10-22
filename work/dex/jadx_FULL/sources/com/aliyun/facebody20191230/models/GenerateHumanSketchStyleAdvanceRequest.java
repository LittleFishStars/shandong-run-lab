package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanSketchStyleAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("ReturnType")
    public String returnType;

    public static GenerateHumanSketchStyleAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (GenerateHumanSketchStyleAdvanceRequest) TeaModel.build(map, new GenerateHumanSketchStyleAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public GenerateHumanSketchStyleAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public GenerateHumanSketchStyleAdvanceRequest setReturnType(String str) {
        this.returnType = str;
        return this;
    }
}
