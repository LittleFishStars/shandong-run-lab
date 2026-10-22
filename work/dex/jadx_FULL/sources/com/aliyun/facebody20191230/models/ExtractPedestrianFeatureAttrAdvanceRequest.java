package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractPedestrianFeatureAttrAdvanceRequest extends TeaModel {

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("Mode")
    public String mode;

    @NameInMap("ServiceVersion")
    public String serviceVersion;

    public static ExtractPedestrianFeatureAttrAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (ExtractPedestrianFeatureAttrAdvanceRequest) TeaModel.build(map, new ExtractPedestrianFeatureAttrAdvanceRequest());
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public String getMode() {
        return this.mode;
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public ExtractPedestrianFeatureAttrAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public ExtractPedestrianFeatureAttrAdvanceRequest setMode(String str) {
        this.mode = str;
        return this;
    }

    public ExtractPedestrianFeatureAttrAdvanceRequest setServiceVersion(String str) {
        this.serviceVersion = str;
        return this;
    }
}
