package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractPedestrianFeatureAttrRequest extends TeaModel {

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("Mode")
    public String mode;

    @NameInMap("ServiceVersion")
    public String serviceVersion;

    public static ExtractPedestrianFeatureAttrRequest build(Map<String, ?> map) throws Exception {
        return (ExtractPedestrianFeatureAttrRequest) TeaModel.build(map, new ExtractPedestrianFeatureAttrRequest());
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getMode() {
        return this.mode;
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public ExtractPedestrianFeatureAttrRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public ExtractPedestrianFeatureAttrRequest setMode(String str) {
        this.mode = str;
        return this;
    }

    public ExtractPedestrianFeatureAttrRequest setServiceVersion(String str) {
        this.serviceVersion = str;
        return this;
    }
}
