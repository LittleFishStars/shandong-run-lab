package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceBeautyResponseBody extends TeaModel {

    @NameInMap("Data")
    public FaceBeautyResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class FaceBeautyResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static FaceBeautyResponseBodyData build(Map<String, ?> map) throws Exception {
            return (FaceBeautyResponseBodyData) TeaModel.build(map, new FaceBeautyResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public FaceBeautyResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static FaceBeautyResponseBody build(Map<String, ?> map) throws Exception {
        return (FaceBeautyResponseBody) TeaModel.build(map, new FaceBeautyResponseBody());
    }

    public FaceBeautyResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public FaceBeautyResponseBody setData(FaceBeautyResponseBodyData faceBeautyResponseBodyData) {
        this.data = faceBeautyResponseBodyData;
        return this;
    }

    public FaceBeautyResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
