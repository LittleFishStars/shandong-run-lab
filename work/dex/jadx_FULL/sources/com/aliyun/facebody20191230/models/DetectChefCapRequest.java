package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectChefCapRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    public static DetectChefCapRequest build(Map<String, ?> map) throws Exception {
        return (DetectChefCapRequest) TeaModel.build(map, new DetectChefCapRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public DetectChefCapRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
