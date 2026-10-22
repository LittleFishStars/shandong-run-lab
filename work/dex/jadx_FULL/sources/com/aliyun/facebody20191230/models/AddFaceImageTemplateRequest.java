package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceImageTemplateRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    public static AddFaceImageTemplateRequest build(Map<String, ?> map) throws Exception {
        return (AddFaceImageTemplateRequest) TeaModel.build(map, new AddFaceImageTemplateRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public AddFaceImageTemplateRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
