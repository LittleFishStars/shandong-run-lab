package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeHandGestureAdvanceRequest extends TeaModel {

    @NameInMap("AppId")
    public String appId;

    @NameInMap("GestureType")
    public String gestureType;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    public static RecognizeHandGestureAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeHandGestureAdvanceRequest) TeaModel.build(map, new RecognizeHandGestureAdvanceRequest());
    }

    public String getAppId() {
        return this.appId;
    }

    public String getGestureType() {
        return this.gestureType;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public RecognizeHandGestureAdvanceRequest setAppId(String str) {
        this.appId = str;
        return this;
    }

    public RecognizeHandGestureAdvanceRequest setGestureType(String str) {
        this.gestureType = str;
        return this;
    }

    public RecognizeHandGestureAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }
}
