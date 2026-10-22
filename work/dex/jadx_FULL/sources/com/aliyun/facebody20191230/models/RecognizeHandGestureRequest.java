package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeHandGestureRequest extends TeaModel {

    @NameInMap("AppId")
    public String appId;

    @NameInMap("GestureType")
    public String gestureType;

    @NameInMap("ImageURL")
    public String imageURL;

    public static RecognizeHandGestureRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeHandGestureRequest) TeaModel.build(map, new RecognizeHandGestureRequest());
    }

    public String getAppId() {
        return this.appId;
    }

    public String getGestureType() {
        return this.gestureType;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public RecognizeHandGestureRequest setAppId(String str) {
        this.appId = str;
        return this;
    }

    public RecognizeHandGestureRequest setGestureType(String str) {
        this.gestureType = str;
        return this;
    }

    public RecognizeHandGestureRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }
}
