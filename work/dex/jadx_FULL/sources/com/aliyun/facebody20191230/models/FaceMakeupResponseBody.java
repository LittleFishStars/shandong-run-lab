package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceMakeupResponseBody extends TeaModel {

    @NameInMap("Data")
    public FaceMakeupResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class FaceMakeupResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static FaceMakeupResponseBodyData build(Map<String, ?> map) throws Exception {
            return (FaceMakeupResponseBodyData) TeaModel.build(map, new FaceMakeupResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public FaceMakeupResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static FaceMakeupResponseBody build(Map<String, ?> map) throws Exception {
        return (FaceMakeupResponseBody) TeaModel.build(map, new FaceMakeupResponseBody());
    }

    public FaceMakeupResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public FaceMakeupResponseBody setData(FaceMakeupResponseBodyData faceMakeupResponseBodyData) {
        this.data = faceMakeupResponseBodyData;
        return this;
    }

    public FaceMakeupResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
