package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceFilterResponseBody extends TeaModel {

    @NameInMap("Data")
    public FaceFilterResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class FaceFilterResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static FaceFilterResponseBodyData build(Map<String, ?> map) throws Exception {
            return (FaceFilterResponseBodyData) TeaModel.build(map, new FaceFilterResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public FaceFilterResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static FaceFilterResponseBody build(Map<String, ?> map) throws Exception {
        return (FaceFilterResponseBody) TeaModel.build(map, new FaceFilterResponseBody());
    }

    public FaceFilterResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public FaceFilterResponseBody setData(FaceFilterResponseBodyData faceFilterResponseBodyData) {
        this.data = faceFilterResponseBodyData;
        return this;
    }

    public FaceFilterResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
