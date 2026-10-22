package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanAnimeStyleAdvanceRequest extends TeaModel {

    @NameInMap("AlgoType")
    public String algoType;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    public static GenerateHumanAnimeStyleAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (GenerateHumanAnimeStyleAdvanceRequest) TeaModel.build(map, new GenerateHumanAnimeStyleAdvanceRequest());
    }

    public String getAlgoType() {
        return this.algoType;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public GenerateHumanAnimeStyleAdvanceRequest setAlgoType(String str) {
        this.algoType = str;
        return this;
    }

    public GenerateHumanAnimeStyleAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }
}
