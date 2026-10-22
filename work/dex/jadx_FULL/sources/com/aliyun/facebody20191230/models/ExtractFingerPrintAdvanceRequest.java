package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractFingerPrintAdvanceRequest extends TeaModel {

    @NameInMap("ImageData")
    public String imageData;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    public static ExtractFingerPrintAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (ExtractFingerPrintAdvanceRequest) TeaModel.build(map, new ExtractFingerPrintAdvanceRequest());
    }

    public String getImageData() {
        return this.imageData;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public ExtractFingerPrintAdvanceRequest setImageData(String str) {
        this.imageData = str;
        return this;
    }

    public ExtractFingerPrintAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }
}
