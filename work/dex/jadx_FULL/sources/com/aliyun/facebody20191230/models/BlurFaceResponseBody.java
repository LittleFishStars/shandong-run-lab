package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BlurFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public BlurFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class BlurFaceResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("MaskURL")
        public String maskURL;

        public static BlurFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (BlurFaceResponseBodyData) TeaModel.build(map, new BlurFaceResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public String getMaskURL() {
            return this.maskURL;
        }

        public BlurFaceResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public BlurFaceResponseBodyData setMaskURL(String str) {
            this.maskURL = str;
            return this;
        }
    }

    public static BlurFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (BlurFaceResponseBody) TeaModel.build(map, new BlurFaceResponseBody());
    }

    public BlurFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public BlurFaceResponseBody setData(BlurFaceResponseBodyData blurFaceResponseBodyData) {
        this.data = blurFaceResponseBodyData;
        return this;
    }

    public BlurFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
