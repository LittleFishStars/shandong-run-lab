package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectVideoLivingFaceAdvanceRequest extends TeaModel {

    @NameInMap("VideoUrl")
    public InputStream videoUrlObject;

    public static DetectVideoLivingFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectVideoLivingFaceAdvanceRequest) TeaModel.build(map, new DetectVideoLivingFaceAdvanceRequest());
    }

    public InputStream getVideoUrlObject() {
        return this.videoUrlObject;
    }

    public DetectVideoLivingFaceAdvanceRequest setVideoUrlObject(InputStream inputStream) {
        this.videoUrlObject = inputStream;
        return this;
    }
}
