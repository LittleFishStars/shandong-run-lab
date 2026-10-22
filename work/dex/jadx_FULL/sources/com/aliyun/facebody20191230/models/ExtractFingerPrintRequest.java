package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractFingerPrintRequest extends TeaModel {

    @NameInMap("ImageData")
    public String imageData;

    @NameInMap("ImageURL")
    public String imageURL;

    public static ExtractFingerPrintRequest build(Map<String, ?> map) throws Exception {
        return (ExtractFingerPrintRequest) TeaModel.build(map, new ExtractFingerPrintRequest());
    }

    public String getImageData() {
        return this.imageData;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public ExtractFingerPrintRequest setImageData(String str) {
        this.imageData = str;
        return this;
    }

    public ExtractFingerPrintRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
