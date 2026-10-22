package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanAnimeStyleRequest extends TeaModel {

    @NameInMap("AlgoType")
    public String algoType;

    @NameInMap("ImageURL")
    public String imageURL;

    public static GenerateHumanAnimeStyleRequest build(Map<String, ?> map) throws Exception {
        return (GenerateHumanAnimeStyleRequest) TeaModel.build(map, new GenerateHumanAnimeStyleRequest());
    }

    public String getAlgoType() {
        return this.algoType;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public GenerateHumanAnimeStyleRequest setAlgoType(String str) {
        this.algoType = str;
        return this;
    }

    public GenerateHumanAnimeStyleRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
