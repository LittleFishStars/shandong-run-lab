package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HandPostureRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    public static HandPostureRequest build(Map<String, ?> map) throws Exception {
        return (HandPostureRequest) TeaModel.build(map, new HandPostureRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public HandPostureRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
