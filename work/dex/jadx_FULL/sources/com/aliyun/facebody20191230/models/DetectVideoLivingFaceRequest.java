package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectVideoLivingFaceRequest extends TeaModel {

    @NameInMap("VideoUrl")
    public String videoUrl;

    public static DetectVideoLivingFaceRequest build(Map<String, ?> map) throws Exception {
        return (DetectVideoLivingFaceRequest) TeaModel.build(map, new DetectVideoLivingFaceRequest());
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public DetectVideoLivingFaceRequest setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
